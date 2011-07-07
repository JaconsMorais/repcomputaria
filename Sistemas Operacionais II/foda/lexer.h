

        1 typedef int token_t; //aqui serão definidos os tokens ou rótulos, pois para cada lexema será atribuido um token

        2 

        3 enum {

        4 	T_SPACE = ' ', //Caractere especial de espaço

        5 	T_PIPE = '|',  

        6 	T_OUTPUT = '>',

        7 	T_INPUT = '<',

        8 	T_EOL = '\n' , //Caractere especial de final de linha

        9 	T_ARGUMENT = 256, //Argumento

       10      };

       11 

       12 char lexeme[1024]; //guardara a linha de comando digitada

       13 token_t lookahead; //receberá o proximo token

       14 int ilexeme; //indice do vetor lexeme

       15 extern token_t Get_Token(void); //função que pega o proximo token de entrada

       16 extern void match(token_t expected); //verifica se o token esperado é o token que chega e retorna erro caso nao seja

       17 

       18 


