/*******************
*****TD3-exo4.c*****
********************/

#include <stdio.h>

void main()
{
    int leNb;
    int leDiv=2;
    
    do
    {
        printf("saisir un nombre (superieur ou egale à 2 !) :\n");
        scanf("%d", &leNb);
    }while(leNb<2);
    
    while(leNb%leDiv!=0)
    {
        leDiv++;
    }
    printf("le plus petit diviseur de %d est : %d",leNb,leDiv);
}