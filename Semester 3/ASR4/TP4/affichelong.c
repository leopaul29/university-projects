#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>

#include <unistd.h>
#include <string.h>

#include <sys/stat.h>
#include <sys/types.h>
#include <pwd.h>
#include <grp.h>

#include <time.h>
#include <locale.h>

#include <libgen.h>		/* basename */

#include "affichelong.h"

void
affichemode (mode_t const mode)
{
  char permission[] = "-rwxrwxrwx";
  char *chaine = permission;

  /* type */
  switch (mode & S_IFMT)
    {
    case S_IFLNK:
      *chaine++ = 'l';
      break;
    case S_IFDIR:
      *chaine++ = 'd';
      break;
    default:
      *chaine++ = '-';
      break;
    }

  /* user */
  (mode & S_IRUSR) ? (*chaine++ = 'r') : (*chaine++ = '-');
  (mode & S_IWUSR) ? (*chaine++ = 'w') : (*chaine++ = '-');
  (mode & S_IXUSR) ? (*chaine++ = 'x') : (*chaine++ = '-');

  /* group */
  (mode & S_IRGRP) ? (*chaine++ = 'r') : (*chaine++ = '-');
  (mode & S_IWGRP) ? (*chaine++ = 'w') : (*chaine++ = '-');
  (mode & S_IXGRP) ? (*chaine++ = 'x') : (*chaine++ = '-');

  /* others */
  (mode & S_IROTH) ? (*chaine++ = 'r') : (*chaine++ = '-');
  (mode & S_IWOTH) ? (*chaine++ = 'w') : (*chaine++ = '-');
  (mode & S_IXOTH) ? (*chaine++ = 'x') : (*chaine++ = '-');

  /* affichage */
  *chaine = '\0';
  printf ("%", permission);

}

void
utilisateur (int numero_uid, char *nom_utilisateur, int numero_gid,
	     char *nom_groupe)
{
  struct passwd *pinfos;
  struct group *ginfos;

  if ((pinfos = getpwuid (numero_uid)) == NULL)
    /* si le nom de l'utilisateur est absent (ldap ne répond pas par exemple), on renvoit l'uid */
    sprintf (nom_utilisateur, "%10d", numero_uid);
  else
    sprintf (nom_utilisateur, "%s", pinfos->pw_name);

  if ((ginfos = getgrgid (numero_gid)) == NULL)
    /* si le nom du groupe est absent on renvoit le gid */
    sprintf (nom_groupe, "%10d", numero_gid);
  else
    sprintf (nom_groupe, "%10s", ginfos->gr_name);
}

void
affichelong (char *nom)
{
  struct stat pinfo;
  int uid, gid;
  char utilisateur_courant[LONG_MAX_USER];
  char groupe_courant[LONG_MAX_GROUPE];
  struct tm *timeinfo;
  time_t timer;
  char buf[10];
  char st[100];
  char *LANG;

  if (lstat (nom, &pinfo) == -1)
    {
      fprintf (stderr, "lstat: impossible d'accéder à %s\n", nom);
      exit (3);
    }

  affichemode (pinfo.st_mode);
  printf (" %ld", pinfo.st_nlink);
  uid = pinfo.st_uid;
  gid = pinfo.st_gid;
  utilisateur (uid, (char *) utilisateur_courant, gid,
	       (char *) groupe_courant);
  printf (" %s %s", utilisateur_courant, groupe_courant);
  printf (" %10ld", pinfo.st_size);

  /* Partie date optionnelle avec améliorations possibles */
  LANG = getenv ("LANG");
  //setlocale(LC_TIME, "fr_FR.UTF-8");
  setlocale (LC_TIME, LANG);	// voir "" pour default
  timeinfo = localtime (&pinfo.st_mtime);
  //strftime(st, 30, "%b %e  %Y", timeinfo);
  strftime (buf, 7, "%b", timeinfo);
  //printf(" :%s:", buf);
  sprintf (st, "%-5s", buf);
  strftime (buf, 3, "%e", timeinfo);
  sprintf (st, "%s %-2s", st, buf);
  // 60*60*24*365.25/2 = 15778800 (6 mois)
  timer = time (NULL);
  if (timer - pinfo.st_mtime < 15778800)
    {				// vieux de moins de 6 mois
      strftime (buf, 6, "%H:%M", timeinfo);
      sprintf (st, "%s %5s", st, buf);
    }
  else
    {
      strftime (buf, 5, "%Y", timeinfo);
      sprintf (st, "%s %5s", st, buf);
    }
  printf (" %s", st);

  printf (" %s\n", basename (nom));
}
