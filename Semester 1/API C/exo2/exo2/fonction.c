// fonction.c

#include <stdio.h>
#include "fonction.h"

void AfficherTable ( int unN )
{
	int i;
	for (i=1;i<=10;i++)
	{
		printf("%d * %d = %d\n",i,unN,i*unN);
	}
}

