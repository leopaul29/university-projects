/**
 * @(#)T_Joueur_N3.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/10
 */
 
import batailleNavale.*;

public class T_Joueur_N3 {

	public static void main (String[] args) throws Exception {

		Tests.Begin("Joueur", "1.0.0");
      
	      	Tests.Design("Controle des accesseurs", 3); {
			
			Joueur j1= new Joueur();
            String nom1= "Jack";		Joueur j2= new Joueur(nom1, 8, 12);

				Tests.Case("Affichage des Nom de Joueur"); {
					Tests.Unit("Joueur 1", j1.getNom());
					Tests.Unit("Jack", j2.getNom());
				}
		
		        Tests.Case("Affichage des Grilles de Bateau"); {
		            Tests.Unit("[ Lignes : 10 , Colonnes : 10 ]", j1.getGrilleBateau().toString());
		           	Tests.Unit("[ Lignes : 12 , Colonnes : 8 ]", j2.getGrilleBateau().toString());
		        }
		
			    Tests.Case("Affichage des Grille avec les Coup joué"); {
		           	Tests.Unit("[ Lignes : 10 , Colonnes : 10 ]", (j1.getGrilleCoup()).toString());
		           	Tests.Unit("[ Lignes : 12 , Colonnes : 8 ]", (j2.getGrilleCoup()).toString());
		        }
		
		        Tests.Case("Affichage du nombre de Joueur créé"); {
		           	Tests.Unit(2, Joueur.getCompteurJoueur());
		        }
	            
         }
      Tests.End();
    }    
}