//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Point- Modelisation de l'ensemble ZxZ*
//
// Edition "Draft" : le point d'entree simule les tests unitaires
//
// + Version 0.0.0 : TP2 constructeur, accesseur, methode confondu et distance, projX et projY
// + Version 0.1.0 : TP3=>TP4 methode translation/translate
// + Version 0.2.0 : TD5 methode clone et equals
// + Version 1.0.0 : TD7 methode clone en public
// + Version 2.0.0 : TD12 methode save et load
//
// Auteur : MARTIN Léo-Paul
//
import java.util.*;
import java.io.*;

public class Point implements Serializable {

    private double m_x;
    private double m_y;
    private char m_nom;
    public final static double EPSILON = 1./10000;
    private static int m_compteur;
    
    // ---							 Constante ESPILON

    final double EPISLON = 1./10000; 
    
  	// ---							Constructeur par défaut

    public Point() {
    	
    	m_x=0;
    	m_y=0;
    	m_nom='_';
    }
    
    // ---							Premier constructeur normal

    public Point(double x, double y){
    	
    	m_x=x;
    	m_y=y;
    	m_nom='_';
    }
    
    // ---							Second constructeur normal

    public Point(char nom, double x, double y){
    	
    	m_x=x;
    	m_y=y;
    	m_nom=nom;
    }
    
    // ---							Accesseur Consultation Nom / Abscisse / Ordonnee

    public char getNom(){return this.m_nom;}
	public double getAbscisse(){return this.m_x;}
    public double getOrdonnee(){return this.m_y;}
    public static int getCompteur(){return m_compteur;}
    
    // ---							Methode toString

    public String toString(){ return m_nom + "(" + m_x + ", " + m_y + ")";}
    
    // ---							Méthode confondus

	public boolean confondus(Point op2){
		
    	if ((Math.abs(this.m_x - op2.m_x) <= EPSILON) && (Math.abs(this.m_y - op2.m_y) <= EPSILON))
    		return true;
    	else return false;
    }
    
    // ---							 Méthode distance

    public double distance(final Point op2){ return Math.sqrt( Math.pow(op2.m_x - this.m_x, 2) + Math.pow(op2.m_y - this.m_y, 2) );}
    
    // ---							Méthode projX 

    public Point projX(){ return new Point (getAbscisse(),0);}
    
    // ---							Méthode projY 

    public Point projY(){ return new Point (0,getOrdonnee());}
    
    // ---							Méthode translate

	public Point translate (double dx, double dy) {return new Point(m_x += dx, m_y += dy);}
	
    // ---							Méthode translation

    public void translation (double dx, double dy){	m_x += dx; m_y += dy;} 
    
   	// ---												--- Methode Equals et Clone ---
	//    
    // ---	   						Methode equals

	public boolean equals(Object obj) {
		Point p = (Point)obj;
		return ((m_x == p.m_x) && (m_y == p.m_y));
	}

 	//   --- 						Methode Clone

	public Object clone() {
		Point resu = null;
		try{
			resu = new Point(this.m_x,this.m_y);
		}catch(Exception e){}
		return resu;
	}
	
	// ---												--- Methode Save et Load ---
	//
	// ---							Methode Save
	
	public static void save(String fileName, Point p) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(fileName);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		try{ oos.writeObject(p); }
		
		finally{ oos.close(); }
	}
	
	// ---							Methode Load
	
	public static Point load (String fileName) throws IOException {
		
		Point p = null;
		ObjectInputStream ois = new ObjectInputStream(new
		BufferedInputStream(new FileInputStream(fileName)));
		try {
			p = (Point) ois.readObject();
		}
		catch(Exception e){ }
		
		finally { ois.close(); }
		
		return p;
	}
	
	/*public static void main(String []args) {
		
		//Créer un point
		Point p1= new Point(2,2);
		
		//Save le point
		try {
			save("savep0",p1.translate(5,5));
		} catch(Exception e) {}
		
		//Load le point
		Point p2= null;
		
		try {
			p2=load("savep0");
		} catch(Exception e) {}
		
		//afficher point
		System.out.println("le point est : " + p2);
	}*/
}