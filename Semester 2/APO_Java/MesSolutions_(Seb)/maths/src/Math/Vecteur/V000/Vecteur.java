
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Vecteur - Modelisation de l'espace vectoriel RxR
//
//
//    + Version 0.0.0	: Cours_3
//
//
//
// Auteur : S.Nicoletti
//
package Math.Vecteur.V000;


public class Vecteur {
private double m_x;
private double m_y;
@SuppressWarnings("unused")
private final double EPSILON= 1./10000;

// ---                                             Constructeur par defaut
	public Vecteur() {

      // Fixer les deux attributs de la fraction (element neutre)
      //
      m_x= 0;
      m_y= 0;
   }

// ---                                                 Constructeur normal
	public Vecteur(double x, double y) {

      // Fixer les deux attributs du vecteur
      //
      m_x= x;
      m_y= y;
   }

// ---                                                    Methode toString
	public String toString() {return "(" + m_x + ", " + m_y + ")";}
   
//  														ACCESSEURS :
//														getAbscisse

	public double getAbscisse ()
	{
		return this.m_x;  
	}
//														getOrdonnee

	public double getOrdonnee ()
	{
		return this.m_y;  
	}


//														getNorme

	public double getNorme ()
	{
		return Math.sqrt( Math.pow(this.getAbscisse(),2) + Math.pow(this.getOrdonnee(),2) );  
	}
   
   

// ---                                                         Methode add
	public Vecteur add (Vecteur op2) {

      return new Vecteur (m_x + op2.m_x, m_y + op2.m_y);
   }

// ---                                                         Methode sub
	public Vecteur sub (Vecteur op2) {

      return new Vecteur (m_x - op2.m_x, m_y - op2.m_y);
   }
   public Vecteur sub () {

      return new Vecteur (-m_x, -m_y);
   }

// ---                                                         Methode mul
	public Vecteur mul (double op2) {

      return new Vecteur (m_x*op2, m_y*op2);
   }
   
//																Methode Orthogonol

	public boolean orthogonal (Vecteur op2) {
		return ((this.m_x*op2.m_x + this.m_y*op2.m_y)==0);
	}
	
//																Methode Colibeaire

	public boolean colineaire (Vecteur op2) {
		return (this.m_x*op2.m_y == this.m_y*op2.m_x);
		
	}
	
 //																Methode produitScalaire
	public  double produitScalaire (Vecteur op2)
	{
		return this.getAbscisse()*op2.getAbscisse() + this.getOrdonnee()*op2.getOrdonnee();
	}
	
	
	public  boolean memeSens (Vecteur op2)
	{
		return (this.colineaire(op2) && (this.getAbscisse() / op2.getAbscisse()) > 0 );	
	}
	
}