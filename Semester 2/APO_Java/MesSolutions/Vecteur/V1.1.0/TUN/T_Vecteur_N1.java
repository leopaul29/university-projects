//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2010_2011 - Package _Maths
//
// Classe Vecteur - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Vecteur_N1 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Vecteur", "1.1.0");
      
         Tests.Design("Methode Clone et Equals",3); {	
			
			Tests.Case("Methode Clone"); {
			Fraction f1 = new Fraction(2);
            Fraction f2 = new Fraction(3);
            Vecteur v1= new Vecteur (f1, f2);
         	Vecteur v2= (Vecteur)v1.clone();

               	Tests.Unit(2, Vecteur.getCompteur());
				Tests.Unit(true, v1.equals(v1.clone()));
				Tests.Unit(true, v1.equals(v2));
			}
			
			Tests.Case("Methode equals"); {
			Fraction f1 = new Fraction(2);
            Fraction f2 = new Fraction(3);
            Vecteur v1= new Vecteur (f1, f2);
            	
            Fraction f3 = new Fraction(5);
            Fraction f4 = new Fraction(-7);
            Vecteur v2= new Vecteur (f3, f4);
	         	
	           	Tests.Unit(true, v1.equals(v1));
				Tests.Unit(true, v1.equals(v1.clone()));
				Tests.Unit(false, v1.equals(v2));
            }
		}

         Tests.Design("Controle des constructeurs", 3); {

            Tests.Case("Constructeur par defaut"); {
	        Vecteur v0= new Vecteur();
	            Tests.Unit("(0, 0)",  v0.toString());
            }
            
            Tests.Case("Constructeur normal"); {
            Fraction f1 = new Fraction(1);
            Fraction f2 = new Fraction(2);
            Vecteur v1= new Vecteur (f1, f2);

            Fraction f3 = new Fraction(3,2);
            Fraction f4 = new Fraction(-2);
            Vecteur v2= new Vecteur (f3, f4);

           	Fraction f5 = new Fraction(-1);
            Fraction f6 = new Fraction(9,4);

            Vecteur v3= new Vecteur (f5, f6);
            Vecteur v4= new Vecteur (f5, f4);

           	Fraction f7 = new Fraction(-29,4);
            Fraction f8 = new Fraction(8.45);
            Vecteur v5= new Vecteur (f7, f8);

               	Tests.Unit("(1, 2)",    v1.toString());
               	Tests.Unit("(3/2, -2)",   v2.toString());
               	Tests.Unit("(-1, 9/4)",  v3.toString());
               	Tests.Unit("(-1, -2)",  v4.toString());
               	Tests.Unit("(-29/4, 169/20)", v5.toString());
            }
         }
         
      Tests.End();
   }
}
