// fonction.C

#include <stdio.h>
#include "fonction.h"

char Maj (char unC)
{
	char leC;
	leC = 'A'-'a'+unC;
	return leC;
}