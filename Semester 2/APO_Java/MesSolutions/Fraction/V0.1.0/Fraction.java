//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Fraction - Modelisation de l'ensemble ZxZ*
//
// Edition "Draft" : le point d'entree simule les tests unitaires
//
// + Version 0.0.0 : TD1 constructeur + methode add, sub
// + Version 0.1.0 : TP1 methode inverse, oppose, mul et div
//
// Auteur : MARTIN Léo-Paul
//

public class Fraction {
	
private int m_numerateur;
private int m_denominateur;

   // ---                                               Constructeur par defaut

   	public Fraction() {

      // Fixer les deux attributs de la fraction
      //
		m_numerateur= 0 ;
		m_denominateur= 1 ;
   }

   // ---                                           Premier constructeur normal

   	public Fraction(int num, int den) throws Exception {

      // Controler la validite du denominateur
      //
      if (den==0) throw new Exception ();

      // Fixer les deux attributs de la fraction
      //
		m_numerateur= num ;
		m_denominateur= den ;

      // Reduire la fraction resultante
      //
      reduire();
   }

   // ---                                            Second constructeur normal

   	public Fraction(int num) {

      // Fixer les deux attributs de la fraction
      //
      	m_numerateur= num ;
		m_denominateur= 1 ;
   }

   // ---                                                       Methode reduire

   private void reduire() {
   
   int signe, pgcd;

      // Traiter le cas particulier d'une fraction nulle
      //	
		if (m_numerateur == 0)
			return ;
		
      // Determiner le signe du resultat
      //
      if (m_numerateur>0)
         if (m_denominateur>0) signe= 1;
         else signe= -1;
      else if (m_denominateur>0) signe= -1;
         else signe= 1;

      // Calculer le PGCD des deux membres
      //
      pgcd = Arithm.pgcd( Math.abs(this.m_numerateur), Math.abs(this.m_denominateur));
			 
      // Diviser chaque membre par le PGCD
      //
      this.m_numerateur = Math.abs(this.m_numerateur) / pgcd;
      this.m_denominateur = Math.abs(this.m_denominateur) /pgcd;
     	
      if ( signe == -1)
     	this.m_numerateur *= -1;
   }

   // ---                                                      Methode toString

   	public String toString() {

      // Traiter le cas particulier d'une fraction nulle
      //
      if (m_numerateur==0) return "0";

      // Traiter le cas particulier d'un entier
      //
      if (m_denominateur==1) return "" + m_numerateur;

      // Traiter le cas general
      //
      return m_numerateur + "/" + m_denominateur;
   }
   
   // ---                                                      Methode Add
   
	public Fraction add (final Fraction op2)	{
		
		Fraction resultat= null;
		int num, den;
		num = this.m_numerateur*op2.m_denominateur+this.m_denominateur*op2.m_numerateur;
		den = this.m_denominateur*op2.m_denominateur;
		try { resultat= new Fraction(num, den);}
		catch(Exception e){}
		
		// Restituer le resultat
		//
		return resultat;
	}
	
	public Fraction add (int op2)	{
		
		Fraction x = new Fraction (op2);
		Fraction resu = this.add(x);
		return resu;
	}
	
   // ---                                                      Methode Sub
	
	public Fraction sub (int op2)	{
		
		Fraction x = new Fraction (op2);
		Fraction resu = this.sub(x);
		return resu;
	}
	
	public Fraction sub (Fraction op2)	{
	
		Fraction resultat= null;
		int num, den;
		num = this.m_numerateur*op2.m_denominateur-this.m_denominateur*op2.m_numerateur;
		den = this.m_denominateur*op2.m_denominateur;
		try { resultat= new Fraction(num, den);}
		catch(Exception e){}
		
		// Restituer le resultat
		//
		return resultat;
	}
	
	public Fraction sub ()	{
		
		Fraction resultat= null;
		int num, den;
		num = (-1*this.m_numerateur);
		den = 1*this.m_denominateur;
		try { resultat= new Fraction(num, den);}
		catch(Exception e){}
		
		// Restituer le resultat
		//
		return resultat;
	}
	
   // ---                                                      Methode Inverse
	
