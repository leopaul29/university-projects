
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Fraction - Modelisation des point sur Z*Z
//
// Edition "Draft" : le point d'entree simule les tests unitaires
//
// + Version 0.0.0

// Auteur : S. Nicoletti

package maths;

public class Point {
	
	char m_nom;
	double m_x;
	double m_y;
	final double EPISLON = 1./10000; 
	
	
	//										Constructeur par defaut
	
	public Point ()
	{
		this.m_nom = '_';
		this.m_x=0.0d;
		this.m_y=0.0d;
		
	}
	
	public Point (double x, double y)
	{
		this.m_nom = '_';
		this.m_x=x;
		this.m_y=y;
		
	}
	
	public Point (char nom,double x, double y)
	{
		this.m_nom = nom;
		this.m_x=x;
		this.m_y=y;
		
	}
	
	
	//										Accesseur de consultation
	
	
	public char getNom ()
	{
		return this.m_nom;
	}
	
	public double x ()
	{
		return this.m_x;
	}
	
	public double y ()
	{
		return this.m_y;
	}
	
	//											Methode toString
	
	public String toString ()
	{
		return this.m_nom + " (" + this.m_x + ", " + this.m_y + ")";
	}
	
	public boolean confondus (Point op2)
	{
		return ( (Math.abs(this.x() - op2.x()) <= EPISLON) &&  (Math.abs(this.y() - op2.y()) <= EPISLON) );
	}
	
	//											Methode projX
	public Point projX ()
	{
		return new Point (this.x(),0);
	}
	//											Methode projY
	public Point projY ()
	{
		return new Point (0,this.y());
	}
	//											Methode distance
	public double distance (final Point op2)
	{
		return Math.sqrt( Math.pow(op2.x() - this.x(), 2) + Math.pow(op2.y() - this.y(), 2) );
	}

}
