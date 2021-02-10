/**
 * @(#)PointColore.java
 *
 *
 * @author 
 * @version 1.00 2013/5/22
 */
package maths.geometrie;

import java.awt.*;

public class PointColore extends Point {

	// ---										  Attribut couleur

	Color m_couleur;

	// ---											Constructeur
	//
	// ---										Constructeur par défaut

    public PointColore() {
    	
    	super();
    	m_couleur = Color.black;
    }

	// ---										1er Constructeur normal

    public PointColore(double x, double y, Color couleur) {
    	
    	super(x,y);
    	m_couleur = couleur;
    }

	// ---										2ème Constructeur normal
 	
    public PointColore(char nom, double x, double y, Color couleur) {

    	super(nom,x,y);
    	m_couleur = couleur;
    }
    
	// ---									Accesseurs de consultation couleur

	public Color getCouleur() {return m_couleur;}
    
	// ---  									Metohde memeCouleur
    
	public boolean memeCouleur(PointColore p1) {if(this.getCouleur() == p1.getCouleur()) return true; else return false;}

	// ---										Methode toString
	@Override
	public String toString() {return super.toString() + " : " + m_couleur;}
	
	// ---	   									Methode equals

	public boolean equals(Object obj) {
		
		if((super.equals(obj) == true) && (m_couleur == ((PointColore)obj).getCouleur())) return true;
		else return false;
	}

}