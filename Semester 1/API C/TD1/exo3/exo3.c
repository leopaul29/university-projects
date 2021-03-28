/************************
**********TD1-exo3.c*****
*************************/

#include <stdio.h>

void main()
{
    //declaration
    float laTempC;
    float laTempF;
    
    //initialisation
    printf("saisir la temperature en degre C : \n");
    scanf("%f", &laTempC);
    
    //traitement
    laTempF = ( 9 * laTempC / 5 ) + 32;
    
    // affichage du resultat
    printf("La temperature F est %f \n", laTempF);
}