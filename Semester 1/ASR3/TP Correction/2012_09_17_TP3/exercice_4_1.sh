# Correction TP3 / exercice 4.1
cd
# maintenant on est certain d'être à la racine de notre HOME directory

mkdir -p ASR3/TP3
# si le répertoire ASR3/TP3 n'existe pas on le crée
# attention, ce n'est pas /ASR3/TP3 (si vous ne comprenez pas : demander d'urgence 
# 

cp -r /SupportCours/S1T/ASR3/2012_09_17_TP3/6 ASR3/TP3
# cp récursif : pour copier les répertoires et sous-répertoires
# source : /SupportCours/S1T/ASR3/2012_09_17_TP3/6 (ici chemin absolu)
# destination : ASR3/TP3 (ici chemin relatif)
cd ASR3/TP3
cp 6/Test.txt .
cp Test.txt copie_Test.txt
gzip copie_Test.txt
ls -l
# on a divisé par plus de 200 la taille du fichier original
zcat copie_Test.txt.gz
ls -l 6/carre_bleu*
# bons taux de compression sur certains formats, mais pas sur le GIF par exemple
# en fait, les algorithmes de gif et gzip sont similaires
# les images font 420*300 pixels codés sur 3 octets (24 bits de couleur),
# il faut donc  au moins 378000 octets pour stocker la couleur de chaque pixel
# si le format est brut (sans compression)
