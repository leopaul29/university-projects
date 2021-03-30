/*
  fork1.c
  APUE 

bash-3.1$ gcc fork1.c -o fork1
bash-3.1$ ./fork1
a write to stdout
before fork
pid = 28851, glob = 7, var = 89
pid = 28851
pid = 28850, glob = 6, var = 88
bash-3.1$
*/
    
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

int	glob = 6;		/* external variable in initialized data */
char	buf[] = "a write to stdout\n";

int main(void) {
	int	var;		/* automatic variable on the stack */
	pid_t	pid;

	var = 88;
	if (write(STDOUT_FILENO, buf, sizeof(buf)-1) != sizeof(buf)-1)
	  fprintf(stderr,"write error");
	printf("before fork\n");	/* we don't flush stdout */

	if ( (pid = fork()) < 0)
		fprintf(stderr,"fork error");
	else if (pid == 0) {		/* child */
		glob++;			/* modify variables */
		var++;
	} else {
		printf("pid = %d\n",pid);
		sleep(2);				/* parent */
	}
	printf("pid = %d, glob = %d, var = %d\n", getpid(), glob, var);
	return EXIT_SUCCESS;
}
