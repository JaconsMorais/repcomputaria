#include "lexer.c"
#include "parser.c"
#include <stdio.h>

int main(int argc, char **argv)
{
	while(true){
                printf("shell@%s$",func_pwd()); //informa a pasta para o usuário se localizar
		token_t t = gettoken();
		statement(argc,argv); //começa o parser
	}
}
