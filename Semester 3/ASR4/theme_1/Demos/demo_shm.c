/******************************************************************/
/* IUT NICE-COTE D'AZUR - Departement INFORMATIQUE - R. CHIGNOLI  */
/* Module DUT SYS-RX                              Theme 1 IPC S5  */
/******************************************************************/
/* demo_shm.c : Demonstration d'utilisation d'un segment          */
/*              de memoire partagee                               */
/* UTILISATION : commande ( -creation | -use )                    */
/* Utiliser ipcs pour voir les ressources                         */
/* Utiliser ipcrm pour rendre une ressource                       */
/******************************************************************/
#include <stdlib.h> 
#include <stdio.h>
#include <string.h>
#include <sys/types.h> 
#include <sys/ipc.h> 
#include <sys/shm.h>

#define CLEF  3

#include <sys/time.h>
#include <time.h>

// Type de la zone m�moire 
typedef struct memoire
  { int valeur;
    int date;
  } Memoire;

int main(int argc, char * argv[]) { 
    struct memoire *zone; 
    int memid, resultat;

    if (argc != 2) {fprintf (stderr, "\nSyntaxe : %s ( -creation | -use )\n\n", argv[0]); exit (1);}
    if ((strcmp (argv[1], "-creation")!= 0) && (strcmp (argv[1], "-use")!= 0))
                   {fprintf (stderr, "\nSyntaxe : %s ( -creation | -use )\n\n", argv[0]); exit (2);}
    
    /* cr�ation ou lien avec une zone partag�e */
    memid = shmget(CLEF, 100, 0700 | IPC_CREAT); 
    if (memid == -1) { perror("shmget"); exit (-1); }
    
    /* attachement : montage en m�moire */
    zone = shmat(memid, NULL, 0);
    if (zone == (struct memoire*)-1) { perror("shmat"); exit (-1); }
    
    if (strcmp (argv[1], "-creation")== 0) 
       { 
         zone->valeur = 0; 
         zone->date =time(NULL);
         printf("\nCREATION : VALEURS en memoire : valeur = %d - date = %s\n",
                zone->valeur, ctime ((time_t*)&zone->date));
       }  
      else // -use
       { 
         printf("\nUSE : ANCIENNES VALEURS en memoire : valeur = %d - date = %s \n",
                zone->valeur, ctime ((time_t*)&zone->date));
         zone->valeur++; 
         zone->date =time(NULL);
         printf("USE : NOUVELLES VALEURS en memoire : valeur = %d - date = %s \n",
         zone->valeur, ctime ((time_t*)&zone->date));
       }

    /* detachement */
    resultat = shmdt (zone);
    if (resultat == -1) { perror("shmdt"); exit (-1); }
    printf("Memoire detachee\n\n");
}

