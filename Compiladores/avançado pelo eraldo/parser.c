#include <string.h>

#include <tokens.h>
#include <lexer.h>
#include <parser.h>
#include <codegen.h>

/*
 * Method: top-down recursive parser for LL(1) grammars
 *
 * Simplified Pascal grammar:
 *
 * start symbol: program
 *
 * program -> Program ID ';' declrscope stmtscope '.'
 *
 */
void program (void)
{
	match (Program);
	match (ID);
	match (';');
	declrscope ();
	stmtscope ();
	match ('.');
}

/*
 * declrscope -> ( Var varlist ':' tmodifier ';' )*
 *
 */
void declrscope (void)
{
	while (lookahead == Var)
	{
		match (Var);
		varlist ();
		match (':');
		tmodifier ();
		match (';');
	}
}

/*
 * varlist -> var ( ',' var )*
 *
 */
void varlist (void)
{
	var ();
	while (lookahead == ',')
	{
		match (',');
		var ();
	}
}

/*
 * tmodifier -> Integer | Boolean | String
 *
 */
void tmodifier (void)
{
	switch (lookahead)
	{
		case Integer:
			match (Integer);
			break;
		case Boolean:
			match (Boolean);
			break;
		default:
			match (String);
	}
}

/*
 * stmtscope -> Begin stmtlist End
 *
 */
void stmtscope (void)
{
	match (Begin);
	stmtlist ();
	match (End);
}

/*
 * stmtlist -> stmt ( ';' stmt )*
 *
 */
void stmtlist (void)
{
	stmt ();
	while (lookahead == ';')
	{
		match (';');
		stmt ();
	}
}

/*
 * stmt -> ifstmt | whilestmt | forstmt | repstmt | wrtstmt | rdstmt
 * 	 | assgnm
 *
 */
void stmt (void)
{
	switch (lookahead)
	{
		case Begin:
			stmtscope ();
			break;
		case If:
			ifstmt ();
			break;
		case While:
			whilestmt ();
			break;
		case For:
			forstmt ();
			break;
		case Repeat:
			repstmt ();
			break;
		case Write:
		case Writeln:
			wrtstmt ();
			break;
		case Read:
		case Readln:
			rdstmt ();
			break;
		default:
			assgnm ();
	}
}

/*
 * ifstmt -> If expr Then stmt ( Else stmt )?
 *
 */
int loopcount = 1;
void ifstmt (void)
{
	int L1, L2;
	match (If);
	expr ();
	{				/* 1 */
		jmpfalse (L1 = L2 = loopcount++);
	}
	match (Then);
	stmt ();
	if (lookahead == Else)
	{
		{				/* 2 */
			jmp (L2 = loopcount++);
			mklabel (L1);
		}
		match (Else);
		stmt ();
	}
	{				/* 3 */
		mklabel (L2);
	}
}

/*
 * whilestmt -> While expr Do stmt
 *
 */
void whilestmt (void)
{
	int L1, L2;
	match (While);
	/* */ mklabel (L1 = loopcount++);
	expr ();
	/* */ jmpfalse (L2 = loopcount++);
	match (Do);
	stmt ();
	/* */ jmp (L1);
	/* */ mklabel (L2);
}

/*
 * forstmt -> For assgnm (To|Downto) expr Do stmt
 *
 */
void forstmt (void)
{
	int L1, L2;
	match (For);
	/* */ mklabel (L1 = loopcount++);
	assgnm ();
	if (lookahead == To)
		match (To);
	else
		match (Downto);
	expr ();
	/* To -> jmpfalse if var > finalexpr
	 * Downto   -> jmpfalse var < finalexpr */
	/* */ jmpfalse (L2 = loopcount++);
	match (Do);
	stmt ();
	/* */ mklabel (L2);
}

/*
 * repstmt -> Repeat stmtlist Until expr
 *
 */
void repstmt (void)
{
	int L;
	match (Repeat);
	/* */ mklabel (L = loopcount++);
	stmtlist ();
	match (Until);
	expr ();
	/* */ jmpfalse (L);
}

/*
 * wrtstmt -> Writeln ( '('exprlist')' )?
 * 	    | Write '('exprlist')'
 *
 */
