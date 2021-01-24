//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Vecteur - Tests unitaires de la methode mul
//                  (cas nominaux)
//
// Auteur : S.Nicoletti
//

package Math.Vecteur.V010.TUN;
import Math.Teste.*;
import Math.Vecteur.V010.*;

public class T_Vecteur_N4 {

   public static void main (String[] args) {

      Tests.Begin("_Maths.Vecteur", "0.0.0");

         Tests.Design("Controle de l'operation * (produit par un scalaire)", 2); {

            Tests.Case("Methode mul"); {
            Vecteur v0= new Vecteur();
            Vecteur v1= new Vecteur (1, 2);
            Vecteur v2= new Vecteur (-1, 2.25);

            Vecteur v;

               v= v0.mul(2);
               Tests.Unit("(0.0, 0.0)",  v.toString());

               v= v1.mul(-1.25);
               Tests.Unit("(-1.25, -2.5)",  v.toString());

               v= v2.mul(4);
               Tests.Unit("(-4.0, 9.0)",  v.toString());
            }
         }

      Tests.End();
   }
}
