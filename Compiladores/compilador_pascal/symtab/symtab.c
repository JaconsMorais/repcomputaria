#include <string.h>

/*pr�xima posi��o a ser inserida na tabela*/
int symtab_nextentry = 0;

#include "symtab.h"

/*tabela de s�mbolos*/
SYMBOL symtab[MAXSYMTABENTRIES];

/*symtab_lookup - acha a posi��o do s�mbolo na tabela*/
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

/*symtab_add - insere um s�mbolo na tabela de s�mbolos*/
int
symtab_add (char const *symbol)
{
  if (symtab_nextentry == MAXSYMTABENTRIES)
    return -1;
  strcpy (symtab[symtab_nextentry++].lexeme, symbol);
  return 0;
}

/*symtab_verify - verifica se a vari�vel foi declarada*/
int
symtab_verify(char const *symbol)
{

int position = symtab_lookup(symbol);

	if (symtab[symtab_nextentry-1].valtype==1)
	{
		//printf( "vari�vel declarada");
	}else
	{ 
		printf (" ATENCAO!, VARIAVEL %s ,NAO DECLARADA\n",symbol);
       	// exit(getch());
	}
}
