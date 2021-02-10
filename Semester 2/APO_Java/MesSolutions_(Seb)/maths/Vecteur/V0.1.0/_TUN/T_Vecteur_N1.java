
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Vecteur - Tests unitaires des constructeurs
//                  (cas nominaux)
//
// Auteur : S.Nicoletti
//

import maths.*;

public class T_Vecteur_N1 {

   public static void main (String[] args) {

      Tests.Begin("_Maths.Vecteur", "0.1.0");

         Tests.Design("Controle des constructeurs", 3); {

            Tests.Case("Constructeur par defaut"); {
            Vecteur v0= new Vecteur();

               Tests.Unit("(0.0, 0.0)",  v0.toString());
            }

            Tests.Case("Constructeur normal"); {
            Vecteur v1= new Vecteur (1, 2);
            Vecteur v2= new Vecteur (1.5, -2);
            Vecteur v3= new Vecteur (-1, 2.25);
            Vecteur v4= new Vecteur (-1, -2);
            Vecteur v5= new Vecteur (-7.25, 8.45);

               Tests.Unit("(1.0, 2.0)",    v1.toString());
               Tests.Unit("(1.5, -2.0)",   v2.toString());
               Tests.Unit("(-1.0, 2.25)",  v3.toString());
               Tests.Unit("(-1.0, -2.0)",  v4.toString());
               Tests.Unit("(-7.25, 8.45)", v5.toString());
            }


         }

         Tests.Design("Controle des méthodes equals et clone", 3); {

           Tests.Case("clone"); {
            Vecteur f1= new Vecteur(2.0,1.0);
            Vecteur f2= null;

            Vecteur f3= new Vecteur(2.0,-5.0);
            Vecteur f4= null;

            f2= (Vecteur) f1.clone();
            f4= (Vecteur) f3.clone();

                 Tests.Unit("(2.0, 1.0)",  f2.toString());
                 Tests.Unit("(2.0, -5.0)",  f4.toString());
                 }


             Tests.Case("equals"); {

                Vecteur f1= new Vecteur(2.0,1.0);
                Vecteur f2= null;

                Vecteur f3= new Vecteur(2.0,-5.0);
                Vecteur f4= null;

                f2= (Vecteur) f1.clone();
                f4= (Vecteur) f3.clone();


               Tests.Unit(true,f1.equals(f2) );
               Tests.Unit(true,f2.equals(f1) );
               Tests.Unit(true,f3.equals(f4) );
               Tests.Unit(false,f1.equals(f3) );
               Tests.Unit(false,f3.equals(f1) );
               Tests.Unit(false,f2.equals(f3) );

             }


         }

      Tests.End();
   }
}
