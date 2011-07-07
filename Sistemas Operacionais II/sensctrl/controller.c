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

// Cabeçalhos da biblioteca da linguagem C
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
	error("Uso: controller NOME");
	fatal("Utilização incorreta.");
}

/**
 * Função de entrada do programa.
 *
 * Sintaxe:
 *    controller NOME
 *
 * Inicia o controlador, que monitorará o segmento de memória compartilhada
 * com o nome fornecido.
 *
 * @param argc Número de argumentos na linha de comando.
 * @param argv Vetor de argumentos da linha de comando.
 * @return Zero para execução com êxito, diferente de zero para erro.
 */
int
main(int argc, char *argv[])
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
	 * - Dimensionar o segmento de memória para o tamanho 'shmsize'.
	 * - Mapear a memória compartilhada no espaço virtual do processo,
	 *      obtendo um ponteiro 'q' para a memória compartilhada.
	 */

	int shmdes = shm_open(shmname, O_RDWR, 0600);
	if (shmdes < 0){
		perror("shm_open");
		exit(EXIT_FAILURE);
	}
	if (ftruncate(shmdes,sizeof(int)) < 0){
		perror("ftruncate");
		exit(EXIT_FAILURE);
	}

	int *q = mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE, MAP_SHARED, shmdes, 0);

	if(q == MAP_FAILED){
		perror("mmap");
		exit(EXIT_FAILURE);
	}

	// Inicializa a memória compartilhada, que é atribuída a uma
	// fila de mensagens.
	queue_init(q);

	double sum = 0.0;		// Soma dos valores.
	double sum2 = 0.0;		// Soma dos quadrados.
	int n = 0;				// Número de valores lidos.

	double value;

	while ((value = queue_receive(q)) >= 0.0) {
		n++;
		sum += value;
		sum2 += value * value;

		printf("Recebido valor %lf; média %lf; devio %lf.\n",
			   value, sum / n, sqrt(sum2/n - pow(sum/n, 2)));
// 		usleep(500000);
	}

	/**
	 * === IMPLEMENTAR ===
	 *
	 * - Remover o mapeamento de memória em 'q'.
	 * - Fechar o segmento de memória compartilhada.
	 * - Apagar o segmento de memória compartilhada do sistema.
	 */

	munmap(q, shmsize);
	close(shmdes);
	shm_unlink(shmdes);
	return 0;
}

