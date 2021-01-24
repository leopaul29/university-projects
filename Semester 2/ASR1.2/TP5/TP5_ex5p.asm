PILE SEGMENT STACK
  DW 256 DUP(?)
base:         
PILE ENDS

DATA SEGMENT
    text DB 10,13,"Ligne ",'0'," Ceci est ecrit pas votre premiere procedure",'$'  
    
	;appel de procedure local -> pointeur local
	;NEAR = PUSH IP; JMP etiquette=MOV IP, etiquette
	
	;appel de procedure distante -> pas dans le meme segment, on change de segment -> pointeur distant
	;FAR = PUSH IP; PUSH CS; MOV CS:IP, etiquette=MOV CD,Val;MOV SP, Val
	
DATA ENDS

CODE SEGMENT
  ASSUME CS:CODE, DS:DATA, SS:PILE 
  
  extrn affichage : far
  
debut:
  MOV AX,DATA ; initialisation du segment de donnees
  MOV DS,AX

  MOV AX,PILE
  MOV SS,AX   ; initialisation du segment de pile
  MOV SP,Base ; initialise la pile a vide   
  
  ;boucle
  MOV CX, 5
repeat2:  
  ;incrementation du compteur de ligne
  INC text[8]
  
  ;affichage
  MOV BX, offset text
  PUSH BX
  CALL far ptr affichage ; far ptr : pointeur distant
LOOP repeat2  
 
fin:
  MOV AH,4CH  ; Les 2 lignes necessaires pour la
  INT 21H	  ; fin du programme	
CODE ENDS
END debut
