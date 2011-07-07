!Dada uma equa��o de segundo grau
!a*x**2+b*x+c=0 que possui duas raizes x1 e x2, cujos 
!valores podem ser encontrados atrav�s das f�rmulas
!x1 = (-b + dsqrt(b**2 -4.0d0*a*c)2.0d0*a
!x1 = (-b - dsqrt(b**2 -4.0d0*a*c)2.0d0*a
!
!Calcule as ra�zes da equa��o
!
!Observa��o; 1) Se a = 0 -> 2a=0, x ter� valor infinito
!            2) Criticar o valor de delta
!
!Comandos decontrole defluxo
!1. Estrutura sequ�ncial (bloco1, bloco2, etc.)
!2. Estrutura se-ent�o-sen�o (if-then-else)
!3. Estrutura de la�o: fa�a-enquanto (do while)
!4. Estrutura de la�o repeti��o; repeat-loop
!
!Declarar as variaveis

!Abrir arquivo

!entrada

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!Express�es relacionais
!a = b           -> a.eq.b
!a diferente b   -> a.ne.b
!a < b           -> a.lt.b
!a > b           -> a.gt.b
!a <= b		   -> a.le.b
!a >= b          -> a.ge.b
!
!Express�es l�gicas
! .not.a  -> nega��o l�gica 
!         -> se a � verdade -> .not.a � falso
!		-> se a � falso   -> .not.a � verdade
!a.and.b  -> conjun��o l�gica
!		-> se a e b s�o verdade -> a.and.b � verdade
!		-> se a e b s�o falso   -> a.and.b � falso
!a.or.b   -> disjun��o inclusivo l�gica
!		-> se a e b ou ambos s�o verdade -> a.or.b � verdade
!		-> se a ou b s�o falso -> a.or.b � falso
!a.eqv.b  -> equival�ncia l�gica 
!		-> se a e b s�o ambos verdade ou ambos falsos -> 
!               a.eqv.b � verdade; caso contr�rio � falso
!a.neqv.b -> se a e b s�o ambos verdade ou ambos falsos ->
!               a.neqv.b � falso, caso contr�rio � verdade
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!
!Criticar o valor de a
      if (a.eq.0) then
	  write(*,20)
20	  format(' o valor de a eh zero')
        stop
	end if
!Calcular o valor de delta

!Criticar o valor de delta
      if (delta.lt.0) then
	   write(*,30)
30	   format(' valor de delta negativo')
 	   stop
	end if
!Valores das raizes x1 e x2


	end