#include "oshell.h"
#include "parser.h"
#include "lexer.h"

int i;

void statement(int argc, char **argv){
  i = 0;
  pipeline(i); //começa a ver o pipeline
  com->argc = argc;
  com->argv = argv;
  if (lookahead == T_EOL) {
    return;
  }
  match(T_EOL);
}

void pipeline(int p)
{  
  command();

  if (lookahead == T_PIPE){
    match(T_PIPE);
    i++;
    pipeline(i);
  }else run_pipe(com,i,i); //roda o pipeline
}

void command(void){ //verificação do comando
  char *arquivo;
 
  do {
   argument();
  }while (lookahead == T_ARGUMENT);

  if (lookahead == T_INPUT || lookahead == T_OUTPUT){ //redirecionamento de arquivo
     if (lookahead == T_INPUT){ //interno
	match(T_INPUT);
	arquivo = file(); //verificação de arquivo
	redir(arquivo,STDIN_FILENO); //redirecionamento
     }
     if(lookahead == T_OUTPUT){ //externo
	match(T_OUTPUT);
	arquivo = file(); //verificação de arquivo
	redir(arquivo,STDOUT_FILENO); //redirecionamento
     }
  }
}

char *file(void){ //verificação de arquivo
  return argument();
}

char *argument(void){ //argumento
  return match(T_ARGUMENT);
} 
