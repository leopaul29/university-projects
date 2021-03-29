#!/bin/bash
# version du 23/10/2012
# recorddiskuse.sh
#
#     Ecrit le montant d'espace disque utilise par l'utilisateur
#     courant dans le fichier ~/ASR3/TP4/.TailleHomedir_jj_mm_aaaa avec jj, mm
#     et aaaa les valeurs du jour, mois et annee de la date courante
#     
#     auteur : ms

datedujour=$(date +%d_%m_%Y)

nomfich=".TailleHomedir_$datedujour"

# du -sk ~/.
# calcule l'espace disque total en Kilo octets du répertoire ~/.

du -sk ~/. 2>/dev/null > ~/ASR3/TP4/$nomfich

echo "Le resultat a ete enregistre dans ~/ASR3/TP4/$nomfich"
