/*******************
*****TD3-exo6.c*****
********************/

#include <stdio.h>

void main()
{
    int leNb;
    int leDiv;
    do
    {
        printf("saisir un nombre (superieur à 1) :\n");
        scanf("%d", &leNb);
    }while(leNb==0);
    
    leDiv=leNb-1;
    
    while(leNb%leDiv!=0)
    {
        leDiv--;
    }
    
    if(leDiv==1)
        printf("le nombre est un nombre premier\n");
    else
    {
        printf("le nombre n'est pas un nombre premier\n");
        printf("le diviseur le plus grand est : %d",leDiv);
    }
}