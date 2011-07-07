/*
 * Projeto SimPas -- Compiladores
 *
 * Autores:
 *         Fernando Narciso Prado - RA 208000619
 *         Thales Eduardo Nazatto - RA 208000729
 *
 * Autor Original: Professor Dr Eraldo P Marinho
 */
 
#include <stdio.h>
#include <stdlib.h>

/*verifica��o de erros no c�digo*/
void
reterror(void)
{
  fprintf (stderr, "Erro!\n");
  exit (-1);
}
#include "lexer.h"
#include "parser.h"

/* 
 * start symbol: prog
 *
 * eBNF grammar:
 *
 * prog -> header declscope procscope '.'
 */
void
prog (void)
{
  header ();
  declscope ();
  
  /*gera��o do c�digo de in�cio*/
  {printf("\n.section .text \n\n");
  printf("\t .global _start \n");
  printf("_start: \n");}
  
  procscope ();
  match ('.');
  
  /*gera��o do c�digo final*/
  {printf("_end: \n");
  printf("\t movl $1, %%eax\n");  
  printf("\t xorl %%ebx, %%ebx \n");
  printf("\t int 0x80\n");}

}

/*
 * 	header -> PROGRAM progid ;
 */
void
header (void)
{
  match (PROGRAM);
  progid ();
  match (';');
}

void
progid (void)
{
  match (ID);
}

/* declara��es:
 *
 * 	declscope -> {vari_def
 * 		     |constdef
 * 		     |procedef
 * 		     |functdef
 * 		     |type_def}
 */
void
declscope (void)
{
  while (1)
    {
      switch (lookahead)
	{
	case VAR: //vari�vel
	  vari_def ();
	  break;
	case CONST://constante
	  constdef ();
	  break;
	case PROCEDURE://procedimentos
	  procedef ();
	  break;
	case FUNCTION://fun��es
	  functdef ();
	  break;
	case TYPE://tipos
	  type_def ();
	  break;
	default:
	  return;
	}
    }
}

/*  vari�veis: verifica a tabela de s�mbolos e adiciona
 *  na tabela caso encontre uma vari�vel
 *
 * 	vari_def -> VAR ID {, ID} : vartype ;
 * 			{ID {, ID} : vartype ;}
 */
int firstentry;
void
vari_def (void)
{
  firstentry = symtab_nextentry;
  match (VAR);
  {
    symtab_add (lexeme);
  }
  match (ID);
  while (lookahead == ',')
    {
      match (',');
      {
	symtab_add (lexeme);
      }
      match (ID);
    }
  match (':');
  vartype ();
  match (';');
  while (lookahead == ID)
    {
      match (ID);
      while (lookahead == ',')
	{
	  match (',');
	  match (ID);
	}
      match (':');
      vartype ();
      match (';');
    }
}

 /* tipos de vari�veis: 
  *
  *           vartype ->  ARRAY \[ range {; range} \] OF vartype
  *                       | INTEGER
  *                       | REAL
  *                       | DOUBLE
  *                       | BOOLEAN
  *                       | STRING [ \[ INTCTE \] ]
  *                       | CHAR
  */
void
vartype (void)
{
  int i;
  switch (lookahead)
    {
    case ARRAY://array
      match (ARRAY);
      match ('[');
      range ();
      while (lookahead == ',')
	{
	  match (',');
	  range ();
	}
      match (']');
      match (OF);
      vartype ();
      break;
    case STRING://string
      match (STRING);
      if (lookahead == '[')
	{
	  match ('[');
	  match (INTCTE);
	  match (']');
	}
      break;
    case INTEGER://inteiro
    case REAL://real
    case DOUBLE://double real
    case BOOLEAN://booleano
    case CHAR://char
      for (i = firstentry; i < symtab_nextentry; i++)
	{
	  symtab[i].objtype = SMPLVAR;
	  symtab[i].valtype = lookahead;
	}
      match (lookahead);
    }
}

/* range: range -> INTCTE .. INTCTE */
void
range (void)
{
  match (INTCTE);
  match (DDOT);
  match (INTCTE);
}

