# Exercice 2.3.2 TP2
cd ~/ASR3/TP2/INFO
# On suppose que ce répertoire existe
# Pour AP on effectue les copies depuis la position courante ~/ASR3/TP2/INFO
# cp avec source en chemin absolu et destination en chemin relatif
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_api_*.pdf AP/API/Cours/
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_apo_*.pdf AP/APO/Cours/
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_web2_*.pdf AP/WEB2/Cours/
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_api_*.pdf AP/API/TP/
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_apo_*.pdf AP/APO/TP/
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_web2_*.pdf AP/WEB2/TP/

# Pour ASR on se positione d'abord dans le répertoire cible
cd ASR/ASR1/Cours/
# cp avec source en chemin relatif et destination en chemin relatif
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_asr1_??.pdf .
cd ../TP
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_asr1_??.pdf .
cd ../../ASR2/Cours
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_asr2_??.pdf .
cd ../TP
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_asr2_??.pdf .
cd ../../ASR3/Cours
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_asr3_??.pdf .
cd ../TP
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_asr3_??.pdf .
cd ../../ASR4/Cours
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_asr4_??.pdf .
cd ../TP
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_asr4_??.pdf .
cd ../../ASR5/Cours
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_asr5_??.pdf .
cd ../TP
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_asr5_??.pdf .
cd ../../WEB1/Cours
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_web1_??.pdf .
cd ../TP
cp ../../../../../../../../../../SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_web1_??.pdf .

# Pour OMGL on se positione d'abord dans le répertoire  ~, c-à-d son HOMEDIR
# cp avec source et destination de type absolu
# ~/ est considéré de type absolu car lors de l'exécution de la commande, le caractére ~ est remplacé (substitution) par la valeur
# du chemin correspondant au HOMEDIR. Par exemple : /users/etudiant/d/dd232217/
# En cas de problème avec le caractère  ~, le remplacer par ce chemin
cd  ~

cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_omgl1_*.pdf ~/ASR3/TP2/INFO/OMGL/OMGL1/Cours
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_omgl2_*.pdf ~/ASR3/TP2/INFO/OMGL/OMGL2/Cours
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_sgbd1_*.pdf ~/ASR3/TP2/INFO/OMGL/SGBD1/Cours
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/Cours_sgbd2_*.pdf ~/ASR3/TP2/INFO/OMGL/SGBD2/Cours

cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_omgl1_*.pdf ~/ASR3/TP2/INFO/OMGL/OMGL1/TP
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_omgl2_*.pdf ~/ASR3/TP2/INFO/OMGL/OMGL2/TP
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_sgbd1_*.pdf ~/ASR3/TP2/INFO/OMGL/SGBD1/TP
cp /SupportCours/S1T/ASR3/2012_09_10_TP2/Vrac/TP_sgbd2_*.pdf ~/ASR3/TP2/INFO/OMGL/SGBD2/TP

