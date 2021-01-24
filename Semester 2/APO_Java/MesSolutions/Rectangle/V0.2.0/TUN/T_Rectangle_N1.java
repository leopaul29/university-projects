//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Carre - Tests unitaires des accesseurs
//
// Auteur : MARTIN Léo-Paul
//

public class T_Rectangle_N1 {

   public static void main (String[] args) throws Exception{

      Tests.Begin("_Maths.Rectangle", "0.2.0");

         Tests.Design("Methode Clone et Equals", 3); {	
			
			Tests.Case("Methode Clone"); {
				
				Rectangle r1 = new Rectangle(2,3);
         		Rectangle r2= (Rectangle)r1.clone();

               	Tests.Unit(2,  Rectangle.getCompteur());
				Tests.Unit(true,  r1.equals(r1.clone()));
				Tests.Unit(true,  r1.equals(r2));
			}
			
			Tests.Case("Methode equals"); {
				
				Rectangle r1 = new Rectangle(2,3);
				Rectangle r2 = new Rectangle(2.5,3.0);
	         	
	               	Tests.Unit(true, r1.equals(r1));
					Tests.Unit(true, r1.equals(r1.clone()));
					Tests.Unit(false, r1.equals(r2));
            }
		}
         
         Tests.Design("Controle de la construction", 3); {

            Tests.Case("Constructeur par défault"); {

            	Rectangle r = new Rectangle();

            	Tests.Unit("[_(0.0, 0.0), 0.0, 0.0]",  r.toString());
            }

            Tests.Case("Constructeur par dimension"); {

            	Rectangle r = null;
            	Rectangle r2 =null;
            	Rectangle r3 =null;

				try {
					 r = new Rectangle(10,5);
					 r2 = new Rectangle(2,6);
					 r3 = new Rectangle(0,0);
				} catch (Exception e) {e.printStackTrace();}

            	Tests.Unit("[_(0.0, 0.0), 10.0, 5.0]",  r.toString());
            	Tests.Unit("[_(0.0, 0.0), 2.0, 6.0]",  r2.toString());
            	Tests.Unit("[_(0.0, 0.0), 0.0, 0.0]",  r3.toString());
            }


            Tests.Case("Constructeur par dimension et position"); {

            	Rectangle r = null;
            	Rectangle r2 =null;
            	Rectangle r3 =null;

				try {
					 r = new Rectangle(0,0,10,5);
					 r2 = new Rectangle(1,2,2,6);
					 r3 = new Rectangle(3,4,0,0);
				} catch (Exception e) {e.printStackTrace();}

            	Tests.Unit("[_(0.0, 0.0), 10.0, 5.0]",  r.toString());
            	Tests.Unit("[_(1.0, 2.0), 2.0, 6.0]",  r2.toString());
            	Tests.Unit("[_(3.0, 4.0), 0.0, 0.0]",  r3.toString());
            }


            Tests.Case("Constructeur par un point"); {

            	Rectangle r = null;	Point point = new Point();
            	Rectangle r2 =null; 	Point point2 = new Point(2.5, 3);
            	Rectangle r3 =null;	Point point3 = new Point ('A',5,2.75);

				try {
					 r = new Rectangle(point);
					 r2 = new Rectangle(point2);
					 r3 = new Rectangle(point3);
				} catch (Exception e) {e.printStackTrace();}

            	Tests.Unit("[_(0.0, 0.0), 0.0, 0.0]",  r.toString());
            	Tests.Unit("[_(2.5, 3.0), 0.0, 0.0]",  r2.toString());
            	Tests.Unit("[A(5.0, 2.75), 0.0, 0.0]",  r3.toString());
            }
            
            
            Tests.Case("Constructeur par un point et dimension"); {

            	Rectangle r = null;		Point p = new Point();
            	Rectangle r2 =null; 	Point p2 = new Point(2.5, 3);
            	Rectangle r3 =null;		Point p3 = new Point ('A',5,2.75);

				try {
					 r = new Rectangle(p,10,5);
					 r2 = new Rectangle(p2,6,8.2);
					 r3 = new Rectangle(p3,0,0);
				} catch (Exception e) {e.printStackTrace();}

            	Tests.Unit("[_(0.0, 0.0), 10.0, 5.0]",  r.toString());
            	Tests.Unit("[_(2.5, 3.0), 6.0, 8.2]",  r2.toString());
            	Tests.Unit("[A(5.0, 2.75), 0.0, 0.0]",  r3.toString());
            }
         }
         
      Tests.End();
   }
}