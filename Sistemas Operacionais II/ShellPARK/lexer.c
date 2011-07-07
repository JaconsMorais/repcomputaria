#include "lexer.h"
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>

bool isargchar(int ch)
{
  return ch != 0
      && ch != ' '
      && ch != '|'
      && ch != '>'
      && ch != '\n'; 
}

token_t get_token(void)
{
  for (;;){
      int ch = fgetc(stdin);

      if (ch == '|'){
         return T_PIPE;
      }
      else if (ch == '>'){
         return T_OUTPUT;
      }
      else if (ch == '\n'){
         return T_EOL;
      }
      else if (isspace(ch)){
         continue;
     }	 
     else{
	 int i = 0;
         do{
            argument[i++] = ch;
            while (ch = fgetc(stdin), isargchar(ch));
            argument[i] = 0;
            ungetc(ch, stdin);
            return T_ARGUMENT;
         }
     }
  }
void match(token_t expected)
{
  if (expected != lookahead){
     fprintf(stderr, "Expected: %c, found: %c\n" )
     exit(1); 
  }
  lookahead = get_token();  
}
