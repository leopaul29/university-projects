//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Vecteur - Tests unitaires des accesseurs
//
// Auteur : N.Sebastien
//

package Math.Vecteur.V010.TUN;
import Math.Teste.*;
import Math.Vecteur.V010.*;

public class T_Vecteur_N2 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Vecteur", "0.0.0");

         Tests.Design("Controle des accesseurs de consultation", 3); {

            Tests.Case("Consultation Abscisse"); {
            Vecteur v1= new Vecteur(1,2);
            Tests.Unit(1.0,  v1.getAbscisse());	
            }      
            	
            Tests.Case("Consultation Ordonnee"); {
            Vecteur v1= new Vecteur(1,2);
            Tests.Unit(2.0,  v1.getOrdonnee());	
            }      
            	
            Tests.Case("Consultation Norme"); {
            Vecteur v1= new Vecteur(1,2); 
            Tests.Unit(2.23606797749979,  v1.getNorme());	
            }
         }
      Tests.End();
   }
}
