/*********************************************************/
/*                                                       */
/*   Client IPC/BERKELEY  -- DOMAINE UNIX -- MODE UDP    */
/*                                                       */
/* IUT de NICE - Departement INFORMATIQUE - Ph. Lahire   */ 
/*                                                       */
/*********************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/un.h>

#define SOCKNAME "demo_th1_OOO"

int main(int argc, char *argv [])
{
   struct sockaddr_un socket_name;  /*Nom de la socket */
   int sd;
   
   if (argc <2)
   {
      printf ("\nSYNTAXE : %s <chaine>\n", argv[0]);
      exit (1);
   }
   
   
   /* Ouverture d'une socket ds le domaine UNIX, de type DATAGRAM */
   if ((sd = socket (AF_UNIX, SOCK_DGRAM, 0)) ==-1)
   {
      perror ("*** Echec socket ***"); exit(1);
   }
   
   
   
   /*Le client envoie un msg a la socket serveur nommee SOCKNAME */
   socket_name.sun_family = AF_UNIX;
   strcpy(socket_name.sun_path, SOCKNAME);
   
   
   //il envois sur le canal sd, la chaine qui est mis en paramtère et transmet la socket du serveur 
   if (sendto (sd, argv [1], strlen (argv [1]), 0, 
              (struct sockaddr*)&socket_name, sizeof(socket_name)) == -1)
   {
      perror("*** Echec sendto ***"); exit(1);
   }
   /*Fermeture de la socket */
   close(sd);
}


//demo_th1_000 => fichier socket 


