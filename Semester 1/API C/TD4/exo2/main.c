/*******************
*****TD4-exo2.c*****
********************/

#include <stdio.h>
#include "fonction.h"

void main()
{
    int leA;
    int leB;
    
    printf("saisir 2 nombre :\n");
    printf("le 1er : ");
    scanf("%d", &leA);
    printf("le 2eme : ");
    scanf("%d", &leB);
    
    printf("calcul(%d,%d)=%d\n",leA,leB,calcul(leA,leB));
}