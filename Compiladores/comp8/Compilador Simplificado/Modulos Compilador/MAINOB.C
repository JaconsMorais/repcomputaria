//---------------------------------MAIN.C-----------------------------------------------


/* UNESP RIO CLARO - DEMAC
 * Janeiro 2005
 *
 * Disciplina: Compiladores
 * Prof. Dr.: Eraldo P.Marinho
 * Alunos : Caio Nunes
 *	    	Willian Makarenko
 *
 * COMPILADOR DE UM PROGRAMA PASCAL IMPLEMENTADO EM C 
 * PASSA O CODIGO FONTE PARA CODIGO OBJETO(ASSEMBLY)
*/

/* ARQUIVOS UTILIZADOS

		PARSEROB.C    - ANALISADOR SINTATICO
		LEXEROB.C     - ANALISADOR LEXICO
		GLOBAL.H      - CONTEM OS TOKENS RESERVADOS UTILIZADOS NOS
				    DEMAIS ARQUIVO E AS VARIAVEIS GLOBAIS 
		SIMBOLO.C	  - TABELA DE SIMBOLOS
		ENTRADA.PAS   - ARQUIVO FONTE QUE CONTEM O PROGRAMA A SER
				    COMPILADO
		OBJETO.S      - ARQUIVO QUE CONTEM O CODIGO OBJETO.

OBSERVACAO: ESSE COMPILADOR FOI IMPLEMENTADO EM AMBIENTE WINDOWS, UTILIZANDO O
	    COMPILADOR LCC-WIN32. POR NAO ESTAR FAMILIARIZADO
	    COM O AMBIENTE LINUX.
*/

//--------------------------------PROGRAMA PRINCIPAL----------------------------------

#include <stdio.h>
#include <string.h>
#include "parserob.c"

void main(void)
{
//clrscr();
/* PALAVRAS RESERVADAS DO PASCAL ARMAZENADAS
   NA TABELA DE SIMBOLOS DECLARADA EM LEXEROB.C
*/

/* INCIALIZACAO DA TABELA DE SIMBOLOS*/


  insert ("of", OF);
  insert ("var", VAR);
  insert ("procedure", PROCEDURE);
  insert ("function", FUNCTION);
  insert ("begin", BEGIN);
  insert ("end", END);
  insert ("if", IF);
  insert ("then", THEN);
  insert ("else", ELSE);
  insert ("while", WHILE);
  insert ("do", DO);
  insert ("for", FOR);
  insert ("to", TO);
  insert ("repeat", REPEAT);
  insert ("until", UNTIL);
  insert ("or", OR);
  insert ("and", AND);
  insert ("not", NOT);
  insert ("div", DIV);
  //insert ("mod", MOD);
  insert ("program", PROGRAM);
  insert ("integer", INTEGER);
  //insert ("real", REAL);
  insert ("boolean", BOOLEAN);
  insert ("read", READ);
  insert ("write", WRITE);
  insert ("case", CASE);	


/* arq_entrada  - CONTEM O ARQUIVO ENTRADA.PAS O QUAL SERA COMPILADO
   arq_objeto   - CONTEM O CODIGO OBJETO OBJETO.S QUE E GERADAO A PARTIR DO
		      ARQUIVO ENTRADA.PAS 
*/


arq_entrada = fopen("entrada.pas","r");
arq_objeto  = fopen("objeto.s","w+");

/* INICIA O PARSEROB*/

	lookahead = gettoken();
	programa ();


	fcloseall ();

	printf(" \n\n ARQUIVO ENTRADA.PAS COMPILADO!\n");
	printf(" CODIGO OBJETO ARMAZENADO EM OBJETO.S ");
	getch();

};/* main(); */
