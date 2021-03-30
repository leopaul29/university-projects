#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
#include <time.h>

int main (int argc,char* argv[]) {
  struct stat s;
  
  time_t t;
  struct tm *tp;
  char buff[80];

  if ( argc!=2 ) {
    fprintf(stderr, "Usage : %s nom_de_fichier_ou_repertoire\n", argv[0]);
    exit (1);
  }
  if ( stat(argv[1],&s) == -1 ) {
    perror("stat");
    exit(1);
  }
  t = s.st_mtime;
  tp = localtime(&t);
  printf("Fichier %s : taille = %d, inode = %d, mtime = %d, type = %c, uid = %d, gid = %d, lien = %d\n",
	      argv[1], s.st_size, s.st_ino, s.st_mtime, (S_ISDIR(s.st_mode)?'d':(S_ISREG(s.st_mode)?'f':'?')), s.st_uid, s.st_gid, s.st_nlink);
  strftime(buff,80,"%b %d %Y %H:%M", tp);
  printf("Date et temps : %s\n", buff);
		

  return EXIT_SUCCESS ;
}
