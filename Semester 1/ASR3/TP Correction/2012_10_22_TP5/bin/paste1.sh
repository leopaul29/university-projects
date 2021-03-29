#!/bin/bash
#
# paste1.sh
#
#     Auteur : ms
#     Date de création : 16 11 2005
#             dernière modification : 30 11 2011
#
#     Exemple d'utilisation :
#     ./paste1.sh fich1.txt fich2.txt --dest foo fich3.txt

# Exercice 4 du TP 7 : version 1 plus complexe qui repond a l'enonce
# mais perfectible (pb du fichier tmp)

# Comme on ne sait pas dans quel ordre les arguments sont passés au
#   script, on traitera les opérations après avoir examiné tous les
#   arguments en fonction des valeurs des indicateurs suivants :

# Ici, on va coller les fichiers au fur et a mesure du traitement des
# arguments correspondants de la ligne de commande dans un fichier
# temporaire
# NB : /tmp est un repertoire ouvert a tous en ecriture pour ce type
# de besoin. Probleme : fich_tmp peut deja exister et appartenir a
# un autre utilisateur

# On supprime le fichier s'il existe deja
rm -f /tmp/fich_tmp 2>/dev/null

# On regarde les arguments un a un
while (( $# )) # vrai si le nombre d'arguments est different de 0
do
    case $1 in
	"--dest")
	    DEST=$2 # si $1 vaut --dest alors on attend un nom dans $2
	    shift # un shift de plus car ici on aura traite deux arguments
	    if [[ -z $DEST ]] #  $2 est-il vide?
	    then
		echo "Erreur usage : paste.sh --dest fich fich1 ..."
		exit 8
	    fi
	    ;;
	*) # pour toutes les autres valeurs possibles de $1
	    if [[ -f $1 ]]  # $1 est-il un fichier normal?
	    then
		cat $1 >> /tmp/fich_tmp # si oui on le rajoute au fichier temporaire
	    else
		echo "Erreur : $1 argument inconnu!"
		rm -f /tmp/fich_tmp 2>/dev/null
		exit 6
	    fi
    esac
    shift # on traite le mot (argument) suivant sur la ligne de commande
done

# Maintenant, il n'y a plus d'arguments sur la ligne de commande (shift les a tous
# consommés

# rien ne nous assure que on a rencontre --dest
if [[ -z $DEST ]] 
then
    echo "Erreur usage : paste.sh --dest fich"
    rm -f /tmp/fich_tmp 2>/dev/null
    exit 4
else # tous les fichiers ont ete colles dans fich_tmp
    mv /tmp/fich_tmp $DEST # il ne reste plus qu'lui donner son veritable nom
fi

exit 0






