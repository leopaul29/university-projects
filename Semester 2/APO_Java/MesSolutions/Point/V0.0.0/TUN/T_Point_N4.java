//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point- Tests unitaires de projX et projY (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Point_N4 {

    public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.0.0");

         Tests.Design("Controle des methodes projX et projY", 3); {

            Tests.Case("Sur l'axe des abscisses"); {
            Point p1= new Point('A',0,2);
            Point p2= new Point('B',1,0);
            Point p3= new Point('C',2,1);
            
            Point P1 = null, P2 = null, P3 = null;
            	P1 = p1.projX();
            	P2 = p2.projX();
            	P3 = p3.projX();

            Tests.Unit("_(0.0, 0.0)",  P1.toString());
            Tests.Unit("_(1.0, 0.0)",  P2.toString());
            Tests.Unit("_(2.0, 0.0)",  P3.toString());
            }

            Tests.Case("Sur l'axe des ordonnées"); {
            Point p1= new Point('A',2,0);
            Point p2= new Point('B',0,1);
            Point p3= new Point('C',1,2);
            
            Point P1 = null, P2 = null, P3 = null;
            	P1 = p1.projY();
            	P2 = p2.projY();
            	P3 = p3.projY();

            Tests.Unit("_(0.0, 0.0)",  P1.toString());
            Tests.Unit("_(0.0, 1.0)",  P2.toString());
            Tests.Unit("_(0.0, 2.0)",  P3.toString());
            }
         }
         
      Tests.End();
    }
}