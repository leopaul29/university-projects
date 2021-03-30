 /*
  * Auteur : Léo-Paul MARTIN
  * 
  * dup_redirection.c
  * 
  */

#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>

int
main ()
{
  int pid, fd, nfd;
  char **commande;
  commande = (char **) malloc (30);
  commande[0] = (char *) malloc (30);
  commande[0] = "date";
  commande[1] = NULL;

  if ((pid = fork ()) < 0)	/*erreur */
    fprintf (stderr, "fork error");

  if (pid == 0) /* Traitement fils */
    {				
      if (1)	/* redirection */
	{
	  /*Créer le fichier.txt si il n'existe pas sinon ont écrit dedans par dessus ce qu'il y avait avant
	   avec les permission 644 pour pouvoir le remodifier ensuite*/
	  fd = open ("afficher_date.txt", O_CREAT | O_WRONLY, 00644);	/* création ... O_CREAT > | O_APPEND >> */
	  printf ("fd : %d\n", fd);
	  close (STDOUT_FILENO);	// ferme fd=1 pour remplacer 1 par un fichier
	  nfd = dup (fd);	/* nfd = stdout */
	  close (fd);
	  execvp (commande[0], commande);
	  close (nfd);
	}
    }
  sleep (1);
  wait (pid);	// attente de la fin du fils
}
