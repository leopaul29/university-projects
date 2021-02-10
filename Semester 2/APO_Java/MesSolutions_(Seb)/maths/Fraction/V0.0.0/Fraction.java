//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Fraction - Modelisation de l'ensemble ZxZ*
//
// Auteur : Nicoletti Sebastien
//
package Fraction.V000;
import Arithm.*;

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

   public Fraction(int num, int den) throws Exception {

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

   public Fraction(int num) {

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

   	public Fraction add (Fraction op2)
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

   	public Fraction sub (Fraction op2)
   	{
   		Fraction maFraction = op2;
   		maFraction.m_numerateur *= -1;

   		return maFraction.add( this );

   	}


   	public Fraction sub (int nb)
     {
     	Fraction maFraction = new Fraction(nb);

     	return this.sub(maFraction);

     }


   	public  Fraction sub ()  // elle permet de renvoyer une fraction de signe opposé
   	{
   		Fraction maFraction = this;

   		maFraction.m_numerateur *= -1;
   		return maFraction;

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


   }
}
