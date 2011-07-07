#include <stdio.h>
#include <stdlib.h>
#include "parser.h"

/*v�riavel para ler os tokens*/
extern token_t lookahead;

/*c�digo Pascal*/
FILE *sourcecode;

/*simpasboot - l� os tokens do arquivo recebido*/
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
