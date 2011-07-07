      integer simular,iseed !semente recomendada pela Carmen: 200

      write (*, 10)
10    format('Digite a semente: ')
      read (*, 11) iseed
11    format(I5)

      simular = SimulaPosto(iseed)
      
      end

      function SimulaPosto (iseed)
       integer iseed !semente
       REAL*8 freqac, tempoServ,tempoFila,tempoFServ,tempoIRel,tempoSist
       REAL*8 tempoLOp,tEChegadas,tempoRel, freqac2 !vari veis de simula‡Æo
       REAL*8 somaFila,contFila,MediaFila,contCli,probFila, razaoTempos
       REAL*8 contTOp !vari veis usadas para resolu‡Æo dos exerc¡cios

       contCli = 0 !vari vel usada para contar clientes
       contFila = 0 !vari vel usada para contar clientes na fila
       tempoFServ = 0 !tempo final de servi‡o - in¡cio da simula‡Æo
       tempoRel = 0 !tempo do rel¢gio
       somaFila = 0 !vari vel usada para somar os tempos da fila para usar no tempo m‚dio

       do while(tempoFServ.le.480) !simula‡Æo durante um turno de 8 horas
          !vari veis de frequˆncia
          freqac = cong(iseed) !frequˆncia acumulada dos tempos de chegada
          
          if (freqac.lt.0.337d0) then ! 0 a 5 - ponto m‚dio 2,5
               tEChegadas = 2.5d0
          else if (freqac.lt.0.529d0) then ! 5 a 10 - ponto m‚dio 7,5
               tEChegadas = 7.5d0
          else if (freqac.lt.0.731d0) then ! 10 a 15 - ponto m‚dio 12,5
               tEChegadas = 12.5d0
          else if (freqac.lt.0.865d0) then ! 15 a 20 - ponto m‚dio 17,5
               tEChegadas = 17.5d0
          else if (freqac.lt.0.894d0) then ! 20 a 25 - ponto m‚dio 22,5
               tEChegadas = 22.5d0
          else if (freqac.lt.0.962d0) then ! 25 a 30 - ponto m‚dio 27,5
               tEChegadas = 37.5d0
          else if (freqac.lt.0.971d0) then ! 30 a 35 - ponto m‚dio 32,5
               tEChegadas = 32.5d0
          else if (freqac.lt.0.99d0) then ! 35 a 40 - ponto m‚dio 37,5
               tEChegadas = 37.5d0
          else ! 40 a 45 - ponto m‚dio 42,5
               tEChegadas = 42.5d0
          end if
          
          freqac2 = cong(iseed) !frequˆncia acumulada dos tempos de servi‡o
          
          if (freqac.lt.0.337d0) then ! 9 a 10 - ponto m‚dio 9,5
               tempoServ = 9.5d0
          else if (freqac.lt.0.529d0) then ! 10 a 11 - ponto m‚dio 10,5
               tempoServ = 10.5d0
          else if (freqac.lt.0.731d0) then ! 11 a 12 - ponto m‚dio 11,5
               tempoServ = 11.5d0
          else if (freqac.lt.0.865d0) then ! 12 a 13 - ponto m‚dio 12,5
               tempoServ = 12.5d0
          else if (freqac.lt.0.894d0) then ! 13 a 14 - ponto m‚dio 13,5
               tempoServ = 13.5d0
          else if (freqac.lt.0.962d0) then ! 14 a 15 - ponto m‚dio 14,5
               tempoServ = 14.5d0
          end if
         !vari veis dependentes desses valores
        tempoRel = tempoRel + tEChegadas
        if (tempoRel.gt.tempoFServ) then
         tempoFila = tempoRel - tempoFServ
         tempoIRel = tempoRel
        else
         tempoFila = 0
         tempoIRel = tempoFServ
        end if
        if (tempoSist.lt.tEChegadas) then
         tempoLOp = tEChegadas - tempoSist
        else
         tempoLOp = 0
        end if
        tempoSist = tempoServ + tempoFila
        tempoFServ = tempoIRel + tempoServ
        !vari veis de probabilidade
        contCli = contCli + 1 !carros j  visitaram o posto
        if (tempoFila.gt.0) contFila = contFila + 1 !h  carros na fila
        somaFila = somaFila + tempoFila !soma dos tempos da fila
        
      write(*, 13) contCli
      write(*, 29) freqac,tEChegadas,freqac2,tempoServ
      write(*, 30) tempoRel,tempoIRel,tempoFila,tempoFServ
      write(*, 31) tempoSist,tempoLOp
      write(*, 32)
13    format('Ap¢s Cliente ',F3.0,':',F3.0,F6.3)
29    format('FTEC:',F5.3,' TEC:',F6.3,' FTS:',F5.3,' TS:',F6.3)
30    format('TRel:',F7.3,' TIRel:',F7.3,' TF:',F6.3,' TFS:',F7.3)
31    format('TSist:',F6.3,' TLOp:',F6.3)
14    format('FTEC: Frequencia acumulada do tempo entre chegadas')
15    format('TS: Tempo entre chegadas:')
16    format('FTS: Frequencia acumulada do tempo de servico')
17    format('TS: Tempo de servico:')
18    format('TRel: Tempo do relogio:')
19    format('TIRel: Tempo do inicio do relogio:')
20    format('TF: Tempo na fila:')
21    format('TFS: Tempo do final do servico:')
22    format('TSist: Tempo do sistema:')
23    format('TLOp: Tempo livre do operador:')
32    format('')
       end do
       !vari veis de razÆo
       probFila = contFila / contCli !probabilidade de um carro estar na fila
       mediaFila = somaFila / contCli !tempo m‚dio de espera na fila
       razaoTempos = 480 / tempoFServ !razÆo entre o tempo de execu‡Æo e o tempo de permanˆncia

       write(*,33)
       write(*,14)
       write(*,15)
       write(*,16)
       write(*,17)
       write(*,18)
       write(*,19)
       write(*,20)
       write(*,21)
       write(*,22)
       write(*,23)
       write(*,32)
       write(*,25)
       write(*,26) probFila
       write(*,27) mediaFila
       write(*,28) razaoTempos
33    format('Legenda:')
25    format('Apos a simulacao:')
26    format('Probabilidade de um cliente entrar na fila:',F5.3)
27    format('Tempo medio de espera na fila:',F6.3)
28    format('Razao entre o tempo de execucao e o de permanencia:',F5.3)

      SimulaPosto = 0 !fim da simula‡Æo
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
