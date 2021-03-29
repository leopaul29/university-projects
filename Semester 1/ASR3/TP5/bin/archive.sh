#!/bin/bash
#
#
# archive.sh --name [nom archive.tar.gz] [repertoire à archiver] [repertoire à archiver] ...
#
#
############
if [[ $1 == "--name" ]]
then
	shift
	TARGZ=`echo $1 | sed "s/.tar.gz/%/" | cut -d '%' -f1`
	shift
	tar -cvf $TARGZ.tar $1
else
	echo "Erreur de syntaxe"
	echo "respectez la syntaxe suivante : archive.sh --name [nom archive.tar.gz] [fichier 1] [fichier 2] ... [fichier n]"
	exit
fi
shift
while [ $# -ge 1 ]
do
	tar -rvf $TARGZ.tar $1
	shift
done
gzip $TARGZ.tar
exit
