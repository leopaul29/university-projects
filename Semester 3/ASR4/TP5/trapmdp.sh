#!/bin/sh
trap "" 2 3 15 # ignorer les signaux
while :
	do
	echo "Entrez le mot de passe : \c"
	read -s mdp
	if [ "${mdp}" = "test" ]
	then
		echo "mot de passe valide !"
		break
	fi
done
trap 2 3 15 # revenir l'etat par defaut
