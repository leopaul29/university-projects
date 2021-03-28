/*******************
*****TP1-exo1.c*****
********************/

#include <stdio.h>

void main()
{
    float leNb=435.2431112;
    const float PI = 3.14159;
    int leNbInt = 127;
    printf("%6d\n", leNbInt);
    printf("%-6d\n", leNbInt);
    printf("%f\n", PI);
    printf("%5.3f\n", PI);
    printf("%8.3f\n", PI);
    
    printf("%9.2f\n",leNb);
}