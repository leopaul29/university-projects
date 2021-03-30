package bibliotehque;

import java.util.Vector;
import bibliotehque.StockTotal;

public class StockLivre {
	private int _m_nbExemplaire;
	private int _m_emprunté;
	public Livre _unnamed_Livre_;
	public Livre _unnamed_Livre_2;
	public Gérant _ajouter_un_exemplaire;
	public StockTotal _ensemble_de_livre_total;
	public Livre _unnamed_Livre_3;
	public Livre _unnamed_Livre_4;
	public Livre _nombre_d_exemplaire;
	public Vector<StockTotal> _ensemble_de_Livre_empruntable = new Vector<StockTotal>();

	public int getNbExemplaire() {
		throw new UnsupportedOperationException();
	}

	public int getNbExEmpruntable(Object aEmpruntable) {
		throw new UnsupportedOperationException();
	}

	public int getEmprunte() {
		throw new UnsupportedOperationException();
	}
}