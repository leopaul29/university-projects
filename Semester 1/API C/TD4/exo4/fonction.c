//fonction.c

#include <stdio.h>
#include <math.h>
#include "fonction.h"

int puissance (int unX,int unY)
{
    int laP;
    laP=pow(unX, unY);
    return laP;
}


Bool multiple (int unNb1 , int unNb2)
{
   if((unNb1%unNb2==0)||(unNb2%unNb1==0))
       return 1;
   else
       return 0;
}

int fact ( int unNb1 )
{
    int i,leC=1;
    for(i=1;i<=unNb1;i++)
    {
        leC=leC*i;
    }
    return leC;
}

int PGCD (int unNb1,int unNb2)
{
    int leRest=unNb2;
    while (unNb2>0)
    {
        leRest=unNb1%unNb2;
        unNb1=unNb2;
        unNb2=leRest;
    }
    return unNb1;
}

Bool premier (int unNb1)
{
    int leDiv=unNb1-1;
    while(unNb1%leDiv!=0)
    {
        leDiv--;
    }
    
    if(leDiv==1)
    {
        printf("le nombre est un nombre premier\n");
        return 1;
    }
    else
    {
        printf("le nombre n'est pas un nombre premier\n");
        return 0;
        printf("le diviseur le plus grand est : %d",leDiv);
    }
}

double fibo (int n)
{
    int valeur;
    if (n == 1 || n == 2)
    {
    return 1;
    }
    if (n != 0)
    {
        
        valeur = fibo(n - 1) + fibo(n - 2);
        return valeur;
    }
    else
    {
        return 0;
    }
}