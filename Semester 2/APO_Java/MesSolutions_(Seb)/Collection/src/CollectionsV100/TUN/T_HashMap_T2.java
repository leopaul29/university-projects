// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package Collections
//
// Classe Test Unitaire T2
//
// Auteur : N. Sebou 
//

package CollectionsV100.TUN;
import java.util.HashMap;

import Collections.Teste.*;
import CollectionsV100.*;

@SuppressWarnings("rawtypes")
public class T_HashMap_T2 {

@SuppressWarnings("unchecked")
public static void main (String[] args) throws Exception {

      Tests.Begin("Collection", "0.0.0");

         Tests.Design("Teste Unitaire", 3); {
        	 
        	 
        	 
        	HashMap FrAng = new HashMap();
			FrAng.put("Glace", "Ice");
			FrAng.put("Maison", "House");
			
			HashMap FrIta = new HashMap();
			FrIta.put("Glace", "Gelato");
			FrIta.put("Maison", "Casa");
			
			HashMap FrEsp = new HashMap();
			FrEsp.put("Glace", "Helado");
			FrEsp.put("Maison", "Casa");
			
			HashMap grandDico = new HashMap();
			grandDico.put("ESPAGNOL", FrEsp);
			grandDico.put("ANGLAIS", FrAng);
			grandDico.put("ITALIEN",FrIta);
			
			
			Traducteur.init(grandDico);	
			
			Tests.Case("Methode TraductionMultilangue");{
            	
				Tests.Unit("{ESPAGNOL=Casa ITALIEN=Casa ANGLAIS=House }", Traducteur.TraductionMultilangue("Maison") );

         	}
		

      Tests.End();
         }
	}
}
