//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe FormeGeo -
// Auteur : S. Nicoletti
//
package maths;


public abstract class FormeGeo{
	
	
	private Point m_ptOrigine = new Point ();
	private double EPISLON = 1./10000;
	
	
	public FormeGeo()
	{
		m_ptOrigine = new Point();
	}
	
	public FormeGeo(double x, double y)
	{
		m_ptOrigine = new Point(x,y);
	}
	
	public FormeGeo (Point p)
	{
		m_ptOrigine = (Point) p.clone();
	}
	
	public Point getPoint ()
	{
		return this.m_ptOrigine;
	}
	
	public void translation (double dx, double dy) throws Exception
	{ 	
		if (dx <0 || dy < 0)
			throw new Exception ();
		
		this.m_ptOrigine.translation(dx,dy);
	}
	
	
	public abstract double getAire();
	public abstract void redimension( double h, double v) throws Exception;

}