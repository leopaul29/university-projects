#!/bin/bash

# --- nano projet --- #

# Nom de l'auteur : Léo-Paul MARTIN
# Date : 
# Version : 4



# --- Declaration des variables utilisées dans le script.

chemin=""
fich=""
fichdos=""
name=""
iname=""
size=""
taille=""
taille2=""
includes=""
expres=""
verbose=""
help=""
erreur=""
ficherr=""
excep=""
mots=""



# --- Test tous les arguments et les stocke dans des variable.

while [[ $# -ge 1 ]] # --- Tant qu'il y a un argument ou plus, alors idem.sh le test.
do

case $1 in

	-name) # --- Test avec -name.

		if [[ $IGNORE_CASE ]]
			then
				iname="-iname"
				shift
				fich=$1
			else
				name=$1
				shift
				fich=$1
		fi
		# --- Si il y a un argument derrière alors c'est le fichier à rechercher. Sinon c'est une erreure.
		if [[ $fich == "" ]]
			then
				erreur="9"
		fi

	;;

	-iname) # --- Test avec -iname.

		iname=$1
		shift
		fich=$1
		# --- Si il y a un argument derrière alors c'est le fichier à rechercher. Sinon c'est une erreure.
		if [[ $fich == "" ]]
			then
				erreur="9"
		fi

	;;

	-size) # --- Test avec -size.

		size=$1
		shift
		taille=$1
		# --- Si il y a un argument derrière alors c'est la taille à rechercher. Sinon c'est une erreure.
		if [[ $taille == "" ]]
				then
					erreur="5"
			else
				if  [[ "$(echo $taille | grep "^[+]")" ]] # --- Si l'argument commence par un "+" alors je le supprime pour tester si l'argument est un entier.
					then
						taille2=$(echo $taille | tr -d [+])
						
						if  [[ "$(echo $taille2 | grep "^[ [:digit:] ]*$")" ]]
							then
								taille="$1c" # --- exemple : 4096 devient 4096c pour la recherche en octet
							
							else
								erreur="2"	
						fi
				fi
					
				if  [[ "$(echo $taille | grep "^[-]")" ]] # --- Si l'argument commence par un "-" alors je le supprime pour tester si l'argument est un entier.
					then
						taille2=$(echo ${taille/#-/})
						
						if  [[ "$(echo $taille2 | grep "^[ [:digit:] ]*$")" ]]
							then
								taille="$1c"
								
							else
								erreur="3"
						fi
				fi
				
				if  [[ $taille2 == "" ]] # --- Si la variable $taille2 est vide, c'est que l'argument ne commencait pas par un "+" ou un "-" . Je le teste pour savoir si c'est un entier.
					then
						if [[ "$(echo $taille | grep "^[ [:digit:] ]*$")" ]]
							then
								taille="$1c"
							else
								erreur="4"
						fi
				fi
		fi
		
	;;

	-v) # --- Test avec -v.

		verbose="1"

	;;

	--verbose) # --- Test avec --verbose.

		verbose="1"

	;;

	-h) # --- Test avec -h.

		help="1"

	;;

	--help) # --- Test avec --help.

		help="1"

	;;

	-includes) # --- Test avec -includes.

		includes="1"
		shift
		fich=$1
		# --- Si il y a un argument derrière alors c'est le fichier texte qui contient les mots à rechercher. Sinon c'est une erreure.
		if [[ $fich == "" ]]
			then
				erreur="7"
				echo $erreur
			else
				if [[ $(echo $(file -b -i $1 | cut -d '/' -f1)) == "text" ]] # --- Je test si c'est bien un fichier texte.
					then
						fich=$1
					else
						ficherr=$1
						includes=""
						erreur="8"
				fi
		fi

	;;

	*) # --- Si ça n'est pas une des possibilité précédentes.
		
		if [[ -d "$1" ]] # --- Si $1 est un répertoire alors je l'ajoute dans la variable $chemin sinon c'est une erreur.
			then
				chemin="$chemin $1"
			else
				erreur="10"
				ficherr=$1
				break
		fi

	;;

	esac # --- Fin du Case.

shift # --- décalage à gauche d'un argument (suppression de $1).

done # --- Fin de boucle.



# --- si un des arguments est -v alors $verbose=1 et explique ce que fait idem.sh comme recherche.

