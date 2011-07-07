#include <string.h>

/*próxima posição a ser inserida na tabela*/
int symtab_nextentry = 0;

#include "symtab.h"

/*tabela de símbolos*/
SYMBOL symtab[MAXSYMTABENTRIES];

/*symtab_lookup - acha a posição do símbolo na tabela*/
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

/*symtab_add - insere um símbolo na tabela de símbolos*/
int
symtab_add (char const *symbol)
{
  if (symtab_nextentry == MAXSYMTABENTRIES)
    return -1;
  strcpy (symtab[symtab_nextentry++].lexeme, symbol);
  return 0;
}

/*symtab_verify - verifica se a variável foi declarada*/
int
symtab_verify(char const *symbol)
{

int position = symtab_lookup(symbol);

	if (symtab[symtab_nextentry-1].valtype==1)
	{
		//printf( "variável declarada");
	}else
	{ 
		printf (" ATENCAO!, VARIAVEL %s ,NAO DECLARADA\n",symbol);
       	// exit(getch());
	}
}
