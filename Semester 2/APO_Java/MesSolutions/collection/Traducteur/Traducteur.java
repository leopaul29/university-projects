/**
 * @(#)Traducteur.java
 *
 *
 * @author 
 * @version 1.00 2013/5/3
 */
package collections;

import java.util.*;

public abstract class Traducteur {
    
    private static HashMap m_dico;
    
    
    public static void init(HashMap dico)throws Exception{
    	if(dico == null) throw new Exception();
    	m_dico=dico;
    }
    
    
    public static HashMap getDico(){
    	return m_dico;
    }
    
    public static String traduire(String mot){
    	return mot+" = "+m_dico.get(mot);
    }
    
    
    public static String inverse(String mot){
    	Iterator i = m_dico.keySet().iterator();
    	Object cle = i.next();
    	while (i.hasNext()){
    		if (m_dico.get(i).equals(mot))
    			return (String)cle;
    		else cle = i.next();
    	}
    	return "pas de traduction";
    }
    
}