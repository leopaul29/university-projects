/************************
**********TD1-exo4.c*****
*************************/

#include <stdio.h>

void main()
{
    //declaration
    int lasec;
    int sec=0;
    int heur=0;
    int min=0;
    
    //saisi
    printf("Saisir le nombre de seconde : ");
    scanf("%d", &lasec);
    
    //traitement
    heur=lasec/3600;
    min=(lasec-heur*3600)/60;
    sec=(lasec-heur*3600-min*60);
    
    //affichage du resultat
    printf("la convertion en heures,minutes,seconde de : ");
    printf("%d seconde :\n%d d'heures,\n%d de minutes,\n%d de seconde",lasec,heur,min,sec);
}