/**
 * @(#)FormGeo.java
 *
 *
 * @author 
 * @version 1.00 2013/5/2
 */
package maths.geometrie;

import maths.geometrie.Point;

abstract public class FormeGeo implements Affichable, Deplacable {
 
   	private Point m_ptOrigine;
   
 	public FormeGeo () { m_ptOrigine = new Point () ; }
 	
	public FormeGeo (double x, double y) { m_ptOrigine = new Point(x, y) ; }
	
	public FormeGeo (Point p) { m_ptOrigine = (Point) p.clone(); }
	
	public Point getPoint() { return m_ptOrigine ;}
	
	public void translation (double dx, double dy) throws Exception{ 
		if (dx <0 || dy<0) throw new Exception();
		m_ptOrigine.translation(dx,dy);
	}
	
	abstract public double getAire() ;
	abstract public void redimension (double h, double v) throws Exception;
	abstract public double getPerimetre();
}