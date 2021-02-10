package maths;
import maths.*;//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Rectangle - Tests unitaires des accesseurs (cas nominaux)
//
// Auteur : S. Nicoletti
//



public class T_Rectangle_N2 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.rectangle", "0.0.0");

         Tests.Design("Controle des accesseurs", 3); {

            Tests.Case("getHeight");
            {
            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;

				try {
					 rect = new Rectangle(10,5);
					 rect2 = new Rectangle(2,6);
					 rect3 = new Rectangle(0,0);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit(5,  rect.getHauteur());
            	Tests.Unit(6,  rect2.getHauteur());
            	Tests.Unit(0,  rect3.getHauteur());
            }




            Tests.Case("getWidth");
            {
            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;

				try {
					 rect = new Rectangle(10,5);
					 rect2 = new Rectangle(2,6);
					 rect3 = new Rectangle(0,0);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit(10,  rect.getLargeur());
            	Tests.Unit(2,  rect2.getLargeur());
            	Tests.Unit(0,  rect3.getLargeur());
            }

            Tests.Case("getLocation");
            {
            	Rectangle rect = null;	Point point = new Point();
            	Rectangle rect2 =null; 	Point point2 = new Point(-2.5, 3);
            	Rectangle rect3 =null;	Point point3 = new Point ('A',5,-2.75);



				try {
					 rect = new Rectangle(point);
					 rect2 = new Rectangle(point2);
					 rect3 = new Rectangle(point3);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit("_ (0.0, 0.0)",  rect.getPoint().toString());
            	Tests.Unit("_ (-2.5, 3.0)",  rect2.getPoint().toString());
            	Tests.Unit("A (5.0, -2.75)",  rect3.getPoint().toString());
           	 }
           	 
           	 
           	  Tests.Case("getAire");
            {
            	
            	
            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;

				try {
					 rect = new Rectangle(10,5);
					 rect2 = new Rectangle(2,6);
					 rect3 = new Rectangle(0,0);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit(50.0,  rect.getAire());
            	Tests.Unit(12.0,  rect2.getAire());
            	Tests.Unit(0.0,  rect3.getAire());
           	 }

         }
      Tests.End();

	}
}
