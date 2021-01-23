#! /usr/bin/env python
# -*- coding:Utf8 -*-

# Simple éditeur de texte

def f1(ch):
    nouv = ""
    i, j = 0, len(ch) -1
    while i < j:
        nouv = nouv + ch[i]
        i = i + 1
    return nouv

def f2():
    of = open(nomF, 'a')
    while 1:
        ligne = input("entrez une ligne de texte (ou <Enter>) : ")
        if ligne == '':
            break
        else:
            of.write(ligne + '\n')
    of.close()

def f3():
    print("==================================================================")
    of = open(nomF, 'r')
    while 1:
        ligne = of.readline()
        if ligne == "":
            break
        # afficher en omettant le dernier caractère (= fin de ligne) :
        print(f1(ligne))
    of.close()
    print("==================================================================")


nomF = input('Nom du fichier : ')
while 1:
    choix = input('Entrez "e" pour écrire, "c" pour consulter les données, "q" pour quitter : ')
    if choix =='e':
        f2()
    elif choix == 'c':
        f3()
    else :
        break
