package JeuxDeLaVie;

public class Bacterie {
	
	
	int etat;
	
	
	public Bacterie ()
	{
		etat =0;
	}
	
	public Bacterie (int etat) throws Exception
	{
		if (etat != 1 || etat != 0)
			throw new Exception();
			
		etat =0;
	}
	
	
	public int getEtat (){	return this.etat;}
	
	public void setEtat (int etat) throws Exception
	{
		if(etat != 0 || etat != 1)
			throw new Exception();
		
		this.etat = etat;
	}
	
	
	public String toString (){ return "Bacterie : "+ this.etat; }

}
