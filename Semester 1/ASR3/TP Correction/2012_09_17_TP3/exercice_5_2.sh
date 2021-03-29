# Correction TP3 / exercice 5.2
cd
# maintenant on est certain d'être à la racine de notre HOME directory

tar zcvf TP_Linux.tar.gz /SupportCours/S1T/ASR3/2012_09_10_TP2
tar ztvf TP_Linux.tar.gz  | more

# tar zrvf ~/TP_Linux.tar.gz /SupportCours/S1T/ASR3/2012_09_03_TP1
# tar: Une archive compressée ne peut pas être mise à jour
# Pour en savoir davantage, faites : « tar --help » ou « tar --usage ».
# Il faut procéder en trois étapes :
gunzip TP_Linux.tar.gz
tar rvf ~/TP_Linux.tar /SupportCours/S1T/ASR3/2012_09_03_TP1
gzip TP_Linux.tar.gz

tar zxvf TP_Linux.tar.gz -C ASR3/TP3
cd ASR3/TP3
# où se trouvent nos TP1 et TP2? A essayer et conclure.
tree SupportCours/
