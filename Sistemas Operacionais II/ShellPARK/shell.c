#include "lexer.h"
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  lookahead  =get_token();

  for (;;){
    statement();
    printf("ok\n");
  }
  return 0;
} 




  token_t token;

  while (token = get_token(), token != EOL){
    print("Token: %c (%d)\n", token, token);

    if token = argument{
     printf("ARGUMENT: %s", argument);
    }  	
  }
  return 0;
}


