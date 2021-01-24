//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Rectangle
//
// Edition "Draft" : le point d'entree simule les tests unitaires
//
// + Version 0.0.0 : TP4 constructeur, accesseurs et methode contient, translation, redimension, intersection, union
// + Version 0.1.0 : TP5 getAire
// + Version 0.2.0 : TP5 methode clone et equals
// + Version 1.0.0 : TD7 methode clone en public
//
// Auteur : MARTIN Léo-Paul
//
package maths.geometrie;

public class Rectangle extends FormeGeo{
    	
private Point m_ptOrigine = null;
private double m_largeur;
private double m_hauteur;
private static int m_compteur;
    	
    // ---										Constructeur par defaut
    
    public Rectangle() {
    	
    	//creer un nouveau point qui est origine (coin inférieur gauche est (0, 0))
    	m_ptOrigine = new Point();
    	// largeur et la hauteur sont égaux à zéro.
    	m_largeur = 0;
    	m_hauteur = 0;
    	m_compteur ++;
    }
    
    // ---										Premier constructeur normal
    
    public Rectangle(double width,double height) throws Exception {
    	
    	//exception si les valeurs des paramètres, largeur ou hauteur, sont négatives
    	if (width<0 || height <0)
			throw new Exception();
			
    	//creer un nouveau point qui est origine (coin inférieur gauche est (0, 0))
    	m_ptOrigine = new Point();
    	m_largeur = width;
    	m_hauteur = height;
    	m_compteur ++;
    }
    
    // ---										Second constructeur normal
    
    public Rectangle(double x, double y, double width, double height) throws Exception {
    	
    	//exception si les valeurs des paramètres, largeur ou hauteur, sont négatives
    	if (width<0 || height <0 || x<0 || y<0)
			throw new Exception();
	
		//creer un nouveau point qui est origine (x, y)
		m_ptOrigine = new Point(x,y);
		m_largeur = width;
		m_hauteur = height;
		m_compteur ++;
    }
    
    // ---										Troisième constructeur normal
    
    public Rectangle(Point p) throws Exception {
    	
    	//exception si les valeurs des paramètres, largeur ou hauteur, sont négatives
    	if (  p.getAbscisse()<0 || p.getOrdonnee()<0)
			throw new Exception();
		// largeur et la hauteur sont égaux à zéro.
    	m_ptOrigine = p;
    	m_largeur = 0;
    	m_hauteur = 0;
    	m_compteur ++;
    }
    
    // ---										Quatrième constructeur normal
    
	public Rectangle(Point p, double width, double height) throws Exception {
		
    	//exception si les valeurs des paramètres, largeur ou hauteur, sont négatives
    	if (  p.getAbscisse()<0 || p.getOrdonnee()<0)
			throw new Exception();
			
    	m_ptOrigine = p;
    	m_largeur = width;
    	m_hauteur = height;
    	m_compteur ++;
    }
    
    // ---										Accesseur Point, Largeur, Hauteur
    
    public Point getPoint(){return this.m_ptOrigine;}
	public double getLargeur(){return this.m_largeur;}
	public double getHauteur(){return this.m_hauteur;}
	public double getAire(){return this.m_hauteur * this.m_largeur;}
	public double getPerimetre(){return 2*this.getLargeur()+2*this.getHauteur();}
	public static int getCompteur(){return m_compteur;}
	
	// ---										Methode String toString()
	
	public String toString(){return "[" + this.m_ptOrigine + ", " + this.m_largeur+ ", " + this.m_hauteur +"]";}
	
    // ---										Methode boolean estVide()
    
    public boolean estVide(){if ((this.m_largeur == 0)&& (this.m_hauteur == 0)) return true; else return false;}
    
    
    // --- ---									Methode boolean contient
    
	// ---								Methode boolean contient (double x, double y)
    
    public boolean contient (int x, int y)	{
    	
		return  this.m_ptOrigine.getAbscisse()<= x && x<= this.m_ptOrigine.getAbscisse()+this.m_largeur  &&
				 this.m_ptOrigine.getOrdonnee()<= y && y<= this.m_ptOrigine.getOrdonnee()+this.m_hauteur ;
	}
	
	// ---								Methode boolean contient (Point p)

	public boolean contient (Point p)	{
		
		return  (this.m_ptOrigine.getAbscisse()<= p.getAbscisse()) && (p.getAbscisse()<= this.m_ptOrigine.getAbscisse()+this.m_largeur)  &&
				 (this.m_ptOrigine.getOrdonnee()<= p.getOrdonnee() )&& (p.getOrdonnee()<= this.m_ptOrigine.getOrdonnee()+this.m_hauteur) ;
	}
	
	// ---								Methode boolean contient (Rectangle r)

