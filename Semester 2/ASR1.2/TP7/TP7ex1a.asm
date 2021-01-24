CODE SEGMENT

ASSUME CS:CODE

PUBLIC conversionValeurASCII

 
;Converti le premier parametre (valeur entre 0 et 99) en 2 caractere ASCII.
;Les parametre sont passes par la pile
;IN : parametre 1 : la valeur a convertir en texte
;     parametre 2 : vide, il sert juste pour le retour
;OUT: parametre 1 : la valeur ASCII de l'unite
;     parametre 2 : la valeur ASCII de la dizaine
conversionValeurASCII PROC FAR
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

CODE ENDS
END 