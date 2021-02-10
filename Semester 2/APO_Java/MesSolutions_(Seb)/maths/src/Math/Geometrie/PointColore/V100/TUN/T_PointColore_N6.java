
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe PointColore - Tests unitaires des methodes pour calculer la distance
//
// Auteur : S. Nicoletti
//

package Math.Geometrie.PointColore.V100.TUN;
import Math.Teste.*;
import Math.Geometrie.PointColore.V100.*;

public class T_PointColore_N6 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.PointColore", "0.1.0");

         Tests.Design("Controle des methodes distance", 3); {

            Tests.Case("Teste distance"); {
            PointColore p1= new PointColore(0,0);
            PointColore p2= new PointColore(0,1);
            PointColore p3= new PointColore(4,3);
            PointColore p4= new PointColore(-1,-5);
            PointColore p5= new PointColore(-4,-9);

            Tests.Unit(1.0,  p1.distance(p2));
            Tests.Unit(1.0,  p2.distance(p1));
            Tests.Unit(0.0,  p2.distance(p2));
            Tests.Unit(5.0,  p1.distance(p3));
            Tests.Unit(5.0,  p4.distance(p5));
            }
         }
      Tests.End();
   }
}
