/*********************************************************/
/*                                                       */
/* V2 Client IPC/BERKELEY  -- DOMAINE INET -- MODE UDP   */
/*                                                       */
/* IUT de NICE - Departement INFORMATIQUE - PhL - RC     */ 
/*                                                       */
/*********************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <strings.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

int main(int argc, char *argv [])
{
   struct hostent *host_name;
   struct sockaddr_in socket_name;  /*Nom de la socket */
   int sd;
   
   if (argc != 3)
   {
      printf ("\nSYNTAXE : %s <machine> <chaine> \n\n", argv[0]);
      exit (1);
   }
   /* Ouverture d'une socket ds le domaine INET, de type DATAGRAM */
   if ((sd = socket (PF_INET, SOCK_DGRAM, 0)) ==-1)
   {
      perror ("*** Echec socket ***"); exit(1);
   }
   /* Recherche de l'adresse INTERNET de la machine distante */
   host_name = gethostbyname (argv[1]);
   if (host_name == 0)
   {
      fprintf (stderr, "\n*** Echec gethostbyname ***\n\n"); exit(1);
   }      
   /* Remplissage de la socket */
   socket_name.sin_family = AF_INET;
   socket_name.sin_port   = 6201;
   bcopy (host_name ->h_addr, &socket_name.sin_addr, host_name -> h_length);

   /* Envoie d'un message a la socket-serveur decrite dans `sockname' */
   if (sendto (sd, argv [2], strlen (argv [2]), 0, (struct sockaddr*)
               &socket_name, sizeof(socket_name)) == -1)
   {
      perror("*** Echec sendto***");  exit(1);
   }
   /*Fermeture de la socket */
   close(sd);
}
