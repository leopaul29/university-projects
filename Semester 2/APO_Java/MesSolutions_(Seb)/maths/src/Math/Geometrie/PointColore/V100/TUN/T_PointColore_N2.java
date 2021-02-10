
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point - Tests unitaires des accesseurs
//
// Auteur : S. Nicoletti et encore moi
//

package Math.Geometrie.PointColore.V100.TUN;
import java.awt.Color;
//import petitpois.bonheur.*;
import Math.Teste.*;
import Math.Geometrie.PointColore.V100.*;

public class T_PointColore_N2 {

   public static void main (String[] args) throws Exception {
//MEGAPOUET
      Tests.Begin("_Maths.Point", "0.1.0");

         Tests.Design("Controle des accesseurs de consultation de la jolie couleur", 3); {

            Tests.Case("Consultation Abscisse"); {
            PointColore p1= new PointColore('A',1,2);
            Tests.Unit(1.0,  p1.x());
            }

            Tests.Case("Consultation Ordonnee"); {
            PointColore p1= new PointColore('A',1,2);
            Tests.Unit(2.0,  p1.y());
            }

            Tests.Case("Consultation Nom"); {
            	PointColore p1= new PointColore('A',1,2);
            Tests.Unit('A',  p1.getNom());
            }
            
            Tests.Case("Consultation COULEUUUUR"); {
            	PointColore p1= new PointColore('L',5,2 , new Color (14,114,84) );
            Tests.Unit("java.awt.Color[r=14,g=114,b=84]",  p1.getCouleur().toString() );
            }
         }
      Tests.End();
   }
}
