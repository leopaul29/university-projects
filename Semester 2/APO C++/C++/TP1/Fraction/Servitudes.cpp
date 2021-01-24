//
// IUT de Nice / Departement informatique / Module APO-C++
// Annee 2009_2010 - Package _Maths
//
// Fonctions de servitudes PGCD et PPCM
//
// Auteur : A. Thuaire
//
#include "Servitudes.h"
// --- Calcul du PGCD de deux nombres entiers positifs
//
int PGCD(int n, int m) {

   // Traiter le cas de nombres invalides
   //
   if (n<=0 || m<=0) return -1;

   // Traiter le cas particulier de l'identite
   //
   if (n==1 || m==1) return 1;

   // Traiter le cas particulier de nombres egaux
   //
   if (n==m) return n;

   // Traiter le cas general
   //
   if (n>m) return PGCD(n-m,m);
   else return PGCD(n,m-n);
}

// --- Calcul du PPCM de deux nombres entiers positifs
//
int PPCM(int n, int m) {

   // Traiter le cas de nombres invalides
   //
   if (n<=0 || m<=0) return -1;

   // Traiter le cas general
   //
   return n*m/PGCD(n,m);
}
