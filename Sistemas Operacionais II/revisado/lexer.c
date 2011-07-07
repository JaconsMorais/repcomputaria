#include "lexer.h"

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <ctype.h>

token_t lookahead;

char lexeme[MAX_ARG_SIZE];

static bool isargchar(int ch) //"reconhece" a variável char
{
	return ch != EOF
		&& !isspace(ch)
		&& ch != '>'
		&& ch != '<'
		&& ch != '|';
}

token_t gettoken(void) //pega o token
{

	int ch = fgetc(stdin);

	while(true){
		if(ch == EOF) return EOF;
		else if(ch == '\n') return T_EOL;
		else if(isspace(ch)) continue;
		else if(ch == '>') return T_OUTPUT;
		else if(ch == '<') return T_INPUT;
		else if(ch == '|') return T_PIPE;
		else{
			int i = 0;
			do{
				lexeme[i++] = ch;
			}while(ch = fgetc(stdin),isargchar(ch));
			lexeme[i] = 0;
			ungetc(ch, stdin);
			return T_ARGUMENT;
		}
	}

}

token_t match(token_t expected) //verifica se o token está correto
{
	if(lookahead != expected){
		fprintf(stderr, "Esperado '%c' (%d), obtido '%c' (%d)\n", expected, expected, lookahead, lookahead);
		exit(1);
	}

	lookahead = gettoken();

	return expected;
}