/* constantes:	
 * constdef -> CONST ID = INTCTE ;
 *
 * 	...
 */
void
constdef (void)
{
  match (CONST);
  match (ID);
  match ('=');
  match (INTCTE);
  match (';');
}

/* procedimentos:
 *	
 * procedef -> PROCEDURE ID formparm ;
 *		      declscope
 *		      procscope ;
 */
void
procedef (void)
{
  match (PROCEDURE);
  match (ID);
  formparm ();
  match (';');
  declscope ();
  procscope ();
  match (';');
}

/* fun��es:	
 * functdef -> FUNCTION ID formparm : rettype ;
 *		      declscope
 *		      procscope ;
 *
 * 	...
 */
void
functdef (void)
{
  match (FUNCTION);
  match (ID);
  formparm ();
  match (':');
  rettype ();
  match (';');
  declscope ();
  procscope ();
  match (';');
}

/*retorno: rettype -> vartype */
void
rettype (void)
{
  vartype ();
}

/* estrutura dos par�metros: 
 * formparm -> (parm {; parm} ) */
void
formparm (void)
{
  match ('(');
  parm ();
  while (lookahead == ';')
    {
      match (';');
      parm ();
    }
  match (')');
}

/* par�metros: parm -> [VAR] ID {, ID} : vartype */
void
parm (void)
{
  if (lookahead == VAR)
    match (VAR);
  match (ID);
  while (lookahead == ',')
    {
      match (',');
      match (ID);
    }
  match (':');
  vartype ();
}

/* tipos: type_def -> ID \= vartype */
void
type_def (void)
{
  match (ID);
  match ('=');
  vartype ();
}

/* 	estrutura do programa, fun��es e procedimentos:
    procscope -> beginblock
 */
void
procscope (void)
{
  beginblock ();
}

 /* estrutura do bloco:    
  * beginblock -> BEGIN stmt { ; stmt } END
  */
void
beginblock (void)
{
           
  {printf("\t<begin.asm.list>\n");}
           
  match (BEGIN);
  stmt ();
  while (lookahead == ';')
    {
      match (';');
      stmt ();
    }
  match (END);
}

/* statements:
 * 		stmt ->   beginblock
 */
void
stmt (void)
{
    {printf("\t<stm.asm.list>\n");}
    
  switch (lookahead)
    {
    case BEGIN:
      beginblock ();
      break;
/* 			| ifstmt  	 */

    case IF:
      ifstmt ();
      break;
/* 			| whlstmt  	 */
    case WHILE:
      whlstmt ();
      break;
/* 			| repstmt  	 */
    case REPEAT:
      repstmt ();
      break;
/* 			| forstmt  	 */
    case FOR:
      forstmt ();
      break;
/*  			| casestmt  	 */
    case CASE:
      casestmt ();
      break;
/* 			| prccall    	 */
/*			| assgstm    	 */
    case ID:
      
      /*a��o sem�ntica*/   
      {printf("\t<idstm.asm.list>\n");}   
         
      match (ID);
      if (lookahead == '[' || lookahead == ASGNM)
	{
	  while (lookahead == '[')
	    {
	      idxsynt ();
	    }
	  /* ':=' == ASGNM */
	  match (ASGNM);
	  expr ();
	}
      else
	{
	  if (lookahead == '(')
	    {
	      match ('(');
	      exprlist ();
	      match (')');
	    }
	}
      break;
      /*                     | ""
       */
    default:
      ;
    }				/*end switch */
}

/*
 * 			ifstmt -> IF expr THEN
 * 					stmt
 * 				 [ELSE
 * 				 	stmt]
 */
 
