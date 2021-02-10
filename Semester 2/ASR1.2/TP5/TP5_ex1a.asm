PILE SEGMENT STACK
  DW 256 DUP(?)
base:         
PILE ENDS

DATA SEGMENT
    text DB 10,13,'Ceci est ecrit pas votre premiere procedure$' 

DATA ENDS

CODE SEGMENT
  ASSUME CS:CODE, DS:DATA, SS:PILE 
   
  affichage PROC NEAR  ; Procedure: affichage
  PUSH AX
  PUSH DX  
  MOV DX, offset text
  MOV AH, 09h
  INT 021h  ; Sortie: affiche le contenu de la variable text 
  POP DX 
  POP AX 
  RET
  affichage ENDP  ; fin de la procedure
   
   ; Entree: aucune
     
   
debut:
  MOV AX,DATA ; initialisation du segment de donnees
  MOV DS,AX

  MOV AX,PILE
  MOV SS,AX   ; initialisation du segment de pile
  MOV SP,Base ; initialise la pile a vide   
  
  ;boucle
  MOV CX, 5
repeat:
  
  ; affichage
  CALL affichage
LOOP repeat  
 
fin:
  MOV AH,4CH  ; Les 2 lignes necessaires pour la
  INT 21H	  ; fin du programme	
CODE ENDS
END debut
