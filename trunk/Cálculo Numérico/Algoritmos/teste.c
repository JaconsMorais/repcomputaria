#include <stdio.h>
#include <stdlib.h>
#include <math.h>

float func1(float x){
     float xa = x;
     x = (2*x*x*x+log(x)-5)/(6*x*x+1/x);
     if(x-xa <= 0.0000001 && x-xa >= -0.0000001) return x;
     else{
           printf("%.3f\n",x);
           func1(x);
     }
}

float func2(float x){
     float xa = x;
     x = (x*x*x-5*x*x+x+3)/(3*x*x-5*x+1);
     if(x-xa <= 0.00001 && x-xa >= -0.00001) return x;
     else{
           printf("%.3f\n",x);
           func2(x);
     }
}

main(){
       float x1,x2;
       printf("Digite o numero inicial da func1:");
       scanf("%f",&x1);
       printf("Digite o numero inicial da func2:");
       scanf("%f",&x2);
       x1 = func1(x1);
       printf("%.5f\n\n",x1);
       x2 = func2(x2);
       printf("%.5f\n\n",x2);
       system("pause");
}
