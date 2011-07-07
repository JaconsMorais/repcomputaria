#include <stdio.h>
#include <unistd.h>
#include <ctype.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <glob.h>
#include <stdarg.h>
#include <signal.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/wait.h>

struct command_t{ //comando
int argc;
char **argv;
};

struct command_t *com;

char *func_pwd() //comando interno pwd
{
    int size;
    char *buf;
    char *ptr = getcwd(buf, size);
    buf=(char *)malloc((size_t)size);
    printf("%s\n", ptr);
    
    return ptr;
}
 
void func_exit(){ //comando interno exit
    exit(1);
}
 
int func_cd(int argc, char *argv[]) //comando interno cd
{
  if (argc > 2) {
    fprintf(stderr, "cd: argumentos demais\n");
    return 1;
  }
  else if (argc == 2) {
    int ret = chdir(argv[1]);
    if (ret < 0)
      perror("chdir");
    return ret;
  }
  else {
    fprintf(stderr, "cd: falta argumento\n");
    return 1;
  }
}

/*glob_t *expande_glob(command_t *cmd)
{
      int i = 2;
      glob_t globbuf;

      globbuf.gl_offs = 1;
      glob(cmd->argv[1], GLOB_DOOFFS | GLOB_NOCHECK, NULL, &globbuf);

      while(cmd->argv[i] != NULL){
          glob(cmd->argv[i], GLOB_DOOFFS | GLOB_NOCHECK | GLOB_APPEND, NULL, &globbuf);
          i++;
      }

      globbuf.gl_pathv[0] = (char *) malloc(sizeof(char)*(strlen(cmd->argv[0]) + 1));
      strcpy(globbuf.gl_pathv[0], cmd->argv[0]);

      return globbuf;
}*/

void redir(char *file, int descritor){  //redirecionamento
    int f = open(file, O_RDONLY);
    int fc = dup(f);

    close(descritor);
    dup2(f, descritor);
}
 
void executa_comando(struct command_t *cmd) //execução do comando
{
    const char *cmdname = cmd->argv[0];
    /*glob_t globbuf = (glob_t *) malloc(sizeof(glob_t));
    globbuf = expande_glob(cmd);*/
 
    if(strcmp(cmdname,"cd") == 0) func_cd(cmd->argc,cmd->argv); //comandos internos - sem uso do fork()
    else if(strcmp(cmdname,"pwd") == 0) func_pwd();
    if(strcmp(cmdname,"exit") == 0) func_exit();
    else{ //uso do fork aqui
     pid_t cpid = fork();
     int wait_pid;
     int status;
     int lastchild;
 
     if (cpid < 0) {
       perror("fork");
       exit(127);
     }
     else if (cpid > 0) { /* pai */
       lastchild = cpid;
       wait_pid = wait(&status);
     }
     else {               /* filho */
       /*if(&globbuf == NULL)*/ execvp(cmdname, cmd->argv);
       //else execvp(cmdname, globbuf.gl_pathv);
       perror("exec");
       exit(127);
     }
 
     if(wait_pid < 0) perror("wait");

    }
}
 
int run_pipe(struct command_t **comandos, int num_args, int num_args0) //pipeline
{
	int pd[2];
	int pid;

	if(pipe(pd) < 0){
		perror("pipe");
		exit(1);
	}else{
		pid = fork();
		if (pid < 0) { //erro
			perror("fork");
			exit(1);
		}else if (pid > 0){ //processo pai - roda o comando
			close(1);
			dup2(pd[1], 1);
			close(pd[1]);
			close(pd[0]);
			executa_comando(comandos[num_args0-num_args]);
		}else{ //processo filho - continua o pipeline
			close(0);
			dup2(pd[0], 0);
			close(pd[0]);
			close(pd[1]);
			if(num_args0 != 0) run_pipe(comandos,num_args-1, num_args0);
			else return 0;
		}
	}

}
