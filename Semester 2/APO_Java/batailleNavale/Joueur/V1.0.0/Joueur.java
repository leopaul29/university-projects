/**
 * @(#)Joueur.java
 *
 * V0.0.0 : Constructeur de Joueur (nom + grille)
 * V1.0.0 : Ajout des accesseurs
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/28
 */
 
package batailleNavale;

import batailleNavale.*;
import java.util.*;
import java.lang.*;

public class Joueur {

// ---											Attribut de la Class Joueur

private String m_nom;
private Grille m_grille_bateau;
private Grille m_grille_coup;
private static int m_compteur_joueur = 0;

// --- 		 									---	Les Constructeurs ---


// ---										Constructeur par defaut

    public Joueur() throws Exception{

		// Si deux joueur existe deja alors il ne peut y en avoir plus
		if (m_compteur_joueur>4) throw new Exception();
	
		m_compteur_joueur ++;
    	m_nom = "Joueur " + m_compteur_joueur; // Premiere instance = Joueur 1
    	m_grille_bateau = new Grille();
    	m_grille_coup = new Grille();
    }

// ---									Premier constructeur (Choix du nom)

    public Joueur(String nom) throws Exception{

		// Si deux joueur existe deja alors il ne peut y en avoir plus
		if (m_compteur_joueur>4) throw new Exception();

    	m_nom = nom;
    	m_grille_bateau = new Grille();
    	m_grille_coup = new Grille();
    	m_compteur_joueur ++;
    }

// ---								Second constructeur (Choix de la taille de la grille)

	public Joueur(int col, int row) throws Exception{

		// Si deux joueur existe deja alors il ne peut y en avoir plus
		if (m_compteur_joueur>4) throw new Exception();

		m_compteur_joueur ++;
		m_nom = "Joueur " + m_compteur_joueur;
		m_grille_bateau = new Grille(col, row);
		m_grille_coup = new Grille(col, row);
	}

// ---							Troisieme constructeur (Choix du nom ET de la taille de la grille)

	public Joueur(String nom, int col, int row) throws Exception{

		// Si deux joueur existe deja alors il ne peut y en avoir plus
		if (m_compteur_joueur>4) throw new Exception();

		m_nom = nom;
		m_grille_bateau = new Grille(col, row);
		m_grille_coup = new Grille(col, row);
		m_compteur_joueur ++;
	}

// --- 		 									---	Les Accesseurs ---

	public String getNom() {return this.m_nom;}
	public Grille getGrilleBateau() {return this.m_grille_bateau;}
	public Grille getGrilleCoup() {return this.m_grille_coup;}
	public static int getCompteurJoueur() {return m_compteur_joueur;}

// ---											--- Les Methodes ---


// ---											Methode toString

	public String toString() {return "[" + m_nom + ", " + m_grille_coup.toString() + "]";}

}


