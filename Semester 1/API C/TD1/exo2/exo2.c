/************************
**********TD1-exo2.c*****
*************************/

#include <stdio.h>
#define CAPA 8

void main()
{
    //declaration
    int leNbRadNecessaire; //variable de sortie
    int lalong,lalarg,lahaut; //variable d'entrée
    int leVolumepiece; //variable de travail
    
    //initialisation
    printf("Saisir la longueur : ");
    scanf("%d", &lalong);
    printf("Saisir la largeur : ");
    scanf("%d", &lalarg);
    printf("Saisir la hauteur : ");
    scanf("%d", &lahaut);
    
    //traitement
    leVolumepiece = lalong*lalarg*lahaut;
    leNbRadNecessaire = (leVolumepiece/CAPA)+1;
    
    //affichage des resultats
    printf("le nombre de radiateur necessaire est : %d \n", leNbRadNecessaire);
}