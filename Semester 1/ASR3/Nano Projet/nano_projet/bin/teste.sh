#!/bin/bash

# --- Test.sh --- #

clear
echo -e "\n"
echo "			##### ----- Nano Projet ----- #####"
echo -e "\n\n"
echo "	Auteur : Leo-Paul MARTIN"
echo "	Date : 21/12/2012"
echo "	Version : 4"
echo -e "\n\n"
echo "		################################################"
echo "		# Appuiyer sur une touche pour lancer teste.sh #"
echo "		################################################"

echo -e "\n\n\n\n\n\n\n"
echo "idem.sh peut etre executer depuis la racine en prenant comme chemin : ' ~/~/SupportCours/S1T/ASR3/Leopaul_MARTIN/ ... '"
echo -e "\n"
echo "Ceci est une demonstration de idem.sh"

read
clear


# --- AIDE : Affiche l'aide si -h en premier argument (1/4")
echo -e 
echo "Test de la commande -h ou --help :"
echo "-h ou --help affiche bien l'aide en ligne et quitte le programme quel que soit le rang de l'argument sur la ligne de commande, sauf si un argument invalide est lu avant (de gauche a droite)."
echo -e 
echo "idem.sh execute la commande : ./idem.sh -h ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/magique/ -name enterre.txt"
echo -e 
echo "	execution correcte de idem.sh avec l'option '-h' en premier argument."
echo "		Resultat : Affiche l'aide"
echo -e
./idem.sh -h ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/magique/ -name enterre.txt

read
clear

# --- AIDE : Affiche l'aide si --help en premier argument (2/4)
echo -e 
echo "Test de la commande -h ou --help :"
echo "-h ou --help affiche bien l'aide en ligne et quitte le programme quel que soit le rang de l'argument sur la ligne de commande, sauf si un argument invalide est lu avant (de gauche a droite)."
echo -e 
echo "idem.sh execute la commande : ./idem.sh --help ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/sourd/ -name opportunite.txt"
echo -e 
echo "	execution correcte de idem.sh avec l'option '--help' en premier argument."
echo "		Resultat : Affiche l'aide"
echo -e 
./idem.sh --help ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/sourd/ -name opportunite.txt

read
clear

# --- AIDE : Affiche l'aide si le repertoire existe (3.1/4)
echo -e 
echo "Test de la commande -h ou --help :"
echo "-h ou --help affiche bien l'aide en ligne et quitte le programme quel que soit le rang de l'argument sur la ligne de commande, sauf si un argument invalide est lu avant (de gauche a droite)."
echo -e 
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/Puissance/ -name tata.txt --help"
echo -e 
echo "	execution correcte de idem.sh avec l'option '--help' en dernier argument et un chemin qui existe."
echo "		Resultat : Affiche l'aide"
echo -e
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/Puissance/ -name tata.txt --help

read
clear


# --- AIDE : N'affiche pas l'aide si le repertoire n'existe pas (3.2/4)
echo -e 
echo "Test de la commande -h ou --help :"
echo "-h ou --help affiche bien l'aide en ligne et quitte le programme quel que soit le rang de l'argument sur la ligne de commande, sauf si un argument invalide est lu avant (de gauche a droite)."
echo -e 
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/tressailleazant -name soit.txt --help"
echo -e 
echo "	execution INcorrecte de idem.sh avec l'option '--help' en dernier argument et un chemin qui n'existe pas."
echo "		Resultat : N'affiche pas l'aide"
echo -e 
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/tressailleazant -name soit.txt --help

read
clear


# --- AIDE : N'affiche pas l'aide si l'option "-naimme" n'exite pas (4/4)
echo -e 
echo "Test de la commande -h ou --help :"
echo "-h ou --help affiche bien l'aide en ligne et quitte le programme quel que soit le rang de l'argument sur la ligne de commande, sauf si un argument invalide est lu avant (de gauche a droite)."
echo -e 
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/tressaillant -nainme soit.txt --help"
echo -e 
echo "	execution INcorrecte de idem.sh avec l'option '--help' en dernier argument et une expression qui n'existe pas."
echo "		Resultat : N'affiche pas l'aide"
echo -e 
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/tressaillant -nainme soit.txt --help

read
clear


