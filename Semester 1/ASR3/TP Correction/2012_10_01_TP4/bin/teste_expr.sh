#!/bin/bash
# ASR3 TP4 semaine du 01 octobre 2012
# teste_expr.sh
#
#     exercice sur la manipulation des variables numeriques
#     auteur : ms
#     version du 23/10/2012

# Initialisation des variables
S='Exercice 3'
typeset -i i j s p
i=2
j=3
echo "Les variables utilisees sont S=$S, i=$i, j=$j, s=$s et p=$p"

# Saisie de i et j
echo -n "Entrez les valeurs de i et j separees par un blanc : "
read i j

# Calculs

s=i+j
p=i*j
echo "Les nouvelles valeurs sont S=$S, i=$i, j=$j, s=$s et p=$p"
