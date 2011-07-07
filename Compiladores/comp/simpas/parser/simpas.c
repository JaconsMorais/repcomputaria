#include <stdio.h>
#include <stdlib.h>
#include <parser.h>

extern token_t lookahead;

FILE *sourcecode;

void
simpasboot (void)
{
  sourcecode = stdin;
  lookahead = gettoken (sourcecode);
}

main (int argc, char *argv[])
{
  simpasboot ();
  prog ();
  return 0;
}
