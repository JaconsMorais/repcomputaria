void jmpfalse (int label);
void jmp(int label);
void mklabel (int label);
extern int unary_oper;
void negate(int);
extern char var_name[];
void lvalue(char const *lexeme);
void rvalue(char const *lexeme, int flag);
