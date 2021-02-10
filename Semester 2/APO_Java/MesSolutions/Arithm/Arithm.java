//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2012_2013 - DUT/S2T
//
// Classe Arithm - Services pgcd et ppcm
//
// Version 0.0.0 : TD1 methode pgcd, ppcm
//
// Auteur : MARTIN Léo-Paul
//

public abstract class Arithm {

// ---                                                          Methode pgcd

   public static int pgcd (int n, int m) {
	
	int PGCD;
      // Controler la validite des parametres
      //
		n = Math.abs(n);
		m = Math.abs(m);
		
      // Traiter le cas particulier de l'identite
      //
      if ((n == 1)||(m == 1)) return PGCD = 1;

      // Traiter le cas particulier de nombres egaux
      //
		if (n == m) return PGCD = n;

      // Traiter le cas general par appel recursif
      //
      	while (n != m) {
			if (n < m)
				m = m - n;
			else 
				n = n - m;
      	}
		return n;
   }

// ---                                                          Methode ppcm

   public static int ppcm (int n, int m) {
	
	int Produit, Reste, PPCM;
      // Controler la validite des parametres
      //
      	n = Math.abs(n);
		m = Math.abs(m);
		
      // Traiter le cas general
      //
      Produit = n * m;
		Reste   = n % m;
		
		while(Reste != 0){
		    n = m;
		    m = Reste;
		    Reste = n % m;
	        }
		PPCM = Produit / m;
	
		return PPCM;

   }

   public static void main (String[] args) {

      // Calculer plusieurs pgcd
      //

      System.out.println("PGCD (36, 1)= " + pgcd(36, 1));
      System.out.println("PGCD (36, 36)= " + pgcd(36, 36));
      System.out.println("PGCD (36, 42)= " + pgcd(36, 42));
      System.out.println("PGCD (37, 43)= " + pgcd(37, 43));
      System.out.println();

      // Calculer plusieurs ppcm
      //
      System.out.println("PPCM (6, 7)  = "  + ppcm(6, 7));
      System.out.println("PPCM (6, 12) = "  + ppcm(6, 12));
      System.out.println("PPCM (12, 18)= "  + ppcm(12, 18));
      System.out.println();
   }
}
