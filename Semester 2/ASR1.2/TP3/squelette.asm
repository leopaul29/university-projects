PILE SEGMENT STACK
   DW 256 DUP(0)
base:
PILE ENDS 
	
DATA SEGMENT 
    ; ici on declare les variable
  MAX DW 0 
  MIN DW 0
DATA ENDS

CODE SEGMENT
   ASSUME CS:CODE, DS:DATA, SS:STACK
main:
  MOV AX,DATA ; initialisation du segment de donnees
  MOV DS,AX

  MOV AX,PILE
  MOV SS,AX   ; initialisation du segment de pile
  MOV SP,Base ; initialise la pile a vide
             
  MOV AX, 1
  MOV BX, 7

;;;;;;;;;;;;;;;;
 
  CMP AX, BX
  JGE else   ;JG
  MOV MIN, AX
  JMP fi  
else:
  MOV MIN, BX  
fi:

;;;;;;;;;;;;;;;;

  MOV BX, 3
  MOV AX, 1
  MOV CX, 5
  
for:
  CMP CX, BX
  JLE rof 
  
  ADD AX, CX 
  
  DEC CX
  JMP for
rof:
  
;;;;;;;;;;;;;;;;  

while:
  CMP AX, 10
  JE elihw
  
  ADD CX, AX 
  ADD CX, AX
  ADD CX, AX
  ADD CX, AX
  
  INC AX
  JMP while

elihw:
  
;;;;;;;;;;;;;;;;

  MOV BX, 2
  MOV CX, 21
  
;repeat:
  ;CMP CX, 0
  ;JE taeper
  ;DEC CX
  ;ADD BX, BX
  ;JMP repeat
;taeper:  

repeat:
  ADD BX, BX
  ;LOOP repeat
  DEC CX
  CMP CX, 0
  JNE repeat
  
;;;;;;;;;;;;;;;;

  CMP CX, 1
  JNE c2
  MOV BX, 1
  JMP hctiws ;break;
c2:
  CMP CX, 2
  JNE c3
  MOV BX, 5
  JMP hctiws ;break;
c3:
  CMP CX, 3
  JNE default
  MOV BX, 7
  JMP hctiws ;break;
default:
  MOV BX, 0
hctiws:  
  
  
          
  MOV AH, 4CH 
  INT 21H  
CODE ENDS
END main
