/*************************************************************************/
/* IUT NICE-COTE D'AZUR - Departement INFORMATIQUE - R. CHIGNOLI         */
/* Module DUT SYS-RX                            Theme 2 PTHREADS         */
/*************************************************************************/
// demo_thread.c : Demonstration d'utilisation des threads
                    
#include <stdio.h> 
#include <stdlib.h> 
#include <pthread.h> 

void* action (void* name) { 
    printf ("\n... ACTION par thread %s (pid : %d ) ... Puis MORT\n\n", (char*) name, getpid());
    } 

int main (void) { 
    pthread_t filsA, filsB; 

    printf ("\nDebut du pere ( pid : %d ; ppid : %d ) )\n\n",
            getpid(), getppid());

    if (pthread_create(&filsA, NULL, action, "filsA")) { 
        perror("pthread_create"); 
        exit(-1); 
        } 

    if (pthread_create(&filsB, NULL, action, "filsB")) { 
        perror("pthread_create"); 
        exit(-1); 
        }  

    printf("\nFin du pere\n\n") ;
    return (0);
    }


