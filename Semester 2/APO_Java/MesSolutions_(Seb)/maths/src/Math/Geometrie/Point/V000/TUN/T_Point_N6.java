//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point - Tests unitaires des methodes pour calculer la distance
//
// Auteur : S.Nicoletti
//

package Math.Geometrie.Point.V000.TUN;
import Math.Teste.*;
import Math.Geometrie.Point.V000.*;

public class T_Point_N6 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.0.0");

         Tests.Design("Controle des methodes distance", 3); {

            Tests.Case("Tests generaux"); {
            Point p1= new Point(0,0);
            Point p2= new Point(0,1);
            Point p3= new Point(5,1);
            Point p4= new Point(-2,-1);
            Point p5= new Point(-2,-9);

            Tests.Unit(1.0,  p1.distance(p2));
            Tests.Unit(0.0,  p2.distance(p2));
            Tests.Unit(5.0990195135927845,  p1.distance(p3));
            Tests.Unit(8.0,  p4.distance(p5));
            Tests.Unit(1.0,  p2.distance(p1));
            Tests.Unit(10.198039027185569,  p2.distance(p5));
            }
         }
      Tests.End();
   }
}
