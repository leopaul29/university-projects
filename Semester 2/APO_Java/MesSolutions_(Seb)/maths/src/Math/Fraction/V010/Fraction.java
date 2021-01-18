

//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Fraction - Modelisation de l'ensemble ZxZ*
//
// Auteur : Nicoletti Sebastien
//
//    + Version 0.0.0	: TD1
//    + Version 0.1.0	: TP1

package Math.Fraction.V010;
import Math.Arithm.*;


public class Fraction {
private int m_numerateur;
private int m_denominateur;

   // ---                                               Constructeur par defaut

   public Fraction() {

      // Fixer les deux attributs de la fraction
      //
      
      this.m_numerateur = 0;
      this.m_denominateur = 1;

   }

   // ---                                           Premier constructeur normal

   public Fraction(final int num, final int den) throws Exception {

      // Controler la validite du denominateur
      //
      if (den==0) throw new Exception ();

      // Fixer les deux attributs de la fraction
      //
		this.m_numerateur =  num;
		this.m_denominateur = den;

      // Reduire la fraction resultante
      //
      	this.reduire();
    	
	 
  }

   // ---                                            Second constructeur normal

   public Fraction(final int num) {

      // Fixer les deux attributs de la fraction
      //
      
      this.m_numerateur = num;
      this.m_denominateur = 1;

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
     	{
     		this.m_numerateur *= -1;
     	}
 

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
   																
   	//																Methode add
   	
   	public Fraction add (final Fraction op2)
   	{
   		Fraction maFraction = new Fraction();
   		
   		maFraction.m_numerateur =  (op2.m_numerateur * this.m_denominateur) + ( op2.m_denominateur * this.m_numerateur);
   		maFraction.m_denominateur =  op2.m_denominateur  * this.m_denominateur;
   		
   		maFraction.reduire();
   		
   		return maFraction;
     }	
     	
     public Fraction add (int nb)
     {
     	Fraction maFraction = new Fraction(nb);
     	
     	return this.add(maFraction);
     	
     }
   	
   	//																Methode Sub
   	
   	public Fraction sub (final Fraction op2)
   	{
   		Fraction maFraction = null;
   		
   		try
   		{
   			maFraction = new Fraction(op2.m_numerateur, op2.m_denominateur);
   		}
   		catch(Exception e){}
   		
   		maFraction.m_numerateur *= -1;
   		
   		return maFraction.add( this );
   		
   	}
   	
   	
   	public Fraction sub (final int nb)
     {
     	Fraction maFraction = new Fraction(nb);
     	
     	return this.sub(maFraction);
     	
     }
   	
   	
   	public  Fraction sub ()  // elle permet de renvoyer une fraction de signe opposé 
   	{
   		Fraction maFraction = null;
   		
   		try
   		{
   			maFraction = new Fraction( -1*this.m_numerateur, this.m_denominateur);
   		}
   		catch (Exception e)
   		{}
   		
   		
   		return maFraction;
   		
   	}
   	
   	
   	// ---                                                         Methode inverse
   	
   	
   	public Fraction inverse  ()throws Exception
   	{	
   		Fraction maFraction = null;
   		
   		if (m_numerateur == 0 )
   			throw new Exception ();
   			
   		
   		try
   		{
     		maFraction =  new Fraction (this.m_denominateur,  this.m_numerateur);
   		}
   		catch (Exception e) {
			e.printStackTrace();
		}
   		
   		return maFraction;
   		
   	}
   	
   	// --- 															Methode oppose
   	public void oppose ()
   	{
   		this.m_numerateur *= -1;
   		
   	}
   	
   	
   	// --- 															Methode mul
   	
   	
   	public Fraction mul (Fraction op2)
   	{
   		Fraction maFraction = new Fraction();
   		
   		maFraction.m_numerateur = this.m_numerateur * op2.m_numerateur;
   		maFraction.m_denominateur = this.m_denominateur * op2.m_denominateur;
   		
   		maFraction.reduire();
   		
   		
   		return maFraction;
   	}
   	
   	public Fraction mul (int nb)
   	{
   		Fraction maFraction = new Fraction(nb);
   		
   	
   		return this.mul(maFraction);
   	}
   	
   //---															Methode div
   	
   	public Fraction div (Fraction op2) 
   	{
   		Fraction maFraction = null;
		
		try
		{
			maFraction = op2.inverse();
		}
		catch (Exception e)
		{}
   		
   		return maFraction.mul(this);
   	}
   	
   	public Fraction div (int nb)
   	{
   		Fraction maFraction = new Fraction(nb);
   		
   		return this.div(maFraction);
   	}
   	
   

   // ---                                                          Methode main

   public static void main (String[] args) {

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
      
      
      // Additionner les deux premieres fractions
      //
      Fraction r1= f1.add(f2);

      System.out.println("R1= " + r1.toString());

      // Additionner les deux suivantes
      //
      Fraction r2= f3.add(f4);

      System.out.println("R2= " + r2.toString());
      System.out.println();
      
       // Soustraire les deux premieres fractions
      //
      Fraction r3= f1.sub(f2);

      System.out.println("R3= " + r3.toString());

      // Soustraire les deux suivantes
      //
      Fraction r4= f3.sub(f4);

      System.out.println("R4= " + r4.toString());
      
      System.out.println("-R4= " + r4.sub().toString());
      System.out.println("-R2= " + r2.sub().toString());
      System.out.println();
      
      // Calculer l'inverse de la fraction f4
      //
      
      Fraction r5 = null;
      try
      {
      	r5 = f4.inverse();
      }
      catch ( Exception e)
      {
      	System.out.println("Erreure: Le numerateur est null... ");
      }
      
      System.out.println("F4 :"+ f4.toString());
      System.out.println("R5 :"+ r5.toString());
      
      Fraction f6 = new Fraction ();
      
      try
      {
      	f6 = f6.inverse();
      }
      catch (Exception e)
      {
      	System.out.println("Erreure: Le numerateur de f6 est null... ");
      }
      
      

      // Changer le signe d'une fraction
      //
      f4.oppose();
      r2.oppose();

      System.out.println("R6= " + f4.toString());
      System.out.println("R7= " + r2.toString());
      System.out.println();
      
      
      // Multiplier 2 Fractions 
      
      Fraction R8 = f1.mul(f2);
      Fraction R9 = f2.mul(4);
      
      System.out.println("R8= " + R8.toString());
      System.out.println("R9= " + R9.toString());
      System.out.println();
      
      // Diviser 2 Fractions 
      
      Fraction R10 = f1.div(f2);
      Fraction R11 = f2.div(-2);
      
      System.out.println("R10= " + R10.toString());
      System.out.println("R11= " + R11.toString());
      System.out.println();

   }
}