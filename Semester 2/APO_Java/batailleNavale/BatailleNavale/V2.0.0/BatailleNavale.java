/**
 * @(#)BatailleNavale.java
 *
 * V0.0.0 : Construction des joueurs + methode utile pour la grille
 * V1.0.0 : Placement des bateaux pour les 2 joueurs
 * V2.0.0 : Fin de la partie lorsqu'un joueur n'a plus de bateau
 *
 * @author MARTIN L�o-Paul et JACQUEMET Corentin
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
    
    // ---										Recup�rer le num de la colonne par la lettre

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

// ---											Recup�rer la lettre de la colone par le num

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
	
    
    // ---					lireLigne qui retourne une cha�ne (String) compos�e des caract�res saisis au clavier
    
    /*public static String lireLigne() {
    	BufferedReader lecteur =  nouveau  BufferedReader ( nouveau  StringReader (< string >)); 
		lecteur.readLine();
	}*/
	
	// ---											Recuperer coordonn�e
	
	public int recupCoord (String coup) {
		
	    int a = getX(coup);
	    int b = getY(coup);
	    int c = a + b;
	    return c;
	}
    
  	// ---							� convertir � un coup en un couple de coordonn�es (x,y)
  	
  	// ---										Recuperer la coordonn�e X
    
  	public static int getX (String coup) {
  		
  		coup = coup + "12";
		if(coup.charAt(0)=='1' || coup.charAt(0)=='2')return 911;
		
  		char a = coup.charAt(0);
	    String b = Character.toString(a); 
	    int c = NumCol(b);
	    return c;
	}
	
	// ---										Recuperer la coordonn�e Y
	
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
    	
    	System.out.println("\n\nPour commencer, vous devez cr�er deux joueurs :\n");
    	
    	System.out.println("Si vous ne choisissez pas de nom de joueur, un nom par defaut vous sera attribu�.");
    	//Choix du nom du joueur 1
    	System.out.print("Cr�ez un nom de joueur 1 : ");
    	Scanner sc = new Scanner(System.in);
    	String nom1 = sc.nextLine();
    	Joueur j1 = null;
    	
    	//Choix du nom du joueur 2
    	System.out.print("Cr�ez un nom de joueur 2 : "); 
    	String nom2 = sc.nextLine();
    	Joueur j2 = null;
    	System.out.println("");
    	
    	//Choix de la taille de la matrice ou taille par defaut
    	char carac = ' ';
    	
    	do{
    		//Choisir une taille de matrice a definir ou par d�faut(controle)
    		System.out.print("Choisissez un taille de matrice(O) ou choisir la taille par d�faut(N) : ");
    		carac = sc.nextLine().charAt(0);
    		System.out.println("");
    	
	    	if(carac == 'O'){
	    		//Si on choisi de d�finir la taille de la matrice
	    		System.out.println("le nombre minimum de ligne et colonne est 10, le maximum est 26");
	    		int ligne = 0, colonne = 0;
	    		
	    		do{
	    			//Choisir le nombre de ligne(controle)
	    			System.out.print("Choisissez un nombre de ligne et colonne : ");
		    		ligne = sc.nextInt();
		    		colonne  = ligne;
	    		}while(ligne < 10 || ligne > 26);
		    	
		    	System.out.println("");
		    	//Cr�ation du joueur 1 avec ou sans nom:
	    		if(nom1.compareTo("")==0){try{j1= new Joueur(ligne,colonne);}catch(Exception e){}
	    		}else{try{j1= new Joueur(nom1,ligne,colonne);}catch(Exception e){}
	    		}
	    		
	    		//Cr�ation du joueur 2 avec ou sans nom:
	    		if(nom1.compareTo("")==0){try{j2= new Joueur(ligne,colonne);}catch(Exception e){}
	    		}else{try{j2= new Joueur(nom2,ligne,colonne);}catch(Exception e){}
	    		}
	    		
	    		//Affichage des noms de joueur et de la taille de la grille
	    		System.out.println("Les " + Joueur.getCompteurJoueur() + " Joueur sont " + j1.getNom() + " et " + j2.getNom());
	    		System.out.println("La grille est de taille (" + ligne + ", " + colonne + ")\n");
	    	}
	    	
	    	//Cr�ation de joueur avec une grille de taille normal
	    	if(carac == 'N'){
	    		//Cr�ation du joueur 1 avec ou sans nom:
	    		if(nom1.compareTo("")==0){try{j1= new Joueur();}catch(Exception e){}
	    		}else{try{j1= new Joueur(nom1);}catch(Exception e){}
	    		}
	    			
	    		//Cr�ation du joueur 2 avec ou sans nom:
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
    	
    	//declaration de variable utilis� pour placer les bateaux
    	boolean BadCoord = false; int a, b, c, d, e, f, g, h;
    	
    	// --- Les 3 torpilleurs
    		// --- Premier torpilleur
    		do{
    			BadCoord = false;String coordT11=" ", coordT12=" ";
    			System.out.println("Premier torpilleur :");
    			do{//Saisi de la premiere case du premier torpilleur
		    		System.out.print("Notez les premier coordonn�es (exemple B5) : ");
		    		coordT11 = sc.nextLine();
		     		b = getX(coordT11);
		    		a = getY(coordT11);
		    	}while(a==911);
		    	
	    		do{//Saisi de la deuxieme case du premier torpilleur
	    			System.out.print("Notez les deuxieme coordonn�es :");
		    		coordT12 = sc.nextLine();
		      		d = getX(coordT12);
		    		c = getY(coordT12); 
		    	}while(c==911);
		    	
		    	//Placement du premier torpilleur
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");
	    	
	    	// --- Deuxi�me torpilleur
	    	do{
	    		BadCoord = false;
	    		System.out.println("Deuxi�me torpilleur :");
	    		do{//Saisi de la premiere case du deuxi�me torpilleur
		    		System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordT21 = sc.nextLine();
			    	b = getX(coordT21);
			    	a = getY(coordT21);
	    		}while(a==911);
		    
	    		do{//Saisi de la deuxi�me case du deuxi�me torpilleur
		    		System.out.print("Notez les deuxieme coordonn�es :");
			    	String coordT22 = sc.nextLine();
			    	d = getX(coordT22);
			    	c = getY(coordT22);
	    		}while(c==911);
	    		
		    	//Placement du deuxi�me torpilleur
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");
	    	
	    	// --- Troisi�me torpilleur
	    	do{
	    		BadCoord = false;
	    		System.out.println("Troisi�me torpilleur :");
	    		do{//Saisi de la premiere case du troisi�me torpilleur
		    		System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordT31 = sc.nextLine();
			    	b = getX(coordT31);
			    	a = getY(coordT31);	
	    		}while(a==911);
		    	
	    		do{//Saisi de la deuxi�eme case du troisi�me torpilleur
		    		System.out.print("Notez les deuxieme coordonn�es : ");
			    	String coordT32 = sc.nextLine();
			    	d = getX(coordT32);
			    	c = getY(coordT32);	
	    		}while(c==911);
	    		
		    	//Placement du troisi�me torpilleur
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
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
		    		System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordC11 = sc.nextLine();
			    	b = getX(coordC11);
			    	a = getY(coordC11);
	    		}while(a==911);
		    	
	    		do{//Saisi de la deuxi�me case du premier croiseur
		    		System.out.print("Notez les deuxieme coordonn�es : ");
			    	String coordC12 = sc.nextLine();
			    	d = getX(coordC12);
			    	c = getY(coordC12);
	    		}while(c==911);
		    	
		    	do{//Saisi de la troisieme case du premier croiseur
			    	System.out.print("Notez les troisieme coordonn�es : ");
			    	String coordC13 = sc.nextLine();
			    	f = getX(coordC13);
			    	e = getY(coordC13);
			    }while(e==911);
		    	
		    	//Placement du Premier Croiseurs
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d,e,f);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");
	    	
	    	// --- Deuxi�me Croiseurs
	    	do{
	    		BadCoord = false;
	    		System.out.println("Deuxi�me croiseur :");
	    		do{//Saisi de la premiere case du deuxieme croiseur
			    	System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordC21 = sc.nextLine();
			    	b = getX(coordC21);
			    	a = getY(coordC21);
			    }while(a==911);
	    		
	    		do{//Saisi de la deuxieme case du deuxieme croiseur
		    		System.out.print("Notez les deuxieme coordonn�es : ");
			    	String coordC22 = sc.nextLine();
			    	d = getX(coordC22);
			    	c = getY(coordC22);
			    }while(c==911);
		    	
		    	do{//Saisi de la troisieme case du deuxieme croiseur
			    	System.out.print("Notez les troisieme coordonn�es : ");
			    	String coordC23 = sc.nextLine();
			    	f = getX(coordC23);
			    	e = getY(coordC23);
			    }while(e==911);
		    	
		    	//Placement du Deuxi�me Croiseurs
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d,e,f);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j1 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j1.getNom() + " apres la pose des croiseurs : \n");
    	(j1.getGrilleBateau()).afficheGrille();
	    System.out.println("");
	    
	    // --- Le Cuirass�
	    	do{
	    		BadCoord = false;
	    		System.out.println("Cuirass� :\nLes coordonn�es doivent �tre rentr�es dans l'ordre croissant(exemple A1,A2,A3,A4)");
	    		do{//Saisi de la troisieme case du Cuirass�
			    	System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordC31 = sc.nextLine();
			    	b = getX(coordC31);
			    	a = getY(coordC31);
	    		}while(a==911);
	    		
	    		do{//Saisi de la troisieme case du Cuirass�
		    		System.out.print("Notez les deuxieme coordonn�es : ");
			    	String coordC32 = sc.nextLine();
			    	d = getX(coordC32);
			    	c = getY(coordC32);
		    	}while(c==911);
		    	
		    	do{//Saisi de la troisieme case du Cuirass�
			    	System.out.print("Notez les troisieme coordonn�es : ");
			    	String coordC33 = sc.nextLine();
			    	f = getX(coordC33);
			    	e = getY(coordC33);
		    	}while(e==911);
		    	
		    	do{//Saisi de la troisieme case du Cuirass�
			    	System.out.print("Notez les quatri�me coordonn�es : ");
			    	String coordC34 = sc.nextLine();
			    	h = getX(coordC34);
			    	g = getY(coordC34);
		    	}while(g==911);
		    	
		    	//Placement du Cuirass�
		    	try{(j1.getGrilleBateau()).placer(a,b,c,d,e,f,g,h);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
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
		    		System.out.print("Notez les premier coordonn�es (exemple B5) : ");
		    		coordT11 = sc.nextLine();
		     		b = getX(coordT11);
		    		a = getY(coordT11);
		    	}while(a==911);
		    	
	    		do{//Saisi de la deuxieme case du premier torpilleur
	    			System.out.print("Notez les deuxieme coordonn�es :");
		    		coordT12 = sc.nextLine();
		      		d = getX(coordT12);
		    		c = getY(coordT12); 
		    	}while(c==911);
		    	
		    	//Placement du premier torpilleur
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");
	    	
	    	// --- Deuxi�me torpilleur
	    	do{
	    		BadCoord = false;
	    		System.out.println("Deuxi�me torpilleur :");
	    		do{//Saisi de la premiere case du deuxi�me torpilleur
		    		System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordT21 = sc.nextLine();
			    	b = getX(coordT21);
			    	a = getY(coordT21);
	    		}while(a==911);
		    
	    		do{//Saisi de la deuxi�me case du deuxi�me torpilleur
		    		System.out.print("Notez les deuxieme coordonn�es :");
			    	String coordT22 = sc.nextLine();
			    	d = getX(coordT22);
			    	c = getY(coordT22);
	    		}while(c==911);
	    		
		    	//Placement du deuxi�me torpilleur
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");
	    	
	    	// --- Troisi�me torpilleur
	    	do{
	    		BadCoord = false;
	    		System.out.println("Troisi�me torpilleur :");
	    		do{//Saisi de la premiere case du troisi�me torpilleur
		    		System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordT31 = sc.nextLine();
			    	b = getX(coordT31);
			    	a = getY(coordT31);	
	    		}while(a==911);
		    	
	    		do{//Saisi de la deuxi�eme case du troisi�me torpilleur
		    		System.out.print("Notez les deuxieme coordonn�es : ");
			    	String coordT32 = sc.nextLine();
			    	d = getX(coordT32);
			    	c = getY(coordT32);	
	    		}while(c==911);
	    		
		    	//Placement du troisi�me torpilleur
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
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
		    		System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordC11 = sc.nextLine();
			    	b = getX(coordC11);
			    	a = getY(coordC11);
	    		}while(a==911);
		    	
	    		do{//Saisi de la deuxi�me case du premier croiseur
		    		System.out.print("Notez les deuxieme coordonn�es : ");
			    	String coordC12 = sc.nextLine();
			    	d = getX(coordC12);
			    	c = getY(coordC12);
	    		}while(c==911);
		    	
		    	do{//Saisi de la troisieme case du premier croiseur
			    	System.out.print("Notez les troisieme coordonn�es : ");
			    	String coordC13 = sc.nextLine();
			    	f = getX(coordC13);
			    	e = getY(coordC13);
			    }while(e==911);
		    	
		    	//Placement du Premier Croiseurs
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d,e,f);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");
	    	
	    	// --- Deuxi�me Croiseurs
	    	do{
	    		BadCoord = false;
	    		System.out.println("Deuxi�me croiseur :");
	    		do{//Saisi de la premiere case du deuxieme croiseur
			    	System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordC21 = sc.nextLine();
			    	b = getX(coordC21);
			    	a = getY(coordC21);
			    }while(a==911);
	    		
	    		do{//Saisi de la deuxieme case du deuxieme croiseur
		    		System.out.print("Notez les deuxieme coordonn�es : ");
			    	String coordC22 = sc.nextLine();
			    	d = getX(coordC22);
			    	c = getY(coordC22);
			    }while(c==911);
		    	
		    	do{//Saisi de la troisieme case du deuxieme croiseur
			    	System.out.print("Notez les troisieme coordonn�es : ");
			    	String coordC23 = sc.nextLine();
			    	f = getX(coordC23);
			    	e = getY(coordC23);
			    }while(e==911);
		    	
		    	//Placement du Deuxi�me Croiseurs
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d,e,f);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j2.getNom() + " apres la pose des croiseurs : \n");
    	(j2.getGrilleBateau()).afficheGrille();
	    System.out.println("");
	    
	    // --- Le Cuirass�
	    	do{
	    		BadCoord = false;
	    		System.out.println("Cuirass� :\nLes coordonn�es doivent �tre rentr�es dans l'ordre croissant(exemple A1,A2,A3,A4)");
	    		do{//Saisi de la troisieme case du Cuirass�
			    	System.out.print("Notez les premier coordonn�es (exemple B5) : ");
			    	String coordC31 = sc.nextLine();
			    	b = getX(coordC31);
			    	a = getY(coordC31);
	    		}while(a==911);
	    		
	    		do{//Saisi de la troisieme case du Cuirass�
		    		System.out.print("Notez les deuxieme coordonn�es : ");
			    	String coordC32 = sc.nextLine();
			    	d = getX(coordC32);
			    	c = getY(coordC32);
		    	}while(c==911);
		    	
		    	do{//Saisi de la troisieme case du Cuirass�
			    	System.out.print("Notez les troisieme coordonn�es : ");
			    	String coordC33 = sc.nextLine();
			    	f = getX(coordC33);
			    	e = getY(coordC33);
		    	}while(e==911);
		    	
		    	do{//Saisi de la troisieme case du Cuirass�
			    	System.out.print("Notez les quatri�me coordonn�es : ");
			    	String coordC34 = sc.nextLine();
			    	h = getX(coordC34);
			    	g = getY(coordC34);
		    	}while(g==911);
		    	
		    	//Placement du Cuirass�
		    	try{(j2.getGrilleBateau()).placer(a,b,c,d,e,f,g,h);}
		    	catch(Exception ex){BadCoord = true;System.out.print("Mauvaise Coordonn�e\n\nReplacer votre ");}
    		}while(BadCoord==true);
    		m_Compteur_Bateau_j2 ++;
	    	System.out.println("");

    	System.out.println("\nGrille de bateaux de " + j2.getNom() + " apres la pose de tous les bateaux : \n");
    	(j2.getGrilleBateau()).afficheGrille();
	    
	    SautLigne();
    	
    	// --- Fin du placement des bateaux 
    	
    	System.out.println("Le jeu va commenc� !");
    	SautLigne();
    	
    	// --- Debut des tires
    	
    	boolean coupJoueur = false; int i, j, k, l, m=0;
    	
    	// --- Boucle de tires jusqu'a ce qu'1 des 2 joueurs n'ai plus de bateaux
    	do{
    		m++; //incr�mente le nombre de tours
	    	// --- Tire du joueur 1
	    	do{
	    		coupJoueur = false;
	    		do{
	    	   		System.out.println(j1.getNom() + ", rentrez les coordonn�es du coup que vous voulez jouer");
	    	   		String coupJ1 = sc.nextLine();
			    	j = getX(coupJ1);
			    	i = getY(coupJ1);
			    }while(i==911);
		    	try{
		    		(j2.getGrilleBateau()).coup(i,j);
		    		(j2.getGrilleBateau()).getCase(i,j);
		    		(j1.getGrilleCoup()).setCase(i,j,(j2.getGrilleBateau()).getCase(i,j));
		    		//Verification de la cible Rat�,Touch�,Coul� :
		    		if(j2.getGrilleBateau().estRate(i,j) == true)System.out.print("Rat�\n");
		    		if(j2.getGrilleBateau().estTouche(i,j) == true){System.out.print("Touch�");
		    			if(j2.getGrilleBateau().estCoule(i,j) == true){m_Compteur_Bateau_j2 --;System.out.print(", Coul�\n");}}
		    		}catch(Exception ex){coupJoueur = true;if(j2.getGrilleBateau().aEteJoue(i,j))System.out.print("Coup deja jou� \nVeuillez, ");else System.out.print("Mauvaise Coordonn�e\nVeuillez, ");}
	    	}while(coupJoueur==true);//Redonner des coordonn�es tant qu'elle ne sont pas correcte
	    	
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
		    	   	System.out.println(j2.getNom() + ", rentrez les coordonn�es du coup que vous voulez jouer");
		    	   	String coupJ2 = sc.nextLine();
				    l = getX(coupJ2);
				    k = getY(coupJ2);
			    }while(k==911);
		    	try{
		    		(j1.getGrilleBateau()).coup(k,l);
		    		(j1.getGrilleBateau()).getCase(k,l);
		    		(j2.getGrilleCoup()).setCase(k,l,(j1.getGrilleBateau()).getCase(k,l));
		    		//Verification de la cible Rat�,Touch�,Coul� :
		    		if(j1.getGrilleBateau().estRate(k,l) == true)System.out.print("Rat�\n");
		    		if(j1.getGrilleBateau().estTouche(k,l) == true){System.out.print("Touch�");
		    			if(j1.getGrilleBateau().estCoule(k,l) == true){m_Compteur_Bateau_j1 --;System.out.print(", Coul�\n");}}
		    	}catch(Exception ex){coupJoueur = true;if(j2.getGrilleBateau().aEteJoue(i,j))System.out.print("Coup deja jou� \nVeuillez, ");else System.out.print("Mauvaise Coordonn�e\nVeuillez, ");}
	    	}while(coupJoueur==true);//Redonner des coordonn�es tant qu'elle ne sont pas correcte
	    	
	    	SautLigne();
	    	
	    	System.out.println("\nGrille de bateau de " + j2.getNom());//Affiche la grille des bateaux
	    	(j2.getGrilleBateau()).afficheGrille();
	    	
	    	SautLigne();
	    	
	    	System.out.println("\nGrille de coup de " + j2.getNom());//Affiche la grille des tires
	    	(j2.getGrilleCoup()).afficheGrille();
	  	    	
    	}while(m_Compteur_Bateau_j1!=0);//fin de la partie si le joueur 2 a detruit le dernier bateau du joueur 1	
	    	
	    //partie fini, annonce du nom du joueur qui a gagn� ainsi que le nombre de tours jou� 
	    System.out.println("--------------------------------------------------------");
	    if(m_Compteur_Bateau_j1 == 0)System.out.println(j2.getNom() + " a gagn� la partie en " + m + " tours !\nF�licitation !");
	    else System.out.println(j1.getNom() + " a gagn� la partie en " + m + " tours !\nF�licitation !");
	    System.out.println("--------------------------------------------------------");
    }
    
}