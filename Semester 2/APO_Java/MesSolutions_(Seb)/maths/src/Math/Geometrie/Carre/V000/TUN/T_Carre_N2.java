
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Carre - Tests unitaires des accesseurs
//
// Auteur : A. Thuaire
//

package Math.Geometrie.Carre.V000.TUN;
import Math.Teste.*;
import Math.Geometrie.Carre.V000.*;
import Math.Geometrie.Point.V100.*;

public class T_Carre_N2 {

   public static void main (String[] args) throws Exception{

      Tests.Begin("Carre", "0.0.0");

         Tests.Design("Controle des accesseurs", 3); {

            Carre c0= new Carre();
            Carre c1= new Carre(2.5);
            Carre c2= new Carre(1.0, 1.0, 2.5);
            Carre c3= new Carre(new Point(1.0, 1.0));
            Carre c4= new Carre(new Point(1.0, 1.0), 2.0);

         	Tests.Case("Methode getPoint"); {

               Tests.Unit("_ (0.0, 0.0)",  c0.getPoint().toString());
               Tests.Unit("_ (0.0, 0.0)",  c1.getPoint().toString());
               Tests.Unit("_ (1.0, 1.0)",  c2.getPoint().toString());
               Tests.Unit("_ (1.0, 1.0)",  c3.getPoint().toString());
               Tests.Unit("_ (1.0, 1.0)",  c4.getPoint().toString());
            }

         	Tests.Case("Methode getCote"); {

               Tests.Unit(0.0,  c0.getCote());
               Tests.Unit(2.5,  c1.getCote());
               Tests.Unit(2.5,  c2.getCote());
               Tests.Unit(0.0,  c3.getCote());
               Tests.Unit(2.0,  c4.getCote());
            }

          	Tests.Case("Methode getAire"); {

               Tests.Unit(0.0,  c0.getAire());
               Tests.Unit(6.25,  c1.getAire());
               Tests.Unit(6.25,  c2.getAire());
               Tests.Unit(0.0,  c3.getAire());
               Tests.Unit(4.0,  c4.getAire());
            }
         }

      Tests.End();
   }
}
