//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package _Maths
//
// Classe Analyseur - Tests unitaires du second constructeur
//
// Auteur : L. Brenac
//

import utils.Analyseur;

public class T_Analyseur_N2
{
   public static void main (String[] args) throws Exception
   {

      Tests.Begin("_Services d'analyse.Analyseur", "0.0.0");

         Tests.Design("Controle de la construction", 3);
         {

            Tests.Case("Analyse d'une methode");
            {
            	Analyseur a = null, b = null;
		   		try
		   		{
		   			a = new Analyseur("maths.geometrie.Point", "toString");
		   			a.afficheMethode();
		   			
		   			b = new Analyseur("maths.geometrie.Point", "translation", double.class, double.class);
		   			b.afficheMethode();
		   		}
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouvée !");}       	
            }
         }
     Tests.End();
   }
}