/*******************
*****TP1-exo4.c*****
********************/

#include <stdio.h>

void main()
{
    int leN1;
    float leN2;
    char leCar;
    
    printf("saisir un entier !!! int : \n");
    scanf("%d", &leN1);
    printf("%d\n",leN1);
    fflush(stdin);
    printf("saisir un caractere !!! char : \n");
    leCar=getchar();
    printf("%c\n",leCar);
    
    printf("saisir un reel !!! float : \n");
    scanf("%f", &leN2);
    printf("%f\n",leN2);
}