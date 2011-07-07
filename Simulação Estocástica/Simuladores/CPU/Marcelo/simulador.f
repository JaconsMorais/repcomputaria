 
       ! declara o modulo de uso da lista para fila
      module lista_module
        ! elemento da lista
        type processo_elem
            integer numeroProcess             ! numero do processo
            integer processClass              ! classe do processo
            integer execTime                  ! tempo de execucao total
            integer executedTime              ! tempo de uso da CPU
            type(processo_elem),pointer next ! ponteiro para o proximo elem
        end type processo_elem

        ! declaracao da fila
        type fila_processos
            integer numElem
            type(processo_elem), pointer head ! inicio da fila
            type(processo_elem), pointer tail ! final da fila
        end type fila_processos
        
      contains
        ! inicializa uma fila sem nenhum processo
        function startLista(lista)
          type(fila_processos) lista
          lista%numElem = 0
          nullify(lista%head)
          nullify(lista%tail)

          ! sucesso
          startLista = 1
          return
        end function

        ! adiciona um novo processo a lista
        function addAtLista(lista, processo)
          type(fila_processos) lista
          type(processo_elem), pointer :: processo, processoTemp
          lista%numElem = lista%numElem + 1
          processoTemp => lista%tail
          if (associated(processoTemp)) then
            processoTemp%next => processo
          else
            lista%head => processo
          endif
          lista%tail => processo

          ! sucesso
          addAtLista = 1
          return
        end function
        
        ! remove um elemento da lista
        function removePrimeiro(lista)
          type(processo_elem), pointer :: removePrimeiro, processoTemp
          type(fila_processos) lista
          lista%numElem = lista%numElem - 1
          processoTemp => lista%head
          lista%head => processoTemp%next
          
          if (.not. associated(processoTemp%next)) then
            lista%tail => processoTemp%next
          endif

          removePrimeiro => processoTemp
          return
        end function

        ! retorna se uma fila esta vazia ou nao
        logical function isListaEmpty(lista)
          type(fila_processos) lista
          if (lista%numElem .gt. 0) then
            isListaEmpty = .FALSE.
          else
            isListaEmpty = .TRUE.
          endif
        
          return
        end function
        
        ! cria um processo, dado um numero, um tempo de exec para ele
        ! e uma classe
        function createProc(num, execTim, processClass)
          type(processo_elem), pointer :: createProc
          type(processo_elem), pointer :: processoTemp
          integer num, execTim, processClass

          allocate(processoTemp)
          processoTemp%numeroProcess = num
          processoTemp%execTime = execTim
          processoTemp%processClass = processClass
          processoTemp%executedTime = 0
          nullify(processoTemp%next)
          
          createProc => processoTemp
          return
        end function
        
      end module lista_module

      ! Simulador de CPU
      !    trabalha com tres tipos de processo (classes 1 a 3) e
      !    coordena a CPU deles, trocando processos a cada quantum
      program main
      use lista_module
      
      ! declaracao das variaveis e atributos do projeto
      type(fila_processos) classe1, classe2, classe3
      type(processo_elem), pointer :: processoTemp, executing
      integer iseedUniform, iseedPoisson, iseedExponencial
      integer ierr
      integer tempTotalSec, quantum, execClass1Number
      integer simulationTime, proxProcessTime, execProcessTime
      integer processNumber, processTime, processClass, nextScheduler
      real genUniform
      logical scheduler

      ! inicializa as listas (filas) para trabalho
      ierr = startLista(classe1)
      ierr = startLista(classe2)
      ierr = startLista(classe3)
      
      ! inicializa as constantes do projeto
      tempTotalSec = 90    ! seconds
      quantum = 450        ! 450 decimos de ms = 45 milesseconds
      simulationTime = 0   ! em decimos de milissecond
      iseedUniform = 2000
      iseedPoisson = 2000
      iseedExponencial = 2000
      execClass1Number = 0
      proxProcessTime = 0  ! tempo (decimos de ms) de chegada do prox processo
      processNumber = 1    ! contador de total de processos gerados
      scheduler = .TRUE.   ! o primeiro processo a executar eh o scheduler
      nullify(executing)
      execProcessTime = 0
      nextScheduler = 1    ! quando sera executado o proximo scheduler

      ! formatacao da saida da execucao do scheduler
1     format(F8.1, ';sched;0;     0.1;     0.1')
      ! formatacao da saida da execucao de um programa
