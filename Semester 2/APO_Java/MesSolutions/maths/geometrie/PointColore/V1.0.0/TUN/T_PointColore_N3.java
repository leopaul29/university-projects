//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point- Tests unitaires des methodes (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.PointColore;
import java.awt.*;

public class T_PointColore_N3 {

    public static void main (String[] args) throws Exception {

      Tests.Begin("PointColore", "1.0.0");

         Tests.Design("Methodes", 3); {
         	
         	PointColore p1 = new PointColore();
			PointColore p2 = new PointColore(2,2,Color.red);
			PointColore p3 = new PointColore(2,2,Color.red);
			PointColore p4 = new PointColore('Z',5.2,6,Color.black);
			PointColore p5 = new PointColore('_',0.0,0.0,Color.black);
         	
            Tests.Case("Methode memeCouleur"); {
    			Tests.Unit(false, p1.memeCouleur(p2));
    			Tests.Unit(false, p1.memeCouleur(p3));
    			Tests.Unit(true, p2.memeCouleur(p3));
             }
             
             Tests.Case("Methode equals"); {
             	Tests.Unit(false, p1.equals(p2));
             	Tests.Unit(true, p2.equals(p3));
             	Tests.Unit(false, p1.equals(p4));
             	Tests.Unit(true, p1.equals(p5));
             }
         }
         
      Tests.End();
   }
}
