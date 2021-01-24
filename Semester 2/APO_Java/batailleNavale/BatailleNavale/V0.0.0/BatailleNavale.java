/**
 * @(#)BatailleNavale.java
 *
 * V0.0.0 : Construction des joueurs + methode utile pour la grille
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/10
 */
package batailleNavale;

import java.io.*;
import java.util.*;
import java.lang.*;
import batailleNavale.*;

public class BatailleNavale {

private LinkedHashMap m_bateaux;
private static int m_Compteur_Bateau_j1;
private static int m_Compteur_Bateau_j2;
    
    // ---										Recupérer le num de la colonne par la lettre

	public static int NumCol (String col) {
		
		String str = col;
		int codeASCII;		
		if(str.length() == 1) {
			char L1 = str.charAt(0);
			codeASCII = (int) L1;
			return codeASCII - 64;
		} else { 
			char L1 = str.charAt(0);
			codeASCII = (int) L1;
			int N1 = codeASCII - 64;
			char L2 = str.charAt(1);
			codeASCII = (int) L2;
			int N2 = codeASCII - 64;
			int Ntotal = (N1 * 26) + N2;
			return Ntotal;
		}
	}

// ---											Recupérer la lettre de la colone par le num

	public static String CharCol (int col) {
		
		int codeASCII = col + 64;
		if(codeASCII > 90) {
			int x = col / 26;
			int y = col % 26;
			if((y == 0) && (x>1)) x = x - 1 ; 
			int cA1 = x + 64;
			char lettre1 = (char) cA1;
			String l1 = Character.toString(lettre1);
			int cA2 = codeASCII - (x * 26);
			char lettre2 = (char) cA2;
			String l2 = Character.toString(lettre2);
			return l1 + l2;
		} else { 
			char lettre3 = (char) codeASCII;
			String l3 = Character.toString(lettre3);
			return l3;
		}		
	}
	
    
    // ---					lireLigne qui retourne une chaîne (String) composée des caractères saisis au clavier
    
    /*public static String lireLigne() {
    	BufferedReader lecteur =  nouveau  BufferedReader ( nouveau  StringReader (< string >)); 
		lecteur.readLine();
	}*/
    
  	// ---							« convertir » un coup en un couple de coordonnées (x,y)
  	
  	// ---										Recuperer la coordonnée X
    
  	public static int getX (String coup) {
  		
  		coup = coup + "12";
		if(coup.charAt(0)=='1' || coup.charAt(0)=='2')return 911;
		
  		char a = coup.charAt(0);
	    String b = Character.toString(a); 
	    int c = NumCol(b);
	    return c;
	}
	
	// ---										Recuperer la coordonnée Y
	
	public static int getY (String coup) {
		
		coup = coup + "zqs";
		if(coup.charAt(2)=='q' || coup.charAt(2)=='s')return 911;
		
		int b;
		if(coup.charAt(2)!= 'z'){
			char c = coup.charAt(1);
			String l1 = Character.toString(c);
			char d = coup.charAt(2);
			String l2 = Character.toString(d);
			String e = l1 + l2;
			b = Integer.parseInt(e);
		}else{
			char a = coup.charAt(1);
	    	b = Character.getNumericValue(a);
	    }	
	    return b;
	}
    
    // ---											main
    
    public static void main (String [] arg){
    	
    	//Demarrage de la bataille navale
    	System.out.println("--------------------------------------------------------");
    	System.out.println("		Bienvenue dans la bataille navale");
    	System.out.println("--------------------------------------------------------");
    	
    	System.out.println("\n\nPour commencer, vous devez créer deux joueurs :\n");
    	
    	System.out.println("Si vous ne choisissez pas de nom de joueur, un nom par defaut vous sera attribué.");
    	//Choix du nom du joueur 1
    	System.out.print("Créez un nom de joueur 1 : ");
    	Scanner sc = new Scanner(System.in);
    	String nom1 = sc.nextLine();
    	Joueur j1 = null;
    	
    	//Choix du nom du joueur 2
    	System.out.print("Créez un nom de joueur 2 : "); 
    	String nom2 = sc.nextLine();
    	Joueur j2 = null;
    	System.out.println("");
    	
    	//Choix de la taille de la matrice ou taille par defaut
    	char carac = ' ';
    	
    	do{
    		//Choisir une taille de matrice a definir ou par défaut(controle)
    		System.out.print("Choisissez un taille de matrice(O) ou choisir la taille par défaut(N) : ");
    		carac = sc.nextLine().charAt(0);
    		System.out.println("");
    	
	    	if(carac == 'O'){
	    		//Si on choisi de définir la taille de la matrice
	    		System.out.println("le nombre minimum de ligne et colonne est 10, le maximum est 26");
	    		int ligne = 0, colonne = 0;
	    		
	    		do{
	    			//Choisir le nombre de ligne(controle)
	    			System.out.print("Choisissez un nombre de ligne et colonne : ");
		    		ligne = sc.nextInt();
		    		colonne  = ligne;
	    		}while(ligne < 10 || ligne > 26);
					    	
		    	System.out.println("");
		    	//Création du joueur 1 avec ou sans nom:
	    		if(nom1.compareTo("")==0){try{j1= new Joueur(ligne,colonne);}catch(Exception e){}
	    		}else{try{j1= new Joueur(nom1,ligne,colonne);}catch(Exception e){}
	    		}
	    		
	    		//Création du joueur 2 avec ou sans nom:
	    		if(nom1.compareTo("")==0){try{j2= new Joueur(ligne,colonne);}catch(Exception e){}
	    		}else{try{j2= new Joueur(nom2,ligne,colonne);}catch(Exception e){}
	    		}
	    		
	    		//Affichage des noms de joueur et de la taille de la grille
	    		System.out.println("Les " + Joueur.getCompteurJoueur() + " Joueur sont " + j1.getNom() + " et " + j2.getNom());
	    		System.out.println("La grille est de taille (" + ligne + ", " + colonne + ")\n");
	    	}
	    	
	    	//Création de joueur avec une grille de taille normal
	    	if(carac == 'N'){
	    		//Création du joueur 1 avec ou sans nom:
	    		if(nom1.compareTo("")==0){try{j1= new Joueur();}catch(Exception e){}
	    		}else{try{j1= new Joueur(nom1);}catch(Exception e){}
	    		}
	    			
	    		//Création du joueur 2 avec ou sans nom:
	    		if(nom2.compareTo("")==0){try{j2= new Joueur();}catch(Exception e){}
	    		}else{try{j2= new Joueur(nom2);}catch(Exception e){}
	    		}
	    		
	    		//Affichage des noms de joueur et de la taille de la grille
	    		System.out.println("Les " + Joueur.getCompteurJoueur() + " Joueur sont " + j1.getNom() + " et " + j2.getNom());
    			System.out.println("La grille est de taille normal\n");
    		}
    	}while(carac != 'O' && carac != 'N');//Redemande si mauvaise reponse
    	
    	//Le joueur 1 va placer ses bateaux
    	System.out.println("Grille bateau de base de " + j1.getNom());
    	//Affichage de la grille avant de placer ses bateaux
    	(j1.getGrilleBateau()).afficheGrille();
    	
    	// --- Fin création des joueurs et de la grille
    }
    
}