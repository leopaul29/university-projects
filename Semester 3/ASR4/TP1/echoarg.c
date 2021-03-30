/*
	echoarg.c
	gcc echoarg.c
	./a.out un deux trois
*/
#include <stdio.h>
int main(int argc, char * argv[]){
	int i;
	for (i=1; i< argc; i++) {
		printf("argument %d: %s\n",i,argv[i]);
	}
	return 0;
}
