/************************
**********TD2-exo3.c*****
*************************/


#include <stdio.h>

void main()
{
    //declaration
    int leD1,leD2; //variable entrant
    int leN1,leN2; //variable entrant
    float lePrix1,lePrix2; //variable entrant
    float leRap1,leRap2; //variable de travail
    
    //saisi
    printf("Numero pizza 1 : ");
    scanf("%d", &leN1);
    printf("Diametre : ");
    scanf("%d", &leD1);
    printf("Prix : \n");
    scanf("%f", &lePrix1);
    
    printf("Numero pizza 2 : ");
    scanf("%d", &leN2);
    printf("Diametre : ");
    scanf("%d", &leD2);
    printf("Prix : \n");
    scanf("%f", &lePrix2);
    
    //traitement
    leRap1=leD1/lePrix1;
    leRap2=leD2/lePrix2;
    
    //test et affichage du resultat
    if(leRap1==leRap2)
    {
        printf("meme rapport taille/prix \n");
    }
    else if (leRap1>leRap2)
    {
        printf("la pizza num %d a un meilleur rapport taille/prix que la pizza num %d", leN1,leN2);
    }
    else
    {
        printf("la pizza num %d a un meilleur rapport taille/prix que la pizza num %d", leN2,leN1);
    }
}