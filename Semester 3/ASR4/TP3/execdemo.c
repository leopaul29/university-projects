/*
 * execdemo.c
 *  - Reservation de la place max des arguments (20 car.),
 *  - lecture du nom de la commande a executer,
 *  - lecture d'un parametre obligatoire,
 *  - execution (avec prise en compte de la variable PATH).
 *
 *  Created on: 26 oct. 2010
 *      Author: michel
 */
#include <stdio.h>
#include <stdlib.h>

main() {
	char *argv[3];
	argv[0] = (char*) malloc(30);
	argv[1] = (char*) malloc(30);
	printf("Nom de la commande a executer : ");
	scanf("%s", argv[0]);
	printf("Un argument (obligatoire)     : ");
	scanf("%s", argv[1]);
	argv[2] = (char*) 0;
	execvp(argv[0], argv);
	printf("\nERREUR : execvp impossible\n");
}
