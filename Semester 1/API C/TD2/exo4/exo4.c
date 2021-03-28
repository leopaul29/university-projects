/************************
**********TD2-exo4.c*****
*************************/

#include <stdio.h>

void main()
{
    //declaration
    int leNb;
    
    //saisi
    printf("saisir un nomber entier : ");
    scanf("%d", &leNb);
    
    //test
    if((leNb>0)&&(leNb%2==0))
       {
           printf("le nombre %d est pair et positif", leNb);
       }
    else
       {
           printf("le nombre %d est impair ou negatif", leNb);
       }
}