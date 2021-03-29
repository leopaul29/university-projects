#!/bin/bash
#
# testeargs.sh
#
#     TP7 : exercice 3 sur les arguments de la ligne de commande
#     Exemple
#     ./testeargs.sh --help
#
#     Auteur : ms
#     Date de creation : 23 11 2011
#             derniere modification : 23 11 2011 (TP7 S1T ASR3)
#

#if [[ $1 == "--help" ]]
#then
#	cat help.txt
#fi

while (( $# ))
do
	case $1 in

		"--help"|"-h")
			cat help.txt
		;;
	
		*)
			echo "sorry but $1 is not recognized!"
		;;
	esac
	shift
done
