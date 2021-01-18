//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Rectangle - Tests sur les méthodes généraux
//
// Auteur : S.Nicoletti
//


public class T_Rectangle_N3 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Rectangle", "0.0.0");
      
      	Tests.Design("Controle des methodes contient", 3); {
      		
      		Rectangle rect = null;
            	Rectangle rect2 =null;

				try {
					 rect = new Rectangle(2,2,10,5);
					 rect2 = new Rectangle(10,10);
				} catch (Exception e) {e.printStackTrace();}
      		
      		Tests.Case("Si un rectangle contient un point de coordonnee x et y");{
      			Tests.Unit(true,  rect.contient(new Point(2,3)));
            	Tests.Unit(false,  rect.contient(new Point(15,8)));
      		}
      		
      		Tests.Case("Si le rectangle contient le point spécifié"); {
      			Tests.Unit(true,  rect.contient(2,3));
            	Tests.Unit(false,  rect.contient(15,8));
      		}
      		
      		Tests.Case("Si le rectangle contient entièrement le rectangle spécifié"); {
      			Tests.Unit(true,  rect2.contient(new Rectangle(2,2,5,4) ));
            	Tests.Unit(false,  rect.contient(new Rectangle(5,5,7,7) ));
            	Tests.Unit(false,  rect.contient(new Rectangle(12,14,7,7) ));
      		}
      	}

         Tests.Design("Controle des methodes généraux", 3); {
         	
         	Tests.Case("méthode estVide"); {
         		
         		Rectangle rect = null;		Point point = new Point();
         		Rectangle rect1 = null;		Point point1 = new Point();
         		Rectangle rect2 = null;
         		Rectangle rect3 = null;	
         		Rectangle rect4 = null;
         		
         		try {
         			rect = new Rectangle();
         			rect2 = new Rectangle(2,6);
         			rect3 = new Rectangle(3,4,0,0);
         			rect3 = new Rectangle(point);
         			rect4 = new Rectangle(point1,10,5);
         		}catch (Exception e){}
         		
         			Tests.Unit(true, rect.estVide());
         			Tests.Unit(false, rect2.estVide());
         			Tests.Unit(true, rect3.estVide());
         			Tests.Unit(false, rect4.estVide());
         	}

           	Tests.Case("méthode translation"); {

            	Rectangle rect = null;	Point point = new Point();
            	Rectangle rect2 =null; 	Point point2 = new Point(2.5, 3);
            	Rectangle rect3 =null;	Point point3 = new Point ('A',5,2.75);
				double i1 = 2; double i2 = 3;
				
				try {
					 rect = new Rectangle(point);
					 rect2 = new Rectangle(point2);
					 rect3 = new Rectangle(point3);
				} catch (Exception e) {	e.printStackTrace();}
				
				Rectangle R=null, R1=null, R2=null;
				rect.translation(i1, i2);
				rect2.translation(i1, i2);
				rect3.translation(i1, i2);

            	Tests.Unit("[_(2.0, 3.0), 0.0, 0.0]", rect.toString());
            	Tests.Unit("[_(4.5, 6.0), 0.0, 0.0]", rect2.toString());
            	Tests.Unit("[A(7.0, 5.75), 0.0, 0.0]", rect3.toString());
            }
           
            Tests.Case("méthode redimension"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;
            	Rectangle rect4 =null;

				try {
					 rect = new Rectangle(2,5);
					 rect2 = new Rectangle(0,0);
					 rect3 = new Rectangle(2,3);
					 rect4 = new Rectangle(4,5);
				} catch (Exception e) {	e.printStackTrace();}

				rect.redimension(5, 2);
				rect2.redimension(8, 9);
				rect3.redimension(-2, -1);
				rect4.redimension(-2, 3);
				
            	Tests.Unit("[_(0.0, 0.0), 10.0, 10.0]", rect.toString());
            	Tests.Unit("[_(0.0, 0.0), 0.0, 0.0]", rect2.toString());
            	Tests.Unit("[_(0.0, 0.0), 1.0, 3.0]", rect3.toString());
            	Tests.Unit("[_(0.0, 0.0), 2.0, 15.0]", rect4.toString());
            }

            Tests.Case("méthode intersection"); {

            	Rectangle rect = null;
            	Rectangle rect2 =null;
            	Rectangle rect3 =null;
            	Rectangle rect4 =null;

				try {
					 rect = new Rectangle(1,2,10,10);
					 rect2 = new Rectangle(2,2,2,2);
					 rect3 = new Rectangle(15,20,3,3);
					 rect4 = new Rectangle(15,20);
				} catch (Exception e) {	e.printStackTrace();}

            	Tests.Unit(true,  rect.intersection(rect2));
            	Tests.Unit(false,  rect.intersection(rect3));
            	Tests.Unit(true,  rect.intersection(rect4));
            }
            
            Tests.Case("unionR");{
					Rectangle r1 = null;
					Rectangle r2 = null;
					Rectangle r3 = null;
					Rectangle r4 = null;
					try{
						r1=new Rectangle(1,1,3,2);
						r2=new Rectangle(3,2,2,3);
						r3=new Rectangle(2,4,4,3);
						
					}catch(Exception e){}
					
					r4=r1.intersectionR(r3);
					
					Tests.Unit("", r4.toString());
            }
         }
      Tests.End();
   }
}
