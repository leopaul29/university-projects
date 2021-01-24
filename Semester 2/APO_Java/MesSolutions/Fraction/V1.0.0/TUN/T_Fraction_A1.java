//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Fraction - Tests unitaire d'anomalie (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Fraction_A1 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Fraction", "1.0.0");

         Tests.Design("tests unitaires d’anomalie", 3); {

            Tests.Case("Exception avec un denominateur nul"); {	
            	try {
            		Fraction f1= new Fraction(12,0);
            		System.out.println("f1 : "+ f1.toString());
            	} catch (Exception e){
            		System.out.println("Division par zéro !");
            	}              
			}
			
			Tests.Case("Exception avec la methode inverse et un numerateur nul"); {	
			try {
				Fraction f2= new Fraction(0,50);
				System.out.println("f2 : "+ f2.inverse());
			} catch (Exception e){
				System.out.println("Division par zéro !");
				}
			}
		
			Tests.Case("Exception avec la methode sqrt"); {	
			try {
				Fraction f3= new Fraction(-16);
				System.out.println("f3 : "+ f3.sqrt());
			} catch (Exception e){
				System.out.println("Racine carré d'un nombre negatif est impossible !");
				}
			}
		}
		
	   Tests.End();
	}
}