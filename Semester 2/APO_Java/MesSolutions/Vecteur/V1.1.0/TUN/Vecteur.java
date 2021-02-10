//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Vecteur - Modelisation de l'espace vectoriel RxR
//
// Edition A        : suppression de la methode main
//
// + Version 0.0.0 : TD3 constructeur + methode add, sub, mul, memeSense, colineaire, prodScalaire, orthogonal, Accesseurs
// + Version 1.0.0 : TD3 attributs de type Fraction
// + Version 0.1.0 : TD4 methode clone et equals

//
// Auteur : MARTIN Léo-Paul
//

public class Vecteur {
	
private Fraction m_x;
private Fraction m_y;
private final double EPSILON= 1./10000;
private static int m_compteur;

// ---                                             Constructeur par defaut

   public Vecteur() {

      // Fixer les deux attributs de la fraction (element neutre)
      //
      m_x= new Fraction();
      m_y= new Fraction();
      m_compteur ++;
   }

// ---                                                 Constructeur normal

   public Vecteur(Fraction x, Fraction y) {

      // Fixer les deux attributs du vecteur
      //
      m_x= x;
      m_y= y;
      m_compteur ++;
   }

// ---                                                    Methode toString

   public String toString() {return "(" + m_x.toString() + ", " + m_y.toString() + ")";}

// ---                                                         Methode add

   public Vecteur add (Vecteur op2) {
   	  Fraction f1 = m_x.add(op2.m_x);
   	  Fraction f2 = m_y.add(op2.m_y);

      return new Vecteur (f1, f2);
   }

// ---                                                         Methode sub

   public Vecteur sub (Vecteur op2) {

   	  Fraction f1 = m_x.sub(op2.m_x);
   	  Fraction f2 = m_y.sub(op2.m_y);

      return new Vecteur (f1, f2);
   }

   public Vecteur sub () {

      return new Vecteur (m_x.sub(), m_y.sub());
   }

// ---                                                         Methode mul

   public Vecteur mul (double op2) throws Exception{
   	
   		double r1 = m_x.getValeur()*op2;
   		double r2 = m_y.getValeur()*op2;
		Fraction f1 = new Fraction (r1);
		Fraction f2 = new Fraction (r2);

      	return new Vecteur (f1, f2);
   }

// ---                                             Methode produitScalaire

   public double produitScalaire (Vecteur op2) {
   	
   		Fraction f1 = m_x.mul(op2.m_x);
   		Fraction f2 = m_y.mul(op2.m_y);
   		Fraction f3 = f1.add(f2);
   		//double resultat = ((double)f3.getNumerateur())/f3.getDenominateur();
      	//return  resultat;
      	return f3.getValeur();
   }

// ---                                                  Methode colineaire

   public boolean colineaire (Vecteur op2) {
   	
   		Fraction f1 = m_x.mul(op2.m_y);
   		Fraction f2 = m_y.mul(op2.m_x);
   		Fraction f3 = f1.sub(f2);
   		double resultat = f3.getNumerateur()/f3.getDenominateur();
		return Math.abs(resultat) <= EPSILON;
   }

// ---                                                  Methode orthogonal

   public boolean orthogonal (Vecteur op2) {
   	
   		Fraction f1 = m_x.mul(op2.m_x);
   		Fraction f2 = m_y.mul(op2.m_y);
   		Fraction f3 = f1.add(f2);
   		double resultat = f3.getNumerateur()/f3.getDenominateur();
		return Math.abs(resultat) < EPSILON;
   }

// ---                                                    Methode memeSens

   public boolean memeSens (Vecteur op2) {

      // Controler la direction
      //
      if (!colineaire(op2)) return false;

      // Controler le sens
      //
   		Fraction f1 = m_x.mul(op2.m_x);
   		Fraction f2 = m_y.mul(op2.m_y);
   		double r1 = f1.getNumerateur()/f1.getDenominateur();
   		double r2 = f2.getNumerateur()/f2.getDenominateur();
   		return (r1 >= 0) && (r2 >= 0);
   }

// ---                                            Accesseurs de consultation

   public Fraction getAbscisse() {return m_x;}
   public Fraction getOrdonnee() {return m_y;}
   public static int getCompteur() { return m_compteur;}
   
   public double getNorme() {
   	
   		Fraction f1= m_x.mul(m_x);
 		Fraction f2= m_y.mul(m_y);
 		Fraction f3= f1.add(f2);
		double num= f3.getNumerateur();
 		double den= f3.getDenominateur();
        return Math.sqrt(num/den);
   }
   
 //    --- 												Methode equals

	public boolean equals(Object op2) {
		
		Vecteur v = (Vecteur)op2;
		return ((m_x == v.m_x) && (m_y == v.m_y));
	}

 //   --- 												Methode Clone

	protected Object clone() {return new Vecteur (m_x,m_y);}
}