//--------------------------------ANALISADOR SINTATICO--------------------

#include <stdio.h>
#include <string.h>
#include "lexerob.c"

//-----------------------------PROCEDIMENTOS--------------------------------

/* VARIAVEL QUE FAZ O CONTROLE DOS ROTULOS*/

int ROTULO= 0;

/*  PROCEDIMENTOS DO PARSER ( INICIALIZADOS EM GLOBAL.H)

void programa (void);
void declara_variavel (void);
void subprogramas (void);
void bloco (void);
void comando (void);
void ifthen (void);
void whiledo (void);
void declara_for(void);
void repeatuntil (void);
void declara_case(void);
void declara_read(void);
void declara_write(void);
void lista_expressao (void);
void expressao (void);
void expressao_simples (void);
void termo (void);
void fator (void);


*/

//-----------------------------CORPO PRINCIPAL--------------------------------

void programa (void){
	match (PROGRAM);
  	match (ID);
  	match (';');
  	declara_variavel();
  	subprogramas ();
  	fprintf(arq_objeto,"\n.section .text \n\n");
  	fprintf(arq_objeto,"\t .global _start \n");
  	fprintf(arq_objeto, "_start: \n");
  	bloco ();
  	match ('.');

/*CHAMADA DA INTERRUPCAO DO PROGRAMA*/
	fprintf(arq_objeto, "_end: \n");
  	fprintf(arq_objeto, "\t movl $1, %%eax\n");  
  	fprintf(arq_objeto, "\t xorl %%ebx, %%ebx \n");
  	fprintf(arq_objeto, "\t int 0x80\n");

}//void


//--------------------------DECLARA_VARIAVEL-------------------------------------

/* OBS: SO HA DECLARACAO DE VARIAVEIS GLOBAIS E DO TIPO INTEGER E BOOLEAN */ 
void declara_variavel (void){
	if (lookahead == VAR)
	{
		/* INICIO DO CODIGO OBJETO*/

      	fprintf(arq_objeto,".section .bss \n\n");
		match (VAR);
		do
   		{
			fprintf(arq_objeto, "\.global \n");
			fprintf(arq_objeto, ".common %s, 4\n", lexema);

/* 
	CHAMADA DO PROCEDIMENTO DECLARA, ASSIM TABLESYMBOL[LASTENTRY].DEC RECEBE VALOR 1
   	SINALIZANDO QUE O INDENTIFICADOR FOI DECLARADO COMO VARIAVEL EM VAR.
 	(LASTENTRY CONTEM A POSICAO DO ULTIMO ID DECLARADO NA TABELA DE SIMBOLOS.)
*/
			declara();
			match(ID);
			do
			{
	   			if (lookahead == ',')
	   			{
					match(',');
					fprintf(arq_objeto, "\.global \n");
					fprintf(arq_objeto, ".common %s, 4\n", lexema);
					declara();
					match(ID);
	   			}
			}while (lookahead == ',');
			match(':');
			if (lookahead == INTEGER)
	      	match(INTEGER);
			else
	      		if (lookahead == BOOLEAN)
		 			match(BOOLEAN);
					match(';');
   		}while(lookahead == ID);
	}
}

//----------------------------SUBPROGRAMAS-----------------------------------------

void subprogramas (){
  	while ((lookahead == PROCEDURE) || (lookahead == FUNCTION))
	{   
    	fprintf(arq_objeto,"\n.section .text \n\n");
    	if (lookahead == PROCEDURE)
	{
		match (PROCEDURE);
		fprintf (arq_objeto, "%s:\n", lexema);
		fprintf (arq_objeto, "\t pushl %%ebp \n");
		fprintf (arq_objeto, "\t movl %%esp, %%ebp \n");
		declara();
		match (ID);
		if (lookahead == '(')
		{
      		match ('(');
      		match (')');
		}
	match (';');
	declara_variavel ();
	fprintf(arq_objeto, "\t addl $0, %%esp \n");
	bloco ();
	fprintf(arq_objeto, "\t movl %%ebp, %%esp\n");
	fprintf(arq_objeto, "\t popl %%ebp \n");
	fprintf(arq_objeto, "\t ret \n");
	match (';');
    	}
    	else{
		match (FUNCTION);
		fprintf (arq_objeto, "%s:\n", lexema);
		declara();
		match (ID);
		if (lookahead == '(')
		{
      		match ('(');
     	 		match (')');
		}
		match (':');
		if (lookahead == INTEGER)
		match(INTEGER);
		else
			if (lookahead == BOOLEAN)
			match(BOOLEAN);
		match (';');
		bloco ();
		match (';');
    		}
  	}//while
}//void

