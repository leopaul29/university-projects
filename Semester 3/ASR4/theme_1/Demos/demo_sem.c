/************************************************************** *************/
/* IUT NICE-COTE D'AZUR - Departement INFORMATIQUE - R. CHIGNOLI            */
/* Module DUT SYS-RX                              Theme 1 IPC S5            */
/****************************************************************************/
// demo-sem.c : Demonstration d'utilisation d'un sémaphore    
// usage : commande [-creation]  cle                                                                             
// premier acces : utiliser l'option "-creation"                                              
// Utiliser la commande ipcs pour voir la situation systeme 
// Utiliser la commande ipcrm pour detruire une ressource systeme  
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdio_ext.h>

#define CREATION 1
#define UTILISATION 0

void detruire_sem(int sem)
{ if (semctl(sem, 0, IPC_RMID, 0) != 0) {perror("detruire_sem"); exit(-1);}}

void changer_sem(int sem, int val)
{ struct sembuf sb[1];
  sb[0].sem_num = 0;  sb[0].sem_op = val;  sb[0].sem_flg = 0;
  if (semop(sem, sb, 1) != 0){ perror("changer_sem"); exit(-1);}
}

int creer_sem(key_t key, int mode)
{
  int sem,r;
  if (mode == CREATION) {
    sem = semget(key, 1, IPC_CREAT | IPC_EXCL  | 0666);
    if (sem < 0) { perror("Creer_sem"); exit(-1); }
    r = semctl(sem, 0, SETVAL, 1);      /* valeur initiale = 1 */
    if (r < 0) { perror("initialisation sémaphore"); exit(-1); }
  }
  else
  {
    sem = semget(key, 1, 0666);
    if (sem < 0) { perror("Utiliser_sem"); exit(-1); }
  }
  
  printf ("\nSemaphore OK(%d) !\n\n", key);
  return sem;
}

void P(int sem){ changer_sem(sem, -1);}

void V(int sem){ changer_sem(sem, 1);}

int main(int argc, char *argv[])
{
  key_t key;
  char reponse;
  int sem, mode, encore = 1;
  
  if (argc < 3) { fprintf(stderr, "Usage: %s [-creation | -use ] cle\n", argv[0]); exit(1);}
  if ((argc == 3) && (strcmp (argv[1], "-creation") == 0))
   { mode = CREATION; printf ("Mode creation\n\n"); key = atoi(argv[2]); }
  else if ((argc == 3) && (strcmp (argv[1], "-use") == 0))
   { mode = UTILISATION; printf ("Mode utilisation\n\n"); key = atoi(argv[2]);  }
  else 
  { fprintf(stderr, "Usage: %s [-creation | -use ] cle\n", argv[0]); exit(2);}
   sem = creer_sem(key, mode);
  while (encore) {
    printf("P,V,X,Q ? "); reponse = getchar();__fpurge(stdin);
    switch (reponse) {
    case 'P': P(sem); printf("... P OK.\n"); break;
    case 'V': V(sem); printf("... V OK.\n"); break;
    case 'X': detruire_sem(sem);
      printf("... Semaphore detruit\n"); encore = 0;
      break;
    case 'Q':
      encore = 0; break;
    default: printf("... Commande incorrecte\n");
    }
  }
  printf("... Bye\n");
}
