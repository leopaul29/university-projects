#!/bin/bash
#
#
# paste.sh
#
# se positionner dans le dossier data et executer la commande suivante pour tester :
# bash ../bin/paste.sh foo1.txt --dest foo.bar foo2.txt
##########
while [ $# -ge 1 ]
do
	if [[ $1 == "--dest" ]]
	then
		shift
		fic_dest=$1
	else
		cat $1 >> result_tmp.txt
	fi
	shift
done
mv result_tmp.txt $fic_dest
exit
