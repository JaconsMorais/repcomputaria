CFLAGS=-g -I../symtab -I.
LDFLAGS=-g

codelist=\
keywords.c\
lexer.c\
parser.c\
simpas.c\
../symtab/symtab.c

objlist=\
keywords.o\
lexer.o\
parser.o\
simpas.o\
../symtab/symtab.o

simpas: $(objlist)
	$(CC) $(LDFLAGS) -o $@ $^
clean:
	$(RM) $(objlist)
