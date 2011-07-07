#include "bctokens.h"

int isvar(void);
int iscte(void);
int ismulop(void);
int isaddop(void);
void skipspaces(void);
int gettoken(void);
extern int lookahead;
void match(int needed);

