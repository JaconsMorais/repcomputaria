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
 //useradd.c

#include "../vish.h"

int verifica_usuario(char *nome);
int adicionar_usuario(char *usuario);

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
	printf("Uso: %s <nome_usuario>\n", argv[0]);
	exit(1);
    }
    
    verifica_usuario(argv[1]);
    adicionar_usuario(argv[1]);

}

int adicionar_usuario(char *usuario)
{
    FILE *arquivo;
    arquivo=fopen(PASS_PATH, "a+");

    if(arquivo==NULL)
    {
	printf("erro ao adicionar usuario\n");
	exit(1);
    }
    
    Useradd novo;
    strcpy(novo.user, usuario);
    strcpy(novo.home, "/home/");
    strcat(novo.home, novo.user);
    novo.bloqueado=0;
    printf("Nome para usuario  [%s]: ", novo.user); scanf("%s", novo.nome);
    printf("Senha para usuario [%s]: ", novo.user); scanf("%s", novo.senha);
    fwrite(&novo, sizeof(Useradd), 1, arquivo);
    fclose(arquivo);
}

int verifica_usuario(char *nome)
{
    Useradd verifica;
    FILE *arquivo;
    arquivo=fopen(PASS_PATH, "r");
    
    if(arquivo==NULL)
    {
	printf("erro ao adicionar usuario\n");
	exit(1);
    }
    rewind(arquivo);
    while(!feof(arquivo))
    {
	fread(&verifica, sizeof(Useradd), 1, arquivo);
	if(strcmp(verifica.user,nome)==0)
	{
	    printf("\nO sistema já possui um usuario com este nome\n\n");
	    fclose(arquivo);
	    exit(0);
	}
    }
    fclose(arquivo);
}

