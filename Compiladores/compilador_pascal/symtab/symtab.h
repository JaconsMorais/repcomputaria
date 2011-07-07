#define MAXSTRLEN 32

/*registro da tabela de s�mbolos*/
typedef struct _symbol_ {
	char lexeme[MAXSTRLEN];
	char asmoff[MAXSTRLEN];
	int objtype;
	int valtype;
	int lexlvl;
	int pad[1024];
} SYMBOL;

/*n�mero de elementos na tabela*/
#define MAXSYMTABENTRIES 0x10000

/*m�todos*/
extern SYMBOL symtab[];

extern int symtab_nextentry;

extern int symtab_lookup(char const *symbol);

extern int symtab_add(char const *symbol);
