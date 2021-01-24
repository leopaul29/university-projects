//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2D
//
// Classe Vecteur - Modelisation de l'espace vectoriel RxR
//
// + Version 0.0.0 : TD3 constructeur + methode add, sub, mul, memeSense, colineaire, prodScalaire, orthogonal, Accesseurs
// + Version 0.1.0 : TD4 methode clone et equals
// + Version 2.0.0 : TD8 methode clone en public
//
// Auteur : MARTIN Léo-Paul
//
package maths;

public class Vecteur {
	
private double m_x;
private double m_y;
private static final double EPSILON= 1./10000;
private static int m_compteur;

   // ---                                               Constructeur par defaut

   public Vecteur() {

      // Fixer les deux attributs de la fraction (element neutre)
      //
      m_x= 0;
      m_y= 0;
      m_compteur ++;
   }

   // ---                                                   Constructeur normal

   public Vecteur(double x, double y) {

      // Fixer les deux attributs du vecteur
      //
      m_x= x;
      m_y= y;
      m_compteur ++;
   }

   // ---                                                      Methode toString

   public String toString() {return "(" + m_x + ", " + m_y + ")";}

   // ---                                                           Methode add

   public Vecteur add (Vecteur op2) {

      return new Vecteur (m_x + op2.m_x, m_y + op2.m_y);
   }

   // ---                                                           Methode sub

   public Vecteur sub (Vecteur op2) {

      return new Vecteur (m_x - op2.m_x, m_y - op2.m_y);
   }

   public Vecteur sub () {

      return new Vecteur (-m_x, -m_y);
   }

   // ---                                                           Methode mul

   public Vecteur mul (double op2) {

      return new Vecteur (m_x*op2, m_y*op2);
   }

   // ---                                            Accesseurs de consultation

   public double getAbscisse() {return m_x;}
   public double getOrdonnee() {return m_y;}
   public double getNorme() {return Math.sqrt(m_x*m_x + m_y*m_y) ;}
   public static int getCompteur() { return m_compteur;}
   
   // ---                                               Methode produitScalaire

   public double produitScalaire (Vecteur op2) {
   	
      return m_x*op2.m_x + m_y*op2.m_y;
   }

   // ---                                               Methode colineaire

   public boolean colineaire (Vecteur op2) {
   	
      return Math.abs(m_x*op2.m_y - op2.m_x*m_y) <= EPSILON;
   }

   // ---                                               Methode orthogonal

   public boolean orthogonal (Vecteur op2) {
   	
      return Math.abs(m_x*op2.m_x + m_y*op2.m_y) <= EPSILON;
   }

   // ---                                               Methode memeSens

   public boolean memeSens (Vecteur op2) {

      // Controler la direction
      //
      if (!colineaire(op2)) return false;

      // Controler le sens
      //
      return (m_x*op2.m_x >= 0) && (m_y*op2.m_y >= 0);
   }
   
   	//    --- 												Methode equals

	public boolean equals(Object op2) {
		
		Vecteur v = (Vecteur)op2;
		return ((m_x == v.m_x) && (m_y == v.m_y));
	}

 	//   --- 												Methode Clone

	public Object clone() {return new Vecteur (m_x,m_y);}

}