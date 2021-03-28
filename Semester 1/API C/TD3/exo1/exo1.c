/*******************
*****TD3-exo1.c*****
********************/

#include <stdio.h>

void main()
{
    //declaration
    int i=0; //pour compter le nombre de voyelle
    char leCar; //pour lire un caractere
    
    //saisi
    printf("Entrez votre texte (non accentue, terminer par un #) : \n");
    leCar=getchar();
    
    //traitement "tant que"
    while(leCar!='#')
    {
        //test le car
        if((leCar=='a')||(leCar=='e')||(leCar=='i')||(leCar=='o')||(leCar=='u')||(leCar=='y'))
        {
            i++;
        }
        leCar=getchar();
    }
    if(i!=0)
    {
        printf("Ce texte contient %d voyelles : \n",i);
    }
    else
    {
        printf("Ce texte ne contient aucune voyelle.\n");
    }
}