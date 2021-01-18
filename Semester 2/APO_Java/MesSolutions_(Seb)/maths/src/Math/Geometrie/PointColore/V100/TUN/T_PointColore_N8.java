
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe PointColore - Tests unitaires des methodes pour sauvegarder et charger
//
// Auteur : Comoglio Loïc tout seul comme un grand
//

package Math.Geometrie.PointColore.V100.TUN;
import Math.Teste.*;
import Math.Geometrie.PointColore.V100.*;

public class T_PointColore_N8 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.PointColore", "2.0.0");

         Tests.Design("Controle des poireaux et des methodes de sauvegarde", 3); {
//pouet
            Tests.Case("save & load"); {
            PointColore p1 = new PointColore('L',1,2);
            PointColore p2 = null;

            PointColore.save("savePointColore", p1);
            //Pomme
            p2 = (PointColore) PointColore.load("savePointColore");
            
            Tests.Unit("L (1.0, 2.0) : java.awt.Color[r=0,g=255,b=128]",  p2.toString());


            }//case


                
           

         }//design
      Tests.End();
   }//begin
}//main
