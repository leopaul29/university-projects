/*******************
*****TD4-exo3.c*****
********************/

#include <stdio.h>
#include <math.h>
#include "fonction.h"

int main()
{
    //delcaration
    int leA,leB;
    char leChoix;
    
    //Menu
    printf("Menu:\n");
    printf("1 - puissance\n");
    printf("2 - multiple\n");
    printf("3 - factorielle\n");
    printf("4 - PGCD\n");
    printf("5 - premier\n");
    printf("6 - fibo\n");
    
    //Saisir un choix
    printf("\nVotre choix: ");
    leChoix = getchar();
    
    //liste des choix et appel des fonctions
    switch (leChoix)
    {
        case '1':
            //fonction puissance
            //saisi
            printf("saisir un premier nombre : ");
            scanf("%d", &leA);
            printf("saisir un deuxieme nombre : ");
            scanf("%d", &leB);
            printf("\n");
            //affichage
            printf("le nombre %d a la puissance %d est : %d\n",leA,leB,puissance(leA,leB));
            printf("\n");
            break;
            
        case '2':
            //fonction multiple
            //saisi
            printf("saisir un premier nombre : ");
            scanf("%d", &leA);
            printf("saisir un deuxieme nombre : ");
            scanf("%d", &leB);
            printf("\n");
            //affichage
            printf("le nombre %d est un multiple de %d (Vrai=1 Faux=0)\n",leA,leB);
            printf("%d",multiple(leA,leB));
            printf("\n");
            break;
            
        case '3':
            //fonction factorielle
            //saisi
            printf("saisir un premier nombre : ");
            scanf("%d", &leA);
            //affichage
            printf("le factorielle du nombre %d est : %d",leA,fact(leA));
            break;
            
        case '4':
            //fonction PGCD
            //saisi
            printf("saisir un premier nombre : ");
            scanf("%d", &leA);
            printf("saisir un deuxieme nombre : ");
            scanf("%d", &leB);
            //affichage
            printf("le PGCD de %d et %d est : %d",leA,leB,PGCD(leA, leB));
            break;
            
        case '5':
            //fonction premier
            //saisi
            printf("saisir un premier nombre : ");
            scanf("%d", &leA);
            //affichage
            printf("le nombre est premier ? (VRAI=1 FAUX=0)\n");
            printf("%d",premier(leA));
            break;
            
        case '6':
            //fonction fibo
            //saisi
            printf("Quel nombre x de la suite voulez vous ? ");
            scanf("%d", &leA);
            //affichage
            printf("Voici le %d eme nombre de la suite : %lf \n",leA,fibo(leA));
            break;
            
        default: printf("\nCe choix n'est pas prevu ");
    }
}