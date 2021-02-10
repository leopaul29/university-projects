// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package Collections
//
// Classe Traducteur 
// version V0.0.0
// Auteur : N. Sebou & Cie
//

package CollectionsV000;

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
			motTraduit = ((String) Traducteur.m_dico.get(motDico));//le mot //Cours 7 Diapo 9
			if (motTraduit.equals(motA))
				return motDico;
		}

		return "";
	}
	
	
	

}
