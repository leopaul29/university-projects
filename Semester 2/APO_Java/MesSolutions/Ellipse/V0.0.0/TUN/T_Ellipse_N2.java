//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013
//
// Classe Ellipse - Tests unitaires des accesseurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Ellipse_N2{
	
	public static void main(String[] arg) throws Exception {
		
		Ellipse e1 = new Ellipse(2.0,1.0,4.0,2.0);
		Ellipse e2 = new Ellipse(4.0,2.0,8.0,4.0);
		Ellipse e3 = new Ellipse(2.0,2.0,4.0,4.0);
		Ellipse e4 = new Ellipse();
		
		Tests.Begin("_Maths.Ellipse","0.0.0");
		
			Tests.Design("Tests des accesseurs",3);{
			
				Tests.Case("getPoint");{
					Tests.Unit("_(2.0, 1.0)",e1.getPoint().toString());
					Tests.Unit("_(4.0, 2.0)",e2.getPoint().toString());
					Tests.Unit("_(2.0, 2.0)",e3.getPoint().toString());
				}
				Tests.Case("getFocal");{
					Tests.Unit(4.0,e1.getFocal());
					Tests.Unit(8.0,e2.getFocal());
					Tests.Unit(4.0,e3.getFocal());
				}
				
				Tests.Case("getSecondaire");{
					Tests.Unit(2.0,e1.getSecondaire());
					Tests.Unit(4.0,e2.getSecondaire());
					Tests.Unit(4.0,e3.getSecondaire());
				}
				
				Tests.Case("getAire");{
					Tests.Unit(6.28318,e1.getAire());
					Tests.Unit(25.13272,e2.getAire());
					Tests.Unit(12.56636,e3.getAire());
				}
				
				Tests.Case("estVide");{
					Tests.Unit(false,e1.estVide());
					Tests.Unit(false,e2.estVide());
					Tests.Unit(false,e3.estVide());
					Tests.Unit(true,e4.estVide());
				}
			}
			
		Tests.End();
	}
}