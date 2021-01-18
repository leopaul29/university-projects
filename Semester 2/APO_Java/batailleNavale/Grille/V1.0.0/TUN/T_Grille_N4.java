/**
 * @(#)T_Grille_N4.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/24
 */

import batailleNavale.*;

public class T_Grille_N4 {
    
    public static void main(String[] args)throws Exception{
    	
    	Grille g1 = new Grille();
    	Grille g2 = new Grille();
    	Grille g3 = new Grille(10,15);
    	
    	Tests.Begin("Bataille Navale","0.0.0");
    	
    		Tests.Design("tests de equals, et clone",3);
    		
    			Tests.Case("clone");{
    				
    				Grille t1 = (Grille)g1.clone();
    				Tests.Unit(g1.toString(), t1.toString());
    				
    				Grille t2 = (Grille)g3.clone();
    				Tests.Unit(g3.toString(), t2.toString());
    			}
    			
    			Tests.Case("equals");{
    				
    				Tests.Unit(true, g1.equals(g2));
    				Tests.Unit(false, g2.equals(g3));
    				g1.setCase(2,3,'B');
    				Tests.Unit(false, g1.equals(g2));
    			}
    			
    	Tests.End();
    }
    
}