//
// IUT de Nice / Departement informatique / Module APO-C++
// Annee 2009_2010 - Charte des tests unitaires
//
// Classe Tests - Methodes de classe publiques
//
// Auteur : A. Thuaire
//
#include "Tests.h"

int  Tests::levelDesign;         // Numero d'ordre du test_design 
int  Tests::levelCase;           // Numero d'ordre du test_case
int  Tests::levelUnit;           // Numero d'ordre du test_unit
int  Tests::verboseLevel;        // Niveau courant de visualisation
int  Tests::statusDesign;        // CR du test_design courant
int  Tests::statusCase;          // CR de test_case courant
bool Tests::testBegin;           // Indicateur execution Begin
char Tests::designName[80];      // Nom du test design courant;
char Tests::caseName[80];        // Nom du test case courant

/*
 *
 * La methode Begin visualise la ligne d'entete du module de tests 
 * unitaires.
 * 
*/
void Tests::Begin (char* name, char* version) {
   visuEntete(name, version);	// Visualiser entete des tests
   testBegin=true;	            // Service Begin execute
}

/*
 *
 * La methode End visualise d'abord le compte rendu (CR) du dernier 
 * "test case" et/ou du dernier "test design" du module, en fonction 
 * du niveau de visualisation courant (attribut verboseLevel).
 *
 * Seuls les CR non nuls sont visualises.
 *
 * La methode End visualise ensuite la ligne de cloture du module de 
 * tests unitaires, si et seulement si ce dernier s'est termine 
 * globalement avec succes. Dans la charte, un "test design" (y compris
 * le dernier) n'est exécute que si le précédent se termine avec succes 
 * (CR=0).
 * 
*/

void Tests::End () {
char lastLine[]= "\n------------------------------------------------------------\n";
      
   // Visualiser le CR dernier test case et dernier test design
   //
   visuCR("Case"); visuCR("Design"); 
      
   // Visualiser la ligne de cloture des tests unitaires
   //
   if (statusDesign == 0) cout << lastLine << endl;
   else cout << endl;
      
   // Gerer le cas du dernier test design en anomalie
   //
   if (statusDesign != 0) exit(statusDesign);
}

/*
 *
 * La methode Design visualise d'abord le compte rendu (CR) du dernier 
 * "test case" et/ou du dernier "test design" exécutes, en fonction du 
 * niveau de visualisation courant (attribut verboseLevel).
 *
 * La methode renseigne ensuite les attributs du "test design" et le 
 * niveau requis de visualisation (second paramètre).
 *
 * La methode visualise pour terminer la ligne d'entete des "test 
 * design".
 * 
*/
void Tests::Design (char* name, int level) {
   	
   // Controler les conditions initiales requises par la charte
   //
   if (!valid("Begin")) exit(1);
      
   // Visualiser le CR du test case et du test design precedents
   //
   visuCR("Case"); visuCR("Design"); 
      
   // Controler que le status OK du test design precedent
   //
   if (statusDesign != 0) exit(1);

   // Initialiser les attributs du test design
   //
   levelCase   =0;
   statusCase  =0;
   statusDesign=0;
   strcpy(designName,name);
   levelDesign++;
      
   // Controler et affecter le nouveau niveau de visualisation
   //
   verboseLevel=level;
   if (level > 3) verboseLevel=3;
   if (level < 0) verboseLevel=0;
      
   // Visualiser la ligne d'entete du nouveau test design
   //   
   visuEntete(name);
}

/*
 *
 * La methode Case visualise d'abord le compte rendu (CR) du dernier
 * "test case" exécute, en fonction du niveau de visualisation courant 
 * (attribut verboseLevel).
 *
 * La methode renseigne ensuite les attributs du "test case".
 *
 * La methode visualise pour terminer la ligne d'entête des "test cases".
 * 
*/
void Tests::Case (char* name) {
      
   // Controler les conditions initiales requises par la charte
   //
   if (!valid("Begin") || !valid("Design"))  exit(1);

   // Visualiser le CR du dernier test case execute
   //  
   visuCR("Case");
      
   // Initialiser les attributs du nouveau test case
   // 
   strcpy(caseName, name);
   levelCase++;
      
   // Visualiser la ligne d'entete du nouveau test case
   //  
   visuEntete();
}
 
