//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe MonBouton - Extends de JButton, attribut Couleur
//
// Auteur : Pavone Manuel
//
// + Version 1.0.0 				
//

import javax.swing.JButton;
import java.awt.Color;

public class MonBouton extends JButton {
	
	private Color m_Couleur;
	
    public MonBouton(String nom, Color couleur) {
    	
    	super(nom);
    	m_Couleur = couleur;
    	
    }
    
    public Color getCouleur(){
    	return m_Couleur;
    }
    
    
}