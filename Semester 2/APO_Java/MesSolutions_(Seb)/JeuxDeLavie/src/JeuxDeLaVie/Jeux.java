package JeuxDeLaVie;

import java.util.Scanner;

public class Jeux {
	
	Matrice map;
	
	public static void main (String[] args)
	{

		System.out.println("\t\t\tJeux de la vie");
		
		
		
	}
	
	
	
	private void initJeu ()
	{
		Scanner scan = new Scanner(System.in);
		boolean continuer = false;
		int hauteur=0, largeur=0, nbBact = 0;
		
		// on recupere la demande de la map 
		do
		{
			continuer = false;
			
			try{
				hauteur = scan.nextInt();
			}catch(Exception e){
				continuer = true;
				scan.nextLine();
			}
			
			if(hauteur<=0)
				continuer = true;
			
		}while(continuer);
		
		// on récupére la largeur de la map
		do
		{
			continuer = false;
			
			try{
				largeur = scan.nextInt();
			}catch(Exception e){
				continuer = true;
				scan.nextLine();
			}
			
			if(hauteur<=0)
				continuer = true;
			
		}while(continuer);
		
		do
		{
			continuer = false;
			
			try{
				nbBact = scan.nextInt();
			}catch(Exception e){
				continuer = true;
				scan.nextLine();
			}
			
			if(hauteur<=0)
				continuer = true;
			
		}while(continuer);
		
		this.map = new Matrice(largeur, hauteur);
		
		
		
		
	}
	
	
	
	private void initMap(int nbBact)
	{
		
	}
	
	
	private int tirerUnNombreAlea ( int max)
	{
		int nb = max;
		int nbChiffre =0;
		
		while( (nb % 10) != 0)
		{
			nbChiffre ++ ;
		}
	}
	

}
