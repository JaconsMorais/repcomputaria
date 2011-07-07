! gerador de números aleatórios
!
      real*8 rnum(10000),rave,r2ave,correl,sdev,dmax,pmod, a, b, c, z
	integer iseed,num
	open(1,file='result.dat',status='unknown')
	pmod=2147483647.d0
	dmax=1.d0/pmod
!
      a = 1.02d0
      b = 3.0d0
      c = 0.0d0
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
!	if(rnum(1).eq.0.0d0) sum1=sum1+1
	do 10 i=2,num
	   rnum(i)=cong(iseed)
!	if(rnum(i).eq.0.0d0) sum1=sun1+1
!	print*,sum1
           c = 0.0d0
	do 11 j=1,12
           c = c + rnum(i)
11    continue
      z = (c-6.0d0) * 2.0d0 + 10.0d0
              write (*,14) z
14     format(F6.1)
10    continue
!  b, a - user inputs   a < b
! f(x) - rand
! X = (E-6) * dp + u

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

