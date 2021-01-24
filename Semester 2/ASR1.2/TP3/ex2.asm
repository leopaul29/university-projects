STACK SEGMENT STACK
   DW 256 DUP(0)
base:
STACK ENDS 
	
DATA SEGMENT 
    ; ici on declare les variable  
    b0 DB 1
    b1 DB 255
    b2 DB -1
    b3 DB 'e'
    b4 DB 032h
    b5 DB 0ffh
    b6 DB 1b
    b7 DB 11111111b
    b8 DB ?
    b9 DB ?
    
    do0 DW 1
    do1 DW 255
    do2 DW -1
    do3 DW 'e'
    do4 DW 032h
    do5 DW 0ffh
    do6 DW 1b
    do7 DW 11111111b
    do8 DW ?
    do9 DW ? 
    
    tb DB 1,255,-1,'e',032h,0ffh,1b,11111111b,?,?
    td DW 1,255,-1,'e',032h,0ffh,1b,11111111b,?,?
      
    ; nomVariable Type NombreCase DUP (Valeur)
    tab DB 152 DUP(111)
    tad DW 150 DUP(43981)                                                                 

DATA ENDS

CODE SEGMENT
   ASSUME CS:CODE, DS:DATA, SS:STACK
   
   ; ici on declare les fonctions publiques
   
   ; ici on declare les fonctions externes
                                                                                   
   
   ; ici on declare les fonctions locales
   ; on precise a l'aide d'un commantaire 
   ; son nom, ses entrees et ses sorties
   
   ; Procedure: name
   ; Entree: ...
   ; Sortie: ...

debut:
   MOV AX, DATA
   MOV DS, AX

   MOV AX, STACK
   MOV SS, AX 
   MOV SP, base  
	
   ; ici on ecrit le corps du programme

fin:         
   MOV AH, 4CH 
   INT 21H  
CODE ENDS
END debut
