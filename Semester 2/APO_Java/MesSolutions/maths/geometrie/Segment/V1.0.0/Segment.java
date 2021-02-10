//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Segment - Couple de points distincts du plan euclidien
//
// Edition A        : TD5
//
//    + Version 0.0.0	: version initiale
//
// Auteur : A. Thuaire
//
package maths.geometrie;

import maths.geometrie.Point;
import maths.Vecteur;

public class Segment {
private final Point m_A;
private final Point m_B;

   // ---                                               Constructeur par defaut

   public Segment() {

      m_A= new Point(0, 0);
      m_B= new Point(1, 0);
   }

   // ---                                                   Constructeur normal

   public Segment(final Point p0, final Point p1) {

      m_A= (Point)p0.clone();
      m_B= (Point)p1.clone();
   }

   // ---                                            Accesseurs de consultation

   public String getNom() {return "" + m_A.getNom() + m_B.getNom();}

   public Point  getExtremite(int rang) throws Exception {

      if (rang == 1) return m_A;
      if (rang == 2) return m_B;

      throw new Exception();
   }

   public Point getMilieu() {
   	
   double x= (m_A.getAbscisse() + m_B.getAbscisse()) / 2;
   double y= (m_A.getOrdonnee() + m_B.getOrdonnee()) / 2;

      return new Point(x, y);
   }

   public double getLongueur() {return m_A.distance(m_B); }

   // ---                                                      Methode toString

   public String toString() {
   	
   double x1= m_A.getAbscisse(), x2= m_B.getAbscisse();
   double y1= m_A.getOrdonnee(), y2= m_B.getOrdonnee();

   	  return "[(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")]";
   }

   // ---                                                         Methode clone

   public Object clone() {return new Segment(m_A, m_B);}

   // ---                                                        Methode equals

   public boolean equals(Object s) {
   	
   boolean b1= m_A.equals(((Segment)s).m_A);
   boolean b2= m_B.equals(((Segment)s).m_B);
   boolean b3= m_A.equals(((Segment)s).m_B);
   boolean b4= m_B.equals(((Segment)s).m_A);

      return (b1 && b2) || (b3 && b4);
   }

   // ---                                                     Methode extremite

   public boolean extremite(final Point p) {

      return p.equals(m_A) || p.equals(m_B);
   }

   // ---                                                    Methode horizontal

   public boolean horizontal() {return m_A.getOrdonnee() == m_B.getOrdonnee();}

   // ---                                                      Methode vertical

   public boolean vertical()   {return m_A.getAbscisse() == m_B.getAbscisse();}

   // ---                                                         Methode projX

   public Segment projX() {

      // Traiter le cas particulier d'un segment support vertical
      //
      if (vertical()) return null;

      // Restituer le resultat
      //
      return new Segment(m_A.projX(), m_B.projX());
   }

   // ---                                                Methode projY

   public Segment projY() {

      // Traiter le cas particulier d'un segment support horizontal
      //
      if (horizontal()) return null;

      // Restituer le resultat
      //
      return new Segment(m_A.projY(), m_B.projY());
   }
   
   // ---												Méthode aligne
   
   public boolean aligne(Point p){
   	
		Vecteur v1 = new Vecteur(this.m_A.getAbscisse()-this.m_B.getAbscisse(), this.m_A.getOrdonnee()-this.m_B.getOrdonnee());
		Vecteur v2 = new Vecteur(this.m_A.getAbscisse()-p.getAbscisse(), this.m_A.getOrdonnee()-p.getOrdonnee());
		if(v1.colineaire(v2) == true) return true;
		else return false;
   }
   
   // ---												Methode Appartient
   
   public boolean appartient(Point p){
   	
   		if(this.aligne(p)==true){
   			Vecteur AB = new Vecteur(this.m_A.getAbscisse()-this.m_B.getAbscisse(), this.m_A.getOrdonnee()-this.m_B.getOrdonnee());
   			Vecteur AP = new Vecteur(this.m_A.getAbscisse()-p.getAbscisse(), this.m_A.getOrdonnee()-p.getOrdonnee());
   			if(AB.getNorme()>AP.getNorme()) return true;
   			else return false;
   		}
   		else return false;
   }
}