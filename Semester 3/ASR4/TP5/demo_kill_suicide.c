/*
  demo_kill.c : Utilisation de la routine kill
*/
# include <stdio.h>
# include <signal.h>

main (){
	int res;
	printf("\nJe commence et j'attends 3 secondes...\n");
	sleep(3);
	printf("\n... puis je me suicide par kill\n");
	kill(getpid(), SIGKILL);
	printf("\n... je suis mort\n");
}
