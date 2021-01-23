/**
 * @(#)MultiServeur.java
 *
 *
 * @author 
 * @version 1.00 2013/5/23
 */
package Projet;
import java.net.*;
import java.io.*;
import java.util.Date;

public class MultiServeur{
	
	static final int port = 8080;
	
	// methode pour enregistrer les log
	public static void WriteFile (String Text, String directoryName, String fileName) throws IOException{ 

		String directoryPath = System.getProperty("user.dir") + "\\" + directoryName + "\\"; 
		String filePath = System.getProperty("user.dir") + "\\" + directoryName + "\\" + fileName ; 

		//Recupere le chemin du fichier et le chemin de repertoire grace aux parametre
		File file = new File(filePath); 
		File dir = new File(directoryPath); 

		if (dir.exists() && dir.isDirectory() && file.exists()){ 

			try { 
				FileWriter fw = new FileWriter(filePath, true); 
				BufferedWriter output = new BufferedWriter(fw); 
	
				output.write(Text); 
				output.flush(); 
				output.close(); 
	
	
			} catch (IOException ioe) {  
					ioe.printStackTrace(); 
			} catch (java.lang.NullPointerException e){ 
					System.out.println ("Error"); 
					e.printStackTrace(); 
			} 
		} 
		//Crée le fichier s'il n'existe pas 
		else{ 

		if (dir.exists() && dir.isDirectory()){ 

			file.createNewFile(); 
			System.out.println("New file at " + filePath); 
		
			try {	
			FileWriter fw = new FileWriter(filePath, true); 
			BufferedWriter output = new BufferedWriter(fw); 
			output.write(Text); 
			output.flush(); 
			output.close(); 
			System.out.println("Text written!"); 
			} catch (IOException ioe) { 
	 			ioe.printStackTrace(); 
			} catch (java.lang.NullPointerException e){ 
				System.out.println ("Error"); 
				e.printStackTrace(); 
			} 
		//Ecrit le texte dans le fichier 
		} 
		else{ 
		//Crée le dossier s'il n'existe pas ainsi que le fichier 
		dir.mkdir(); 
		System.out.println("New directory at " + directoryPath); 
		file.createNewFile(); 
		System.out.println("New file at " + filePath);	
		try { 
		FileWriter fw = new FileWriter(filePath, true); 
		BufferedWriter output = new BufferedWriter(fw); 
		
		output.write(Text); 
		output.flush(); 
		output.close(); 


		} catch (IOException ioe) { 
		ioe.printStackTrace(); 
		} catch (java.lang.NullPointerException e){ 
		System.out.println ("Error"); 
		e.printStackTrace(); 
		} 
		} 
		} 

		} 
	
	public static void main(String[] args ){
		try {
			ServerSocket s = new
			ServerSocket(port);
			System.out.println("Serv. Started");
			while(true) {
				Socket socket = s.accept();
				Date d=new Date();
				System.err.print("["+d.toString()+"] Nouveau client connecté : ");
				System.out.println(socket.getLocalAddress().toString());
				
				// j'enregistre les log
				WriteFile("["+d.toString()+"] Client : "+socket.getLocalAddress().toString()+System.getProperty("line.separator"), "LOG","log.txt");
				new Serveur(socket);
			}		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
