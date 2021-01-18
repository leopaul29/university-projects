//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Segment - Tests unitaires des services (Lot 2)
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.Point;
import maths.geometrie.Segment;

public class T_Segment_N4 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Segment", "0.1.0");

         Tests.Design("Controle des services (Lot 2)", 3); {

            Tests.Case("aligne");{
			Segment s = new Segment(new Point(1.0,1.0),new Point(2.0,2.0));
			Point p1 = new Point(3.0,3.0);
			Point p2 = new Point(4.0,3.0);
					
				Tests.Unit(true, s.aligne(p1));
				Tests.Unit(false, s.aligne(p2));
			}
				
			Tests.Case("appartient");{
			Segment s = new Segment(new Point(1.0,1.0),new Point(2.0,2.0));
			Point p1 = new Point(3.0,3.0);
			Point p2 = new Point(1.5,1.5);
					
				Tests.Unit(true, s.appartient(p2));
				Tests.Unit(false, s.appartient(p1));
			}
         }
         
      Tests.End();
   }
}
