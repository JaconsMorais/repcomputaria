! FORTRAN = FORmula TRANslatio
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!
! Exemplo: C�lculo do raio de um c�rculo de raio r
! area= pi*r**2
!
!Colunas 1-5: n�mero das instru��es ou roteiros
!Coluna  6: linha de continua��o de um comando ou instru��o
!Colunas 7-72: comandos e instru��es
!Colunas 73-81: campo de identifica��o
!
!Tipos de vari�veis
!
!INTEIRAS: integer, integer*2, integer*4
!
!Ex. integer*2 - 2 -> comprimento associado em bytes
!                     ocupa 1/2 palavra de memoria (2 bytes)
!
!REAIS: real, real*4, real*8, real*16 e double precision=real*8
!
      REAL*8 area, pi, r  !ou implicit real*8(a-h,o-z)
	data pi/3.1415d0/   !atribui��o antes da execu��o do programa
!     pi=3.1415d0 atribui��o durante a execu��o do programa
!
!COMANDOS DE ENTRADA E SA�DA
!
!Abrir um arquivo
      open(1,file='dados.dat',status='unknown')
!1 = unidade
!status: as condi��es do arquivo dependem do sistema operacional
!status =old, new, ou scratch (o arquivo � apagado quando acabar a execu��o)
!
!ENTRADA
!
      write(*,10) !imprime na tela
	read(*,11) r !l� via tela
!	print*,r !imprime o valor da vari�vel na tela
	write(*,11) r !idem
 10   format(' raio do circulo')
 11	format(F5.2)
!
!F5.2 -> F: para dados reais
!        5: vari�vel expressa em um campo de 5 caracteres
!	   2: 2 casas decimais
!
!I3   -> I: n�meros inteiros
!	   3: vari�vel expressa em um campo de 3 caracteres
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