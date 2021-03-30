/*
 * echoargenviron.c
 *
 *  Created on: 26 oct. 2010
 *  Author: asr4 from Stevens
 */

/* APUE Stevens */

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int i;
	char **ptr;
	extern char **environ; /* this is a Unixism;
	 according to Posix, it should be declared in <unistd.h>. See
	 http://www.unix.org/single_unix_specification
	 See also getenv()
	 */

	for (i = 0; i < argc; i++) /* echo all command-line args */
		printf("argv[%d]: %s\n", i, argv[i]);

	for (ptr = environ; *ptr != 0; ptr++) /* and all env strings */
		printf("%s\n", *ptr);

	exit(EXIT_SUCCESS);
}
