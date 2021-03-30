/******************/
/* ASR4 Chignoli  */
/* demo_strtok    */
/******************/
# include <stdio.h>
# include <stdlib.h>
# include <sys/types.h>
# include <string.h>
# include <strings.h>

int main()
{ 
  char *valeur;
  char *item1, *item2;  // malloc inutile ...
  valeur = malloc(100);
  strcpy (valeur, "acbd@xxxxx");
  printf("\n==> Valeur = %s \n\n", valeur);
  item1 = strtok(valeur, "@"); // 1ere extraction
  item2 = strtok(0, "@"); // autres extractions    
  printf("item1: %s - item2: %s\n\n", item1, item2);
}




