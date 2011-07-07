      !X(n+1) + lambda - 0.5 + sqrt(lambda) * F(x)
      real*8 prob
      integer sucessos, tentativas, chegou, iseed
      tentativas = 200
      write (*, 10)
10    format('Digite a semente: ')
      read (*, 11) iseed
11    format(I5)
      sucessos = 0
      
      do i=1, tentativas
         chegou = SimulaBebado(iseed)
         if(chegou.eq.1) sucessos = sucessos + 1

      end do
      
      prob = dfloat(sucessos)/dfloat(tentativas)
      
      write(*, 1) prob
1     format('A probabilidade eh de: ',F6.4)

      stop
      end


      function SimulaBebado (iseed)
        integer tempo, x, y,  iseed
        REAL*8 direcao, pensa
        x = 0
        y = 0
        tempo = 0
        do i=1, 200
          tempo = tempo + 5
          direcao = cong(iseed)
          if (direcao.lt.0.45d0) then
             y = y + 1
          else if (direcao.lt.0.8d0) then
               x = x + 1
          else if (direcao.lt.0.9d0) then
               x = x - 1
          else
               y = y - 1
          end if

          if (x.eq.5.AND.y.eq.4) then
             SimulaBebado = 1
             return
          end if
          
          pensa = cong(iseed)
          if(pensa.le.0.4d0) tempo = tempo + 1
          
          if (tempo.gt.180) then
             SimulaBebado = 0
             return
          end if
          
        end do
        
        return
      end
      
      
      FUNCTION cong(iseed)
	real*8 rmod,pmod,dmax
	integer iseed,imod
	rmod= dfloat(iseed)
	pmod=2147483647.0d0
	dmax=1.0d0/pmod
	rmod=rmod*16807.d0
	imod=rmod*dmax
	rmod=rmod-pmod*imod
	cong=rmod*dmax
!	print*,cong
	iseed=rmod
	return
	end
