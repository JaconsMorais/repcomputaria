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
 //vish.c

#include "vish.h"

int main(int argc, char *argv[])
{
    Useradd login;
    int retorno;
    char *comando=(char *) malloc(sizeof(char));
    char *p1, *p2;
    char nome[MAX];
    char senha[MAX];
    FILE *passwd;

    login:
    printf("\e[H\e[2J");
    printf("\n\n");
    printf("login:  "); gets(nome);
    printf("passwd: "); gets(senha);
    passwd=fopen(PASS_PATH, "r");
    
    rewind(passwd);
    while(!feof(passwd))
    {
	fread(&login, sizeof(Useradd), 1, passwd);
	if( strcmp(login.user, nome) == 0 && strcmp(login.senha,senha) == 0 && login.bloqueado==0)
	{
		if(strcmp(login.user, "root") != 0)
	        {
		    suid=500;
	    	    goto shell;
		}
		else
		{
		    suid=0;
		    goto shell;
		}
	}
    }
    goto login;
    
    shell:
    mtod();
    while(1)
    {
	//fclose(passwd);
	if(suid==0)
	    printf("[>]# "); 
	
	else
	    printf("[>]$ ");
	
	gets(comando);
	p1=strtok(comando, " ");
	p2=strtok(NULL, "#");
    	
	comando_vish[0]=p1;
	comando_vish[1]=p2;
	
	/*funcao execve exige que o ultimo valor seja NULL*/
	comando_vish[2]=NULL; 

	if(strcmp(p1, "cat")==0)
	{
	    executa_processo(CAT_PATH);	    
	}
	else if(strcmp(p1, "exit")==0) 
	{
	    comando_exit(login.user);
	    goto login;
	}
	else if(strcmp(p1, "clear")==0)
	{
	    printf("\e[H\e[2J");
	}
	
	else if(strcmp(p1, "creditos")==0)
	{
	    executa_processo(CREDITO_PATH);
	}
	
	else if(strcmp(p1, "last")==0)
	{
	    executa_processo(LAST_PATH);
	}
	
	else if(strcmp(p1, "logout")==0)
	{
	    logout(login.user);
	    goto login;
	}
	
	else if(strcmp(p1, "mv")==0)
	{
	    executa_processo(MV_PATH);
	}
	
	else if(strcmp(p1, "rm")==0)
	{
	    executa_processo(RM_PATH);
	}
	
	else if(strcmp(p1, "edit")==0)
	{
	    executa_processo(EDIT_PATH);
	}
	else if(strcmp(p1, "useradd")==0 && suid == 0 )
	{
	    executa_processo(USERADD_PATH);
	}
	else if(strcmp(p1, "userdel")==0 && suid == 0 )
	{
	    executa_processo(USERDEL_PATH);
	}
	else if(strcmp(p1, "userblock")==0 && suid == 0)
	{
	    executa_processo(USERBLK_PATH);
	}
	else if(strcmp(p1, "whoami")==0)
	{
	    printf("%s\n", login.user);
	}
	else if(strcmp(p1, "pwd")==0)
	{
	    executa_processo(PWD_PATH);
	}
	else if(strcmp(p1, "log")==0)
	{
	    executa_processo(LOG_EXEC_PATH);
	}
	else if(strcmp(p1, "date")==0)
	{
	    executa_processo(DATE_PATH);
	}
	else if(strcmp(p1, "hostname")==0)
	{
	    executa_processo(HOSTNAME_PATH);
	}
	else if(strcmp(p1, "rmdir")==0)
	{
	    executa_processo(RMDIR_PATH);
	}
	else if(strcmp(p1, "cp")==0)
	{
	    executa_processo(CP_PATH);
	}
	else if(strcmp(p1, "cd")==0)
	{
	    /*Aqui esta ocorrendo falha de segmentacao
	    quando o usuario digita um diretorio que
	    existe*/
	    retorno=chdir(comando_vish[1]);
	    get_current_dir_name();
	    //printf("%s\n",getcwd(comando_vish[1],100));
	    if(retorno != 0)
	    	printf("Diretorio nao existe\n");
	}
	else if(strcmp(p1, "uname")==0)
	{
	    executa_processo(UNAME_PATH);
	}
	else if(strcmp(p1, "ls")==0)
	{
	    executa_processo(LS_PATH);
	}
	else if(strcmp(p1, "passwd")==0)
	{
	    trocar_senha(login.user);
	}
	else if(strcmp(p1, "quit")==0)
	{
	    goto sair;
	}
	else if(strcmp(p1, "userback")==0 && suid==0)
	{
	    executa_processo(USERBACK_PATH);
	}
	else if(strcmp(p1, "mkdir")==0)
	{
	    executa_processo(MKDIR_PATH);
	}
	else
	{
	    printf("%s:  %s: comando invalido.\n", shell, p1);
	}	
	
	/*comandos digitados sao gravados no arquivo de log*/
	gerar_log(p1, login.user);
    }
    sair:
    fclose(passwd);
    return 0;
}

