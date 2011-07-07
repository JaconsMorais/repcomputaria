
// implementação do Método Gauss-Jacobi

/**
 * Codigo cedido por Andre Massao Higa <pirata.no@gmail.com>
 * Universidade Federal de Sao Carlos - Turma 2003
 * Todos os direitos reservados ao autor
 *
 * Esse codigo estah disponivel para consulta em http://www.fundao.pro.br
 *
 */

#include<iostream.h>
#include<stdlib.h>
#include<math.h>

// funções auxiliares

// faz a leitura da matriz inicial
void le_matriz(int aux_ordem, double mat[10][10]){

	cout<<"Digite os coeficientes da matriz!"<<endl;
	for(int i = 0; i < aux_ordem; i++)
		for(int j = 0; j < aux_ordem; j++){
			cout<<"coeficiente da posição "<<i + 1<<","<<j + 1<<": ";
			cin>>mat[i][j];
		}// fim for
	// fim for
}

// cria o vetor X de solução inicial
void cria_vetor_X(int aux_ordem, double mat[10][10], double vet_sol[10], double vet[10]){

	for(int j = 0; j < aux_ordem; j++)
		vet[j] = vet_sol[j] / mat[j][j];
}

// le as soluções das equações e armazena em um vetor
void le_vetor_solucao(int aux_ordem, double vet[10]){

	cout<<"Digite os valores dos resultados das equações!"<<endl;
	for(int j = 0; j < aux_ordem; j++){
		cout<<"Resultado da equação "<<j + 1<<": ";
		cin>>vet[j];
	}// fim for
}

// cria a matriz C a partir da matriz inicial
// matriz C utilizada na relação x = Cx' + g 
void cria_matriz_C(int aux_ordem, double mat[10][10], double mat_aux[10][10]){

	for(int i = 0; i < aux_ordem; i++)
		for(int j = 0; j < aux_ordem; j++)
			if(i == j)
				mat_aux[i][j] = 0;
			else
				mat_aux[i][j] = -1 * (mat[i][j] / mat[i][i]);
		// fim for
	// fim for
}

// cria o vetor g da relação x = Cx' + g
void cria_vetor_G(int aux_ordem, double mat[10][10], double vet[10], double vet_aux[10]){

	for(int i = 0; i < aux_ordem; i++)
		vet_aux[i] = vet[i] / mat[i][i];
}

// função q realiza a multiplicação entre uma matriz e um vetor
void multiplica_Matriz_Vetor(int aux_ordem, double mat[10][10], double vet[10], double vet_aux[10]){

	double coef = 0;
	for(int i = 0; i < aux_ordem; i++){
		for(int j = 0; j < aux_ordem; j++)	
			coef = coef + mat[i][j] * vet[j];
			//fim for
		vet_aux[i] = coef;
	}// fim for
}

// cria um vetor para uma iteraçao
void cria_vetor_de_iteracoes(int aux_ordem, double mat[10][10], double vet_g[10], 
							 double vet_x[10], double vet_aux[10]){

	multiplica_Matriz_Vetor(aux_ordem, mat, vet_x, vet_aux);
	// criado o vetor de iteração
	for(int i = 0; i < aux_ordem; i++)
		vet_aux[i] = vet_aux[i] + vet_g[i];
	// fim for		
}

// faz a troca de elementos entre dois vetores
void troca_vetor(int aux_ordem, double vet1[10], double vet2[10]){

	for(int i = 0; i < aux_ordem; i++)
		vet1[i] = vet2[i];
	// fim for
}

// apenas escreve na tela o vetor
void escreve_vetor(int aux_ordem, double vet[10]){

	for(int i = 0; i < aux_ordem; i++)
		cout<<vet[i]<<endl;
	//fim for
}

// escreve na tela a matriz inicial e seu vetor solução
void escreve_matriz(int aux_ordem, double mat[10][10], double vet[10]){

	for(int i = 0; i < aux_ordem; i++){
		for(int j = 0; j < aux_ordem; j++)
			if(j != (aux_ordem - 1))
				cout<<mat[i][j]<<"x + ";
			else
				cout<<mat[i][j]<<"x";
			// fim if
		// fim for
		cout<<" = "<< vet[i]<<endl;
	}// fim for
}

// retorna o maior valor de um vetor
// valor em modulo
double retorna_maior(int aux_ordem, double vet[10]){

	double maior = fabs(vet[0]);
	for(int i = 1; i < aux_ordem; i++)
		if(maior > fabs(vet[i]))
			maior = fabs(vet[i]);
		//fim if
	// fim for
	return maior;
}

double calculo_do_delta(int aux_ordem, double vet_x[10], double vet_1[10], double vet_aux[10]){

	double aux_erro = 0;
	for(int i = 0; i < aux_ordem; i++)
		vet_aux[i] = fabs(vet_1[i]);

	for(int j = 0; j < aux_ordem; j++)
		vet_aux[j] = vet_aux[j] - vet_x[j];

	aux_erro = retorna_maior(aux_ordem, vet_aux) / retorna_maior(aux_ordem, vet_1);
	return aux_erro;
}

// programa principal
void main(){
	
	//constante
	const int max = 10;
	
	double matriz[max][max],
		   vetor_solucao[max],
		   vetor_x[max],
		   matrizC[max][max],
		   vetorG[max],
	       vet1[max],
		   vet2[max]; // vetores auxiliares
	
	double erro;

	int ordem, iteracoes;
	
	cout<<endl;
	cout<<"Metodo de Solução de Equações por Gauss-Jacobi!!!"<<endl<<endl;
	cout<<"Digite a ordem da Matriz"<<endl<<"Ordem: ";
	cin>>ordem;
	le_matriz(ordem, matriz);
	le_vetor_solucao(ordem, vetor_solucao);
	cout<<endl<<"Matriz problema"<<endl<<endl;
	escreve_matriz(ordem, matriz, vetor_solucao);
	cout<<endl;
	cout<<"Digite o erro ou tolerância: ";
	cin>>erro;
	cout<<"Digite o número de iterações: ";
	cin>>iteracoes;
	
	// criação do vetor inicial x, da Matriz C e do vetor G
	cria_vetor_X(ordem, matriz, vetor_solucao, vetor_x);
	cria_matriz_C(ordem, matriz, matrizC);
	cria_vetor_G(ordem, matriz, vetor_solucao, vetorG);

	cria_vetor_de_iteracoes(ordem, matrizC, vetorG, vetor_x, vet1);
	double aux = 9999;
	while(iteracoes >= 0 && aux > erro){
		aux = calculo_do_delta(ordem, vetor_x, vet1, vet2);
		if(aux > erro){
			iteracoes--;
			troca_vetor(ordem, vetor_x, vet1);		
			// rcria um novo vetor para uma nova iteração
			cria_vetor_de_iteracoes(ordem, matrizC, vetorG, vetor_x, vet1);
		}// fim if
	}// fim while
	cout<<"A solução do Sistema é: "<<endl;
	escreve_vetor(ordem, vet1);
	cout<<"Para um erro menor do que "<<erro<<endl;
}