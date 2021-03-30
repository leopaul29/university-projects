/*
gcc affiche_nom_proprietaire_fichier.c
./a.out affiche_nom_proprietaire_fichier.c
Le fichier affiche_nom_proprietaire_fichier.c appartient a 20067
Le fichier affiche_nom_proprietaire_fichier.c appartient a syska
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <string.h>
#include <sys/stat.h>
#include <pwd.h>
#include <grp.h>

/*
   Prepare les informations du fichier
*/

struct stat fichier_infos;

set_infos (char * nom_fichier)
{
  if (stat (nom_fichier, &fichier_infos) == -1)
    {
      fprintf (stderr, "set_infos: impossible d'acceder a %s \n", 
	       nom_fichier);
      return;
    }
}
/*
   Retourne le nom d'utilisateur 'nom_utilisateur' correspondant a 
   l'uid 'numero_uid'
*/

void utilisateur (int numero_uid, char* nom_utilisateur)
{

  struct passwd *pinfos;

  pinfos = getpwuid (numero_uid);
  if ( pinfos < (struct passwd*) 0 )
    {
      perror ("Error: UID incorrect");
      exit (1);
    }
  else
    sprintf (nom_utilisateur, "%s", pinfos->pw_name);
}

void groupe (int numero_gid, char* nom_utilisateur)
{
	struct group *pinfos;
	
	pinfos = getgrgid (numero_gid);
	if ( pinfos < (struct group*) 0 )
	{
	  perror ("Error: GID incorrect");
	  exit (1);
	  }
	else
	  sprintf (nom_utilisateur, "%s", pinfos->gr_name);
}

void afficher_infos(char * nom_fichier)
{
  int uid;
  int gid;
  char utilisateur_courant[10];
  char nom_groupe[10];

  set_infos (nom_fichier);
  uid = fichier_infos.st_uid;
  gid = fichier_infos.st_gid;
  
  printf("Le fichier %s appartient a %d\n",nom_fichier,uid);

  utilisateur (uid, (char *) utilisateur_courant);
  groupe (gid, (char *) nom_groupe);
  
  printf("Le fichier %s appartient a %s\n",nom_fichier,utilisateur_courant);
  printf("Le fichier %s appartient au groupe %s\n",nom_fichier, nom_groupe);
}


int
main (int argc, char **argv)
{

  afficher_infos(argv[1]);
  return EXIT_SUCCESS;
    
} /* main */
