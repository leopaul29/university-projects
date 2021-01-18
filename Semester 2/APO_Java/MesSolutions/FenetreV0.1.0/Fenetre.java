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
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame{
	JButton bouton;
	JButton bouton2;
	
	private JPanel content;

	// Constructeur par defaut: Taille 80*80
	//
    public Fenetre() {
    	
	    //Definir un titre pour la fenetre
	    //
	    this.setTitle("Ma première fenêtre Java");
	    
	    //Definir la taille de la fenetre (80*80)
	    //
	    this.setSize(200, 200);
	    
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
    	
    	// Creation de la Fenetre
    	//
	    this.setTitle(nom);
	    this.setSize(x, y);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    	
	    // Instanciation du JPanel
	    //
	    JPanel pan = new JPanel();
 	    
	       
	    
	    // Creation d'un Layout: BorderLayout
	    //
 		this.setLayout(new BorderLayout());

	    
	    // JPanel avec Bouton
	    //
		    // Creation du pannel
	 		pan.setBackground(laCouleur);
	 		this.setContentPane(pan);
	 		
		    
		    // Creation de deux boutons

	 		bouton = new JButton("Premier Bouton");
	 		bouton2 = new JButton("Deuxième Bouton");

		    
		    // Ajout des boutons au Jpanel
	 		this.getContentPane().add(bouton, BorderLayout.CENTER);
	 	    this.getContentPane().add(bouton2, BorderLayout.NORTH);
	 	    
	 	
	   
	    
    	
    }
    
    
    public void changeCouleur(Color couleur){
    	//Changer le background de l'objet content
    	this.setBackground(couleur);
    	
    }

}