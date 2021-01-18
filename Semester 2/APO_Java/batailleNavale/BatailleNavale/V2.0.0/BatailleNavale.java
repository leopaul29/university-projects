/**
 * @(#)BatailleNavale.java
 *
 * V0.0.0 : Construction des joueurs + methode utile pour la grille
 * V1.0.0 : Placement des bateaux pour les 2 joueurs
 * V2.0.0 : Fin de la partie lorsqu'un joueur n'a plus de bateau
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/28
 */
 
package batailleNavale;

import java.io.*;
import java.util.*;
import java.lang.*;
import batailleNavale.*;

public class BatailleNavale {

private LinkedHashMap m_bateaux;
private static int m_Compteur_Bateau_j1 = 0;
private static int m_Compteur_Bateau_j2 = 0;

	// ---												Accesseurs du nombre de bateaux d'un joueur
	
	public static int getComptBatJ1() {return m_Compteur_Bateau_j1;}
	public static int getComptBatJ2() {return m_Compteur_Bateau_j2;}
    
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
	
	// ---											Recuperer coordonnée
	
	public int recupCoord (String coup) {
		
	    int a = getX(coup);
	    int b = getY(coup);
	    int c = a + b;
	    return c;
	}
    
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
	
	// --- 											Saut de ligne pour afficher la suite plus clairement
	
