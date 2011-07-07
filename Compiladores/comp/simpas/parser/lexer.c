#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <lexer.h>

#define MAXIDLEN 32

size_t linecount = 1;

char lexeme[MAXIDLEN];
token_t lookahead;

/* automata */
token_t
isidentifier (FILE * tape)
{
  if (isalpha (lexeme[0] = toupper (getc (tape))))
    {
      token_t token;
      int i = 1;
      while (isalnum (lexeme[i] = toupper (getc (tape))) || lexeme[i] == '_')
	if (i < MAXIDLEN - 1)
	  {
	    i++;
	  }
      ungetc (lexeme[i], tape);
      lexeme[i] = 0;
      if (token = iskeyword (lexeme))
	return token;
      return ID;
    }
  ungetc (lexeme[0], tape);
  return 0;
}

token_t
isassgnmt (FILE * tape)
{
  char head = getc (tape);
  if (head == ':')
    {
      if ((head = getc (tape)) == '=')
	{
	  strcpy (lexeme, ":=");
	  return ASGNM;
	}
      ungetc (head, tape);
      ungetc (':', tape);
    }
  else
    {
      ungetc (head, tape);
    }
  return 0;
}

token_t
isrange (FILE * tape)
{
  char head = getc (tape);
  if (head == '.')
    {
      if ((head = getc (tape)) == '.')
	{
	  strcpy (lexeme, "..");
	  return DDOT;
	}
      ungetc (head, tape);
      ungetc ('.', tape);
    }
  else
    {
      ungetc (head, tape);
    }
  return 0;
}

token_t
isintcte (FILE * tape)
{
  lexeme[0] = toupper (getc (tape));
  int i = 1;
  if (isdigit (lexeme[0]))
    {
      if (lexeme[0] != 0)
	{
	  while (isdigit (lexeme[i] = toupper (getc (tape))))
	    i++;
	  ungetc (lexeme[i], tape);
	  lexeme[i] = 0;
	  return INTCTE;
	}
      else if (lexeme[0] == 0)
	return INTCTE;
    }
  ungetc (lexeme[0], tape);
  return 0;
}

token_t
isrelop (FILE * tape)
{
  char head = getc (tape);
  switch (head)
    {
    case '<':
      if ((head = getc (tape)) == '=')
	{
	  strcpy (lexeme, "<=");
	  return RELOP;
	}
      else if (head == '>')
	{
	  strcpy (lexeme, "<>");
	  return RELOP;
	}
      ungetc (head, tape);
      strcpy (lexeme, "<");
      return RELOP;
    case '>':
      if ((head = getc (tape)) == '=')
	{
	  strcpy (lexeme, ">=");
	  return RELOP;
	}
      ungetc (head, tape);
      strcpy (lexeme, ">");
      return RELOP;
    case '=':
      strcpy (lexeme, "=");
      return RELOP;
    default:
      ungetc (head, tape);
    }
  return 0;
}

/* lexer */

/* ignora espaços em branco e comentários */
void
skipall (FILE * tape)
{
  char head;
  while (isspace (head = getc (tape)) || head == '{')
    {
      if (head == '\n')
	linecount++;
      if (head == '{')
	{
	  while ((head = getc (tape)) != '}');
	}
      else if (isspace (head))
	{
	  while (isspace (head = getc (tape)));
	  ungetc (head, tape);
	}
    }
  ungetc (head, tape);
}

token_t
gettoken (FILE * buffer)
{
  token_t token;
  skipall (buffer);
  if (token = isidentifier (buffer))
    return token;
  if (token = isassgnmt (buffer))
    return token;
  if (token = isrange (buffer))
    return token;
  if (token = isintcte (buffer))
    return token;
  if (token = isrelop (buffer))
    return token;
  lexeme[1] = 0;
  return lexeme[0] = getc (buffer);
}

void
match (token_t expected)
{
  if (lookahead == expected)
    {
      lookahead = gettoken (stdin);
    }
  else
    {
      fprintf (stderr, "parser: token mismatch at line %d: %s\nexiting\n",
	       linecount, lexeme);
      exit (-1);
    }
}
