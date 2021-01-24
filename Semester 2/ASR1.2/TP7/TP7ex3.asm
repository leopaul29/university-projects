STACK SEGMENT STACK
	DW 256 DUP(?) 
base:
STACK ENDS


DATA SEGMENT
    msg DB "Ma premiere interruption",10,13,'$'
    ancien DW ?,?  ;ES,BX
    nouveau DW ?,?
DATA ENDS


CODE SEGMENT
    ASSUME CS:CODE, DS:DATA, SS:STACK
 
    ;input l'adresse dans DX   
TraitantInt PROC
    ;PUSH DX
    PUSH AX 
    ;LEA DX, msg
    MOV AH, 09h
    INT 021h
    POP AX
    ;POP DX
 IRET
TraitantInt ENDP    
    
    
debut:
    MOV AX, Data
    MOV DS, AX
    MOV AX, Stack
    MOV SS, AX
    MOV SP, base
    
    
    ; Sauvegarde de l'ancien traitant
 ;; a completer    
    MOV AL, 0fdh
    MOV AH, 035h   ;permet de lire
    INT 021H
    
    MOV AX, ES
    MOV ancien, AX
    MOV ancien+2, BX
    
    ; Sauvegarde de DS
 ;; a completer
    MOV AX, DS
    PUSH AX
    
    ; Preparation des parametres pour la mise en place du traitant
 ;; a completer
    ;DS <- CD
    ;DX <- TraitantInt
    MOV AX, CS
    MOV DS, AX
    MOV DX, TraitantInt
    
    ; Mise a jour du vecteur d'interruption
 ;; a completer
    MOV AL, 0fdh
    MOV AH, 025h    ;ecrire Maj nouvelle valeur
    INT 21h 
    
    ; Restauration de DS
 ;; a completer
    POP AX
    MOV DS, AX
    
    ; Appel de l'interruption
 ;; a completer
    ;LEA DX, msg
    INT 0fdh
    
    ; Restauration du vecteur d'interruption
 ;; a completer
    MOV AX, ancien
    MOV DS, AX
    MOV DX, ancien+2
    
    MOV AL, 0fdh
    MOV AH, 025h    ;ecrire Maj ancienne valeur
    INT 21h

fin:
	MOV AH,4CH 
	INT 21H			

CODE ENDS
END debut ; indique l'étiquette de début du programme


