#ifndef LEXER_H
#define LEXER_H

enum {
   T_PIPE = '|',
   T_OUTPUT = '>',
   T_EOL = '\n',
   T_ARGUMENT = 0xFF01
};

typedef int token_t;

#define MAX_ARG_SIZE 4096

extern char argument[MAX_ARG_SIZE];
extern token_t lookahead;

token_t get_token(void);
void match(token_t token);

#endif
