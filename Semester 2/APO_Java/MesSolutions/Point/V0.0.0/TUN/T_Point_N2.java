//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point- Tests unitaires des accesseur de consultation (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Point_N2 {

    public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.0.0");

         Tests.Design("Accesseur de consultation", 3); {
         	
         	Point p1 = new Point('A',2.4,5.0);
			Point p2 = new Point('B',3.5,6.1);
			Point p3 = new Point('C',4.6,7.9);
			Point p4 = new Point('D',9.3,1.5);

            Tests.Case("Accesseur de consultation du nom"); {
               	Tests.Unit('A', p1.getNom());
				Tests.Unit('B', p2.getNom());
				Tests.Unit('C', p3.getNom());
				Tests.Unit('D', p4.getNom());
            }

			Tests.Case("Accesseur de consultation de l'abscisse"); {
               	Tests.Unit(2.4,  p1.getAbscisse());
				Tests.Unit(3.5,  p2.getAbscisse());
				Tests.Unit(4.6,  p3.getAbscisse());
				Tests.Unit(9.3,  p4.getAbscisse());
            }

			Tests.Case("Accesseur de consultation de l'ordonnee"); {
	          	Tests.Unit(5.0,  p1.getOrdonnee());
				Tests.Unit(6.1,  p2.getOrdonnee());
				Tests.Unit(7.9,  p3.getOrdonnee());
				Tests.Unit(1.5,  p4.getOrdonnee());
            }
         }
         
      Tests.End();
   }
}
