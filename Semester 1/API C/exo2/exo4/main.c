/*********************
********TD5.exo4******
**********************/

#include <stdio.h>
#include "fonction.h"

void main()
{
	//Déclaration
	char leC;

	//Saisie
	printf("Saisir un caratere que vous voulez en majuscule : ");
	scanf("%c", &leC);

	//Appel de la fonction
	printf("%c", Maj(leC));

	getch();
}