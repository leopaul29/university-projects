/*
 lslaRscan.c : imitation de la commande ls -l -R -a

 Version du 8 octobre 2013
 
 Utilisation de scandir avec une fonction alphasort2 "maison"

*/
#define  _GNU_SOURCE

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>
#include <dirent.h>

#include "affichelong.h"

int
alphasort2 (const struct dirent **a, const struct dirent **b)
{
  return strcoll ((*b)->d_name, (*a)->d_name);	// envers
}

int
parcourt (char *rep)
{
  DIR *subdirp;
  int n, nsub;
  struct dirent **namelist;
  char sousrep[LONG_MAX_REP];

  n = scandir (rep, &namelist, NULL, alphasort2);
  if (n < 0)
    perror ("scandir");
  else
    {
      while (n--)
	{
	  if (strcmp (namelist[n]->d_name, ".") != 0)
	    {
	      if (strcmp (namelist[n]->d_name, "..") != 0)
		{
		  sprintf (sousrep, "%s/%s", rep, namelist[n]->d_name);
		  free (namelist[n]);
		  affichelong (sousrep);
		  if ((subdirp = opendir (sousrep)) != NULL)
		    {
		      printf ("\n%s\n", sousrep);
		      parcourt (sousrep);
		    }
		}
	    }
	}
    }
  free (namelist);
  return EXIT_SUCCESS;
}

int
main (int argc, char *argv[])
{
  DIR *dirp;

  if (argc != 2)
    {
      fprintf (stderr, "usage : %s chemin\n", argv[0]);
      exit (EXIT_FAILURE);
    }

  if ((dirp = opendir (argv[1])) != NULL)
    {
      return parcourt (argv[1]);
    }
  else
    {
      fprintf (stderr, "%s : %s\n", argv[1], strerror (errno));
      exit (EXIT_FAILURE);
    }

  return EXIT_SUCCESS;
}
