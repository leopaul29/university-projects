#include <signal.h>
#include <stdio.h> 

void capture (int sig) { 
	printf("Signal recu %d\n", sig); 
} 

int main () {
  signal (SIGINT, capture);
  while (1) { 
	  printf("Hello World!\n"); 
	  sleep(1); 
	}
}
