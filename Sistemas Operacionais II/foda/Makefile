

        1  # ------------------------- Sistemas Operacionais II -------------------------

        2 # Bacharelado em Ciências da Computação

        3 # DEMAC/IGCE/UNESP Rio Claro - 2010

        4 # ----------------------------------------------------------------------------

        5 # Arquivo Makefile padrão -- Juliano F. Ravasi - 2010-03-26

        6 # ----------------------------------------------------------------------------

        7 

        8 # ----------------------------------------------------------------------------

        9 # Projeto/Tarefa: Shell

       10 # Aluno/Grupo: Andre Q. sobral / Geovanne B. Bertonha / Jose Michel Fogaca

       11 # Data:30/03/2010

       12 # ----------------------------------------------------------------------------

       13 

       14 # Compiladores de C e C++.

       15 CC = gcc

       16 CXX = g++

       17 

       18 # Parâmetros adicionais para os compiladores de C e C++.

       19 #   -g              Inclui informações de debug.

       20 #   -Wall           Habilita todos as advertências.

       21 #   -std=gnu99      Utiliza a versão mais nova da linguagem C.

       22 #   -std=gnu++0x    Utiliza a versão mais nova da linguagem C++.

       23 CFLAGS = -g -Wall -std=gnu99

       24 CXXFLAGS = -g -Wall -std=gnu++0x

       25 

       26 # Parâmetros adicionais para a link-edição.

       27 #   Bibliotecas extras devem ser listadas aqui (ex: -lm).

       28 LDFLAGS = lexer.h parser.h

       29 

       30 # Lista de programas (binários) a serem compilados.

       31 BINARIES = shell

       32 

       33 # Regra padrão (quando make utilizado sem argumentos).

       34 default: $(BINARIES)

       35 

       36 # Dependências dos programas do projeto, no formato:

       37 #   <binário>: <obj1> <obj2>...

       38 lexer: lexer.o

       39 parser: parser.o lexer.o

       40 shell: shell.o parser.o lexer.o	

       41 # Limpeza.

       42 clean:

       43 	rm -f $(BINARIES) *.o

       44 	rm -f Makefile.dep

       45 

       46 # Gera automaticamente as dependências entre arquivos de código fonte.

       47 Makefile.dep: *.[ch]

       48 	$(CC) $(CFLAGS) -MM *.c > $@

       49 

       50 -include Makefile.dep


