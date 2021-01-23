PILE SEGMENT STACK
;segment de pile
    DW 256 DUP(0)
base:
PILE ENDS 
 
 
DATA SEGMENT 
; declarer vos donnees ici	
    msgClair DB "ABCD$"
    key DW 130, 40, 5, 99 ;16 DUP('D','Z','Y','F') 
    msgChiffre DB 4 DUP('0')
    text DW "Le message chiffre est : $"
; ici on declare les variable  

DATA ENDS


CODE SEGMENT
;Segment de code

ASSUME CS:CODE, DS:DATA, SS:PILE    ; positionnement des registres de segment.

main:
    MOV AX, DATA    ; initialisation du segment de donnees
    MOV DS, AX
    
    MOV AX, PILE
    MOV SS, AX      ; initialisation du segment de pile
     
    MOV SP, base 

; ici on ecrit le corps du programme

    MOV AH,msgClair[0]
    MOV AL,msgClair[1]
    MOV BH,msgClair[2]
    MOV BL,msgClair[3]

    MOV CX,key[1]
    MOV DX,key[2]

    XOR CX,BX
    XOR AX,CX

    XOR DX,AX
    XOR BX,DX

    MOV msgChiffre[0],AH
    MOV msgChiffre[1],AL
    MOV msgChiffre[2],BH
    MOV msgChiffre[3],BL

    MOV DX,offset text
    MOV AH,09h
    INT 021h
     
    MOV CX,4 
    MOV SI,0 
affiche: 
    MOV DX,0
    MOV DL,msgChiffre[SI]
    MOV AH,02h
    INT 021h 
    INC SI
LOOP affiche 

fin:
	MOV AH,4CH 	; Les 2 lignes necessaires pour la 
	INT 21H		; fin du programme	
CODE ENDS
END main ; indique l'etiquette de debut du programme