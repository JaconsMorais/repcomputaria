#include <string.h>

#include <symtab.h>

#define MAXDESCRIPTORS 10000
#define MAXSTREAMLEN 80000

extern char symstream[MAXSTREAMLEN];

extern int symstream_available;

extern int symtab[MAXDESCRIPTORS][];

extern int symtab_available;

int symtab_insert (char const * symb);

int symtab_lookup (char const *key);

int symtab_delete (void);

