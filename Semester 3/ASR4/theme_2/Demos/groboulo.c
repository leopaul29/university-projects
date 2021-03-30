#include <stdlib.h>
#include <stdio.h>
#include <sys/time.h>
#include <sys/types.h>
#include <unistd.h>
#include <time.h>

int MAX = 999999999;

int aleat(int n){  
 int partSize =  n == RAND_MAX ? 1 : 1 + (RAND_MAX-n)/(n+1);
 int maxUsefull = partSize * n + (partSize-1); 
 int draw; 
 do { 
   draw = rand(); 
 } while (draw > maxUsefull); 
 return draw/partSize; 
}

void groboulo ()
{
   struct timespec duree_nanosleep;
   int valeur;
   valeur = aleat (MAX);   
   printf("\ngroboulo : %d\n\n", valeur);
   duree_nanosleep.tv_sec = 1;
   duree_nanosleep.tv_nsec = valeur;
   nanosleep(&duree_nanosleep,&duree_nanosleep);
}

int main ()
{ int i;
  for (i = 1;i<4; i++) groboulo ();
}
