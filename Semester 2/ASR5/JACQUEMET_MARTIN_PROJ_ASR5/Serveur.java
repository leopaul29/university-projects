/**
 * @(#)Serveur.java
 *
 *
 * @author L�opaul&Corentin
 * @version 1.00 2013/5/23
 */
package Projet;

import java.io.*;
import java.net.*;

class Serveur extends Thread {
	
	private	Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
		// methode pour effectuer la commande netstat
/*	private String netstat() {
		String netstatResult = new String();
		
		String netstatCmd = "netstat -a";
		
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(netstatCmd);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				netstatResult += inputLine;
			}
			netstatResult=netstatResult.replace('�', '�');
			netstatResult=netstatResult.replace('�', ' ');
			netstatResult=netstatResult.replace('�', '�');
			netstatResult=netstatResult.replace('�', '�');
			String resultat="";
			/*for(int i=0;i<tracertResult.length();i++){
				if (tracertResult.charAt(i)=='R' || tracertResult.matches(".*Itin�raire.*"))
					resultat+="<br/>"+tracertResult.charAt(i);
				else if (tracertResult.matches(".*sauts :.*"))
					resultat+=tracertResult.matches(".*sauts :.*")+"</br>";
				else
					resultat+=tracertResult.charAt(i);
			}*//*
			in.close();
		return netstatResult;
		}
		catch (IOException e) {
			netstatResult+="hote injoignable.";
			return netstatResult;
		}
	}
*/
	// methode pour effectuer un ipconfig/all
/*	private String ipconfigAll() {
		String ipconfigAllResult = new String();
		
		String ipconfigAllCmd = "ipconfig/all";
		
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(ipconfigAllCmd);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				ipconfigAllResult += inputLine;
			}
			ipconfigAllResult=ipconfigAllResult.replace('�', '�');
			ipconfigAllResult=ipconfigAllResult.replace('�', ' ');
			ipconfigAllResult=ipconfigAllResult.replace('�', '�');
			ipconfigAllResult=ipconfigAllResult.replace('�', '�');
			String resultat="";
			/*for(int i=0;i<tracertResult.length();i++){
				if (tracertResult.charAt(i)=='R' || tracertResult.matches(".*Itin�raire.*"))
					resultat+="<br/>"+tracertResult.charAt(i);
				else if (tracertResult.matches(".*sauts :.*"))
					resultat+=tracertResult.matches(".*sauts :.*")+"</br>";
				else
					resultat+=tracertResult.charAt(i);
			}*//*
			in.close();
		return ipconfigAllResult;
		}
		catch (IOException e) {
			ipconfigAllResult+="hote injoignable.";
			return ipconfigAllResult;
		}
	}
*/
	Serveur(Socket s) {
		socket = s;
		try { in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch(IOException e) {}
		start(); // Calls run()
	}
	
	// methode pour envoyer une page dont le chemin est pass� en parametre
	public void envoyer(String page, String OS)
	{
		String eligne="";
		String echaine="";
		BufferedReader epage=null;
		String ip=socket.getLocalAddress().toString();
		try
		{ 
			epage = new BufferedReader(new InputStreamReader(new FileInputStream(page)));		
			while((eligne=epage.readLine()) != null)
			{
				if (eligne.equals("</form>"))
					eligne=eligne+"<p>Votre IP : "+ip.substring(1,ip.length())+"<br/>Votre OS : "+OS+"</p>";
				echaine+=eligne+"\r\n";
			}
			int length=echaine.length();
			out.write("HTTP/1.1 200 OK\r\n");
			out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
			out.write("Server: L�opaul&Corentin\r\n");
			out.write("Content-Type: text/html\r\n");
			out.write("Content-Length: "+length+"\r\n");
			out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
			out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
			out.write("\r\n");
			out.write(echaine);
			out.flush();
		}
		catch(IOException ie){}
	}
	
	// methode pour envoyer un message d'erreur
	public void notFound()
	{
		try
		{
			out.write("HTTP/1.1 404 Not Found\r\n");
			out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
			out.write("Server: L�opaul&Corentin\r\n");
			out.write("Content-Type: text/html\r\n");
			out.write("Content-Length: 0\r\n");
			out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
			out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
			out.write("\r\n");
			out.flush();
		}
		catch(IOException ie){}
	}
	
	// methode pour effectuer un ipconfig du serveur
	private String ipconfig()
	{
		String ipconfigResult = new String();
		String ipconfigCmd = "ipconfig ";
		
		try
		{
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(ipconfigCmd);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null)
			{
				ipconfigResult += "</br>" + inputLine;
			}
			// Je traite les caract�res sp�ciaux
			ipconfigResult=ipconfigResult.replace('�', '�');
			ipconfigResult=ipconfigResult.replace('�', ' ');
			ipconfigResult=ipconfigResult.replace('�', '�');
			ipconfigResult=ipconfigResult.replace('�', '�');
			
			in.close();
			return ipconfigResult;
		}
		catch (IOException e)
		{
			ipconfigResult+="Adresse incorrecte ou hote injoignable.";
			return ipconfigResult;
		}
	}
	
