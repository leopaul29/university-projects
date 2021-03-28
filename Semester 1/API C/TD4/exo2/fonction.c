//fonction.c

#include <stdio.h>

int calcul (int unA,int unB)
{
    int leC,leD,leE; //variable locales
    
    leD=unB;
    leE=unA;
    leC=1;
    
    while(leD>0)
    {
        if(leD%2==0)
        {
            leD=leD/2;
        }
        else
        {
            leD=(leD-1)/2;
            leC=leC*leE;
        }
        leE=leE*leE;
    }
    
    return leC;
}