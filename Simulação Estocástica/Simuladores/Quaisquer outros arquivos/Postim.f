      integer iseed !semente recomendada pela Carmen: 200


















      subroutine SimulaPosto (iseed)
       integer iseed !semente
       REAL*8 freqac, tempoServ,tempoFila,tempoFServ,tempoIRel,tempoSist
       REAL*8 tempoLOp !vari veis de simula‡Æo
       REAL*8 somaFila,contFila,MediaFila,contCli,probFila !vari veis usadas para resolu‡Æo dos exerc¡cios

       tempoFServ = 0

       while(tempoFServ.le.480)
       
          tempoIRel = tempoFServ
          
          if (freqac.lt.0.337d0) then ! 0 a 5 - ponto m‚dio 2,5
               tempoServ = 10.42d0
               tempoFila =
               tempoLOp =
          else if (freqac.lt.0.529d0) then ! 5 a 10 - ponto m‚dio 7,5
               tempoServ = 10.94d0
               tempoFila =
               tempoLOp =
          else if (freqac.lt.0.731d0) then ! 10 a 15 - ponto m‚dio 12,5
               tempoServ = 11.56d0
               tempoFila =
               tempoLOp =
          else if (freqac.lt.0.865d0) then ! 15 a 20 - ponto m‚dio 17,5
               tempoServ = 12.32d0
               tempoFila =
               tempoLOp =
          else if (freqac.lt.0.894d0) then ! 20 a 25 - ponto m‚dio 22,5
               tempoServ = 12.77d0
               tempoFila =
               tempoLOp =
          else if (freqac.lt.0.962d0) then ! 25 a 30 - ponto m‚dio 27,5
               tempoServ = 13.27d0
               tempoFila =
               tempoLOp =
          else if (freqac.lt.0.971d0) then ! 30 a 35 - ponto m‚dio 32,5
               tempoServ = 13.91d0
               tempoFila =
               tempoLOp =
          else if (freqac.lt.0.99d0) then ! 35 a 40 - ponto m‚dio 37,5
               tempoServ = 14.32d0
               tempoFila =
               tempoLOp =
          else ! 40 a 45 - ponto m‚dio 42,5
               tempoServ = 14.38d0
               tempoFila =
               tempoLOp =
          end if

        tempoSist = tempoServ + tempoFila
        tempoFServ = tempoFServ + tempoSist

       end while

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
