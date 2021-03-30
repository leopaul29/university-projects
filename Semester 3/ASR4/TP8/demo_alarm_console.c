/*
	demo_alarm.c : Utilisation du signal SIGALRM par alarm
*/
 
#include <stdio.h>
#include <signal.h>
#include <stdlib.h>

void rep_SIGALRM () { 
	printf ("\n*** Signal SIGALRM recu ***\n"); 
	printf ("***** Je me reveille ******\n");
	exit(0);
}

int main () { 
	int res;
	signal (SIGALRM,  rep_SIGALRM);
	printf ("\nJe m' endors\n");
	/* res = alarm (5); */
	/* kill -ALRM 31391 */
	for (;;) printf(".");
}
