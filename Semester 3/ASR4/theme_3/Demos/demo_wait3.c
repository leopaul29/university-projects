/*******************************/
/* handler de signaux SIGCHILD */
/* Comptage de fin de fils     */
/*******************************/
#include <stdio.h>
#include <sys/types.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <sys/wait.h>
#include <stdlib.h>

int nb_max;
int nb_fils;

void handler_SIGCHLD()
   /* Pour eliminer les zombies */
{
   int num;
   while ((num = wait3 (NULL, WNOHANG, NULL)) > 0)
   {
      nb_fils--;
      printf ("Pere : Vu la mort de %d .. RESTE %d fils\n", num, nb_fils);
   }
}

