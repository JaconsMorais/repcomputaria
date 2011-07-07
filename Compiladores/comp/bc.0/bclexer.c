#include "bclexer.h"
#include <stdlib.h>
#include <stdio.h>

isvar(void)
{
	char head = getc(stdin);
	if (isalpha(head)){
		while(isalnum(head=getc(stdin)));
		ungetc(head,stdin);
		return VAR;
	}
	ungetc(head,stdin);
	return 0;
}

iscte(void)
{
	char head = getc(stdin);
	if (isdigit(head)){
		if(head!='0'){
			while(isdigit(head=getc(stdin)));
			ungetc(head,stdin);
		}
		return CTE;
	}
	ungetc(head,stdin);
	return 0;
}

isaddop(void)
{
	char head;
	switch(head=getc(stdin)){
	case '+':case'-':
		return ADDOP;
	default:
		ungetc(head,stdin);
	}
	return 0;
}

ismulop(void)
{
	char head;
	switch(head=getc(stdin)){
	case '*':case'/':
		return MULOP;
	default:
		ungetc(head,stdin);
	}
	return 0;
}

void skipspaces(void)
{
	char head;
	while(isspace(head=getc(stdin)));
	ungetc(head,stdin);
}

gettoken(void)
{
	int token;
	skipspaces();
	if (token = isvar()) return token;
	if (token = iscte()) return token;
	if (token = isaddop()) return token;
	if (token = ismulop()) return token;
	return token = getc(stdin);
}

/* parser interface */

int lookahead;

void match (int required)
{
	if (required == lookahead){
		lookahead = gettoken();
	} else {
		fprintf(stderr,"syntax error\nexiting\n");
		exit(-1);
	}
}
