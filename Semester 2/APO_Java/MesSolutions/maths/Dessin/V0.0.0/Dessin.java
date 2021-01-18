/**
 * @(#)Dessin.java
 *
 *
 * @author 
 * @version 1.00 2013/5/3
 */
package maths;

import maths.geometrie.*;
import java.util.*;

public class Dessin {
	
	private LinkedHashMap m_historiqueModifs;
	private ArrayList m_formes;

	// ---											Constructeur par defaut

    public Dessin() {
    	m_historiqueModifs = new LinkedHashMap();
    	m_formes = new ArrayList();
    	Date dates = new Date();
    	String date = dates.toString()+" "+dates.getHours()+":"+dates.getMinutes()+":"+dates.getSeconds();
    	m_historiqueModifs.put(date, " =  Création");
    	
    }

    // ---											Premier constructeur
    
    public Dessin(FormeGeo parameter){
    	m_historiqueModifs = new LinkedHashMap();
    	m_formes = new ArrayList();
    	m_formes.add(parameter);
    	Date dates = new Date();
    	String date = dates.toString()+" "+dates.getHours()+":"+dates.getMinutes()+":"+dates.getSeconds();
    	m_historiqueModifs.put(date, " =  Création");
    	
    }

    // ---											Accesseurs Forme et Historique

    public ArrayList getFormes(){return m_formes;}
    public LinkedHashMap getHistorique(){return m_historiqueModifs;}
    public FormeGeo get(int parameter){return (FormeGeo)this.getFormes().get(parameter);}
    
    public void add(FormeGeo parameter){
    	this.getFormes().add(parameter);
    	Date dates = new Date();
    	String date = dates.toString()+" "+dates.getHours()+":"+dates.getMinutes()+":"+dates.getSeconds();
    	this.getHistorique().put(date," = ajout d'une forme de type maths.geometrie."+parameter);
    }
    
    public void remove(int parameter){
    	this.getFormes();
    }
    
    // ---											Translation du dessin
    
    public void translation(double a, double b) {}
    
    
}