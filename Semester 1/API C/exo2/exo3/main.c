/*********************
********TD5.exo3******
**********************/

#include <stdio.h>
#include "fonction.h"

void main()
{
	//Déclaration
	int n;

	//Saisie pour nombre pair
	printf("Saisir un nombre entier dont vous souhaitez savoir si il est pair ou non : ");
	scanf("%d", &n);
	
	//Appel de fonction
	if ( Pair(n) == VRAI )
		printf("\n %d est pair",n);
	else
		printf("\n %d est impair",n);

	getch();
}