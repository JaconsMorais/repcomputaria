/*
 * Projeto SimPas -- Compiladores
 * Autor Original: Professor Dr Eraldo P Marinho
 * Code para orientar a elaboração do Pascal Simplificado
 */
#include <stdio.h>
#include <stdlib.h>
void
deupau (void)
{
  fprintf (stderr, "deu pau!\n");
  exit (-1);
}

#include <parser.h>
/* 
 * Date of last change: Fri Oct 23 10:08:52 BRST 2009 
 * 
 *
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
  {printf("\n.section .text \n\n");
  printf("\t .global _start \n");
  printf("_start: \n");}
  procscope ();
  match ('.');
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

/*
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
	case VAR:
	  vari_def ();
	  break;
	case CONST:
	  constdef ();
	  break;
	case PROCEDURE:
	  procedef ();
	  break;
	case FUNCTION:
	  functdef ();
	  break;
	case TYPE:
	  type_def ();
	  break;
	default:
	  return;
	}
    }
}

/*
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

 /*             vartype ->  ARRAY \[ range {; range} \] OF vartype
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
    case ARRAY:
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
    case STRING:
      match (STRING);
      if (lookahead == '[')
	{
	  match ('[');
	  match (INTCTE);
	  match (']');
	}
      break;
    case INTEGER:
    case REAL:
    case DOUBLE:
    case BOOLEAN:
    case CHAR:
      for (i = firstentry; i < symtab_nextentry; i++)
	{
	  symtab[i].objtype = SMPLVAR;
	  symtab[i].valtype = lookahead;
	}
      match (lookahead);
    }
}

/* range -> INTCTE .. INTCTE */
void
range (void)
{
  match (INTCTE);
  match (DDOT);
  match (INTCTE);
}

/* 	constdef -> CONST ID = INTCTE ;
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

/*	procedef -> PROCEDURE ID formparm ;
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

/*	functdef -> FUNCTION ID formparm : rettype ;
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

/*rettype -> vartype */
void
rettype (void)
{
  vartype ();
}

/* formparm -> (parm {; parm} ) */
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

/* parm -> [VAR] ID {, ID} : vartype */
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

/* type_def -> ID \= vartype */
void
type_def (void)
{
  match (ID);
  match ('=');
  vartype ();
}

/* 	procscope -> beginblock
 */
void
procscope (void)
{
  beginblock ();
}

 /*     beginblock -> BEGIN stmt { ; stmt } END
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

/*
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
 *
 * 				expr -> expla [RELOP expla]
 * 					expla -> [NEGATE] term {ADDOP term}
 * 					   term -> fact {MULOP fact}
 * 					     fact -> varbl
 * 					     	   | INTCTE
 * 					     	   | fncall
 * 					     	   | ( expr )
 */
/* ifstmt parser:*/
int labelcount = 1;
void
ifstmt (void)
{
       
  {printf("\t<ifstm.asm.list>\n");}     
       
  int endif, thenexit;
  match (IF);
  expr ();
  match (THEN);
  {
    printf ("\tjz .L%d\n", endif = thenexit = labelcount++);
  }
  stmt ();
  if (lookahead == ELSE)
    {
      {
	printf ("\tjmp .L%d\n", endif = labelcount++);
	printf (".L%d:\n", thenexit);
      }
      match (ELSE);
      stmt ();
    }
  {
    printf (".L%d:\n", endif);
  }
}

/* expr parser:*/
void
expr (void)
{
     
  {printf("\t<expr.asm.list>\n");}
    
  expla ();
  if (lookahead == RELOP || lookahead == IN)
    {
      match (lookahead);
      expla ();
    }
}

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
    
    {printf("\tpop %%eax\n");}
    
}

