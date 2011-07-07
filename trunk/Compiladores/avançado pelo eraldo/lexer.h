#include <stdio.h>

#define MAXSTRLEN	256

typedef long token_t;

extern char lexeme[];

extern token_t lookahead;

token_t gettoken(FILE *);

void match(token_t);


