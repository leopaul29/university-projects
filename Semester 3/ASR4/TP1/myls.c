/*
 * mysimplels.c
 *
 *  Created on: 26 oct. 2010
 *      Author: michel
 */
 
#include <stdio.h> /* pour stderr */
#include <sys/types.h>
#include <dirent.h>
#include <unistd.h> /* pour NULL */
#include <stdlib.h> /* pour exit */


int
main(int argc, char *argv[])
{
	DIR			*dp;
	struct dirent	*dirp;

	if (argc != 2){
	  fprintf(stderr,"a single argument (the directory name) is required\n");
	  exit(1);
	}

	if ( (dp = opendir(argv[1])) == NULL){
		printf("can't open %s\n", argv[1]);
		exit(2);
	}

	while ( (dirp = readdir(dp)) != NULL)
		printf("%s\n", dirp->d_name);

	closedir(dp);
	exit(EXIT_SUCCESS);
}
