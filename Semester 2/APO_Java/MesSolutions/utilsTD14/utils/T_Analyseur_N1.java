//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package _Maths
//
// Classe Analyseur - Tests unitaires du premier constructeur
//
// Auteur : L. Brenac
//

import utils.Analyseur;

public class T_Analyseur_N1
{
   public static void main (String[] args) throws Exception
   {

      Tests.Begin("_Services d'analyse.Analyseur", "0.0.0");

         Tests.Design("Controle de la construction", 3);
         {

            Tests.Case("Analyse de la classe java.util.Date");
            {
		   		Analyseur a = null;
		   		try
		   		{
		   			a = new Analyseur ("java.util.Date");
		   			a.afficheClasse();
		      	}
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouvée !");}
          }
            Tests.Case("Analyse de la classe Point");
            {
		   		Analyseur a = null;
		   		try
		   		{
		   			a = new Analyseur ("maths.geometrie.Point");
		   			a.afficheClasse();
		      	}
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouvée !");}
          }
            Tests.Case("Analyse de la classe PointColore");
            {
		   		Analyseur a = null;
		   		try
		   		{
		   			a = new Analyseur ("maths.geometrie.PointColore");
		   			a.afficheClasse();
		   			a.afficheMethodes();
		      	}
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouvée !");}
          }
         }
     Tests.End();
   }
}
