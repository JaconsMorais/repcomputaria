#include <unistd.h>
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <glob.h>
#include <stdarg.h>
#include <signal.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/wait.h>

#include "mysh.h"

extern char **environ;

char *pname;

char *exec_argv[32];

char cmd_line[BUFF_SIZ];

int cmd_offset;

char command[BUFF_SIZ];

int child_exit_status;

int send_to_back;

#define _not_exit_yet_ 1

main (int argc, char *argv[], char *envp[])
{

  pname = argv[0];

  signal (SIGINT, MySh_sig_ctrl_c);
  signal (SIGCHLD, MySh_sig_child);

  if (argc > 1)
    {
      int fd = open (argv[1], O_RDONLY);
      if (fd == -1)
        {
          MySh_printmsg (2, pname, ": MySh script file ",
                         argv[1], " not found, using "
                         "interactive input\n", NULL);
        }
      else
        {
          dup2 (fd, 0);
        }
    }

  while (_not_exit_yet_)
    {
      int cmd_len;

      MySh_printmsg (1, "# ", NULL);

      if ((cmd_len = MySh_getline ()) == 0)
        {
          exit (0);
        }
      else if (cmd_len == 1 && cmd_line[0] == 0)
        {
          continue;
        }

      while (MySh_getcmd ())
        {

          MySh_fetchargv ();

          if (MySh_isbuiltin () == 0)
            {
              MySh_spawncmd ();
            }

          MySh_freeargv ();
        }
    }

  return 0;
}

MySh_getline (void)
{
  int UPPLIM = BUFF_SIZ - 1;

  int i;
  for (i = 0; i < UPPLIM; i++)
    {
      int nr = read (0, cmd_line + i, 1);
      if (nr == 0)
        {
          cmd_line[i] = 0;
          break;
        }
      if (cmd_line[i] == '\n')
        {
          cmd_line[i] = 0;
          i++;
          break;
        }
    }

  cmd_offset = 0;

  return i;
}

MySh_getcmd (void)
{
  int i = cmd_offset;
  int j = 0;

  send_to_back = 0;

  if (cmd_offset >= strlen (cmd_line))
    {
      return 0;
    }

  while (isspace (cmd_line[i]) || cmd_line[i] == ';')
    i++;

  if (cmd_line[i] == 0)
    {
      return 0;
    }

  while (cmd_line[i] != 0 && cmd_line[i] != ';')
    {
      command[j++] = cmd_line[i++];
    }
  command[j] = 0;

  cmd_offset = i + 1;

  for (i = strlen (command) - 1; i >= 0; i++)
    {
      if (command[i] == '&')
        {
          command[i] = 0;
          send_to_back = 1;
          break;
        }
      else if (!isspace (command[i]))
        {
          break;
        }
    }

  return 1;
}

MySh_fetchargv (void)
{
  int alloc_size = sizeof (char) * (strlen (command) + 1);

  int i = 0;
  int argv_p = 0;

  while (command[i] != 0)
    {
      int j = 0;

      exec_argv[argv_p] = (char *) malloc (alloc_size);

      while (!isspace (command[i]) && command[i] != 0)
        {
          exec_argv[argv_p][j++] = command[i++];
        }
      exec_argv[argv_p][j] = 0;

      while (isspace (command[i]))
        i++;

      argv_p++;
    }

  exec_argv[argv_p] = NULL;

  return argv_p;
}

