				-----------------
				READ ME : idem.sh
				-----------------


------------------------
Auteur : L�o-paul MARTIN
Date : 21/12/2012
Version : 5
-----------


------------------------------------
le niveau de r�alisation du projet :
------------------------------------

	- Ce qui fonctionne :
		Le idem.sh peut r�aliser toutes les commandes demand�es dans la demonstration

	---------------------------------
	- "-includes" marche correctement
	---------------------------------

------
SAUF :
------
	-----------------------------------------------
	- la recherche simple avec un caract�re joker *
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

if [[ $excep != ""  ]] # --- si le fichier cherch� est un dossier
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
Autre possibilit� :
-------------------
	--------------------------------------------------------------
	- possiblit� de rechercher les fichiers qui sont des chemins :
	--------------------------------------------------------------
----------------------
commande d'execution :
----------------------

if [[ $name == "" && $iname == "" && $size == "" && $chemin != "" ]]	
	then	
		find $chemin -type f		
		exit	
	else # --- Sinon idem.sh recherche avec les param�tres
		find $chemin $name $iname $fich $size $taille -a -type f
		exit
fi


------------------------------------------------------------------------------------------
les �ventuelles parties communes avec d�autres projets et le nom des �tudiants concern�s :
------------------------------------------------------------------------------------------

Corentin JACQUEMET a quelques petites heures de nano projet pendant les 2 ou 3 premi�res 
semaines apr�s avoir donn� le sujet.
Il nous a seulement donn� quelques pistes et indications qui se sont trouv�es �tre pr�cis�es
dans le PDF "2012_11_19_nano_projet.pdf" seulement 2 semaines apr�s dans la rubrique
"6)COMMANDES UTILES ET CONSEIL"
Ses conseils (utiliser find // traiter/v�rifier TOUS les arguments puis effectuer les
traitements) ont donc �t� justifi�es.


Fin README