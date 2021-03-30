#include <stdio.h>  /*  */
#include <unistd.h> /* STDIN_FILENO ... */
#include <stdlib.h> /* exit */

int main(int argc, char * argv[]){
	
	int n;
	int BUFFSIZE=atoi(argv[1]);
	char buf[BUFFSIZE];
	
	while ((n = read(STDIN_FILENO, buf, BUFFSIZE)) > 0){
		if (write(STDOUT_FILENO, buf, n) != n)
			write(STDERR_FILENO,"write error\n",12);
	}
	if (n < 0)
		write(STDERR_FILENO,"read error\n",11);
	exit(0);
}
