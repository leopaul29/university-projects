//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package _Maths
//
// Classe rectangle - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur : S. Nicoletti
//

package Math.Geometrie.Rectangle.V010.TUN;
import Math.Teste.*;
import Math.Geometrie.Rectangle.V010.*;
import Math.Geometrie.Point.V100.*;

public class T_Rectangle_N1 {

   public static void main (String[] args) {

      Tests.Begin("_Maths.Rectangle", "0.0.0");

         Tests.Design("Controle de la construction", 3); {

            Tests.Case("Constructeur par défault"); {

            	Rectangle rect = new Rectangle();

            	Tests.Unit("[ _ (0.0, 0.0), 0.0, 0.0]",  rect.toString());

            }

            Tests.Case("Constructeur par dimension"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;

				try {
					 rect = new Rectangle(10,5);
					 rect2 = new Rectangle(2.3,6.2);
					 rect3 = new Rectangle(0,0);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit("[ _ (0.0, 0.0), 10.0, 5.0]",  rect.toString());
            	Tests.Unit("[ _ (0.0, 0.0), 2.3, 6.2]",  rect2.toString());
            	Tests.Unit("[ _ (0.0, 0.0), 0.0, 0.0]",  rect3.toString());

            }


            Tests.Case("Constructeur par dimension et position"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;

				try {
					 rect = new Rectangle(0,0,10,5);
					 rect2 = new Rectangle(-1.2,-2.3,2.4,6.6);
					 rect3 = new Rectangle(3,4,0,0);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit("[ _ (0.0, 0.0), 10.0, 5.0]",  rect.toString());
            	Tests.Unit("[ _ (-1.2, -2.3), 2.4, 6.6]",  rect2.toString());
            	Tests.Unit("[ _ (3.0, 4.0), 0.0, 0.0]",  rect3.toString());

            }


            Tests.Case("Constructeur par un point"); {

            	Rectangle rect = null;	Point point = new Point();
            	Rectangle rect2 =null; 	Point point2 = new Point(2.5, 3);
            	Rectangle rect3 =null;	Point point3 = new Point ('A',5,2.75);



				try {
					 rect = new Rectangle(point);
					 rect2 = new Rectangle(point2);
					 rect3 = new Rectangle(point3);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit("[ _ (0.0, 0.0), 0.0, 0.0]",  rect.toString());
            	Tests.Unit("[ _ (2.5, 3.0), 0.0, 0.0]",  rect2.toString());
            	Tests.Unit("[ A (5.0, 2.75), 0.0, 0.0]",  rect3.toString());

            }


         }

      Tests.End();
   }
}
