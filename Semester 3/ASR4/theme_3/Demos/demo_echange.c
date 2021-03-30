#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>

int main (int argc, char* argv[])
{ 
  char buffer [80];
  if (argc != 2) fprintf (stderr, "\nERREUR ... Syntaxe : %s chaine\n\n", argv[0]), exit(1);
  bzero (buffer, 80);
  strcpy (buffer, argv[1]);
  printf ("\nBuffer a envoyer ou a recevoir : %s\n\n", buffer);
}
