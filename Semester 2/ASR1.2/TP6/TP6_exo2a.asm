
PILE SEGMENT STACK
;segment de pile
	DW 256 DUP(?)
PILE ENDS


DATA SEGMENT
; declarer vos donnees ici
    msgF DB "Ce n'est pas un palindrome",10,13,'$'
    msg DB 10,13,"La chaine '" 
    tab DB 65 DUP('$')
    msgV DB 10,13,"C'est un palindrome",10,13,'$'   
    
    demSaisi DB "Saisir un phrase (64 caractere maximum)",10,13,'$'
	

DATA ENDS

CODE SEGMENT
;Segment de code

ASSUME CS:CODE, DS:DATA, SS:PILE   ; positionnement des registres de segment.   

 
;Procedure: lireChar
;Entree: aucun
;Sortie: le caractere lu par la pile (dans les 8Bits de poids faible)
lireChar PROC NEAR
    PUSH AX
    PUSH BP  
    
    MOV BP, SP
    MOV AH, 01h
    INT 021h
    ;al contient le caractere
    MOV [BP+8], AX  
    
    POP BP
    POP AX
  RET
  lireChar ENDP

    extrn affichage1 : far
    extrn affichage : far
     
main:	
    MOV AX,DATA ; initialisation du segment de donnees
	MOV DS,AX

	MOV AX,PILE
	MOV SS,AX   ; initialisation du segment de pile
	
;ecrire votre code ici

;Lecture de la chaine de caracteres (taille max 64 octets) 
;saisie au clavier par l utilisateur. 

;demande saisie de chaine
    CALL affichage1  
    
;saisie de la chaine
    MOV CX, 64
    MOV SI, 0 
    
BoucleLec:
    PUSH AX ;parametre vide pour
    ;reserver un place dans la pile pour recuperer le parametre dans la procedure 
                  
    CALL lireChar ;pas de parametre ;resultat, le char par la pile 
    
    POP BX ;char dans BL
    CMP BL, '$'
    JE finLec
    
    MOV tab[SI], BL 
    INC SI 
    
    LOOP BoucleLec
    
  finLec:
    
;Verification si la chaine est bien un palindrome 
    DEC SI ;pointeur de fin
    MOV DI, 0 ;pointeur de debut
     
BouclePal:    
    CMP DI, SI
    JGE finPal
    
    MOV AL, tab[SI] ;AL contient le char de fin
    MOV AH, tab[DI] ;AL contient le char de debut

    CMP AL, AH
    JNE finPal
    
    DEC SI
    INC DI    
    
    JMP BouclePal
    
  finPal:

;Affichage d un message contenant la chaine et
;indiquant si celle-ci est bien un palindrome.
  
  ;pal   
    MOV AX, offset msg
    PUSH AX
    CALL affichage    
    CMP DI, SI
    JL nonPal
    
  ;estPal:
    MOV AX, offset msgV 
    PUSH AX
    CALL affichage
    JMP fin
    
  nonPal:
    MOV AX, offset msgF
    PUSH AX
    CALL affichage
  
  ;non pal
  

fin:
	MOV AH,4CH 	; Les 2 lignes necessaires pour la 
	INT 21H		; fin du programme	
CODE ENDS
END main ; indique l'étiquette de début du programme


