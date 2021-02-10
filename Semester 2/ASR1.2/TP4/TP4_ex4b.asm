PILE SEGMENT STACK
  DW 256 DUP(?)
base:         
PILE ENDS

DATA SEGMENT
  N1 DW 1
  N2 DW 2
  N3 DW 3
  N4 DW 4
  Res DW 0
DATA ENDS

CODE SEGMENT
  ASSUME CS:CODE, DS:DATA, SS:PILE
main:
  MOV AX,DATA ; initialisation du segment de donnees
  MOV DS,AX

  MOV AX,PILE
  MOV SS,AX   ; initialisation du segment de pile
  MOV SP,Base ; initialise la pile a vide
             
  PUSH N1
  MOV N1, 0
  PUSH N2
  MOV N2, 0
  PUSH N3
  MOV N3, 0
  PUSH N4
  MOV N4, 0
 
  ;ajouter votre code ici 
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
fin:
  MOV AH,4CH  ; Les 2 lignes necessaires pour la
  INT 21H	  ; fin du programme	
CODE ENDS
END main
