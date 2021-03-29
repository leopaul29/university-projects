# Exercice 2.3.4 TP2
cd ~/ASR3/TP2/
# On suppose que ce répertoire existe
# Sauvegarde de INFO dans ~/ASR3/TP2/INFO_SAUVE
# cp -r INFO INFO_SAUVE

cd INFO
mkdir S1 S2 S3 S4

mv AP/API/ S1
mv AP/APO/ S3
mv AP/WEB2/ S2

mv ASR/ASR1/ S1
mv ASR/ASR2/ S2
mv ASR/ASR3/ S1
mv ASR/ASR4/ S3
mv ASR/ASR5/ S2
mv ASR/WEB1/ S1

mv OMGL/OMGL1/ S1
mv OMGL/OMGL2/ S3
mv OMGL/SGBD1/ S1
mv OMGL/SGBD2/ S4

# Les répertoires AP ASR et OMGL sont vides et peuvent être supprimés
rmdir AP ASR OMGL
