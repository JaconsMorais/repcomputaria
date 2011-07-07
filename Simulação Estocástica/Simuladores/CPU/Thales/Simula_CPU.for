      !            Projeto final de Simulaá∆o Estoc†stica
      !                      Simulador de CPU
      !              Prof¶. Dr¶. Carmen Maria Andreazza
      !
      !            Nomes:
      !                   Willian Rossini
      !                   Thales Eduardo Nazatto
      !
      !Erros dos princ°pios de simulaá∆o:
      !
      !Objetivos com pouca clareza e definiá∆o. N«O
      !
      ! O objetivo era simular o comportamento de uma CPU e seus proces-
      ! sos. Se algo n∆o estava claro o problema reside nos c†lculos ou
      ! ent∆o no algoritmo
      !
      !Construá∆o de modelos muito detalhados ou muito simplificados.
      !N«O
      !
      ! Talvez o modelo esteja confuso de ser interpretado, mas possui
      ! tudo o que precisa para fazer uma simulaá∆o fiel
      !
      !Conclus‰es sem base estat°stica. N«O
      !
      !  Todas as estat°sticas que colocamos foram baseadas no texto dos
      !  pr°ncipios de simulaá∆o. TambÇm colocamos informaá‰es comple-
      !  mentares a respeito do andamento dos processos
      !
      !Falhas na comunicaá∆o com a gerància do sistema. N«O
      !
      !  Todas as d£vidas que tivemos foram perguntadas e solucionadas
      !
      !Falhas nas obtená‰es de dados sobre o funcionamento do sistema e
      !interpretaá‰es equivocadas da equipe respons†vel pelo desenvolvi-
      !mento do simulador. N«O
      !
      ! Seguimos todo o percurso necess†rio segundo o documento Simula-
      ! dor_CPU.doc e cremos n∆o ter errado em nenhuma parte desse pro-
      ! cesso
      !
      !Falha em formar uma equipe especializada. SIM
      !
      ! N¢s n∆o tivemos experiància anterior em qualquer tipo de Fortran
      !
      !Software de simulaá∆o inadequado ou muito complexo e com documen-
      !taá∆o inadequada. SIM
      !
      ! O Force deu muitos erros em coisas que, seguindo a documentaá∆o,
      ! aparentemente dariam certo, e tivemos que achar outro compilador
      ! (FTN95, com a IDE Plato) para conseguir achar o que estava dando
      ! errado. AlÇm disso, a linguagem Fortran 77 Ç muito limitada, n∆o
      ! oferecendo suporte a atributos importantes para a simulaá∆o se
      ! sistemas operacionais e CPUs, como manipulaá∆o de listas, de ma-
      ! neira adequada, sendo executada de maneira aceit†vel no Fortran
      ! 90
      !
      !Uso de distribuiá‰es de probabilidade incorretas, como dados de
      !entrada do simulador, e de outros fatores aleat¢rios no comporta-
      !mento do sistema a ser estudado. SIM
      !
      ! A distribuiá∆o de Poisson Ç suspeita de estar errada, uma vez
      ! que processos de classes 2 e 3 nunca "estouram" o quantum.
      ! PorÇm, era a mais eficiente do ponto de vista computacional, j†
      ! que a outra que fizemos travava no meio da simulaá∆o:
      !
      !function poisson(iseed, media)
      !  real*8 x, num, acc
      !  integer iseed, media, n
      !
      !     x = exp(dfloat(-media))
      !     n = 0
      !     acc = 1.0d0
      !
      !     do while ((n.lt.(1000 * media)).and.(acc.ge.x))
      !       num = cong(iseed)
      !       acc = acc * num
      !       n = n + 1
      !     end do
      !
      !  poisson = n
      !  return
      !end
      !
      !Executar uma £nica vez a simulaá∆o e considerar os resultados
      !como a resposta do sistema simulado. N«O
      !
      ! O programa foi executado in£meras vezes para corrigir o m†ximo
      ! de bugs poss°vel e depois testado com v†rias sementes, todas com
      ! resultados semelhantes
      !
      ! C¢digo do Simulador abaixo:
      !
      
      !tipo da fila (structure /filaproc/ n∆o deu certo)
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
      
        function SimulaCPU(filaclasse,filatempoexec,iseed,fimfila)  !simulador de CPU
         real*8 tempoSim,tempquantum,proct,filatempoexec(50),tempocpu
         real*8 exp,tempofila
         integer filaclasse(50),iseed,flagproc,procriados,i
         integer contproc,cont1,quantum,inifila,flagop,proc,fimfila
         real flag !real flag Ç usada para acabar com bugs de compilaá∆o
         
         i = 1
         inifila = 1
         tempoSim = 0d0
         tempocpu = 0d0
         quantum = 0           !inicia vari†veis
         tempquantum = 45d0    !as vari†veis integer s∆o contadoras
         contproc = 0          !tempquantum indica o tempo utilizado do quantum
         procriados = 0        !as outras real s∆o vari†veis cumulativas,usadas para contar tempo
         tempofila = 0d0       !as vari†veis "flag"(com exceá∆o da real flag) s∆o usadas como orientaá‰es condicionais
         cont1 = 0
         
         do while(tempoSim.lt.90000)
          exp = expo(iseed,40)
          tempoSim = tempoSim + exp !chega um processo
          tempocpu = tempocpu + exp
      flag=criafila(filaclasse,filatempoexec,iseed,fimfila)
          procriados = procriados + 1
          
          proc = filaclasse(inifila) !dados do processo
          proct = filatempoexec(inifila)
          tempocpu = tempocpu + proct
          
          if (filatempoexec(inifila).le.tempquantum) then
            flagop = 3 !tÇrmino do processo
            contproc = contproc + 1
      flag= organizafila(filaclasse,filatempoexec,proc,proct,fimfila,
     &flagop,inifila)
            flagproc = 1 !processou!
          else
            flagop = 2 !troca de processos
            flag=temproc(filatempoexec,inifila,proct,tempquantum)
      flag= organizafila(filaclasse,filatempoexec,proc,proct,fimfila,
     &flagop,inifila)
             flagproc = 0 !n∆o processou ainda
          end if
          
          do while(i.lt.fimfila)
           tempofila = tempofila + tempquantum !verifica quanto os processos j† esperaram
          end do
          
          quantum = quantum + 1 !quantum terminado
          tempoSim = tempoSim + tempquantum !mais um quantum contado no tempo da simulaá∆o
         flag=priorizaproc(filaclasse,filatempoexec,fimfila,cont1,tempo) !executa scheduler

          write(*,1) quantum
          write(*,2) proc
          write(*,3) proct
          write(*,4) contproc            !estat°sticas do processo
          if(flagproc.eq.1) write(*,5)
          if(flagproc.eq.0) then
           write(*,6)
           write(*,16) filatempoexec(fimfila)
          end if
          write(*,17) tempoSim
          write(*,7)
