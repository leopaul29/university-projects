//
// IUT de Nice / Departement informatique / Module APO-C++
// Annee 2012_2013 - Package _Maths
//
// Classe Fraction - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur :L. Brenac
//
#include "..\_SRC\Fraction.h"
#include "T:\_Tests\Tests\Tests.h"

void main () {

   Tests::Begin("_Maths.Fraction", "1.0.0");

      Tests::Design("Controle de la construction", 3);
	
         Tests::Case("Construction avec normalisation du signe"); {
         Fraction f1(2,3), f2(2,-3), f3(2,-1), f4(-2,-3);

            Tests::Unit("2/3",  f1.toString());
            Tests::Unit("-2/3", f2.toString());
            Tests::Unit("-2",   f3.toString());
            Tests::Unit("2/3",  f4.toString());
         }

         Tests::Case("Construction avec reduction"); {
         Fraction f1(3,36), f2(-15,-45), f3(36,-14), f4(-4,-10);
  
            Tests::Unit("1/12",  f1.toString());
            Tests::Unit("1/3",   f2.toString());
            Tests::Unit("-18/7", f3.toString());
            Tests::Unit("2/5",   f4.toString());
         }
 
         Tests::Case("Construction avec resultat entier"); {
         Fraction f1(12,2), f2(1,1), f3(60,3), f4(300,-300);
  
            Tests::Unit("6",   f1.toString());
            Tests::Unit("1",   f2.toString());
            Tests::Unit("20",  f3.toString());
            Tests::Unit("-1",  f4.toString());
         }

         Tests::Case("Construction avec resultat nul"); {
         Fraction f1(0,-2), f2(0,1), f3(0,-1), f4(-0,-3);
  
            Tests::Unit("0",  f1.toString());
            Tests::Unit("0",  f2.toString());
            Tests::Unit("0",  f3.toString());
            Tests::Unit("0",  f4.toString());
         }

         Tests::Case("Construction par copie"); {   
         Fraction f1(1,2), f2(1,-2), f3(60,3), f4(14,-38);
         Fraction r1(f1), r2(f2), r3(f3), r4(f4);
  
            Tests::Unit(f1.toString(), r1.toString());
            Tests::Unit(f2.toString(), r2.toString());
            Tests::Unit(f3.toString(), r3.toString());
            Tests::Unit(f4.toString(), r4.toString());
         }

   Tests::End();
}
