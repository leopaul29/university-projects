#!/bin/bash
#
# paste2.sh
#
#     Auteur : ms
#     Date de création : 16 11 2005
#             dernière modification : 30 11 2011
#
#     Exemple d'utilisation :
#     ./paste.sh fich1.txt fich2.txt --dest foo fich3.txt

# Exercice 4 du TP 7 : version 2 plus complexe qui repond a l'enonce
# et 

# Comme on ne sait pas dans quel ordre les arguments sont passes au
#   script, on traitera les operations apres avoir examine tous les
#   arguments en fonction des valeurs des indicateurs suivants :

# Au lieu d'utiliser un fichier temporaire, on construit la liste des fichiers
# a utiliser par la commande cat : cout zero en cas d'erreur

LISTE=  # equivalent a : LISTE=''

while (( $# )) # equivalent a :  while [[ $# -ge 1 ]]

do
    case $1 in

	"--dest")
	    DEST=$2
	    shift
	    if [[ -z $DEST ]] 
	    then
		echo "Erreur usage : paste.sh --dest fich fich1 ..."
		exit 8
	    fi
	    ;;

	*)
	    if [[ -f $1 ]] 
	    then
		LISTE="$LISTE $1" # on ajoute $1 à la liste des fichiers a coller
	    else
		echo "Erreur : $1 argument inconnu!"
		exit 6
	    fi
    esac
    shift
done

# rien ne nous assure que on a rencontre --dest et qu'il y a au moins un fichier a coller
if [[ -z $DEST || -z $LISTE ]] 
then
    echo "Erreur usage : paste.sh --dest fich fich1 ..."
    exit 4
else
   cat $LISTE > $DEST # une seule instruction pour realiser le travail et on
                                  # ne copie aucun fichier inutilement en cas d'erreur de syntaxe
fi

exit 0