1        format('Quantum ',I4)
2        format('Classe do processo processado: ', I1)
3        format('Tempo para processar: ', F7.3)
4        format('Processos processados atÇ o momento: ', I4)
5        format('Processado totalmente: Sim')
6        format('Processado totalmente: N∆o')
16       format('Tempo restante: ', F7.3,' ms')
17       format('Tempo atual da simulaá∆o: ', F9.3,' ms')
7        format('')

         end do

         write(*,8)
         write(*,18) tempoSim
         write(*,9) procriados
         write(*,10) tempofila/procriados
         write(*,11) (1d0-contproc/procriados)*100d0   !imprime estat°sticas
         write(*,12) tempocpu/tempoSim*100d0
         write(*,13) (1d0-tempocpu/tempoSim)*100d0
         write(*,14) tempocpu/procriados
         write(*,15) tempoSim/procriados
8        format('Fim da simulaá∆o!')
18       format('Tempo total: ', F9.3,' ms')
9        format('Processos criados: ', I4)
10       format('Tempo mÇdio de espera na fila: ', F7.3,' ms')
11       format('Probabilidade do processo esperar na fila: ', F7.3,'%')
12       format('Carga da CPU: ', F7.3,'%')
13       format('Ociosidade da CPU: ', F7.3,'%')
14       format('Tempo mÇdio da CPU carregada: ', F7.3,' ms')
15       format('Tempo mÇdio do sistema: ', F7.3,' ms')
         
        SimulaCPU = 0
        return
        end

        function temproc(filatempoexec,inifila,proct,tempquantum) !funá∆o usada para corrigir bug de compilaá∆o
        real*8 proct,tempquantum,filatempoexec(50)
        integer inifila
        filatempoexec(inifila) = proct - tempquantum
        temproc = 0
        return
        end
        
        function poisson(iseed,num)  !distribuiá∆o de poisson
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

        if(poisson.lt.0) poisson = -poisson !condiá∆o usada para evitar tempo de processamento negativo

