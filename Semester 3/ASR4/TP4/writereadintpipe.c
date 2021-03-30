#include <stdio.h>
#include <unistd.h>
void
main ()
{
  int nombre = 4, resultat;
  int tabpipe[2];
  pipe (tabpipe);

  write (tabpipe[1], &nombre, sizeof (int));
  read (tabpipe[0], &resultat, sizeof (int));
  resultat++;
  printf ("Le nombre lu est : %d \n", resultat);
}
