/* programa que copia arquivo */

#include <stdio.h>


int main(int argc, char *argv[])
{
    char caracter;
    int i;
    FILE *arquivo1;
    FILE *arquivo2[argc];

    if(argc < 3)
    {
	printf("Uso: %s <arquivo_origem> <arquivo_destino>\n", argv[0]);
	exit(1);
    }
    
    for(i=2; i<argc; i++)
    {
        arquivo1=fopen(argv[1], "r");
        arquivo2[i]=fopen(argv[i], "w");

        if(arquivo1 != arquivo2[i])
        {
            while((caracter=fgetc(arquivo1)) != EOF)
            {
                fputc(caracter, arquivo2[i]);
            }
        }
        
        fclose(arquivo1);
        fclose(arquivo2[i]);
    }

    return(0);
}

