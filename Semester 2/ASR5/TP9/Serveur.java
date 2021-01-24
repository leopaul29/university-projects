/**
 * @(#)Serveur.java
 *
 *
 * @author MARTIN Léo-Paul
 * @version 1.00 2013/4/10
 */
 package ASR5TP9;
 
import java.io.*;
import java.net.*;

public class Serveur {

		/*
	 *Socket()	: 	Le serveur crée une "socket serveur" et se met en attente de la connection d'un client.
	 *				IL créer aussi une "socket client" pour se connecter.
	 *				Le client et le serveur communique par les sockets.
	 *		param : ServeurSocket(@IP, port);
	 *bind() 	: 	Le serveur affecte une adresse IP à une socket particulière si plusieurs carte réseaux.
	 *		param : socket@
	 *socket et bind : en 2 methodes ou une seul en Java
	 *listen() 	:	Le serveur est en attente de connexions. /!\ PAS EN JAVA
	 *accept() 	: 	le serveur attent la fonction connect() du client avant d'écouter.
	 *				Le client initialise ue connexion à un service.
	 *		Fait le listen en même temps
	 *recv() 	:	Le serveur recoit des données.
	 *send() 	: 	Le serveur envoie des données. 
	 *close() 	: 	Fermeture du Socket par la partie cliente et serveur
	 */
	 
/** Un client tres simple qui envoie n
* lignes au serveur et lit n ligne
*/

	// Choisir un no de port non entre 1-1024
	static final int port = 8080;

	public static void main(String[] args ) {

		try {
			//Créer un socket
			ServerSocket s = new ServerSocket(port);
			System.out.println("Serv Started: " + s);
			// Blocks until a connection occurs:
			//Socket qui gère le client
			Socket socket = s.accept();
			System.out.println("Connect. accepted, socket: "+ socket);
			//Création d'objet pour Lire
			BufferedReader in =	new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Création d'objet pour Ecrire
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while (true) {
				String str = in.readLine();
			
				if (str.equals("END")) break;
					System.out.println("Echoing: " + str);
					out.println(str);
					out.flush(); // Ne pas oublier!
			}
			
			System.out.println("closing...");
			socket.close();
			
		} catch(Exception e) {e.printStackTrace();}
	}
}
