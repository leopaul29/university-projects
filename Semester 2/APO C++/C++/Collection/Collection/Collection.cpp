//Collection.cpp

#include <iostream>
#include <string>
#include <stdio.h>
#include "..\..\TP1\Fraction\Servitudes.h"
#include "..\..\TP1\Fraction\Fraction.h"
#include "Collection.h"
using namespace std;

// Constructeurs
Collection :: Collection()
{
	m_pElements = new Fraction[10];
	taille = 0;
}

// Constructeur de copie
Collection :: Collection(Collection&)
{
	m_pElements = new Fraction[50];
	taille = 50;
}

// Destructeur
Collection :: ~Collection() { delete m_pElements = new Fraction; delete taille = 0;}

// Retirer tout les elements
void vider()
{
	//for(int K=0;K<this->taille;K++) sprintf(delete m_pElements[K].toString());
	this = NULL;
}

//toString
char* Collection :: toString() {

    // Traiter le cas particulier d'une fraction nulle
    //
	char* resultat;
	resultat = new char[5+50*taille];
	if(resultat == NULL) throw -1;
	sprintf(resultat,"[");
	for(int K=0;K<taille;K++) sprintf(resultat,"%d/%d", m_pElements[K].toString());
	sprintf(resultat,"]");
	return resultat;
}

//permet d'ajouter une fraction dans la collection
Collection& operator += (const Fraction& f)
{
	char* resultat;
	resultat = new char[5+50+1*taille];
	if(resultat == null) throw -1;
	sprintf(resultat,"[");
	for(int K=0;K<taille;K++) sprintf(resultat + 1,f, m_pElements[K].toString());
	sprintf(resultat,"]");
	return resultat;
}

//permet de retirer une fraction dans la collection
Collection& operator += (const Fraction& f)
{
	char* resultat;
	resultat = new char[5+50+1*taille];
	if(resultat == null) throw -1;
	sprintf(resultat,"[");
	for(int K=0;K<taille;K++) sprintf(resultat - 1,f, m_pElements[K].toString());
	sprintf(resultat,"]");
	return resultat;
}