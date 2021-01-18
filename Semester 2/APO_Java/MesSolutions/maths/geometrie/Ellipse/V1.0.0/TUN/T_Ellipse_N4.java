//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Ellipse - Tests unitaires des methode rectangle interieur et exterieur (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.Point;
import maths.geometrie.Ellipse;
import maths.geometrie.Rectangle;

public class T_Ellipse_N4{
	
	public static void main(String[] arg) throws Exception {
		
		Tests.Begin("_Maths.Ellipse","0.0.0");
		
			Tests.Design("Methode 2",3);{
			
				Tests.Case("rectangleExt");{
					Ellipse e1 = new Ellipse(1.0,1.0,4.0,2.0);
					Ellipse e2 = new Ellipse(3.0,4.0,10.0,8.0);
					Rectangle e3 = e1.rectangleExt();
					Rectangle e4 = e2.rectangleExt();
					Tests.Unit("[_(-1.0, 0.0), 4.0, 2.0]",e3.toString());
					Tests.Unit("[_(-2.0, 0.0), 10.0, 8.0]",e4.toString());
				}
				
				Tests.Case("rectangleInt");{
					Ellipse e1 = new Ellipse(1.0,1.0,4.0,2.0);
					Ellipse e2 = new Ellipse(3.0,4.0,10.0,8.0);
					Rectangle e3 = e1.rectangleInt();
					Rectangle e4 = e2.rectangleInt();
					Tests.Unit("[_(-0.41421356237309515, 0.2928932188134524), 2.8284271247461903, 1.4142135623730951]",e3.toString());
					Tests.Unit("[_(-0.5355339059327378, 1.1715728752538097), 7.0710678118654755, 5.656854249492381]",e4.toString());	
				}
			}
			
		Tests.End();
	}
}