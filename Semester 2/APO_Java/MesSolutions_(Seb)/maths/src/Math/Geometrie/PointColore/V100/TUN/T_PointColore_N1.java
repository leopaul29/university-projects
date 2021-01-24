
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur :S. Nicoletti et moi
//

package Math.Geometrie.PointColore.V100.TUN;
import java.awt.Color;

import Math.Teste.*;
import Math.Geometrie.PointColore.V100.*;


public class T_PointColore_N1 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.3.0");

         Tests.Design("Controle de la construction", 3); {


            Tests.Case("Construction sans parametres"); {
            PointColore p1= new PointColore();
            Tests.Unit("_ (0.0, 0.0) : java.awt.Color[r=0,g=255,b=128]",  p1.toString());
            }//pouet

            Tests.Case("Construction avec deux parametres"); {
            	PointColore p1= new PointColore(2,6.2,new Color(0,255,0) );
            Tests.Unit("_ (2.0, 6.2) : java.awt.Color[r=0,g=255,b=0]",  p1.toString());
            }

            Tests.Case("Construction avec tous les parametres"); {
            PointColore p1= new PointColore('A',1,1, new Color (0,128,64) );
            Tests.Unit("A (1.0, 1.0) : java.awt.Color[r=0,g=128,b=64]",  p1.toString());
            }
            
          
            }
            
        Tests.Design("Controle de la Equals", 3); {
        	
        	Tests.Case("equals"); {
            PointColore p1= new PointColore('A',1.0,1.0 , new Color (0,128,64) );
            PointColore p2 = (PointColore) p1.clone();
            PointColore p3 = new PointColore ('A',0.0,1.0 , new Color (0,120,65) );
            	
            Tests.Unit("A (1.0, 1.0) : java.awt.Color[r=0,g=128,b=64]",  p2.toString());
            
            Tests.Unit(true,  p1.equals(p2));
            Tests.Unit(true,  p2.equals(p1));
            Tests.Unit(false, p1.equals(p3));
        
        }
            
         }
      Tests.End();
   }
}
