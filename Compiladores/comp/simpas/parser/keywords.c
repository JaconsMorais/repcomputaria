#include <keywords.h>

char *keyword[] = {
  "BEGIN",
  "PROGRAM",
  "IF",
  "THEN",
  "ELSE",
  "WHILE",
  "DO",
  "FOR",
  "TO",
  "DOWNTO",
  "REPEAT",
  "UNTIL",
  "CASE",
  "OF",
  "VAR",
  "PROCEDURE",
  "FUNCTION",
  "CONST",
  "TYPE",
  "ARRAY",
  "INTEGER",
  "CHAR",
  "STRING",
  "REAL",
  "DOUBLE",
  "BOOLEAN",
  "DIV",
  "MOD",
  "AND",
  "OR",
  "NOT",
  "IN",
  "END"
};

token_t
iskeyword (char *word)
{
  token_t i;
  int nk = END - BEGIN + 1;
  for (i = 0; i < nk; i++)
    {
      if (strcmp (word, keyword[i]) == 0)
	return BEGIN + i;
    }
  return 0;
}
