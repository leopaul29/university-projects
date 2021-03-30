#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <assert.h>
 
#define TOKENBUFFER 3
 
int main (int argc, char **argv)
{
  pid_t pid;
  int i, numberOfProcess, firstcurrentToken, currentToken;
  int numberOfRound = 1;
  char stringCurrentToken[TOKENBUFFER];
   
  // Contrôle des paramètres.
  assert(argc >= 3);
  assert((numberOfProcess = atoi(argv[1])) > 0);
  assert((currentToken = (firstcurrentToken = atoi(argv[2]))) > 0);
   
  int pipefd[numberOfProcess][2];
 
  if (argc == 4)
    assert((numberOfRound = atoi(argv[3])) > 0);
       
  // Initialisation des pipes qui seront utilisés pour l'écriture du currentToken.
  for(i = 0; i < numberOfProcess; i++)
    if(pipe(pipefd[i]) < 0)
      return EXIT_FAILURE;
 
  printf("\n");
 
  sprintf(stringCurrentToken, "%d", currentToken);
  write(pipefd[numberOfProcess - 1][1], stringCurrentToken, TOKENBUFFER);
 
  // Initialisation des fils au nombre de numberOfProcess.
  for(i = 0; i < numberOfProcess; i++)
    if((pid = fork()) < 0)
      return EXIT_FAILURE;
    else if (pid != 0)
      break;
 
   
  // Parcours tant que le currentToken est > 0
  // C'est-à-dire le temps qu'on a pas parcouru tous les fils
  while(currentToken > 0)
    {
      read(pipefd[(i - 1) < 0 ? (numberOfProcess - 1) : (i - 1)][0], stringCurrentToken, TOKENBUFFER);
      currentToken = atoi(stringCurrentToken);
       
      printf("Fils n°%d\n--PID=%d\n--RD: currentToken=%d\n", i, pid, currentToken);
       
      if(currentToken > 0) {
	if(currentToken >= (firstcurrentToken + numberOfProcess * numberOfRound))
	  currentToken = 0;
	else
	  currentToken++;
      }
       
      printf("--RW: currentToken=%i\n", currentToken);
       
      sprintf(stringCurrentToken, "%d", currentToken);
      write(pipefd[i][1], stringCurrentToken, TOKENBUFFER);
    }
       
  if(pid == 0)
    printf("\n\n ** Attente de la fin des processus ** \n\n");
       
  while((pid = wait(NULL)) > 0)
    printf("PID n°%d terminé\n", pid);
 
  return EXIT_SUCCESS;
}
