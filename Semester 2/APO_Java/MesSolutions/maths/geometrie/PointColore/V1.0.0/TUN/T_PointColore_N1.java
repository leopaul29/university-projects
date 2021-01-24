//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point- Tests unitaires des constructeurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.PointColore;
import java.awt.*;

public class T_PointColore_N1 {

    public static void main (String[] args) throws Exception {

      Tests.Begin("PointColore", "1.0.0");
      
      	 	Tests.Design("Constructeur", 3); {	
			
				PointColore p1 = new PointColore();
				PointColore p2 = new PointColore(2,2,Color.red);
				PointColore p3 = new PointColore('A',2.9,10.4,Color.cyan);
				
				Tests.Case("Constructeur par défaut"); {
    				Tests.Unit("_(0.0, 0.0) : java.awt.Color[r=0,g=0,b=0]", p1.toString());
           		}
           		
           		Tests.Case("1er Constructeur normal"); {
    				Tests.Unit("_(2.0, 2.0) : java.awt.Color[r=255,g=0,b=0]", p2.toString());
           		}
           		
           		Tests.Case("2èm Constructeur normal"); {
    				Tests.Unit("A(2.9, 10.4) : java.awt.Color[r=0,g=255,b=255]", p3.toString());
           		}
           		
         	}
         
      Tests.End();
    } 
}