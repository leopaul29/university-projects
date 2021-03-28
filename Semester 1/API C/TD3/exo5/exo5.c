/*******************
*****TD3-exo5.c*****
********************/

#include <stdio.h>

void main()
{
    int leNb;
    int leDiv;
    do
    {
        printf("saisir un nombre (superieur ou egale à 2 !) :\n");
        scanf("%d", &leNb);
    }while(leNb<2);
    
    leDiv=leNb-1;
    
    while(leNb%leDiv!=0)
    {
        leDiv--;
    }
    printf("le plus grand diviseur de %d est : %d",leNb,leDiv);
}