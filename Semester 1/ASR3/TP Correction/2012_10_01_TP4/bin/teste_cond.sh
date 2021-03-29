#!/bin/bash
#
# teste_cond.sh
#
#     exercice sur les tests conditionnels
#     auteur : ms
#     version du 12 mars 2012

# Saisie des noms de dossier et de fichier
echo -n "Entrez un nom de dossier : "
read DIR
echo -n "Entrez un nom de fichier : "
read FICH

# Tests
echo "Est-ce que $DIR existe? "

if [[ -d $DIR ]]
then
	echo "OUI"
else 
	echo "NON"
fi

echo -n "Est-ce que $FICH est un fichier normal? "

if [[ -f $FICH ]]
then 
	echo "OUI"
else
	echo "NON"
fi

# if ls $FICH >/dev/null 2>/dev/null; then echo "oui"; else echo "non"; fi
# ne marche pas si $FICH est vide

echo -n "Est-ce que $FICH a une extension .txt? "
if [[  $FICH == *.txt ]] # ou ${FICH##*.} == "txt"
then 
	echo "OUI"
	if [[ -s $FICH ]]
	then 
		cat $FICH
	else 
		echo "Le fichier $FICH est vide"
	fi
else 
	echo "NON"
fi






