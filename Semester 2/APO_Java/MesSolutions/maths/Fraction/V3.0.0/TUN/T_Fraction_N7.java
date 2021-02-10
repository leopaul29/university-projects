//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Fraction - Tests unitaires de la methode racine carré (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.Fraction;

public class T_Fraction_N7 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Fraction", "3.0.0");

         Tests.Design("Controle de la methode sqrt", 3); {

            Tests.Case("Construction avec normalisation du signe"); {
            Fraction f1= new Fraction(225,36);
            Fraction f2= new Fraction(121);
            Fraction f3= new Fraction(9,16);
            Fraction f4= new Fraction(64);
            Fraction f5= new Fraction(0);

               Tests.Unit("5/2", f1.sqrt());
               Tests.Unit("11", f2.sqrt());
               Tests.Unit("3/4", f3.sqrt());
               Tests.Unit("8", f4.sqrt());
               Tests.Unit("0", f5.sqrt());
              
			}
		}
		Tests.End();
	}
}
