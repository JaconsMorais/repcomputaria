      !tipo da fila (structure /filaproc/ nÆo deu certo)
      integer filaclasse(50)
      real*8 filatempoexec(50)
      !end structure
      

      integer fimfila
      real*8 pmod,dmax
      real flag
      
        fimfila = 1
      	pmod=2147483647.d0
	dmax=1.d0/pmod

      write (*, 10)
10    format('Digite a semente: ')
      read (*, 11) iseed
11    format(I5)

        flag=SimulaCPU(filaclasse,filatempoexec,iseed,fimfila)

      end
      
        function SimulaCPU(filaclasse,filatempoexec,iseed,fimfila)
         real*8 tempoSim,tempquantum,proct,filatempoexec(50),tempotp
         integer filaclasse(50),iseed,flagproc,procriados
         integer contproc,cont1,quantum,inifila,flagop,proc,fimfila
         real flag
         
         inifila = 1
         tempoSim = 0d0
         tempotp = 0d0
         quantum = 0
         tempquantum = 45d0
         contproc = 0
         procriados = 0
         cont1 = 0
         
         do while(tempoSim.lt.90000)
          tempoSim = tempoSim + expo(iseed,40) !chega um processo
      flag=criafila(filaclasse,filatempoexec,iseed,fimfila)
          procriados = procriados + 1
          
          proc = filaclasse(inifila)
          proct = filatempoexec(inifila)
          tempotp = tempotp + proct
          
          if (filatempoexec(inifila).le.tempquantum) then
            flagop = 3 !t‚rmino do processo
            contproc = contproc + 1
      flag= organizafila(filaclasse,filatempoexec,proc,proct,fimfila,
     &flagop,inifila)
            flagproc = 1 !processou!
          else
            flagop = 2 !troca de processos
            flag=temproc(filatempoexec,inifila,proct,tempquantum)
      flag= organizafila(filaclasse,filatempoexec,proc,proct,fimfila,
     &flagop,inifila)
             flagproc = 0 !nÆo processou
          end if
          
          quantum = quantum + 1
          tempoSim = tempoSim + tempquantum
         flag=priorizaproc(filaclasse,filatempoexec,fimfila,cont1,tempo)

          write(*,1) quantum
          write(*,2) proc
          write(*,3) proct
          write(*,4) contproc
          if(flagproc.eq.1) write(*,5)
          if(flagproc.eq.0) then
           write(*,6)
           write(*,16) filatempoexec(fimfila)
          end if
          write(*,7)
1        format('Quantum ',I4)
2        format('Classe do processo processado: ', I1)
3        format('Tempo para processar: ', F7.3)
4        format('Processos processados at‚ o momento: ', I4)
5        format('Processado totalmente: Sim')
6        format('Processado totalmente: NÆo')
16       format('Tempo restante: ', F7.3,' ms')
7        format('')

         end do

         write(*,8)
         write(*,9) procriados
         write(*,11) (1d0-contproc/procriados)*100d0
         write(*,12) tempotp/tempoSim*100d0
         write(*,13) (1d0-tempotp/tempoSim)*100d0
         write(*,14) tempotp/procriados
         write(*,15) tempoSim/procriados
8        format('Fim da simula‡Æo!')
9        format('Processos criados: ', I4)
10       format('Tempo m‚dio de espera na fila: ', F7.3,' ms')
11       format('Probabilidade do processo esperar na fila: ', F7.3,'%')
12       format('Carga da CPU: ', F7.3,'%')
13       format('Ociosidade da CPU: ', F7.3,'%')
14       format('Tempo m‚dio da CPU carregada: ', F7.3,' ms')
15       format('Tempo m‚dio do sistema: ', F7.3,' ms')
         
        SimulaCPU = 0
        return
        end

        function temproc(filatempoexec,inifila,proct,tempquantum)
        real*8 proct,tempquantum,filatempoexec(50)
        integer inifila
        filatempoexec(inifila) = proct - tempquantum
        temproc = 0
        return
        end
        
        function poisson(iseed,num)
        integer iseed,num
        real*8 rnum(num),c,z

        rnum(1)=iseed*dmax
!	print*,rnum(1)
!	if(rnum(1).eq.0.0d0) sum1=sum1+1

        do 10 i=2,num
	   rnum(i)=cong(iseed)
!	if(rnum(i).eq.0.0d0) sum1=sun1+1
!	print*,sum1
           c = 0.0d0

        do 11 j=1,13
           c = c + rnum(i)
11      continue

        z = (c-6.0d0) * 1.0d0 + 0.0d0
        poisson = 10.0d0 - 0.5d0 + dsqrt(10.0d0) * z

10      continue

        return
        end

        function expo(iseed,num)
        integer iseed,num
        real*8 rnum(num),a,z

        a = 1.02d0

        rnum(1)=iseed*dmax
!	print*,rnum(1)
!	if(rnum(1).eq.0.0d0) sum1=sum1+1
	do 10 i=2,num
	   rnum(i)=cong(iseed)
