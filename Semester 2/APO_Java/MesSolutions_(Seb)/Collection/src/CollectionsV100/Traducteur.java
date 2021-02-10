// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package Collections
//
// Classe Traducteur 
// Version V0.0.0
// Version V1.0.0 + traduction multilingue
// Auteur : N. Sebou & Cie
//

package CollectionsV100;

import java.util.HashMap;
import java.util.Iterator;
@SuppressWarnings("rawtypes")
public abstract class Traducteur {
	
	
	protected static HashMap m_dico = new HashMap();

//													INIT
	public static  void init (HashMap dico)
	{
		Traducteur.m_dico = dico;
	}
	
//													GETDICO
	public static HashMap getDico ()
	{
		return Traducteur.m_dico;
	}
	
	
//													TRADUIRE Fr --> An
	public static String traduire (String motF)
	{
		if (motF == null)
			return null;
		
		return   (String) Traducteur.m_dico.get(motF);
	}
	
	
//													TRADUIRE An --> Fr
	public static String inverse (String motA)
	{
		Iterator i = Traducteur.m_dico.keySet().iterator();
		String motDico = new String();
		String motTraduit = new String();
		
		while(i.hasNext())
		{
			motDico = (String) i.next();//indice
			motTraduit = ((String) Traducteur.m_dico.get(motDico));//le mot 
			if (motTraduit.equals(motA))
				return motDico;
		}

		return "";
	}
	
	public static String TraductionMultilangue (String mot) //(langue, dico(motlangue, traduc))
	{
		
		//je garde en memoire le dico des dico
		HashMap grandDico =  Traducteur.getDico();
		
		String Resultat = new String();
		String langueDico = new String();
		String traduc = new String();
		
		Iterator i = Traducteur.m_dico.keySet().iterator();
		
		while (i.hasNext())
		{
			langueDico = (String) i.next(); //langue
			Traducteur.init( (HashMap) Traducteur.m_dico.get(langueDico));
			traduc = Traducteur.traduire(mot);
			
			
			Resultat += langueDico + "=" + traduc +" ";
			
			//on replace l'ancien dico
			Traducteur.init(grandDico);
		}
		
		
		return "{"+ Resultat + "}";
	}
	
	

}
