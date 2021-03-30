#include <stdio.h>
#include <stdlib.h>
#include <wait.h>
int fonction_snif_ssh (char* machine, char* qui)
{ 
  int code_retour;
  char commande[80]; // limitation
  sprintf (commande, "ssh %s \"who | grep %s > /dev/null 2> /dev/null \"", machine, qui);
  printf ("\n\nCommande a executer : %s\n\n", commande);
  code_retour = system(commande);
  code_retour = WEXITSTATUS(code_retour);
  return code_retour;
}

int main (int argc, char* argv[])
{ 
  if (argc != 3) {
     fprintf (stderr, "\nERREUR ... Syntaxe : %s nom_machine nom_login\n\n", argv[0]);
     exit(1);
   }
  printf ("\n*** %d ***\n\n", fonction_snif_ssh(argv[1], argv[2]));
}