//----------------------------BLOCO------------------------------------------

void bloco (void){
	
	match (BEGIN);
  	while (lookahead != END)
	{
      comando ();
      if(lookahead==';') 
	match (';');
      else break;
    	}//end   
	match (END);

}//void

//----------------------------COMANDO-----------------------------------------


void comando (void){
  char auxiliar[33];	
  	if (lookahead == BEGIN)
    	bloco ();

 	 else if (lookahead == ID)
		{     
		/* ARMAZENA EM AUXILIAR O ID, POIS QDO FAZ MATCH(ID) O LOOKAHEAD PEGA 
		   O PROXIMO LEXEMA AQUI NO CASO ELE PEGA POR EX´:=´ SENDO ASSIM NAO 
		   TENHO MAIS EM LEXEMA O ID QUE IREI USAR EM FPRINTF. 
		*/ 
      	strcpy (auxiliar, lexema);

/* 	
	CHAMADA DO PROCEDIMENTO VERIFICA(), VERIFICA SE O IDENTIFICADOR FOI DECLARADO
   	EM VAR. CASO NAO TENHA SIDO UMA MENSAGEM SERA MOSTRADA AVISANDO QUE O ID
   	NAO FOI DECLARADO.	
*/
		verifica (lexema);
      	match (ID);
		if (lookahead != ATRIB)
		fprintf (arq_objeto, "\t call %s\n", auxiliar);
    		if (lookahead=='(')
		{
			match('(');
			match(')');
    		}else
    			{
      		match (ATRIB);
      		expressao_simples ();
			fprintf (arq_objeto, "\t movl %%eax, %s\n", auxiliar);
    			}
    		}//ID

// ******************ESTRUTURAS DE CONTROLE*****************

  	ifthen ();
  	whiledo ();
  	repeatuntil ();
	declara_for();
  	declara_read();
 	declara_write();
	declara_case();

}//void


//------------------------------IFTHEN---------------------------------------

void ifthen (void){
  	int L, L1;

  	if (lookahead == IF)
	{
      match (IF);
      expressao ();
      match (THEN);
      L1 = L = ROTULO++;
      fprintf (arq_objeto, "\t and \%%eax,\%%eax\n\t jz .L%d\n", L);
      comando ();
      if (lookahead == ELSE)
	{
		match (ELSE);
	  	L1 = ROTULO++;
	  	fprintf (arq_objeto, "\t jmp .L%d\n.L%d:\n", L1, L);
	  	comando ();
      }//else	
      fprintf (arq_objeto, ".L%d:\n", L1);
  	}//IF
}//void

//-----------------------------WHILEDO-----------------------------------------


void whiledo (void){
  	int L, L1;

  	if (lookahead == WHILE)
	{
      	match (WHILE);
      	L = ROTULO++;
      	fprintf (arq_objeto, ".L%d:\n", L);
      	expressao ();
     	 	L1 = ROTULO++;
      	fprintf (arq_objeto, "\t jz .L%d\n", L1);
      	match (DO);
      	comando ();
      	fprintf (arq_objeto, "\t jmp .L%d\n.L%d:\n", L, L1);
   	}//while
}//void



//-----------------------------REPEAT_UNTIL----------------------------------------

void repeatuntil (void){
  	int L;

  	if (lookahead == REPEAT)
	{
      	match (REPEAT);
      	L = ROTULO++;
      	fprintf (arq_objeto, ".L%d:\n", L);
		do
		{
      		comando ();
      		if(lookahead==';') 
			match (';');
		}while(lookahead==ID);
      	
		match (UNTIL);
      	expressao ();
      	fprintf (arq_objeto, "\t jz .L%d\n", L);
  	}//if
} //void

