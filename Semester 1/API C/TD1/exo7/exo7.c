/************************
**********TD1-exo7.c*****
*************************/

#include <stdio.h>

void main()
{
    //declaration
    int euro;
    int le500=0;
    int le200=0;
    int le100=0;
    int le50=0;
    int le20=0;
    int le10=0;
    int le5=0;
    
    //saisi
    printf("saisir une somme en euro sans centimes : \n");
    scanf("%d", &euro);
    
    //traitement
    le500=euro/500;
    le200=(euro-le500*500)/200;
    le100=(euro-le500*500-le200*200)/100;
    le50=(euro-le500*500-le200*200-le100*100)/50;
    le20=(euro-le500*500-le200*200-le100*100-le50*50)/20;
    le10=(euro-le500*500-le200*200-le100*100-le50*50-le20*20)/10;
    le5=(euro-le500*500-le200*200-le100*100-le50*50-le20*20-le10*10)/5;
    
    //affichage du resultat
    printf("le nombre(minimal) de billet necessaires pour : \n");
    printf("%d euro :\n%d de 500,\n%d de 200,\n%d de 100,\n%d de 50,\n%d de 20,\n%d de 10,\n%d de 5", euro,le500,le200,le100,le50,le20,le10,le5);
}