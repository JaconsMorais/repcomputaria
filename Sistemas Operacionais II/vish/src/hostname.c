//hostname.c

#include <stdio.h>

int main( )
{
    printf("Nome do Host: %s\n",getenv("HOSTNAME"));
    return 0;
}
