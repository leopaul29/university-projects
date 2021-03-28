/*******************
*****TD4-exo1.c*****
********************/

#include <stdio.h>
#include "fonction.h"

void main()
{
    int s,a=0,b=0,c=0;
    s=hms(a,b,c);
    printf("saisir un nombre d'heure : ");
    scanf("%d", &a);
    printf("saisir un nombre de minute : ");
    scanf("%d", &b);
    printf("saisir un nombre de seconde : ");
    scanf("%d", &c);
    printf("la durée saisi equivaut a %d seconde",hms(a,b,c));
}