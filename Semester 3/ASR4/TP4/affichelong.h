#ifndef __AFFICHE_LONG_H__
#define __AFFICHE_LONG_H__

#define LONG_MAX_USER 32
#define LONG_MAX_GROUPE 32
#define LONG_MAX_REP 256

void affichemode(mode_t const mode);

void
utilisateur(int numero_uid, char *nom_utilisateur, int numero_gid,
	    char *nom_groupe);

char *petitnom(char *nom);

void affichelong(char *nom);

#endif
