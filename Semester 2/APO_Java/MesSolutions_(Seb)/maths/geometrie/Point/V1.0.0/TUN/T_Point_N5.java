
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point - Tests unitaires des methodes de projection
//
// Auteur : S. Nicoletti
//

import maths.*;

public class T_Point_N5 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.1.0");

         Tests.Design("Controle des methodes de projection", 3); {

            Tests.Case("Sur l'axe des abscisses"); {
            Point p1= new Point('A',0,2);
            Point p2= new Point('B',1,0);
            Point p3= new Point('C',2,1);

            Tests.Unit("p(0.0 , 0.0)",  p1.projX());
            Tests.Unit("p(1.0 , 0.0)",  p2.projX());
            Tests.Unit("p(2.0 , 0.0)",  p3.projX());
            }

            Tests.Case("Sur l'axe des ordonn�es"); {
            Point p1= new Point('A',2,0);
            Point p2= new Point('B',0,1);
            Point p3= new Point('C',1,2);

            Tests.Unit("p(0.0 , 0.0)",  p1.projY());
            Tests.Unit("p(0.0 , 1.0)",  p2.projY());
            Tests.Unit("p(0.0 , 2.0)",  p3.projY());
            }
         }
      Tests.End();
   }
}
