#! /bin/bash
# generer un gros fichier sur /partage en salle 756
cd /partage
rm -rf fich*
cp /boot/vmlinuz* fich #vmlinuz -> noyau
for i in {1..10}
do
    cat fich fich >> fich2 2>/dev/null
    mv fich2 fich
done
mv fich BIGFOO
ls -lh BIGFOO
