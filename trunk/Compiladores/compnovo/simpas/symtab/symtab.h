#define MAXSTRLEN 32

/*registro da tabela de símbolos*/
typedef struct _symbol_ {
	char lexeme[MAXSTRLEN];
	char asmoff[MAXSTRLEN];
	int objtype;
	int valtype;
	int lexlvl;
	int pad[1024];
} SYMBOL;

/*número de elementos na tabela*/
#define MAXSYMTABENTRIES 0x10000

/*métodos*/
extern SYMBOL symtab[];

extern int symtab_nextentry;

extern int symtab_lookup(char const *symbol);

extern int symtab_add(char const *symbol);
