/**
 * @(#)T_Joueur_N2.java
 *
 *
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version 1.00 2013/4/28
 */
 
import batailleNavale.*;

public class T_Joueur_N2 {

    public static void main (String[] args) throws Exception {

      Tests.Begin("Joueur", "1.0.0");
      
      	Tests.Design("Controle de la construction avec nom de joueur (2 joueurs maximum)", 3); {

			Tests.Case("Construction avec un nom en parametres"); {
            	String nom= "Joe";
				Joueur j1= new Joueur(nom);
            	
            	Tests.Unit("[Joe, [ Lignes : 10 , Colonnes : 10 ]]",  j1.toString());
            }

			Tests.Case("Construction avec un nom et une grille en parametres"); {
            	String nom= "Guillaume";
            	Joueur j1= new Joueur(nom, 15, 15);
            	
            	Tests.Unit("[Guillaume, [ Lignes : 15 , Colonnes : 15 ]]",  j1.toString());
            }
            
         }
      Tests.End();
    }    
}