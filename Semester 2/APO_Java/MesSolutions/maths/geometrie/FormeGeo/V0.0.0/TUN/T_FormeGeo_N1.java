/**
 * @(#)T_FormGeo_N1.java
 *
 *
 * @author 
 * @version 1.00 2013/5/2
 */
import maths.geometrie.FormeGeo;
import maths.geometrie.Ellipse;
import maths.geometrie.Rectangle;

public class T_FormeGeo_N1 {
	
	public static void main (String[] args) throws Exception{
		
		Tests.Begin("FormeGeo", "V 0.0.0");
		
			Tests.Design("Essai", 3); {
				
				Tests.Case("Construction d'un tableau de formes"); {
					
					Rectangle r= new Rectangle(2.,3.);
					Ellipse e= new Ellipse(4.,2.);
					Tests.Unit(6.0, r.getAire());
					Tests.Unit(25.132741228718345, e.getAire());
				}
			}
		Tests.End();
	}
}