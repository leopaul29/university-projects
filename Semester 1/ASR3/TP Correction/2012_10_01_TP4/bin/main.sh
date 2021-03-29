#! /bin/bash
# Script qui met en evidence l'utilite de PATH

# Pour tester cette solution vous devez enlever le ou les commentaires
# que vous souhaitez (il y a plusieurs solutions)

# Le problème :
# Si dans main.sh on écrit
# ./affiche_env.sh
# ou
# bash affiche_env.sh
# alors il suffit de changer de répertoire pour retrouver l'erreur :
# [syska@linserv1 bin]$ cd ..
# [syska@linserv1 TP4]$ bin/main.sh
# bin/main.sh: line 24: ./affiche_env.sh: Aucun fichier ou dossier de ce 
# ./affiche_env.sh

# Solutions en ligne de commande :
# Dans le shell on tape :
# PATH=/users/personnel/s/syska/ASR3/TP4/bin:$PATH
# ou bien
# PATH=$HOME/ASR3/TP4/bin:$PATH
# ou bien
# PATH=.:$PATH
# puis depuis n'importe quel repertoire on exécute
# $HOME/ASR3/TP4/bin/main.sh
# Cependant, le PATH reste modifié après avoir exécuté le script.
# Si on adopte cette solution, le PATH va grossir et risque de provoquer 
# des conflits à terme.

# Solutions qui ne modifient PATH que temporairement
# ou sauvegarder dans OLDPATH
# Solution externe :

#~ [syska@linserv1 ~]$ echo $PATH
#~ /usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games
#~ [syska@linserv1 ~]$ (PATH=~/ASR3/TP4/bin:$PATH;ASR3/TP4/bin/main.sh)
#~ HOSTNAME vaut linserv1
#~ PATH vaut /users/personnel/s/syska/ASR3/TP4/bin:/usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games
#~ PWD vaut /users/personnel/s/syska
#~ [syska@linserv1 ~]$ echo $PATH
#~ /usr/local/bin:/usr/bin:/bin:/usr/local/games:/usr/games
#~ [syska@linserv1 ~]$

# Solution interne :

PATH=$HOME/ASR3/TP4/bin:$PATH

affiche_env.sh

