/**
 * @(#)T_Grille_N1.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/7
 */

import batailleNavale.*;

public class T_Grille_N1 {

	public static void main(String [] args)throws Exception{
		
		Grille g1 = new Grille();
		Grille g2 = new Grille(12,12);
		Grille g3 = new Grille(15,11);
		
		Tests.Begin("Bataille Navale","V0.0.0");
		
			Tests.Design("Tests des constructeurs et des accesseurs",3);
			
				Tests.Case("premier et second constructeurs et des accesseurs");{
					
					Tests.Unit(10,g1.getLigne());
					Tests.Unit(10,g1.getColonne());
					Tests.Unit("[ Lignes : 10 , Colonnes : 10 ]",g1.toString());
					
					Tests.Unit(12,g2.getLigne());
					Tests.Unit(12,g2.getColonne());
					Tests.Unit("[ Lignes : 12 , Colonnes : 12 ]",g2.toString());
					
					Tests.Unit(11,g3.getLigne());
					Tests.Unit(15,g3.getColonne());
					Tests.Unit("[ Lignes : 11 , Colonnes : 15 ]",g3.toString());
				}
				
				Tests.Case("setCase et getCase");{
					
					Tests.Unit('V', g1.getCase(2,3));
					g1.setCase(2,3,'C');
					Tests.Unit('C', g1.getCase(2,3));
					
					Tests.Unit('V', g2.getCase(4,2));
					g2.setCase(4,2,'R');
					Tests.Unit('R', g2.getCase(4,2));	
				}
				
		Tests.End();
	}
 
}