//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Ellipse-
//
// Auteur : S. Nicoletti
//

package Math.Geometrie.Ellipse.V000;
import Math.Geometrie.Point.V100.*;
import Math.Geometrie.FormGeo.V000.FormeGeo;
import Math.Geometrie.Pivotable.*;


public class Ellipse extends FormeGeo implements Pivotable{
	
	private double m_Largeur;
	private double m_Hauteur;
	
	public Ellipse ()
	{
		super();
		m_Largeur = 0;
		m_Hauteur = 0;
	} 
		
	
	public Ellipse ( double largeur, double hauteur) throws Exception
	{
		super();
		if( largeur < 0. || hauteur <0. )
			throw new Exception();
		
		m_Largeur = largeur;
		m_Hauteur = hauteur;
	}
	
	public Ellipse ( double x, double y, double largeur, double hauteur) throws Exception
	{
		super(x,y);
		if( largeur < 0. || hauteur <0. )
			throw new Exception();
		
		m_Largeur = largeur;
		m_Hauteur = hauteur;
	}
	
	public Ellipse ( Point p)
	{
		super(p);
		m_Largeur = 0;
		m_Hauteur = 0;
	}
	
	public Ellipse (Point p, double largeur, double hauteur) throws Exception
	{
		super(p);
		if( largeur < 0 || hauteur <0 )
			 throw new Exception();

		m_Largeur = largeur;
		m_Hauteur = hauteur;
	}
	
	//															Accesseur 
	
	public Point getCentre (){ return super.getPoint();}
	public double getLargeur() {return this.m_Largeur;}
	public double getHauteur() {return this.m_Hauteur;}
	
	//															Méthode toString
	
	public String toString(){ return "Ellipse: [ " + this.m_ptOrigine.toString() + " ," +m_Largeur + " ," + m_Hauteur + " ]";}
	
	//															Méthode estVide
	public boolean estVide()
	{
		return this.m_Largeur == 0 && this.m_Hauteur == 0 ;
	}
	
	public void redimension (double h, double v)
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
	

	public double getAire() {
		
		return PI * this.m_Hauteur * this.m_Largeur;
	}
	
	public double getPerimetre()
	{
		return PI*Math.sqrt(2*(Math.pow(this.m_Hauteur, 2)+Math.pow(this.m_Largeur, 2)));
	}


	public void rotation(double angle) {
		// TODO Auto-generated method stub
		
	}

}
