//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Rectangle - Tests unitaires des accesseurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.Point;
import maths.geometrie.Rectangle;

public class T_Rectangle_N2 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.rectangle", "0.0.0");

         Tests.Design("Controle des accesseurs", 3); {

            Tests.Case("getHauteur"); {
            	
            	Rectangle r = null;
            	Rectangle r2 =null;
            	Rectangle r3 =null;

				try {
					 r = new Rectangle(10,5);
					 r2 = new Rectangle(2,6);
					 r3 = new Rectangle(0,0);
				} catch (Exception e) {	e.printStackTrace();}

            	Tests.Unit(5,  r.getHauteur());
            	Tests.Unit(6,  r2.getHauteur());
            	Tests.Unit(0,  r3.getHauteur());
            }

            Tests.Case("getLargeur"); {
            	
            	Rectangle r = null;
            	Rectangle r2 =null;
            	Rectangle r3 =null;

				try {
					 r = new Rectangle(10,5);
					 r2 = new Rectangle(2,6);
					 r3 = new Rectangle(0,0);
				} catch (Exception e) {	e.printStackTrace();}

            	Tests.Unit(10,  r.getLargeur());
            	Tests.Unit(2,  r2.getLargeur());
            	Tests.Unit(0,  r3.getLargeur());
            }

            Tests.Case("getPoint");  {
            	
            	Rectangle r = null;		Point p = new Point();
            	Rectangle r2 =null; 	Point p2 = new Point(2.5, 3);
            	Rectangle r3 =null;		Point p3 = new Point ('A',5,2.75);

				try {
					 r = new Rectangle(p);
					 r2 = new Rectangle(p2);
					 r3 = new Rectangle(p3);
				} catch (Exception e) {	e.printStackTrace();}

            	Tests.Unit("_(0.0, 0.0)",  r.getPoint().toString());
            	Tests.Unit("_(2.5, 3.0)",  r2.getPoint().toString());
            	Tests.Unit("A(5.0, 2.75)",  r3.getPoint().toString());
           	 }
           	 
           	 Tests.Case("Methode getAire"); {
           	 	
           	 	Rectangle r = null;
           	 	Rectangle r2 = null;
           	 	Rectangle r3 = null;
           	 	
           	 	try {
					 r = new Rectangle(10,5);
					 r2 = new Rectangle(2,6);
					 r3 = new Rectangle(0,0);
				} catch (Exception e) {	e.printStackTrace();}
           	 	
               Tests.Unit(50.0,  r.getAire());
               Tests.Unit(12.0,  r2.getAire());
               Tests.Unit(0.0,  r3.getAire());
            }
            
            Tests.Case("getPerimetre");{
            	
				Rectangle r1 = new Rectangle(1,1,3,4);
				Rectangle r2 = new Rectangle(2,2,6,2);
				
				Tests.Unit(14, r1.getPerimetre());
				Tests.Unit(16, r2.getPerimetre());
					
			}
         }
         
      Tests.End();
	}
}
