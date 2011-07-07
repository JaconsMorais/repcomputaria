%include "io.mac"

.STACK 1024

.CODE

.DATA

aux DW 0
contar DB 0
fim DB 0
TEXT DB "Digite o numero de bits ",0

.STARTUP

shift_left: ;Shift AX:BX:CX para a esquerda.Caso queiram para a direita, troque SHR por SHL, SHL por SHR e a ordem dos registradores na rotina (de CX-BX-AX para AX-BX-CX)

PutStr TEXT ;pega o número de bits
GetLInt EAX
MOV [fim],EAX

MOV CX, DX ; Move CX para pegar o último bit

SHL CX,1 ; Faz Shift em CX

SHR DX, 15 ; pega o último bit de CX para ser o primeiro bit de BX

MOV BX,[aux] ; Move BX para uma variável auxiliar

SHL BX,1 ; Faz Shift em BX, e...

OR BX, DX ; ...para completar o Shift agora, é preciso fazer a transição entre os dois registradores. Para isso, faço um OR com o DX, pois é com DX que está o bit (não fui muito feliz com o carry)

MOV [aux],DX ; Move aux(antes BX) para pegar o último bit

SHR DX, 15 ; repito o mesmo procedimento usado em BX com o AX
SHL AX,1
OR AX, DX

INC [contar] ; mais uma rotina se foi

MOV EDX,[fim] ; corrige bug

CMP [contar],EDX ; compara a contagem com o número de bits

JNE shift_left ;se não for igual, continua o shift

.EXIT