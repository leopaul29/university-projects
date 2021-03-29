#!/bin/bash
#
# version du 24/10/2012
# affichetxt.sh
# auteur : ms
#
#     affiche tous les fichiers de type texte enregistrés dans le répertoire
#     $BASEDIR et ayant pour extension .txt.
#
# version + : vérifier que BASEDIR n'est pas vide, sinon sortir

for FICH in $(ls $BASEDIR/*.txt 2>/dev/null) # et pas for FICH in $BASEDIR/*.txt
do
	echo "####################################################################"
	echo "Contenu du fichier $FICH"
	echo "####################################################################"
	cat $FICH
done
