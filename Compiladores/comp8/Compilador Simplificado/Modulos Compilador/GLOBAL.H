#include <stdio.h>
#include <string.h>

//-------------------------TOKENS RESERVADOS-------------------------
#define ID 0x800
#define CT 0x801

#define OF 0x805
#define VAR 0x835
#define PROCEDURE 0x806
#define FUNCTION 0x807
#define BEGIN 0x808
#define END 0x809
#define IF 0x811
#define THEN 0x812
#define ELSE 0x813
#define WHILE 0x814
#define DO 0x815
#define FOR 0x816
#define TO 0x817
#define REPEAT 0x819
#define UNTIL 0x820
#define OR 0x821
#define AND 0x822
#define NOT 0x823
#define DIV 0x824
//#define MOD 0x825
#define PROGRAM 0x826
#define INTEGER 0x827
#define BOOLEAN 0x829
#define ATRIB 0x830
#define MENORIGUAL 0x831
#define MAIORIGUAL 0x832
#define DIFERENTE 0x833
#define DOTDOT 0x834
#define READ 0x835
#define WRITE 0x836
#define CASE 0x837

#define MAXENTRIES 500

/*---------------------- VARIAVEIS GLOBAIS-----------------------*/

/*  LOOKAHEAD - ONDE E ARMAZENADO O TOKEN DO ULTIMO LEXEMA.
    LEXEMA    - ONDE SAO ARMAZENADOS OS LEXEMAS.  
    FILE      - CONTEM O PROGRAMA FONTE (.PAS), PASSADO PELO USUARIO. 
*/

FILE *arq_entrada, *arq_objeto;

char lexema[33];

typedef long int TOKENTYPE;
TOKENTYPE lookahead;


/*---------------------------INICIALIZACAO FUNCOES----------------------------*/

/* PROCEDIMENTOS DO LEXEROB.C*/

TOKENTYPE match(TOKENTYPE token);
TOKENTYPE gettoken(void);

/* PROCEDIMENTOS DO PARSEROB.C*/
void programa (void);
void declara_variavel (void);
void subprogramas (void);
void bloco (void);
void comando (void);
void ifthen (void);
void thenelse (void);
void whiledo (void);
void repeatuntil (void);
void declara_for (void);
void declara_case(void);
void declara_read (void);
void declara_write (void);
void lista_expressao (void);
void expressao (void);
void expressao_simples (void);
void termo (void);
void fator (void);

/* PROCEDIMENTOS DO SIMBOLO.C*/

int lookup (const char *symbol);
int insert (const char *symbol, int token);
void declara (void);
void verifica(const char *symbol);

