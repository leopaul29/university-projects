#!/bin/bash
#
#afficheargs.sh
#
#
###########
echo "Exécution de la commande afficheargs.sh"
echo  "Nombre de parametres : $#"
echo "Liste de parametres : $*"
typeset -i i
i=1
while [ $# -ge 1 ]
do
	echo "argument numéro $i : $1"
	i=i+1
	shift
done
