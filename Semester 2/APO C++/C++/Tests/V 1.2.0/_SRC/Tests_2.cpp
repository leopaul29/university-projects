//
// IUT de Nice / Departement informatique / Module APO-C++
// Annee 2009_2010 - Charte des tests unitaires
//
// Classe Tests - Methodes de classe privees (Lot 1)
//
// Auteur : A. Thuaire
//
#include "Tests.h"

/*
 *
 * La fonction privee valid verifie les conditions d'exécution du niveau 
 * de tests passé en paramètre.
 * 
*/
bool Tests::valid (char* level) {
char headText[]   = "\n*** Erreur fatale (Tests) : ";
char errorBegin[] = "Begin requis au prealable\n";
char errorDesign[]= "Design requis au prealable\n";
char errorCase[]  = "Case requis au prealable\n";
   
   // Controler l'execution prealable du service Begin
   //
   if (level=="Begin" && !testBegin) {
      cout << headText << errorBegin << endl;
      return false;
   }
      
   // Controler l'execution prealable du service Design
   //   
   if (level=="Design" && levelDesign == 0) {
      cout << headText << errorDesign << endl;
      return false;
   }
      
   // Controler l'execution prealable du service Case
   // 
   if (level == "Case" && levelCase == 0) {
      cout << headText << errorCase << endl;
      return false;
   }
      
   return true;  
}

/*
 *
 * La fonction privee visuCR visualise le compte rendu courant du niveau
 * de tests fourni en paramètre.
 * 
**/
void Tests::visuCR (char* level) {
char beginPartCase[]   ="     => CR= ";
char beginPartDesign[] = "=> CR= ";
char LF[]              = "\n";
   
   // Visualiser le CR du dernier test case execute
   //
   if (level == "Case" && levelCase > 0 && verboseLevel > 1 && statusCase != 0) {
      if (verboseLevel == 2) cout << beginPartCase << statusCase << LF;
      else cout << LF << beginPartCase << statusCase << LF;
   }  	
      
   // Visualiser le CR du dernier test design execute
   //
   if (level == "Design" && verboseLevel > 0 && statusDesign != 0) {
      if (verboseLevel == 1 && statusDesign != 0) {
         cout << beginPartDesign << statusDesign << LF;
      }
      else cout << LF << beginPartDesign << statusDesign << LF;
   }
}
