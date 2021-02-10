//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Fraction - Tests unitaires de la methode racine carré (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Fraction_N7 {

   public static void main (String[] args) throws Exception {
			
      Tests.Begin("_Maths.Fraction", "1.0.0");

         Tests.Design("Controle de la methode sqrt", 3); {

            Tests.Case("Avec numerateur > 0"); {
            Fraction f1= new Fraction(225,36);
            Fraction f2= new Fraction(121);
            Fraction f3= new Fraction(9,16);
            Fraction f4= new Fraction(64.0);
            
            Fraction resuF1 = null, resuF2 = null;
            Fraction resuF3 = null, resuF4 = null;
            
            try{
            	resuF1 = f1.sqrt();
            	resuF2 = f2.sqrt();
            	resuF3 = f3.sqrt();
            	resuF4 = f4.sqrt();
			}catch ( Exception e){}
            

               Tests.Unit("5/2",resuF1.toString());
               Tests.Unit("11", resuF2.toString());
               Tests.Unit("3/4",resuF3.toString());
               Tests.Unit("8",  resuF4.toString());
              
			}
			
			Tests.Case("Avec numerateur = 0"); {
			Fraction f1= new Fraction(0);
			
			Fraction resuF1 = null;
			
			try{
            	resuF1 = f1.sqrt();
			}catch ( Exception e){}
			
				Tests.Unit("0", resuF1.toString());
			}
		}
		
	   Tests.End();
	}
}