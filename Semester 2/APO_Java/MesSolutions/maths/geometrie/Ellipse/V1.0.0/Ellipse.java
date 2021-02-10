//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Ellipse
//
// Edition "Draft" : le point d'entree simule les tests unitaires
//
// + Version 0.0.0 : TP6 costructeur, accesseurs, toString, estVide, Redimension, RectangleExt, RectangleInt, clone, equals
// + Version 1.0.0 : TD7 methode clone en public
//
// Auteur : MARTIN Léo-Paul
//
package maths.geometrie;

public class Ellipse {
	
	private Point m_ptOrigine;
	private double m_focal;
	private double m_secondaire;


	// --- 												Constante PI

	private static final double PI = 3.14159;
	
	// 	--- 										Constructeur par defaut
	
	public Ellipse(){
		
		m_ptOrigine=new Point();
		m_focal=0;
		m_secondaire=0;
	}

	// 	--- 										Premier Constructeur Normal
	
	public Ellipse(double x, double y, double f, double s) throws Exception {
		
		if((f<0)||(s<0))throw new Exception();
		m_ptOrigine=new Point(x,y);
		m_focal=f;
		m_secondaire=s;
	}
	
	// --- 											Second Construceut Normal
	
	public Ellipse(Point p, double f, double s) throws Exception {
		
		if((f<0)||(s<0))throw new Exception();
		m_ptOrigine=p;
		m_focal=f;
		m_secondaire=s;
	}
	
	// --- 											Troisieme Constructeur Normal
	
	public Ellipse(Point p){
		
		m_ptOrigine=p;
		m_focal=0;
		m_secondaire=0;
	}
	
	// --- 											Quatrieme Constructeur Normal
	
	public Ellipse(double f, double s) throws Exception {
		
		if((f<0)||(s<0))throw new Exception();
		m_ptOrigine=new Point();
		m_focal=f;
		m_secondaire=s;
	}
	
	// --- 												Accesseurs getPoint / getFocal / getSecondaire / getAire
	
	public Point getPoint(){return this.m_ptOrigine;}
	public double getFocal(){return this.m_focal;}
	public double getSecondaire(){return this.m_secondaire;}
	public double getAire(){return PI*(this.m_focal/2)*(this.m_secondaire/2);}
	public double getPerimetre(){
		return PI*Math.sqrt(2*(Math.pow(this.getFocal()/2,2)+(Math.pow(this.getSecondaire()/2,2))));
	}

	// --- 															Methode toString
	
	public String toString(){return "["+m_ptOrigine.toString()+", "+m_focal+", "+m_secondaire+"]";}
	
	// --- 															Methode estVide
	
	public boolean estVide(){
		
		if((this.m_focal == 0)&&(this.m_secondaire == 0)) return true;
		else return false;
	}
	
	// --- 														Methode translation
	
	public void translation(double dx, double dy){this.m_ptOrigine.translation(dx, dy);}
	
	// ---														Methode redimension
	
	public void redimension(double df, double ds) throws Exception {
		
		if((df==0)||(ds==0))throw new Exception();
		
		if(df>=0) this.m_focal*=df;
		else this.m_focal/=Math.abs(df);
		
		if(ds>=0) this.m_secondaire*=ds;
		else this.m_secondaire/=Math.abs(ds);
	}
	
	// --- 															Methode rectangleExt
	
	public Rectangle rectangleExt() throws Exception {
		
		return new Rectangle(this.getPoint().getAbscisse()-(this.getFocal()/2),this.getPoint().getOrdonnee()-(this.getSecondaire()/2),this.getFocal(), this.getSecondaire());
	}
	
	// --- 															Methode rectangleInt
	
	public Rectangle rectangleInt() throws Exception {
		
		double l=Math.sqrt(2)*(this.getFocal()/2);
		double h=Math.sqrt(2)*(this.getSecondaire()/2);
		Point pt = this.getPoint();
		pt.translation(-l/2,-h/2);
		return new Rectangle(pt,l,h);
	}
	
	// --- 																Methode clone
	
	public Object clone(){
		
		Ellipse e1=null;
		try{
			e1=new Ellipse(this.m_ptOrigine, this.m_focal, this.m_secondaire);
		}
		catch(Exception e){}
		return e1;
	}
	
	// 	--- 															Methode equals
	
	public boolean equals(Object o){
		
		Ellipse e1=(Ellipse)o;
		if((this.m_ptOrigine==e1.m_ptOrigine)&&(this.m_focal==e1.m_focal)&&(this.m_secondaire==e1.m_secondaire))
			return true;
		else return false;
	}	
}