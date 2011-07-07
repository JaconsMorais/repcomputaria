

        1 #include <stdio.h>

        2 #include <stdlib.h>

        3 #include <stdbool.h>

        4 #include <string.h>

        5 #include <unistd.h>

        6 #include <sys/wait.h>

        7 #include <sys/stat.h>

        8 #include <sys/types.h>

        9 #include <fcntl.h>

       10 

       11 #include "lexer.h"

       12 #include "parser.h"

       13 

       14 int contador = 0;

       15 int file_f;

       16 

       17 void Executa_Comando(int argc, char **argv);

       18 

       19 	

       20 void Command(void)

       21 {

       22         vetorComandos[contador].argv[vetorComandos[contador].argc++] = strdup(lexeme);

       23 	match(T_ARGUMENT);

       24 	while (lookahead == T_SPACE) match(T_SPACE); //pula os espaços

       25 	while (lookahead == T_ARGUMENT)

       26 	{

       27 			vetorComandos[contador].argv[vetorComandos[contador].argc++] = strdup(lexeme);

       28 		        match(T_ARGUMENT);

       29 			while (lookahead == T_SPACE) match(T_SPACE);

       30 	}

       31 		

       32 }	

       33 

       34 void Pipeline(void)

       35 {

       36 	Command();

       37 	switch (lookahead) 

       38 	{

       39 		case T_PIPE: 

       40 		{

       41 			contador++; //incrementa contador de comandos

       42                         vetorComandos[contador].argc = 0;

       43 			match(T_PIPE);

       44 			while (lookahead == T_SPACE) match (T_SPACE);

       45 			Pipeline();

       46 			break;

       47 		}

       48 		case T_INPUT:

       49 		{

       50 			match(T_INPUT);

       51                         while (lookahead == T_SPACE) match(T_SPACE);

       52                         match(lookahead);

       53 			vetorComandos[contador].arquivoEntrada = strdup(lexeme);

       54 			file_f = open(vetorComandos[0].arquivoEntrada, O_RDWR | O_CREAT, 0751);

       55 			break;

       56 		}

       57 		case T_OUTPUT:

       58 		{

       59 			match(T_OUTPUT);

       60 			while (lookahead == T_SPACE) match(T_SPACE);

       61 			match(lookahead);

       62                         vetorComandos[contador].arquivoSaida = strdup(lexeme);

       63 			file_f = open(vetorComandos[0].arquivoSaida, O_WRONLY | O_CREAT, 0666);

       64 			break;

       65 		}	

       66 				       

       67 	}	

       68 }	

       69 

       70 void Statement(void)

       71 {

       72 	while (lookahead == T_SPACE) match(T_SPACE); //pula os espaços

       73 	Pipeline();

       74 	if (contador > 0) {

       75 	  	

       76 	}	

       77 	else //significa que não há pipes

       78 	{// Executa comando sem pipeline (teste)

       79 	  Executa_Comando(vetorComandos[0].argc, vetorComandos[0].argv);

       80 	}

       81 

       82 	while (lookahead == T_SPACE) match(T_SPACE); //pula os espaços

       83 	

       84 	if (lookahead == T_EOL)

       85 	{

       86 		printf("Statement aceito com sucesso\n"); //para testes

       87 	}

       88 	match(T_EOL);	

       89 }	

       90 

       91 void Inicializar(void) { //Envia pro lookahead o primeiro token para que a analise possa ser realizada

       92  lookahead = Get_Token();

       93  Statement();

       94 }

       95 

       96 void Executa_Comando(int argc, char **argv){

       97        

       98        if (strcmp(argv[0], "pwd") == 0) { //comando pwd

       99                  printf("Passou por aqui/n");                 

      100                  char acumulador[1024];

      101 		 getcwd(acumulador, sizeof acumulador);

      102 		 printf("%s\n", acumulador);

      103 		}

      104        else if (strcmp(argv[0], "cd") == 0) { //comando cd

      105              if (argc == 2) {

      106                                chdir(argv[1]);

      107                                printf("%s", argv[1]);

      108                                } //só muda se houver um argumento	

      109              }

      110        else if (strcmp(argv[0], "exit") == 0) { // comando exit

      111         exit(0);

      112              }

      113 

      114        else {	//caso contrario deve chamar a execução

      115              int res, pid = fork();

      116               if (pid < 0) {

      117 		            printf("Erro!");

      118  		            exit(-1);

      119 		           }

      120 	      else if (pid > 0) {

      121 		            wait(&res);

      122 		             }

      123 	      else {

      124                    if (vetorComandos[0].arquivoEntrada != NULL && strcmp(vetorComandos[0].arquivoEntrada, "") != 0) { //Se foi direcionado um arquivo

      125 		 close(0);

      126 	         dup2(file_f,0);

      127 	         close(file_f);	      

      128 	          }                                        

      129 	          if (vetorComandos[0].arquivoSaida != NULL && strcmp(vetorComandos[0].arquivoSaida, "") != 0) { //Se foi direcionado para algum arqu       

      130 		    close(1);

      131 		    dup2(file_f,1);

      132 		    close(file_f);

      133 	            }  

      134                  execvp(argv[0], argv);

      135 	      }

      136             }

      137 } 


