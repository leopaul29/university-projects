/************************
**********TD1-exo5.c*****
*************************/

#include <stdio.h>

void main()
{
    //declaration
    float PO1an,POauj,TI,POd1an,POd2an;
    
    //saisi
    printf("saisir le prix d'un objet il y a un an : \n");
    scanf("%f", &PO1an);
    printf("saisir le prix d'un objet aujourd'hui : \n");
    scanf("%f", &POauj);
    
    //traitement
    TI=(POauj-PO1an)/PO1an;
    POd1an=POauj*TI;
    POd2an=POd1an*TI;
    
    //affichage
    printf("le taux d'inflation est : %f \n",TI);
    printf("le taux d'inflation dans un an est : %f \n",POd1an);
    printf("le taux d'inflation dans deux ans est : %f \n",POd2an);
}