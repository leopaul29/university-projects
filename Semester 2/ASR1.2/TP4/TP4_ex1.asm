PILE SEGMENT STACK
  DW 256 DUP(?)
base:         
PILE ENDS

DATA SEGMENT
  N1 DW 5
  N2 DW 3
  N3 DW -1	
  N4 DW 5 
  Re DB 0
DATA ENDS

CODE SEGMENT
  ASSUME CS:CODE, DS:DATA, SS:PILE
main:
  MOV AX,DATA ; initialisation du segment de donnees
  MOV DS,AX

  MOV AX,PILE
  MOV SS,AX   ; initialisation du segment de pile
  MOV SP,Base ; initialise la pile a vide
             
  MOV AX, N1
  MOV BX, N2
  MOV CX, N3
  MOV DX, N4
 
  CMP AX, DX
  JE egaux           ; si ax=dx alors on va a l'etiquette egaux
  ;JZ egaux          
  MOV Re, 2
egaux:
  ADD Re, 5
  CMP BX, CX
  JL inf             ; si bx<cx alors on va a l'etiquette inf
  ;JB inf
  ADD Re, 2
  JMP et1
inf:     
  SUB Re, 2
et1:
  CMP BX, 24
  JGE sup            ; si bx>24 alors on va a l'etiquette sup

  ADD Re, 255
sup:
  INC AX
  CMP AX, DX
  JE egaux2          ; si ax=dx alors on va a l'etiquette egaux2
  SUB Re, 5
  JMP fin            
egaux2:
  ADD Re, 5 
  CMP CX, 26
  JLE infeg          ; si cx<=26 alors on va a l'etiquette infeg
  DEC Re
infeg:
  ADD Re, 1   
  CMP N1, 0xFFFDh
  JE egal             ; si N1=FFFDh alors on va a l'etiquette egal
  SUB Re, 10           
egal:
  CMP N4,0
  JL fin        ; si N4<0 alors on va a l'etiquette fin  
  
  ADD Re, 3
fin:	
  MOV AH,4CH  ; Les 2 lignes necessaires pour la 
  INT 21H	  ; fin du programme	
CODE ENDS
END main
