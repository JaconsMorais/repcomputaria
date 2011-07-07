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
 //rm.c

#include <stdio.h>

void uso(char *nome)
{
    printf("Poucos argumento, use:\n");
    printf("%s <arquivo1> <arquivo2> <arquivo3> [...]\n", nome);
}

int main(int argc, char *argv[])
{
    int argumentos;
    char opcao;

    if(argc < 2)
    {
    	uso(argv[0]);
	exit(1);
    }

    printf("\n\nDeseja realmente apagar o(s) arquivo(s) ? ");
    opcao=getchar();

    switch(opcao)
    {
	case 's':
	    for(argumentos=1; argumentos < argc; argumentos++)
		remove(argv[argumentos]);
		break;

	case 'n':
	    exit(1);

	default:
	    printf("Opcao invalida\n");
    }
    
}

