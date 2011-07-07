! FORTRAN = FORmula TRANslatio
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!
! Exemplo: Cálculo do raio de um círculo de raio r
! area= pi*r**2
!
!Colunas 1-5: número das instruções ou roteiros
!Coluna  6: linha de continuação de um comando ou instrução
!Colunas 7-72: comandos e instruções
!Colunas 73-81: campo de identificação
!
!Tipos de variáveis
!
!INTEIRAS: integer, integer*2, integer*4
!
!Ex. integer*2 - 2 -> comprimento associado em bytes
!                     ocupa 1/2 palavra de memoria (2 bytes)
!
!REAIS: real, real*4, real*8, real*16 e double precision=real*8
!
      REAL*8 area, pi, r  !ou implicit real*8(a-h,o-z)
	data pi/3.1415d0/   !atribuição antes da execução do programa
!     pi=3.1415d0 atribuição durante a execução do programa
!
!COMANDOS DE ENTRADA E SAÍDA
!
!Abrir um arquivo
      open(1,file='dados.dat',status='unknown')
!1 = unidade
!status: as condições do arquivo dependem do sistema operacional
!status =old, new, ou scratch (o arquivo é apagado quando acabar a execução)
!
!ENTRADA
!
      write(*,10) !imprime na tela
	read(*,11) r !lê via tela
!	print*,r !imprime o valor da variável na tela
	write(*,11) r !idem
 10   format(' raio do circulo')
 11	format(F5.2)
!
!F5.2 -> F: para dados reais
!        5: variável expressa em um campo de 5 caracteres
!	   2: 2 casas decimais
!
!I3   -> I: números inteiros
!	   3: variável expressa em um campo de 3 caracteres
!
!Calculo
!
      area=pi*r**2
!
!Saida
!
      write(1,20) r, area
20    format(' raio:',F5.2,4x,'area:',F8.2)
      write(*,20) r, area
	close(1)
	end