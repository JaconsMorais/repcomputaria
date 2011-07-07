#include <string.h>

int symtab_nextentry = 0;

#include "symtab.h"

SYMBOL symtab[MAXSYMTABENTRIES];

int
symtab_lookup (char const *symbol)
{
  int i;
  for (i = symtab_nextentry - 1; i > -1; i--)
    {
      if (strcmp (symtab[i].lexeme, symbol) == 0)
	return i;
    }
  return -1;
}

int
symtab_add (char const *symbol)
{
  if (symtab_nextentry == MAXSYMTABENTRIES)
    return -1;
  strcpy (symtab[symtab_nextentry++].lexeme, symbol);
  return 0;
}

int
symtab_verify(char const *symbol)
{

int position = symtab_lookup(symbol);

	if (symtab[symtab_nextentry].lexlvl==1)
	{
		//printf( "variável declarada");
	}else
	{ 
		printf (" ATENCAO!, VARIAVEL %s ,NAO DECLARADA\n",symbol);
       	// exit(getch());
	}
}
