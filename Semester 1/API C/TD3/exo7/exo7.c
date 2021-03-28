/*******************
*****TD3-exo7.c*****
********************/

#include <stdio.h>

void main()
{
    //declaration
    int leNb;
    float i=0;
    
    //saisi
    printf("saisir un nombre : ");
    scanf("%d", &leNb);
    
    //traitement
    do
    {
        i+=0.00001;
    }
    while(i*i<=leNb);
        
    //affichage du resultat
    printf("la racine carre du nombre %d a 1 pres est %.0f\n",leNb,i);
    printf("la racine carre du nombre %d a 0,1 pres est %.1f\n",leNb,i);
    printf("la racine carre du nombre %d a 0,00001 pres est %.5f\n",leNb,i);
}