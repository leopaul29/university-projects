
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point - Tests unitaires des methodes points confondus
//
// Auteur : S. Nicoletti
//

package Math.Geometrie.PointColore.V100.TUN;
import java.awt.Color;

import Math.Teste.*;
import Math.Geometrie.PointColore.V100.*;

public class T_PointColore_N3 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.1.0");

         Tests.Design("Controle de la methode confondus", 3); {

            Tests.Case("Deux pts confondus"); {
            PointColore p1= new PointColore('A',1,2 , new Color (192,192,192) );
            PointColore p2= new PointColore('B',1,2 , new Color (55,82,66) );
            PointColore p3= new PointColore(1,2.00000000000012 , new Color (22,69,88));
            PointColore p4= new PointColore(1,2 , new Color (6,6,6) );


            Tests.Unit(true,  p1.confondus(p2));
            Tests.Unit(true,  p2.confondus(p1));
            Tests.Unit(true,  p3.confondus(p4));
            }

            Tests.Case("Deux pts non confondus"); {
            PointColore p1= new PointColore('A',1,2 , new Color (255,128,0));
            PointColore p2= new PointColore('B',0,2 , new Color (255,255,0) );
            PointColore p3= new PointColore('C',1,0 , new Color (255,128,255));
            PointColore p4= new PointColore(1,2.0012 , new Color (1,2,3));
            PointColore p5= new PointColore(1,2 , new Color (3,2,1));

            Tests.Unit(false,  p1.confondus(p2));
            Tests.Unit(false,  p2.confondus(p1));
            Tests.Unit(false,  p1.confondus(p3));
            Tests.Unit(false,  p2.confondus(p3));
            Tests.Unit(false,  p4.confondus(p5));
            }
            
            
            Tests.Case("Deux pts meme couuuuuleurs"); {
                PointColore p1= new PointColore(1,2 , new Color (255,128,0));
                PointColore p2= new PointColore(1,2 , new Color (255,128,0));
                
                PointColore p3= new PointColore(1,2 , new Color (254,128,0));
                PointColore p4= new PointColore(1,2 , new Color (255,138,0));
                PointColore p5= new PointColore(1,2 , new Color (255,128,1));


     

                Tests.Unit(true,  p1.memeCouleur(p2));
                Tests.Unit(true,  p2.memeCouleur(p1));
                
                Tests.Unit(false,  p1.memeCouleur(p3));            
                Tests.Unit(false,  p1.memeCouleur(p4));
                Tests.Unit(false,  p1.memeCouleur(p5));
                Tests.Unit(false,  p3.memeCouleur(p4));
                //Hyperpouet


                }
         }
      Tests.End();
   }
}
