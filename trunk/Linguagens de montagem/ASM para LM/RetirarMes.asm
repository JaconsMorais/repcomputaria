%include "io.mac"

.STACK 1024

.CODE

.DATA

bMes DW 0 ; Variável onde será colocada o mês

.STARTUP

     MOV DX, 0010011001101010B ; O DX inicialmente tem esse valor

     MOV AX, DX ; Coloca o valor de DX em um registrador auxiliar. Afinal, devo preservar a data e pegar apenas o mês

     AND AX, 0000000111100000B ; máscara para ter apenas os bits do mês, que são os que estão marcados com '1'

     SHR AX, 5 ; Faz o Shift para obter o valor original. AX é deslocado 5 bits para a direita e o que era 0000000111100000B fica 0000000000001111B, por exemplo

     MOV [bMes], AX ; Move o mês para a variável

     PutInt bMes ; Exibe o mês
     PutInt AX ; Linha dispensável, mas há um "bug" no bMes que não entendi. É o que deveria ser exibido

.EXIT