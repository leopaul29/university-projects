#! /bin/bash

# affichetxt.sh
# version du 23/11/2011

# Affiche les fichiers comportant l'extension .txt du répertoire pointé par $BASEDIR
# Au préalable, il faut affecter une valeur à BASEDIR et exporter BASEDIR pour
# qu'elle soit connue à l'intérieur du shell qui exécute affichetxt.sh (voir TP4)

# [syska@linserv1 TP7]$ ./affichetxt.sh
# $BASEDIR est vide
# [syska@linserv1 TP7]$ pwd
# /users/personnel/s/syska/ASR3/TP7
# [syska@linserv1 TP7]$
# [syska@linserv1 TP7]$
# [syska@linserv1 TP7]$ export BASEDIR=/users/personnel/s/syska/ASR3/TP7
# [syska@linserv1 TP7]$ ./affichetxt.sh
# ####################################################################
# Contenu du fichier foo1.txt
# ####################################################################
# Fichier foo1.txt
# sur deux lignes
# ####################################################################
# Contenu du fichier foo2.txt
# ####################################################################
# Fichier foo2.txt sur une ligne
# [syska@linserv1 TP7]$

# Ici, il faut vérifier que BASEDIR n'est pas vide et pointe bien sur un répertoire
# 
# -n teste si une variable est non vide
# -z teste si une variable est vide
if [[ -z $BASEDIR ]]
then
	echo "\$BASEDIR est vide"
	exit 8 # on pourra constater dans le shell appelant que le script a échoué
	# avec un code de retour valant 8
	# echo $?
fi

# On vérifie que le répertoire de nom $BASEDIR existe bien
if [[ -d $BASEDIR ]]
then

	cd $BASEDIR

	for FICH in $(ls *.txt 2>/dev/null) # pour traiter le cas ou BASEDIR sans .txt
	do
		echo "####################################################################"
		echo "Contenu du fichier $FICH"
		echo "####################################################################"
		cat "$FICH"
	done
else	
	echo "$BASEDIR n'est pas un repertoire"
	exit 9
fi