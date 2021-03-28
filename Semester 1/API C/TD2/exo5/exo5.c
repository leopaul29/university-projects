/************************
**********TD2-exo5.c*****
*************************/

#include <stdio.h>

void main()
{
    //declaration
    int lan;
    
    //saisi
    printf("saisir une année : ");
    scanf("%d", &lan);
    
    //traitement
    if (((lan%400==0)||(lan%4==0))&&(lan%100!=0))
    {
        printf("l'année est bissextile");
    }
    else
    {
        printf("l'année n'est pas bissextile");
    }
}