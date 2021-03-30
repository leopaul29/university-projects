#define _XOPEN_SOURCE /* tester avec ou sans */
#include <signal.h>
#include <stdio.h> 

void capture (int sig) { 
	printf("Signal reçu %d\n", sig); 
} 

int main() {
  signal(SIGINT, capture);
  while (1) { 
	  printf("Hello World!\n"); 
	  sleep(1); 
	}
}
