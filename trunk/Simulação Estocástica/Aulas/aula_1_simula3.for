! C�lculo da m�dia aritm�tica e desvio-padr�o
!
!media = soma das n variaveis x / n
!
!var = (soma das n variaveis x**2 - (soma das n variaveis)**2/n)/n 
!
!dp = dsqrt(var)
!
!nval=n�mero de valores
!val = valor de cada vari�vel
!
      soma =0.0d0
	i=0
1	i=i+1
!        
!if l�gico
      if (i.gt.nval) stop
	read(*, ) val
	soma=soma + val
! goto condicional
      goto 1
	media = soma/dfloat(n)
! dfloat ou dble converte inteiro em real
!
! outro modo 
      do j=1,n
	  read(*, ) val
	  soma=soma + val
	  if(i.gt.nval) goto 2 
	end do
2     continue
      media =soma/dfloat(n)
!
!C�lculo da vari�ncia

!C�lculo do desvio-padr�o
	end