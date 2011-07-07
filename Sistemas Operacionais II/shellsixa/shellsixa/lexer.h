#ifndef LEXER_H
#define LEXER_H

typedef int token_t;

enum{
	T_EOL = '\n',
	T_INPUT = '<',
	T_OUTPUT = '>',
	T_PIPE = '|',
	T_ARGUMENT = 0xFF01
};

#define MAX_ARG_SIZE 4096
extern char lexeme[MAX_ARG_SIZE];

extern token_t lookahead;

token_t gettoken(void);
token_t match(token_t token);

#endif
