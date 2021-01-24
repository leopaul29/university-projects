package maths;
import maths.*;//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point - Tests unitaires des methodes pour calculer la distance
//
// Auteur : S.Nicoletti
//


public class T_Point_N6 {

   public static void main (String[] args) throws Exception {

      Tests.Begin("_Maths.Point", "0.0.0");

         Tests.Design("Controle des methodes distance", 3); {

            Tests.Case("Tests generaux"); {
            Point p1= new Point(0,0);
            Point p2= new Point(0,1);
            Point p3= new Point(5,1);
            Point p4= new Point(-2,-1);
            Point p5= new Point(-2,-9);

            Tests.Unit(1.0,  p1.distance(p2));
            Tests.Unit(0.0,  p2.distance(p2));
            Tests.Unit(5.09901,  p1.distance(p3));
            Tests.Unit(8.0,  p4.distance(p5));
            Tests.Unit(1.0,  p2.distance(p1));
            Tests.Unit(10.19803903,  p2.distance(p5));
            }
         }
      Tests.End();
   }
}
