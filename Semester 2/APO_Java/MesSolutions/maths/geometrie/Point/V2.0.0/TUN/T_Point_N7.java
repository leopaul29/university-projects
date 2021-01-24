//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Point- Tests unitaires des methodes save et load (cas nominaux)
//
// Auteur : MARTIN Léo-Paul
//
import maths.geometrie.Point;

public class T_Point_N7 {

    public static void main(String []args) throws Exception {
    	
    	Tests.Begin("Point", "2.0.0");
   
      		Tests.Design("Methode Save et Load", 3);
      			
      			Point p1= new Point(); 		Point p2= new Point(2,2);
      			
      			try {
      				Point.save("savep1",p1);
					Point.save("savep2",p2.translate(5,5));
				} catch(Exception e) {}
				
				Point p3= null;				Point p4= null;
		
				try {
					p3=Point.load("savep1");
					p4=Point.load("savep2");
				} catch(Exception e) {}
      			
      			Tests.Case("Methode Save et Load"); {
      				Tests.Unit("_(0.0, 0.0)", p3.toString());
      				Tests.Unit("_(7.0, 7.0)", p4.toString());
      			}
      Tests.End();
      	
    }
}