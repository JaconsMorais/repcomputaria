#include <string.h>
#include <keywords.h>
#include <lexer.h>

char *keyword[] = {
  "Begin",
  "Program",
  "If",
  "Then",
  "Else",
  "While",
  "Do",
  "For",
  "To",
  "Downto",
  "Repeat",
  "Until",
  "Var",
  "Integer",
  "Boolean",
  "String",
  "And",
  "Or",
  "Xor",
  "Div",
  "Mod",
  "Not",
  "Write",
  "Writeln",
  "Read",
  "Readln",
  "End",
};

token_t
iskeyword (char const *symbol)
{
  int k;
  for (k = Begin; k <= End; k++)
    {
      int i, j = k - Begin;
      for (i = 0; tolower (symbol[i]) == tolower (keyword[j][i]) && symbol[i];
	   i++);
      if (i == strlen (keyword[j]))
	return k;
    }
  return 0;
}
