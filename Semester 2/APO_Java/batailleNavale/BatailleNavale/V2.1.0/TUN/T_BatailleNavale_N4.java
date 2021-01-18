/**
 * @(#)T_BatailleNavale_N4.java
 *
 *
 * @author 
 * @version 1.00 2013/5/15
 */
import batailleNavale.*;
import java.util.*;
import java.lang.*;

public class T_BatailleNavale_N4 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("batailleNavale", "2.1.0");
      
      	Tests.Design("Controle des methodes \"enregistrerData\" et \"restaurerData\"", 3); {
      		
      		Joueur j1= new Joueur();	Joueur j2= new Joueur();
      		
      		j1.getGrilleCoup().setCase(2,2,'R');
      		j2.getGrilleCoup().setCase(3,3,'T');
      		BatailleNavale.enregistrerData();
      		
      		j1.getGrilleCoup().setCase(2,3,'R');
      		j2.getGrilleCoup().setCase(3,4,'T');
      		
      		Tests.Case("restaurerData"); {
			j1= BatailleNavale.restaurerDataj1();
			j2= BatailleNavale.restaurerDataj2();
			
				Tests.Unit('V', j1.getGrilleCoup().getCase(2,3));
				Tests.Unit('V', j2.getGrilleCoup().getCase(3,4));
			}
            
         }
      Tests.End();
    }    
}