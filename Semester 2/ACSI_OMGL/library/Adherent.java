package bibliotehque;

public class Adherent {
	private String _m_nom;
	private int _n_numID;
	public Date _unnamed_Date_;
	public ListeLivreEmprunté _livre_emprunté;
	public Empruntable _emprunter;
	public Empruntable _unnamed_Empruntable_;
	public Bibliotheque _rechercher;

	public boolean emprunterLivre(Object aEmpruntable) {
		throw new UnsupportedOperationException();
	}

	public Livre RechercherLivre(Object aString_titre) {
		throw new UnsupportedOperationException();
	}
}