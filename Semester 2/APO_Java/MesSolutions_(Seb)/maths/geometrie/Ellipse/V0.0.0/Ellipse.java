package maths;
import maths.*;//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Ellipse-
//
// Auteur : S. Nicoletti
//

public class Ellipse {
	
	private Point m_centre;
	private double m_Largeur;
	private double m_Hauteur;
	
	public Ellipse ()
	{
		m_centre = new Point();
		m_Largeur = 1;
		m_Hauteur = 1;
	} 
		
	
	public Ellipse ( double largeur, double hauteur) throws Exception
	{
		if( largeur < 0. || hauteur <0. )
			throw new Exception();
		
		m_centre = new Point();
		m_Largeur = largeur;
		m_Hauteur = hauteur;
	}
	
	public Ellipse ( double x, double y, double largeur, double hauteur) throws Exception
	{
		if( largeur < 0. || hauteur <0. )
			throw new Exception();
		
		m_centre = new Point(x,y);
		m_Largeur = largeur;
		m_Hauteur = hauteur;
	}
	
	public Ellipse ( Point p)
	{
		m_centre = p.clone();
		m_Largeur = 1;
		m_Hauteur = 1;
	}
	
	public Ellipse (Point p, double largeur, double hauteur) throws Exception
	{
		if( largeur < 0 || hauteur <0 )
			 throw new Exception();
			
		m_centre = p.clone();
		m_Largeur = largeur;
		m_Hauteur = hauteur;
	}
	
	//															Accesseur 
	
	public Point getCentre (){ return this.m_centre;}
	public double getLargeur() {return this.m_Largeur;}
	public double getHauteur() {return this.m_Hauteur;}
	
	//															Méthode toString
	
	public String toString(){ return "Ellipse: [ " + this.m_centre.toString() + " ," +m_Largeur + " ," + m_Hauteur + " ]";}
	
	//															Méthode estVide
	public boolean estVide()
	{
		return this.m_Largeur == 0 && this.m_Hauteur == 0 ;
	}
	
	void redimension (double h, double v)
	{
		if (h == 0 || v==0 )
			return;
			
		if ( h > 0 )
			this.m_Largeur *= h;
		else
			this.m_Largeur /= Math.abs(h);
		
		if ( v > 0 )
			this.m_Hauteur *= v;
		else
			this.m_Hauteur /= Math.abs(v);
	}
	
	void translation (double dx, double dy)
	{
		this.m_centre = new Point ( this.m_centre.getNom(), this.m_centre.x() + dx, this.m_centre.x() + dy);
	}

}
