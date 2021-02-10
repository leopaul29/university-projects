//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Fenetre - Modelisation d'une fenetre X*Y
//
// Auteur : Pavone Manuel
//
// + Version 0.0.0 : - Constructeurs
//

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

public class Fenetre extends JFrame{
	

	// Constructeur par defaut: Taille 200*200
	//
    public Fenetre() {
	    //Definir un titre pour la fenetre
	    //
    	this.setTitle("Fentre par défaut");

	    
	    //Definir la taille de la fenetre (200*200)
	    //
    	this.setSize(200,200);	
	    
	    //Definir comment la fenetre devra se fermer (Croix rouge)
	    //
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //Rendre visible la fenetre
	    //     
    	this.setVisible(true);
    }
    
    
   
    
    
    
    
    
    
    // Constructeur normal: Nom + Taille X*Y
	//
    public Fenetre(String nom, int x, int y, Color laCouleur) {
    	
 	    //Definir un titre pour la fenetre
 	    //
     	this.setTitle(nom);
 	    
 	    //Definir la taille de la fenetre (x*y)
 	    //
     	this.setSize(x,y);	
 	    
 	    //Definir comment la fenetre devra se fermer (Croix rouge)
 	    //
 	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	    
 	    //Application de la couleur passé en paramètre en couleur de fond
 	    JPanel pan = new JPanel();
 	    pan.setBackground(laCouleur);
 		this.setContentPane(pan); 
 	    
 	    //Rendre visible la fenetre
 	    //     
     	this.setVisible(true);

    	
    }
    
}