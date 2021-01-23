# TP4

## Exercice 1 :

Re = 0, 5, 7, *6, 

*7+255 = 6

INC AX = AX + 1 => AX = 6

La taille de la variable doit être la même quel le registre (16 bits).

## Exercice 2 :

### 2 . 1 : If

CMP AX, BX
JGE else   ;JG
MOV MIN, AX
JMP fi
else:
MOV MIN, BX
fi:

### 2 . 2 : For

for:
CMP CX, BX
JLE rof

ADD AX, CX

DEC CX
JMP for
rof:

### 2 . 3 : While

while:
  CMP AX, 10
  JE elihw
  
  ADD CX, AX 
  ADD CX, AX
  ADD CX, AX
  ADD CX, AX
  
  INC AX
  JMP while

elihw:

**/ !\ Multiplication avec :**
MOV BX, AX 		pour sauver la valeur de AX
MOV DL, 4
MUL DL
ADD CX, AX
MOV AX, BX

**Shift SHL(left) ou SHR(Right) pour décaler de x bit vers la gauche ou vers la droite**
MOV BX, AX 		    
SHL AX, 2
ADD CX, AX
MOV AX, BX

**PAS DE DEBORDEMENT, SINON RESULTAT DIFFERENT**

### 2 . 4 Repeat

  MOV BX, 2
  MOV CX, 21
  
repeat:
  CMP CX, 0
  JE taeper
  DEC CX
  ADD BX, BX
  JMP repeat
taeper:

-	instruction LOOP

repeat:
  ADD BX, BX
  ;LOOP repeat
  DEC CX
  CMP CX, 0
  JNE repeat

**DIFFERENCE entre boucle REPEAT et LOOP :**
**- Test fait au début dans repeat, pas forcement d’exécutions**
**- Test fait après dans loop, forcement une exécution**






### 2 . 5 Switch

CMP CX, 1
  JNE c2
  MOV BX, 1
  JMP hctiws ;break;
c2:
  CMP CX, 2
  JNE c3
  MOV BX, 5
  JMP hctiws ;break;
c3:
  CMP CX, 3
  JNE default
  MOV BX, 7
  JMP hctiws ;break;
default:
  MOV BX, 0
hctiws:

## Exercice 4 :

	Info-Pile :

	Dernier arrivé, premier sortie,
	Case mémoire en 16 bits,
	Fonctions : PUSH et POP,
	PUSH : dépose et SP monte ( SP =  SP - 2 ),
	POP : enlève et SP descend ( SP =  SP + 2 ),
	SP : Stack Pointeur, sur la dernière case mémoire occupé,
	Adresse local codé sur 16 bits ( 2^16 = 65 536 possibilité ),
	Adresse dernière case 65534,
	Adresse avant dernière case 65532,
	Pas le droit d’écrire la première adresse de la pile 
or SP = 35536 ! impossible sur 16 bits !
alors SP=0 mais point vers le haut,

4 . A 

POP AX
POP BX
POP CX
POP DX

	4 . B 

  POP AX
  POP BX
  
  ADD AX,BX
  
  ;ajouter votre code ici
  POP BX

  ADD AX,BX
  
  ;ajouter votre code ici
  POP BX

  ADD AX,BX
  MOV Res, AX

	4 . C

  POP AX
  POP BX
  POP CX
  POP DX
  
  ADD AX,BX
  ADD CX,DX
  
  ;ajouter votre code ici
  PUSH CX
  POP BX

  ADD AX,BX
  MOV Res, AX

## Exercice 5 :

-	Lecture Val
Afficher un Msg
Lire 1 valeur, 			X 5
Save valeur
Retour à la ligne
	
-	Calcul Somme
Init
Lecture Val			X 3
Somme
Affucher le resultat

-	Min / Max
*






**CODE :**



PILE SEGMENT STACK
;segment de pile
	DW 256 DUP(?)
PILE ENDS


DATA SEGMENT
; declarer vos donnees ici	
  msg DB "Saisir un entier entre 0 et 9 : ",'$'
  somme DB "La somme est : ",'$'
  min DB "Le min est : ",'$'
  max DB "Le max est : ",'$'
  nl DB 10,13,'$' ; chaine de caractere qui contient un retour a la ligne

DATA ENDS

CODE SEGMENT
;Segment de code

ASSUME CS:CODE, DS:DATA, SS:PILE   ; positionnement des registres de segment.

main:	MOV AX,DATA ; initialisation du segment de donnees
	MOV DS,AX

	MOV AX,PILE
	MOV SS,AX   ; initialisation du segment de pile
	
    ; ecrire votre code ici 
    ;lecture valeurs
    MOV CX, 5
lecture:

    ;;; afficher un message 
    MOV DX, offset msg
    MOV AH, 09h
    INT 021h
    
   
    ;;;;;;;; lecture d'une valeur
    MOV AH, 01h
    INT 021h
    
    ;;; save valeur
    SUB AL, 48 ; convert char to val
    MOV AH, 0
    PUSH AX 
    
    ; afficher retour a la ligne  
    MOV DX, offset nl
    MOV AH, 09h
    INT 021h
    LOOP lecture
       
    
    
    
    
    ;;;;;;;; calcul sommes
    
    ;; Init
    MOV BP, SP
    MOV CX, 5
    MOV BX, 0 
    ;;; Calcul somme
SUM:
    ADD BX, [BP]
    ADD BP, 2
        
    LOOP SUM
    
    ;;; Affiche message
    MOV DX, OFFSET somme
    MOV AH, 09h
    INT 021h
    
    ;;; affiche valeur 
    CMP BL, 10
    JL unite:
    MOV AX, BX
    MOV CL, 10
    DIV CL
    
    MOV BL, AH
    ADD AL, 48
    
    MOV DL, AL
    MOV AH, 02h
    INT 021h
    
unite:    
    ADD BL, 48
    MOV AL, BL
    MOV AH, 02h
    INT 021H
            
    ;;; affiche retour a la ligne
    MOV DX, OFFSET nl
    MOV AH, 09h
    INT 021h
    
      
    
    
   
    ; recherche min max
    
fin:
	MOV AH,4CH 	; Les 2 lignes necessaires pour la 
	INT 21H		; fin du programme	
CODE ENDS
END main ; indique l'étiquette de début du programme




