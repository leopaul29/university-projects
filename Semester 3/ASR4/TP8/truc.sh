#!/bin/bash
trap "" 2 3 15
while :
	do
	echo -n "Mot de passe : "
	read -ers mdp
	echo ""
	if [ "${mdp}" = "test" ]
	then
		echo "mot de passe valide"
		break
	fi
	done
trap 2 3 15
