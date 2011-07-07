#include <stdio.h>

int main(int argc, char *argv[])
{
    int retorno;
    int i;
    
    if( argc < 2 )
    {
	printf("\nUso: %s <pasta>\n\n", argv[0]);
	exit(1);
    }
    
    for(i=1; i<argc; i++)
    {
        retorno=rmdir(argv[i]);

        if(retorno != 0)
    	   printf("Nao foi possivel remover o diretorio %s\n",argv[i]);
    
        else
            printf("O diretorio %s foi removido com sucesso\n",argv[i]);
        
    }

    return 0;
}
