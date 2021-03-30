 /*
  * Auteur : Léo-Paul MARTIN
  * 
  * dup_pipe.c
  * 
  */

#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int
main ()
{
  int tab[2], pid;
  char *s1, *s2;
  int err;

  s1 = "chaine1";
  //création d'un pipe
  err = pipe (tab);

  if ((pid = fork ()) < 0)
    printf ("erreur");

  if (pid == 0)
    {				/* Traitement fils */
      s2 = (char *) malloc (10);
      close (tab[1]);		//ferme tab1
      read (tab[0], s2, 8);	//lit s2 sur tab0 (vide avant que le père ne le remplisse plus bas
      printf ("fils lis tab0(%d) sur s2(%s)\n", tab[0], s2);
    }
  else
    {				/* Traitement père */
      close (tab[0]);		//ferme tab0
      write (tab[1], s1, 8);	//ecrit s1 sur tab1
      printf ("pere ecrit s1(%s) dans tab1(%d)\n", s1, tab[1]);
    }
  sleep (1);
  wait (pid);			// attente de la fin du fils
}
