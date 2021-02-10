//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Carre - Tests unitaires des services redimension et translation
//
// Auteur : A. Thuaire
//
import maths.geometrie.Point;
import maths.geometrie.Carre;

public class T_Carre_N4 {

   public static void main (String[] args) throws Exception{

      Tests.Begin("Carre", "0.0.0");

         Tests.Design("Controle des services redimension et translation", 3); {

            Tests.Case("Methode translation"); {

            Carre c0= new Carre();
            Carre c1= new Carre(new Point(1.0, 1.0), 2.0);

            c0.translation(1.0, 1.0);
            c1.translation(1.0, 1.0);

               Tests.Unit("[ _(1.0, 1.0), 0.0 ]",  c0.toString());
               Tests.Unit("[ _(2.0, 2.0), 2.0 ]",  c1.toString());
            }

            Tests.Case("Methode redimension Carre vide"); {

            Carre c0= new Carre();
            c0.redimension(0.0, 0.0);
            Tests.Unit("[ _(0.0, 0.0), 0.0 ]",  c0.toString());

            c0 = new Carre();
            c0.redimension(0.0, 1.0);
            Tests.Unit("[ _(0.0, 0.0), 0.0 ]",  c0.toString());

            c0 = new Carre();
            c0.redimension(1.0, 0.0);
            Tests.Unit("[ _(0.0, 0.0), 0.0 ]",  c0.toString());

            c0 = new Carre();
            c0.redimension(2.0, 3.0);
            Tests.Unit("[ _(0.0, 0.0), 0.0 ]",  c0.toString());

            }

            Tests.Case("Methode redimension Carre non vide"); {

            Carre c0= new Carre(new Point(1.0, 1.0), 2.0);
            c0.redimension(0.0, 0.0);
            Tests.Unit("[ _(1.0, 1.0), 2.0 ]",  c0.toString());

            c0 = new Carre(new Point(1.0, 1.0), 2.0);
            c0.redimension(0.0, 1.0);
            Tests.Unit("[ _(1.0, 1.0), 0.0 ]",  c0.toString());

            c0 = new Carre(new Point(1.0, 1.0), 2.0);
            c0.redimension(1.0, 0.0);
            Tests.Unit("[ _(1.0, 1.0), 2.0 ]",  c0.toString());

            c0 = new Carre(new Point(1.0, 1.0), 2.0);
            c0.redimension(2.0, 3.0);
            Tests.Unit("[ _(1.0, 1.0), 4.0 ]",  c0.toString());

            c0 = new Carre(new Point(1.0, 1.0), 2.0);
            c0.redimension(-2.0, -3.0);
            Tests.Unit("[ _(1.0, 1.0), 1.0 ]",  c0.toString());

            }

         }

      Tests.End();
   }
}
