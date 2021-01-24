//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Ellipse - Tests unitaires des methode clone et equals (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.Point;
import maths.geometrie.Ellipse;

public class T_Ellipse_N5{
	
	public static void main(String[] arg) throws Exception {
		
		Tests.Begin("_Maths.Ellipse","0.0.0");
		
			Tests.Design("Methode 3",3);{
			
				Tests.Case("clone");{
					
				}
				
				Tests.Case("equals");{
						
				}
				
				Tests.Case("getPerimetre");{
					Ellipse e1 = new Ellipse(1,1,3,2);
					Ellipse e2 = new Ellipse(2,2,6,4);
					
					Tests.Unit(8.009514356853977, e1.getPerimetre());
					Tests.Unit(16.019028713707954, e2.getPerimetre());
					
				}
			}
			
		Tests.End();
	}
}