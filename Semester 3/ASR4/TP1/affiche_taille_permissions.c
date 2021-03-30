/*

[syska@linserv1 FICHIERS]$ gcc affiche_taille_permissions.c
[syska@linserv1 FICHIERS]$ ./a.out affiche_taille_permissions.c
taille : 1331
mode : 000081a0
rw-r-----

*/

#include <stdio.h>
/* pour alloc */
#include <stdlib.h>
/* pour O_RDONLY */
#include <fcntl.h>
/* pour struct stat */
#include <sys/stat.h>


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
   printf("\n");
}

int lire(char * nom)
{
int fd;

struct stat * pinfo = (struct stat *) malloc(sizeof(struct stat)) ;
char * Str;


if (stat (nom, pinfo) == -1)
    {
      fprintf (stderr, "info: impossible d'acceder a %s\n",nom);
      return;
    }

printf("taille : %d\n", pinfo->st_size);
printf("mode : %08x\n", pinfo->st_mode);

if ((pinfo->st_mode & S_IRWXU) == S_IRUSR) { /* man stat */
printf("Le proprietaire a les droits en lecture UNIQUEMENT\n");
}

affiche_mode(pinfo->st_mode);

}

int main(int argc,char **argv)
{
if(argc < 2) {
  fprintf(stderr,"usage : affiche_taille_permissions nom_fichier\n");
  exit(3);	
}


lire(argv[1]);
exit(0);
}
