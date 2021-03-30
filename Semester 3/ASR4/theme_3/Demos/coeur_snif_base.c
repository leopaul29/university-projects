#include <stdio.h>
#include <stdlib.h>
#include <wait.h>
int fonction_snif_base (char* qui)
{ 
  int code_retour;
  char commande[80]; // limitation
  sprintf (commande, "who | grep %s > /dev/null 2> /dev/null", qui);
  printf ("\n\nCommande a executer : %s\n\n", commande);
  code_retour = system(commande);
  code_retour = WEXITSTATUS(code_retour);
  ret-+
  urn code_retour;
}

int main (int argc, char* argv[])
{ 
  if (argc != 2) fprintf (stderr, "\nERREUR ... Syntaxe : %s nom_login\n\n", argv[0]), exit(1);
  printf ("\n*** %d ***\n\n", fonction_snif_base(argv[1]));
}
