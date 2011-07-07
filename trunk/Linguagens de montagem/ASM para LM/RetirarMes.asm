%include "io.mac"

.STACK 1024

.CODE

.DATA

bMes DW 0 ; Vari�vel onde ser� colocada o m�s

.STARTUP

     MOV DX, 0010011001101010B ; O DX inicialmente tem esse valor

     MOV AX, DX ; Coloca o valor de DX em um registrador auxiliar. Afinal, devo preservar a data e pegar apenas o m�s

     AND AX, 0000000111100000B ; m�scara para ter apenas os bits do m�s, que s�o os que est�o marcados com '1'

     SHR AX, 5 ; Faz o Shift para obter o valor original. AX � deslocado 5 bits para a direita e o que era 0000000111100000B fica 0000000000001111B, por exemplo

     MOV [bMes], AX ; Move o m�s para a vari�vel

     PutInt bMes ; Exibe o m�s
     PutInt AX ; Linha dispens�vel, mas h� um "bug" no bMes que n�o entendi. � o que deveria ser exibido

.EXIT