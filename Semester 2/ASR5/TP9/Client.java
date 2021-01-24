/**
 * @(#)Client.java
 *
 *
 * @author 
 * @version 1.00 2013/4/10
 */
 package ASR5TP9;

/** Un client tres simple qui envoie n
* lignes au serveur et lit n ligne
*/

import java.io.*;
import java.net.*;

public class Client {
	
	// Choisir un no de port non entre 1-1024
	static final int port = 8080;
	
	public static void main(String args[]) {
		
		try {
			// Passing null to getByName() produces the
			// special "Local Loopback" IP address, for
			// testing on one machine w/o a network:
			
			InetAddress addr = InetAddress.getByName(null);
			
			// On aurait pu utiliser l’adresse ou
			// le nom de façon équivalente
			addr = InetAddress.getByName("192.168.6.226");
			// InetAddress.getByName("127.0.0.1");
			// InetAddress.getByName("localhost");
			
			System.out.println("addr = " + addr);
			Socket socket = new Socket(addr, port);
			System.out.println("socket = " + socket);
			
			DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
			
			for(int i = 0; i < 10; i ++) {
				
				out.println("howdy " + i);
				out.flush(); // Ne pas oublier
				String str = in.readLine();
				System.out.println(str);
			}
			
			out.println("END");
			out.flush(); // Ne pas oublier!
			socket.close();
			
		} catch(Exception e) {e.printStackTrace();}
	}
}