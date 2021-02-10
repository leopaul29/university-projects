//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Ellipse - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Ellipse_N1 {
	
	public static void main(String[] arg) throws Exception {
		
		Tests.Begin("_Maths.Ellipse","0.0.0");
		
			Tests.Design("Tests des constructeurs",3);{
			
				Tests.Case("Ellipse()");{
					Ellipse e1 = new Ellipse();
					Tests.Unit("[_(0.0, 0.0), 0.0, 0.0]", e1.toString());
				}
				
				Tests.Case("Ellipse(double x, double y, double f, double s)");{
					Ellipse e2 = new Ellipse(2.0,1.0,4.0,2.0);
					Tests.Unit("[_(2.0, 1.0), 4.0, 2.0]", e2.toString());
				}
				
				Tests.Case("Ellipse(Point pt, double f, double s)");{
					Point p = new Point(2.0, 1.0);
					Ellipse e3 = new Ellipse(p,4.0,2.0);
					Tests.Unit("[_(2.0, 1.0), 4.0, 2.0]", e3.toString());
				}
				
				Tests.Case("Ellipse(Point p)");{
					Point p = new Point(2.0,1.0);
					Ellipse e4 = new Ellipse(p);
					Tests.Unit("[_(2.0, 1.0), 0.0, 0.0]", e4.toString());
				}
				
				Tests.Case("Ellipse(double f, double s)");{
					Ellipse e5 = new Ellipse(4.0,2.0);
					Tests.Unit("[_(0.0, 0.0), 4.0, 2.0]", e5.toString());
				}
			}
	
		Tests.End();
	}
}