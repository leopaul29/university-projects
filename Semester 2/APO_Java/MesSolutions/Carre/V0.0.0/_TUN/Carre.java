//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Carre
//
// Edition "Draft" : le point d'entree simule les tests unitaires
//
// + Version 0.0.0 : TP5 constructeur, accesseurs et methode redimension + h�ritage
//
// Auteur : MARTIN L�o-Paul
//


public class Carre extends Rectangle {
    	
private double m_cote=getLargeur();
    	
    // ---										Constructeur par defaut
    
    public Carre() {super();}
    
    // ---										Premier constructeur normal
    
    public Carre(double cote) throws Exception {super(cote,cote);}
    
    // ---										Second constructeur normal
    
    public Carre(double x,double y, double cote) throws Exception {super(x,y,cote,cote);}
    
    // ---										Troisi�me constructeur normal
    
    public Carre(Point p) throws Exception {super(p);}
    
    // ---										Quatri�me constructeur normal
    
    public Carre(Point p, double cote) throws Exception {super(p,cote,cote);}
    
    // ---										Point getPoint()(h�rit� de Rectangle)
    
    // ---										double getCote()
    
	public double getCote() {return this.getLargeur();}
	
	// ---										double getAire()
    
	public double getAire() {return this.getCote() * this.getCote();}
	
	// ---										Methode toString()
	
	public String toString(){return "[ " + this.getPoint() + ", " + this.m_cote + " ]";}
	
	// --- 										Methode redimension
	public void redimension(double x)throws Exception {
		
		super.redimension(x,x);
	}
	
}