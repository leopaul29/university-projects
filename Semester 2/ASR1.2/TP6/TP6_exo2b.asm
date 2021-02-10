DATA SEGMENT
; declarer vos donnees ici
    msgF DB "Ce n'est pas un palindrome",10,13,'$'
    msg DB 10,13,"La chaine '" 
    tab DB 65 DUP('$')
    msgV DB 10,13,"C'est un palindrome",10,13,'$'   
    
    demSaisi DB "Saisir un phrase (64 caractere maximum)",10,13,'$'
	

DATA ENDS

CODE SEGMENT
  ASSUME CS:CODE

  PUBLIC affichage1   

;Procedure: affichage1 
;Entree: aucun
;Sortie: affiche le contenu de la variable demSaisi
affichage1 PROC far  
    PUSH AX
    PUSH DX  
    
    MOV DX, offset demSaisi
    MOV AH, 09h
    INT 021h 
      
    POP DX 
    POP AX 
  RET
  affichage1 ENDP ; fin de la procedure 
   
   

   
   
   PUBLIC affichage
;Procedure: affichage 
;Entree: aucun
;Sortie: affiche le contenu de la variable demSaisi
affichage PROC far  
    PUSH AX  
    PUSH BP
    PUSH BX 
    
    MOV BP, SP
    MOV DX, [BP+10]
    MOV AH, 09h
    INT 021h 
    
    POP BX
    POP BP 
    POP AX
  RET 2
  affichage ENDP
     
CODE ENDS
END    