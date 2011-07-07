function [sol, it_hist, ierr] = brsola(x,f,tol, parms)

debug=1;

ierr = 0; maxit=40; maxdim=39;  
it_histx=zeros(maxit,3);
maxarm=10;
%
if nargin == 4
    maxit=parms(1); maxdim=parms(2)-1; 
end
rtol=tol(2); atol=tol(1); n = length(x); fnrm=1; itc=0; nbroy=0;

f0=feval(f,x);
fc=f0;
fnrm=norm(f0)/sqrt(n);
it_hist(itc+1)=fnrm;
it_histx(itc+1,1)=fnrm; it_histx(itc+1,2)=0; it_histx(itc+1,3)=0;
fnrmo=1;
stop_tol=atol + rtol*fnrm;
outstat(itc+1, :) = [itc fnrm 0 0];

if fnrm < stop_tol
    sol=x;
    return
end

stp=zeros(n,maxdim);
stp_nrm=zeros(maxdim,1);
lam_rec=ones(maxdim,1);

lambda=1;
stp(:,1) = -fc;
stp_nrm(1)=stp(:,1)'*stp(:,1);

while(itc < maxit)

    nbroy=nbroy+1;

    fnrmo=fnrm; itc=itc+1;

    xold=x; lambda=1; iarm=0; lrat=.5; alpha=1.d-4;
    x = x + stp(:,nbroy);
    fc=feval(f,x);
    fnrm=norm(fc)/sqrt(n);
    ff0=fnrmo*fnrmo; ffc=fnrm*fnrm; lamc=lambda;

    while fnrm >= (1 - lambda*alpha)*fnrmo & iarm < maxarm

        if iarm==0
            lambda=lambda*lrat;
        else
            lambda=parab3p(lamc, lamm, ff0, ffc, ffm);
        end
        lamm=lamc; ffm=ffc; lamc=lambda;
        x = xold + lambda*stp(:,nbroy);
        fc=feval(f,x);
        fnrm=norm(fc)/sqrt(n);
        ffc=fnrm*fnrm;
        iarm=iarm+1;
    end

    if iarm == maxarm
        disp('Line search failure in brsola ')
        ierr=2;
        it_hist=it_histx(1:itc+1,:);
        sol=xold;
        return;
    end

    it_histx(itc+1,1)=fnrm;
    it_histx(itc+1,2)=it_histx(itc,2)+iarm+1;
    if(itc == 1) it_histx(itc+1,2) = it_histx(itc+1,2)+1; end;
    it_histx(itc+1,3)=iarm;

    if fnrm < stop_tol
        sol=x;
        rat=fnrm/fnrmo;
        outstat(itc+1, :) = [itc fnrm iarm rat];
        it_hist=it_histx(1:itc+1,:);

        if debug==1
            disp(outstat(itc+1,:))
        end
        return
    end

    lam_rec(nbroy)=lambda;
    if lambda ~= 1
         stp(:,nbroy)=lambda*stp(:,nbroy);
         stp_nrm(nbroy)=lambda*lambda*stp_nrm(nbroy);
    end

    rat=fnrm/fnrmo;
    outstat(itc+1, :) = [itc fnrm iarm rat];
        if debug==1
            disp(outstat(itc+1,:))
        end

    if nbroy < maxdim+1
        z=-fc;
        if nbroy > 1
            for kbr = 1:nbroy-1
                 ztmp=stp(:,kbr+1)/lam_rec(kbr+1);
                 ztmp=ztmp+(1 - 1/lam_rec(kbr))*stp(:,kbr);
                 ztmp=ztmp*lam_rec(kbr);
                 z=z+ztmp*((stp(:,kbr)'*z)/stp_nrm(kbr));
            end
        end

        a2=-lam_rec(nbroy)/stp_nrm(nbroy);
        a1=1 - lam_rec(nbroy);
        zz=stp(:,nbroy)'*z;
        a3=a1*zz/stp_nrm(nbroy);
        a4=1+a2*zz;
        stp(:,nbroy+1)=(z-a3*stp(:,nbroy))/a4;
        stp_nrm(nbroy+1)=stp(:,nbroy+1)'*stp(:,nbroy+1);

    else

        stp(:,1)=-fc;
        stp_nrm(1)=stp(:,1)'*stp(:,1);
        nbroy=0;

    end

end

sol=x;
it_hist=it_histx(1:itc+1,:);
ierr=1;
if debug==1
    disp(outstat)
end