int executa_processo(char *comando)
{
    pid_proc = fork();
    if(pid_proc == -1)
    	printf("%s: erro ao tentar criar processo filho\n",shell);
    
    else if(pid_proc == 0)
    	execve(comando, comando_vish, environ);
    
    else
    	wait_pid = wait(&proc_status);
    
    if(wait_pid == -1)
    	printf("%s: erro esperando processo terminar\n",shell);
    
    return 0;
}

int mtod()
{
    char caractere;
    FILE *mtod;
    mtod=fopen(MTOD_PATH, "r");
    if(mtod==NULL)
    {
	printf("error mtod\n");
    }
    caractere=getc(mtod);
    while(caractere != EOF)
    {
	putchar(caractere);
	caractere=getc(mtod);	
        
    }
    fclose(mtod);
    return 0;
}


int gerar_log(char *comando, char *usuario)
{
    FILE *arquivo;
    time_t raw_time;
    struct tm *timeinfo;
    time(&raw_time);
    timeinfo=localtime(&raw_time);
    arquivo=fopen(LOG_PATH, "a");
    
    if (arquivo==NULL)
    	printf("Erro obtendo informacoes sobre log\n");
    
    fprintf(arquivo, "%s | %d/%d | %d:%d | %s\n", comando, timeinfo->tm_mday, \
    timeinfo->tm_mon, timeinfo->tm_hour, timeinfo->tm_min, usuario);
    fclose(arquivo);
    return 0;
}

int trocar_senha(char *usuario)
{
    Useradd chgpasswd;
    int registro=0;
    char senha_nova[30]; 
    FILE *passwd;
    passwd=fopen(PASS_PATH, "r+");
    
    if(passwd==NULL)
    {
	printf("Erro obtendo informacoes sobre usuario\n");
	exit(0);
    }
    
    while(fread(&chgpasswd, sizeof(Useradd), 1, passwd))
    {
	if(strcmp(chgpasswd.user, usuario)==0)
	{
	    printf("Digite a nova senha: ");
	    gets(senha_nova);
	    strcpy(chgpasswd.senha, senha_nova);
	    registro=ftell(passwd);
	    fseek(passwd, registro-sizeof(Useradd), SEEK_SET);
	    fwrite(&chgpasswd, sizeof(Useradd), 1, passwd);    	    
		
	}    
    }
    
    fclose(passwd);
}

int logout(char *usuario)
{
    FILE *arquivo;
    
    time_t rawtime;
    struct tm *timeinfo;
    
    time(&rawtime);
    timeinfo=localtime(&rawtime);
    
    arquivo=fopen(LAST_ARQ_PATH, "a");
    
    if(arquivo==NULL)
    	printf("Erro abrindo arquivo last\n");
    
    /*gravando no arquivo, os valores definidos pela
      estrutura tm*/
    fprintf(arquivo,"%s | %d/%d | %d:%d:%d | LOGOUT\n",\
    usuario, timeinfo->tm_mday, timeinfo->tm_mon+1,\
    timeinfo->tm_hour, timeinfo->tm_min, timeinfo->tm_sec);
    
    fclose(arquivo);
    return(0);
}

int comando_exit(char *usuario)
{
    FILE *arquivo;
    time_t rawtime;
    struct tm *timeinfo;
    
    time(&rawtime);
    timeinfo=localtime(&rawtime);
  
    arquivo=fopen(LAST_ARQ_PATH, "a");
    
    if(arquivo==NULL)
    	printf("Erro abrindo arquivo last\n");

    fprintf(arquivo,"%s | %d/%d | %d:%d:%d | EXIT\n",\
    usuario,timeinfo->tm_mday, timeinfo->tm_mon,\
    timeinfo->tm_hour, timeinfo->tm_min, timeinfo->tm_sec);
    
    fclose(arquivo);

}



