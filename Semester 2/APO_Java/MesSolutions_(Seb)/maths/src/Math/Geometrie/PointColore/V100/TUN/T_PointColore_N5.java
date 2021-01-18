
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe PointColore - Tests unitaires des methodes de projection
//
// Auteur : S. Nicoletti
//

package Math.Geometrie.PointColore.V100.TUN;
import Math.Teste.*;
import Math.Geometrie.PointColore.V100.*;

public class T_PointColore_N5 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.PointColore", "0.1.0");

         Tests.Design("Controle des methodes de projection", 3); {

             Tests.Case("Sur l'axe des abscisses"); {
             PointColore p1= new PointColore('A',0,2);
             PointColore p2= new PointColore('B',1,0);
             PointColore p3= new PointColore('C',2,1);

             Tests.Unit("_ (0.0, 0.0)",  p1.projX().toString());
             Tests.Unit("_ (1.0, 0.0)",  p2.projX().toString());
             Tests.Unit("_ (2.0, 0.0)",  p3.projX().toString());
             }

             Tests.Case("Sur l'axe des ordonnées"); {
             PointColore p1= new PointColore('A',2,0);
             PointColore p2= new PointColore('B',0,1);
             PointColore p3= new PointColore('C',1,2);

             Tests.Unit("_ (0.0, 0.0)",  p1.projY().toString());
             Tests.Unit("_ (0.0, 1.0)",  p2.projY().toString());
             Tests.Unit("_ (0.0, 2.0)",  p3.projY().toString());
             }
         }
      Tests.End();
   }
}
