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
import java.awt.CardLayout;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class Fenetre extends JFrame implements ActionListener{
	
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
	    content = new JPanel();
	    content.setBackground(Color.RED); 
       
	    
	    // Creation d'un Layout: BorderLayout
	    //
	    this.setLayout(new BorderLayout());	
	    
	    // JPanel avec Bouton
	    //
		    // Creation du pannel
	    	content.setBackground(laCouleur);
	    	this.setContentPane(content);
 		
		    
		    // Creation de deux boutons (MonBouton)

	    	MonBouton bouton = new MonBouton("Couleur Bleu",Color.RED);
	 		MonBouton bouton2 = new MonBouton("Couleur Rouge",Color.BLUE);

		    
		    // Ajout de l'actionListener sur chaque bouton, (paramtètre this)
	 		 //Définition de l'action du bouton
	 	    bouton.addActionListener(new ActionListener(){
	 	    	public void actionPerformed(ActionEvent event){
	 	    		changeCouleur(Color.BLUE);
	 	      }
	 	    });
	 	         
	 	    
	 	    //Définition de l'action du bouton2
	 	    bouton2.addActionListener(new ActionListener(){
	 	    	public void actionPerformed(ActionEvent event){   
	 	    		changeCouleur(Color.RED);
	 	      }
	 	    });
		    
		    // Ajout des boutons au Jpanel
	 		this.getContentPane().add(bouton, BorderLayout.CENTER);
	 	    this.getContentPane().add(bouton2, BorderLayout.NORTH);
	 	    
    	
    }
    
    
    public void changeCouleur(Color couleur){
    	//Changer le background de l'objet content
    	content.setBackground(couleur);

    }

    
	public void actionPerformed(ActionEvent arg0) {
		changeCouleur(((MonBouton)arg0.getSource()).getCouleur());
	}  
    
}