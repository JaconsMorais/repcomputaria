//--------------------------------ANALISADOR LEXICO----------------------------------
#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include "simbolo.c"  

//--------------------------------VARIAVEIS------------------------------------------


/* ESTE PROCEDIMENTO DECIDE SE O CARACTER INICIAL LIDO E DO TIPO ALPHA,
   DIGITO,ESPACO EM BRANCO,INDENTIFICADOR,PONTUACAO[:|;|( | )],SINAL DE 
   OPERACAO,ETC, ATRAVES DE COMANDOS DE SELECAO. PARA CADA TIPO O PROCEDIMENTO 
   TEM UMA SERIE DE INSTRUCOES A SER REALIZADAS.
*/

TOKENTYPE gettoken()
{
  while((*lexema=getc(arq_entrada)),isspace(*lexema));
  
  if (isalpha(*lexema))
	 {
		ungetc(*lexema,arq_entrada);
		fscanf(arq_entrada, "%[A-Za-z0-9_]",lexema);
		
	/*RETORNA O TOKEN CORRESPONDENTE*/
      
	return (insert (lexema, ID));
	 } else

	 if (isdigit(*lexema))
	 {
		ungetc(*lexema,arq_entrada);
		fscanf(arq_entrada, "%[0-9]",lexema);
		return(CT);
	 } else
	 switch(*lexema)
	 {
		case ';':
		case ',':
		case '=':
		case '+':
		case '-':
		case '*':
		case '/':
		case '"':
		case '[':
		case ']':
		case '(':
		case ')': return *lexema;
		case '.':
				  {
					 *lexema= fgetc(arq_entrada);
					 if (*lexema == '.')
						 return DOTDOT;
					 else
					 {
						ungetc(*lexema,arq_entrada);
						return '.';
					 }
				  }
		case ':':
				  {
					 *lexema= fgetc(arq_entrada);
					 if (*lexema == '=')
						 return ATRIB;
					 else
					 {
						ungetc(*lexema,arq_entrada);
						return ':';
					 }
				  }
		case '<':
				  {
					 *lexema= fgetc(arq_entrada);
					 if (*lexema == '=')
						return MENORIGUAL;
					 else if (*lexema == '>')
						return DIFERENTE;
					 else
					 {
						ungetc(*lexema,arq_entrada);
						return '<';
					 }
				  }
		case '>':
				  {
					 *lexema= fgetc(arq_entrada);
					 if (*lexema == '=')
						 return MAIORIGUAL;
					 else
					 {
						ungetc(*lexema,arq_entrada);
						return '>';
					 }
				  }
	 }//switch


  return(0);
}

/* VERIFICA SE O TOKEN PASSADO COMO PARAMETRO E O MESMO DO SIMBOLO LIDO,
   O QUAL ESTA CONTIDO NA VARIAVEL GLOBAL LOOKAHEAD, SE ISTO FOR VERDADEIRO,
   ENTAO PROCESSA A LEITURA DE UM NOVO LEXEME, ATRAVES DA CHAMADA AO
   PROCEDIMENTO LEXAN. SE O TOKEN LIDO NAO CORRESPONDER AO TOKEN ESPERADO O
   PROCEDIMENTO MATCH IMPRIME A MENSAGEM DE ERRO E INTERROMPE O PROCESSO DE
   COMPILACAO.
*/

TOKENTYPE match(TOKENTYPE token)
{
  if (token == lookahead)
  {
	lookahead = gettoken();
	return lookahead;
  }
  else
  {
	printf("\n\t\tERRO!\n");
	return(0);

  }
}