	// methode pour effectuer un traceroute sur une adresse
	private String tracert(String adresse)
	{		
		String tracertResult = new String();
		String tracertCmd = "tracert " + adresse;
		
		try
		{
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(tracertCmd);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			{
				tracertResult += "</br>" + inputLine;
			}
			// Je traite les caract�res sp�ciaux	
			tracertResult=tracertResult.replace('�', '�');
			tracertResult=tracertResult.replace('�', ' ');
			tracertResult=tracertResult.replace('�', '�');
			tracertResult=tracertResult.replace('�', '�');
			in.close();
			return tracertResult;
		}
		catch (IOException e)
		{
			tracertResult+="Adresse incorrecte ou hote injoignable.";
			return tracertResult;
		}
	}

	// methode pour effectuer un ping sur une adresse
	private String ping(String adresse)
	{		
		String pingResult = new String();
		String pingCmd = "ping " + adresse;

		try
		{
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(pingCmd);

			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			{
				pingResult +=  "</br>" + inputLine;
			}
			// Je traite les caract�res sp�ciaux
			pingResult=pingResult.replace('�', '�');
			pingResult=pingResult.replace('�', ' ');
			pingResult=pingResult.replace('�', '�');
			pingResult=pingResult.replace('�', '�');
			in.close();
			return pingResult;
		}
		catch (IOException e)
		{
			pingResult+="Adresse incorrecte ou hote injoignable.";
			return pingResult;
		}
	}
	
