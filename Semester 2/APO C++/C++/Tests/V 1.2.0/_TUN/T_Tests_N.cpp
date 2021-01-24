//
// IUT de Nice / Departement informatique / Module APO-C++
// Annee 2009_2010 - Charte des tests unitaires
//
// Exemple d'un module de tests unitaires limites a des cas nominaux
//
// Auteur : A. Thuaire
//
#include "..\_SRC\Tests.h"

void main () {
  
   Tests::Begin("Tests", "1.2.0");

      Tests::Design("Visualisation de niveau 0", 0);
         
         Tests::Case("C1 : 2 / OK"); {			
            Tests::Unit("x", "x");
            Tests::Unit(0, 0);
         }
      			       
      Tests::Design("Visualisation de niveau 1", 1);		
  
	     Tests::Case("C1 : 1 / OK"); {
            Tests::Unit("niveau 1", "niveau 1");
            Tests::Unit(1, 1);
         }

      Tests::Design("Visualisation de niveau 2", 2);		
  
         Tests::Case("C1 : 2 / OK"); {
            Tests::Unit("xxx", "xxx");
            Tests::Unit(2, 2);
         }

         Tests::Case("C2 : 3 / OK"); {
            Tests::Unit("niveau 1", "niveau 1");
            Tests::Unit(1, 1);
            Tests::Unit(-1,-1); 
         } 

      Tests::Design("Visualisation de niveau 3 avec TU tous OK", 3);		
  
	     Tests::Case("C1 : 3 / OK"); {
            Tests::Unit("......", "......");
            Tests::Unit(3, 3);
            Tests::Unit(3, 3);
         }

         Tests::Case("C2 : 2 / OK"); {
            Tests::Unit("xxxxx", "xxxxx");
            Tests::Unit(-3, -3);
         } 
            
         Tests::Case("C3 : 1 / OK"); {
            Tests::Unit(-3.0f, -3.0f);
         }  		
  
         Tests::Case("C1 : 2 / OK"); {
            Tests::Unit("......", "......");
            Tests::Unit(4, 4);
         }

         Tests::Case("C2 : 1 / OK !"); {
            Tests::Unit(-4.0f, -4.01f+0.01f);
         } 
            
         Tests::Case("C3 : 1 / OK"); {
            Tests::Unit(-4.25f, -4.25f);
         }

      Tests::Design("Modification du niveau verbose par un cas de test", 1);		
  
	     Tests::Case("C1 : 3 / OK"); {
            Tests::Unit("......", "......");
            Tests::Unit(3, 3);
            Tests::Unit(3, 3);
         }

         Tests::Case("C2 : 2 / OK", 2); {
            Tests::Unit("xxxxx", "xxxxx");
            Tests::Unit(-3, -3);
         } 
            
         Tests::Case("C3 : 1 / OK"); {
            Tests::Unit(-3.0f, -3.0f);
         }  		
  
         Tests::Case("C1 : 2 / OK", 3); {
            Tests::Unit("......", "......");
            Tests::Unit(4, 4);
         }

         Tests::Case("C2 : 1 / OK !"); {
            Tests::Unit(-4.0f, -4.01f+0.01f);
         } 
            
         Tests::Case("C3 : 1 / OK", 2); {
            Tests::Unit(-4.25f, -4.25f);
         }
             
   Tests::End();
}
