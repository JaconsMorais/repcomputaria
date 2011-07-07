#include "tokens.h"

/*variáveis necessárias para a leitura do arquivo Pascal,através
*de tokens e lexemas*/
extern size_t linecount;
extern char lexeme[];
extern token_t lookahead;

/*métodos*/
token_t isidentifier (FILE * tape);
token_t isassgnmt (FILE * tape);
token_t isrange (FILE * tape);
token_t iscte (FILE * tape);
token_t isaddop (FILE * tape);
token_t ismulop (FILE * tape);
token_t isrelop (FILE * tape);


void skipall (FILE * tape);
token_t gettoken (FILE * buffer);
void match (token_t needed);
