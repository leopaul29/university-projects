//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package _Maths
//
// Classe Analyseur - Tests unitaires de la création d'un objet
//
// Auteur : Dark Vador
//



//import petitpois.bonheur.*
public class T_Analyseur_N4
{
   public static void main (String[] args) throws Exception
   {

      Tests.Begin("_Services d'analyse.Analyseur", "0.0.0");

         Tests.Design("Controle de la construction d'un objet", 3);
         {

            Tests.Case("Méthode générique");
            {
		   		Analyseur a = null;
		   		Analyseur b = null;
				try{
					
					Point p = new Point('A',10,10);
					
					
		            a = new Analyseur ("Point","translation", double.class, double.class);
		            b = new Analyseur ("Point","toString");

		                Tests.Unit("A (10.0, 10.0)", b.executeMethode(p));
		                
		                a.executeMethode(p, 5,5);
		                
		                Tests.Unit("A (15.0, 15.0)", b.executeMethode(p));

		        }
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouvée !");}
		      	catch(IllegalAccessException e) { System.out.println("La classe n'est pas accessible !");}
          }

         }
     Tests.End();
   }
}

