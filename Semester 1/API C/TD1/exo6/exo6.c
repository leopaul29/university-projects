/************************
**********TD1-exo6.c*****
*************************/

#include <stdio.h>

void main()
{
    //declaration
    float laDist;
    float laConsom;
    float laConsom100;
    float lePrixEss;
    float leCoutCarb;
    
    //saisi
    printf("Saisir la distance du voyage en kilometre : ");
    scanf("%f", &laDist);
    printf("Saisir la consomation en litre au 100km en carburant du vehicule : ");
    scanf("%f", &laConsom);
    printf("Saisir le prix du litre de carburant : ");
    scanf("%f", &lePrixEss);
    
    //traitement
    laConsom100=laConsom/100;
    leCoutCarb=laDist*laConsom100*lePrixEss;
    
    //affichage du resultat
    printf("le cout du carburant pour le voyage est de : %f",leCoutCarb);
}