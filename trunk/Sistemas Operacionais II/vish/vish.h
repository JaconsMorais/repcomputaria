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
 
#include <time.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define CAT_PATH      "bin/cat"
#define EDIT_PATH     "bin/edit"
#define EXIT_PATH     "bin/exit"
#define LAST_PATH     "bin/last"
#define LOGOUT_PATH   "bin/logout"
#define CREDITO_PATH  "bin/creditos"
#define RM_PATH       "bin/rm"
#define EDIT_PATH     "bin/edit"
#define MV_PATH       "bin/mv"
#define USERADD_PATH  "bin/useradd"
#define MTOD_PATH     "etc/mtod"
#define PASS_PATH     "etc/passwd"
#define PWD_PATH      "bin/pwd"
#define LOG_PATH      "etc/log"
#define LOG_EXEC_PATH "bin/log"
#define LAST_ARQ_PATH "etc/last"
#define DATE_PATH     "bin/date"
#define HOSTNAME_PATH "bin/hostname"
#define EXIT_PATH     "bin/exit"
#define RMDIR_PATH    "bin/rmdir"
#define CP_PATH       "bin/cp"
#define UNAME_PATH    "bin/uname"
#define LS_PATH       "bin/ls"
#define USERDEL_PATH  "bin/userdel"
#define NEWPASS_PATH  "etc/new.passwd"
#define USERBLK_PATH  "bin/userblock"
#define USERBACK_PATH "bin/userback"
#define MKDIR_PATH    "bin/mkdir"
#define MAX 20

/*comando digitados pelo shell*/
char *comando_vish[3];
/*definicao para ambiente, usado em execve*/
extern char **environ;
/*variaveis usadas no processo do fork()*/
pid_t pid_proc;
pid_t wait_pid;

int proc_status;

const char shell[]="vish-0.1";

int executa_processo(char *comando);
int gerar_log(char *comando, char *usuario);

int trocar_senha(char *usuario);
int logout(char *usuario);
int comando_exit(char *usuario);

int mtod();
int suid=0;

typedef struct user {
    char nome[MAX];
    char user[MAX];
    char home[MAX];
    char senha[MAX];
    int bloqueado;
} Useradd;

