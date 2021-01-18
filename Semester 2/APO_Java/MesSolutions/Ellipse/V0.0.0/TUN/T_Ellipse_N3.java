//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Ellipse - Tests unitaires des methode translation et redimension (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Ellipse_N3{
	
	public static void main(String[] arg) throws Exception {
		
		Tests.Begin("_Maths.Ellipse","0.0.0");
		
			Tests.Design("Methode 1",3);{
			
				Tests.Case("translation");{
					Ellipse e1 = new Ellipse(2.0,2.0,5.0,2.0);
					Ellipse e2 = new Ellipse(3.0,1.0,6.0,4.0);
					e1.translation(3.0,2.0);
					Tests.Unit("[_(5.0, 4.0), 5.0, 2.0]",e1.toString());
					e2.translation(4.0,-3.0);
					Tests.Unit("[_(7.0, -2.0), 6.0, 4.0]",e2.toString());
				}
				
				Tests.Case("redimension");{
					Ellipse e1 = new Ellipse(2.0,2.0,5.0,2.0);
					Ellipse e2 = new Ellipse(3.0,1.0,6.0,4.0);
					e1.redimension(2.0,3.0);
					Tests.Unit("[_(2.0, 2.0), 10.0, 6.0]",e1.toString());
					e2.redimension(-2.0,-2.0);
					Tests.Unit("[_(3.0, 1.0), 3.0, 2.0]",e2.toString());
				}
			}
			
		Tests.End();
	}
}