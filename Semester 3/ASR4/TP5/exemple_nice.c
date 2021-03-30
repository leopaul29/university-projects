/***********************************************************************\
   exemple_nice
 
   Programme d'exemple du livre "Developpement systeme en C sous Linux"
   
   (c) 2000,2005 - Christophe Blaess
 
\***********************************************************************/

#define _GNU_SOURCE
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

volatile long compteur = 0; // la variable est rechargee a chaque reference
					// meme si elle est deja dans le registre du processeur
static int  gentillesse;

void gestionnaire (int numero) {
	if (compteur != 0) {
		fprintf(stdout, "Fils %ld (nice %2d) Compteur = %9ld\n",
                          (long) getpid(), gentillesse, compteur);
		exit(EXIT_SUCCESS);
	}
}

#define NB_FILS	5

int main (void) {
	pid_t   pid;
	int	fils;
	
	/* Cr�ation d'un nouveau groupe de processus */
	setpgid(0, 0); // pid = 0 : pid du processus appelant
			    // pgid = 0 : meme valeur que celui du pid appelant
	
	signal(SIGUSR1, gestionnaire);
	for (fils = 0; fils < NB_FILS; fils ++) {
		if ((pid = fork()) < 0) {
			perror("fork");
			exit(EXIT_FAILURE);
		}
		if (pid != 0)
			continue;
		gentillesse = fils * (20 / (NB_FILS - 1));
		if (nice(gentillesse) < 0) { // nouvelle gentillesse pour ce fils
			perror("nice");
			exit(EXIT_FAILURE);
		}
		/* attente signal de d�marrage */
		pause(); // attend un signal qui termine le processus ou est intercepte
		/* comptage */
		while (1)
			compteur ++;
	}
	/* processus p�re */
	signal(SIGUSR1, SIG_IGN);
	sleep(1);
	kill(-getpgid(0), SIGUSR1);
	sleep(15);
	kill(-getpgid(0), SIGUSR1);
	while (wait(NULL) > 0)
		;
	exit(EXIT_SUCCESS);
}

