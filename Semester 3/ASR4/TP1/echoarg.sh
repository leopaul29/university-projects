#! /bin/bash
# affiche les arguments de la ligne de commande
# echoarg.sh
#
# TP1 ASR4 du 14 02 2012

typeset -i num=1
while (( $# ))
do
	echo "argument $num : $1"
	num=num+1
	shift
done

