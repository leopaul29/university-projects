#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char * argv[])
{
	struct stat s;
	int i;
	int n;
int BUFFSIZE=atoi(argv[1]);
	char buf[BUFFSIZE];
	char nom[256];
	if(argc < 3) {
		printf("Pas assez d'argument\n");
		exit(1);
	}
	for(i =1; i < argc;i++){
		printf("%s\n", argv[i]);
  	}

	//fopen(foo,foo);
	/*open newfile -> read file + ecrire la lecture dans le newfile jusqu'a n octet*/

	while ((n = read(STDIN_FILENO, buf, BUFFSIZE)) > 0){
		if (write(STDOUT_FILENO, buf, n) != n)
			write(STDERR_FILENO,"write error\n",12);
	}
	if (n < 0)
		write(STDERR_FILENO,"read error\n",11);
	exit(0);
	
}
