# include "bib_microsh.h"

char une_ligne [NB_CAR];

int ligne_blanche (char * ligne)
{ 
  int i = 0;
  while (ligne [i] == ' ') i++;
  SYS_TRACE_I ("   Trace ... Indice ligne_blanche : %d\n", strlen(une_ligne)); 
  if (i == (strlen(une_ligne) -1)) return 0; else return 1;
}
 
shell_commande ** nouvelle_commande()
{ 
  int i, j, min, num_comm, i_trace;
  shell_commande **ligne_commande;
  bzero (une_ligne, NB_MOTS);
  do
   { printf ("\nPrompt$ "); fflush (stdout);
     fgets (une_ligne, NB_CAR, stdin);
     SYS_TRACE_I ("   Trace ... Nombre de caracteres : %d\n", strlen(une_ligne));
    }
  while ( (strlen(une_ligne) < 2) || (ligne_blanche (une_ligne) == 0));
  TRACE_S ("\n%s\n", "   Trace DEBUT nouvelle_commande()");
  if (une_ligne [strlen(une_ligne) - 1] == '\n') 
      une_ligne [strlen(une_ligne) - 1] = (char) 0; 
  TRACE_S ("   Trace ... Ligne de commande : %s\n",une_ligne); 
  i = 0; 
  ligne_commande = malloc (sizeof (struct Shell_commande) * NB_COMMANDES);
  bzero (ligne_commande, sizeof (struct Shell_commande) * NB_COMMANDES);
 
  SYS_TRACE_I ("   Trace ... Taille de ligne de commande [i] : %d\n", 
               sizeof (struct Shell_commande));
  SYS_TRACE_I ("   Trace ... Taille de ligne de commande : %d\n", 
               sizeof (struct Shell_commande) * NB_COMMANDES);

  num_comm = 0;
  // Allocation d'une ligne de commande et du tableau d'argument interne  
  ligne_commande[num_comm]= malloc (sizeof (struct Shell_commande));
  ligne_commande[num_comm]-> commande = malloc (sizeof (char*) * NB_MOTS);
  SYS_TRACE_II ("   Trace ... Adresse ligne_commande[%d]: %d\n", num_comm,
               ligne_commande[num_comm]);
  SYS_TRACE_S ("   Trace ... %s\n","Tous les mots de la ligne"); 
  ligne_commande[num_comm]->commande [i] = strtok(une_ligne, " "); // 1ere extraction
  while(ligne_commande[num_comm]->commande [i] != 0) 
    {
      SYS_TRACE_IIS ("   Trace ... commande [%d] [%d] = %s \n", num_comm, i, 
                ligne_commande[num_comm]->commande [i]);
      i++;     
      ligne_commande[num_comm]->commande [i] = strtok(0, " "); // autres extractions
    }
    SYS_TRACE_IIS ("   Trace ... commande [%d] [%d] = %s \n", num_comm, i, 
                ligne_commande[num_comm]->commande [i]); 
   
  // Decoupage de ligne_commande->commande [0] en fonction des separateurs
  while (ligne_commande[num_comm] != NULL) 
   {
    i=0;    
    while ((ligne_commande[num_comm]->commande [i] != NULL) 
          && (strcmp (ligne_commande[num_comm]->commande [i], "|")  != 0)
          && (strcmp (ligne_commande[num_comm]->commande [i], ";")  != 0)
          && (strcmp (ligne_commande[num_comm]->commande [i], "&")  != 0)) { i++; }

    if (ligne_commande[num_comm]->commande [i] != NULL)
     {
      // Traitement de fin commande 
      if (strcmp (ligne_commande[num_comm]->commande [i], "|")  == 0)
         ligne_commande[num_comm]->separateur = barre;
      else if (strcmp (ligne_commande[num_comm]->commande [i], ";")  == 0)
         ligne_commande[num_comm]->separateur = pvirg;
      else if (strcmp (ligne_commande[num_comm]->commande [i], "&")  == 0)
         ligne_commande[num_comm]->separateur = et_comm;
      else ligne_commande[num_comm]->separateur = aucun;
      SYS_TRACE_I ("   Trace ... Separateur (int) : %d\n", ligne_commande[num_comm]->separateur );
      // Allocation de ligne de commande suivante et du tableau d'argument interne 
      num_comm++; 
      ligne_commande[num_comm]= malloc (sizeof (struct Shell_commande));
      ligne_commande[num_comm]-> commande = malloc (sizeof (char*) * NB_MOTS);
      SYS_TRACE_I ("   Trace ... Adresse ligne_commande[num_comm]: %d\n", 
                   ligne_commande[num_comm]);

      ligne_commande[num_comm-1]->commande [i] = NULL;
      ligne_commande[num_comm]->commande [0] = NULL;
      i++;j=0;
      while (ligne_commande[num_comm-1]->commande [i] != NULL)
         ligne_commande[num_comm]->commande [j++] = 
                  ligne_commande[num_comm-1]->commande [i++];
       ligne_commande[num_comm]->commande [j] = NULL;
      SYS_TRACE_S ("   Trace ... %s\n","Décomposition des mots en commande"); 
      i_trace = 0;
      while(ligne_commande[num_comm-1]->commande [i_trace] != 0) 
       {
        SYS_TRACE_IIS ("   Trace ... commande [%d] [%d] = %s \n", num_comm-1, i_trace, 
                  ligne_commande[num_comm-1]->commande [i_trace]);
        i_trace++;     
       }
       SYS_TRACE_IIS ("   Trace ... commande [%d] [%d] = %s \n", num_comm-1, i_trace, 
                  ligne_commande[num_comm-1]->commande [i_trace]);
     }
  else 
    {
      num_comm++;
      i_trace = 0;
      while(ligne_commande[num_comm-1]->commande [i_trace] != 0) 
       {
        SYS_TRACE_IIS ("   Trace ... commande [%d] [%d] = %s \n", num_comm-1, i_trace, 
                  ligne_commande[num_comm-1]->commande [i_trace]);
        i_trace++;     
       }
       SYS_TRACE_IIS ("   Trace ... commande [%d] [%d] = %s \n", num_comm-1, i_trace, 
                  ligne_commande[num_comm-1]->commande [i_trace]);
   }
  } // Fin decoupage par commande

  // Remplissage des champs de redirection et affichage du detail de chaque commande
  num_comm = 0;    
  while (ligne_commande[num_comm] != NULL) 
   {      
     i = 0; min = 0;
     while (ligne_commande[num_comm]->commande [i] != NULL)
     {
       if ((strcmp (ligne_commande[num_comm]->commande [i], "<")  == 0) ||
          ( strcmp (ligne_commande[num_comm]->commande [i], ">")  == 0) ||
          ( strcmp (ligne_commande[num_comm]->commande [i], "2>")  == 0)) 
         {
           if (strcmp (ligne_commande[num_comm]->commande [i], "<")  == 0) 
              { ligne_commande[num_comm]->in_redir = ligne_commande[num_comm]->commande [i+1]; 
                SYS_TRACE_S ("   Trace ... %s\n", "Redir. entree"); }
           else if (strcmp (ligne_commande[num_comm]->commande [i], ">")  == 0) 
              { ligne_commande[num_comm]->out_redir = ligne_commande[num_comm]->commande [i+1];
                SYS_TRACE_S ("   Trace ... %s\n", "Redir. sortie"); }
           else if (strcmp (ligne_commande[num_comm]->commande [i], "2>")  == 0) 
              { ligne_commande[num_comm]->err_redir = ligne_commande[num_comm]->commande [i+1];
                SYS_TRACE_S ("   Trace ... %s\n", "Redir. erreur"); }
           ligne_commande[num_comm]->commande [i] = NULL;
           ligne_commande[num_comm]->commande [i+1] = NULL;
           i=i+2;
           if (min == 0) min = i+1; 
         }
      else i++;
     }
    if (min != 0) ligne_commande[num_comm]->commande [min] = NULL; // suppression des redirections
    if (ligne_commande[num_comm]->commande [0] == NULL) // derniere commande vide
      ligne_commande [num_comm] = NULL; // Supression de la dernier commande vide
    else
     {
#ifdef TRACE
    i=0; 
    printf ("   Trace ... Detail de la commande numero %d ==> \n", num_comm);
    SYS_TRACE_I ("   Trace ...... Valeur de ligne_commande[num_comm] : %d  \n", ligne_commande[num_comm]);
    while (ligne_commande[num_comm]->commande [i] != NULL) {
       printf("   Trace ...... ligne_commande [%d]->commande [%d] = %s \n", num_comm, i, 
              ligne_commande[num_comm]->commande [i]);
       i++;
      }
     printf("   Trace ...... ligne_commande [%d]->commande [%d] = %s \n", num_comm, i,
              ligne_commande[num_comm]->commande [i]); 
     printf("   Trace ...... ligne_commande [%d]->in_redir     = %s \n", num_comm,
              ligne_commande[num_comm]->in_redir); 
     printf("   Trace ...... ligne_commande [%d]->out_redir    = %s \n", num_comm,
              ligne_commande[num_comm]->out_redir); 
     printf("   Trace ...... ligne_commande [%d]->err_redir    = %s \n", num_comm,
              ligne_commande[num_comm]->err_redir); 
    switch (ligne_commande[num_comm]->separateur){
      case barre   : printf ("   Trace ...... ligne_commande [%d]->separateur   = barre \n", num_comm ); break;
      case pvirg   : printf ("   Trace ...... ligne_commande [%d]->separateur   = pvirg \n", num_comm ); break;
      case et_comm : printf ("   Trace ...... ligne_commande [%d]->separateur   = et_comm \n", num_comm );break;
      case aucun   : printf ("   Trace ...... ligne_commande [%d]->separateur   = aucun \n", num_comm ); break;
     }
#endif
    }

    num_comm++;
  } // Fin traitement redirections et affichage
    TRACE_I ("   Trace ... Detail de la commande numero %d ==> (null)\n", num_comm);
    TRACE_T ("   Trace FIN nouvelle_commande ()\n");
    return ligne_commande;
}
 
