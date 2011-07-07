#include "bclexer.h"
#include <stdlib.h>
#include <stdio.h>

#define BUFFSIZ 32

char lexeme[BUFFSIZ];

isvar(void)
{
    char head = getc(stdin);
    if (isalpha(head)){
        lexeme[0] = head;
        int i = 1;
        while(isalnum(lexeme[i]=head=getc(stdin)))i++;
        lexeme[i] = 0;
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
        lexeme[0] = head;
        if(head!='0'){
            int i = 1;
            while(isdigit(lexeme[i]=head=getc(stdin)))i++;
            lexeme[i] = 0;
            ungetc(head,stdin);
        }else{
            lexeme[1] = 0;
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
        case '+':case'-':lexeme[0]=head;lexeme[1]=0;
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
        case '*':case'/':lexeme[0]=head;lexeme[1]=0;
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
    lexeme[1] = 0;
    if (token = isvar()) return token;
    if (token = iscte()) return token;
    if (token = isaddop()) return token;
    if (token = ismulop()) return token;
    return lexeme[0] = token = getc(stdin);
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