MySh_isbuiltin (void)
{
  if (strcmp (exec_argv[0], "exit") == 0)
    {
      exit (0);
    }
  else if (strcmp (exec_argv[0], "setenv") == 0)
    {
      if (exec_argv[1] == NULL || exec_argv[2] == NULL)
        {
          MySh_printmsg (2, pname, ": setenv must receive an environment "
                         "variable name and value\n", NULL);
        }
      else
        {
          int i;
          int alloc_size = strlen (exec_argv[1]) + 2;
          char *newenv = (char *) malloc (alloc_size * sizeof (char));
          strcpy (newenv, exec_argv[1]);
          strcat (newenv, "=");

          for (i = 2; exec_argv[i] != NULL; i++)
            {
              char *tmp;

              alloc_size += strlen (exec_argv[i]);
              if (exec_argv[i + 1] != NULL)
                alloc_size++;

              tmp = (char *) malloc (alloc_size * sizeof (char));
              strcpy (tmp, newenv);
              strcat (tmp, exec_argv[i]);
              if (exec_argv[i + 1] != NULL)
                strcat (tmp, " ");

              free (newenv);
              newenv = tmp;
            }
          putenv (newenv);
          MySh_printmsg (1, "setenv $", exec_argv[1], " executed\n", NULL);
        }
      return 1;
    }
  else if (strcmp (exec_argv[0], "echo") == 0)
    {
      if (exec_argv[1] == NULL || exec_argv[2] != NULL)
        {
          MySh_printmsg (2, pname,
                         ": echo must receive an environment variable "
                         "name, like $var\n", NULL);
        }
      else if (exec_argv[1][0] != '$')
        {
          MySh_printmsg (2, pname, ": invalid variable name: ",
                         exec_argv[1], "\n", NULL);
        }
      else
        {
          char *value = getenv (&exec_argv[1][1]);
          if (value == NULL)
            {
              MySh_printmsg (2, pname, ": variable ",
                             exec_argv[1], " not found in environment\n",
                             NULL);
            }
          else
            {
              MySh_printmsg (1, value, "\n", NULL);
            }
        }
      return 1;
    }
  else if (strcmp (exec_argv[0], "env") == 0)
    {
      int i;
      for (i = 0; environ[i] != NULL; i++)
        {
          MySh_printmsg (1, environ[i], "\n", NULL);
        }
      return 1;
    }
  return 0;
}

pid_t
MySh_spawncmd (void)
{
  pid_t cpid;

  if (cpid = fork ())
    {
      if (!send_to_back)
        {
          wait (&child_exit_status);
        }
      return cpid;
    }
  else
    {
      if (send_to_back)
        {
          setpgid (0, cpid);
        }

      MySh_execvp_glob (exec_argv[0], exec_argv);
      MySh_printmsg (2, pname, ": cannot execute ", exec_argv[0], "\n", NULL);
      exit (-1);
    }
}

MySh_execvp_glob (char *file, char *argv[])
{
  int retval;


  if (argv[1] == NULL)
    {
      retval = execvp (file, argv);

    }
  else
    {
      int i;
      glob_t globbuf;

      globbuf.gl_offs = 1;
      glob (argv[1], GLOB_DOOFFS | GLOB_NOCHECK, NULL, &globbuf);

      for (i = 2; argv[i] != NULL; i++)
        {
          glob (argv[i], GLOB_DOOFFS | GLOB_NOCHECK | GLOB_APPEND, NULL,
                &globbuf);
        }

      globbuf.gl_pathv[0] =
        (char *) malloc (sizeof (char) * (strlen (file) + 1));
      strcpy (globbuf.gl_pathv[0], file);

      retval = execvp (file, globbuf.gl_pathv);
    }

  return retval;
}

MySh_freeargv (void)
{
  int argc = 0;
  while (exec_argv[argc] != NULL)
    {
      free (exec_argv[argc++]);
    }
  exec_argv[0] = NULL;
}

void
MySh_printmsg (int fd, char *msg1, ...)
{
  va_list argp;
  char *str;

  va_start (argp, msg1);
  write (fd, msg1, sizeof (char) * strlen (msg1));
  while ((str = (char *) va_arg (argp, char *)) != NULL)
    {
      write (fd, str, sizeof (char) * strlen (str));
    }
  va_end (argp);
}

void
MySh_sig_ctrl_c (int signal)
{
  cmd_line[0] = 0;
  cmd_offset = 0;
  MySh_printmsg (1, "\n# ", NULL);
}

void
MySh_sig_child (int signal)
{
  if (WIFEXITED (child_exit_status) == 0)
    {
      MySh_printmsg (2, pname, ": ", exec_argv[0], " was exited abnormally\n",
                     NULL);
    }
}

