CODE SEGMENT
  ASSUME CS:CODE

  PUBLIC affichage
  ;procedure affichage
  ;entree:adresse de la variable a afficher
  ;sortie:affichage d'une ligne de texte
affichage PROC FAR  
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
