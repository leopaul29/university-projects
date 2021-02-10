//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - Package _Maths
//
// Classe Vecteur - Tests unitaires des constructeurs (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//

public class T_Vecteur_N1 {

   public static void main (String[] args) {

      Tests.Begin("_Maths.Vecteur", "0.0.0");

         Tests.Design("Controle des constructeurs", 3); {

            Tests.Case("Constructeur par defaut"); {
            Vecteur v0= new Vecteur();

               Tests.Unit("(0.0, 0.0)",  v0.toString());
            }

            Tests.Case("Constructeur normal"); {
            Vecteur v1= new Vecteur (1, 2);
            Vecteur v2= new Vecteur (1.5, -2);
            Vecteur v3= new Vecteur (-1, 2.25);
            Vecteur v4= new Vecteur (-1, -2);
            Vecteur v5= new Vecteur (-7.25, 8.45);

               Tests.Unit("(1.0, 2.0)",    v1.toString());
               Tests.Unit("(1.5, -2.0)",   v2.toString());
               Tests.Unit("(-1.0, 2.25)",  v3.toString());
               Tests.Unit("(-1.0, -2.0)",  v4.toString());
               Tests.Unit("(-7.25, 8.45)", v5.toString());
            }
         }

      Tests.End();
   }
}
