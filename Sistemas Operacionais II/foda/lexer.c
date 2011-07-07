

        1 #include <stdio.h>

        2 #include <stdlib.h>

        3 #include <stdbool.h>

        4 #include <string.h>

        5 

        6 #include "lexer.h" //Cabeçalho que contem os tokens

        7 

        8 bool Is_Special_Character(int c) //Função que verifica se trata-se de um caractere especial

        9 {

       10   return (   c == T_SPACE

       11 	  || c == T_INPUT

       12           || c == T_OUTPUT

       13           || c == T_PIPE 

       14 	  || c == T_EOL ); // retornara true se for um caractere especial	  

       15 }	

       16 

       17 token_t Get_Token() //Função que retorna o token

       18 {

       19   int c;

       20   if (Is_Special_Character(c = getc(stdin))) //verifica se é um caractere especial

       21   {

       22   lexeme[ilexeme] = c;

       23   ilexeme++; //incrementa o indice do lexema (variavel global)

       24   return c;

       25   }

       26   else

       27   {

       28  

       29     ungetc(c, stdin); //Devolve caractere

       30     while (!Is_Special_Character(lexeme[ilexeme] = getc(stdin))) ilexeme++; //Ficaguardado emlexem ate achar caractereespecial 	  

       31     ungetc(lexeme[ilexeme], stdin);

       32     lexeme[ilexeme] = 0; 

       33     return T_ARGUMENT;    

       34   }	      

       35 }	

       36 

       37 void  match(token_t expected) //Função que verifica se o proximo token é o token esperado

       38 {

       39 	if (lookahead == expected)

       40 	{ 

       41 	if (lookahead != T_EOL) lookahead = Get_Token(); //Caso contratio nao é necessario pegar o proximo token

       42 	}

       43 	else {

       44               printf("Error: TOKEN MISMATCH\n");

       45               exit (-1);

       46              }

       47 }

       48 	


