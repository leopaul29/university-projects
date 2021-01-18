/**
 * @(#)T_BatailleNavale_N2.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/28
 */

import batailleNavale.*;
import java.util.*;
import java.lang.*;

public class T_BatailleNavale_N2 {

   public static void main (String[] args) throws Exception {
   	
   	  Grille g1 = new Grille();

      Tests.Begin("batailleNavale", "1.0.0");
      
      	Tests.Design("Controle du placement des bateaux", 3); {
      		
      		Tests.Case("Placement d'un torpilleur"); {
      			
      			g1.placer(1,1,1,2);
      			Tests.Unit(true, g1.estOccupe(1,1));
      			Tests.Unit(true, g1.estOccupe(1,2));
      			Tests.Unit(false, g1.estOccupe(1,3));
      		}
      		
      		Tests.Case("Placement d'un croiseur"); {
      			
      			g1.placer(3,1,3,2,3,3);
      			Tests.Unit(true, g1.estOccupe(3,1));
      			Tests.Unit(true, g1.estOccupe(3,2));
      			Tests.Unit(true, g1.estOccupe(3,3));
      			Tests.Unit(false, g1.estOccupe(2,3));
      		}
      		
      		Tests.Case("Placement d'un cuirassé"); {
      			
      			g1.placer(6,6,6,7,6,8,6,9);
      			Tests.Unit(true, g1.estOccupe(6,6));
      			Tests.Unit(true, g1.estOccupe(6,7));
      			Tests.Unit(true, g1.estOccupe(6,8));
      			Tests.Unit(true, g1.estOccupe(6,9));
      			Tests.Unit(false, g1.estOccupe(8,9));
      		}
      		
      	}
   }
}