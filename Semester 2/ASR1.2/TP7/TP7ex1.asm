
PILE SEGMENT STACK
;segment de pile
	DW 256 DUP(?)
PILE ENDS


DATA SEGMENT
; declarer vos donnees ici
    text DB 10,13,"L heure actuelle est : "	
    hd DB ?
    hu DB ?,'h'
    md DB ?
    mu DB ?,'m'
    sd DB ?
    su DB ?,'s'
    cd DB ?
    cu DB ?,'c','$'
DATA ENDS

    
CODE SEGMENT
;Segment de code

 
;Converti le premier parametre (valeur entre 0 et 99) en 2 caractere ASCII.
;Les parametre sont passes par la pile
;IN : parametre 1 : la valeur a convertir en texte
;     parametre 2 : vide, il sert juste pour le retour
;OUT: parametre 1 : la valeur ASCII de l'unite
;     parametre 2 : la valeur ASCII de la dizaine
conversionValeurASCII PROC NEAR
    PUSH BP
    PUSH AX
    PUSH BX     
    MOV BP, SP
    MOV AX, [BP+10]     
    MOV BL, 10
    DIV BL        
    MOV BL, AH
    MOV BH, 0
    ADD BX, 48     
    MOV [BP+10], BX     
    MOV AH, 0
    ADD AX, 48    
    MOV [BP+8], AX     
    POP BX
    POP AX
    POP BP
    
    RET
conversionValeurASCII ENDP

ASSUME CS:CODE, DS:DATA, SS:PILE   ; positionnement des registres de segment.

main:	MOV AX,DATA ; initialisation du segment de donnees
	MOV DS,AX

	MOV AX,PILE
	MOV SS,AX   ; initialisation du segment de pile
	
; ecrire votre code ici
    
    MOV BH, 10
boucle:
    ;lecture heure
    MOV AH, 02ch
    INT 021h
    
    ;Maj et conversion
    MOV AX, 0
    MOV Al, CH  ;mettre CH dans AX   
    PUSH AX  ;parametre 1
    PUSH AX  ;parametre 2 (vide)
    CALL conversionValeurASCII  ;appele de la fct    
    POP AX   
    MOV hd, AL   ;recuperer parametre sorti 1 (dizaine)
    POP AX
    MOV hu, AL   ;recuperer parametre sorti 2 (unite) 
    
     
         
    MOV AX, 0
    MOV Al, CL  ;mettre CH dans AX    
    PUSH AX  ;parametre 1
    PUSH AX  ;parametre 2 (vide)    
    CALL conversionValeurASCII  ;appele de la fct     
    POP AX   
    MOV md, AL   ;recuperer parametre sorti 1 (dizaine)
    POP AX
    MOV mu, AL   ;recuperer parametre sorti 2 (unite) 
    
    
    
    MOV AX, 0
    MOV Al, DH  ;mettre CH dans AX     
    PUSH AX  ;parametre 1
    PUSH AX  ;parametre 2 (vide)     
    CALL conversionValeurASCII  ;appele de la fct     
    POP AX   
    MOV sd, AL   ;recuperer parametre sorti 1 (dizaine)
    POP AX
    MOV su, AL   ;recuperer parametre sorti 2 (unite)
    
    
    
    MOV AX, 0
    MOV Al, DL  ;mettre CH dans AX      
    PUSH AX  ;parametre 1
    PUSH AX  ;parametre 2 (vide)     
    CALL conversionValeurASCII  ;appele de la fct    
    POP AX   
    MOV cd, AL   ;recuperer parametre sorti 1 (dizaine)
    POP AX
    MOV cu, AL   ;recuperer parametre sorti 2 (unite)
    
    
    ;afficher resultat
    MOV DX, offset text
    MOV AH, 09h
    INT 021h  
    
    
    DEC BH
    CMP BH, 0
    JNE boucle

 

    
            
fin:
	MOV AH,4CH 	; Les 2 lignes necessaires pour la 
	INT 21H		; fin du programme	
CODE ENDS
END main ; indique l'étiquette de début du programme





;affichage PROC NEAR  ; Procedure: affichage
  ;PUSH AX
  ;PUSH DX
  
  ;MOV DX, offset text
  ;MOV AH, 09h
  ;INT 021h  ; Sortie: affiche le contenu de la variable text 
  
  ;POP DX 
  ;POP AX
   
  ;RET
;affichage ENDP  ; fin de la procedure  

 ;;;;;;;;;;
    ;MOV CX, 3
;repeat: ;pas de CX de libre, pas de LOOP
 
    ;recuperer H/M/S/C en octet (DX et CX)
    
    
    ;Maj msg + conversion en mot (2octet) X4

    ;CALL affichage
    
    ;afficher le resultat    


;LOOP repeat 