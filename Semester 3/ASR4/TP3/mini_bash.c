// mini_bash.c

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int
main ()
{
  pid_t pid;

  int i = 0;
  char *argv[10];
  argv[0] = (char *) malloc (30);	//chaine pour la commande

  while (1 == 1)
    {
      i = 0;
      printf ("Nom de la commande a executer : ");
      scanf ("%s", argv[0]);
      printf ("Tapper 0 pour stopper la saisie d'argument (10 maximum)\n");

      // Saisie d'un nombre variable d'argument
      do
	{
	  i++;
	  printf ("%d Argument : ", i);
	  argv[i] = (char *) malloc (30);	//chaine pour les arguments
	  scanf ("%s", argv[i]);
	}
      while (*argv[i] != '0');
      argv[i] = (char *) 0;

      if ((pid = fork ()) < 0)
	fprintf (stderr, "fork error");
      else if (pid == 0)
	{			// child 
	  sleep (2);
	  execvp (argv[0], argv);	//execution de la commande avec les arguments
	  printf ("\nERREUR : execvp impossible\n");
	}
      else
	{
	  sleep (2);		// parent 
	  wait (pid);		// attente de la fin du fils
	}
    }

  exit (EXIT_SUCCESS);
}
