//uname.c

//no windows a variavel de ambiente e "OS"

#include <stdio.h>


int main( )
{
   FILE *arquivo1;
    char caracter;

    arquivo1=fopen("/etc/motd", "r");
    
    caracter=getc(arquivo1);
    
    while(caracter != EOF)
    {
	putchar(caracter);
	caracter=getc(arquivo1);
    }
    
    fclose(arquivo1);

    return 0;
}