# --- MODE BAVARD : Affiche le type de recherche en fonction de l'option si -v en premier argument (1/2)
echo -e 
echo "Test de la commande -v ou --verbose :"
echo "-v ou --verbose affiche bien la liste de tous les chemins traites (et d'autres informations eventuellement)"
echo -e 
echo "idem.sh execute la commande : ./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name autrement.txt"
echo -e 
echo "	execution correcte de idem.sh avec l'option '-v' en premier argument."
echo "		Resultat : Affiche la description de la recherche effectue"
echo -e 
./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name autrement.txt
read
clear


# --- MODE BAVARD : Affiche le type de recherche en fonction de l'option si --verbose en dernier argument(2/2)
echo -e 
echo "Test de la commande -v ou --verbose :"
echo "-v ou --verbose affiche bien la liste de tous les chemins traites (et d'autres informations eventuellement)"
echo -e 
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name lacet.txt --verbose"
echo -e 
echo "	execution correcte de idem.sh avec l'option '--verbose' en dernier argument."
echo "		Resultat : Affiche la description de la recherche effectue"
echo -e 
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name lacet.txt --verbose
read
clear


#--- RECHERCHE IGNORANT LA CASSE : -name est forcé à -iname
echo -e 
echo "Test de la commande '-name' force a '-iname' :"
echo "-name affiche bien la liste de tous les fichiers recherche avec IGNORE_CASE non vide"
echo -e 
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name toTo"
echo "Avec IGNORE_CASE non vide"
IGNORE_CASE=TRUE ;
export IGNORE_CASE
echo -e 
echo "	execution correcte de idem.sh avec l'expression '-name' en ignorant la casse."
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
echo "La commande executer est : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -iname toTo"
echo -e
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name toTo
echo -e "\n"

sleep 1

echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name TOto"
echo "Avec IGNORE_CASE non vide"
echo -e 
echo "	execution correcte de idem.sh avec l'expression '-name' en ignorant la casse."
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
echo "La commande executer est : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -iname TOto"
echo -e
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name TOto
echo -e "\n"
IGNOR_CASE= ;
export IGNORE_CASE

read
clear


# --- RECHERCHE SIMPLE : -name
echo -e 
echo "Test de la commande -name :"
echo "-name affiche bien la liste de tous les fichiers recherche avec IGNORE_CASE vide "
echo -e 
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name trente.txt"
echo -e 
echo "	execution correcte de idem.sh avec l'expression '-name' apres le chemin."
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name trente.txt
echo -e "\n"

sleep 1

echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/sourd -name opportunite.txt"
echo -e 
echo "	execution correcte de idem.sh avec l'expression '-name'"
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -name opportunite.txt
echo -e "\n"

sleep 1

echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/tressaillant ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/sourd ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/Puissance -name toto"
echo -e 
echo "	execution correcte de idem.sh avec l'expression '-name' dans plusieurs chemin different."
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
./idem.sh ../data/tressaillant ../data/sourd ../data/Puissance -name toto
echo -e "\n"

sleep 1

echo "idem.sh execute la commande : ./idem.sh -name monsieur.txt ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data"
echo -e 
echo "	execution correcte de idem.sh avec l'expression '-name' avant le chemin."
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
./idem.sh -name monsieur.txt ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data
echo -e "\n"

read
clear


# --- RECHERCHE POUR UNE TAILLE FIXEE : 
echo -e 
echo "Test de la commande -size avec une taille fixe :"
echo "-size affiche bien la liste de tous les fichiers recherche ayant la taille correspondante."
echo -e 
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size 983"
echo -e 
echo "	execution correcte de idem.sh avec l'expression 'size'"
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size 983
read
clear


# --- INCLUDES
echo -e 
echo "Test de la commande -includes :"
echo "-includes affiche bien la liste de tous les fichiers recherche ayant la taille correspondante."
echo -e 
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/specialincludes -includes mots.txt"
echo -e 
echo "	execution correcte de idem.sh avec l'expression 'includes'"
echo "		Resultat : Affiche le(s) fichier trouve qui contiennent les mots contenus dans mot.txt"
echo -e 
./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/specialincludes -includes mots.txt
read
clear


# --- SUITE DE LA DEMONSTRATION
echo -e "\n\n\n\n"
echo "	Ceci est la suite de la demonstration de idem.sh"
read
clear
		