	public Fraction inverse  ()throws Exception {
   	 
   		// verifier la validité du numerateur
   		if (m_numerateur == 0) throw new Exception ();
   		
   		// construire le resultat
   		Fraction resultat = null;
   		
   		try { resultat = new Fraction(this.m_denominateur, this.m_numerateur);}
   		catch(Exception e){}
   		
   		// Restituer le resultat
   		//
   		return resultat; 
   	}   	
   	
   // ---                                                      Methode Oppose
   	
   	private void oppose () {
   		
   		m_numerateur *= -1;
   	}
   	
   // ---                                                      Methode Mul
   	
   	public Fraction mul (Fraction op2) {
   		
   		Fraction maFraction = new Fraction();
   		
   		maFraction.m_numerateur = this.m_numerateur * op2.m_numerateur;
   		maFraction.m_denominateur = this.m_denominateur * op2.m_denominateur;
   		
   		maFraction.reduire();
   		
   		return maFraction;
   	}
   	
   	public Fraction mul (int nb) {
   		Fraction maFraction = new Fraction(nb);
   		
   		return this.mul(maFraction);
   	}
   	
   // ---                                                      Methode Div
   	
   	public Fraction div (Fraction op2) {
   	
	   	Fraction resultat = null;
	   	
		try { resultat = new Fraction(this.m_numerateur, this.m_denominateur);
		   		}catch (Exception e) {}
		   		
		resultat.m_numerateur = this.m_numerateur * op2.m_denominateur;
		resultat.m_denominateur = this.m_denominateur* op2.m_numerateur;
		
		resultat.reduire();
		
		// Restituer le resultat
   		//
		return resultat;
   	}
   	
   	public Fraction div (int nb) {
   		Fraction maFraction = new Fraction(nb);
   	
   		return this.div(maFraction);
   	}
   	
   	// ---                                                          Methode main

   public static void main (String[] args) {

	  // --- // --- Creation de Fraction
	  System.out.println("Creation de fraction");
	  
      // Creer une fraction irreductible positive
      //
      Fraction f1= null;
      try {f1= new Fraction(1, 2);}
      catch(Exception e){}

      System.out.println("f1= " + f1.toString());

      // Creer une fraction reductible, avec denominateur negatif
      //
      Fraction f2= null;
      try {f2= new Fraction(2, -4);}
      catch(Exception e){}

      System.out.println("f2= " + f2.toString());

      // Creer une fraction reductible positive
      //
      Fraction f3= null;
      try {f3= new Fraction(16, 24);}
      catch(Exception e){}

      System.out.println("f3= " + f3.toString());

      // Creer une fraction irreductible negative
      //
      Fraction f4= null;
      try {f4= new Fraction(-25, 19);}
      catch(Exception e){}

      System.out.println("f4= " + f4.toString());
      System.out.println();
      
      
      // --- // --- Addition de Fraction
	  System.out.println("Addition de fraction");

      // Additionner les deux premieres fractions
      //
      Fraction r1= f1.add(f2);

      System.out.println("R1= " + r1.toString());

      // Additionner les deux suivantes
      //
      Fraction r2= f3.add(f4);

      System.out.println("R2= " + r2.toString());
      System.out.println();
      
      
      // --- // --- Soustraction de Fraction
	  System.out.println("Soustraction de fraction");

      // Soustraire les deux premieres fractions
      //
      Fraction r3= f1.sub(f2);

      System.out.println("R3= " + r3.toString());

      // Soustraire les deux suivantes
      //
      Fraction r4= f3.sub(f4);

      System.out.println("R4= " + r4.toString());
      System.out.println();
      
      
      // --- // --- Inverse de Fraction
	  System.out.println("Inverse de fraction");
      
      // Calculer l'inverse de la fraction f4
      //
      Fraction r5= null;

      try {r5= f4.inverse();}
      catch (Exception e){}

      System.out.println("R5= " + r5.toString());
      System.out.println();
      
      
      // --- // --- Oppose de Fraction
	  System.out.println("Oppose de fraction");

      // Changer le signe d'une fraction
      //
      f3.oppose();

      System.out.println("R6= " + f3.toString());
      System.out.println();
   }
}