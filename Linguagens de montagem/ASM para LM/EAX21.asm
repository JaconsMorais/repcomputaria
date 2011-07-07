%include "io.mac"

.STACK 1024

.CODE

.DATA

TEXT DB "DIGITE UM NUMERO ",0 ; Variáveis usadas para ver o comportamento da rotina
TEXT2 DB "X21 = ",0

.STARTUP

PutStr TEXT ; Imprime texto

GetLInt EAX ; Pega valor - =Valor=Valor*2^0

MOV EBX,EAX ; Move para um registrador auxiliar

SHL EAX,2 ;=Valor*4=Valor*2^2

MOV ECX,EAX ; Move para um registrador auxiliar

SHL EAX,2;=Valor*4*4 = Valor*16=Valor*2^4

ADD EAX,EBX;=Valor*16+Valor=Valor*17

ADD EAX,ECX;=Valor*17+Valor*4=Valor*21

nwln
PutStr TEXT2 ;Imprime resultado
PutLInt EAX 

.EXIT