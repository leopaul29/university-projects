//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Dessin - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur : S.Nicoletti (et un peu Loïc Comoglio)
//
package Dessin.V000.TUN;
import Math.Teste.*;
import Math.Geometrie.FormGeo.*;
import Math.Geometrie.Rectangle.V100.*;
import Math.Geometrie.Carre.V100.*;
import Dessin.V000.*;

public class T_Dessin_N1 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("Dessin", "0.0.0");

         Tests.Design("Controle de la construction", 3); {
        	
        	 Rectangle r1 = new Rectangle();
        	 Carre c1 = new Carre (2);
        	 
        	 Dessin d1 = new Dessin();
        	
        	
            Tests.Case("Construction par default"); {
            	
            }

            Tests.Case("Construction avec reduction"); {

            }

         }

      Tests.End();
   }
}
