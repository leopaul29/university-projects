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
 * @author MARTIN Léo-Paul et JACQUEMET Corentin
 * @version : V1.0.0
 * @date : 17/04/2013
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
  
//	Joue un coup sur la case spécifier et modifie la valeur de la case en conséquence
	public void coup(int col, int row)throws Exception{
		if ((this.getLigne() <= row-1)||(0> row)) throw new Exception();
		if ((this.getColonne() <= col-1)||(0> col)) throw new Exception();		
		if ((this.getCase(col,row) == 'T')||(this.getCase(col,row) == 'R')||(this.getCase(col,row) == 'C'))throw new Exception();
		if (this.estOccupe(col,row))
		{
			try{this.setCase(col,row,'T');}
			catch(Exception e){}
		}
		else{
			try{this.setCase(col,row,'R');}
			catch(Exception e){}
			}
	}

//	Vérifier si les coordonées d'un torpilleur sont valides
	public boolean verifCoord(int col1, int row1, int col2, int row2)throws Exception{
		if((this.getLigne()<row1)||(this.getLigne()<row2)||(this.getColonne()<col1)||(this.getColonne()<col2)) throw new Exception();
		if((1>row1)||(1>row2)||(1>col1)||(1>col2)) throw new Exception();
		if (((row1==row2)&&((col1==col2+1)||(col1==col2-1)))||(((row1==row2+1)||(row1==row2-1))&&(col1==col2))) return true;
		else return false;
	}
	
//	Vérifier si les coordonées d'un croiseur sont valides
	public boolean verifCoord(int col1, int row1, int col2, int row2, int col3, int row3)throws Exception{
		if((this.getLigne()<row1)||(this.getLigne()<row2)||(this.getLigne()<row3)||(this.getColonne()<col1)||(this.getColonne()<col2)||(this.getColonne()<col3)) throw new Exception();
		if((1>row1)||(1>row2)||(1>col1)||(1>col2)||(1>row3)||(1>col3)) throw new Exception();
		if((row1==row2)&&(row2==row3)){
			if(((col1==col2+1)&&(col2==col3+1))||((col1==col2-1)&&(col2==col3-1)))return true;
			if(((col2==col3+1)&&(col3==col1+1))||((col2==col3-1)&&(col3==col1-1)))return true;
			if(((col3==col1+1)&&(col1==col2+1))||((col3==col1-1)&&(col1==col2-1)))return true;
		}
		if((col1==col2)&&(col2==col3)){
			if(((row1==row2+1)&&(row2==row3+1))||((row1==row2-1)&&(row2==row3-1)))return true;
			if(((row2==row3+1)&&(row3==row1+1))||((row2==row3-1)&&(row3==row1-1)))return true;
			if(((row3==row1+1)&&(row1==row2+1))||((row3==row1-1)&&(row1==row2-1)))return true;
		}
		return false;		
	}
	
