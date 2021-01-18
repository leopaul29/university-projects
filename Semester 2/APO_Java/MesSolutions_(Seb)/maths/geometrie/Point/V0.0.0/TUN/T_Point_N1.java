package maths;
import maths.*;//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur :S. Nicoletti
//


public class T_Point_N1 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.0.0");

         Tests.Design("Controle de la construction", 3); {


            Tests.Case("Construction sans parametres"); {
            Point p1= new Point();
            Tests.Unit("_(0.0 , 0.0)",  p1.toString());
            }

            Tests.Case("Construction avec deux parametres"); {
            Point p1= new Point(2,6.2);
            Tests.Unit("_(2.0 , 6.2)",  p1.toString());
            }

            Tests.Case("Construction avec tous les parametres"); {
            Point p1= new Point('A',1,1);
            Tests.Unit("A(1.0 , 1.0)",  p1.toString());
            }
         }
      Tests.End();
   }
}
