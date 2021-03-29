#! /bin/bash

# version du 05 octobre 2012
# MS

# Usage :
# export NOM="Il y a des blancs dans ce nom"
# ./changeNom.sh

# Important : pour qu'une variable du shell courant soit vue 
# dans un script, il faut qu'elle ait été exportée. Pour une
# variable du système telle que PATH, c'est souvent automatique.
# Voir le fichier /etc/profile sur linserv1

echo "Avant : $NOM"

# Solution 0
# echo -n "Apres : "
# echo $NOM | tr "a-z " "A-Z_"

# Solution 1
# NOM=$(echo $NOM | tr "a-z " "A-Z_")

# Solution 2 : avec les ensembles de caractères POSIX
NOM=$(echo $NOM | tr "[:lower:] " "[:upper:]_")

echo "Apres : $NOM"

#~ [syska@linserv1 ASR3]$ ./TP4/bin/change_nom.sh
#~ Avant : le contenu de la variable NOM
#~ Apres : LE_CONTENU_DE_LA_VARIABLE_NOM
#~ [syska@linserv1 ASR3]$ echo $NOM
#~ le contenu de la variable NOM
#~ [syska@linserv1 ASR3]$
#~ Quand on revient au shell qui a appelé le script, on
#~ vérifie que NOM n'a pas été modifiée

