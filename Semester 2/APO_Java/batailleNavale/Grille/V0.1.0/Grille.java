/**
 * @(#)Grille.java
 *
 *
 *
 *	V = la case est vide
 *	B = contient un bateau
 *	R = coup raté
 *	T = touché
 *
 *
 *
 * @author : MARTIN Léo-Paul et JACQUEMET Corentin
 * @version : V0.1.0
 * @date : 10/04/2013
 */

package batailleNavale;

import java.util.*;

public class Grille {
	

   private char [][] m_grille;
   private int m_ligne;
   private int m_colonne;
   
// Constructeur de grille par default   
    public Grille() {
    	m_grille = new char[12][12];
    	this.setLigne(10);
    	this.setColonne(10);
    	for(int i=0; i<=11; i++){
    		for(int j=0; j<=11; j++){
    			try{this.setCase(i,j,'V');}
    			catch(Exception e){}
    		}
    	}
    }

// Constructeur de grille de dimension variable
    public Grille(int col, int row){
    	m_grille = new char[row+2][col+2];
    	this.setLigne(row);
    	this.setColonne(col);
    	for(int i=0; i<=row+1; i++){
    		for(int j=0; j<=col+1; j++){
    			try{this.setCase(i,j,'V');}
    			catch(Exception e){}
    		}
    	}
    }
    
//	Attribuer une valeur à une case    
    public void setCase(int col, int row, char etat)throws Exception{
    	if ((etat == 'V')||(etat == 'B')||(etat == 'R')||(etat == 'T')||(etat == 'C')) this.m_grille[row][col]=etat;
    	else throw new Exception();
    }
    
// Retourne le caractere de la case
    public char getCase(int col, int row){
    	return this.m_grille[row][col];
    }
    
// Retourne le nombre de ligne
	public int getLigne(){
		return m_ligne;
	}
	
// Retourne le nombre de colonne
	public int getColonne(){
		return m_colonne;
	}
	
//	Définit le nombre de lignes
	private void setLigne(int row){
		this.m_ligne=row;
	}

//	Définit le nombre de colonnes
    private void setColonne(int col){
    	this.m_colonne=col;
    }
    
//	Vérifie si la case est Vide
    public boolean estVide(int col, int row){
    	if (this.getCase(col, row) == 'V') return true;
    	else return false;
    }
    
//	Vérifie si la case est occupé par un bateau
	public boolean estOccupe(int col, int row){
    	if (this.getCase(col, row) == 'B') return true;
    	else return false;
    }
    
//	Vérifie si un bateau est coulé
	public boolean estCoule(int col, int row){
		for(int i=row-1;i<=row+1; i++){
			for(int j=col-1;j<=col+1;j++){
				if(this.getCase(j,i)=='B') return false;
				if(this.getCase(j,i)=='T'){
					if(this.estCoule(j,i,col,row)==false)
						return false;
				}
			}
		}
		return true;
	}
	
// Vérifie si un bateau est coulé sauf la case i,j
	public boolean estCoule(int col, int row, int ncol, int nrow){
		for(int i=row-1;i<=row+1; i++){
			for(int j=col-1;j<=col+1;j++){
				if(this.getCase(j,i)=='B') return false;
				if((this.getCase(j,i)=='T')&&(j!=ncol)&&(i!=nrow)){
					if(this.estCoule(j,i,col,row)==false)
						return false;
				}
			}
		}
		return true;
	}	
    
//	Vérifie si la case à déja été joué
	public boolean aEteJoue(int col, int row){
		if((this.getCase(col,row) == 'R')||(this.getCase(col,row) == 'T')||(this.getCase(col,row) == 'C')) return true;
		else return false;
	}
    
// Vérifie si la case à été joué et si le coup à été raté
	public boolean estRate(int col, int row){
    	if (this.getCase(col, row) == 'R') return true;
    	else return false;
    }
    
//	Vérifie si la case à été joué et si un bateau à été touché
	public boolean estTouche(int col, int row){
    	if (this.getCase(col, row) == 'T') return true;
    	else return false;
    }
    
    // affiche les caractéristiques d'une grille
	public String toString(){
		return "[ Lignes : "+this.getLigne()+" , Colonnes : "+this.getColonne()+" ]";
	
	}
}