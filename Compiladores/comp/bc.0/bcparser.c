#include "bcparser.h"
#include "bctokens.h"

/*
 * topdown parser => LL(1) grammar:
 *
 * E -> T (addop T)*
 * T -> F (mulop F)*
 * F -> var (= E)? | cte | '('E')'
 */

/* terminal -> match(terminal) */

void E (void)
{
	T();
	while (lookahead == ADDOP) {
		match (ADDOP); T();
	}
}

void T (void)
{
	F();
	while (lookahead == MULOP) {
		match (MULOP); F();
	}
}


void F (void)
{
	switch (lookahead) {
	case VAR:
		match(VAR); 
		if (lookahead == '='){
			match('=');
			E();
		}
		break;
	case CTE:
		match(CTE); break;
	default:
		match('('); E(); match(')');
	}
}

