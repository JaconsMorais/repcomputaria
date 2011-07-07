#ifndef __mysh_h
#define __mysh_h

#define BUFF_SIZ 8192

extern char *exec_argv[];
extern int cmd_offset;
extern char cmd_line[];
extern int cmd_offset;
extern char command[];
extern int child_exit_status;
extern int send_to_back;

int MySh_getline (void);
int MySh_getcmd (void);
int MySh_fetchargv (void);
int MySh_isbuiltin (void);
pid_t MySh_spawncmd (void);
void MySh_freeargv (void);
int MySh_execvp_glob (char *file, char *argv[]);
void MySh_printmsg (int fd, char *msg1, ...);
void MySh_sig_ctrl_c (int signal);
void MySh_sig_child (int signal);

#endif
