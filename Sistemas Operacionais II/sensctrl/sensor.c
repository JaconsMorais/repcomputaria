/******************************************************************************
 * sensctrl - C                                                               *
 * Exemplo de utilização de memória compartilhada e semáforos                 *
 ******************************************************************************
 * Autor: Juliano F. Ravasi                                                   *
 * Sistemas Operacionais II - Bacharelado em Ciência da Computação            *
 * Universidade Estadual Paulista, UNESP - Rio Claro                          *
 ******************************************************************************/

// Cabeçalhos comuns
#include "util.h"
#include "queue.h"

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <math.h>

// Mapeamento de memória e gerenciamento de memória compartilhada
#include <sys/types.h>
#include <sys/mman.h>
#include <fcntl.h>

/**
 * Termina a execução por erro de sintaxe da linha de comando.
 */
void
die_usage(void)
{
	error("Uso: sensor NOME");
	fatal("Utilização incorreta.");
}

/**
 * Gera um par de valores aleatórios pela distribuição Normal.
 */
void rand_normal(double mean, double stdev, double values[2])
{
	double v1, v2, s;
	do {
		v1 = 2 * ( (double) rand() / (double) RAND_MAX ) - 1;
		v2 = 2 * ( (double) rand() / (double) RAND_MAX ) - 1;
		s = v1*v1 + v2*v2;
	}
	while (s > 1);
		
	v1 *= sqrt(-2 * log(s) / s);
	values[0] = v1 * stdev + mean;

	v2 *= sqrt(-2 * log(s) / s);
	values[1] = v2 * stdev + mean;
}

/**
 * Função de entrada do programa.
 *
 * Sintaxe:
 *    sensor NOME
 *
 * Inicia o sensor, que utilizará o segmento de memória compartilhada
 * com o nome fornecido.
 *
 * @param argc Número de argumentos na linha de comando.
 * @param argv Vetor de argumentos da linha de comando.
 * @return Zero para execução com êxito, diferente de zero para erro.
 */
int main(int argc, char *argv[])
{
	if (argc != 2)
		die_usage();

	const char *const shmname = argv[1];
	const size_t shmsize = sizeof(my_queue_t);

	my_queue_t *q;

	/**
	 * === IMPLEMENTAR ===
	 *
	 * - Abrir o segmento de memória compartilhada cujo nome que está em
	 *      'shmname'.
	 * - Mapear a memória compartilhada no espaço virtual do processo,
	 *      obtendo um ponteiro 'q' para a memória compartilhada.
	 */
	
    	int shmdes = shm_open(shmname, O_CREAT | O_RDWR, 0600);
	if (shmdes < 0){
		perror("shm_open");
		exit(EXIT_FAILURE);
	}
	if (ftruncate(shmdes,sizeof(int)) < 0){
		perror("ftruncate");
		exit(EXIT_FAILURE);
	}

	int *p = mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE, MAP_SHARED, shmdes, 0);

	if(p == MAP_FAILED){
		perror("mmap");
		exit(EXIT_FAILURE);
	}

	printf("Novo valor: ", %d\n, *p);

	for (int i = 0; i < 50; i++) {
		double v[2];
		rand_normal(25.0, 3.0, v);
		queue_send(q, v[0]); printf("Enviado valor %lf.\n", v[0]);
		queue_send(q, v[1]); printf("Enviado valor %lf.\n", v[1]);
	}

	queue_send(q, -1.0);

	/**
	 * === IMPLEMENTAR ===
	 *
	 * - Remover o mapeamento de memória em 'q'.
	 * - Fechar o segmento de memória compartilhada.
	 */

	munmap(q, shmsize);
	close(shmdes);
	return 0;
}
