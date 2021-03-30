/*
	Programme équivalent à echo $PATH (ou toute autre variable)

	$ gcc getenv.c
	./a.out PATH

	/usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games

*/
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]) 
{
  if (argc != 2)
  { 
	fprintf (stderr, "Syntaxe : %s <nom-de-variable>\n", argv[0]); 
	exit (1); 
  }
  printf ("\n%s\n\n", getenv (argv[1]));
  return EXIT_SUCCESS;
}
 
