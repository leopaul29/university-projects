package Data.V120;

//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Gestion de fichiers de donnees
//
// Classe Texte - Services de gestion de fichiers texte
//
// Edition A    : enregistrement et chargement d'un fichier texte
//
//    + Version 1.0.0  : version initiale    
/**
 *
 * La classe Texte fournit deux services destines a simplifier la gestion 
 * des fichiers texte (caracteres Unicode), strictement compatibles avec
 * ceux produits par l'outil standard Bloc-notes de Windows :.
 *
 * Les services rendus sont :
 *
 * load   : charger un texte depuis un fichier source designe par son chemin
 * store  : enregistrer un texte dans un fichier cible designe par son chemin.
 *
 * @author XXXX
**/

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

abstract public class Texte {
	
/**
 *
 * La methode store enregistre dans un fichier cible designe par son  
 * chemin le tableau de chaines de caracteres fourni en parametre.
 * Elle y ajoute l'extension .txt. Si le fichier n'existe pas deja, 
 * il sera cree.
 * 
**/

// ---                                                   Methode store
//
   public static boolean store (String[] texte, 
                                String  cheminComplet) {                          	      

	   
      // Controler la validite des deux parametres
      //
      if (texte == null) return false;
      if (cheminComplet == null) return false;
      
      // Construire un fichier logique et le fichier physique associe
      //
      FileWriter f= null;
      try {
		f = new FileWriter(cheminComplet);
	} catch (IOException e1) {e1.printStackTrace();}
      	
      // Construire un flux de sortie base sur le fichier logique
      //
      BufferedWriter out = new BufferedWriter(f);
      
      // Recopier le texte source au complet dans le flux de sortie
      //
      
      try {
	      for(int i=0; i<texte.length; i++)
			out.write(texte[i]);

      } catch (IOException e) {e.printStackTrace();}
            
      // Fermer le flux de sortie
      //
      try {
		out.close();
	} catch (IOException e) {e.printStackTrace();}
      
      // Visualiser dans la console un message de succes
      //
      String msgConsole;
      msgConsole= "Enregistrement du fichier " + cheminComplet  + " : OK";
      
      System.out.println(msgConsole);
      
      return true;
   }
   
/**
 *
 * La methode load charge le contenu textuel d'un fichier source 
 * (designe par parametre)  dans un tableau resultant de chaines de
 * caracteres. L'extension .txt est ajoutee automatiquement avant
 * la lecture effective du fichier source.
 * 
**/

// ---                                                 Methode load
//

public static String[] load (String  cheminComplet) {
    
      // Controler la validite du parametre
      //
      if (cheminComplet == null) return null;
       
      // Controler l'existence du fichier source
      //
      File fichier = new File(cheminComplet);
      
      if( !fichier.exists())
    	  	return null;  
      
      // Construire un flux d'entree base sur le fichier logique
      //
      
      FileReader fin;
      BufferedReader in = null;
	try {
		fin = new FileReader(fichier);
	     in = new BufferedReader(fin);
	} 
	catch (FileNotFoundException e1) {e1.printStackTrace();}

      // Lire le flux ligne a ligne et transferer ces lignes dans
      // une liste alimentee pas a pas
      //
      String ligneTexte= null;
      ArrayList<String> texte= new ArrayList<String>();
      try {
         ligneTexte = in.readLine();
         while (ligneTexte != null) {
        	texte.add(ligneTexte);
            ligneTexte = in.readLine();
         }
      }
      catch (Exception e) {return null;}
 
      // Fermer le flux d'entree
      //
      try {
		in.close();
      } catch (IOException e) {e.printStackTrace();}
      
      // Visualiser dans la console un message de succes
      //
      String msgConsole;
      msgConsole= "Chargement du fichier " + cheminComplet + " : OK";    
      System.out.println(msgConsole);
      
      // Recopier le texte dans un tableau resultant
      //
      ArrayList<String> resultat= new ArrayList<>();
      
      try {
    	  BufferedReader entree = new BufferedReader(new  FileReader(fichier));
    	  
          String contenu = new String();
          while ((contenu=entree.readLine())!=null)
          {
        	  if(contenu!= null)
        	  {
        		resultat.add(contenu);
        	  }
          }
    	  
      } 
      catch (FileNotFoundException e) {e.printStackTrace();}
      catch (IOException e) {e.printStackTrace();}
    
      String [] resultatTab = new String [resultat.size()];
       
      for (int i =0; i< resultat.size(); i++)
      {
    	  resultatTab[i] = resultat.get(i);
      }
      
      // Restituer le resultat
      //
      return resultatTab;
   }
   
// ---                                                    Methode main
//
   
   public static void main(String[] args) {
   String[] source = new String[3];
     
      // Construire un texte de test
      //
      source[0] = "La vengence est un plat qui se mange avec des petits pois.";
      source[1] = "\nJour de pluie, jour sans soucis.";
      source[2] = "\nNinja des montagnes n'aime pas les patates grillées avec une poele legendaire.";

      // Enregistrer la source dans un fichier du
      // repertoire courant
      //
      Texte.store(source, "Exemple.txt");
	
      // Charger en memoire le fichier precedent
      //
      String[] texte= Texte.load("Exemple.txt");
	  
      // Visdualiser le texte resultant dans la console
      //
      System.out.println("\nTexte recharge : \n");
      for(int i = 0; i<texte.length; i++) System.out.println(texte[i]);
   }
}
