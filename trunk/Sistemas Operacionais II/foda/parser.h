

        1 #define NUMERO_ARGS 128

        2 

        3 

        4 typedef struct Estrutura { //estrutura de um comando do shell

        5 	int argc;

        6 	char *argv[NUMERO_ARGS];

        7 	char *arquivoEntrada;

        8 	char *arquivoSaida;

        9 } COMANDO;

       10 

       11 COMANDO vetorComandos[1024]; //guarda todos os comandos presentes no shell

       12 void Inicializar(void);


