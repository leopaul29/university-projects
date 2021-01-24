                             
PILE SEGMENT STACK
;segment de pile
	DW 256 DUP(?)
PILE ENDS


DATA SEGMENT
; declarer vos donnees ici	

DATA ENDS

CODE SEGMENT
;Segment de code

ASSUME CS:CODE, DS:DATA, SS:PILE   ; positionnement des registres de segment.
                                  
;IN : P1 = colonne origine 
;   : P2 = ligne origine 
;   : P3 = couleur 
;   : P4 = taille en pixels
;OUT: aucun  

;procedure P1:
P1 PROC NEAR  
    MOV AL, 1100b
    MOV AH, 0ch
    RET
ENDP P1

    

main:	MOV AX,DATA ; initialisation du segment de donnees
	MOV DS,AX

	MOV AX,PILE
	MOV SS,AX   ; initialisation du segment de pile
	
; ecrire votre code ici

;creer point    
    MOV al, 13h
	MOV ah, 0
	INT 10h
	               
    ;couleur rouge
    PUSH AX
	CALL P1
	POP AX
	
;affiche une ligne vers la droite	
	MOV cx, 125
boucle1:
    MOV dx, 20
	MOV ah, 0ch
	INT 10h
	
	CMP cx, 25
	JE boucle2	
LOOP boucle1

;affiche une ligne vers le bas  
boucle2:       
    MOV cx, 25
    INT 10h    
    INC dx  
    
    CMP dx, 120
    JE boucleR
LOOP boucle2   

;recommence depuis le debut (en haut a droite)
boucleR:
    MOV cx, 125 
    MOV dx, 20

;affiche une ligne vers le bas           
boucle3:
    INC dx 
    INC cx
	INT 10h

	CMP dx, 120 
	JE boucle4	
LOOP boucle3 

;affiche une ligne vers la droite    
boucle4:    
     INT 10h
     
     CMP cx, 25
     JE boucleR2
LOOP boucle4

boucleR2:   
     
	
fin:
	MOV AH,4CH 	; Les 2 lignes necessaires pour la 
	INT 21H		; fin du programme	
CODE ENDS
END main ; indique l'étiquette de début du programme
