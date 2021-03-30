/*********************************************************/
/*                                                       */
/*  Serveur IPC/BERKELEY  -- DOMAINE UNIX -- MODE UDP    */
/*                                                       */
/* IUT de NICE - Departement INFORMATIQUE - Ph. Lahire   */ 
/*                                                       */
/*********************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <signal.h>

#define BUFSIZE 80
#define SOCKNAME "demo_th1_OOO"
int sd;

void arret_service()
{
   printf("\n SERVEUR : SIGINT recu => Arret du SERVICE\n\n");
   close(sd);
   unlink(SOCKNAME);
   exit(0);
}



int main (int argc, char* argv [])
{
    //une variable socket pour le domaine mono machine
   struct sockaddr_un socket_name;
   char buffer [BUFSIZE];

   //sigint simplement quand on va taper CTRL C ça va arrèter propprememnt l'application en suprimant tout 
   /* Armement du signal SIGINT */
   signal(SIGINT,arret_service);

   //création de socket 
   /* Ouverture d'une socket ds le domaine UNIX, type DATAGRAM */
   if ((sd = socket (AF_UNIX, SOCK_DGRAM, 0)) == -1)
   {
      perror ("*** Echec socket ***"); exit (1);
   }
   
   //on paramètre la socket 
  //family 
  //sun_path = on remplis cette variable avec sockname 
   /* Attribution d'un nom a la socket */
   socket_name.sun_family = AF_UNIX;
   strcpy (socket_name.sun_path, SOCKNAME);

   //après avoir paramètré la prise en local, on annonce a la biblio cette prise est connu à l'extérieure, le sd = le resultat de la création de socket 
   /* Liaison avec le noyau (nommage) */
   if (bind (sd, (struct sockaddr*) &socket_name, sizeof (socket_name))
        == -1)
   {
      perror ("*** Echec bind ***"); exit (1);
   }
   /* Boucle de traitement des `demandes' */
   for (;;)
   {
     //bit zero => on mais le buffer à zero
      bzero (buffer, BUFSIZE);
      //on donne un buffer combien on veux en recevoir les  c'est les parametre pour récupérer qui envois
      if (recvfrom (sd, buffer, sizeof (buffer), 0, 0, 0) == -1)
      {
	 perror ("Echec recvfrom"); exit (1);
      }
      /* Affichage du message recu */
      printf ("SERVEUR : Message recu = %s\n", buffer);
      /* NB : Pas de `retour' vers le client */
   }
}




