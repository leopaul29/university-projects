//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package _Maths
//
// Classe Analyseur - Tests unitaires de la cr�ation d'un objet
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

            Tests.Case("Construction g�n�rique d'un objet (constructeur par d�faut)");
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
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouv�e !");}
		      	catch(InstantiationException e) { System.out.println("La classe est abstract ou est une interface !");}
		      	catch(IllegalAccessException e) { System.out.println("La classe n'est pas accessible !");}
          	}
          	
          	/*Tests.Case("Construction g�n�rique d'un objet (constructeur normal)");
            {
            	Analyseur a = null;
				try{
					
					a = new Analyseur ("maths.geometrie.Point", "Point", char.class, double.class, double.class);
					Object o = a.creerInstance('A', 1, 2);
					if(o instanceof Point)
					{      
		                Point p1 = (Point)o;
		                Tests.Unit("A(1.0, 2.0)", p1.toString());
		            
						
						a = new Analyseur ("maths.geometrie.Point", "Point");
					 	Object o = a creerInstance(double, double);
						Point p1 = (Point)o.toString(c) + toString(c);
						char<2> noval[] = ();
						Analyse b = new.Analyse{" "," "," "," ...");
						Tests.Unit("_(1.0, 0.0)", p1.toString());
					}
				}
		      	catch(ClassNotFoundException e) { System.out.println("Classe non trouv�e !");}
		      	catch(InstantiationException e) { System.out.println("La classe est abstract ou est une interface !");}
		      	catch(IllegalAccessException e) { System.out.println("La classe n'est pas accessible !");}
            }*/
         }
     Tests.End();
   }
}

