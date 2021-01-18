/**
 * @(#)T_Grille_N3.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/10
 */

import batailleNavale.*;

public class T_Grille_N3 {

	static public void main(String[] args)throws Exception{
		
		Grille g1 = new Grille();
		
		Tests.Begin("Bataille Navale","V0.0.0");
		
			Tests.Design("Test de jeu",3);
			
				Tests.Case("coup");{
					
					g1.setCase(2,3,'B');
					g1.coup(2,3);
					g1.coup(2,4);
					Tests.Unit('R',g1.getCase(2,4));
					Tests.Unit('T',g1.getCase(2,3));
				}
				
				Tests.Case("verifCoord(pour un torpilleur");{
					
					Tests.Unit(true, g1.verifCoord(2,3,2,4));
					Tests.Unit(true, g1.verifCoord(2,3,1,3));
					Tests.Unit(false, g1.verifCoord(2,3,3,4));
				}
				
				Tests.Case("verifCoord(pour un croiseur)");{
					
					Tests.Unit(true, g1.verifCoord(2,2,2,3,2,4));
					Tests.Unit(true, g1.verifCoord(3,3,2,3,4,3));
					Tests.Unit(false, g1.verifCoord(4,3,4,3,4,3));
					Tests.Unit(true, g1.verifCoord(5,2,5,1,5,3));
					Tests.Unit(false, g1.verifCoord(2,3,3,4,4,5));
				}
				
				Tests.Case("verifCoord(pour un cuirassé)");{
					
					Tests.Unit(true, g1.verifCoord(2,2,2,3,2,4,2,5));
					Tests.Unit(false, g1.verifCoord(2,3,3,4,4,5,5,6));
				}
				
				Tests.Case("verifPlaceBateau(torpilleur)");{
					
					Tests.Unit(true, g1.verifPlaceBateau(6,1,6,2));
					Tests.Unit(false, g1.verifPlaceBateau(2,3,2,4));
					Tests.Unit(false, g1.verifPlaceBateau(2,2,3,2));
					Tests.Unit(true, g1.verifPlaceBateau(2,6,3,6));
				}
				
				Tests.Case("verifPlaceBateau(croiseur)");{
					
					Grille g2 = new Grille();
					Tests.Unit(true, g2.verifPlaceBateau(6,2,6,3,6,4));
					g2.setCase(2,5,'B');
					Tests.Unit(false, g2.verifPlaceBateau(2,3,2,4,2,5));
					Tests.Unit(false, g1.verifPlaceBateau(2,5,3,5,4,5));
					Tests.Unit(true, g1.verifPlaceBateau(2,7,3,7,4,7));
				}
				
				Tests.Case("verifPlaceBateau(croiseur)");{
					
					Grille g2 = new Grille();
					Tests.Unit(true, g2.verifPlaceBateau(6,2,6,3,6,4,6,5));
					g2.setCase(2,5,'B');
					Tests.Unit(false, g2.verifPlaceBateau(2,3,2,4,2,5,2,6));
					Tests.Unit(false, g1.verifPlaceBateau(2,5,3,5,4,5,5,5));
					Tests.Unit(true, g1.verifPlaceBateau(2,7,3,7,4,7,5,7));
				}
				
		Tests.End();
	}
    
}