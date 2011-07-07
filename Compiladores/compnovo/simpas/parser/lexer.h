#include "tokens.h"

/*vari�veis necess�rias para a leitura do arquivo Pascal,atrav�s
*de tokens e lexemas*/
extern size_t linecount;
extern char lexeme[];
extern token_t lookahead;

/*m�todos*/
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
