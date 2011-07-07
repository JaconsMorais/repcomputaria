/***************************************************************************
 *   Copyright (C)  Thiago Sanches de Moraes                               *
 *   Copyright (C)  Fabio Curtis Volpe                                     *
 *   Copyright (C)  Nelson Leandro Merloto                                 *
 *   Copyright (C)  Guilherme Carneiro                                     *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 ***************************************************************************/
 //cat.c

#include <stdio.h>

void uso(char *nome)
{
    printf("Poucos argumento, use:\n");
    printf("%s <arquivo_1> <arquivo_2> ... <arquivo_n>\n", nome);
}

int main(int argc, char *argv[])
{
    char caractere;
    int argumentos;
    FILE *arquivo;

    if(argc < 2) 
    {
    	uso(argv[0]);
	exit(1);
    }    

    /*para cada arquivo passado por parametro, arq1, arq2 etc...
      o arquivo é aberto, e seu conteudo é lido até que seja
      final de arquivo */
    for(argumentos=1; argumentos < argc; argumentos++)
    {
	arquivo=fopen(argv[argumentos], "r");	
	
	if(arquivo==NULL)
	{
	    printf("\n-->ERRO AO ABRIR O ARQUIVO: %s\n\n", argv[argumentos]);
    	    continue;
	}    	
	
	caractere=getc(arquivo);
	printf("\n-->CONTEUDO DO ARQUIVO: %s\n", argv[argumentos]);
	
	while(caractere != EOF)
	{
	    putchar(caractere);
	    caractere=getc(arquivo);
	}
	fclose(arquivo);
    }
}
