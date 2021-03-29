#!/bin/bash
#
#
#affichetxt.sh
#
export BASEDIR=~/ASR3/TP5/data
##############
cd $BASEDIR
for fic in `ls $BASEDIR/*.txt`
do
	echo "####################################################################"
	echo "Contenu du fichier $fic"
	echo "####################################################################"
	cat $fic
done
exit
