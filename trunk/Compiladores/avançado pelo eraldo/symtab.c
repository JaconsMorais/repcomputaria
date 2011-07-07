#include <string.h>

#include <symtab.h>

#define MAXDESCRIPTORS 10000
#define MAXSTREAMLEN 80000

char symstream[MAXSTREAMLEN];

int symstream_available = 0;

int symtab[MAXDESCRIPTORS][2];

int symtab_available = 0;

symtab_insert (char const * symb) {
	int symstream_next = strlen (symb) + 1 + symstream_available;
	if(symtab_available == MAXDESCRIPTORS) return -1;
	if(symstream_next > MAXSTREAMLEN) return -2;
	symtab[symtab_available][0] = symstream_available;
	strcpy (symstream + symstream_available, symb);
	symstream_available = symstream_next;
	symtab_available++;
	return 0;
}

symtab_lookup (char const *key) {
	int i;
	for (i = symtab_available - 1; i > -1; i--) {
		if (strcmp(symstream + symtab[i][0], key) == 0)
			return i;
	}
	return -1;
}

symtab_delete (void) {
}

