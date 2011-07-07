/***************************************************************************
 *   Copyright (C)  Guilherme Carneiro                                     *
 *   Copyright (C)  Fabio Curtis Volpe                                     *
 *   Copyright (C)  Nelson Leandro Merloto                                 *
 *   Copyright (C)  Thiago Sanches de Moraes                               *
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
 //last.c

#include "../vish.h"

int main(int argc, char *argv[])
{
    FILE *arquivo;
    char ch;
    
    arquivo=fopen(LAST_ARQ_PATH, "r");
    if(arquivo==NULL)
    {
	printf("Erro obtendo informacoes sobre o acesso ao sistema\n");
	exit(1);
    }

    ch=getc(arquivo);

    while(ch != EOF)
    {
	putchar(ch);
	ch=getc(arquivo);
    }
    
    fclose(arquivo);
    return(0);
}

