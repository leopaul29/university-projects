 /*
  * Auteur : Léo-Paul MARTIN
  * 
  * dup_1.c
  * 
  */
 
#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>

int
main ()
{
  int fd, nfd;
  char tab1[512], tab2[512];
  fd = open ("/etc/bash.bashrc", O_RDONLY);	//lire seulement

  printf ("fd : %d\n", fd);
  /* ex: fd = 3 */

  nfd = dup (fd);	/* ex: nfd = 6 */
  printf ("nfd : %d\n\n", nfd);

  //on lit 512 caractere de fd sur tab1
  read (fd, tab1, 512);
  printf ("Tab1 ========\n%s\n================\n\n", tab1);
  //on lit les 512 caractere suivant de fd sur tab1
  read (fd, tab1, 512);
  printf ("Tab1.2 =========\n%s\n================\n\n", tab1);
  //on lit les 512 caractere suivant de fd sur tab2
  read (nfd, tab2, 512);
  printf ("Tab2 ===========\n%s\n================\n\n", tab2);
  //on lit les 512 caractere suivant de fd sur tab2
  read (nfd, tab2, 512);
  printf ("Tab2.2 =========\n%s\n================\n\n", tab2);

  //on ferme fd
  close (fd);
  //idem tab1.2 + tab2.2
  read (fd, tab1, 512);
  printf ("Tab3.1 =========\n%s\n================\n\n", tab1);
  //idem tab2.2
  read (nfd, tab2, 512); 
  printf ("Tab3.2 =========\n%s\n================\n\n", tab2);
}
