/* 

APUE page 431-432

bash-3.1$ gcc pipe2.c -o pipe2
bash-3.1$ ./pipe2 /etc/httpd/conf/httpd.conf 
bash-3.1$ export PAGER=/usr/bin/less
bash-3.1$ ./pipe2 /etc/httpd/conf/httpd.conf
PAGER='/usr/bin/less'
PAGER='/usr/bin/less' ARGV0='less'
bash-3.1$                               
 */

#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAXLINE 4096		/* max line length */
#define DEF_PAGER "/bin/more"	/* default pager program */

int
main (int argc, char *argv[])
{
  int n, fd[2];
  pid_t pid;
  char line[MAXLINE], *pager, *argv0;
  FILE *fp;

  if (argc != 2)
    {
      fprintf (stderr, "usage: a.out <pathname> \n");
      exit (1);
    }
  if ((fp = fopen (argv[1], "r")) == NULL)
    fprintf (stderr, "can't open %s", argv[1]);

  if (pipe (fd) < 0)
    fprintf (stderr, "pipe error");

  if ((pid = fork ()) < 0)
    fprintf (stderr, "fork error");
  else if (pid > 0)
    {				/* parent */
      close (fd[0]);		/* close read end */
      /* parent copies argv[1] to pipe */
      while (fgets (line, MAXLINE, fp) != NULL)
	{
	  n = strlen (line);
	  if (write (fd[1], line, n) != n)
	    fprintf (stderr, "write error to pipe");
	}
      if (ferror (fp))
	fprintf (stderr, "fgets error");

      close (fd[1]);		/* close write end of pipe for reader */
      if (waitpid (pid, NULL, 0) < 0)
	printf ("waitpid error");
      exit (EXIT_SUCCESS);

    }
  else
    {				/* child */
      close (fd[1]);		/* close write end */
      if (fd[0] != STDIN_FILENO)
	{
	  if (dup2 (fd[0], STDIN_FILENO) != STDIN_FILENO)
	    fprintf (stderr, "dup2 error to stdin");
	  close (fd[0]);	/* don't need this after dup2 */
	}

      /* get arguments for execl() */

      if ((pager = getenv ("PAGER")) == NULL)
	pager = DEF_PAGER;
      printf ("PAGER='%s'\n", pager);
      if ((argv0 = strrchr (pager, '/')) != NULL)
	argv0++;		/* step past rightmost slash */
      else
	argv0 = pager;		/* no slash in pager */
      printf ("PAGER='%s' ARGV0='%s'\n", pager, argv0);
      if (execl (pager, argv0, (char *) 0) < 0)
	printf ("execl error for %s", pager);
    }
  /* pas utile ici        return EXIT_SUCCESS; */
}