2     format(F8.1, ';', I5, ';', I1, ';', F8.1, ';', F8.1)

      ! cabecalho dos logs da execucao
      print*,'tempoSimulado(ms);processoNum;processoClasse;',
     +'tempoTotalGastoCPU(ms);tempoTotalRequisitado(ms)'

      ! o loop abaixo faz a simulacao em si
      ! cada iteracao do loop corresponde a um decimo de ms
      ! com isso, sabemos que o scheduler dura uma iteracao enquanto
      ! os outros processos usam mais de uma
      ! a primeira execucao eh forcadamente a do scheduler
      do i=0, (tempTotalSec*1000*10-1) ! tempo de simulacao em decimo de ms
        simulationTime = simulationTime + 1

        ! verifica se ha um novo processo que deveria chegar agora
        if (proxProcessTime .eq. i) then
          ! define os atributos do processo novo a ser gerado
          genUniform = uniformGen(iseedUniform)
          if (genUniform .le. 0.15d0) then
            processClass = 3
            ! define quanto o processo deve executar ateh finalizar
            ! media de 300ms ou 3000 decimos de ms e distribuicao de poisson
            ! sempre soma pelo menos um decimo de ms para garantir que
            ! o processo execute pelo menos uma iteracao
            processTime = NInt(poissonGen(iseedPoisson, 300))*10+1
          else if (genUniform .le. 0.40d0) then
            processClass = 2
            ! define quanto o processo deve executar ateh finalizar
            ! media de 210ms ou 2100 decimos de ms e distribuicao de poisson
            ! sempre soma pelo menos um decimo de ms para garantir que
            ! o processo execute pelo menos uma iteracao
            processTime = NInt(poissonGen(iseedPoisson, 210))*10+1
          else
            processClass = 1
            ! define quanto o processo deve executar ateh finalizar
            ! media de 40ms ou 400 decimos de ms e distribuicao de poisson
            ! sempre soma pelo menos um decimo de ms para garantir que
            ! o processo execute pelo menos uma iteracao
            processTime = NInt(poissonGen(iseedPoisson, 400))+1
          endif

          ! cria e aloca o mesmo aa fila correta
          processoTemp => createProc(processNumber, processTime,
     +                               processClass)
          select case (processClass)
            case (1)
              ierr = addAtLista(classe1, processoTemp)
            case (2)
              ierr = addAtLista(classe2, processoTemp)
            case (3)
              ierr = addAtLista(classe3, processoTemp)
          end select
          ! aumenta o contador de processos
          processNumber = processNumber + 1

          ! define quando sera a chegada de um novo processo
          ! media de 40ms ou 400 decimos de ms e distribuicao exponencial
          ! sempre soma pelo menos um decimo de ms para garantir que somente
          ! chegue um novo processo na proxima iteracao
          proxProcessTime = i +
     +               NInt(exponencialGen(iseedExponencial, 400))+1
        endif

        if (scheduler) then
          scheduler = .FALSE.
          nextScheduler = simulationTime + quantum
          
          ! caso exista um processo executando que ainda nao acabou
          ! retorna ele para o fim da fila da sua classe
          if (associated(executing)) then
            nullify(executing%next)
            select case (executing%processClass)
                case (1)
                  ierr = addAtLista(classe1, executing)
                case (2)
                  ierr = addAtLista(classe2, executing)
                case (3)
                  ierr = addAtLista(classe3, executing)
            end select
            write(*,2) (dfloat(simulationTime-1)/10),
     +          executing%numeroProcess, executing%processClass,
     +          (dfloat(executing%executedTime)/10),
     +          (dfloat(executing%execTime)/10)
     
            nullify(executing)
          endif

          ! imprime que o scheduler esta sendo executado
          write(*,1) (dfloat(simulationTime)/10)

          ! verifica qual o proximo processo a ser executado
          if (.not. isListaEmpty(classe3) .and.
     +      ((isListaEmpty(classe1) .and. isListaEmpty(classe2)) .or.
     +      (isListaEmpty(classe2) .and. execClass1Number .ge. 8))) then
            ! caso a lista um e a dois estejam vazias, executa um
            ! processo da tres OU quando a lista um nao esta vazia
            ! mas ja se passaram 8 execucoes de processos da lista 1 e
            ! nao ha nenhum da lista dois a ser executado
            execClass1Number = 0
            executing => removePrimeiro(classe3)
          else if (.not. isListaEmpty(classe2) .and.
     +              (isListaEmpty(classe1) .or.
     +               execClass1Number .ge. 4)) then
            ! caso a lista 1 esteja vazia OU os ultimos 4 processos
            ! foram da classe 1
            execClass1Number = 0
            executing => removePrimeiro(classe2)
          else if (.not. isListaEmpty(classe1)) then
            ! caso contrario da prioridade para a classe 1
            execClass1Number = execClass1Number + 1
            executing => removePrimeiro(classe1)
          else
            ! nao ha o que executar, chama o scheduler novamente
            scheduler = .TRUE.
            nullify(executing)
          endif
          
        else
          ! caso o scheduler nao esteja executando, incrementa o
          ! contador de tempo do processo atual
           executing%executedTime = executing%executedTime + 1

          ! verifica se o processo acabou. se sim, seta o scheduler
          ! para executar no proximo ciclo
          if (executing%executedTime .eq. executing%execTime) then
            write(*,2) (dfloat(simulationTime)/10),
     +          executing%numeroProcess, executing%processClass,
     +          (dfloat(executing%executedTime)/10),
     +          (dfloat(executing%execTime)/10)
            scheduler = .TRUE.
            ! limpa a memoria utilizada pelo processo
            deallocate(executing)
            nullify(executing)
          end if
        endif

        ! essa conta garante que o intervalo entre as chamadas do
        ! scheduler sera de quantum (decimos de segundos)
        if (nextScheduler .eq. (simulationTime)) then
          scheduler = .TRUE.
        endif
      end do
      
      ! se ainda havia alguem executando, finaliza o processo
      if (associated(executing)) then
        write(*,2) (dfloat(simulationTime)/10),
     +          executing%numeroProcess, executing%processClass,
     +          (dfloat(executing%executedTime)/10),
     +          (dfloat(executing%execTime)/10)
        ! limpa a memoria utilizada pelo processo
        deallocate(executing)
        nullify(executing)
      endif

      print*,'total de processos criados: ', processNumber
      ! libera a memoria alocada para todo mundo que ainda ficou na
      ! fila mesmo depois do fim da simulacao
      print*,'processos restantes na fila classe 1: ', classe1%numElem
      do while (.not. isListaEmpty(classe1))
        executing => removePrimeiro(classe1)
        deallocate(executing)
        nullify(executing)
      end do
      print*,'processos restantes na fila classe 2: ', classe2%numElem
      do while (.not. isListaEmpty(classe2))
        executing => removePrimeiro(classe2)
        deallocate(executing)
        nullify(executing)
      end do
      print*,'processos restantes na fila classe 3: ', classe3%numElem
      do while (.not. isListaEmpty(classe3))
        executing => removePrimeiro(classe3)
        deallocate(executing)
        nullify(executing)
      end do

      print*,'pressione ENTER para sair da simulacao'
      read * ! espera o usuario pressionar enter para sair da simulacao

      stop
      end program

      ! gerador de numeros uniformes entre a e b
      ! x = (b-a)*F(x) + a
      ! estamos usando b = 1 e a = 0 para gerar um numero entre [0,1)
      real*8 function uniformGen(iseed)
        real*8 x,num
        integer iseed

        num = cong(iseed)
        x = ((dfloat(1) - dfloat(0)) * num) + dfloat(0)

        uniformGen = x
        return
      end

      ! gerador de numeros com distribuicao exponencial de media xpto
      ! x = -1/alpha * ln(U(0,1))
      ! onde 1/alpha eh a media desejada
      real*8 function exponencialGen(iseed, media)
        real*8 x, num
        integer iseed, media
        
        num = cong(iseed)
        x = -media * dlog(num)
        
        exponencialGen = x
        return
      end

      ! gerador de numeros com distribuicao poisson de media xpto
      ! sao utilizados dois algoritmos
      ! o primeiro para medias pequenas, usando uma simulacao do processo
      !    de Poisson por "Uniform deviates". Este metodo tambem eh o
      !    metodo descrito por Knuth para geracao de numeros aleatorios
      !    seguindo uma distribuicao de poisson
      ! o segundo utiliza o algoritmo de rejeicao descrito em
      !    Devroye, Luc. (1981). The Computer Generation of Poisson
      !    Random Variables. Computing vol. 26 pp. 197-207.
      real*8 function poissonGen(iseed, media)
        real*8 x, num, acc
        integer iseed, media, pivot, n
        pivot = 500 ! valor original proposto 40
        
        if (media < pivot) then

           x = exp(dfloat(-media))
           n = 0
           acc = 1.0d0
           
           do while ((n < (1000 * media)) .and. (acc >= x))
             num = cong(iseed)
             acc = acc * num
             n = n + 1
           end do
        endif
        poissonGen = n
        return
      end

      ! funcao gera um numero aleatorio entre 0 e 1
      ! disponibilizada "as is"
      real function cong(iseed)
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


