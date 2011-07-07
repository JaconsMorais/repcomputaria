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

typedef struct command_t command_t;

extern command_t *com;
char *func_pwd(void);
void func_exit(void);
int func_cd(int argc, char *argv[]);
glob_t *expande_glob(command_t *cmd);
void redir(char *file, int descritor);
void executa_comando(command_t *cmd);
int run_pipe(command_t **comandos, int num_args, int num_args0);

