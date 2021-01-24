//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Vecteur - Tests unitaires des accesseurs (cas nominaux)
//
// Auteur : A. Thuaire
//

public class T_Vecteur_N2 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Vecteur", "1.0.0");

         Tests.Design("Controle des accesseurs", 3); {

            Tests.Case("Methode getAbscisse"); {
            	Fraction f1 = new Fraction(1);
            	Fraction f2 = new Fraction(2);
            	Vecteur v1= new Vecteur (f1, f2);

             	Fraction f3 = new Fraction(3,2);
            	Fraction f4 = new Fraction(-2);
             	Vecteur v2= new Vecteur (f3, f4);

              	Tests.Unit(1.0, v1.getAbscisse().getValeur());
               	Tests.Unit(1.5, v2.getAbscisse().getValeur());            }

            Tests.Case("Methode getOrdonnee"); {
            	Fraction f1 = new Fraction(1);
            	Fraction f2 = new Fraction(2);
            	Vecteur v1= new Vecteur (f1, f2);

            	Fraction f3 = new Fraction(3,2);
            	Fraction f4 = new Fraction(-2);
             	Vecteur v2= new Vecteur (f3, f4);

               Tests.Unit(2,  v1.getOrdonnee().getValeur());
               Tests.Unit(-2, v2.getOrdonnee().getValeur());
            }

            Tests.Case("Methode getNorme"); {
            Vecteur v1= new Vecteur (new Fraction(1), new Fraction(0));
            Vecteur v2= new Vecteur (new Fraction(0), new Fraction(-4));
            Vecteur v3= new Vecteur (new Fraction(3), new Fraction(-4));

               Tests.Unit(1.0, v1.getNorme());
               Tests.Unit(4.0, v2.getNorme());
               Tests.Unit(5.0, v3.getNorme());
            }
         }

      Tests.End();
   }
}