/*
 *
 * La methode Unit visualise d'abord les deux messages standard d'un 
 * test elementaire, en fonction du niveau de visualisation courant 
 * (attribut verboseLevel).
 *
 * La methode elabore pour terminer les CR du "test case" et du "test
 * design" courant. 
 *
*/ 
void Tests::Unit (int attendu, int obtenu) {
char bufferAttendu[20];
char bufferObtenu[20];

   // Controler les conditions initiales requises par la charte
   //
   if (!valid("Begin") || !valid("Design") || !valid("Case")) exit(1);
  
   // Visualiser les messages du test de plus niveau
   // 
   sprintf(bufferAttendu, "%d", attendu);
   sprintf(bufferObtenu, "%d", obtenu);

   visuUnit(bufferAttendu, bufferObtenu); 	  

   // Elaborer le CR du test case courant
   //  
   if (statusCase == 0 && obtenu != attendu) statusCase=levelCase;
   else statusCase=0;
      
   // Elaborer le CR du test design courant
   //  
   if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
}

void Tests::Unit (float attendu, float obtenu) {
char bufferAttendu[20];
char bufferObtenu[20];

   // Controler les conditions initiales requises par la charte
   //
   if (!valid("Begin") || !valid("Design") || !valid("Case")) exit(1);
  
   // Visualiser les messages du test de plus niveau
   // 
   sprintf(bufferAttendu, "%f", attendu);
   sprintf(bufferObtenu, "%f", obtenu);

   visuUnit(bufferAttendu, bufferObtenu); 	  

   // Elaborer le CR du test case courant
   //  
   if (statusCase == 0 && obtenu != attendu) statusCase=levelCase;
   else statusCase=0;
      
   // Elaborer le CR du test design courant
   //  
   if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
}

void Tests::Unit (char* attendu, char* obtenu) {

   // Controler les conditions initiales requises par la charte
   //
   if (!valid("Begin") || !valid("Design") || !valid("Case")) exit(1);
  
   // Visualiser les messages du test de plus niveau
   // 
   visuUnit(attendu, obtenu); 	  

   // Elaborer le CR du test case courant
   //  
   if (statusCase == 0 && strcmp(obtenu,attendu) != 0) statusCase=levelCase;
   else statusCase=0;
      
   // Elaborer le CR du test design courant
   //  
   if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
}

void Tests::Unit (double attendu, double obtenu) {
char bufferAttendu[20];
char bufferObtenu[20];

   // Controler les conditions initiales requises par la charte
   //
   if (!valid("Begin") || !valid("Design") || !valid("Case")) exit(1);
  
   // Visualiser les messages du test de plus niveau
   // 
   sprintf(bufferAttendu, "%lf", attendu);
   sprintf(bufferObtenu, "%lf", obtenu);

   visuUnit(bufferAttendu, bufferObtenu); 	  

   // Elaborer le CR du test case courant
   //  
   if (statusCase == 0 && obtenu != attendu) statusCase=levelCase;
   else statusCase=0;
      
   // Elaborer le CR du test design courant
   //  
   if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
}

void Tests::Unit (double attendu, double obtenu, double epsilon) {
char bufferAttendu[20];
char bufferObtenu[20];

   // Controler les conditions initiales requises par la charte
   //
   if (!valid("Begin") || !valid("Design") || !valid("Case")) exit(1);
  
   // Visualiser les messages du test de plus niveau
   // 
   sprintf(bufferAttendu, "%lg", attendu);
   sprintf(bufferObtenu, "%lg", obtenu);

   visuUnit(bufferAttendu, bufferObtenu); 	  

   // Elaborer le CR du test case courant
   //  
   if (statusCase == 0 && fabs(obtenu - attendu) > fabs(epsilon)) statusCase=levelCase;
   else statusCase=0;
      
   // Elaborer le CR du test design courant
   //  
   if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
}
