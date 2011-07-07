
#include "../symtab/symtab.h"

/*variáveis e métodos necessários para a leitura do arquivo Pascal,através
*de tokens e lexemas*/
extern char lexeme[];
extern token_t lookahead;
extern void match(token_t expected);

/*métodos*/
void prog (void);
void header (void);
void progid (void);
void declscope (void);
void vari_def (void);
void vartype (void);
void range (void);
void constdef (void);
void procedef (void);
void functdef (void);
void formparm (void);
void parm (void);
void procscope (void);
void beginblock (void);
void stmt (void);
void ifstmt (void);
void expr (void);
void expla (void);
void term (void);
void fact (void);
void idxsynt (void);
void exprlist (void);
void whlstmt (void);
void repstmt (void);
void forstmt (void);
void assgstm (void);
void casestmt (void);
void listaop (void);
void rettype (void);
void type_def (void);

