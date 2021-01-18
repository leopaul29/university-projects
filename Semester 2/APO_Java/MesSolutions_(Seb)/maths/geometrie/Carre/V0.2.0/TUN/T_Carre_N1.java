
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Carre - Tests unitaires des constructeurs
//                (cas nominaux)
//
// Auteur : S.Nicoletti
//


import maths.*;

public class T_Carre_N1 {

   public static void main (String[] args) throws Exception{

      Tests.Begin("Carre", "V 0.0.0");

         Tests.Design("Controle des constructeurs", 3); {

            Tests.Case("Constructeur par defaut"); {
            Carre c0= new Carre();

               Tests.Unit("[ _(0.0, 0.0), 0.0 ]",  c0.toString());
            }

            Tests.Case("Premier constructeur normal"); {
            Carre c1= new Carre(2.5);

               Tests.Unit("[ _(0.0, 0.0), 2.5 ]",  c1.toString());
            }

            Tests.Case("Second constructeur normal"); {
            Carre c2= new Carre(1.0, 1.0, 2.5);

               Tests.Unit("[ _(1.0, 1.0), 2.5 ]",  c2.toString());
            }

            Tests.Case("Troisieme constructeur normal"); {
            Carre c3= new Carre(new Point(1.0, 1.0));

               Tests.Unit("[ _(1.0, 1.0), 0.0 ]",  c3.toString());
            }

            Tests.Case("Quatrieme constructeur normal"); {
            Carre c4= new Carre(new Point(1.0, 1.0), 2.0);

               Tests.Unit("[ _(1.0, 1.0), 2.0 ]",  c4.toString());
            }
         }
         
         
         Tests.Design("Controle des méthodes equals et clone", 3); {
         	
            Tests.Case("méthode equals"); {

            	Rectangle rect = null;	Point point = new Point();
            	Rectangle rect2 =null; 	Point point2 = new Point(2.5, 3);
            	Rectangle rect3 =null;	Point point3 = new Point ('A',5,2.75);
            	Rectangle rect4 =null; Point point4  = new Point (5, 2.75);
            	Rectangle rect5 =null;

				try {
					 rect = new Rectangle(point);
					 rect2 = new Rectangle(point2);
					 rect3 = new Rectangle(point3);
					 rect4 =  new Rectangle(point4);
					 rect5 =  new Rectangle(point4,2,5);

				} catch (Exception e) {
					e.printStackTrace();
				}

            	Tests.Unit(true,  rect.equals(rect));
            	Tests.Unit(true,  rect5.equals(rect5));
            	
            	Tests.Unit(false,  rect2.equals(rect));
            	Tests.Unit(false,  rect.equals(rect2));
            	
            	Tests.Unit(false,  rect2.equals(rect3));
            	Tests.Unit(false,  rect3.equals(rect2));
            	
            	Tests.Unit(true,  rect4.equals(rect3));
            	Tests.Unit(true,  rect3.equals(rect4));
            	
            	Tests.Unit(false,  rect4.equals(rect5));
            	Tests.Unit(false,  rect5.equals(rect4));

            }
            
            Tests.Case("méthode clone"); {
            
            	Rectangle rect = null;	Point point = new Point();
            	Rectangle rect2 =null; 
            	Rectangle rect3 =null;	Point point3 = new Point ('A',5,2.75);
            	Rectangle rect4 =null; 


				try {
					 rect = new Rectangle(point);
					 rect2 = (Rectangle) rect.clone();
					 rect3 = new Rectangle(point3);
					 rect4 =  (Rectangle) rect3.clone();

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Tests.Unit(rect.toString(),  rect2.toString());
            	Tests.Unit(rect3.toString(),  rect4.toString());
            
            }

         }
      Tests.End();
   }
}
