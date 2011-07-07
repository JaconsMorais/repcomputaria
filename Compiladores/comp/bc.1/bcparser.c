#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "bcparser.h"
#include "bctokens.h"

extern char lexeme[];

/*
 * topdown parser => LL(1) grammar:
 *
 * E -> T (addop T {addop} )*
 * T -> F (mulop F {mulop} )*
 * F -> var (= E)? {var} {=}? | cte {cte} | '('E')'
 */

/* terminal -> match(terminal) */

void E (void)
{
    T();
    while (lookahead == ADDOP) {
        char opname[2];strcpy(opname,lexeme);
        match (ADDOP); T(); {printf("%s ",opname);}
    }
}

void T (void)
{
    F();
    while (lookahead == MULOP) {
        char opname[2];strcpy(opname,lexeme);
        match (MULOP); F(); {printf("%s ",opname);}
    }
}


void F (void)
{
    char *varname;
    switch (lookahead) {
        case VAR:
        {varname = malloc(strlen(lexeme)+1);
        strcpy(varname,lexeme);}
        match(VAR); 
        if (lookahead == '='){
            match('=');
            E();
            {printf("%s ",varname);
            printf("assign ");}
        }else{
            printf("%s ",varname);
        }
        break;
        case CTE:
        {printf("%s ",lexeme);}
        match(CTE); break;
        default:
            match('('); E(); match(')');
    }
}