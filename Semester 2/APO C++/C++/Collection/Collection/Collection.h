//Collection.h

#include "..\..\TP1\Fraction\Fraction.h"
#include "stdafx.h"

class Collection
{
	protected :
		Fraction* m_pElements;
		int taille;

	public :

	// ------ Constructeurs et destructeur
	//
	Collection ();
	Collection(Collection&);
	~Collection();

	// ------ Predicats predefinis
	//
	bool neutre() const {return m_pElements != NULL && taille==0;}

	bool ok() const {return m_pElements != NULL;}
	bool nok() const {return !ok();}

	// ------ Surcharges d'operateurs

	//permet d'ajouter une fraction dans la collection
	Collection& operator += (const Fraction& f);

	//permet de retirer une fraction dans le conteneur
	Collection& operator -= (const Fraction& f);

	// ------ Services
	//
	// retire tous les éléments
	void vider();

	// retourne le nombre d'éléments
	int cardinal () const;
	char* toString ();

};

