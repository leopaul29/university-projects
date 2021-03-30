/*
	demo_alarm.c : Utilisation du signal SIGALRM par alarm
	
[syska@linserv1 demos]$ gcc demo_alarm.c
[syska@linserv1 demos]$ ./a.out

Je m' endors

*** Signal SIGALRM recu ***
***** Je me reveille ******

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
	signal(SIGALRM,  rep_SIGALRM);
	printf ("\nJe m' endors  \n");
	res = alarm(5);
	for (;;);
}
