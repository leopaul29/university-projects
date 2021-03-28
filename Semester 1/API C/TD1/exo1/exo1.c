/************************
**********TD1-exo1.c*****
*************************/

#include <stdio.h>
#define TVA 0,196

void main()
{
    //declaration
    float PrixHT;
    float PrixTTC;
        
    //saisi d'une valeur pour le prix HT
    printf("saisir un prix HT : ");
    scanf("%f", &PrixHT);
    
    //traitement
    PrixTTC = PrixHT * ( 1 + TVA );
    
    //affichage
    printf("Le Prix TTC de %f € est : %f €\n", PrixHT,PrixTTC);
}