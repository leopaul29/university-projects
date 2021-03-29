# Correction TP3 / exercice 4.3
cd
# maintenant on est certain d'être à la racine de notre HOME directory
cd ASR3/TP3/6
gzip -c carre_bleu_* > CARRE-c.gz
cat carre_bleu_* | gzip > CARRE-cat.gz
ls -l CARRE-c*
#-rw-r--r-- 1 syska 10598 580798  2 oct.  07:36 CARRE-cat.gz
#-rw-r--r-- 1 syska 10598 577737  2 oct.  07:35 CARRE-c.gz
# 3061 octets de différence dans le mauvais sens :-)
# à suivre ...
