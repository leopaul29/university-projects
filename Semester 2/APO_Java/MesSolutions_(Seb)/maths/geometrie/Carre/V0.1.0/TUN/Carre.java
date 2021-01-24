package maths;
import maths.*;//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Carre -
//
// Auteur : S. Nicoletti
//

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


	
}
