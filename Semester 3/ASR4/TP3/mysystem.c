/*
 * mysystem.c
 *
 *  Created on: 26 oct. 2010
 *      Author: michel
 */
/*

 Exemple de system et d'une implantation de system avec fork et exec

 */

#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>

int notre_system(char * commande) {
	char * argv[4];
	int retour;
	pid_t pid;

	if ((pid = fork()) < 0) {
		fprintf(stderr, "fork error");
		return -1;
	}
	if (pid == 0) { /* fils */
		argv[0] = "sh";
		argv[1] = "-c";
		argv[2] = commande;
		argv[3] = (char *) NULL;
		execv("/bin/sh", argv);
		/* execv a echoue */
		exit(127);
	}
	/* pere */
	while (waitpid(pid, &retour, 0) < 0)
		if (errno != EINTR)
			return -1;
	return retour;
}

int main(void) {
	int code = 0;
	code = system("ls");
	code = notre_system("ls");
	code = notre_system("who");
	exit(EXIT_SUCCESS);
}

