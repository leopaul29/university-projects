#! /bin/bash
#
# TP4 ASR3 S1T 02 octobre 2012
#
# affiche_env.sh : affiche les variables d'environnement HOSTNAME, PATH et PWD
# Exemple :
# syska@linserv1:~/ASR3/TP4/bin$ ./affiche_env.sh 
# HOSTNAME vaut linserv1
# PATH vaut /usr/local/bin:/usr/bin:/bin:/usr/games
# PWD vaut /users/personnel/s/syska/ASR3/TP4/bin
#
# Ne pas oublier de donner les droits en execution :
# chmod u+x affiche_env.sh
# ou
# chmod a+x affiche_env.sh

echo "HOSTNAME vaut $HOSTNAME"
echo "PATH vaut $PATH"
echo "PWD vaut $PWD"


