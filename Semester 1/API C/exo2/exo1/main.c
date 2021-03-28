/*********************
********TD5.exo1******
**********************/

#include <stdio.h>
#include "fonction.h"

void main()
{
	//Déclaration
	int leJ,leM,laA;
	int leJj,leMj,laAj;

	//Saisie de l'année de naissance
	printf("Saisir votre date de naissance sous la forme (JJ/MM/AAAA) :\n");
	printf("Jour : ");scanf("%d", &leJ);
	printf("Mois : ");scanf("%d", &leM);
	printf("Annee : ");scanf("%d", &laA);
	printf("\n\n");

	printf("Saisir la date d'ojourd'hui : \n");
	printf("Jour : ");scanf("%d", &leJj);
	printf("Mois : ");scanf("%d", &leMj);
	printf("Annee : ");scanf("%d", &laAj);
	printf("\n\n");

	//Appel de la fonction
	if (Date == 1)
		printf("La réduction est accordee");
	else
		printf("La réduction n'est pas accordee");

	getch();
}