//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Rectangle - Tests sur les méthodes généraux
//
// Auteur : S.Nicoletti
//

package Math.Geometrie.Rectangle.V010.TUN;
import Math.Teste.*;
import Math.Geometrie.Rectangle.V010.*;
import Math.Geometrie.Point.V100.*;

public class T_Rectangle_N3 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Rectangle", "0.0.0");

         Tests.Design("Controle des methodes généraux", 3); {

        	 Tests.Case("méthode estVide"); {


             	Rectangle rect = null;
             	Rectangle rect2 =null;
             	Rectangle rect3 =null;
             	Rectangle rect4 = null;

 				try {
 					 rect = new Rectangle(10,5);
 					 rect2 = new Rectangle(2.3,6.2);
 					 rect3 = new Rectangle(0,0);
 					 rect4 = new Rectangle();

 				} catch (Exception e) {
 					e.printStackTrace();
 				}

 				Tests.Unit(false,  rect.estVide());
 				Tests.Unit(false,  rect2.estVide());
 				Tests.Unit(true,  rect3.estVide());
 				Tests.Unit(true,  rect4.estVide());

        	 }


            Tests.Case("méthode contains"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;

				try {
					 rect = new Rectangle(2,2,10,5);
					 rect2 = new Rectangle(10,10);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit(true,  rect.contient(new Point(2,3)));
            	Tests.Unit(false,  rect.contient(new Point(15,8)));

            	Tests.Unit(true,  rect.contient(2,3));
            	Tests.Unit(false,  rect.contient(15,8));

            	Tests.Unit(true,  rect2.contient(new Rectangle(2,2,5,4) ));
            	Tests.Unit(false,  rect.contient(new Rectangle(5,5,7,7) ));
            	Tests.Unit(false,  rect.contient(new Rectangle(12,14,7,7) ));


            }

            Tests.Case("méthode grow"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 = null;
            	Rectangle rect4 =null;

				try {
					 rect = new Rectangle(2,5);
					 rect2 = new Rectangle(0,0);
					 rect3 = new Rectangle(2,3);
					 rect4 = new Rectangle(4,5);

				} catch (Exception e) {
					e.printStackTrace();
				}

				rect.redimension(5, 2);
				rect2.redimension(8, 9);
				rect3.redimension(-2, -1);
				rect4.redimension(-2, 3);


            	Tests.Unit("[ _ (0.0, 0.0), 4.0, 10.0]", rect.toString());
            	Tests.Unit("[ _ (0.0, 0.0), 9.0, 8.0]", rect2.toString());
            	Tests.Unit("[ _ (0.0, 0.0), 1.0, 1.0]", rect3.toString());
            	Tests.Unit("[ _ (0.0, 0.0), 7.0, 3.0]", rect4.toString());

            }


            Tests.Case("méthode intersects"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;
            	Rectangle rect4 =null;

				try {
					 rect = new Rectangle(1,2,10,10);
					 rect2 = new Rectangle(2,2,2,2);
					 rect3 = new Rectangle(15,20,3,3);
					 rect4 = new Rectangle(15,20);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit(true,  rect.intersection(rect2));
            	Tests.Unit(false,  rect.intersection(rect3));
            	Tests.Unit(true,  rect.intersection(rect4));

            }


            Tests.Case("méthode translate"); {

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

				rect.translation(2, 3);
				rect2.translation(-2, -3);
				rect3.translation(-2, 3);


            	Tests.Unit("[ _ (2.0, 3.0), 0.0, 0.0]", rect.toString());
            	Tests.Unit("[ _ (0.5, 0.0), 0.0, 0.0]", rect2.toString());
            	Tests.Unit("[ A (3.0, 5.75), 0.0, 0.0]", rect3.toString());


            }


            	Tests.Case("méthode intersectionR"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;
            	Rectangle rect4 =null;
            	Rectangle rect5 =null;

				try {
					 rect = new Rectangle(10,5);
					 rect2 = new Rectangle(2,6);
					 rect3 = new Rectangle(2,2);
					 rect4 = new Rectangle(12,2);
					 rect5 = new Rectangle(5,3,8,4);


				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit("[ _ (0.0, 0.0), 2.0, 2.0]",  rect.intersectionR(rect3).toString());
            	Tests.Unit("[ _ (0.0, 0.0), 2.0, 2.0]",  rect3.intersectionR(rect).toString());

            	Tests.Unit("[ _ (0.0, 0.0), 2.0, 5.0]",  rect.intersectionR(rect2).toString());
            	Tests.Unit("[ _ (0.0, 0.0), 2.0, 5.0]",  rect2.intersectionR(rect).toString());


            	Tests.Unit("[ _ (0.0, 0.0), 10.0, 2.0]",  rect.intersectionR(rect4).toString());
            	Tests.Unit("[ _ (0.0, 0.0), 10.0, 2.0]",  rect4.intersectionR(rect).toString());

            	Tests.Unit("[ _ (5.0, 3.0), 5.0, 2.0]",  rect.intersectionR(rect5).toString());
            	Tests.Unit("[ _ (5.0, 3.0), 5.0, 2.0]",  rect5.intersectionR(rect).toString());

            }


            Tests.Case("méthode unionR"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;
            	Rectangle rect4 =null;

            	try {
					 rect = new Rectangle(0,0);
					 rect2 = new Rectangle(2,6);
					 rect3 = new Rectangle(2,2,2,6);
					 rect4 = new Rectangle(5,10,15,15);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit("[ _ (0.0, 0.0), 2.0, 6.0]",  rect.unionR(rect2).toString());
            	Tests.Unit("[ _ (0.0, 0.0), 2.0, 6.0]",  rect2.unionR(rect).toString());

            	Tests.Unit("[ _ (0.0, 0.0), 4.0, 8.0]",  rect.unionR(rect3).toString());
            	Tests.Unit("[ _ (0.0, 0.0), 4.0, 8.0]",  rect3.unionR(rect).toString());

            	Tests.Unit("[ _ (0.0, 0.0), 4.0, 8.0]",  rect2.unionR(rect3).toString());
            	Tests.Unit("[ _ (0.0, 0.0), 4.0, 8.0]",  rect3.unionR(rect2).toString());

            	Tests.Unit("[ _ (2.0, 2.0), 18.0, 23.0]",  rect4.unionR(rect3).toString());
            	Tests.Unit("[ _ (2.0, 2.0), 18.0, 23.0]",  rect3.unionR(rect4).toString());
            }



         }

      Tests.End();
   }
}
