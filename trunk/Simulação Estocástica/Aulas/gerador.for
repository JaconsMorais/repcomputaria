! gerador de números aleatórios
!
      real*8 rnum(10000),rave,r2ave,correl,sdev,dmax,pmod
	integer iseed,num
	open(1,file='result.dat',status='unknown')
	pmod=2147483647.d0
	dmax=1.d0/pmod
!
      write(*,80)
80    format(' Valor inicial ou semente')
      read(*,92) iseed
92    format(I5)
      write(*,81) iseed
81    format(' A semente eh:',I8)
      write(*,82)	
82    format(' Entre o no de nos alaetorios a serem gerados')
      read(*,92) num
	write(*,83) num
	write(1,83) num
83    format(' no de nos aleatorios a serem gerados',I8)
!
      Do 1 i=1,10000
1	 rnum(i)=0.0d0
	rave=0.0d0
	correl=0.0d0
	r2ave=0.0d0
	sdev=0.0d0
	sun1=0.0d0
!
      rnum(1)=iseed*dmax
!	print*,rnum(1)
	write(*,93) rnum(1),iseed
!	if(rnum(1).eq.0.0d0) sum1=sum1+1
	do 10 i=2,num
	   rnum(i)=cong(iseed)
	if (num.le.200) write(*,93) rnum(i),iseed
!	if(rnum(i).eq.0.0d0) sum1=sun1+1
!	print*,sum1
	   write(1,93) rnum(i),iseed
93       format(F6.4,I15)
10    continue
      rave=rnum(1)
	r2ave=rnum(1)**2.0d0
	do 20 i=2,num
	   correl=correl+rnum(i)*rnum(i-1)
	   rave=rave+rnum(i)
20    r2ave=r2ave+rnum(i)**2
      rave=rave/num
	sdev=SQRT((r2ave/num-rave**2)/(num-1))
	correl=correl/(num-1)-rave*rave
!
      write(*,32) rave,sdev,correl
32    format(' media=',F10.6,'+/-', F10.6,1x,'correlacao=',F10.6)
      write(1,32) rave, sdev, correl
	close(1)
	stop
	end
!
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
	    
