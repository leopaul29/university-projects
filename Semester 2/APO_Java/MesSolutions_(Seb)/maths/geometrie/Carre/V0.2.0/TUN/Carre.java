//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Carre -
//
//		V0.1.0 - Ajout de la méthode getAire
// 		V0.2.0 - Ajout des méthodes equals et clone 
// Auteur : S. Nicoletti
//
package maths;
public class Carre extends Rectangle {


	public Carre()
	{
		super();
	}

	public Carre ( double cote) throws Exception
	{
		super(cote,cote);
	}

	public Carre (double x, double y, double cote ) throws Exception
	{
		super(x,y,cote,cote);
	}

	public Carre (Point p)
 	{
 		super (p);
	}

	public Carre(Point p, double cote) throws Exception
	{
		super(p, cote, cote);
	}


	//														Accesseur de consultation

	public double getCote()
	{
		return super.getLargeur();
	}

	public Point getPoint()
	{
		return super.getPoint();
	}


	// 																Methode toString
	public String toString()
	{
		return "[ " + super.getPoint().getNom()+ "(" + super.getPoint().x() + ", " + super.getPoint().y() + "), " + super.getLargeur() + " ]" ;
	}

	//																Méthode redimension
	
	void redimension (double h, double v) throws Exception 
	{
		double largeur;
		
		if(h != v) 
			return;
		
		if( h > 0. )
			largeur = super.getHauteur() * Math.abs(h);
			
		else if ( h < 0. )
			largeur = super.getHauteur() / Math.abs(h);
		else
			return;
		
		try
		{
			super.redimension(largeur - super.getHauteur(),largeur - super.getHauteur());
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	void redimension (double valeur) throws Exception 
	{
		double largeur;
		
		if( valeur > 0. )
			largeur = super.getHauteur() * Math.abs(valeur);
			
		else if ( valeur < 0. )
			largeur = super.getHauteur() / Math.abs(valeur);
		else
			return;
		
		try
		{
			super.redimension(largeur - super.getHauteur() ,largeur - super.getHauteur());
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	
}
