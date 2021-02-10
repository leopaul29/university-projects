import java.net.InetAddress;


public class EXO1 {
	private String m_site;
	
	
	public InetAddress IPSiteWeb(String url){
		InetAddress adrServeur = null;
		
		try	{adrServeur = InetAddress.getByName(url);}
		catch (Exception e) {e.printStackTrace(); }
		
		
		
		return adrServeur;
	}
}
