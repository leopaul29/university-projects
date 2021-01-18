//T-Collection_N1

//
// IUT de Nice / Departement informatique / Module APO-C++
// Annee 2012_2013 - Package _Maths
//
// Classe Fraction - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur :L. Brenac
//
#include "Collection.h"
#include "..\..\TP1\Fraction\Fraction.h"
#include "..\..\Tests\Tests.h"

void main () {

   Tests::Begin("Collectio", "1.0.0");

      Tests::Design("Controle de la construction", 3);
	
         Tests::Case("Construction avec normalisation du signe"); {
			Collection c1 = Collection();
			Tests::Unit(" ", c1.toString());
			Fraction f1(1/2);
			Fraction f2(3/4);
			c1 += f1;
			Tests::Unit("[1/2]", c1.toString());
			c1 += f2;
			Tests::Units(["1/2,3/4]"; c1.toString());
         }

   Tests::End();
}