void wrtstmt (void)
{
	if (lookahead == Writeln)
	{
		match (Writeln);
		if (lookahead == '(')
		{
			match ('(');
			exprlist ();
			match (')');
		}
	}
	else
	{
		match (Write);
		match ('(');
		exprlist ();
		match (')');
	}
	/* */
	printf ("\t<Write[ln]>\n");
}

/*
 * exprlist -> expr ( ',' expr )*
 */
void exprlist (void)
{
	expr ();
	while (lookahead == ',')
	{
		match (',');
		expr ();
	}
}

/*
 * rdstmt -> (Read|Readln) '('varlist')'
 *
 */
void rdstmt (void)
{
	if (lookahead == Read)
		match (Read);
	else
		match (Readln);
	match ('(');
	varlist ();
	match (')');
	/* */
	printf ("\t<Read[ln]>\n");
}

/*
 * assgnm -> var ":=" expr
 *
 */
void assgnm (void)
{
	var ();
	match (ASGN);
	expr ();
	/* */lvalue(var_name);
}

/*
 * var -> ID
 *
 */
void var (void)
{
	strcpy (var_name, lexeme);
	match (ID);
}

/*
 * expr -> laexp ( relop laexp )?
 *
 */
void expr (void)
{
	laexp ();
	if (isrelop (lookahead))
	{
		relop ();
		laexp ();
	}
}

isrelop (token_t operator)
{
	switch (operator)
	{
		case '>':
			return 1;
		case GEQ:
			return 2;
		case '=':
			return 3;
		case LEQ:
			return 4;
		case '<':
			return 5;
		case NEQ:
			return 6;
		default:
			return 0;
	}
}

ismulop (token_t operator)
{
	switch (operator)
	{
		case '*':
			return 1;
		case '/':
			return 2;
		case Div:
			return 3;
		case Mod:
			return 4;
		case And:
			return 5;
		case Xor:
			return 6;
		default:
			return 0;
	}
}

isaddop (token_t operator)
{
	switch (operator)
	{
		case '+':
			return 1;
		case '-':
			return 2;
		case Or:
			return 3;
		default:
			return 0;
	}
}

/*
 * relop -> '>' | ">=" | '=' | "<=" | '<' | "<>"
 *
 */
void relop (void)
{
	switch (lookahead)
	{
		case '>':
		case GEQ:
		case '=':
		case LEQ:
		case '<':
			match (lookahead);
			break;
		default:
			match (NEQ);
	}
}

/*
 * laexp -> unary term ( addop term )*
 *
 */

void laexp (void)
{
	token_t opcode;
	/* */ opcode = unary ();
	term ();
	/* */ negate (opcode);
	while (opcode = isaddop (lookahead))
	{
		match (lookahead);
		term ();
		/* */ addpostfix(opcode);
	}
	/* */ pop();
}

/*
 * unary -> '-' | Not | empty
 *
 */
unary (void)
{
token_t unary_oper;
	switch (lookahead)
	{
		case '-':
			unary_oper = 1;
			match (lookahead);
			return 1;
			break;
		case Not:
			unary_oper = 2;
			match (lookahead);
			break;
		default:
			unary_oper = 0;
	}
	return unary_oper;
}

/*
 * addop -> '+' | '-' | Or
 *
 */
void addop (void)
{
	switch (lookahead)
	{
		case '+':
		case '-':
			match (lookahead);
			break;
		default:
			match (Or);
	}
}

/*
 * term -> fact ( mulop fact )*
 *
 */
void term (void)
{
	token_t opcode;
	fact ();
	/* */ push();
	while (opcode = ismulop (lookahead))
	{
		match (lookahead);
		fact ();
		/* */ mulposfix(opcode);
	}
	/* */ decstack();
}

/*
 * fact -> var | ct | '('expr')'
 *
 */
void fact (void)
{
	switch (lookahead)
	{
		case ID:
			/* */rvalue (lexeme, 1);
			var ();
			break;
		case ZERO:
		case UINT:
		case BOOL:
		case STR:
			ct ();
			break;
		default:
			match ('(');
			expr ();
			match (')');
	}
}

/*
 * ct -> ZERO | UINT | BOOL | STR
 *
 */
void ct (void)
{
	switch (lookahead)
	{
		case ZERO:
		case UINT:
			/* */rvalue (lexeme, 0);
			match (lookahead);
			break;
		case BOOL:
			match (lookahead);
			break;
		default:
			match (STR);
	}
}
