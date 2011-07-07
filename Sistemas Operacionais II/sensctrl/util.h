/******************************************************************************
 * sensctrl - C                                                               *
 * Exemplo de utilização de memória compartilhada e semáforos                 *
 ******************************************************************************
 * Autor: Juliano F. Ravasi                                                   *
 * Sistemas Operacionais II - Bacharelado em Ciência da Computação            *
 * Universidade Estadual Paulista, UNESP - Rio Claro                          *
 ******************************************************************************/

#ifndef UTIL_H
#define UTIL_H

#include <stdarg.h>

void verror(const char *msg, va_list args);
void error(const char *msg, ...);
void fatal(const char *msg, ...);

char * chop(char *str);

#define MIN(a, b) ((b) < (a) ? (b) : (a))
#define MAX(a, b) ((b) > (a) ? (b) : (a))

#endif
