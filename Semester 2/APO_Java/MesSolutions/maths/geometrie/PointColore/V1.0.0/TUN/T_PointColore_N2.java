//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point- Tests unitaires des accesseurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.PointColore;
import java.awt.*;

public class T_PointColore_N2 {

    public static void main (String[] args) throws Exception {

      Tests.Begin("PointColore", "1.0.0");
      
      	 	Tests.Design("Accesseurs", 3); {	
			
				PointColore p1 = new PointColore();
				PointColore p2 = new PointColore('A',2,3,Color.red);
    
    			Tests.Case("Accesseur de consultation du nom"); {
	               	Tests.Unit('_', p1.getNom());
					Tests.Unit('A', p2.getNom());
	            }
	
				Tests.Case("Accesseur de consultation de l'abscisse"); {
	               	Tests.Unit(0.0,  p1.getAbscisse());
					Tests.Unit(2.0,  p2.getAbscisse());
	            }
	
				Tests.Case("Accesseur de consultation de l'ordonnee"); {
		          	Tests.Unit(0.0,  p1.getOrdonnee());
					Tests.Unit(3.0,  p2.getOrdonnee());
	            }
    			Tests.Case("Accesseur de la couleur"); {
    				Tests.Unit("java.awt.Color[r=0,g=0,b=0]",  p1.getCouleur());
    				Tests.Unit("java.awt.Color[r=255,g=0,b=0]",  p2.getCouleur());
           		}
           		
         	}
         
      Tests.End();
    } 
}