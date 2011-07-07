CC = gcc
CFLAGS = -g -Wall -std=gnu99
LDFLAGS = 

# Primeira regra do arquivo é usada quando digitamos
# make sem nenhum argumento.
default: oshell

oshell: oshell.o

Makefile.dep: *.c *.h
	$(CC) $(CFLAGS) -MM *.c > $@

-include Makefile.dep

clean:
	rm -f fork Makefile.dep *.o

