//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point- Tests unitaires des constructeurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Point_N1 {

    public static void main (String[] args) throws Exception {

      Tests.Begin("Point", "0.0.0");
      
      	 	Tests.Design("Methode Clone et Equals", 3); {	
			
			Tests.Case("Methode Clone"); {
				
				Point p1 = new Point(2,3);
         		Point p2= (Point)p1.clone();

               	Tests.Unit(2,  Point.getCompteur());
				Tests.Unit(true,  p1.equals(p1.clone()));
				Tests.Unit(true,  p1.equals(p2));
			}
			
			Tests.Case("Methode equals"); {
				
				Point p1 = new Point(2,3);
				Point p2 = new Point(2.5,3.0);
	         	
	               	Tests.Unit(true, p1.equals(p1));
					Tests.Unit(true, p1.equals(p1.clone()));
					Tests.Unit(false, p1.equals(p2));
            }
		}

         Tests.Design("Controle de la construction", 3); {

            Tests.Case("Construction sans parametres"); {
            Point p1= new Point();
            Tests.Unit("_(0.0, 0.0)",  p1.toString());
            }

            Tests.Case("Construction avec deux parametres"); {
            Point p1= new Point(3,7.3);
            Tests.Unit("_(3.0, 7.3)",  p1.toString());
            }

            Tests.Case("Construction avec tous les parametres"); {
            Point p1= new Point('A',9,9);
            Tests.Unit("A(9.0, 9.0)",  p1.toString());
            }
         }
         
      Tests.End();
    } 
}