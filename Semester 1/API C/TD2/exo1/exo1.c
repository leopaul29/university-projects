/************************
**********TD2-exo1.c*****
*************************/

#include <stdio.h>

void main()
{
    //declaration
    int leNb;
    
    //saisi
    printf("Saisir un  nombre entier : ");
    scanf("%d", &leNb);
    
    //traitement
    if(leNb>0)
    {
        printf("le nombre %d est positif",leNb);
    }
    else
    {
        if(leNb==0)
        {
            printf("le nombre %d est nul",leNb);
        }
        else
        {
            printf("le nombre %d est negatif",leNb);
        }
    }
}