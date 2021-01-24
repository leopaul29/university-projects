//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Vecteur - Tests unitaires des methodes colineaire et orthogonal (cas nominaux)
//
// Auteur : MARTIN L�o-Paul
//

public class T_Vecteur_N5 {

   public static void main (String[] args) throws Exception{

      Tests.Begin("_Maths.Vecteur", "1.1.0");

         Tests.Design("Controle des methodes colineaire et orthogonal", 3); {

            Tests.Case("Methode colineaire"); {
            Vecteur v0= new Vecteur();
            Vecteur v1= new Vecteur (new Fraction(1), new Fraction(2));
            Vecteur v2= new Vecteur (new Fraction(-2), new Fraction(-4));
            Vecteur v3= new Vecteur (new Fraction(-1), new Fraction(1));
            Vecteur v4= new Vecteur (new Fraction(1), new Fraction(1));

               Tests.Unit(true,  v0.colineaire(v1));
               Tests.Unit(true,  v1.colineaire(v2));
               Tests.Unit(false, v3.colineaire(v4));
            }

            Tests.Case("Methode orthogonal"); {
            Vecteur v0= new Vecteur();
            Vecteur v1= new Vecteur (new Fraction(1), new Fraction(2));
            Vecteur v2= new Vecteur (new Fraction(-2), new Fraction(-4));
            Vecteur v3= new Vecteur (new Fraction(-1), new Fraction(1));
            Vecteur v4= new Vecteur (new Fraction(1), new Fraction(1));

               Tests.Unit(true,  v0.orthogonal(v1));
               Tests.Unit(false, v1.orthogonal(v2));
               Tests.Unit(true,  v3.orthogonal(v4));
            }
         }

      Tests.End();
   }
}
