/******************************************************************************
 * sensctrl - C                                                               *
 * Exemplo de utilização de memória compartilhada e semáforos                 *
 ******************************************************************************
 * Autor: Juliano F. Ravasi                                                   *
 * Sistemas Operacionais II - Bacharelado em Ciência da Computação            *
 * Universidade Estadual Paulista, UNESP - Rio Claro                          *
 ******************************************************************************/

#ifndef QUEUE_H
#define QUEUE_H

#include <semaphore.h>

#define NVAL 10


typedef struct my_queue my_queue_t;

/**
 * Representa a região de memória compartilhada, representa uma fila de
 * valores simples.
 */
struct my_queue
{
	double values[NVAL];
	int rp, wp;
	sem_t semw;
	sem_t semr;
	sem_t lock;
	/**
	 * === IMPLEMENTAR ===
	 */
};


void queue_init(my_queue_t *q);
void queue_send(my_queue_t *q, double value);
double queue_receive(my_queue_t *q);


#endif
