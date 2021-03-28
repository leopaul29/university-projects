//fonction.c

#include <stdio.h>

int hms(int unH,int unM, int unS)
{
    int leRetour=unH*3600+unM*60+unS;
    return leRetour;
}