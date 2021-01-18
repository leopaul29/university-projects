//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Vecteur - Tests unitaires des accesseurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.Vecteur;

public class T_Vecteur_N2 {

   public static void main (String[] args) {

      Tests.Begin("_Maths.Vecteur", "2.0.0");

         Tests.Design("Controle des accesseurs", 3); {

            Tests.Case("Methode getAbscisse"); {
            Vecteur v1= new Vecteur (1, 2);
            Vecteur v2= new Vecteur (1.5, -2);

               Tests.Unit(1.0, v1.getAbscisse());
               Tests.Unit(1.5, v2.getAbscisse());
            }

            Tests.Case("Methode getOrdonnee"); {
            Vecteur v1= new Vecteur (1, 2);
            Vecteur v2= new Vecteur (1.5, -2);

               Tests.Unit(2.0,  v1.getOrdonnee());
               Tests.Unit(-2.0, v2.getOrdonnee());
            }

            Tests.Case("Methode getNorme"); {
            Vecteur v1= new Vecteur (1, 0);
            Vecteur v2= new Vecteur (0, -4);
            Vecteur v3= new Vecteur (3, -4);

               Tests.Unit(1.0, v1.getNorme());
               Tests.Unit(4.0, v2.getNorme());
               Tests.Unit(5.0, v3.getNorme());
            }
         }

      Tests.End();
   }
}
