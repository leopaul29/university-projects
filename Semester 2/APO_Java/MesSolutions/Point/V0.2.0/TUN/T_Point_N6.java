//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point- Tests unitaires des translation (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Point_N6 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.1.0");

         Tests.Design("Controle de la translation", 3); {

			Tests.Case("Methode translation"); {
			Point p1= new Point(2,3);
            Point p2= new Point(2,-3);
            Point p3= new Point(2,-1);
            Point p4= new Point(-2,-3);
            double i1 = -2.0; double i2 = -3.0;
            
            p1.translation(i1,i2);
            p2.translation(i1,i2);
            p3.translation(i1,i2);
            p4.translation(i1,i2);
			
			   Tests.Unit("_(0.0, 0.0)", p1.toString());
               Tests.Unit("_(0.0, -6.0)", p2.toString());
               Tests.Unit("_(0.0, -4.0)", p3.toString());
               Tests.Unit("_(-4.0, -6.0)", p4.toString());
            }
			
            Tests.Case("Methode translate"); {
			Point p1= new Point(2,3);
            Point p2= new Point(2,-3);
            Point p3= new Point(2,-1);
            Point p4= new Point(-2,-3);
            double i1 = -2; double i2 = -3;
            
            Point P1=null, P2=null, P3=null, P4=null;
            P1=p1.translate(i1,i2);
            P2=p2.translate(i1,i2);
            P3=p3.translate(i1,i2);
            P4=p4.translate(i1,i2);

				Tests.Unit("_(0.0, 0.0)", P1.toString());
               	Tests.Unit("_(0.0, -6.0)", P2.toString());
               	Tests.Unit("_(0.0, -4.0)", P3.toString());
               	Tests.Unit("_(-4.0, -6.0)", P4.toString());
            }
         }
         
      Tests.End();
   }
}
