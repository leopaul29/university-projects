/*
  demo_kill2.c : Utilisation de la routine kill
*/
# include <stdio.h>
# include <signal.h>

main (){
	int res;
	printf("\nNous (%d) commençons et attendons 333 secondes...\n",getpid());
	sleep(333);
	printf("\n... je suis mort\n");
}
