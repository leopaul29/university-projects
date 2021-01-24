//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package _Maths
//
// Classe Analyseur - Tests unitaires de la création d'un objet
//
// Auteur : L. Brenac
//

import utils.Analyseur;
import maths.geometrie.Point;

public class T_Analyseur_N3
{
   public static void main (String[] args) throws Exception
   {

      Tests.Begin("_Services d'analyse.Analyseur", "0.0.0");

         Tests.Design("Controle de la construction d'un objet", 3);
         {

            Tests.Case("Construction générique d'un objet (constructeur par défaut)");
            {
		   		Analyseur a = null;
				try{

		            a = new Analyseur ("maths.geometrie.Point");
		            Object o = a.creerInstance();
		            if (o instanceof Point)
		            {
		                Point p1 = (Point)o;
		                Tests.Unit("_(0.0, 0.0)", p1.toString());
		            }
		        }
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouvée !");}
		      	catch(InstantiationException e) { System.out.println("La classe est abstract ou est une interface !");}
		      	catch(IllegalAccessException e) { System.out.println("La classe n'est pas accessible !");}
          }

         }
     Tests.End();
   }
}

