//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Fraction - Tests unitaires du compteur (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.Fraction;

public class T_Fraction_N9 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Fraction", "3.0.0");

         Tests.Design("Controle des accesseu compteur", 3); {
         	
         	Tests.Case("Affichage de compteur = 1"); {

         	Fraction f1= new Fraction(2,3);
               Tests.Unit(1,  Fraction.getCompteur());
            }
            
            Tests.Case("Affichage de compteur : 3+1=4"); {
            	
            Fraction f2= new Fraction(2);
            Fraction f3= new Fraction();
            Fraction f4= new Fraction(-2,-3);
            	Tests.Unit(4, Fraction.getCompteur());
            }      
         }

      Tests.End();
   }
}