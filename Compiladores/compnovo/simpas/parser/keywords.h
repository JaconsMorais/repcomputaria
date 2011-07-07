#include "ltypes.h"

/*lista de palavras reservadas*/
enum
{
  BEGIN = 1025,
  PROGRAM,
  IF,
  THEN,
  ELSE,
  WHILE,
  DO,
  FOR,
  TO,
  DOWNTO,
  REPEAT,
  UNTIL,
  CASE,
  OF,
  VAR,
  PROCEDURE,
  FUNCTION,
  CONST,
  TYPE,
  ARRAY,
  INTEGER,
  CHAR,
  STRING,
  REAL,
  DOUBLE,
  BOOLEAN,
  DIV,
  MOD,
  AND,
  OR,
  NOT,
  IN,
  END
};

/*métodos*/
token_t iskeyword(char *word);