//	Vérifier si les coordonées d'un cuirassé sont valides
	public boolean verifCoord(int col1, int row1, int col2, int row2, int col3, int row3, int col4, int row4)throws Exception{
		if((this.getLigne()<row1)||(this.getLigne()<row2)||(this.getLigne()<row3)||(this.getLigne()<row4)||(this.getColonne()<col1)||(this.getColonne()<col2)||(this.getColonne()<col3)||(this.getColonne()<col4)) throw new Exception();
		if((1>row1)||(1>row2)||(1>col1)||(1>col2)||(1>row3)||(1>col3)||(1>row4)||(1>col4)) throw new Exception();
		if ((verifCoord(col1, row1, col2, row2, col3, row3))&&(((row4==row3)&&(col2!=col4)&&((col3==col4+1)||(col3==col4-1)))||(((row3==row4+1)||(row3==row4-1))&&(row2!=row4)&&(col3==col4)))) return true;
		//else return false;
/*		if((row1==row2)&&(row2==row3)&&(row3==row4)){
			if(((col1==col2+1)&&(col2==col3+1)&&(col3==col4+1))||((col1==col2-1)&&(col2==col3-1)&&(col3==col4-1)))return true;
			if(((col2==col3+1)&&(col3==col4+1)&&(col4==col1+1))||((col2==col3-1)&&(col3==col4-1)&&(col4==col1-1)))return true;
			if(((col3==col4+1)&&(col4==col1+1)&&(col1==col2+1))||((col3==col4-1)&&(col4==col1-1)&&(col1==col2-1)))return true;
			if(((col4==col1-1)&&(col1==col2+1)&&(col2==col3+1))||((col4==col1-1)&&(col1==col2-1)&&(col2==col3-1)))return true;
		}
		if((col1==col2)&&(col2==col3)&&(col3==col4)){
			if(((row1==row2+1)&&(row2==row3+1)&&(row3==row4+1))||((row1==row2-1)&&(row2==row3-1)&&(row3==row4-1)))return true;
			if(((row2==row3+1)&&(row3==row4+1)&&(row4==row1+1))||((row2==row3-1)&&(row3==row4-1)&&(row4==row1-1)))return true;
			if(((row3==row4+1)&&(row4==row1+1)&&(row1==row2+1))||((row3==row4-1)&&(row4==row1-1)&&(row1==row2-1)))return true;
			if(((row4==row1-1)&&(row1==row2+1)&&(row2==row3+1))||((row4==row1-1)&&(row1==row2-1)&&(row2==row3-1)))return true;
		}
		*/
		return false;		
	}
	
