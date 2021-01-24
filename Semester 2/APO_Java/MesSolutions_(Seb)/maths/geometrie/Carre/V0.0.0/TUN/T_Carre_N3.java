
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Carre - Tests unitaires des services estVide et contient
//
// Auteur : A. Thuaire
//

import maths.*;

public class T_Carre_N3 {

   public static void main (String[] args) throws Exception{

      Tests.Begin("Carre", "0.0.0");

         Tests.Design("Controle des services estVide et contient", 3); {

            Tests.Case("Methode estVide"); {

            Carre c0= new Carre();
            Carre c1= new Carre(2.5);
            Carre c2= new Carre(1.0, 1.0, 2.0);
            Carre c3= new Carre(new Point(1.0, 1.0));
            Carre c4= new Carre(new Point(1.0, 1.0), 2.0);

               Tests.Unit(true, c0.estVide());
               Tests.Unit(false, c1.estVide());
               Tests.Unit(false, c2.estVide());
               Tests.Unit(true, c3.estVide());
               Tests.Unit(false, c4.estVide());
            }

            Tests.Case("Methode contient 1"); {

            Carre c0= new Carre();
               Tests.Unit(true, c0.contient(0.0, 0.0));

            Carre c1= new Carre(2.5);
               Tests.Unit(true, c1.contient(0.0, 0.0));
               Tests.Unit(true, c1.contient(2.5, 0.0));
               Tests.Unit(true, c1.contient(0.0, 2.5));
               Tests.Unit(true, c1.contient(2.5, 2.5));

            Carre c2= new Carre(1.0, 1.0, 2.0);
               Tests.Unit(true, c2.contient(2.0, 3.0));

            Carre c3= new Carre(new Point(1.0, 1.0));
               Tests.Unit(false, c3.contient(0.0, 0.0));
               Tests.Unit(true, c3.contient(1.0, 1.0));

            Carre c4= new Carre(new Point(1.0, -3.0), 2.0);
               Tests.Unit(true, c4.contient(1.0, -1.0));
               Tests.Unit(true, c4.contient(3.0, -1.0));
               Tests.Unit(true, c4.contient(3.0, -3.0));
               Tests.Unit(true, c4.contient(1.0, -3.0));
               Tests.Unit(true, c4.contient(2.0, -2.0));
               Tests.Unit(true, c4.contient(1.0, -2.0));
               Tests.Unit(true, c4.contient(2.0, -3.0));
               Tests.Unit(false, c4.contient(2.0, 0.0));
               Tests.Unit(false, c4.contient(2.0, -4.0));

            Carre c5= new Carre(new Point(-3.0, -3.0), 2.0);
               Tests.Unit(true, c5.contient(-1.0, -1.0));
               Tests.Unit(true, c5.contient(-3.0, -1.0));
               Tests.Unit(true, c5.contient(-3.0, -3.0));
               Tests.Unit(true, c5.contient(-1.0, -3.0));
               Tests.Unit(true, c5.contient(-2.0, -2.0));
               Tests.Unit(true, c5.contient(-1.0, -2.0));
               Tests.Unit(true, c5.contient(-2.0, -3.0));
               Tests.Unit(false, c5.contient(0.0, 0.0));
               Tests.Unit(false, c5.contient(-4.0, -4.0));

            Carre c6= new Carre(new Point(-3.0, 1.0), 2.0);
               Tests.Unit(true, c6.contient(-1.0, 1.0));
               Tests.Unit(true, c6.contient(-3.0, 1.0));
               Tests.Unit(true, c6.contient(-3.0, 3.0));
               Tests.Unit(true, c6.contient(-1.0, 3.0));
               Tests.Unit(true, c6.contient(-2.0, 2.0));
               Tests.Unit(true, c6.contient(-1.0, 2.0));
               Tests.Unit(true, c6.contient(-2.0, 3.0));
               Tests.Unit(false, c6.contient(0.0, 0.0));
               Tests.Unit(false, c6.contient(-4.0, 4.0));
            }

            Tests.Case("Methode contient 2"); {

            Carre c0= new Carre();
               Tests.Unit(true, c0.contient(new Point()));

            Carre c1= new Carre(2.5);
               Tests.Unit(true, c1.contient(new Point()));
               Tests.Unit(true, c1.contient(new Point(2.5, 0.0)));

            }

            Tests.Case("Methode contient 3"); {

            Carre c0= new Carre();
            Carre c1= new Carre(2.5);
            Carre c2= new Carre(1.0, 1.0, 2.0);
            Carre c3= new Carre(new Point(1.0, 1.0));
            Carre c4= new Carre(new Point(1.0, 1.0), 2.0);

               Tests.Unit(false, c0.contient(c0));
               Tests.Unit(false, c0.contient(c1));
               Tests.Unit(false, c0.contient(c2));
               Tests.Unit(false, c0.contient(c3));
               Tests.Unit(false, c0.contient(c4));

               Tests.Unit(true, c1.contient(c0));
               Tests.Unit(true, c1.contient(c1));
               Tests.Unit(false, c1.contient(c2));
               Tests.Unit(true, c1.contient(c3));
               Tests.Unit(false, c1.contient(c4));

               Tests.Unit(false, c4.contient(c0));
               Tests.Unit(false, c4.contient(c1));
               Tests.Unit(true, c4.contient(c2));
               Tests.Unit(true, c4.contient(c3));
               Tests.Unit(true, c4.contient(c4));
            }

            Tests.Case("Methode contient 3 bis"); {

            Carre c1= new Carre(new Point(1.0, 1.0), 2.0);
            Rectangle r1 = new Rectangle(new Point(1.0, 1.0), 1.0, 2.0);

               Tests.Unit(true, c1.contient(r1));
               Tests.Unit(false, r1.contient(c1));
            }
         }

      Tests.End();
   }
}
