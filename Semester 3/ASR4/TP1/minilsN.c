/*
 * Leo-Paul
 *	minils.c
 */

#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <dirent.h>
#include <unistd.h> /* pour NULL */
#include <stdlib.h> /* pour exit */
#include <pwd.h>
#include <fcntl.h>
#include <string.h>
#include <time.h>
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

void affiche_mode (mode_t const mode)
{
   /* user */
   (mode & S_IRUSR) ? printf("r") : printf("-");
   (mode & S_IWUSR) ? printf("w") : printf("-");
   (mode & S_IXUSR) ? printf("x") : printf("-");
 
   /* group */
   (mode & S_IRGRP) ? printf("r") : printf("-");
   (mode & S_IWGRP) ? printf("w") : printf("-");
   (mode & S_IXGRP) ? printf("x") : printf("-");
 
   /* others */
   (mode & S_IROTH) ? printf("r") : printf("-");
   (mode & S_IWOTH) ? printf("w") : printf("-");
   (mode & S_IXOTH) ? printf("x") : printf("-");
   printf(" ");
}

int lire(char * nom)
{
  int fd;
  struct stat * pinfo = (struct stat *) malloc(sizeof(struct stat)) ;
  char * Str;

  if (stat (nom, pinfo) == -1) {
      fprintf (stderr, "info: impossible d'acceder a %s\n",nom);
      return;
    }

  if ((pinfo->st_mode & S_IRWXU) == S_IRUSR) { /* man stat */
    printf("Le proprietaire a les droits en lecture UNIQUEMENT\n");
  }

  affiche_mode(pinfo->st_mode);
}

void utilisateur (int numero_uid, char* nom_utilisateur)
{
  struct passwd *pinfos;

  pinfos = getpwuid (numero_uid);
  if ( pinfos < (struct passwd*) 0 ) {
      perror ("Error: UID incorrect");
      exit (1);
    }
  else
    sprintf (nom_utilisateur, "%s", pinfos->pw_name); // num de l'etudiant
}

void groupe (int numero_gid, char* nom_utilisateur)
{
  struct group *pinfos;

  pinfos = getgrgid (numero_gid);
  if ( pinfos < (struct group*) 0 ) {
      perror ("Error: GID incorrect");
      exit (1);
    }
  else
    sprintf(nom_utilisateur, "%s", pinfos->gr_name); // nom du groupe
}

void afficher_infos(char * nom_fichier)
{
  int uid, gid;
  char utilisateur_courant[10];
  char nom_groupe[10];

  set_infos (nom_fichier);
  uid = fichier_infos.st_uid;
  gid = fichier_infos.st_gid;

  utilisateur (uid, (char *) utilisateur_courant); // num etudiant
  groupe (gid, (char *) nom_groupe); // nom du groupe

  printf("%s %s", utilisateur_courant, nom_groupe);
}

void afficher_date(char * nom_fichier)
{
  time_t t;
  struct tm *tp;
  char buff[80];
  
  set_infos (nom_fichier);
  t = fichier_infos.st_mtime;
  tp = localtime(&t);
  strftime(buff,80,"%b %d %H:%M", tp);
  printf(" %s",buff);
}

char getType(char  * nom_fichier)
{
  set_infos (nom_fichier);
  if(S_ISDIR(fichier_infos.st_mode))
     return 'd';
  else if(S_ISREG(fichier_infos.st_mode))
    return '-';
  else return '-';
}

void afficher_type(char * nom_fichier)
{
  set_infos (nom_fichier);
  printf("%c", (S_ISDIR(fichier_infos.st_mode)?'d':(S_ISREG(fichier_infos.st_mode)?'-':'-')));
}

void afficher_nblien(char * nom_fichier)
{
  set_infos (nom_fichier);
  char buf[5];
  printf("%d ",fichier_infos.st_nlink);
}

int getTaille(char  * nom_fichier)
{
  set_infos (nom_fichier);
  return fichier_infos.st_size;
}

void afficher_taille(char  * nom_fichier)
{
  set_infos (nom_fichier);
  printf(" %d",fichier_infos.st_size);
}

/*void afficher_propriete(char  * nom_fichier)
{
  set_infos (nom_fichier);
  afficher_type(); // affiche d ou -
  lire(fichier_infos); // affiche les permissons
  afficher_nblien(fichier_infos); // afficher le nombre de lien
  afficher_infos(fichier_infos); // afficher num d'etudiant et groupe
  afficher_taille(fichier_infos); // afficher la taille du fichier
  afficher_date(fichier_infos); // afficher la date de la derniere modification
  printf(" %s\n", fichier_infos ); // afficher le nom de fichier
}*/

int main(int argc, char *argv[])
{
	DIR			*dp;
	struct dirent	*dirp;
	struct stat s;
	int taille = 0;          

	if (argc != 2){
	  fprintf(stderr,"a single argument (the directory name) is required\n");
	  exit(1);
	}

	if ( (dp = opendir(argv[1])) == NULL){
		printf("can't open %s\n", argv[1]);
		exit(2);
	}
       
	while ( (dirp = readdir(dp)) != NULL){
		if ( stat(dirp->d_name, &s) == -1 ){
		    perror("stat");
		    exit(3);
		} 		 
		  afficher_type(dirp->d_name); // afficher 'd' ou '-'
		  lire(dirp->d_name); // afficher les permissons
		  afficher_nblien(dirp->d_name); // afficher le nombre de lien
		  afficher_infos(dirp->d_name); // afficher num d'etudiant et groupe
		  afficher_taille(dirp->d_name); // afficher la taille du fichier
		  afficher_date(dirp->d_name); // afficher la date de la derniere modification
		  printf(" %s\n", dirp->d_name); // afficher le nom de fichier

		taille += getTaille(dirp->d_name); //somme total de la taille de tous les fichiers		
	}

	printf("Total : %d\n", taille);
	closedir(dp);
	return EXIT_SUCCESS;
}
