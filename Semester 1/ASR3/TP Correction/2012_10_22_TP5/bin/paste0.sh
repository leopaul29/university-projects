#! /bin/bash

# paste0.sh
# date de derniere modification : 30 11 2011

# Exercice 4 du TP 7 : version 0 simplissime qui ne repond pas vraiment 
# a l'enonce

# Ce script colle bout a bout tous les fichiers passes en arguments et 
# ecrit le resultat dans le fichier dont le nom est precede par --dest
# sur la ligne de commande

# Méthode 0 : "en aveugle"

# Ici, on suppose que paste.sh est toujours appele avec --dest en premier
# ./paste0.sh --dest FICH_DEST FICH1 FICH2 FICH3 ...

DEST=$2
shift
shift
cat $* > $DEST
