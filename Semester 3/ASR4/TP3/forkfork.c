/*
 * forkfork.c
 * Ce programme illustre le mecanisme de duplication d'images sous UNIX
 *
 *  Created on: 26 oct. 2010
 *      Author: michel
 */

#include <stdio.h>
main() {
	int res;
	res = fork();
	sleep(3);
	printf("Resultat : %d, %d, %d\n", res, getpid(), getppid());
	res = fork();
	sleep(1);
	printf("Resultat : %d, %d, %d\n", res, getpid(), getppid());
	sleep(6);
}
/*
 [syska@linserv1 TPASR4_4]$ ps
 PID TTY          TIME CMD
 1124 pts/0    00:00:01 usershell
 5272 pts/0    00:00:00 ps
 [syska@linserv1 TPASR4_4]$ ./demo_forkbis
 Resultat : 0, 5275, 5274
 Resultat : 0, 5276, 5275
 Resultat : 5275, 5274, 1124
 Resultat : 5276, 5275, 5274
 Resultat : 0, 5277, 5274
 Resultat : 5277, 5274, 1124
 */
