package bibliotehque;

import java.util.Vector;
import bibliotehque.StockLivre;
import bibliotehque.Livre;

public class StockTotal {
	private int _m_nbLivreTotal;
	public Vector<StockLivre> _ensemble_de_Livre_empruntable = new Vector<StockLivre>();
	public Vector<StockLivre> _ensemble_de_livre_total = new Vector<StockLivre>();
	public Vector<Livre> _unnamed_Livre_ = new Vector<Livre>();

	public int getNbLivreTotal() {
		throw new UnsupportedOperationException();
	}

	public int getNbLivreTotalEmpruntable(Object aEmpruntable) {
		throw new UnsupportedOperationException();
	}
}