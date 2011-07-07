/*----------------------------------------------------------------
  Programa MinQuad
  calcula a funcao que melhor se ajusta aos pontos dados
  atraves do metodo dos minimos quadrados
----------------------------------------------------------------*/

#include <stdio.h>
#include <math.h>

/* M estabelece quantos termos tem a funcao aproximadora */
#define M 3

int N;
float X[30],Y[30];
float A[30][30], B[30];
/* funcoes que compoem a funcao aproximadora */

/* Atencao! as funcoes g0, g1, ... gn devem ser
   alteradas para cada caso! */

float g0( /* float x */)
/* esta funcao nao precisa de parametros... */
{
  return 1;
}

float g1(float x)
{
  return x;
}

float g2(float x)
{
  return x*x;
}


/* esta rotina le via teclado os pontos X e Y */
void LeDados()
{
int i;

  printf("Numero de pontos: n= ");
  scanf("%d",&N);
  printf("\n\nDigite X e Y separados por espacos.\n\n");
  for(i=0;i<N;i++)
    {
      printf("[%3d] ",i+1);
      scanf("%f",&(X[i]));
      scanf("%f",&(Y[i]));
    }
}

float funcao(int i,int k)
{
/* o numero de termos da funcao aproximadora
   afeta as proximas linhas (switch) */
   switch (i)
     {
       case 0 : return( g0(X[k]) );
       case 1 : return( g1(X[k]) );
       case 2 : return( g2(X[k]) );
     }
   return 0;
}

void SistemaNormal()
{
  int i,j,k;
  float r,s;

  for (i=0; i<M; i++)
    {
      for (j=0; j<M; j++)
	A[i][j]=0;
      B[i] = 0;
    }
  for (k=0; k<N; k++)
    {
      for (i=0; i<M; i++)
	{
	  r = funcao(i,k);
	  B[i] += r*Y[k];
	  for (j=0; j<M; j++)
	    {
	      s = funcao(j,k);
	      A[i][j] += r*s;
	    }
	}
    }
}

/* calculo do determinante de uma matriz 2x2 */
float det(float a,float b,float c,float d)
{
  return (a*d)-(b*c);
}

/* esta void mostra na tela o estado atual do sistema normal */
void Show()
{
int i,j;

  printf("Ordem do sistema: n= %d\n\n\n",N);
  for ( i=0;i<M;i++ )
    {
      for ( j=0;j<M;j++ )
	printf("  %12.6f",A[i][j]);
      printf("  %12.6f\n",B[i]);
    }
  printf("\n\n\n<ENTER> ");
  getch();
}


/* faz a triangularizacao do sistema pelo metodo de Gauss */
void TriGauss()
{
int i,j,k;

  Show();
  for (k=0; k<(M-1); k++)
    {
      for ( i=k+1; i<M; i++ )
        {
	  for ( j=k+1; j<M; j++ )
	    A[i][j]=det(A[k][k],A[i][k],A[k][j],A[i][j]);
	  B[i]=det(A[k][k],A[i][k],B[k],B[i]);
	  A[i][k] = 0;
	  Show();
        }
    }
}

/* calcula a matriz das solucoes do sistema ja triangularizado */
void SolGauss()
{
int k,j;
float s;

 X[M-1]=B[M-1]/A[M-1][M-1];
 for ( k=M-2; k>=0; k-- )
   {
     s=0;
     for ( j=k+1; j<M; j++)
       s+=A[k][j]*X[j];
     X[k]=(B[k]-s)/A[k][k];
   }
}


/* mostra o resultado da matriz de solucoes */
void Imprime()
{
int i;

  printf("\n\nSolucao do sistema linear\n");
  for ( i=0;i<M;i++ )
    printf("a(%3d)=%10.6g\n",i,X[i]);
  printf("\n\n\nProblema encerrado.\n");
}

/* programa principal */
int main()
{
  LeDados();
  SistemaNormal();
  TriGauss();
  Show();
  SolGauss();
  Imprime();

  getch();

  return 0;
}
