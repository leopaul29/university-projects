//
// IUT de Nice / Departement informatique / Module APO-C++
// Annee 2009_2010 - Charte des tests unitaires
//
// Classe Tests - Methodes de classe privees (Lot 2)
//
// Auteur : A. Thuaire
//
#include "Tests.h"

/*
 *
 * La fonction privee visuEntete visualise la ligne d'entete du niveau
 * de description fixe par sa signature, en fonction du niveau de 
 * visualisation courant (attribut verboseLevel).
 * 
**/
void Tests::visuEntete (char* name, char* version) {
char beginPart[]  = "\n--- Tests unitaires de la classe ";
char versionPart[]= " - Version ";
char endPart[]    = " ---\n\n";
      
      cout << beginPart;
      cout << name << versionPart << version;
      cout << endPart;
}
  
void Tests::visuEntete (char* name) {
char beginPart[] = "\n** [";
char endPart[]   = "]\n";
   
   if (verboseLevel > 0) cout << beginPart << name << endPart;
}
   
void Tests::visuEntete () {
char beginPart[] = "\n   + (";
char endPart[]   = ")\n";
   
      if (verboseLevel > 1) cout << beginPart << caseName << endPart;
}

void Tests::visuUnit (char* attendu, char* obtenu) {
char beginPart[] = "\n     Valeur attendue : ";
char middlePart[]= "\n     Valeur obtenue  : ";
char LF[]        = "\n";
   
   if (verboseLevel > 2) {
      cout << beginPart << attendu;
      cout << middlePart << obtenu << LF;
   }
}
   
   
