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
 //userdel.c
#include "../vish.h"

int main(int argc, char *argv[])
{
    Useradd deletar;
    FILE *arquivo;
    FILE *arquivo_destino;
    arquivo=fopen(PASS_PATH, "a+");
    arquivo_destino=fopen(NEWPASS_PATH, "a+");
    
    if(arquivo==NULL)
    {
	printf("erro ao deletar usuario\n");
	exit(1);
    }
    
    if(argc < 2)
    {
	printf("Use: %s <usuario>\n", argv[0]);
	exit(1);
    }
    
    rewind(arquivo);
    while(!feof(arquivo))
    {
	fread(&deletar, sizeof(Useradd), 1, arquivo);
	if(strcmp(deletar.user, argv[1])==0)
	{
	    continue;
	}
	else
	{
	    fwrite(&deletar, sizeof(Useradd), 1, arquivo_destino);
	}
    }
    rename(NEWPASS_PATH, PASS_PATH);
    fclose(arquivo);
    fclose(arquivo_destino);

}



