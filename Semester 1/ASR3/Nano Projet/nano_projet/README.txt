				-----------------
				READ ME : idem.sh
				-----------------


------------------------
Auteur : Léo-paul MARTIN
Date : 21/12/2012
Version : 5
-----------


------------------------------------
le niveau de réalisation du projet :
------------------------------------

	- Ce qui fonctionne :
		Le idem.sh peut réaliser toutes les commandes demandées dans la demonstration

	---------------------------------
	- "-includes" marche correctement
	---------------------------------

------
SAUF :
------
	-----------------------------------------------
	- la recherche simple avec un caractère joker *
	-----------------------------------------------
----------
commande :
----------

if [ $fich="`echo $fich | grep "*"`" ]

apres -name ou -iname pour tester si l'argument suivant est un joker * (mais il prennait tous les fichiers se trouvant dans /bin).

---------------
son execution :
---------------

if [[ $etoile=="1" ]]
	then
	find $chemin $name "*"
	exit
fi

	-----------------------------------------------------------------------------
	- impossible de tester si un fichier existe SI un ou plusieurs dossier separe
	-----------------------------------------------------------------------------

-----------
commande :
-----------

# --- test de l'argument $fich si il existe puis si c'est un dossier
fichdos="$chemin/$fich"
if [ -e $fichdos ]
	then	
		if [ -d $fichdos ]		
		then		
		excep="1"		
		fi
	else		
		erreur="10"
fi

-------------
son verbose :
-------------

if [[ $etoile == "1" ]]
	then
	echo $verbose" tous les fichiers existants"
fi
---------------
son execution :
---------------

if [[ $excep != ""  ]] # --- si le fichier cherché est un dossier
	then
	find $chemin $name $fich 
	exit
fi

----------
expemple :
----------

si on cherche dans "~/ ... /data" un fichier qui existe dans "~/ ... /data/sourd"
		alors la variable fichdos est egale a "~/ ... /data//lefichier"
		or "//" n'est pas un chemin.
		donc pas possible de tester TOUS les fichiers de l'arborescence

----------------------------------------------------------------------------

-------------------
Autre possibilité :
-------------------
	--------------------------------------------------------------
	- possiblité de rechercher les fichiers qui sont des chemins :
	--------------------------------------------------------------
----------------------
commande d'execution :
----------------------

if [[ $name == "" && $iname == "" && $size == "" && $chemin != "" ]]	
	then	
		find $chemin -type f		
		exit	
	else # --- Sinon idem.sh recherche avec les paramètres
		find $chemin $name $iname $fich $size $taille -a -type f
		exit
fi


------------------------------------------------------------------------------------------
les éventuelles parties communes avec d’autres projets et le nom des étudiants concernés :
------------------------------------------------------------------------------------------

Corentin JACQUEMET a quelques petites heures de nano projet pendant les 2 ou 3 premières 
semaines après avoir donné le sujet.
Il nous a seulement donné quelques pistes et indications qui se sont trouvées être précisées
dans le PDF "2012_11_19_nano_projet.pdf" seulement 2 semaines après dans la rubrique
"6)COMMANDES UTILES ET CONSEIL"
Ses conseils (utiliser find // traiter/vérifier TOUS les arguments puis effectuer les
traitements) ont donc été justifiées.


Fin README