!	if(rnum(i).eq.0.0d0) sum1=sun1+1
!	print*,sum1
           expo = -1/a * LOG(rnum(i))

10      continue

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

        function criafila(filaclasse,filatempoexec,iseed,fimfila)
        integer filaclasse(50),filatempoexec(50)
        integer iseed,fimfila
        real*8 freqproc
        real flag
        
         freqproc = cong(iseed) !frequˆncia do processo

          if (freqproc.lt.0.6d0) then
               filaclasse(fimfila) = 1
          else if (freqproc.lt.0.85d0) then
               filaclasse(fimfila) = 2
          else
               filaclasse(fimfila) = 3
          end if
          
          flag = tempexec(filaclasse,filatempoexec,fimfila,iseed,num)
          fimfila = fimfila + 1

        criafila = 0
        return
        end
        
        function tempexec(filaclasse,filatempoexec,fimfila,iseed,num)
        integer filaclasse(50)
        real*8 filatempoexec(50)
        integer iseed,num,fimfila

        if(filaclasse(fimfila).eq.1) then
         filatempoexec(fimfila) = poisson(iseed,40)
        else if(filaclasse(fimfila).eq.2) then
         filatempoexec(fimfila) = poisson(iseed,210)
        else
         filatempoexec(fimfila) = poisson(iseed,300)
        end if

        tempexec = 0
        return
        end
        
        function priorizaproc(filaclasse,ftexec,fimfila,cont1,tempo) !scheduler
        integer filaclasse(50),ftexec(50),proc,proct,flagop
        integer iseed,fimfila,cont1,i,fimwhile
        real*8 tempo
        real flag

        i = 1
        fimwhile = 0
        flagop = 1 !opera‡Æo de prioridade

       if(fimfila.gt.1) then !se h  procesos na fila
       
        if(cont1.gt.0.and.mod(cont1,8).eq.0) then !a cada 8 processos de classe 1

         do while(fimwhile.eq.0)
         
          if(filaclasse(i).eq.3) then !verifica processo de classe 3
           proc = filaclasse(i)
           proct = ftexec(i)
      flag=organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
           fimwhile = 1
          else if(i.lt.fimfila) then
           i = i+1
          else
           i = 1
           
           do while(fimwhile.eq.0)

            if(filaclasse(i).eq.2) then !verifica processo de classe 2
             proc = filaclasse(i)
             proct = ftexec(i)
      flag=  organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
             fimwhile = 1
            else if(i.lt.fimfila) then
             i = i+1
            else !s¢ tem processo de classe 1
             proc = filaclasse(i)
             proct = ftexec(i)
      flag=  organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
             cont1 = cont1 + 1
             fimwhile = 1
            end if

           end do
          end if
          
         end do

        else if(mod(cont1,4).eq.0) then !a cada 8 processos de classe 1

         do while(fimwhile.eq.0)

          if(filaclasse(i).eq.2) then !verifica processo de classe 2
           proc = filaclasse(i)
           proct = ftexec(i)
      flag=organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
           fimwhile = 1
          else if(i.lt.fimfila) then
           i = i+1
          else !verifica processo de classe 1
           proc = filaclasse(i)
           proct = ftexec(i)
      flag=organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
           cont1 = cont1 + 1
           fimwhile = 1
          end if
          
         end do

        else if(filaclasse(i).eq.1) then

         proc = filaclasse(i)
         proct = ftexec(i)
      flag=organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
         cont1 = cont1 + 1

        else if(filaclasse(i).eq.2) then

         proc = filaclasse(i)
         proct = ftexec(i)
      flag=organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)

        end if

      end if
        
        tempo = tempo + 0.1d0 !scheduler foi ativado, organizando processos ou nÆo
        tempotp = tempotp + 0.1d0

      priorizaproc = 0
      return
      end
        
        function organizafila(fc,ftexec,proc,proct,fimfila,flagop,i)
        integer fc(50),proc,aux
        real*8 ftexec(50),proct
        integer iseed,fimfila,flagop,i,j

        j = 1

          if(flagop.eq.1) then !prioridade de processos

           do while(j.lt.i)
            aux = fc(i)
            fc(i) = fc(j)
            fc(j) = aux
            aux = ftexec(i)
            ftexec(i) = ftexec(j)
            ftexec(j) = aux

            j = j + 1

           end do
           
          else if(flagop.eq.2) then !processo nÆo processado

           do while(j.lt.i)
            aux = fc(i)
            fc(i) = fc(j)
            fc(j) = aux
            aux = ftexec(i)
            ftexec(i) = ftexec(j)
            ftexec(j) = aux

            j = j + 1

           end do
           
          else if(flagop.eq.3) then !processo processado
          
           do while(j.lt.i)
            aux = fc(i)
            fc(i) = fc(j)
            fc(j) = aux
            aux = ftexec(i)
            ftexec(i) = ftexec(j)
            ftexec(j) = aux
            
            j = j + 1
            
           end do
          
           fimfila = fimfila-1
           
          end if

        organizafila = 0
        return
        end
