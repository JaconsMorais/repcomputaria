! Cálculo da média aritmética e desvio-padrão
!
!media = soma das n variaveis x / n
!
!var = (soma das n variaveis x**2 - (soma das n variaveis)**2/n)/n 
!
!dp = dsqrt(var)
!
!nval=número de valores
!val = valor de cada variável
!
      soma =0.0d0
	i=0
1	i=i+1
!        
!if lógico
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
!Cálculo da variância

!Cálculo do desvio-padrão
	end