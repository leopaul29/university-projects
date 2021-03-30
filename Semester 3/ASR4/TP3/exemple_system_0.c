/***********************************************************************\
   exemple_system

 Programme d'exemple du livre "Developpement systeme en C sous Linux"

 (c) 2000,2005 - Christophe Blaess

 \***********************************************************************/

#include <stdio.h>
#include <stdlib.h>

int main(void) {

	system("ls");
	printf("On a fini ls\n");
	return 0;
}
