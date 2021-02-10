//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Vecteur - Tests unitaires des methodes add et sub (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Vecteur_N3 {

   public static void main (String[] args) throws Exception{

      Tests.Begin("_Maths.Vecteur", "1.1.0");

         Tests.Design("Controle des operations add et sub", 3); {

            Tests.Case("Methode add"); {
            Vecteur v0= new Vecteur();
            Vecteur v1= new Vecteur (new Fraction(1), new Fraction(2));
            Vecteur v2= new Vecteur (new Fraction(-1), new Fraction(9,4));
            Vecteur v3= new Vecteur (new Fraction(-1), new Fraction(-2));

            Vecteur v;

               v= v0.add(v1);
               Tests.Unit("(1, 2)",  v.toString());

               v= v1.add(v3);
               Tests.Unit("(0, 0)",  v.toString());

               v= v1.add(v2);
               Tests.Unit("(0, 17/4)",  v.toString());
            }

            Tests.Case("Methode sub"); {
            Vecteur v0= new Vecteur();
            Vecteur v1= new Vecteur (new Fraction(1), new Fraction(2));
            Vecteur v2= new Vecteur (new Fraction(-1), new Fraction(9,4));
            Vecteur v3= new Vecteur (new Fraction(-1), new Fraction(-2));

            Vecteur v;

               v= v0.sub(v1);
               Tests.Unit("(-1, -2)",  v.toString());

               v= v1.sub(v3);
               Tests.Unit("(2, 4)",  v.toString());

               v= v1.sub(v2);
               Tests.Unit("(2, -1/4)",  v.toString());
            }

            Tests.Case("Methode sub sans parametre"); {
            Vecteur v0= new Vecteur();
            Vecteur v1= new Vecteur (new Fraction(1), new Fraction(2));

            Vecteur v;

               v= v0.sub();
               Tests.Unit("(0, 0)",  v.toString());

               v= v1.sub();
               Tests.Unit("(-1, -2)",  v.toString()); 
            }
         }
         
      Tests.End();
   }
}
