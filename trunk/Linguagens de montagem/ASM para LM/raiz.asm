%include "io.mac"

.STACK 1024

.CODE

.DATA

complemento DB " - ",0

.STARTUP

     MOV EAX,1 ;raiz
     MOV EBX,1 ;auxiliar para achar o numero da raiz
     MOV ECX,1 ;numero - soma de todos os EBX
     
Imp:     CMP ECX,255
         JGE Fim
         PutLInt EAX
         PutStr complemento
         PutLInt ECX
         nwln
         JL Prox
Prox:     ADD EBX,2
          ADD ECX,EBX
          INC EAX
          JMP Imp

Fim: .EXIT
