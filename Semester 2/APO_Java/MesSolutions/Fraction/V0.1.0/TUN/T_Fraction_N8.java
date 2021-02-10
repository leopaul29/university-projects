//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Fraction - Tests unitaires des methodes opposé et inverse (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Fraction_N8 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Fraction", "0.1.0");

         Tests.Design("Controle de la methode oppose et inverse", 3); {

            Tests.Case("Construction avec la methode inverse"); {
            Fraction f1= new Fraction(8,24);
            Fraction f2= new Fraction(-15,-45);
            Fraction f3= new Fraction(36,-14);
            Fraction f4= new Fraction(-4,-10);

			Fraction F1=null,F2=null,F3=null,F4=null;
				F1 = f1.inverse();
				F2 = f2.inverse();
				F3 = f3.inverse();
				F4 = f4.inverse();
				
               Tests.Unit("3", F1.toString());
               Tests.Unit("3", F2.toString());
               Tests.Unit("-7/18", F3.toString());
               Tests.Unit("5/2", F4.toString());
            }

            Tests.Case("Construction avec le methode oppose"); {
            Fraction f1= new Fraction(12,2);
            Fraction f2= new Fraction(1,1);
            Fraction f3= new Fraction(60,3);
            Fraction f4= new Fraction(300,-300);
            
				f1.oppose();
				f2.oppose();
				f3.oppose();
				f4.oppose();

               Tests.Unit("-6", f1.toString());
               Tests.Unit("-1", f2.toString());
               Tests.Unit("-20", f3.toString());
               Tests.Unit("1", f4.toString());
           	}
		}
		
	  Tests.End();
	}
}
