/*
 * fork0.c
 * exemple_fork simple : pour comprendre la duplication de code
 *  Created on: 26 oct. 2010
 *  Author: ASR4
 */
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main(void) {
	pid_t pid;
	pid = fork();
	fprintf(stdout, "Pere ou fils ?: pid=%d, PID=%d, PPID=%d\n", pid, getpid(), getppid());
	exit(EXIT_SUCCESS);
}

