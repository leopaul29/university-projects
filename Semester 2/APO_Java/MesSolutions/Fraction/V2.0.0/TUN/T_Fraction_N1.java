//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Fraction - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Fraction_N1 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Fraction", "0.1.0");
      
      	 Tests.Design("Controle des methode clone et equals", 3); {
         	
         	Tests.Case("Methode clone"); {
         	Fraction f1= new Fraction(2,3);
         	Fraction f2= (Fraction)f1.clone();

               	Tests.Unit(2,  Fraction.getCompteur());
				Tests.Unit(true,  f1.equals(f1.clone()));
				Tests.Unit(true,  f1.equals(f2));
            }
            
            Tests.Case("Methode equals"); {
         	Fraction f1= new Fraction(2,3);
         	Fraction f2= new Fraction(-2,-3);
			Fraction f3= new Fraction(4,6);
			Fraction f4= new Fraction(5,-7);
         	
               	Tests.Unit(true,  f1.equals(f1));
				Tests.Unit(true,  f1.equals(f2));
				Tests.Unit(true,  f1.equals(f3));
				Tests.Unit(false,  f3.equals(f4));
            }
      	 }

         Tests.Design("Controle de la construction", 3); {

            Tests.Case("Construction avec normalisation du signe"); {
            Fraction f1= new Fraction(2,3);
            Fraction f2= new Fraction(2,-3);
            Fraction f3= new Fraction(2,-1);
            Fraction f4= new Fraction(-2,-3);

               Tests.Unit("2/3",  f1.toString());
               Tests.Unit("-2/3", f2.toString());
               Tests.Unit("-2",   f3.toString());
               Tests.Unit("2/3",  f4.toString());
            }

            Tests.Case("Construction avec reduction"); {
            Fraction f1= new Fraction(3,36);
            Fraction f2= new Fraction(-15,-45);
            Fraction f3= new Fraction(36,-14);
            Fraction f4= new Fraction(-4,-10);

               Tests.Unit("1/12",  f1.toString());
               Tests.Unit("1/3",   f2.toString());
               Tests.Unit("-18/7", f3.toString());
               Tests.Unit("2/5",   f4.toString());
            }

            Tests.Case("Construction avec resultat entier"); {
            Fraction f1= new Fraction(12,2);
            Fraction f2= new Fraction(1,1);
            Fraction f3= new Fraction(60,3);
            Fraction f4= new Fraction(300,-300);

               Tests.Unit("6",   f1.toString());
               Tests.Unit("1",   f2.toString());
               Tests.Unit("20",  f3.toString());
               Tests.Unit("-1",  f4.toString());
            }

            Tests.Case("Construction avec resultat nul"); {
            Fraction f1= new Fraction(0,-2);
            Fraction f2= new Fraction(0,1);
            Fraction f3= new Fraction(0,-1);
            Fraction f4= new Fraction(-0,-3);

               Tests.Unit("0",  f1.toString());
               Tests.Unit("0",  f2.toString());
               Tests.Unit("0",  f3.toString());
               Tests.Unit("0",  f4.toString());
            }
         }
         
         Tests.Design("Controle de la construction avec un double", 3); {

            Tests.Case("Construction avec normalisation du signe"); {
            Fraction f1= new Fraction(2.2);
            Fraction f2= new Fraction(-3.5);
            Fraction f3= new Fraction(-1.9);
            Fraction f4= new Fraction(7.8);
            Fraction f5= new Fraction(12.2);
            Fraction f6= new Fraction(1.1);
            Fraction f7= new Fraction(60.3);
            Fraction f8= new Fraction(300.0);

               Tests.Unit("11/5", f1.toString());
               Tests.Unit("-7/2", f2.toString());
               Tests.Unit("-19/10", f3.toString());
               Tests.Unit("39/5", f4.toString());
               Tests.Unit("61/5", f5.toString());
               Tests.Unit("11/10", f6.toString());
               Tests.Unit("603/10", f7.toString());
               Tests.Unit("300", f8.toString());
            }
         }
         
      Tests.End();
   }
}
