#include <stdio.h>

void jmpfalse (int label){
	printf("\tjz .L%i\n", label);
}
void jmp(int label){
	printf("\tjmp .L%i\n", label);
}
void mklabel (int label){
	printf(".L%i:\n", label);
}
void push(void){
	printf("\tpush %%eax\n");
}
void pop(void){
	printf("\tpop %%eax\n");
}
void negate(int unary_oper){
	switch (unary_oper){
		case 1: printf("\tneg %%eax\n");break;
		case 2: printf("\tnot %%eax\n");break;
		default: ;
	}
	printf("\tpush %%eax\n");
}
void addpostfix(int opcode){
	switch(opcode){
		case 1:
			printf("\tadd %%eax, (%%esp)\n");
			break;
		case 2:
			printf("\tsub %%eax, (%%esp)\n");
			break;
	}
}
void rvalue(char const *lexeme, int flag){
	switch (flag){
		case 1:
			printf("\tmov %s, %%eax\n", lexeme);break;
		case 0:
			printf("\tmov $0x%x, %%eax\n",atoi(lexeme));break;
	}
}
char var_name[32];
void lvalue(char const *lexeme)
{
	printf("\tmov %%eax, %s\n", lexeme);
}
void mulposfix(int opcode){
	switch(opcode){
		case 1:
			printf("\timul (%%esp)\n");
			printf("\tmov %%eax, (%%esp)\n");
			break;
		case 2:
			printf("\tmov %%eax, -4(%%esp)\n");
			printf("\tmov (%%esp), %%eax\n");
			printf("\tcltd\n");
			printf("\tidiv -4(%%esp)\n");
			printf("\tmov %%eax, (%%esp)\n");
			break;
	}
}
void decstack(void){
	printf("\tadd $4, %%esp\n");
}
