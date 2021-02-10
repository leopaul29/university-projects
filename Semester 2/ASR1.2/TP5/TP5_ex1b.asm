PILE SEGMENT STACK
  DW 256 DUP(?)
base:         
PILE ENDS

DATA SEGMENT
    text DB 10,13,"Ligne ",'0'," Ceci est ecrit pas votre premiere procedure",'$'  
    
    ;ou
    ;text DB 10,13,"Ligne "
    ;text2 DB '0' ou 48
    ;text3 DB " Ceci est ecrit pas votre premiere procedure",'$'

DATA ENDS

CODE SEGMENT
  ASSUME CS:CODE, DS:DATA, SS:PILE 
   
  affichage PROC NEAR  ; Procedure: affichage
  PUSH AX
  PUSH DX
  ;MOV DX, BX pour afficher avec le registre BX 
  ;MOV DX, offset text
  MOV AH, 09h
  INT 021h  ; Sortie: affiche le contenu de la variable text 
  POP DX 
  POP AX 
  RET
  affichage ENDP  ; fin de la procedure
   
   ; Entree: adresse de la variable, par le registre DX
     
   
debut:
  MOV AX,DATA ; initialisation du segment de donnees
  MOV DS,AX

  MOV AX,PILE
  MOV SS,AX   ; initialisation du segment de pile
  MOV SP,Base ; initialise la pile a vide   
  
  ;boucle
  MOV CX, 5
  MOV DX, offset text
repeat:  
  ;incrementation du compteur de ligne
  INC text[8]  
    ;ou INC text2
  
  ; affichage 
  ;DX est le parametre
  CALL affichage
LOOP repeat  
 
fin:
  MOV AH,4CH  ; Les 2 lignes necessaires pour la
  INT 21H	  ; fin du programme	
CODE ENDS
END debut
