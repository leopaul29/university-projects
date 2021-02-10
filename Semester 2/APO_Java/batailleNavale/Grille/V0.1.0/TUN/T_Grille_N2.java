/**
 * @(#)T_Grille_N2.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/7
 */


import batailleNavale.*;

public class T_Grille_N2 {

	public static void main(String [] args)throws Exception{
		
		Grille g1 = new Grille();
		
		Tests.Begin("Bataille Navale","V0.0.0");
		
			Tests.Design("Tests des etats",3);
			
				Tests.Case("estVide");{
					
					Tests.Unit(true, g1.estVide(2,3));
					Tests.Unit(true, g1.estVide(5,6));
					g1.setCase(5,6,'R');
					Tests.Unit(false, g1.estVide(5,6));	
				}
				
				Tests.Case("estOccupe");{
					Tests.Unit(false, g1.estOccupe(2,3));
					Tests.Unit(false, g1.estOccupe(5,6));
					g1.setCase(5,6,'B');
					Tests.Unit(true, g1.estOccupe(5,6));
				}
				
				Tests.Case("estCoule");{
					
				g1.setCase(2,1,'T');
				g1.setCase(2,2,'T');
				g1.setCase(2,3,'B');
				g1.setCase(2,4,'T');
				
				g1.setCase(5,1,'T');
				g1.setCase(5,2,'T');
				g1.setCase(5,3,'T');
				g1.setCase(5,4,'T');
				
					Tests.Unit(false, g1.estCoule(2,1));
					Tests.Unit(false, g1.estCoule(2,2));
					Tests.Unit(false, g1.estCoule(2,3));
					Tests.Unit(false, g1.estCoule(2,4));
					
					Tests.Unit(true, g1.estCoule(5,1));
					Tests.Unit(true, g1.estCoule(5,2));
					Tests.Unit(true, g1.estCoule(5,3));
					Tests.Unit(true, g1.estCoule(5,4));
				}
				
				Tests.Case("aEteJoue");{
					
					g1.setCase(3,5,'R');
					g1.setCase(3,6,'T');
					g1.setCase(3,7,'B');
					g1.setCase(3,8,'V');
					g1.setCase(3,9,'C');
					
					Tests.Unit(true, g1.aEteJoue(3,5));
					Tests.Unit(true, g1.aEteJoue(3,6));
					Tests.Unit(false, g1.aEteJoue(3,7));
					Tests.Unit(false, g1.aEteJoue(3,8));
					Tests.Unit(true, g1.aEteJoue(3,9));
				}
				
				Tests.Case("estRate");{
					
					g1.setCase(3,5,'R');
					g1.setCase(3,6,'T');
					g1.setCase(3,7,'B');
					g1.setCase(3,8,'V');
					g1.setCase(3,9,'C');
					
					Tests.Unit(true, g1.estRate(3,5));
					Tests.Unit(false, g1.estRate(3,6));
					Tests.Unit(false, g1.estRate(3,7));
					Tests.Unit(false, g1.estRate(3,8));
					Tests.Unit(false, g1.estRate(3,9));
				}
				
				Tests.Case("estTouche");{
					
					g1.setCase(3,5,'R');
					g1.setCase(3,6,'T');
					g1.setCase(3,7,'B');
					g1.setCase(3,8,'V');
					g1.setCase(3,9,'C');
					
					Tests.Unit(false, g1.estTouche(3,5));
					Tests.Unit(true, g1.estTouche(3,6));
					Tests.Unit(false, g1.estTouche(3,7));
					Tests.Unit(false, g1.estTouche(3,8));
					Tests.Unit(false, g1.estTouche(3,9));
				}
				
		Tests.End();
	}
    
    
}