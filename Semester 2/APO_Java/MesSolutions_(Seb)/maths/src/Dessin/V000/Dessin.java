package Dessin.V000;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import Math.Geometrie.FormGeo.V000.*;


@SuppressWarnings("unchecked")

public class Dessin {
	
	final static String CREATION = new String("Création");
	final static String AJOUT = new String ("Ajout");
	final static String SUPPRESSION = new String ("Suppression");
	final static String TRANSLATION = new String ("Translation");
	

	protected LinkedHashMap m_historique;
	protected ArrayList m_formes;
	
	
	
	//										Constructeur
	
	

	public Dessin ()
	{
		this.m_historique = new LinkedHashMap();
		this.m_formes = new ArrayList();
		this.m_historique.put(new Date(), CREATION);
	}
	
	

	public Dessin ( FormeGeo geo)
	{
		m_formes.add(geo);
		m_historique.put(new Date(), CREATION + " + " + AJOUT + " de " + geo.toString());
	}
	
	
	//										Accesseur
	
	
	public ArrayList<FormeGeo> getFormes (){ return this.m_formes; }
	
	public HashMap<Date, String> getHistorique () { return this.m_historique;}
	
	public FormeGeo get (int indice){ return (FormeGeo)this.m_formes.get(indice); }
	
	public void add (FormeGeo form)
	{
		this.m_formes.add(form);
		m_historique.put(new Date(), AJOUT+ " de " + form.toString());
		
	}
	
	
	public void remove (int indice){ 
		m_historique.put(new Date(), SUPPRESSION+ " de " + this.m_formes.get(indice).toString());
		this.m_formes.remove(indice);
	}
	
	
	
	//											Methode translation
	public void translation (double dx, double dy)
	{
		Iterator i = this.m_formes.iterator();
		FormeGeo form = null;
		
		while (i.hasNext())
		{
			form = (FormeGeo)i.next();
			form.translation(dx, dy);
		}
	}
	
	

}
