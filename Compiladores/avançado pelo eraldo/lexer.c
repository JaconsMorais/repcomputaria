#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#include <lexer.h>
#include <tokens.h>

token_t lookahead;

char lexeme[MAXSTRLEN];

size_t linecount = 1;

token_t
gettoken (FILE * src)
{
skipcomments:
skipspaces:
  while (isspace (lexeme[0] = getc (src)))
    if (lexeme[0] == '\n')
      linecount++;
matchidentifier:
  if (isalpha (lexeme[0]))
    {
      int i = 1;
      token_t token;
      while (isalnum (lexeme[i] = getc (src)))
	i++;
      ungetc (lexeme[i], src);
      lexeme[i] = 0;
      if (token = iskeyword (lexeme))
	return token;
	/*
      if (token = isbool (lexeme))
	return BOOL;
	*/
      return ID;
    }
matchuint:
  if(isdigit(lexeme[0])){
	  if(lexeme[0]=='0'){
		  lexeme[1] = 0;
		  return ZERO;
	  }
	  else {
		  int i = 1;
		  while(isdigit(lexeme[i]=getc(src)))i++;
		  ungetc(lexeme[i],src);
		  lexeme[i] = 0;
		  return UINT;
	  }
  }
matchstr:
  if (lexeme[0] == '\'')
    {
      int i;
      for (i = 1; (lexeme[i] = getc (src)) != '\''
	   && lexeme[i] != '\n' && lexeme[i] != -1; i++);
      if (lexeme[i] == '\'')
	{
	  lexeme[i + 1] = 0;
	  return STR;
	}
      fprintf (stderr,
	       "unmatched left quote in string field at line %d\n",
	       linecount);
      exit (-1);
    }
def:
  switch (lexeme[0])
    {
    case '>':
      if ((lexeme[1] = getc (src)) == '=')
	{
	  lexeme[2] = 0;
	  return GEQ;
	}
      ungetc (lexeme[1], src);
      break;
    case '<':
      if ((lexeme[1] = getc (src)) == '=')
	{
	  lexeme[2] = 0;
	  return LEQ;
	}
      else if (lexeme[1] == '>')
	{
	  lexeme[2] = 0;
	  return NEQ;
	}
      ungetc (lexeme[1], src);
      break;
    case ':':
      if ((lexeme[1] = getc (src)) == '=')
	{
	  lexeme[2] = 0;
	  return ASGN;
	}
      ungetc (lexeme[1], src);
      break;
    }
  lexeme[1] = 0;
  return lexeme[0];
}

void match(token_t expected){
	if (lookahead == expected) {
		lookahead = gettoken(stdin);
	}else{
		fprintf(stderr,"deu pau com \"%s\" na linha %d\n", lexeme, linecount);
		exit (-1);
	}
}
