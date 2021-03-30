/*
 * forkwait.c
 *
 *  Created on: 26 oct. 2010
 *      Author: michel
 */
/*
 bash-3.1$ gcc forkwait.c -o forkwait
 bash-3.1$ ./forkwait
 pid = 0, ppid = 1886, reswait = 4440080
 pid = 1886, ppid = 1885, reswait = 1886
 bash-3.1$
 */

#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

int main(void) {
	pid_t pid;
	pid_t reswait;

	if ((pid = fork()) < 0)
		fprintf(stderr, "fork error");
	else if (pid == 0) { /* child */
		sleep(2);
	} else {
		sleep(2); /* parent */
		reswait = wait(NULL);
	}

	printf("pid = %d, getpid = %d, ppid = %d, reswait = %d\n", pid, getpid(), getppid(), reswait);
	exit(EXIT_SUCCESS);
}

