// fonction.c

#include <stdio.h>

int Date ( int unJ, int unM, int uneA, int unJj, int unMj, int uneAj)
{
	int leJ,leM,laA,leJj,leMj,laAj;
	/*
	if ( laA > laAj-18 || laA < laAj-60)
		return 1;
	else
		return 0;

	if (laA == laAj-18)
		if (leM < leMj)
			if (leJ < leJj)
				return 1;
			else
				return 0;
		else
			return 0;

	if (laA == laAj-64)
		if (leM < leMj)
			if (leJ < leJj)
				return 1;
			else
				return 0;
		else
			return 0;

	*/
	
	

	if (laA < laAj-60 || laA > laAj-18)
		if (leM < leMj || leM > leMj)
			if (leJ < leJj || leJ> leJj)
				return 0;
			else
				return 1;
		else
			return 1;
	else
		return 1;
}