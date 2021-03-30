/*
	Programme équivalent à echo $PATH (ou toute autre variable)

	$ gcc getenv.c
	./a.out PATH

	/usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games

*/
#include <stdio.h>
#include <stdlib.h>

int main(int argc,  char * argv[]) 
{

  int i;
  int resultat = 0;
  int entier = 0;

  printf("La somme des nombres : ");

  for(i =1; i < argc;i++){
	entier = atoi(argv[i]);
	printf("%d ", entier);
	resultat += entier;
  }

  printf("est : %d\n", resultat);

  return EXIT_SUCCESS;
}
 
