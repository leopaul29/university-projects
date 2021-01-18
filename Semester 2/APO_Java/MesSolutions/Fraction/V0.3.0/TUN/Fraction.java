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
// + Version 0.2.0 : TD2 ajout des accesseurs
// + Version 0.3.0 : TD2 nouveau constructeur double
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
   
   // ---                                            Constructeur à partir d'un double
      
   public Fraction (double op2) throws Exception {
   	
 		int signe=1;
 		String s1;
 		if (op2<0) {
 			signe=-1;
 			op2=Math.abs(op2);
 		}
	  	String s = String.valueOf(op2);
	  	String[] tab = s.split("\\.");
	
	 	int n1 = tab[1].length();
	 	s1 = tab[1];
	  	if(n1>5) {n1=5;s1=tab[1].substring(0,5);}
	  	int x = Integer.parseInt(tab[0]);
	  	int y = Integer.parseInt(s1);
	 	//System.out.println(x + " " + y);
	 	
	 	double lx = x*Math.pow(10.0,n1)+y;
	 	double ly = Math.pow(10,n1);
	 	//System.out.println(lx + " " + ly);
	  	if ((Math.abs(lx)>Integer.MAX_VALUE)||(Math.abs(ly)>Integer.MAX_VALUE)) throw new Exception();
	  	m_numerateur = (int)lx;
	 	m_denominateur = (int)ly;
	 	
	 	//System.out.println(m_numerateur + " " + m_denominateur);
	  	reduire();
	  	if (signe==-1) m_numerateur=-m_numerateur;
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
   	
   	public void oppose () {
   		
   		m_numerateur *= -1;
   	}
   	
   // ---                                                      Methode Mul
   	
   	public Fraction mul (Fraction op2) 	{
   		
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
   	
   	public Fraction div (Fraction op2) 	{
   	
	   	Fraction resultat = null;
	   	
		try { 
			resultat = new Fraction(this.m_numerateur, this.m_denominateur);
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
   	
   	// ---                                                      Ajout des accesseurs
   	
	public int getNumerateur() { return m_numerateur; }
	public int getDenominateur() { return m_denominateur;}
	public double getValeur() { return (double) m_numerateur / m_denominateur;}
}