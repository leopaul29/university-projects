//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe FormeGeo -
// Auteur : S. Nicoletti
//

package Math.Geometrie.FormGeo.V000;
import Math.Geometrie.Point.V100.*;
import Math.Geometrie.Affichable.*;
import Math.Geometrie.Deplacable.*;


public abstract class FormeGeo implements Affichable, Deplacable{
	
	
	protected Point m_ptOrigine = null;
	protected static final double EPSILON = 1./10000;
	
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
	
	public void translation (double dx, double dy)
	{ 		
		this.m_ptOrigine.translation(dx,dy);
	}
	
	
	public abstract double getAire();
	public abstract void redimension( double h, double v) throws Exception;
	public abstract double getPerimetre();

}