//-----------------------------DECLARA_FOR----------------------------------------

void declara_for (void){
	int L,L1;
	char auxiliar[33];
	if (lookahead == FOR)
	{
		match(FOR);
	
  		if (lookahead == ID)
		{	
      		strcpy (auxiliar, lexema);
			verifica(lexema);
      		match (ID);
			match (ATRIB);
      		fprintf (arq_objeto, "\t movl %s, \%%eax\n", lexema);
		      fprintf (arq_objeto, "\t movl %%eax, %s\n", auxiliar);
			match(CT);
			match(TO);
      		fprintf (arq_objeto, "\t movl %s, \%%edx\n", lexema);
			match(CT);
     	 		L= ROTULO++;
	      	fprintf (arq_objeto, ".L%d:\n", L);
      		fprintf (arq_objeto, "\t movl %s, \%%eax\n", auxiliar);
			fprintf (arq_objeto, "\t cmpl %%edx, %%eax \n");
			fprintf (arq_objeto, "\t setgeb %%al \n");
			L1 = ROTULO++;      		
			fprintf (arq_objeto, "\t jz .L%d\n", L1);
			fprintf (arq_objeto, "\t inc %%eax\n");
		      fprintf (arq_objeto, "\t movl %%eax, %s\n", auxiliar);
      		match (DO);
      		comando ();
      		fprintf (arq_objeto, "\t jmp .L%d\n.L%d:\n", L, L1);
		}//IF
	}//IF
}//VOID

//--------------------------DECLARA_READ-------------------------------------------

void declara_read()
{	
	if (lookahead == READ)
    	{		
    	match(READ);
    	match('(');

	/* ETAPAS EM ASSEMBLY QUE EXECUTA O COMANDO READ */

    	fprintf(arq_objeto, "\n\t movl $3, %%eax\n");
    	fprintf(arq_objeto, "\t movl $0, %%ebx\n");
    	fprintf(arq_objeto, "\t movl %s,%%ecx\n",lexema);
    	fprintf(arq_objeto, "\t movl 4, %%edx\n");
    	fprintf(arq_objeto, "\t int 0x80\n\n");
    	match(ID);
    	match(')');
    	}	
}

//--------------------------DECLARA_WRITE-----------------------------------------

/* O PROCEDIMENTO WRITE NAO FOI IMPLEMENTADO CORRETAMENTE - NÃO TERMINADO*/

void declara_write()
{     
	char constante[60] = "";
	if(lookahead == WRITE)
    	{
    	match(WRITE);
    	match('(');
	match('"');
	while (lookahead != '"'){
	strcat(constante, lexema);
	strcat(constante," ");	
	lookahead = gettoken();
	}	
    	fprintf(arq_objeto, "\n\t movl $4, %%eax\n");
    	fprintf(arq_objeto, "\t movl $1, %%ebx\n");
    	fprintf(arq_objeto, "\t movl %s, %%ecx\n",constante);

/* MOVE PARA EDX O TAMANHO DA STRING DECLARADA EM WRITE*/

	fprintf(arq_objeto, "\t movl %i, %%edx\n",strlen(constante));
    	fprintf(arq_objeto, "\t int 0x80\n\n");
    	//match (ID);
	match ('"');	
    	match(')');
	}
}

//------------------------------DECLARA_CASE-----------------------------------
void declara_case (void){
int L,L1;

	if (lookahead == CASE )
	{
	match(CASE);
	fprintf (arq_objeto, "\t movl %s, \%%eax\n", lexema);
      fprintf (arq_objeto, "\t pushl \%%eax\n");	
	match(ID);
	match(OF);
	do
	{	
    	 	if (lookahead == ';')
		{
		match(';');
		}
			L= ROTULO++;
	      	fprintf (arq_objeto, ".L%d:\n", L);
      		fprintf (arq_objeto, "\t movl %s, \%%edx\n",lexema);
			fprintf (arq_objeto, "\t popl \%%ebx\n");	
			fprintf (arq_objeto, "\t cmpl %%edx, %%ebx \n");
			fprintf (arq_objeto, "\t seteb %%al \n");
      		fprintf (arq_objeto, "\t pushl \%%ebx\n");
			L1 = ROTULO++;      		
			fprintf (arq_objeto, "\t jnz .L%d\n", L1);
	  		fprintf (arq_objeto, "\t jmp .L%d\n", L1+1);
			match (CT);
			match (':');    	
			fprintf (arq_objeto, ".L%d:\n", L1);
			comando();
			fprintf (arq_objeto, "\t jmp .L%d\n", L1+1);
	}while (lookahead ==';');
	fprintf (arq_objeto, ".L%i:\n", ROTULO);
	match(END);
	}
}	

