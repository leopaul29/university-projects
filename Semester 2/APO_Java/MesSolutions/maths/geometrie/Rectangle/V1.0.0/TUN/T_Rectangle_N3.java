//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Rectangle - Tests sur les méthodes généraux
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.Point;
import maths.geometrie.Rectangle;

public class T_Rectangle_N3 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Rectangle", "0.2.0");
      
      	Tests.Design("Controle des methodes contient", 3); {
      		
      		Rectangle r = null;
            Rectangle r2 =null;

			try {
				 r = new Rectangle(2,2,10,5);
				 r2 = new Rectangle(10,10);
			} catch (Exception e) {e.printStackTrace();}
      		
      		Tests.Case("Si un Rectangle contient un point de coordonnee x et y");{
      			Tests.Unit(true,  r.contient(new Point(2,3)));
            	Tests.Unit(false,  r.contient(new Point(15,8)));
      		}
      		
      		Tests.Case("Si le Rectangle contient le point spécifié"); {
      			Tests.Unit(true,  r.contient(2,3));
            	Tests.Unit(false,  r.contient(15,8));
      		}
      		
      		Tests.Case("Si le Rectangle contient entièrement le Rectangle spécifié"); {
      			Tests.Unit(true,  r2.contient(new Rectangle(2,2,5,4) ));
            	Tests.Unit(false,  r.contient(new Rectangle(5,5,7,7) ));
            	Tests.Unit(false,  r.contient(new Rectangle(12,14,7,7) ));
      		}
      	}

         Tests.Design("Controle des methodes généraux", 3); {
         	
         	Tests.Case("méthode estVide"); {
         		
         		Rectangle r = null;		Point p = new Point();
         		Rectangle r1 = null;		Point p1 = new Point();
         		Rectangle r2 = null;
         		Rectangle r3 = null;	
         		Rectangle r4 = null;
         		
         		try {
         			r = new Rectangle();
         			r2 = new Rectangle(2,6);
         			r3 = new Rectangle(3,4,0,0);
         			r3 = new Rectangle(p);
         			r4 = new Rectangle(p1,10,5);
         		}catch (Exception e){}
         		
         			Tests.Unit(true, r.estVide());
         			Tests.Unit(false, r2.estVide());
         			Tests.Unit(true, r3.estVide());
         			Tests.Unit(false, r4.estVide());
         	}

           	Tests.Case("méthode translation"); {

            	Rectangle r = null;		Point p = new Point();
            	Rectangle r2 =null; 	Point p2 = new Point(2.5, 3);
            	Rectangle r3 =null;		Point p3 = new Point ('A',5,2.75);
				double i1 = 2; double i2 = 3;
				
				try {
					 r = new Rectangle(p);
					 r2 = new Rectangle(p2);
					 r3 = new Rectangle(p3);
				} catch (Exception e) {	e.printStackTrace();}
				
				Rectangle R=null, R1=null, R2=null;
				r.translation(i1, i2);
				r2.translation(i1, i2);
				r3.translation(i1, i2);

            	Tests.Unit("[_(2.0, 3.0), 0.0, 0.0]", r.toString());
            	Tests.Unit("[_(4.5, 6.0), 0.0, 0.0]", r2.toString());
            	Tests.Unit("[A(7.0, 5.75), 0.0, 0.0]", r3.toString());
            }
           
            Tests.Case("méthode redimension"); {

            	Rectangle r = null;
            	Rectangle r2 =null;
            	Rectangle r3 =null;
            	Rectangle r4 =null;

				try {
					 r = new Rectangle(2,5);
					 r2 = new Rectangle(0,0);
					 r3 = new Rectangle(2,3);
					 r4 = new Rectangle(4,5);
				} catch (Exception e) {	e.printStackTrace();}

				r.redimension(5, 2);
				r2.redimension(8, 9);
				r3.redimension(-2, -1);
				r4.redimension(-2, 3);
				
            	Tests.Unit("[_(0.0, 0.0), 10.0, 10.0]", r.toString());
            	Tests.Unit("[_(0.0, 0.0), 0.0, 0.0]", r2.toString());
            	Tests.Unit("[_(0.0, 0.0), 1.0, 3.0]", r3.toString());
            	Tests.Unit("[_(0.0, 0.0), 2.0, 15.0]", r4.toString());
            }

            Tests.Case("méthode intersection"); {

            	Rectangle r = null;
            	Rectangle r2 =null;
            	Rectangle r3 =null;
            	Rectangle r4 =null;

				try {
					 r = new Rectangle(1,2,10,10);
					 r2 = new Rectangle(2,2,2,2);
					 r3 = new Rectangle(15,20,3,3);
					 r4 = new Rectangle(15,20);
				} catch (Exception e) {	e.printStackTrace();}

            	Tests.Unit(true,  r.intersection(r2));
            	Tests.Unit(false,  r.intersection(r3));
            	Tests.Unit(true,  r.intersection(r4));
            }
            
            Tests.Case("unionR");{
            	
				Rectangle r = null;
				Rectangle r2 = null;
				Rectangle r3 = null;
				Rectangle r4 = null;
				Rectangle r5 = null;
				
				try{
					r = new Rectangle(1,2,10,10);
					 r2 = new Rectangle(2,2,2,2);
					 r3 = new Rectangle(15,20);
				}catch(Exception e){}
					
					r4=r.intersectionR(r2);
					r5=r.intersectionR(r4);
					
				Tests.Unit("[_(2.0, 2.0), 9.0, 10.0]", r4.toString());
				Tests.Unit("[_(2.0, 2.0), 9.0, 10.0]", r5.toString());
            }
         }
         
      Tests.End();
   }
}