	public boolean contient(Rectangle r)	{
		
		Point coinHD = new Point ( r.m_ptOrigine.getAbscisse()+ r.m_largeur, r.m_ptOrigine.getOrdonnee() );
		Point coinBG = new Point ( r.m_ptOrigine.getAbscisse(), r.m_ptOrigine.getOrdonnee()+ r.m_hauteur );
		Point coinBD = new Point ( r.m_ptOrigine.getAbscisse()+ r.m_largeur, r.m_ptOrigine.getOrdonnee()+ r.m_hauteur );

		return this.contient(r.m_ptOrigine) && this.contient(coinHD) && this.contient(coinBG) && this.contient(coinBD);
	}
	
	// ---										Methode void translation (double dx, double dy)
	
	public void translation (double dx, double dy){this.m_ptOrigine.translation(dx, dy);}
	
	// ---										Methode void redimension (double h, double v)
	
	public void redimension (double h, double v) throws Exception {
		
		if((v==0)||(h==0))throw new Exception();
		
		if(h>=0) this.m_largeur*=h;
		else this.m_largeur/=Math.abs(h);
		
		if(v>=0) this.m_hauteur*=v;
		else this.m_hauteur/=Math.abs(v);
	}
	
	// ---										Methode boolean intersection(Rectangle r)
	
	public boolean intersection (Rectangle r)	{
		
		Point monPoint = null;

		for (int j=0; j <= r.m_largeur ; j++) {
			for (int i=0; i <= r.m_hauteur ; i++) {
				monPoint = new Point (r.m_ptOrigine.getAbscisse()+i, r.m_ptOrigine.getOrdonnee()+j);

				if ( this.contient(monPoint))
					return true;
			}
		}
		return false;
	}
	
	// ---										Methode unionR(Rectangle r)
	public Rectangle unionR(Rectangle r){
		
		Rectangle resultat = null;
		double nx, ny, nl, nh;

		nx = (this.m_ptOrigine).getAbscisse()<=(r.m_ptOrigine).getAbscisse() ? (this.m_ptOrigine).getAbscisse() : (r.m_ptOrigine).getAbscisse();
		ny = (this.m_ptOrigine).getOrdonnee()<=(r.m_ptOrigine).getOrdonnee() ? (this.m_ptOrigine).getOrdonnee() : (r.m_ptOrigine).getOrdonnee();
		nl = (this.m_ptOrigine).getAbscisse()>=(r.m_ptOrigine).getAbscisse() ? (this.m_ptOrigine).getAbscisse()+this.m_largeur-r.m_ptOrigine.getAbscisse() : (r.m_ptOrigine).getAbscisse()+r.m_largeur-(this.m_ptOrigine).getAbscisse();
		nh = (this.m_ptOrigine).getOrdonnee()>=(r.m_ptOrigine).getOrdonnee() ? (this.m_ptOrigine).getOrdonnee()+this.m_hauteur-r.m_ptOrigine.getOrdonnee() : (r.m_ptOrigine).getOrdonnee()+r.m_hauteur-(this.m_ptOrigine).getOrdonnee();
		try{resultat = new Rectangle(nx,ny,nl,nh);}
		catch(Exception e){}
		return resultat;
	}
	
	// ---										Methode intersectionR(Rectangle r)
	
	public Rectangle intersectionR(Rectangle r)throws Exception{
		
		Rectangle resultat = null;
		if(this.intersection(r) == false)throw new Exception();
		double nx,ny,nl,nh;
		nx = (this.m_ptOrigine).getAbscisse()>=(r.m_ptOrigine).getAbscisse() ? (this.m_ptOrigine).getAbscisse() : (r.m_ptOrigine).getAbscisse();
		ny = (this.m_ptOrigine).getOrdonnee()>=(r.m_ptOrigine).getOrdonnee() ? (this.m_ptOrigine).getOrdonnee() : (r.m_ptOrigine).getOrdonnee();
		nl = (this.m_ptOrigine).getAbscisse()<=(r.m_ptOrigine).getAbscisse() ? (this.m_ptOrigine).getAbscisse()+this.m_largeur-r.m_ptOrigine.getAbscisse() : (r.m_ptOrigine).getAbscisse()+r.m_largeur-(this.m_ptOrigine).getAbscisse();
		nh = (this.m_ptOrigine).getOrdonnee()<=(r.m_ptOrigine).getOrdonnee() ? (this.m_ptOrigine).getOrdonnee()+this.m_hauteur-r.m_ptOrigine.getOrdonnee() : (r.m_ptOrigine).getOrdonnee()+r.m_hauteur-(this.m_ptOrigine).getOrdonnee();
		try{resultat=new Rectangle(nx,ny,nl,nh);}
		catch(Exception e){}
		return resultat;
	}
	
		// ---	   						Methode equals

	public boolean equals(Object obj) {
		
		Rectangle r = (Rectangle)obj;
		return ((m_ptOrigine == r.m_ptOrigine) && (m_largeur == r.m_largeur) && (m_hauteur == r.m_hauteur));
	}

 	//   --- 						Methode Clone

	public Object clone() {
		
		Rectangle resu = null;
		try{
			resu = new Rectangle(this.m_ptOrigine,this.m_largeur,this.m_hauteur);
		}catch(Exception e){}
		return resu;
	}
}