/* ifstmt parser:*/
int labelcount = 1;
void
ifstmt (void)
{
  
  /*a��o sem�ntica*/     
  {printf("\t<ifstm.asm.list>\n");}     
       
  int endif, thenexit;
  match (IF);
  expr ();
  match (THEN);
  
  /*gera��o de c�digo de m�quina*/
  {
    printf ("\tjz .L%d\n", endif = thenexit = labelcount++);
  }
  
  stmt ();
  if (lookahead == ELSE)
    {
  
    /*gera��o de c�digo de m�quina*/
      {
	printf ("\tjmp .L%d\n", endif = labelcount++);
	printf (".L%d:\n", thenexit);
      }
      
      match (ELSE);
      stmt ();
    }
  
  /*gera��o de c�digo de m�quina*/
  {
    printf (".L%d:\n", endif);
  }
}

/* 		estrutura da express�o:	expr -> expla [RELOP expla]
 */
/* expr parser:*/
void
expr (void)
{
  /*a��o sem�ntica*/   
  {printf("\t<expr.asm.list>\n");}
    
  expla ();
  if (lookahead == RELOP || lookahead == IN)
    {
      match (lookahead);
      expla ();
    }
}

/* 		express�o:	expla -> [NEGATE] term {ADDOP term}
*/
/*expla parser: */
void
expla (void)
{
  if (lookahead == '-' || lookahead == NOT)
    {
      match (lookahead);
    }
  term ();
  while (lookahead == '+' || lookahead == '-' || lookahead == OR)
    {
      match (lookahead);
      term ();
    }
    
    /*gera��o de c�digo de m�quina*/
    {printf("\tpop %%eax\n");}
    
}

/* 			termo: term -> fact {MULOP fact}
 */ 
/*term parser:*/
void
term (void)
{
  fact ();
  
  /*gera��o de c�digo de m�quina*/
  {printf("\tpush %%eax\n");}
  
  while (lookahead == '*' ||
	 lookahead == '/' ||
	 lookahead == DIV || lookahead == MOD || lookahead == AND)
    {
      match (lookahead);
      fact ();
      if(ismulop(lookahead)){
        
        /*gera��o de c�digo de m�quina*/
        {printf("\timul (%%esp)\n");
        printf("\tmov %%eax, (%%esp)\n");}
        
      }
      if(isdivop(lookahead)){
                             
            /*gera��o de c�digo de m�quina*/
			{printf("\tmov %%eax, -4(%%esp)\n");
			printf("\tmov (%%esp), %%eax\n");
			printf("\tcltd\n");
			printf("\tidiv -4(%%esp)\n");
			printf("\tmov %%eax, (%%esp)\n");}
			
      }
      if(isandop(lookahead)){
                             
        /*gera��o de c�digo de m�quina*/
        {printf("\tand (%%esp)\n");
        printf("\tmov %%eax, (%%esp)\n");}
        
      }
    }
    
    /*gera��o de c�digo de m�quina*/
    {printf("\tadd $4, %%esp\n");}
    
}

/*				fatores:     fact -> varbl
 * 					     	   | INTCTE
 * 					     	   | fncall
 * 					     	   | ( expr )
 */
/*fact parser:*/
void
fact (void)
{
  switch (lookahead)
    {
    case INTCTE://constante inteira
      match (INTCTE);
      break;
    case '('://par�nteses
      match ('(');
      expr ();
      match (')');
      break;
    case ID://identificador
      {
            
      /*gera��o de c�digo de m�quina*/
      {printf("\tmov %s, %%eax\n", lexeme);}
      
	if (symtab_lookup (lexeme) == -1)
	  {
	    deupau ();
	  }
      }
      match (ID);
      if (lookahead == '(')
	{
	  match ('(');
	  exprlist ();
	  match (')');
	}
      else
	{
	  while (lookahead == '[')
	    {
	      idxsynt ();
	    }
	}
      break;
    default:
      ;
    }
}

/* index syntax: idxsynt -> \[ expla {, expla} \] */
void
idxsynt (void)
{
  match ('[');
  expla ();
  while (lookahead == ',')
    {
      match (',');
      expla ();
    }
  match (']');
}

/* lista de express�es: exprlist -> expr {, expr} */
void
exprlist (void)
{
  expr ();
  while (lookahead == ',')
    {
      match (',');
      expr ();
    }
}

/*
 * prccall -> ID [(exprlst)]
 *
 */


