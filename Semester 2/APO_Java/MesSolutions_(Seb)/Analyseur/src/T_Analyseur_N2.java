//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package _Maths
//
// Classe Analyseur - Tests unitaires du premier constructeur
//
// Auteur : Papa Ninja
//


public class T_Analyseur_N2
{
   public static void main (String[] args) throws Exception
   {

      Tests.Begin("_Services d'analyse.Analyseur", "0.0.0");

         Tests.Design("Controle de la construction", 3);
         {

            Tests.Case("Analyse de la classe Point");
            {
		   		Analyseur a = null;
		   		Analyseur b = null;
		   		try
		   		{
		   			a = new Analyseur("Point", "translation", double.class, double.class);
		   			b = new Analyseur("Point", "toString");
		   			
		   			a.afficheMethode();
		   			b.afficheMethode();
		   			
		      	}
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouvée !");}
          }
        
         }
     Tests.End();
   }
}
