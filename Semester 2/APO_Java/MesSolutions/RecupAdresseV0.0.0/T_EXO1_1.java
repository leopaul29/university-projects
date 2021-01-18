
public class T_EXO1_1 {
	
	public static void main (String[] args) throws Exception
	{
	Tests.Begin("Exercice1","0.0.0");

		Tests.Design("Methodes",3); {
		
			Tests.Case("Afficher Adresse");{
			
				String google = "www.google.fr";
				String fb = "www.facebook.com";
				EXO1 e = new EXO1();
			
				Tests.Unit("www.google.fr/173.194.35.56", e.IPSiteWeb(google));
				Tests.Unit("www.facebook.com/31.13.86.16", e.IPSiteWeb(fb));
			}
		}
	Tests.End();
	}
}
