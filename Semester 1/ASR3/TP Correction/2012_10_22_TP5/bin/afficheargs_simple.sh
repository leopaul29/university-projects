#!/bin/bash
#
# afficheargs_simple.sh
#
#     exercice sur les arguments de la ligne de commande
#     Exemple
#     ./afficheargs2.sh un deux trois quatre cinq six sept huit neuf dix onze douze treize
#
#     Auteur : ms
#     Date de creation : 09 11 2012
#             derniere modification : 09 11 2012 (TP5 S1T ASR3)
#

echo
echo '8 : while (( $# ))'
echo

while  (( $# ))
do
  echo "Il reste $# arguments <$*> et \$1 vaut : $1"
  shift
done










