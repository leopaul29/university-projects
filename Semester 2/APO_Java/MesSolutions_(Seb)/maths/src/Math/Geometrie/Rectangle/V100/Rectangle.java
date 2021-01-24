
//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2011_2012 - Package _Maths
//
// Classe Rectangle -
//
//			Version V0.1.0: Ajout de la methode aire
//			Version V0.2.0: Ajout des méthode clone et equals
//			Version V1.0.0; Package + extends de FormeGeo
//		
// Auteur : S. Nicoletti
//

package Math.Geometrie.Rectangle.V100;
import Math.Geometrie.Point.V100.*;
import Math.Geometrie.FormGeo.V000.*;

public class Rectangle extends FormeGeo{

	private double m_largeur;
	private double m_hauteur;


	public Rectangle()
	{
		super();
		this.m_largeur = 0;
		this.m_hauteur = 0;
	}

	public Rectangle ( double width, double height) throws Exception
	{
		super();
		if (width<0 || height <0)
			throw new Exception();
		
		this.m_largeur = width;
		this.m_hauteur = height;
	}

	public Rectangle(double x, double y, double width, double height)throws Exception
	{
		super (x,y);
		
		if (width<0 || height <0)
			throw new Exception();

		this.m_largeur = width;
		this.m_hauteur = height;
	}

	public Rectangle(Point p)
 	{
		super(p);
		this.m_largeur = 0;
		this.m_hauteur = 0;
	}
	
	public Rectangle(Point p, double width, double height) throws Exception
	{
		if (width<0 || height <0)
			throw new Exception();

		this.m_ptOrigine = (Point) p.clone();
		this.m_largeur = width;
		this.m_hauteur = height;
	}
	
	//														Méthode contient
	public boolean contient (double x, double y)
	{
		return  this.m_ptOrigine.x()<= x && x<= this.m_ptOrigine.x()+this.m_largeur  &&
				 this.m_ptOrigine.y()<= y && y<= this.m_ptOrigine.y()+this.m_hauteur ;
	}

	public boolean contient (Point p)
	{

		return  (this.m_ptOrigine.x()<= p.x()) && (p.x()<= this.m_ptOrigine.x()+this.m_largeur)  &&
				 (this.m_ptOrigine.y()<= p.y() )&& (p.y()<= this.m_ptOrigine.y()+this.m_hauteur) ;
	}


	public boolean contient(Rectangle r)
	{
		Point coinHD = new Point ( r.m_ptOrigine.x()+r.m_largeur, r.m_ptOrigine.y() );
		Point coinBG = new Point ( r.m_ptOrigine.x(), r.m_ptOrigine.y()+ r.m_hauteur );
		Point coinBD = new Point ( r.m_ptOrigine.x()+r.m_largeur, r.m_ptOrigine.y()+ r.m_hauteur );

		return this.contient(r.m_ptOrigine) && this.contient(coinHD) && this.contient(coinBG) && this.contient(coinBD);

	}

	//														Accesseur de consultation

	public double getHauteur()
	{
		return this.m_hauteur;
	}

	public double getLargeur()
	{
		return this.m_largeur;
	}

	//																méthode redimension

	public void redimension(double h, double v) throws Exception
	{
		if ( ( this.m_hauteur + h) < 0 || ( this.m_largeur + v) < 0 )
			throw new Exception();

		this.m_hauteur += h;
		this.m_largeur += v;
	}

	//																méthode intersection

	public boolean intersection(Rectangle r)
	{
		Point monPoint = null;

		for (int j=0; j <= r.m_largeur ; j++)
		{
			for (int i=0; i <= r.m_hauteur ; i++)
			{
				monPoint = new Point (r.m_ptOrigine.x()+i, r.m_ptOrigine.y()+j);

				if ( this.contient(monPoint))
					return true;
			}
		}

		return false;
	}
	
	//														Methode estVide
	
	public boolean estVide (){return (this.m_largeur < EPSILON) && (this.m_hauteur < EPSILON) ;}

	//														Methode toString
	public String toString()
	{
		return "[ "+ this.m_ptOrigine.toString() +", " + this.m_largeur+", " + this.m_hauteur + "]";
	}
	
	
	//														Methode intersectionR
	public Rectangle intersectionR (Rectangle r)
	{
		int i=0,j=0;

		int largeur =0, hauteur =0;

		Rectangle monRect = null;
		Point monPoint = null;


		if(  this.intersection(r)) // si il y a aucune intersection on renvoi null
		{

			//je cherche la position du nouveau rectangle dans le rectangle original
			while( monRect == null )
			{
				monPoint = new Point (i+r.m_ptOrigine.x(), j+r.m_ptOrigine.y());
				//monPoint = new Point (i, j);
				if ( this.contient(monPoint))
				{
					try {
						monRect = new Rectangle(monPoint);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}


				i++;

				if (i > r.m_largeur )
				{
					i=0;
					j++;
				}

			}

			//on cherche la largeur du nouveau rectangle a partire de la position du nouveau rectangle

			for(i=1; i<=r.m_largeur  ; i++) // on part de 1 pour evite de compter une largeur = 0
			{
				monPoint = new Point ((int)monRect.m_ptOrigine.x()+i, monRect.m_ptOrigine.y());

				if ( this.contient(monPoint) && r.contient(monPoint))
					largeur++;

			}

			//on cherche la hauteur du nouveau rectangle

			for(j=1; j<=r.getHauteur(); j++)
			{
				monPoint = new Point (monRect.m_ptOrigine.x(), (int)monRect.m_ptOrigine.y()+j);


				if ( r.contient(monPoint) && this.contient(monPoint))
					hauteur++;
			}

			monRect.m_hauteur=hauteur;
			monRect.m_largeur=largeur;

			return monRect;
		}
		else
		{
			return null;
		}

	}
	
	
	public Rectangle unionR (Rectangle r) throws Exception
	{

		
		double xBas, yBas;
		double xHaut, yHaut;
		
		// on recupere le x de la position du nouveau Rect
		if ( this.getPoint().x() < r.getPoint().x())
			xBas=this.getPoint().x();
		else
			xBas = r.getPoint().x();
		
		// on recupere le y de la position du nouveau Rect
		if ( this.getPoint().y() < r.getPoint().y())
			yBas=this.getPoint().y();
		else
			yBas = r.getPoint().y();
		
		// on cherche les coordone du point HD du grand Rectangle
		
		if ( this.getPoint().x() + this.getLargeur() > r.getPoint().x()+r.getLargeur())
			xHaut=this.getPoint().x()+ this.getLargeur();
		else
			xHaut = r.getPoint().x()+ r.getLargeur();
		
		if ( this.getPoint().y()+this.getHauteur() > r.getPoint().y() + r.getHauteur())
			yHaut=this.getPoint().y()+this.getHauteur();
		else
			yHaut = r.getPoint().y()+r.getHauteur();
		
		return new Rectangle(xBas,yBas, xHaut -xBas , yHaut-yBas);
	}
	
	//													Methode aire
	
	public double getAire () {return this.getHauteur() * this.getLargeur();}
	
	public Object clone ()
	{
		Rectangle resultat = null;
		
		try {
			resultat = new Rectangle(this.getPoint(), this.getLargeur(), this.getHauteur());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	public boolean equals (Object obj)
	{
		Rectangle r = (Rectangle) obj;
		
		return (r.getLargeur() == this.getLargeur()) && (r.getHauteur() == this.getHauteur() && this.getPoint().equals(r.getPoint()));
	}
	
	public double getPerimetre ()
	{
		return (2*this.getHauteur()) + (2*this.getLargeur());
	}

}