10      continue

        return
        end
        
        function expo(iseed,num) !distribuiá∆o exponencial
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
        
        FUNCTION cong(iseed)  !gerador de n£meros aleat¢rios
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

        function criafila(filaclasse,filatempoexec,iseed,fimfila) !cria um elemento da fila de processos
        integer filaclasse(50),filatempoexec(50)
        integer iseed,fimfila
        real*8 freqproc
        real flag
        
         freqproc = cong(iseed) !frequància do processo

          if (freqproc.lt.0.6d0) then
               filaclasse(fimfila) = 1
          else if (freqproc.lt.0.85d0) then     !classes
               filaclasse(fimfila) = 2
          else
               filaclasse(fimfila) = 3
          end if
          
          flag = tempexec(filaclasse,filatempoexec,fimfila,iseed,num) !gera tempos de execuá∆o
          fimfila = fimfila + 1

        criafila = 0
        return
        end
        
        function tempexec(filaclasse,filatempoexec,fimfila,iseed,num) !formula o tempo de execuá∆o de acordo com a classe
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
        fimwhile = 0 !fimwhile usado por raz‰es ¢bvias
        flagop = 1 !operaá∆o de prioridade

       if(fimfila.gt.1) then !se h† procesos na fila
       
        if(cont1.gt.0.and.mod(cont1,8).eq.0) then !a cada 8 processos de classe 1

         do while(fimwhile.eq.0)
         
          if(filaclasse(i).eq.3) then !verifica processo de classe 3
           proc = filaclasse(i)
           proct = ftexec(i)
      flag=organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
           fimwhile = 1
          else if(i.lt.fimfila) then !vai para o pr¢ximo processo
           i = i+1
          else
           i = 1
           
           do while(fimwhile.eq.0)

            if(filaclasse(i).eq.2) then !verifica processo de classe 2
             proc = filaclasse(i)
             proct = ftexec(i)
      flag=  organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
             fimwhile = 1
            else if(i.lt.fimfila) then !vai para o pr¢ximo processo
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

        else if(filaclasse(i).eq.1) then !com exceá∆o das condiá‰es acima, prioridade

         proc = filaclasse(i)
         proct = ftexec(i)
      flag=organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)
         cont1 = cont1 + 1

        else if(filaclasse(i).eq.2) then !prioridade caso n∆o tenham processos de classe 1 dispon°veis

         proc = filaclasse(i)
         proct = ftexec(i)
      flag=organizafila(filaclasse,ftexec,proc,proct,fimfila,flagop,i)

        end if

      end if
        
        tempo = tempo + 0.1d0 !scheduler foi ativado, organizando processos ou n∆o
        tempocpu = tempocpu + 0.1d0

      priorizaproc = 0
      return
      end
        
        function organizafila(fc,ftexec,proc,proct,fimfila,flagop,i) !faz trocas para organizar a fila
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
           
          else if(flagop.eq.2) then !processo n∆o processado

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
          
           fimfila = fimfila-1 !retira ele da fila
           
          end if

        organizafila = 0
        return
        end
