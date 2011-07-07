#include <stdio.h>
#include <string.h>
#include "global.h"

/*--------------------------------VARIAVEIS------------------------------------------*/

//typedef char palavras[12];

char lexstream[10000];

/*	LASTENTRY	- VARIAVEL QUE CONTEM A POSICAO DA ULTIMA ENTRADA NA TABELA DE SIMBOLOS
	NEXTENTRY	- VARIAVEL QUE CONTEM A POSICAO DA PROXIMA ENTRADA NA TABELA DE SIMBOLOS
	LEXENTRY	- IMAGINE QUE OS LEXEMAS SEJAM ARMAZENADOS EM UMA ESPECIE DE FITA	.
			  LEXENTRY CONTEM A POSICAO NA FITA ONDE O LEXEMA LIDO SERA INSERIDO.
			  QDO O LEXEMA E INSERIDO LEXENTRY E INCREMENTADO COM O TAMANHO DO
			  ULTIMO LEXEMA MAIS 1. 	*/


int nextentry, lexentry,lastentry;


/*---------------------------- ESTRUTURA DA TABELA DE SIMBOLOS ------------------------*/

typedef struct
{
  int lex;	   		// PONTEIRO PARA O VETOR DE LEXEMAS
  TOKENTYPE tolken;	// ARMAZENA O TOKEN
  int dec;			// ARMAZENA 1 SE A VARIAVEL FOI DECLARADA 0 CASO CONTRARIO.
} tipo_tab_simbolo;

tipo_tab_simbolo symboltable[MAXENTRIES];


/*----------------------------- INSERE SIMBOLO NA TABELA DE SIMBOLOS-------------------- */

int insert (const char *symbol, int token){
  int pos;
  pos = lookup (symbol);
  if (pos == -1){
	symboltable[nextentry].lex = lexentry;
      symboltable[nextentry].tolken = token;
      strcpy (lexstream + lexentry, symbol);
      lexentry += strlen (symbol) + 1;
	lastentry = nextentry;
      nextentry++;
      return token;
  }
  return symboltable[pos].tolken;
} 


/*----- RETORNA A POSICAO DE UM SIMBOLO NA TABELA DE SIMBOLOS CASO ESTE ESTEJA NA TABELA---*/

int lookup (const char *symbol){
  int i;
  for (i = 0; i < nextentry; i++){
      if (strcmp (symbol, lexstream + symboltable[i].lex) == 0)
      return (i);
  }
  return (-1);
};


/*---------------------------- IDENTIFICADORES DECLARADOS------------------------------*/

/* 	COLOCA 1 NO CAMPO DEC DO ULTIMO ID RECONHECIDO( A POSICAO DESTE ESTA EM LASTENTRY)
	SINALIZANDO QUE O IDENTIFICADOR FOI DECLARADO COMO VARIAVEL  */

void declara ( ){
	
	symboltable[lastentry].dec = 1;

}

/*---------------------------- VERIFICA SE ID FOI DECLARADO------------------------*/

/* VERIFICA SE UM IDENTIFICADOR FOI DECLARADO COMO VARIAVEL. CASO NÃO TENHA SIDO
   SINALIZA PARA O USUARIO O ID QUE NAO FOI DECLARADO */

void verifica (const char *symbol){
	int pos;
	pos=lookup(symbol);
	
	if (symboltable[pos].dec==1)
	{
		//printf( " declarada");
	}else
	{ 
		printf (" AVISO!, A VARIAVEL %s ,NAO FOI DECLARADA\n",symbol);
       	// exit(getch());
	}
}
