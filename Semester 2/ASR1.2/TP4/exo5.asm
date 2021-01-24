STACK SEGMENT STACK
   DW 256 DUP(0)
base:
STACK ENDS 
	
DATA SEGMENT
    ; declarer vos donnees ici 
    msg db "Saisir un entier compris entre 0 et 9 : $"  
    somme db "la somme des valeurs saisies vaut $"
    min db "La valeur min est ",'$'                  
    max db "La valeur max est ",'$'
    nl db 10, 13, '$'
        
   
DATA ENDS

CODE SEGMENT 
; segment de code
   ASSUME CS:CODE, DS:DATA, SS:STACK   ; positionnement des registres de segment

main:
    MOV AX, DATA  ; initialisation du segment de donnees
    MOV DS, AX

    MOV AX, STACK
    MOV SS, AX    ; initialisation du segment de pile
    MOV SP, base                         
                    
                    
    ;Lecture valeur  
    MOV CX, 5
lecture: 

    ;;;Afficher un message
    MOV DX, OFFSET msg
    MOV AH, 09h
    INT 021h
   
    ;;;;;;;;;;Lecture d'une valeur 
    MOV AH, 01h
    INT 021h 
   
    ;;;Save valeur
    SUB AL, 48 ; pour convertir le caractere ascii (CHar) en vAL
    MOV AH, 0
    PUSH AX
   
    ;Afficher un retour a la ligne
    MOV DX, OFFSET nl
    MOV AH, 09h
    INT 021h
LOOP lecture     
   
   
   
   
    ;;;;;;;;;;;Calcul Somme
   
    ;;Init
    MOV BP, SP
    MOV CX, 5 ; compteur
    MOV BX, 0 ; resultat

    ;;;Calcul somme
sum:        
    ADD BX, [BP]
    ADD BP, 2

LOOP sum            
   
    ;;;Affiche message              
    MOV DX, OFFSET somme
    MOV AH, 09h
    INT 021h
   
    ;;;Affiche valeur                 
    CMP BL, 10
    JL unite
    MOV AX, BX
    MOV CL, 10
    DIV CL
          
    MOV BL, AH
    ADD AL, 48
          
    MOV DL, AL
    MOV AH, 02h
    INT 021h
          
unite:
    ADD BX, 48
    MOV DL, BL 
    MOV AH, 02h
    INT 021h

    ;;;Afficher le retour a la ligne 
    MOV DX, OFFSET nl
    MOV AH, 09h
    INT 021h
   
   
   
   
    ;;;;;;;;;;Recherche min max     
       
       
    ;;;Init
    MOV BP, SP ; on recupere le haut de la pile
    MOV CX, 4 ; compteur
    MOV AX,[BP]; 
    MOV DX,[BP]
    ADD BP,2
                 
Minmax: 
    CMP AX, [BP]
    JLE AXInferieurBP   ;SI la nouvelle valeur de BP est Superieure a AX ALors AX = [BP]
    MOV AX,[BP]
       
AXInferieurBP:
    CMP DX, [BP]    
    JGE DXSuperieurBP   ;if la nouvelle valeur de BP est Inferieur a DX ALors DX = [BP]
    MOV DX,[BP]
            
DXSuperieurBP:
    ADD BP, 2
LOOP Minmax     
            
    ;;; on recupere la valeur de AX 
        
    MOV CL, AL      ;CL recup la valeur minimum
    MOV CH, DL      ;CH recup la valeur maximum
        
    ;;;Afficher le message 
      
    ;;;Affiche le max  
    MOV DX, OFFSET max  
    MOV AH, 09h
    INT 021h  
            
    ADD CH,48 
    MOV DL,CH
    MOV AH,02h
    INT 021h
       
    ;;;retour a la ligne
    MOV AH, 09h
    MOV DX, OFFSET nl 
    INT 021h
        
    ;;;Affiche le min
    MOV DX, OFFSET min
    INT 021h
    ADD CL,48
    MOV DL, CL
    MOV AH, 02h
    INT 021h        

fin:         
    MOV AH, 4CH     ; Les 2 lignes necesaires pour la
    INT 21H         ; fin du programme
CODE ENDS
END main       ; indique l'etiquette de debut du programme