	public static void SautLigne(){
		Scanner sc = new Scanner(System.in);
		String Saut = sc.nextLine();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
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
    	
    	System.out.println(j1.getNom() + ", placer ses bateaux :");
    	
    	//declaration de variable utilisé pour placer les bateaux
    	boolean BadCoord = false; int a, b, c, d, e, f, g, h;
    	
    	// --- Les 3 torpilleurs
    		// --- Premier torpilleur
    		do{
    			BadCoord = false;String coordT11=" ", coordT12=" ";
    			System.out.println("Premier torpilleur :");
    			do{//Saisi de la premiere case du premier torpilleur
		    		System.out.print("Notez les premier coordonnées (exemple B5) : ");
		    		coordT11 = sc.nextLine();
		     		b = getX(coordT11);
		    		a = getY(coordT11);
		    	}while(a==911);
		    	
	    		do{//Saisi de la deuxieme case du premier torpilleur
	    			System.out.print("Notez les deuxieme coordonnées :");
		    		coordT12 = sc.nextLine();
		      		d = getX(coordT12);
		    		c = getY(coordT12); 
		    	}while(c==911);
		    	
		    	//Placement du premier torpilleur
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");
	    	
	    	// --- Deuxième torpilleur
	    	do{
	    		BadCoord = false;
	    		System.out.println("Deuxième torpilleur :");
	    		do{//Saisi de la premiere case du deuxième torpilleur
		    		System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordT21 = sc.nextLine();
			    	b = getX(coordT21);
			    	a = getY(coordT21);
	    		}while(a==911);
		    
	    		do{//Saisi de la deuxième case du deuxième torpilleur
		    		System.out.print("Notez les deuxieme coordonnées :");
			    	String coordT22 = sc.nextLine();
			    	d = getX(coordT22);
			    	c = getY(coordT22);
	    		}while(c==911);
	    		
		    	//Placement du deuxième torpilleur
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");
	    	
	    	// --- Troisième torpilleur
	    	do{
	    		BadCoord = false;
	    		System.out.println("Troisième torpilleur :");
	    		do{//Saisi de la premiere case du troisième torpilleur
		    		System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordT31 = sc.nextLine();
			    	b = getX(coordT31);
			    	a = getY(coordT31);	
	    		}while(a==911);
		    	
	    		do{//Saisi de la deuxièeme case du troisième torpilleur
		    		System.out.print("Notez les deuxieme coordonnées : ");
			    	String coordT32 = sc.nextLine();
			    	d = getX(coordT32);
			    	c = getY(coordT32);	
	    		}while(c==911);
	    		
		    	//Placement du troisième torpilleur
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j1.getNom() + " apres la pose des torpilleur : \n");
    	(j1.getGrilleBateau()).afficheGrille();
	    System.out.println("");
	    
	    // --- Les 2 Croiseurs
	    	// --- Premier Croiseurs
	    	do{
	    		BadCoord = false;
	    		System.out.println("Premier croiseur :");
	    		do{//Saisi de la premiere case du premier croiseur
		    		System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordC11 = sc.nextLine();
			    	b = getX(coordC11);
			    	a = getY(coordC11);
	    		}while(a==911);
		    	
	    		do{//Saisi de la deuxième case du premier croiseur
		    		System.out.print("Notez les deuxieme coordonnées : ");
			    	String coordC12 = sc.nextLine();
			    	d = getX(coordC12);
			    	c = getY(coordC12);
	    		}while(c==911);
		    	
		    	do{//Saisi de la troisieme case du premier croiseur
			    	System.out.print("Notez les troisieme coordonnées : ");
			    	String coordC13 = sc.nextLine();
			    	f = getX(coordC13);
			    	e = getY(coordC13);
			    }while(e==911);
		    	
		    	//Placement du Premier Croiseurs
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d,e,f);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");
	    	
	    	// --- Deuxième Croiseurs
	    	do{
	    		BadCoord = false;
	    		System.out.println("Deuxième croiseur :");
	    		do{//Saisi de la premiere case du deuxieme croiseur
			    	System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordC21 = sc.nextLine();
			    	b = getX(coordC21);
			    	a = getY(coordC21);
			    }while(a==911);
	    		
	    		do{//Saisi de la deuxieme case du deuxieme croiseur
		    		System.out.print("Notez les deuxieme coordonnées : ");
			    	String coordC22 = sc.nextLine();
			    	d = getX(coordC22);
			    	c = getY(coordC22);
			    }while(c==911);
		    	
		    	do{//Saisi de la troisieme case du deuxieme croiseur
			    	System.out.print("Notez les troisieme coordonnées : ");
			    	String coordC23 = sc.nextLine();
			    	f = getX(coordC23);
			    	e = getY(coordC23);
			    }while(e==911);
		    	
		    	//Placement du Deuxième Croiseurs
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d,e,f);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j1.getNom() + " apres la pose des croiseurs : \n");
    	(j1.getGrilleBateau()).afficheGrille();
	    System.out.println("");
	    
	    // --- Le Cuirassé
	    	do{
	    		BadCoord = false;
	    		System.out.println("Cuirassé :\nLes coordonnées doivent être rentrées dans l'ordre croissant(exemple A1,A2,A3,A4)");
	    		do{//Saisi de la troisieme case du Cuirassé
			    	System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordC31 = sc.nextLine();
			    	b = getX(coordC31);
			    	a = getY(coordC31);
	    		}while(a==911);
	    		
	    		do{//Saisi de la troisieme case du Cuirassé
		    		System.out.print("Notez les deuxieme coordonnées : ");
			    	String coordC32 = sc.nextLine();
			    	d = getX(coordC32);
			    	c = getY(coordC32);
		    	}while(c==911);
		    	
		    	do{//Saisi de la troisieme case du Cuirassé
			    	System.out.print("Notez les troisieme coordonnées : ");
			    	String coordC33 = sc.nextLine();
			    	f = getX(coordC33);
			    	e = getY(coordC33);
		    	}while(e==911);
		    	
		    	do{//Saisi de la troisieme case du Cuirassé
			    	System.out.print("Notez les quatrième coordonnées : ");
			    	String coordC34 = sc.nextLine();
			    	h = getX(coordC34);
			    	g = getY(coordC34);
		    	}while(g==911);
		    	
		    	//Placement du Cuirassé
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d,e,f,g,h);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j1.getNom() + " apres la pose de tous les bateaux : \n");
    	(j1.getGrilleBateau()).afficheGrille();
    	
	    SautLigne();
	    
	    //Le joueur 2 va placer ses bateaux
    	System.out.println("Grille bateau de base de " + j2.getNom());
    	//Affichage de la grille avant de placer ses bateaux
    	(j2.getGrilleBateau()).afficheGrille();
    	
    	System.out.println(j2.getNom() + ", placer ses bateaux :");
    	
    		// --- Les 3 torpilleurs
    		// --- Premier torpilleur
    		do{
    			BadCoord = false;String coordT11=" ", coordT12=" ";
    			System.out.println("Premier torpilleur :");
    			do{//Saisi de la premiere case du premier torpilleur
		    		System.out.print("Notez les premier coordonnées (exemple B5) : ");
		    		coordT11 = sc.nextLine();
		     		b = getX(coordT11);
		    		a = getY(coordT11);
		    	}while(a==911);
		    	
	    		do{//Saisi de la deuxieme case du premier torpilleur
	    			System.out.print("Notez les deuxieme coordonnées :");
		    		coordT12 = sc.nextLine();
		      		d = getX(coordT12);
		    		c = getY(coordT12); 
		    	}while(c==911);
		    	
		    	//Placement du premier torpilleur
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");
	    	
	    	// --- Deuxième torpilleur
	    	do{
	    		BadCoord = false;
	    		System.out.println("Deuxième torpilleur :");
	    		do{//Saisi de la premiere case du deuxième torpilleur
		    		System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordT21 = sc.nextLine();
			    	b = getX(coordT21);
			    	a = getY(coordT21);
	    		}while(a==911);
		    
	    		do{//Saisi de la deuxième case du deuxième torpilleur
		    		System.out.print("Notez les deuxieme coordonnées :");
			    	String coordT22 = sc.nextLine();
			    	d = getX(coordT22);
			    	c = getY(coordT22);
	    		}while(c==911);
	    		
		    	//Placement du deuxième torpilleur
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");
	    	
	    	// --- Troisième torpilleur
	    	do{
	    		BadCoord = false;
	    		System.out.println("Troisième torpilleur :");
	    		do{//Saisi de la premiere case du troisième torpilleur
		    		System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordT31 = sc.nextLine();
			    	b = getX(coordT31);
			    	a = getY(coordT31);	
	    		}while(a==911);
		    	
	    		do{//Saisi de la deuxièeme case du troisième torpilleur
		    		System.out.print("Notez les deuxieme coordonnées : ");
			    	String coordT32 = sc.nextLine();
			    	d = getX(coordT32);
			    	c = getY(coordT32);	
	    		}while(c==911);
	    		
		    	//Placement du troisième torpilleur
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j2.getNom() + " apres la pose des torpilleur : \n");
    	(j2.getGrilleBateau()).afficheGrille();
	    System.out.println("");
	    
	    // --- Les 2 Croiseurs
	    	// --- Premier Croiseurs
	    	do{
	    		BadCoord = false;
	    		System.out.println("Premier croiseur :");
	    		do{//Saisi de la premiere case du premier croiseur
		    		System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordC11 = sc.nextLine();
			    	b = getX(coordC11);
			    	a = getY(coordC11);
	    		}while(a==911);
		    	
	    		do{//Saisi de la deuxième case du premier croiseur
		    		System.out.print("Notez les deuxieme coordonnées : ");
			    	String coordC12 = sc.nextLine();
			    	d = getX(coordC12);
			    	c = getY(coordC12);
	    		}while(c==911);
		    	
		    	do{//Saisi de la troisieme case du premier croiseur
			    	System.out.print("Notez les troisieme coordonnées : ");
			    	String coordC13 = sc.nextLine();
			    	f = getX(coordC13);
			    	e = getY(coordC13);
			    }while(e==911);
		    	
		    	//Placement du Premier Croiseurs
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d,e,f);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");
	    	
	    	// --- Deuxième Croiseurs
	    	do{
	    		BadCoord = false;
	    		System.out.println("Deuxième croiseur :");
	    		do{//Saisi de la premiere case du deuxieme croiseur
			    	System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordC21 = sc.nextLine();
			    	b = getX(coordC21);
			    	a = getY(coordC21);
			    }while(a==911);
	    		
	    		do{//Saisi de la deuxieme case du deuxieme croiseur
		    		System.out.print("Notez les deuxieme coordonnées : ");
			    	String coordC22 = sc.nextLine();
			    	d = getX(coordC22);
			    	c = getY(coordC22);
			    }while(c==911);
		    	
		    	do{//Saisi de la troisieme case du deuxieme croiseur
			    	System.out.print("Notez les troisieme coordonnées : ");
			    	String coordC23 = sc.nextLine();
			    	f = getX(coordC23);
			    	e = getY(coordC23);
			    }while(e==911);
		    	
		    	//Placement du Deuxième Croiseurs
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d,e,f);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j2.getNom() + " apres la pose des croiseurs : \n");
    	(j2.getGrilleBateau()).afficheGrille();
	    System.out.println("");
	    
	    // --- Le Cuirassé
	    	do{
	    		BadCoord = false;
	    		System.out.println("Cuirassé :\nLes coordonnées doivent être rentrées dans l'ordre croissant(exemple A1,A2,A3,A4)");
	    		do{//Saisi de la troisieme case du Cuirassé
			    	System.out.print("Notez les premier coordonnées (exemple B5) : ");
			    	String coordC31 = sc.nextLine();
			    	b = getX(coordC31);
			    	a = getY(coordC31);
	    		}while(a==911);
	    		
	    		do{//Saisi de la troisieme case du Cuirassé
		    		System.out.print("Notez les deuxieme coordonnées : ");
			    	String coordC32 = sc.nextLine();
			    	d = getX(coordC32);
			    	c = getY(coordC32);
		    	}while(c==911);
		    	
		    	do{//Saisi de la troisieme case du Cuirassé
			    	System.out.print("Notez les troisieme coordonnées : ");
			    	String coordC33 = sc.nextLine();
			    	f = getX(coordC33);
			    	e = getY(coordC33);
		    	}while(e==911);
		    	
		    	do{//Saisi de la troisieme case du Cuirassé
			    	System.out.print("Notez les quatrième coordonnées : ");
			    	String coordC34 = sc.nextLine();
			    	h = getX(coordC34);
			    	g = getY(coordC34);
		    	}while(g==911);
		    	
		    	//Placement du Cuirassé
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d,e,f,g,h);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonnée\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j2.getNom() + " apres la pose de tous les bateaux : \n");
    	(j2.getGrilleBateau()).afficheGrille();
	    
	    SautLigne();
    	
    	// --- Fin du placement des bateaux 
    	
    	System.out.println("Le jeu va commencé !");
    	SautLigne();
    	
    	// --- Debut des tires
    	
    	boolean coupJoueur = false; int i, j, k, l, m=0;
    	
    	// --- Boucle de tires jusqu'a ce qu'1 des 2 joueurs n'ai plus de bateaux
    	do{
    		m++; //incrémente le nombre de tours
	    	// --- Tire du joueur 1
	    	do{
	    		coupJoueur = false;
	    		do{
	    	   		System.out.println(j1.getNom() + ", rentrez les coordonnées du coup que vous voulez jouer");
	    	   		String coupJ1 = sc.nextLine();
			    	j = getX(coupJ1);
			    	i = getY(coupJ1);
			    }while(i==911);
		    	try{
		    		(j2.getGrilleBateau()).coup(i,j);
		    		(j2.getGrilleBateau()).getCase(i,j);
		    		(j1.getGrilleCoup()).setCase(i,j,(j2.getGrilleBateau()).getCase(i,j));
		    		//Verification de la cible Raté,Touché,Coulé :
		    		if(j2.getGrilleBateau().estRate(i,j) == true)System.out.print("Raté\n");
		    		if(j2.getGrilleBateau().estTouche(i,j) == true){System.out.print("Touché");
		    			if(j2.getGrilleBateau().estCoule(i,j) == true){m_Compteur_Bateau_j2 --;System.out.print(", Coulé\n");}}
		    		}catch(Exception ex){coupJoueur = true;if(j2.getGrilleBateau().aEteJoue(i,j))System.out.print("Coup deja joué \nVeuillez, ");else System.out.print("Mauvaise Coordonnée\nVeuillez, ");}
	    	}while(coupJoueur==true);//Redonner des coordonnées tant qu'elle ne sont pas correcte
	    	
	    	SautLigne();
	    	
	    	System.out.println("\nGrille de bateau de " + j1.getNom());//Affiche la grille des bateaux
	    	(j1.getGrilleBateau()).afficheGrille();
	    	
	    	SautLigne();
	    	
	    	System.out.println("\nGrille de coup de " + j1.getNom());//Affiche la grille des tires
	    	(j1.getGrilleCoup()).afficheGrille();
	    	
	    	if(m_Compteur_Bateau_j2 == 0)break;//fin de la partie si le joueur 1 a detruit le dernier bateau du joueur 2
	    	
	    	// --- Tire du joueur 2
	    	do{
	    		coupJoueur = false;
	    		do{
		    	   	System.out.println(j2.getNom() + ", rentrez les coordonnées du coup que vous voulez jouer");
		    	   	String coupJ2 = sc.nextLine();
				    l = getX(coupJ2);
				    k = getY(coupJ2);
			    }while(k==911);
		    	try{
		    		(j1.getGrilleBateau()).coup(k,l);
		    		(j1.getGrilleBateau()).getCase(k,l);
		    		(j2.getGrilleCoup()).setCase(k,l,(j1.getGrilleBateau()).getCase(k,l));
		    		//Verification de la cible Raté,Touché,Coulé :
		    		if(j1.getGrilleBateau().estRate(k,l) == true)System.out.print("Raté\n");
		    		if(j1.getGrilleBateau().estTouche(k,l) == true){System.out.print("Touché");
		    			if(j1.getGrilleBateau().estCoule(k,l) == true){m_Compteur_Bateau_j1 --;System.out.print(", Coulé\n");}}
		    	}catch(Exception ex){coupJoueur = true;if(j2.getGrilleBateau().aEteJoue(i,j))System.out.print("Coup deja joué \nVeuillez, ");else System.out.print("Mauvaise Coordonnée\nVeuillez, ");}
	    	}while(coupJoueur==true);//Redonner des coordonnées tant qu'elle ne sont pas correcte
	    	
	    	SautLigne();
	    	
	    	System.out.println("\nGrille de bateau de " + j2.getNom());//Affiche la grille des bateaux
	    	(j2.getGrilleBateau()).afficheGrille();
	    	
	    	SautLigne();
	    	
	    	System.out.println("\nGrille de coup de " + j2.getNom());//Affiche la grille des tires
	    	(j2.getGrilleCoup()).afficheGrille();
	  	    	
    	}while(m_Compteur_Bateau_j1!=0);//fin de la partie si le joueur 2 a detruit le dernier bateau du joueur 1	
	    	
	    //partie fini, annonce du nom du joueur qui a gagné ainsi que le nombre de tours joué 
	    System.out.println("--------------------------------------------------------");
	    if(m_Compteur_Bateau_j1 == 0)System.out.println(j2.getNom() + " a gagné la partie en " + m + " tours !\nFélicitation !");
	    else System.out.println(j1.getNom() + " a gagné la partie en " + m + " tours !\nFélicitation !");
	    System.out.println("--------------------------------------------------------");
    }
    
}