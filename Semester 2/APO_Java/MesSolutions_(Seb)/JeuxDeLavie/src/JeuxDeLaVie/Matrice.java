package JeuxDeLaVie;

public class Matrice {
	
	
	private Bacterie map[][];
	private int largeur;
	private int hauteur;
	
	
	
	public Matrice (int largeur, int hauteur)
	{
		this.hauteur = hauteur;
		this.largeur = largeur;
		map = new Bacterie [hauteur] [largeur] ;

	}
	
	public int getLargeur(){ return largeur; }
	public int getHauteur(){ return hauteur; }
	
	
	
	public String toString()
	{
		
		String resultat = new String();
		
		
		for( int y = 0; y<hauteur; y++)
		{
			for(int x = 0; x<largeur; x++)
			{
				resultat += map[y][x].getEtat() + '\t';
			}
			resultat += '\n';
			
		}
		return resultat;
	}

	
	public void setCase(Bacterie bact, int x, int y)throws Exception
	{
		if( x<0 || y<0 || x>= largeur || y>= hauteur )
			throw new Exception();
		map[y][x] = bact;
		
	}
	

}
