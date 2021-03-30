#include <stdio.h>
#include <stdlib.h>
#include <strings.h>

int main (int argc, char* argv[])
{ 
  char buffer [80];
  if (argc != 2) fprintf (stderr, "\nERREUR ... Syntaxe : %s nom_login\n\n", argv[0]), exit(1);
  
  bzero (buffer, 80); // les '\0' sur 80 caracteres !!
  sprintf (buffer, "%s OUI",argv[1]);
  printf ("*%s*\n", buffer);
}
