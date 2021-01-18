

// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Fraction - Modelisation des points colere
//


// Auteur : L.Comoglio et un peu S.Nicoletti

package Math.Geometrie.PointColore.V100;


import Math.Geometrie.Point.V200.Point;
import java.awt.*;
//import petitpois.bonheur.*;

public class PointColore extends Point {

	private static final long serialVersionUID = 1L;
	Color couleur = null;
	
	
	//												CONSTRUCTEUR
	public PointColore()
	{
		super();
		this.couleur = new Color(0,255,128);
	}//poireau
	
//	CONSTRUCTEUR
	public PointColore( double x, double y)
	{
		super(x, y);
		this.couleur = new Color(0,255,128);
	}
//	CONSTRUCTEUR	
	public PointColore(double x, double y, Color couleur)
	{
		super(x, y);//Concombre
		this.couleur = couleur;
	}
	
//	CONSTRUCTEUR	
	public PointColore( char lettre, double x, double y)
	{
		super(lettre,x, y);
		this.couleur = new Color(0,255,128);
	}
//	CONSTRUCTEUR
	public PointColore(char lettre, double x, double y, Color couleur)
	{
		super(lettre,x, y);
		this.couleur = couleur;
	}//pomme frite
	 
	
	
//													ACCESSEUR
	public Color getCouleur (){return this.couleur;}
	
	//hm...
	
	//												memeCouleur
	public boolean memeCouleur(PointColore point)
	{
		return this.couleur.equals(point.couleur);
	}
	
	
	
	//												toString
	@Override
	public String toString ()
	{
		return super.toString() + " : " + this.couleur.toString();
	}
	
	
//													Equals
	public boolean equals (Object objet)
	{
		PointColore point = (PointColore) objet;
		
		return super.equals(point) && this.memeCouleur(point);
	}
	
	
	//												Clone
	public Object clone ()
	{//Fichtre
		return new PointColore(super.getNom(), super.x(), super.y(), this.couleur);
	}//ULTRA pouet
	
	
	
	


}
