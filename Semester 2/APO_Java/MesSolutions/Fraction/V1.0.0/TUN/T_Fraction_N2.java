//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Fraction - Tests unitaires des accesseur (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Fraction_N2 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Fraction", "1.0.0");

         Tests.Design("Controle des accesseur", 3); {
         	
         	Tests.Case("Affichage des numerateur"); {
         	Fraction f1= new Fraction(2,3);
            Fraction f2= new Fraction(2,-3);
            Fraction f3= new Fraction(2,-1);
            Fraction f4= new Fraction(-2,-3);

               Tests.Unit(2, f1.getNumerateur());
               Tests.Unit(-2, f2.getNumerateur());
               Tests.Unit(-2, f3.getNumerateur());
               Tests.Unit(2, f4.getNumerateur());
            }

            Tests.Case("Affichage des denominateur"); {
            Fraction f1= new Fraction(3,36);
            Fraction f2= new Fraction(-15,-45);
            Fraction f3= new Fraction(36,-14);
            Fraction f4= new Fraction(-4,-10);

               Tests.Unit(12, f1.getDenominateur());
               Tests.Unit(3, f2.getDenominateur());
               Tests.Unit(7, f3.getDenominateur());
               Tests.Unit(5, f4.getDenominateur());
            }

            Tests.Case("Afficher le resultat"); {
            Fraction f1= new Fraction(12,2);
            Fraction f2= new Fraction(1,1);
            Fraction f3= new Fraction(60,3);
            Fraction f4= new Fraction(300,-300);

               Tests.Unit(6.0, f1.getValeur());
               Tests.Unit(1.0, f2.getValeur());
               Tests.Unit(20.0, f3.getValeur());
               Tests.Unit(-1.0, f4.getValeur());
		   }          
         }

      Tests.End();
   }
}