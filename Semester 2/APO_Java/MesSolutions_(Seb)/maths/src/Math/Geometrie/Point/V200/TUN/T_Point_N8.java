
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point - Tests unitaires des methodes pour sauvegarder et charger
//
// Auteur : Comoglio Loïc tout seul comme un grand
//

package Math.Geometrie.Point.V200.TUN;
import Math.Teste.*;
import Math.Geometrie.Point.V200.*;

public class T_Point_N8 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "2.0.0");

         Tests.Design("Controle des poireaux et des methodes de sauvegarde", 3); {

            Tests.Case("save & load"); {
            Point p1 = new Point('L',1,2);
            Point p2 = null;

            Point.save("savepoint", p1);
            //Pomme
            p2 = Point.load("savepoint");
            
            Tests.Unit("L (1.0, 2.0)",  p2.toString());


            }//case


                
           

         }//design
      Tests.End();
   }//begin
}//main