/*term parser:*/
void
term (void)
{
  fact ();
  {printf("\tpush %%eax\n");}
  while (lookahead == '*' ||
	 lookahead == '/' ||
	 lookahead == DIV || lookahead == MOD || lookahead == AND)
    {
      match (lookahead);
      fact ();
      if(ismulop(lookahead)){
        {printf("\timul (%%esp)\n");
        printf("\tmov %%eax, (%%esp)\n");}
      }
      if(isdivop(lookahead)){/**/
			{printf("\tmov %%eax, -4(%%esp)\n");
			printf("\tmov (%%esp), %%eax\n");
			printf("\tcltd\n");
			printf("\tidiv -4(%%esp)\n");
			printf("\tmov %%eax, (%%esp)\n");}
      }
      if(isandop(lookahead)){/**/
        {printf("\tior (%%esp)\n");
        printf("\tmov %%eax, (%%esp)\n");}
      }
    }
    {printf("\tadd $4, %%esp\n");}
}

/*fact parser:*/
void
fact (void)
{
  switch (lookahead)
    {
    case INTCTE:
      match (INTCTE);
      break;
    case '(':
      match ('(');
      expr ();
      match (')');
      break;
    case ID:
      {
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

/* idxsynt -> \[ expla {, expla} \] */
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

/* exprlist -> expr {, expr} */
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
 * whlstmt -> WHILE expr DO stmt
*/

void
whlstmt (void)
{
  int whilehead, whileend;
  
  {printf("\t<whlstm.asm.list>\n");}
    
  match (WHILE);
  {
    printf (".L%d:\n", whilehead = labelcount++);
  }
  expr ();
  {
    printf ("\tjz .L%d\n", whileend = labelcount++);
  }
  match (DO);
  stmt ();
  {
    printf ("\t jmp .L%d\n", whilehead);
    printf (".L%d:\n", whileend);
  }
}

/*
 * repstmt -> REPEAT stmtlst UNTIL expr
 *
 * 	stmtlst -> stmt {; stmt}
 */
void
repstmt (void)
{
        
  {printf("\t<repstm.asm.list>\n");}      
  
  int repeat;      
  match (REPEAT);
  {printf(".L%i:\n", repeat = labelcount++);}
  stmt ();
  while (lookahead == ';')
    {
      match (';');
      stmt ();
    }
  match (UNTIL);
  expr ();
  printf("\tjz .L%i\n", repeat);
}

/*
 * forstmt -> FOR assgstm to expr DO stmt
 * 		to -> DOWNTO | TO
 */

void
forstmt (void)
{
        
  {printf("\t<forstm.asm.list>\n");}      
  
  int forini,forfim;      
  match (FOR);
  {printf(".L%i:\n", forini = labelcount++);}
  assgstm ();
  if (lookahead == TO)
    match (TO);
  else
    match (DOWNTO);
  expr ();
  {printf("\tjz .L%i\n",forfim = labelcount++);}
  match (DO);
  stmt ();
  {printf(".L%i:\n", forfim);}
}

/* assgstm -> ID { idxsynt } ":=" expr */
void
assgstm (void)
{
  
  {printf("\t<assgstm.asm.list>\n");}      
        
  match (ID);
  while (lookahead == '[')
    idxsynt ();
  match (ASGNM);
  expr ();
  {printf("\tmov %s, %%eax\n", lexeme);}
}

/* casestmt -> CASE expr OF listaop {; listaop} [ELSE stmt] end */
void
casestmt (void)
{
         
  {printf("\t<expr.asm.list>\n");}       
  
  int endcase,thenexit;       
  match (CASE);
  expr ();
  match (OF);
  listaop ();
  while (lookahead == ';')
    {
     {
      printf ("\tjz .L%d\n", endcase = thenexit = labelcount++);
     }
      match (';');
      listaop ();
    }
  if (lookahead == ELSE)
    {
     {
      printf ("\tjmp .L%d\n", endcase = labelcount++);
      printf (".L%d:\n", thenexit);
     }
      match (ELSE);
      stmt ();
    }
  match (END);
  {
    printf (".L%d:\n", endcase);
  }
}

/* listaop -> INTCTE {, INTCTE} : stmt */
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