// Vérifier si les cases sont libre pour l'emplacement du torpilleur
	public boolean verifPlaceBateau(int col1, int row1, int col2, int row2)throws Exception{
		if(this.verifCoord(col1, row1, col2, row2)==false)throw new Exception();
		if(row1<=row2){
			if (col1<=col2){
				for(int i=row1-1;i<=row2+1;i++){
					for(int j=col1-1;j<=col2+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
			else{
				for(int i=row1-1;i<=row2+1;i++){
					for(int j=col2-1;j<=col1+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
		}
		else{
			if (col1<=col2){
				for(int i=row1-1;i<=row2+1;i++){
					for(int j=col1-1;j<=col2+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
			else{
				for(int i=row1-1;i<=row2+1;i++){
					for(int j=col2-1;j<=col1+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
		}
		return true;
	}

// Vérifier si les cases sont libre pour l'emplacement du croiseur
	public boolean verifPlaceBateau(int col1, int row1, int col2, int row2, int col3, int row3)throws Exception{
		if(this.verifCoord(col1, row1, col2, row2, col3, row3)==false)throw new Exception();
		if(row1<=row3){
			if (col1<=col3){
				for(int i=row1-1;i<=row3+1;i++){
					for(int j=col1-1;j<=col3+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
			else{
				for(int i=row1-1;i<=row3+1;i++){
					for(int j=col3-1;j<=col1+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
		}
		else{
			if (col1<=col3){
				for(int i=row1-1;i<=row3+1;i++){
					for(int j=col1-1;j<=col3+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
			else{
				for(int i=row1-1;i<=row3+1;i++){
					for(int j=col3-1;j<=col1+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
		}
		return true;
	}
	
// Vérifier si les cases sont libre pour l'emplacement du cuirassé
	public boolean verifPlaceBateau(int col1, int row1, int col2, int row2, int col3, int row3, int col4, int row4)throws Exception{
		if(this.verifCoord(col1, row1, col2, row2, col3, row3, col4, row4)==false)throw new Exception();
		if(row1<=row4){
			if (col1<=col4){
				for(int i=row1-1;i<=row4+1;i++){
					for(int j=col1-1;j<=col4+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
			else{
				for(int i=row1-1;i<=row4+1;i++){
					for(int j=col4-1;j<=col1+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
		}
		else{
			if (col1<=col4){
				for(int i=row1-1;i<=row4+1;i++){
					for(int j=col1-1;j<=col4+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
			else{
				for(int i=row1-1;i<=row4+1;i++){
					for(int j=col4-1;j<=col1+1;j++){
						if(!this.estVide(j,i)) return false;
					}
				}
			}
		}
		return true;
	}
	
// placer torpilleur sur la grille
	public void placer(int col1, int row1, int col2, int row2)throws Exception{
		if (!verifPlaceBateau(col1, row1, col2, row2))throw new Exception();
		this.setCase(col1, row1, 'B');
		this.setCase(col2, row2, 'B');
	}
	
// placer croiseur sur la grille
	public void placer(int col1, int row1, int col2, int row2, int col3, int row3)throws Exception{
		if (!verifPlaceBateau(col1, row1, col2, row2, col3, row3))throw new Exception();
		this.setCase(col1, row1, 'B');
		this.setCase(col2, row2, 'B');
		this.setCase(col3, row3, 'B');
	}
	
// placer cuirassé sur la grille
	public void placer(int col1, int row1, int col2, int row2, int col3, int row3, int col4, int row4)throws Exception{
		if (!verifPlaceBateau(col1, row1, col2, row2, col3, row3, col4, row4))throw new Exception();
		this.setCase(col1, row1, 'B');
		this.setCase(col2, row2, 'B');
		this.setCase(col3, row3, 'B');
		this.setCase(col4, row4, 'B');
	}
	
//	affiche la grille avec les bateaux
	public void afficheGrille(){
		
		for(int i=0;i<=this.getLigne();i++){
			for(int j=0;j<=this.getColonne();j++){
				if(i==0 && j==0)System.out.print(" ");
				else{
					if(j==0 || i==0){if(i==0){if(j!=this.getLigne()){System.out.print(" | " + BatailleNavale.CharCol(j));
						}else System.out.println(" | " + BatailleNavale.CharCol(j) + " | ");}
									if(j==0){if(i<10)System.out.print(i + " | ");else System.out.print(i + "| ");}
						}else{if(j==this.getColonne())System.out.println(this.getCase(i,j) + " | ");
						  		else System.out.print(this.getCase(i,j) + " | ");}
				}
			}
		}
	}
	
//pour afficher les lettres aux lignes et les chiffres aux colonnes
/*	for(int i=0;i<=this.getLigne();i++){
			for(int j=0;j<=this.getColonne();j++){
				if(i==0 && j==0)System.out.print(" ");
				else {if(i==0){if(j!=this.getLigne()){if(j<11)System.out.print(" | " + j);else System.out.print("| " + j);
						}else System.out.println("| " + j);
					 }else{if(j==0)System.out.print(BatailleNavale.CharCol(i));
					 	  else {if(j==this.getColonne())System.out.println(" | "+this.getCase(i,j)+" | ");
						  		else System.out.print(" | "+this.getCase(i,j));
					 	  }
					  }
				}
			}
		}
	}*/

//	affiche la grille sans les bateaux
	public void afficheGrilleSansBateaux(){
		int k=1;
		System.out.println("  A|B|C|D|E|F|G|H|I|J");
		for(int i=1;i<=this.getLigne();i++){
			for(int j=1;j<=this.getColonne();j++){
				if(j==0){
					System.out.print(k);
					k++;
				}
				if(j==this.getColonne()-1){
					if((this.getCase(i,j))=='B')
						System.out.println("|V|");
					else 
						System.out.println("|"+this.getCase(i,j)+"|");
				}
				else{
					if((this.getCase(i,j))=='B')
						System.out.print("|B");
					else
						System.out.print("|"+this.getCase(i,j));
				}
			}
		}
	}
	
// affiche les caractéristiques d'une grille
	public String toString(){
		return "[ Lignes : "+this.getLigne()+" , Colonnes : "+this.getColonne()+" ]";
	}
	
//						--- clone() ---
	public Object clone(){
		Grille g1=null;
		try{
			g1=new Grille(this.getColonne(), this.getLigne());
		}
		catch(Exception e){}
		return g1;
	}
	
//						--- equals(Object o) ---
	public boolean equals(Object o){
		Grille g1=(Grille)o;
		if((this.getLigne()==g1.getLigne())&&(this.getColonne()==g1.getColonne())){
			for (int i=0;i<this.getColonne()+1;i++){
				for(int j=0;j<this.getLigne()+1;j++)
					if(this.getCase(i,j)!=g1.getCase(i,j)) return false;
			}
			return true;
		}
		else return false;
	}

}