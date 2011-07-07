%include "io.mac"

.STACK 1024

.CODE

.DATA

val2 DW 8000H ; Variáveis dadas
val4 DW 7FFFH

.STARTUP

     MOV AX, 0 ;"Limpa" o AX

     SUB AX, [val2] ;-val2

     ADD AX, BX ;(-val2+BX)

     SUB AX, [val4];(-val2+BX)+val4

     PutInt AX ;Imprime resultado

.EXIT