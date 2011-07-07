# ------------------------- Sistemas Operacionais II -------------------------
# Bacharelado em Ciências da Computação
# DEMAC/IGCE/UNESP Rio Claro - 2010
# ----------------------------------------------------------------------------
# Arquivo Makefile padrão -- Juliano F. Ravasi - 2010-03-26
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Projeto/Tarefa:
# Aluno/Grupo:
# Data:
# ----------------------------------------------------------------------------

# Compiladores de C e C++.
CC = gcc
CXX = g++

# Parâmetros adicionais para os compiladores de C e C++.
#   -g              Inclui informações de debug.
#   -Wall           Habilita todos as advertências.
#   -std=gnu99      Utiliza a versão mais nova da linguagem C.
#   -std=gnu++0x    Utiliza a versão mais nova da linguagem C++.
CFLAGS = -g -Wall -std=gnu99
CXXFLAGS = -g -Wall -std=gnu++0x

# Parâmetros adicionais para a link-edição.
#   Bibliotecas extras devem ser listadas aqui (ex: -lm).
LDFLAGS = 

# Lista de programas (binários) a serem compilados.
BINARIES = shell

# Regra padrão (quando make utilizado sem argumentos).
default: $(BINARIES)

# Dependências dos programas do projeto, no formato:
#   <binário>: <obj1> <obj2>...
shell: shell.o lexer.o parser.o

# Limpeza.
clean:
	rm -f $(BINARIES) *.o
	rm -f Makefile.dep

# Gera automaticamente as dependências entre arquivos de código fonte.
Makefile.dep: *.[ch]
	$(CC) $(CFLAGS) -MM *.c > $@

-include Makefile.dep
