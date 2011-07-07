#include "parser.h"
#include "lexer.h"

void statement(void)
{
  pipeline();
  if (lookahead == T_EOL) {
    return;
  }
  match(T_EOL);
}

void pipeline(void)
{
  command();

  if (lookahead = T_PIPE){
    match(T_PIPE);
    pipeline();
  }
}

void command(void){
  do {
   argument();
  }while (lookahead == T_ARGUMENT);

  if (lookahead == T_INPUT || lookahead == T_OUTPUT){
     if (lookahead == T_INPUT) match(T_INPUT);
     if(lookahead == T_OUTPUT) match(T_OUTPUT);
     file();
  }
}

void file(void){
  argument();
}

void argument(void){
  match(T_ARGUMENT);
} 