while [[ $verbose == "1" && $erreur == "" ]]
do

	verbose="idem.sh recherche dans le(s) repertoire(s) \"$chemin\""
	
	if [[ $name != "" ]] # --- Si c'est une recherche par nom.
		then 
			echo $verbose" le fichier \"$fich\""
			echo -e
	fi

	if [[ $iname != "" ]] # --- Si c'est une recherche par motif.
		then 
			echo $verbose" le ou les fichiers qui ont le motif \"$fich\""
			echo -e
	fi

	if [[ `echo ${taille:0:1}` == '+' ]] # --- Si c'est une recherche par taille qui commence par un "+".
		then
			echo $verbose" les fichiers de taille superieur a "$taille2"c"
			echo -e
	fi

	if [[ `echo ${taille:0:1}` == '-' ]] # --- Si c'est une recherche par taille qui commence par un "-".
		then 
			echo $verbose" les fichiers de taille inferieure a "$taille2"c"
			echo -e
	fi

	if [[ $size != "" && "${taille//[0-9]/}" && "${taille::1}" != '+' && "${taille::1}" != '-' ]]  # --- Si c'est une recherche par taille.
		then
			echo $verbose" le(s) fichier(s) de la taille de "$taille
			echo -e
	fi
	
	if [[ $includes != "" ]] # --- Si c'est une recherche par le contenu de mots.
		then
			echo $verbose" les fichiers verifier avec un fichier contenant quelques mots lus dans un fichier texte."
	fi
	
done



# --- Si un des arguments est -includes alors $includes=1 et idem.sh recherche dans le(s) repertoire(s) les fichiers contenant tous mots lus dans un fichier texte.

if [[ $includes == "1" ]]
	then
		typeset -i i 
		i=0
		
		for line in $(cat $fich) # --- Lit les mots d'un fichier texte.
		do
			expression=$line
			
			i=$i+1 # --- On incrémente i utile pour nommer les fichiers et pour savoir combient de fois on passe dans la boucle.

			# --- On met les resultats de la recherche des fichiers dans un fichier.
			grep -l $expression $chemin* > resultatincludes"$i"

			# --- Seulement apres avoir fait UNE boucle on compare les resultat deux a deux des fichier de resultat.
			if [[ $i != 1 ]]
			then
			# --- La commande "comm -12" permet de garder que les doublons, soit les fichiers contenant tous les mots recherchés.
			comm -12 resultatincludes1 resultatincludes"$i" > resultat
			rm -f resultatincludes"$i" # --- On supprime chaque fichiers temporaire après utilisation.
			fi
			
		done
		cat resultat # --- On affiche le resultat.
		rm -f resultatincludes1 resultat
	exit '14'
fi

# --- Execution du script si il n'y a pas d'erreur. Sinon idem.sh sort du script en affichant une description de l'erreur survenu.

if [[ $erreur == "" ]] # --- Gestion des differentes execution
	then		
		 # --- Si un des arguments est -h ou --help alors $help=1 
		if [[ $help == "1" ]]
			then
				cd ../man # more ../man/idem.txt OU avec less mais pas dans le teste, sinon on ne voit pas toute la description # ou utiliser less
				cat idem.txt
				exit '1'
		fi
		
		# --- Si il n'y a pas de chemin ou pas d'argument du tout.
		if [[ $# == 0 && $chemin == "" ]] 
			then
				echo "Il n y a pas d argument"
				echo -e "Astuce : Utiliser le manuel de la commande avec -h ou --help"
				exit '2'
		fi
		
		# --- Si il n'y a pas de paramètre, idem.sh rechecher dans les chemins sans paramètre.
		if [[ $name == "" && $iname == "" && $size == "" && $chemin != "" ]] 
			then
				echo "Il n y a pas d argument"
				echo -e "Astuce : Utiliser le manuel de la commande avec -h ou --help"
				# Pour rechercher par chemin et sans paramètre : 'find $chemin -type f'
				exit '3'
			else # --- Sinon idem.sh recherche avec les paramètres.
				find $chemin $name $iname $fich $size $taille -a -type f
				exit '4'
		fi

	else # --- Gestion des erreurs.
	
		# --- Test la valeur de erreur.
		
		case $erreur in
		
			"2") echo "Les caracteres qui compose la taille apres le '+' ne sont pas numerique" ; exit '5';;
			"3") echo "Les caracteres qui compose la taille apres le '-' ne sont pas numerique" ; exit '6';;
			"4") echo "Les caracteres qui compose la taille apres '-size' ne sont pas numerique" ; exit '7' ;;
			"5") echo "Il manque un argument de type numerique entier apres '-size'" ; exit '8' ;;
			"7") echo "Il n'y a pas d'argument apres '-includes'" ; exit '9' ;;
			"8") echo "L'argument \""$ficherr"\" n'est pas compatible avec l'option -includes" ; exit '10' ;;
			"9") echo "Il manque un argument de type dossier ou fichier" ; exit '11' ;;
			"10") echo  "L'argument \""$ficherr"\" n'est pas compatible avec idem.sh" ; exit '12' ;;
		esac
fi

exit '13'
echo $?