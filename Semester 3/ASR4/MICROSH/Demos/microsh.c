#include <sys/types.h>
#include <sys/wait.h>
# include <signal.h>
#include "bib_microsh.h"

void rep_SIG()
   /* Pour eliminer les zombies */
{
   while (wait3 (NULL, WNOHANG, NULL) > 0)
   {
      printf ("\n*** NB : FILS MORT ***\n"); 
   }
}

main ()

{ 
  int res;
  shell_commande **ligne_commande; 
  printf ("\n... Microsh : exit pour terminer ...\n");
  signal (SIGCHLD, rep_SIG);
  ligne_commande = nouvelle_commande();
  // Arret si "exit" en 1er mot de la ligne ...
  while (strcmp (ligne_commande [0]-> commande [0], "exit") !=0) 
  { 
    res=fork();
    if (res == 0)
     { 
       execvp (ligne_commande[0]->commande [0], ligne_commande[0]->commande );
       printf ("\nERREUR EXECVP\n");
     }

    else 
     if (ligne_commande[0]->separateur != et_comm) 
       { 
         waitpid (res, 0, 0);
       }
    ligne_commande = nouvelle_commande();
  }
  printf ("\nMicrosh : EXIT\n");
}
