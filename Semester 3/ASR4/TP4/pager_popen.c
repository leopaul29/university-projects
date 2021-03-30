/*
  APUE 14.4
*/

#include <stdio.h>
#include <stdlib.h>

#define PAGER "${PAGER:-more}"
#define MAXLINE 4096

int
main (int argc, char *argv[])
{

  char line[MAXLINE];
  FILE *fpin, *fpout;

  if (argc != 2)
    {
      fprintf (stderr, "SYNTAXE : %s chemin\n", argv[0]);
      exit (1);
    }

  if ((fpin = fopen (argv[1], "r")) == NULL)
    {
      perror ("fopen");
      exit (1);
    }

  if ((fpout = popen (PAGER, "w")) == NULL)
    {
      perror ("popen");
      exit (1);
    }

  while (fgets (line, MAXLINE, fpin) != NULL)
    {
      if (fputs (line, fpout) == EOF)
	perror ("fputs error to pipe");
    }

  if (ferror (fpin))
    perror ("fgets error");

  if (pclose (fpout) == -1)
    perror ("plcose error");

  exit (EXIT_SUCCESS);
}
