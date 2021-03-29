# Exercice 2.3.1 TP2

#~ [syska@linserv1 TP2]$ cd
#~ [syska@linserv1 ~]$ cd ASR3/TP2
#~ [syska@linserv1 TP2]$ cp /SupportCours/S1T/ASR3/2012_09_10_TP2/bin/creation_info.sh .
#~ [syska@linserv1 TP2]$ ls -l bin/creation_info.sh
#~ -rwxr-xr-x 1 syska 10598 643 19 sept. 04:13 bin/creation_info.sh
#~ [syska@linserv1 TP2]$ bash bin/creation_info.sh

cd ~/ASR3/TP2
# On suppose que ce répertoire existe

mkdir INFO
cd INFO
# AP
mkdir AP ASR OMGL
mkdir -p AP/API/Cours
mkdir AP/API/TP
mkdir -p AP/APO/Cours
mkdir AP/APO/TP
mkdir -p AP/WEB2/Cours
mkdir AP/WEB2/TP
# ASR
mkdir -p ASR/ASR1/Cours
mkdir ASR/ASR1/TP
mkdir -p ASR/ASR2/Cours
mkdir ASR/ASR2/TP
mkdir -p ASR/ASR3/Cours
mkdir ASR/ASR3/TP
mkdir -p ASR/ASR4/Cours
mkdir ASR/ASR4/TP
mkdir -p ASR/ASR5/Cours
mkdir ASR/ASR5/TP
mkdir -p ASR/WEB1/Cours
mkdir ASR/WEB1/TP
# OMGL
cd OMGL
mkdir OMGL1 OMGL2 SGBD1 SGBD2
cd OMGL1
mkdir Cours TP
cd ../OMGL2
mkdir Cours TP
cd ../SGBD1
mkdir Cours TP
cd ../SGBD2
mkdir Cours TP
 
 
