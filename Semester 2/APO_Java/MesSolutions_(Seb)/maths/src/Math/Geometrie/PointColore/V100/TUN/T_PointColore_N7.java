
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe PointColore - Tests unitaires des methodes pour calculer la distance
//
// Auteur : S.Nicoletti
//

package Math.Geometrie.PointColore.V100.TUN;
import Math.Teste.*;
import Math.Geometrie.PointColore.V100.*;

public class T_PointColore_N7 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.PointColore", "0.1.0");

         Tests.Design("Controle des methodes de translation", 3); {

            Tests.Case("Translation: Coordoné positif"); {
            PointColore p1= new PointColore('A',0,0);
            PointColore p2= new PointColore('B',0,1);
            PointColore p3= new PointColore('C',5,1);
            PointColore p4= new PointColore('D',2.3,1.2);
            PointColore p5= new PointColore('E',2.6,9.5);

            p1.translation(0, 0);
            p2.translation(2, 2);
            p3.translation(3, 1);
            p4.translation(1, 3);
            p5.translation(1, 5);


            Tests.Unit("A (0.0, 0.0)",  p1.toString());
            Tests.Unit("B (2.0, 3.0)",  p2.toString());
            Tests.Unit("C (8.0, 2.0)",  p3.toString());
            Tests.Unit("D (3.3, 4.2)",  p4.toString());
            Tests.Unit("E (3.6, 14.5)",  p5.toString());

            }


            Tests.Case("Translation: Coordoné négatif"); {

                PointColore p1= new PointColore('A',0,0);
                PointColore p2= new PointColore('B',0,1);
                PointColore p3= new PointColore('C',5,1);
                PointColore p4= new PointColore('D',-2.3,-1.2);
                PointColore p5= new PointColore('E',-2.6,-9.5);

                p1.translation(-1, -1);
                p2.translation(-2, -2);
                p3.translation(-3, -1);
                p4.translation(-1, -3);
                p5.translation(-1, -5);


                Tests.Unit("A (-1.0, -1.0)",  p1.toString());
                Tests.Unit("B (-2.0, -1.0)",  p2.toString());
                Tests.Unit("C (2.0, 0.0)",  p3.toString());
                Tests.Unit("D (-3.3, -4.2)",  p4.toString());
                Tests.Unit("E (-3.6, -14.5)",  p5.toString());

                }
                
                
                
                Tests.Case("Méthode translaté"); {

                PointColore p1= new PointColore('A',0,0);
                PointColore p2= new PointColore('B',0,1);
                PointColore p3= new PointColore('C',5,1);
                PointColore p4= new PointColore('D',-2.5,-1.2);
                PointColore p5= new PointColore('E',-2.5,-9.5);


                Tests.Unit("_ (1.0, 1.0)",  p1.translate(1,1).toString());
                Tests.Unit("_ (-2.0, -1.0)",  p2.translate(-2,-2).toString());
                
                Tests.Unit("_ (2.0, 2.0)",  p3.translate(-3,1).toString());
                Tests.Unit("_ (-1.0, 2.0)",  p4.translate(1.5,3.2).toString());
                
                Tests.Unit("_ (2.0, -14.0)",  p5.translate(4.5,-4.5).toString());
                }

         }
      Tests.End();
   }
}
