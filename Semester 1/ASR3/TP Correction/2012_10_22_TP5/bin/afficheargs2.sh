#!/bin/bash
#
# afficheargs2.sh
#
#     exercice sur les arguments de la ligne de commande
#     Exemple
#     ./afficheargs2.sh un deux trois quatre cinq six sept huit neuf dix onze douze treize
#
#     Auteur : ms
#     Date de creation : 10 10 2005
#             derniere modification : 16 11 2011 (TP7 S1T ASR3)
#
echo "Execution de la commande $0"
echo "Nombre d'arguments : <$#>"
echo "Liste des arguments avec \$* : <$*>"
echo "Liste des arguments avec  \$@: <$@>"

typeset -i num

echo
echo '1: for arg in "$@"'
echo
num=1
for arg in "$@"
do 
  echo "Argument numero $num : $arg"
  num=num+1
done

echo
echo '2: for arg in $@'
echo
num=1
for arg in $@
do 
  echo "Argument numero $num : $arg"
  num=num+1
done

echo
echo '3: for arg in "$*" ne marche pas $* oui'
echo
num=1
for arg in "$*"
do 
  echo "Argument numero $num : $arg"
  num=num+1
done

echo
echo '4: for arg in $*'
echo
num=1
for arg in $*
do 
  echo "Argument numero $num : $arg"
  (( num++ ))
done

echo
echo '5.1: for arg in '
echo
for num in `eval echo {1.."$#"}`
do 
  eval arg=\${$num}
  echo "Argument numero $num : $arg"
done

echo
echo '5.2: for num in $(seq $#)'
echo
for num in $(seq $#)
do
  #echo $$num : faux !!!
  eval arg=\${$num}
  echo "Argument numero $num : $arg"
done

echo
echo '6: for ((num=1; num <= $# ; num++))'
echo
for ((num=1; num <= $# ; num++))
do
  eval arg=\${$num}
  echo "Argument numero $num : $arg"
done         

#~ echo
#~ echo '7 : while [ $# -ge 1 ]'
#~ echo
#~ num=1
#~ while [ $# -ge 1 ]
#~ do
  #~ echo "Argument numero $num : $1"
  #~ shift
  #~ num=num+1
#~ done
#~ echo
echo
echo '8 : while (( $# ))'
echo
num=1
while  (( $# ))
do
  echo "Il reste $# arguments, le numero $num est : $1"
  shift
  num=num+1
done










