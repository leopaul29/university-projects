/*
 * waitstatus.c
 *
 *  Creation : 26 oct. 2010
 *  Modification : 07 mars. 2012
 *  Author: ASR4
 */

/*
 bash-3.1$ ./waitstatus 8
 pid = 1897, ppid = 1896, reswait = 1897 status = 8
 bash-3.1$
 */
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
	pid_t pid;
	pid_t reswait;
	int status;

	if ((pid = fork()) < 0)
		fprintf(stderr, "fork error");
	else if (pid == 0) { /* child */
		sleep(2);
		exit(atoi(argv[1]));
	} else {
		sleep(2); /* parent */
		reswait = wait(&status);
		if (WIFEXITED(status))
		  printf("pid = %d, getpid = %d, reswait = %d status = %d\n", pid, getpid(), reswait, WEXITSTATUS(status));
	}

	return EXIT_SUCCESS;
}

