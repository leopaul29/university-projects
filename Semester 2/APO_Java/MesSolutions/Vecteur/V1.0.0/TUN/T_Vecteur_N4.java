//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Vecteur - Tests unitaires de la methode mul (cas nominaux)
//
// Auteur : A. Thuaire
//

public class T_Vecteur_N4 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Vecteur", "1.0.0");

         Tests.Design("Controle de l'operation * (produit par un scalaire)", 3); {

            Tests.Case("Methode mul"); {
            Vecteur v0= new Vecteur();
            Vecteur v1= new Vecteur (new Fraction(1), new Fraction(2));
            Vecteur v2= new Vecteur (new Fraction(-1), new Fraction(9,4));

            Vecteur v;

               v= v0.mul(2);
               Tests.Unit("(0, 0)",  v.toString());

               v= v1.mul(-1.25);
               Tests.Unit("(-5/4, -5/2)",  v.toString());

               v= v2.mul(4);
               Tests.Unit("(-4, 9)",  v.toString());
            }
         }

      Tests.End();
   }
}
