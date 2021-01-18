/**
 * @(#)T_Traducteur_N1.java
 *
 *
 * @author 
 * @version 1.00 2013/5/3
 */
import java.util.*;
import collections.*;

public class T_Traducteur_N1 {

    public static void main(String[] args)throws Exception{
    	
    	Tests.Begin("Traducteur","V0.0.0");
    	
    		Tests.Design("opération de base",3);
    		
    			Tests.Case("toutes méthodes");{
    				
    				HashMap dictionnaire = new HashMap();
    				dictionnaire.put("maison","house");
    				dictionnaire.put("voiture","car");
    				
    				try{
    					Traducteur.init(dictionnaire);
    				}catch(Exception e){}
    				
    				Tests.Unit("house", Traducteur.traduire("maison"));
    				
    			}
    	Tests.End();
    }
    
}