/*
 * while: whlstmt -> WHILE expr DO stmt
*/

void
whlstmt (void)
{
  int whilehead, whileend;
  
  /*a��o sem�ntica*/
  {printf("\t<whlstm.asm.list>\n");}
    
  match (WHILE);
  
  /*gera��o de c�digo de m�quina*/
  {
    printf (".L%d:\n", whilehead = labelcount++);
  }
  
  expr ();
  
  /*gera��o de c�digo de m�quina*/
  {
    printf ("\tjz .L%d\n", whileend = labelcount++);
  }
  
  match (DO);
  stmt ();
  
  /*gera��o de c�digo de m�quina*/
  {
    printf ("\t jmp .L%d\n", whilehead);
    printf (".L%d:\n", whileend);
  }
  
}

/*
 * repeat: repstmt -> REPEAT stmtlst UNTIL expr
 *
 * 	lista de statements: stmtlst -> stmt {; stmt}
 */
void
repstmt (void)
{
  
  /*a��o sem�ntica*/      
  {printf("\t<repstm.asm.list>\n");}      
  
  int repeat;      
  match (REPEAT);
  
  /*gera��o de c�digo de m�quina*/
  {printf(".L%i:\n", repeat = labelcount++);}
  
  stmt ();
  while (lookahead == ';')
    {
      match (';');
      stmt ();
    }
  match (UNTIL);
  expr ();
  
  /*gera��o de c�digo de m�quina*/
  {printf("\tjz .L%i\n", repeat);}
  
}

/*
 * forstmt -> FOR assgstm to expr DO stmt
 * 		to -> DOWNTO | TO
 */

void
forstmt (void)
{
   
  /*a��o sem�ntica*/      
  {printf("\t<forstm.asm.list>\n");}      
  
  int forini,forfim;      
  match (FOR);
  
  /*gera��o de c�digo de m�quina*/
  {printf(".L%i:\n", forini = labelcount++);}
  
  assgstm ();
  if (lookahead == TO)
    match (TO);
  else
    match (DOWNTO);
  expr ();
  
  /*gera��o de c�digo de m�quina*/
  {printf("\tjz .L%i\n",forfim = labelcount++);}
  
  match (DO);
  stmt ();
  
  /*gera��o de c�digo de m�quina*/
  {printf(".L%i:\n", forfim);}
  
}

/* atribui��o: assgstm -> ID { idxsynt } ":=" expr */
void
assgstm (void)
{
  
  /*a��o sem�ntica*/
  {printf("\t<assgstm.asm.list>\n");}      
        
  match (ID);
  while (lookahead == '[')
    idxsynt ();
  match (ASGNM);
  expr ();
  
  /*gera��o de c�digo de m�quina*/
  {printf("\tmov %s, %%eax\n", lexeme);}
  
}

/* case: casestmt -> CASE expr OF listaop {; listaop} [ELSE stmt] end */
void
casestmt (void)
{
  
  /*a��o sem�ntica*/       
  {printf("\t<expr.asm.list>\n");}       
  
  int endcase,thenexit;       
  match (CASE);
  expr ();
  match (OF);
  listaop ();
  while (lookahead == ';')
    {
     
     /*gera��o de c�digo de m�quina*/
     {
      printf ("\tjz .L%d\n", endcase = thenexit = labelcount++);
     }
      match (';');
      listaop ();
    }
  if (lookahead == ELSE)
    {
                
     /*gera��o de c�digo de m�quina*/
     {
      printf ("\tjmp .L%d\n", endcase = labelcount++);
      printf (".L%d:\n", thenexit);
     }
     
      match (ELSE);
      stmt ();
    }
  match (END);
  
  /*gera��o de c�digo de m�quina*/
  {
    printf (".L%d:\n", endcase);
  }
  
}

/* lista de operadores: listaop -> INTCTE {, INTCTE} : stmt */
void
listaop (void)
{
  match (INTCTE);
  while (lookahead == ',')
    {
      match (',');
      match (INTCTE);
    }
  match (':');
  stmt ();
}
