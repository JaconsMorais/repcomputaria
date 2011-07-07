!Dada uma equação de segundo grau
!a*x**2+b*x+c=0 que possui duas raizes x1 e x2, cujos 
!valores podem ser encontrados através das fórmulas
!x1 = (-b + dsqrt(b**2 -4.0d0*a*c)2.0d0*a
!x1 = (-b - dsqrt(b**2 -4.0d0*a*c)2.0d0*a
!
!Calcule as raízes da equação
!
!Observação; 1) Se a = 0 -> 2a=0, x terá valor infinito
!            2) Criticar o valor de delta
!
!Comandos decontrole defluxo
!1. Estrutura sequêncial (bloco1, bloco2, etc.)
!2. Estrutura se-então-senão (if-then-else)
!3. Estrutura de laço: faça-enquanto (do while)
!4. Estrutura de laço repetição; repeat-loop
!
!Declarar as variaveis

!Abrir arquivo

!entrada

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!Expressões relacionais
!a = b           -> a.eq.b
!a diferente b   -> a.ne.b
!a < b           -> a.lt.b
!a > b           -> a.gt.b
!a <= b		   -> a.le.b
!a >= b          -> a.ge.b
!
!Expressões lógicas
! .not.a  -> negação lógica 
!         -> se a é verdade -> .not.a é falso
!		-> se a é falso   -> .not.a é verdade
!a.and.b  -> conjunção lógica
!		-> se a e b são verdade -> a.and.b é verdade
!		-> se a e b são falso   -> a.and.b é falso
!a.or.b   -> disjunção inclusivo lógica
!		-> se a e b ou ambos são verdade -> a.or.b é verdade
!		-> se a ou b são falso -> a.or.b é falso
!a.eqv.b  -> equivalência lógica 
!		-> se a e b são ambos verdade ou ambos falsos -> 
!               a.eqv.b é verdade; caso contrário é falso
!a.neqv.b -> se a e b são ambos verdade ou ambos falsos ->
!               a.neqv.b é falso, caso contrário é verdade
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