	public void run()
	{
		try 
		{
			String st="";
			String systeme="unknow";
			st=in.readLine();
			
			// je v�rifie que c'est une requete GET et sans favicon
			if(st.charAt(0)=='G' && st.charAt(5)!='f')
			{
				// Je recup�re quel systeme d'exploitation est utilis�
				String entre=in.readLine();entre=in.readLine(); entre=in.readLine();
				System.out.println(entre);
				if(entre.matches(".*Windows.*"))
					systeme="Windows";
				else if(entre.matches(".*Macintosh.*"))
					systeme="Macintosh";
				else if(entre.matches(".*Linux.*"))
					systeme="Linux";
				
				// j'envois la page index.html
				envoyer("index.html",systeme);
				
				// je stock la requete dans une String
				for(int i=0;i<18;i++)
				{
						st+=in.readLine()+"\r\n";
				}
			}
			
			// je v�rifie que c'est une requete GET et avec favicon
			else if(st.charAt(0)=='G' && st.charAt(5)=='f')
			{
				// traitement de la favicon !!!
			}
			
			// je v�rifie que c'est une requete POST
			else if(st.charAt(0)=='P'){
					
				String value="";
				int longueur=0;
				
				// je stock la requete dans un String
				for(int i=0;i<12;i++)
				{
					// je r�cup�re la longueur de la requete pour r�cup�rer les valeurs du formulaire
					if (i==7)
					{
						String length = in.readLine();
						st+=length;
						longueur=Integer.parseInt(length.substring(16));
					}
					else
					{
						st+=in.readLine()+" ";
						// Je recup�re quel systeme d'exploitation est utilis�
						if(st.matches(".*Windows.*"))
							systeme="Windows";
						else if(st.matches(".*Macintosh.*"))
							systeme="Macintosh";
						else if(st.matches(".*Linux.*"))
							systeme="Linux";
					}
				}
				for (int i=1; i<=longueur;i++)
				{
					value+=(char)in.read();
				}
				// j'isole le champ texte
				String url=value.substring(4, value.indexOf("&"));
				System.out.println("url : "+url);
				
				// j'isole l'option selection�e
				String select=value.substring(value.lastIndexOf("&")+8);
				System.out.println("select : "+select);
					
				// // je traite mon formulaire
					
				// J'acc�de � un fichier qui existe sinon 404 NOT FOUND
				if((!url.isEmpty())&&(select.equals("nothing")))
				{//si le champs texte est remplie et aucune option selectionn�e
					File fichier = new File(url);
					if(fichier.exists())
						envoyer(url,systeme);
					else notFound();
				}
				
				// Je traite le ping
				else if ((url.isEmpty())&&(select.equals("ping")))
				{// si le champs texte est vide et l'option ping est selectionn�e
					envoyer("pingurl.html",systeme);
				}
				else if ((!url.isEmpty())&&(select.equals("ping")))
				{// si le champs texte est remplie et l'option ping est selectionn�e
					String chaine = "<p>"+ping(url)+"</p>";
					int lengthping=chaine.length();
					out.write("HTTP/1.1 200 OK\r\n");
					out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
					out.write("Server: L�opaul&Corentin\r\n");
					out.write("Content-Type: text/html\r\n");
					out.write("Content-Length: "+lengthping+"\r\n");
					out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
					out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
					out.write("\r\n");
					out.write(chaine);
					out.flush();
				}
				
				// Je traite le tracert
				else if ((url.isEmpty())&&(select.equals("tracert")))
				{// si le champs texte est vide et l'option ping est selectionn�e
					envoyer("tracerturl.html",systeme);
				}
				else if ((!url.isEmpty())&&(select.equals("tracert")))
				{// si le champs texte est remplie et l'option tracert est selectionn�e
					String chaine = "<p>"+tracert(url)+"</p>";
					int lengthtracert=chaine.length();
					out.write("HTTP/1.1 200 OK\r\n");
					out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
					out.write("Server: L�opaul&Corentin\r\n");
					out.write("Content-Type: text/html\r\n");
					out.write("Content-Length: "+lengthtracert+"\r\n");
					out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
					out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
					out.write("\r\n");
					out.write(chaine);
					out.flush();
				}
				
				// Je traite l'ipconfig
				else if (select.equals("ipconfig"))
				{// si le champs texte est remplie et l'option ipconfig est selectionn�e
					String chaine = "<p>"+ipconfig()+"</p>";
					int lengthipconfig=chaine.length();
					out.write("HTTP/1.1 200 OK\r\n");
					out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
					out.write("Server: L�opaul&Corentin\r\n");
					out.write("Content-Type: text/html\r\n");
					out.write("Content-Length: "+lengthipconfig+"\r\n");
					out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
					out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
					out.write("\r\n");
					out.write(chaine);
					out.flush();
				}
				
				// si le formulaire n'a pas �t� remplie
				else
				{
					envoyer("champs.html",systeme);
				}
			}
			else envoyer("erreur.html",systeme);
			
			in.close(); out.close();
			socket.close();
		}
		catch (IOException e) {}
	}
}
