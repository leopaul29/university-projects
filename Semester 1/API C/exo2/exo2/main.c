/*********************
********TD5.exo2******
**********************/

#include <stdio.h>
#include "fonction.h"

void main()
{
	//D�claration
	int n;

	//Saisie pour la multiplication
	printf("Saisir un nombre entier dont vous souhaitez afficher la table de multiplication : ");
	scanf("%d", &n);
	fflush(stdin);
	
	//Appel de fonction
	AfficherTable (n);

	getch();
}