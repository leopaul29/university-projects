//
// IUT de Nice / Departement informatique / Module APO-C++
// Annee 2009_2010 - Charte des tests unitaires
//
// Classe Tests : services pour la mise en oeuvre de la charte de
//                tests unitaires presentee en cours
//
// Edition A    : cours 5
//
//    + Version 1.0.0  : version initiale
//    + Version 1.1.0  : ajout d'une forme polymorphe de Unit pour
//                       traiter l'egalite de deux doubles avec une
//                       tolerance fournie parametre 
//
// Auteur : A. Thuaire
//

/*
 *
 * La classe Tests fournit un ensemble complet de services destinés à 
 * simplifier et à uniformiser la mise en oeuvre de la charte de 
 * réalisation des modules de tests unitaires exposée en cours. La 
 * classe est également utilisée en TD comme un exemple très concret 
 * de codes sources "écrits par d'autres".
 *
 * Les services fournis sont :
 *
 * Begin    : debut d'exécution des tests unitaires de la classe cible,
 * Design   : executer un "test design",
 * Case     : executer un "test case",
 * Unit     : executer un "test unit",
 * End      : fin d'execution des tests unitaires de la classe cible.
 *
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream.h>
#include <math.h>

class Tests {
private :
static int  levelDesign;         // Numero d'ordre du test_design 
static int  levelCase;           // Numero d'ordre du test_case
static int  levelUnit;           // Numero d'ordre du test_unit
static int  verboseLevel;        // Niveau courant de visualisation
static int  statusDesign;        // CR du test_design courant
static int  statusCase;          // CR de test_case courant
static bool testBegin;           // Indicateur execution Begin
static char designName[80];      // Nom du test design courant;
static char caseName[80];        // Nom du test case courant

static bool valid(char*);
static void visuCR(char*);

static void visuEntete(char*, char*);
static void visuEntete(char*);
static void visuEntete();

static void visuUnit(char*, char*);

public :

static void Begin(char*, char*);
static void Design(char*, int);
static void Case(char*);
static void Unit(int, int);
static void Unit(float, float);
static void Unit(char*, char*);
static void Unit(double, double);
static void Unit(double, double, double);
static void End();

virtual void verrouiller()= 0;

};


