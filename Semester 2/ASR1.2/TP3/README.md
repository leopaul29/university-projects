# TP3


Le segment Stack :
ici on réserver de la mémoire

Le segment Data :
	ici on déclare les variables et les constantes

Le segment Code :
	ici on déclare les fonctions publiques,
	ici on déclare les fonctions externes,
ici on déclare les fonctions locales,
on précise a l'aide d'un commentaire son nom, ses entrées et ses sorties,
Procédure: name
Entrée: ...
Sortie: ...

Le bloc qui commence par « debut: » et fini par « fin: » :
	ici on écrit le corps du programme

Un segment fini commence toujours par « NomSegment SEGMENT ‘Type’ » et fin par « ENDS ». Un segment à une taille entre 0 et un de maximum de 2^16 octet soit 65 535K

END nom : le nom est celui du fichier et marque la fin du fichier (pas du programme)
Pas d’espace entre l’étiquette et « : » (ex : debut: )
Derrière « END » se situe le SEUL point d’entré (ex : Le main en C)
Si il y a un deuxième fichier « xxx.asm » alors il fini par « END » et sans nom car il n’y a qu’un point d’entrée du programme

La première instruction du code copie l’adresse du segment DATA dans le registre AX.
DATA est l’adresse du Segment

ASSUME CS:CODE, DS:DATA, SS:STACK
ASSUME déclare les variables du progralles
Initialise CODE avec l’adresse de CS, CODE 
Initialise STACK avec l’adresse de SS, CODE
Initialise DATA avec l’adresse de DS

/ !\ il n’existe pas d’instruction MOV Registre, [Mémoire]
Dès qu’on à un segment, il doit d’abord passer par AX (question de câblage du processeur)

La cinquième instruction est initialise et mais la valeur 200 à SP.

Tableau :
nomVariable Type Valeur, Valeur, Valeur, …
nomVariable Type NombreCase DUP (Valeur)



STACK : ici Nom et Type
Type DB : define byte (8bit)
Type DW : define word (16bit)
? : Valeur par défaut / non initialisé

Pour ajouter un segment, il y a 2 cas :
- il prend la dernière adresse du précedent segment qui fini par (0000) si multiple de 16
- sinon on cherche le premier multiple de 16 pour s’ajouter

Adresse dans le segment : 16bit
Adresse globale : 20bit

Adresse local du premier octet : 0(b) ou 0(h)
Adresse local du dernier octet : 2*256 -1 = 512-1 = 511(b) ou 1FF(h)

1er Q : Pourquoi mon adresse est représentée par 5 caractères, hexadécimales ?
Adresse sur 20 bite car le bus d’adresse AC en à 20 bits possibles

2 ème Q : Quel est l’adresse mémoire de mon première octet réservé sur la pile ?
Adresse mémoire du segment SS : 07100h
Adresse mémoire du premier octet est 07100+@=07100

Après l’exécution de la première instruction, la valeur décimale du registre AX est 0730 puis 0710

Base est une pile qui pointe sur la première adresse libre (200h)
Dernière adresse de la pile (2^20 - 1 = FFFFFh)
L’adresse globale de cet octet est x@h

3 ème Q : Quel est l’adresse de mon premier octet dans mon segment de donnée ?
L’adresse du segment DS est 0730h
DS contient deux variables (first =12 13 sec=1)
Soit l’adresse du premier octet est 07300h (car l’adresse de first est 0)

4 ème Q : Quel sera la valeur contenu dans le registre IP ?
La valeur de « debut: »
Elle augmente à chaque instruction.


## EXERCICE 1 :

2) Valeur de AX : 07300h
Adresse de l’étiquette Base dans le segment de Pile : 200h
Adresse dans la mémoire : 07100h

Adresse local BASE 200h
Adresse globale BASE 07100h + 200h = 07300h
MOV AX,0730h

3) la valeur du registre de segment est 20 bit – 4 bit de poids faible (0000) = 16 bit
=> L’adresse globale

4) Augmenter la taille de la pile à 1024 octet
La valeur de BASE est 400h
Adresse globale devient 07100h + 400h = 07500h
MOV AX,0750h

## EXERCICE 2 :

Valeur en bit : Valb
Valeur en hexa : 0Valh

DATA SEGMENT 
    ; ici on declare les variable  
    b0 DB 1
    b1 DB 255
    b2 DB -1
    b3 DB 'e'
    b4 DB 032h
    b5 DB 0ffh
    b6 DB 1b
    b7 DB 11111111b
    b8 DB ?
    b9 DB ?
    
    do0 DW 1 /!\ Sur 2 octet
    do1 DW 255
    do2 DW -1
    do3 DW 'e'
    do4 DW 032h
    do5 DW 0ffh
    do6 DW 1b
    do7 DW 11111111b
    do8 DW ?
    do9 DW ? 
    
    tb DB 1,255,-1,'e',032h,0ffh,1b,11111111b,?,?
    td DW 1,255,-1,'e',032h,0ffh,1b,11111111b,?,?
      
    ; nomVariable Type NombreCase DUP (Valeur)
    tab DB 152 DUP(111)
    tad DW 150 DUP(43981)                                                                 

DATA ENDS

Valeur de « -1 » : 	Bit signé : 	1000 0001
			C1 : 		1111 1110
			C2 : 		1111 1111
			Exced 128 : 	0111 1111
Valeur ‘e’ : 101 => valeur ASCII

/ !\ Les bit en mémoire de poids faible auront une adresse qui sera plus faible que celle des poids fort

DS = 0731h
Donner les adresses dans le segment et l’adresse mémoire de b6,d7,tab et tad
	@seg		@Mem
b6	6h		07300+(1*16)=07316
d7	18h		07328h0		
tab	3Ch		0734Ch
tad	D4h		073E4h

1,2,…,9,A,C,E,10,12,…

## EXERCICE 3  :


