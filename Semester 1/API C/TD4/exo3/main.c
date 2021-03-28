/*******************
*****TD4-exo3.c*****
********************/

#include <stdio.h>
#include "fonction.h"

int main()
{
    int lalong,lalarg;
    
    printf("saisir une longueur : ");
    scanf("%d", &lalong);
    printf("saisir une largeur : ");
    scanf("%d", &lalarg);
    
    printf("la surface du rectangle est : %d",surface(lalarg,lalong));
}