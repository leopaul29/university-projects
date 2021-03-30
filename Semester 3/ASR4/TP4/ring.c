 /*
  * Auteur : Léo-Paul MARTIN
  * 
  * ring.c
  * 
  */

#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>

int
main ()
{
  pid_t pid;
  int tabpipe[2], N, J, T, i;


  //saisie des arguments
  printf ("Nombre de processus à créer : ");
  scanf ("%d", &N);

  do
    {				/* condition J strictement positif */
      printf ("Valeur initiale strictement positive d'un jeton : ");
      scanf ("%d", &J);
    }
  while (J <= 0);
  printf ("Nombre de tours : ");
  scanf ("%d", &T);
  printf ("\n");


//création du tube
  pipe (tabpipe);
  write (tabpipe[1], &J, sizeof (int));	// on met la valeur du jeton dans le tube


  //boucle pour N processus à créer
  for (i = 0; i < N; i++)
    {
      //si pid < 0 erreur
      if ((pid = fork ()) < 0)
	{
	  perror ("fork");
	  exit (EXIT_SUCCESS);
	}

      //si c'est le père on continue
      if (pid != 0)
	continue;

      // sinon si je suis dans le fils
      else
	{
	  // boucle T tours à faire
	  for (i = 0; i < T; i++)
	    {
	      // on récupère la valeur du jeton
	      read (tabpipe[0], &J, sizeof (int));
	      J++;		/*on incremente de la valeur du jeton
				   puis on remet dans le tube la nouvelle valeur du jeton */
	      write (tabpipe[1], &J, sizeof (int));
	      printf
		("Je suis le fils %d du pere %d : La valeur du jeton est : %d \n",
		 getpid (), getppid (), J);
	    }
	  exit (EXIT_SUCCESS);
	}
    }

  while (wait (NULL) > 0)	// attente de la fin des fils
    ;
  exit (EXIT_SUCCESS);
}
