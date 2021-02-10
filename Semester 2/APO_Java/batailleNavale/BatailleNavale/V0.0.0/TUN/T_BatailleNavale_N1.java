/**
 * @(#)T_BatailleNavale_N1.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/10
 */
import batailleNavale.*;
import java.util.*;
import java.lang.*;

public class T_BatailleNavale_N1 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("batailleNavale", "0.0.0");
      
      	Tests.Design("Controle des autres methodes", 3); {
      		
      		/*Tests.Case("Afficher la lettre à partir d'un numero de colonne"); {
      			Scanner sc = new Scanner(System.in);
				System.out.println("Veuillez saisir un mot :");
				String str = sc.lireLigne();
				
      			System.out.println("vous avez ecrit : " + Str);
      		}*/
      		
      		Tests.Case("Afficher la lettre à partir d'un numero de colonne"); {
            	Tests.Unit(1, BatailleNavale.getX("A"));
            	Tests.Unit(10, BatailleNavale.getX("J"));
            	Tests.Unit(17, BatailleNavale.getX("Q"));
            	Tests.Unit(26, BatailleNavale.getX("Z"));
            	Tests.Unit(27, BatailleNavale.getX("AA"));
            	Tests.Unit(190, BatailleNavale.getX("GH"));
            	Tests.Unit(702, BatailleNavale.getX("ZZ"));
      		}
      		
      		Tests.Case("Afficher le numero à partir de la lettre de la colonne"); {
            	Tests.Unit(1, BatailleNavale.getY("1"));
            	Tests.Unit(10, BatailleNavale.getY("10"));
            	Tests.Unit(17, BatailleNavale.getY("17"));
            	Tests.Unit(26, BatailleNavale.getY("26"));
            	Tests.Unit(27, BatailleNavale.getY("27"));
            	Tests.Unit(190, BatailleNavale.getY("190"));
            	Tests.Unit(702, BatailleNavale.getY("702"));
			}
			
			Tests.Case("Afficher la lettre à partir d'un numero de colonne"); {
            	Tests.Unit(1, BatailleNavale.NumCol("A"));
            	Tests.Unit(10, BatailleNavale.NumCol("J"));
            	Tests.Unit(17, BatailleNavale.NumCol("Q"));
            	Tests.Unit(26, BatailleNavale.NumCol("Z"));
            	Tests.Unit(27, BatailleNavale.NumCol("AA"));
            	Tests.Unit(190, BatailleNavale.NumCol("GH"));
            	Tests.Unit(702, BatailleNavale.NumCol("ZZ"));
			}
			
			Tests.Case("Afficher le numero à partir de la lettre de la colonne"); {
            	Tests.Unit("A", BatailleNavale.CharCol(1));
            	Tests.Unit("J", BatailleNavale.CharCol(10));
            	Tests.Unit("Q", BatailleNavale.CharCol(17));
            	Tests.Unit("Z", BatailleNavale.CharCol(26));
            	Tests.Unit("AA", BatailleNavale.CharCol(27));
            	Tests.Unit("GH", BatailleNavale.CharCol(190));
            	Tests.Unit("ZZ", BatailleNavale.CharCol(702));
			}
            
         }
      Tests.End();
    }    
}