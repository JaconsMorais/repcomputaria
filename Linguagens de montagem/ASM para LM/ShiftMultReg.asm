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

PutStr TEXT ;pega o n�mero de bits
GetLInt EAX
MOV [fim],EAX

MOV CX, DX ; Move CX para pegar o �ltimo bit

SHL CX,1 ; Faz Shift em CX

SHR DX, 15 ; pega o �ltimo bit de CX para ser o primeiro bit de BX

MOV BX,[aux] ; Move BX para uma vari�vel auxiliar

SHL BX,1 ; Faz Shift em BX, e...

OR BX, DX ; ...para completar o Shift agora, � preciso fazer a transi��o entre os dois registradores. Para isso, fa�o um OR com o DX, pois � com DX que est� o bit (n�o fui muito feliz com o carry)

MOV [aux],DX ; Move aux(antes BX) para pegar o �ltimo bit

SHR DX, 15 ; repito o mesmo procedimento usado em BX com o AX
SHL AX,1
OR AX, DX

INC [contar] ; mais uma rotina se foi

MOV EDX,[fim] ; corrige bug

CMP [contar],EDX ; compara a contagem com o n�mero de bits

JNE shift_left ;se n�o for igual, continua o shift

.EXIT