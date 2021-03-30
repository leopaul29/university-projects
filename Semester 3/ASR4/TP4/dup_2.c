 /*
  * Auteur : Léo-Paul MARTIN
  * 
  * dup_2.c
  * 
  */

#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int
main ()
{
  int fd, nfd;
  char tab1[512], tab2[512];
  fd = open ("/etc/bash.bashrc", O_RDONLY);

  /* ex: fd = 3 */
  printf ("fd : %d\n", fd);

  nfd = dup2 (fd, 3);		//oldfd,newfd  /* nfd = 4 */
  printf ("nfd : %d\n\n", nfd);
  /* si non libre: "4" est fermé avant */

  //on lit 512 caractere de bahs.bashrc sur tab1 (fd = 3)
  read (fd, tab1, 512);
  printf ("Tab1 ========\n%s\n================\n\n", tab1);
  /*lon it 512 caractere de bash.bashrc sur tab2 (nfd = 3)
     met le tab1 a la suite du tab2 */
  read (nfd, tab2, 512);
  printf ("Tab2 ===========\n%s\n================\n\n", tab2);
  //ecrit sur stdout le tab1 de 512 caractere
  write (STDOUT_FILENO, tab1, 512);
  printf ("\n");

  //on ferme fd
  close (fd);
  read (nfd, tab2, 512);
  //idem tab2
  printf ("Tab3 ===========\n%s\n================\n\n", tab2);
}
