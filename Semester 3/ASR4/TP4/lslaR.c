/*
 * lsRla.c : imitation de la commande ls -l -a -R
 *
 * Version du 08 octobre 2013
 * 
 * Améliorations : 
 *   - afficher le Total (nb blocs) par répertoire comme sous Linux
 */
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <dirent.h>

#include "affichelong.h"

int
parcourt (char *rep)
{
  DIR *dirp, *subdirp;
  struct dirent *entry;
  char sousrep[LONG_MAX_REP];

  dirp = opendir (rep);
  /*
   * Phase 1 : affichage des fichiers 
   */
  while ((entry = readdir (dirp)) != NULL)
    {
      if (strcmp (entry->d_name, ".") != 0)
	{
	  if (strcmp (entry->d_name, "..") != 0)
	    {
	      sprintf (sousrep, "%s/%s", rep, entry->d_name);
	      affichelong (sousrep);
	    }
	}
    }
  /*
   * Phase 2 : affichage des sous-répertoires 
   */
  rewinddir (dirp);
  while ((entry = readdir (dirp)) != NULL)
    {
      if (strcmp (entry->d_name, ".") != 0)
	{
	  if (strcmp (entry->d_name, "..") != 0)
	    {
	      sprintf (sousrep, "%s/%s", rep, entry->d_name);
	      if ((subdirp = opendir (sousrep)) != NULL)
		{
		  printf ("\n%s\n", sousrep);
		  parcourt (sousrep);
		}
	    }
	}
    }
  closedir (dirp);
  return 0;
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