//-------------------------LISTA_EXPRESSAO-----------------------------------

void lista_expressao (void){
  	expressao ();
  	while (lookahead == ',')
	{
      match (',');
      expressao ();
  	}
}//void

//------------------------EXPRESSAO------------------------------------------

void expressao (void){
  	expressao_simples ();
  	switch (lookahead)
	{
    	case '=':
      match ('=');
      expressao_simples ();
	fprintf(arq_objeto, "\t movl %%eax, %%ecx \n");
	fprintf(arq_objeto, "\t popl %%ebx \n");
	fprintf(arq_objeto, "\t xorl %%eax \n");
	fprintf(arq_objeto, "\t cmpl %%ecx, %%ebx \n");
	fprintf(arq_objeto, "\t seteb %%al \n");
      break;
    	
	case '>':
      match ('>');
      expressao_simples ();
	fprintf(arq_objeto, "\t movl %%eax, %%ecx \n");
	fprintf(arq_objeto, "\t popl %%ebx \n");
	fprintf(arq_objeto, "\t xorl %%eax \n");
	fprintf(arq_objeto, "\t cmpl %%ecx, %%ebx \n");
	fprintf(arq_objeto, "\t setgb %%al \n");
      break;
    
	case '<':
      match ('<');
      expressao_simples ();
	fprintf(arq_objeto, "\t movl %%eax, %%ecx \n");
	fprintf(arq_objeto, "\t popl %%ebx \n");
	fprintf(arq_objeto, "\t xorl %%eax \n");
	fprintf(arq_objeto, "\t cmpl %%ecx, %%ebx \n");
	fprintf(arq_objeto, "\t setlb %%al \n");
      break;

	case MENORIGUAL:
      match (MENORIGUAL);
      expressao_simples ();
	fprintf(arq_objeto, "\t movl %%eax, %%ecx \n");
	fprintf(arq_objeto, "\t popl %%ebx \n");
	fprintf(arq_objeto, "\t xorl %%eax \n");
	fprintf(arq_objeto, "\t cmpl %%ecx, %%ebx \n");
	fprintf(arq_objeto, "\t setleb %%al \n");
      break;

    	case MAIORIGUAL:
      match (MAIORIGUAL);
      expressao_simples ();
	fprintf(arq_objeto, "\t movl %%eax, %%ecx \n");
	fprintf(arq_objeto, "\t popl %%ebx \n");
	fprintf(arq_objeto, "\t xorl %%eax \n");
	fprintf(arq_objeto, "\t cmpl %%ecx, %%ebx \n");
	fprintf(arq_objeto, "\t setgeb %%al \n");
      break;

    	case DIFERENTE:
      match (DIFERENTE);
      expressao_simples ();
	fprintf(arq_objeto, "\t movl %%eax, %%ecx \n");
	fprintf(arq_objeto, "\t popl %%ebx \n");
	fprintf(arq_objeto, "\t xorl %%eax \n");
	fprintf(arq_objeto, "\t cmpl %%ecx, %%ebx \n");
	fprintf(arq_objeto, "\t setneb %%al \n");
      break;

    }//switch
}

//------------------------EXPRESSAO_SIMPLES--------------------------------------

