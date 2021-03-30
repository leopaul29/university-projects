// R. Chignoli Mars 2010
// Grammaire microsh : simplification de la syntaxe de bash ...
//
// CONVENTIONS : {} = O a N ; "x" = le symbole x ; 
//               () = factorisation ; "..." = 1 a N ; "|" = alternative
//
// GRAMMAIRE : regle principale = ligne
// ligne         ::= commande_pipe { [";" | "&"] commande_pipe } [";" | "&"]  
// commande_pipe ::= commande { "|" commande }
// commande      ::= mot ... { redirection } 
// redirection   ::= (">" | "2>" | "<") mot 
// mot           ::= <identificateur quelconque>
//
// CONTRAINTE : separation des mots et symboles  par un caractere blanc

# include <stdio.h>
# include <stdlib.h>
# include <strings.h>
# include <string.h>

#define NB_COMMANDES 10	// par ligne ... Limitation prototype
#define NB_CAR 80       // Limitation prototype
#define NB_MOTS 20 	// par commande ... Limitation prototype

// Pour préciser l'operateur qui suit une commande_pipe
typedef enum { aucun, barre, et_comm, pvirg} type_separateur;

// Representation intene d'une ligne de commande sous forme d'un tableau de commande_pipe
typedef struct Shell_commande {
    char** commande; // tableau dynamique de NB_MOTS mots 
    char* in_redir; 
    char* out_redir;
    char* err_redir;
    type_separateur separateur;
  }shell_commande;

// Lit une ligne au clavier et rend la representation interne correspondante
shell_commande ** nouvelle_commande();

// Macros de mise au point : utiliser a la compilsation les  options -DTRACE et 
// -D SYS_TRACE pour les activer
#ifdef TRACE
#define TRACE_T(f) printf (f)
#define TRACE_S(f, s) printf(f, s)
#define TRACE_I(f, i) printf(f, i)
#define TRACE_IS(f, i, s) printf(f, i, s)
#define TRACE_IIS(f, i, d, s) printf(f, i, d, s)
#else
#define TRACE_T(f)
#define TRACE_S(f, s)
#define TRACE_I(f, i) 
#define TRACE_IS(f, i, s) 
#define TRACE_IIS(f, i, d, s) 
#endif

#ifdef SYS_TRACE
#define SYS_TRACE_I(f, i) printf(f, i)
#define SYS_TRACE_S(f, s) printf(f, s)
#define SYS_TRACE_II(f, i, d) printf(f, i, d)
#define SYS_TRACE_IIS(f, i, d, s) printf(f, i, d, s)
#else
#define SYS_TRACE_I(f, i)
#define SYS_TRACE_S(f, s)
#define SYS_TRACE_II(f, i, d)
#define SYS_TRACE_IIS(f, i, d, s)
#endif