# --- RECHERCHE AVEC DIFFERENTE TAILLE
echo -e 
echo "Test de la commande -size avec l'option verbose :"
echo "-size affiche bien la liste de tous les fichiers recherche ayant la taille correspondante."
echo -e 
echo "idem.sh execute la commande : ./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size +3000"
echo -e 
echo "	execution correcte de idem.sh avec l'expression 'size' et l'option -v"
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size +3000
read
clear

echo -e
echo "Test de la commande -size avec l'option verbose :"
echo "-size affiche bien la liste de tous les fichiers recherche ayant la taille correspondante."
echo -e 
echo "idem.sh execute la commande : ./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size -2000"
echo -e 
echo "	execution correcte de idem.sh avec l'expression 'size' et l'option -v"
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e 
./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size -2000
read
clear

	# --- Test des erreurs possible
	echo -e
	echo "Test des erreurs possible avec un argument non compatible apres -size"
	echo -e 
	echo "Test de la commande -size avec l'option verbose si la taille apres le '+' n'est pas un entier :"
	echo "idem.sh execute la commande : ./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size +20gh0"
	echo -e 
	echo "	execution INcorrecte de idem.sh avec l'expression 'size' et l'option -v"
	echo "		Resultat : Affiche une erreur"
	echo -e 
	./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size +20gh0
	echo -e "\n"
	
	sleep 1
	
	echo -e 
	echo "Test de la commande -size avec l'option verbose si la taille apres le '-' n'est pas un entier :"
	echo "idem.sh execute la commande : ./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size -20gh0"
	echo -e 
	echo "	execution INcorrecte de idem.sh avec l'expression 'size' et l'option -v"
	echo "		Resultat : Affiche une erreur"
	echo -e 
	./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size -20gh0
	echo -e "\n"
	
	sleep 1
	
	echo -e 
	echo "Test de la commande -size avec l'option verbose si la taille n'est pas un entier :"
	echo "idem.sh execute la commande : ./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size 98fd3"
	echo -e 
	echo "	execution correcte de idem.sh avec l'expression 'size' et l'option -v"
	echo "		Resultat : Affiche une erreur"
	echo -e 
	./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size 98fd3
	echo -e "\n"
	
	sleep 1
	
	echo -e 
	echo "Test de la commande -size avec l'option verbose si la taille n'est pas un entier :"
	echo "idem.sh execute la commande : ./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size"
	echo -e 
	echo "	execution correcte de idem.sh avec l'expression 'size' et l'option -v"
	echo "		Resultat : Affiche une erreur"
	echo -e 
	./idem.sh -v ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -size
	read
	clear
	
# --- INAME
echo -e 
echo "Test de la commande -iname :"
echo "idem.sh execute la commande : ./idem.sh --verbose ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -iname tren??.txt"
echo -e 
echo "	execution correcte de idem.sh avec l'expression '-iname' en ignorant la casse."
echo "		Resultat : Affiche le(s) fichier trouve"
echo -e
./idem.sh --verbose ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data -iname tren??.txt
echo -e
read
clear

# --- PAS D'ARGUMENT
echo -e 
echo "Test de la commande sans argument :"
echo "idem.sh execute la commande : ./idem.sh"
echo -e 
echo "	execution INcorrecte de idem.sh sans argument"
echo "		Resultat : Affiche une erreur"
echo -e
./idem.sh
echo -e "\n\n"

sleep 1

# --- UN SEUL ARGUMENT (chemin)
echo -e 
echo "Test de la commande un argument chemin:"
echo "idem.sh execute la commande : ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/sourd"
echo -e 
echo "	execution INcorrecte de idem.sh sans argument"
echo "		Resultat : Affiche une erreur"
echo -e
 ./idem.sh ~/SupportCours/S1T/ASR3/Leopaul_MARTIN/data/sourd
echo -e "\n\n"

sleep 1

# --- UN SEUL ARGUMENT (expression)
echo -e 
echo "Test de la commande un argument expression :"
echo "idem.sh execute la commande : ./idem.sh -size 985"
echo -e 
echo "	execution correcte de idem.sh sans argument"
echo "		Resultat : Affiche une erreur"
echo -e
 ./idem.sh -size 985
read
clear

# --- fin du script teste.sh
echo "Ceci est la fin du teste.sh"
echo "Appuiyer sur une touche pour sortir du programme"
echo -e
read
clear

exit