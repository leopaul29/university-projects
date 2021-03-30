#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/types.h>

#define NB_FILS	5

int
main (void)
{
  pid_t pid;
  int fils;

  /* fait 5 tours = création de 5 fils */
  for (fils = 0; fils < NB_FILS; fils++)
    {
      if ((pid = fork ()) < 0)
	{
	  perror ("fork");
	  exit (EXIT_SUCCESS);
	}
      if (pid != 0)		/* Traitement père */
	continue;
      /* Traitement fils */
      printf ("Je suis le fils %d du pere %d\n", getpid (), getppid ());
      exit (EXIT_SUCCESS);
    }
  while (wait (NULL) > 0)	// attente de la fin du fils
    ;
  exit (EXIT_SUCCESS);
}
