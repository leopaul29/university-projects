#!/bin/bash
#
#
#testeargs.sh
#
#
#############


#case expression in
#	--help)
#		echo "Ceci est le fichier d'aide pour testeargs.sh."
#		echo "Vous pouvez en ajouter dans help.txt."
#		;;
#	*)
#		for i in $*
#		do
#			echo "sorry but $* is not implemented !"
#			shift
#		done
#		;;
#esac

for i in $*
do
	if [[ $i == "--help" ]]
		then
			echo "Ceci est le fichier d'aide pour testeargs.sh."
			echo "Vous pouvez en ajouter dans help.txt."
		else
			echo "sorry but `echo $* | cut -d' ' -f1` is not implemented !"
	fi
	shift
done
