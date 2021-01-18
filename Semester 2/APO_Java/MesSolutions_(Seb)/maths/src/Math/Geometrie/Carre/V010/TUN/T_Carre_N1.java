//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Carre - Tests unitaires des constructeurs
//                (cas nominaux)
//
// Auteur : S.Nicoletti
//

package Math.Geometrie.Carre.V010.TUN;
import Math.Teste.*;
import Math.Geometrie.Carre.V010.*;
import Math.Geometrie.Point.V100.*;

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


      Tests.End();
   }
}
