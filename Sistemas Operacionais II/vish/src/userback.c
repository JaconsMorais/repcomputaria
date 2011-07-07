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
 //userback.c
#include "../vish.h"


int mostrar();
int main(int argc, char *argv[])
{
    FILE *arquivo;
    Useradd block;
    int registro=0;
    
    arquivo=fopen(PASS_PATH, "r+");
    if(arquivo==NULL)
    {
	printf("Erro ao bloquear usuario\n");
	exit(1);
    }

    if (argc < 2)
    {
	printf("Use: %s <usuario>\n", argv[0]);
	exit(0);
    }

    while(fread(&block, sizeof(Useradd), 1, arquivo))
    {
	if(strcmp(block.user, argv[1])==0)
	{
	    block.bloqueado=0;
	    registro=ftell(arquivo);
	    fseek(arquivo, registro-sizeof(Useradd), SEEK_SET);
	    fwrite(&block, sizeof(Useradd), 1, arquivo);
	}
    
    }
    /*mostrar();*/
}


int mostrar()
{
    Useradd mostrar;
    FILE *arquivo;
    arquivo=fopen(PASS_PATH, "r");
    
    rewind(arquivo);
    while(!feof(arquivo))
    {
	fread(&mostrar, sizeof(Useradd), 1, arquivo);
	printf("NOME: %s\n", mostrar.nome);
	printf("PASS: %s\n", mostrar.senha);
	printf("USER: %s\n", mostrar.user);
	printf("HOME: %s\n", mostrar.home);
	printf("BLOQ: %d\n", mostrar.bloqueado);
	printf("\n\n");
    }
    fclose(arquivo);
}
