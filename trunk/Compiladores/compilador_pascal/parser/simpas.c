#include <stdio.h>
#include <stdlib.h>
#include "parser.h"

/*váriavel para ler os tokens*/
extern token_t lookahead;

/*código Pascal*/
FILE *sourcecode;

/*simpasboot - lê os tokens do arquivo recebido*/
void
simpasboot (void)
{
  sourcecode = stdin;
  lookahead = gettoken (sourcecode);
}

/*main - faz a leitura dos tokens e, em seguida, verifica a sintaxe*/
main (int argc, char *argv[])
{
  simpasboot ();
  prog ();
  return 0;
}
