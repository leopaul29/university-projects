/*********************************************************/
/*                                                       */
/* V2 Serveur IPC/BERKELEY  -- DOMAINE INET -- MODE UDP  */
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
#include <signal.h>
#include <arpa/inet.h>

#define BUFSIZE 80
int sd, newsd;

void arret_service()
{
   printf("\n SERVEUR : SIGINT recu => Arret du SERVICE\n\n");
   close(sd);
   exit(0);
}

int main (int argc, char* argv [])
{
   struct hostent *host_name;
   
   struct sockaddr_in socket_name;
   char buffer [BUFSIZE];
   
   if (argc != 2)
   {
      printf ("\nSYNTAXE : %s <machine>\n\n", argv[0]);
      exit (1);
   }
   /* Armement du signal SIGINT */
   signal(SIGINT,arret_service);
   
   /* Recherche de l'adresse INTERNET de la machine du serveur */
   host_name = gethostbyname (argv[1]);
   if (host_name == 0)
   {
      fprintf (stderr, "\n*** Echec gethostbyname ***\n\n"); exit(1);
   }      
   if ((sd = socket (PF_INET, SOCK_DGRAM, 0)) == -1)
   {
      perror ("*** Echec socket ***"); exit (1);
   }
   /* Attribution d'un nom a la socket */
   bzero ( (char *) &socket_name, sizeof (socket_name) );
   socket_name.sin_family = AF_INET;
   socket_name.sin_port   = 5200;
  //on met dans sin_addr l'adre h_addre d'un taille de h_length 
   bcopy (host_name -> h_addr, &socket_name.sin_addr, host_name -> h_length);

  /* Affichage infos socket */
      printf ("SERVEUR sur machine %s (%u) - port %d\n", inet_ntoa (socket_name.sin_addr),
              socket_name.sin_addr, socket_name.sin_port);

   /* Annonce de l'ouverture de la socket ds le domaine INTERNET, type DATAGRAM */
   if (bind (sd, (struct sockaddr*) &socket_name, sizeof (socket_name)) == -1)
   {
      perror ("*** Echec bind ***"); exit (1);
   }
   /* Boucle de traitement des demandes de connexion */
   while (1)
   {
      bzero (buffer, BUFSIZE);
      if (recvfrom (sd, buffer, sizeof (buffer), 0, 0, 0) == -1)
      {
	 perror ("*** Echec recvfrom ***"); exit (1);
      }
      /* Affichage du message recu */
      printf ("SERVEUR : Message recu = %s\n", buffer);
      /* NB : Pas de `retour' vers le client */
   }
}   


