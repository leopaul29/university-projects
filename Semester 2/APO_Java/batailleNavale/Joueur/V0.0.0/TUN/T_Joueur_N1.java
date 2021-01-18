/**
 * @(#)T_Joueur_N1.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/4
 */
 
import batailleNavale.*;

public class T_Joueur_N1 {

    public static void main (String[] args) throws Exception {

      Tests.Begin("Joueur", "0.0.0");
      
      	Tests.Design("Controle de la construction sans nom de joueur (2 joueurs maximum)", 3); {

            Tests.Case("Construction sans parametres"); {
            	Joueur j1= new Joueur();
            	
            	Tests.Unit("[Joueur 1, [ Lignes : 10 , Colonnes : 10 ]]",  j1.toString());
            }

			Tests.Case("Construction avec une grille en parametres"); {
            	Joueur j1= new Joueur(12, 12);
            	
            	Tests.Unit("[Joueur 2, [ Lignes : 12 , Colonnes : 12 ]]",  j1.toString());
            }
            
         }
      Tests.End();
    }    
}