void expressao_simples (void){
  	if (lookahead == '+')
	{
      match ('+');
      termo ();
  	}else if (lookahead == '-')
		{
      	match ('-');
      	termo ();
      	fprintf (arq_objeto, "\t negl \%%eax\n");
  		}else termo ();
  			while ((lookahead == '+') || (lookahead == '-') || (lookahead == OR) 
					|| (lookahead == AND) )
    			switch (lookahead)
			{
      		case '+':
			match ('+');
			termo ();
			fprintf (arq_objeto, "\t popl \%%ebx\n");
			fprintf (arq_objeto, "\t addl \%%ebx, \%%eax\n");
			break;
      
			case '-':
			match ('-');
			termo ();
			fprintf (arq_objeto, "\t popl \%%ebx\n");
			fprintf (arq_objeto, "\t subl \%%ebx, \%%eax\n");
			break;
      
			case OR:
			match (OR);
			termo ();
	 		fprintf(arq_objeto, "\t popl %%ebx \n");
	 		fprintf(arq_objeto, "\t orl %%ebx, %%eax \n");
			break;
			
			case AND:
			match (AND);
			termo ();
	 		fprintf(arq_objeto, "\t popl %%ebx \n");
	 		fprintf(arq_objeto, "\t andl %%ebx, %%eax \n");
			break;

      		}//SWITCH
}

//------------------------------TERMO----------------------------------------

void termo (void){
	char auxiliar[33];
	fator ();
	while ((lookahead == '*') || (lookahead == DIV)|| (lookahead== '/'))
	switch (lookahead)
	{
      case '*': match ('*');
	if (lookahead == ID)
	//strcpy (auxiliar, lexema);
	{	
		fprintf(arq_objeto, "\t imul %s, %%eax\n", lexema);
		//fprintf(arq_objeto, "\t movl %%eax, %s\n\n", auxiliar);
		verifica(lexema);
		match(ID);
	}
	if (lookahead == CT)
	{
		fprintf(arq_objeto, "\t mull $%s, %%eax\n", lexema);
		//fprintf(arq_objeto, "\t movl %%eax, %s\n\n", auxiliar);
		match(CT);
	}
	      lista_expressao();
	      break;

	case '/': match ('/');
	if (lookahead == ID)
	//strcpy (auxiliar, lexema);
	{
		  fprintf(arq_objeto, "\t divl %s, %%eax\n", lexema);
		  //fprintf(arq_objeto, "\t movl %%eax, %s\n\n", auxiliar);
		  verifica(lexema);	
		  match(ID);
	}else {
	if (lookahead == CT)
	{
		fprintf(arq_objeto, "\t divl $%s, %%eax\n", lexema);
		//fprintf(arq_objeto, "\t movl %%eax, %s\n\n", auxiliar);
		match(CT);
	}}
	lista_expressao();
	break;

    	case DIV: match (DIV);
	if (lookahead == ID)
	//strcpy (auxiliar, lexema);
	{
		  fprintf(arq_objeto, "\t divl %s, %%eax\n", lexema);
		  //fprintf(arq_objeto, "\t movl %%eax, %s\n\n", auxiliar);
		  verifica(lexema);	
		  match(ID);
	}else {
	if (lookahead == CT)
	{
		fprintf(arq_objeto, "\t divl $%s, %%eax\n", lexema);
		//fprintf(arq_objeto, "\t movl %%eax, %s\n\n", auxiliar);
		match(CT);
	}}
	lista_expressao();
	break;

    	default:  break;
   	}

}//void

//-------------------------------FATOR---------------------------------------

void fator (void){
  	char auxiliar[33];
  	if (lookahead == ID)
	{
      strcpy (auxiliar, lexema);
	verifica(lexema);
      match (ID);
      if (lookahead == '(')
	{
	match ('(');
	lista_expressao ();
	match (')');
      }else if (lookahead == '[')
		{
	  	match ('[');
	  	lista_expressao ();
	 	match (']');
      	}
      fprintf (arq_objeto, "\t pushl \%%eax\n");
      fprintf (arq_objeto, "\t movl %s, \%%eax\n", auxiliar);
    	}//id
  
	if (lookahead == CT)
	{
	fprintf (arq_objeto, "\t pushl %%eax \n ");
	fprintf (arq_objeto, "\t movl %s , %%eax \n ", lexema);
      match (CT);
  	}
  
	if (lookahead == '(')
	{
      match ('(');
      expressao ();
      match (')');
  	}
  
}//void

//--------------------------FIM DO PARSER----------------------------------------
