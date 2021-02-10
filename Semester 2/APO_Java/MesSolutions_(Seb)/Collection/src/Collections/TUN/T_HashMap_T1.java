// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2012_2013 - Package Collections
//
// Classe Test Unitaire T1 
// version V0.0.0
// Auteur : N. Sebou & Cie
//

package Collections.TUN;
import java.util.HashMap;

import Collections.Teste.*;
import CollectionsV000.*;

@SuppressWarnings("rawtypes")
public class T_HashMap_T1 {

@SuppressWarnings("unchecked")
public static void main (String[] args) throws Exception {

      Tests.Begin("Collection", "0.0.0");

         Tests.Design("Teste Unitaire", 3); {
        	 
        	HashMap dico = new HashMap<>();
			dico.put("Bouche", "Mouse");
			dico.put("Visage", "Face");
				
			
			Tests.Case("Methode getDico");{
            	
				Traducteur.init(dico);
				HashMap dico1 = Traducteur.getDico();
				
				Tests.Unit("Mouse",dico1.get("Bouche") );
				Tests.Unit("Face",dico1.get("Visage") );

         	}
			
			Tests.Case("Methode Traduire");{
            	
				Traducteur.init(dico);
				
				Tests.Unit("Mouse",Traducteur.traduire("Bouche") );
				Tests.Unit("Face",Traducteur.traduire("Visage") );

         	}
         
         	Tests.Case("Methode invrese");{
     	
         		Traducteur.init(dico);
			
         		Tests.Unit("Bouche",Traducteur.inverse("Mouse") );
         		Tests.Unit("Visage",Traducteur.inverse("Face") );
         		
			}

      Tests.End();
         }
	}
}
