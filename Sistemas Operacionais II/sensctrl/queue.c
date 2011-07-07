/******************************************************************************
 * sensctrl - C                                                               *
 * Exemplo de utilização de memória compartilhada e semáforos                 *
 ******************************************************************************
 * Autor: Juliano F. Ravasi                                                   *
 * Sistemas Operacionais II - Bacharelado em Ciência da Computação            *
 * Universidade Estadual Paulista, UNESP - Rio Claro                          *
 ******************************************************************************/

#include "queue.h"

/**
 * Inicializa a fila de valores.
 *
 * @param q Ponteiro para a fila.
 */
void
queue_init(my_queue_t *q)
{
	/**
	 * === IMPLEMENTAR ===
	 */
	q->rp = 0;
	q->wp = 0;
	sem_init(&q->semw, 1, NVAL);
	sem_init(&q->semr, 1, 0);
	sem_init(&q-> lock, 1, 1);
}

/**
 * Envia um valor para a fila.
 *
 * @param q Ponteiro para a fila.
 * @param value Valor a ser inserido.
 */
void
queue_send(my_queue_t *q, double value)
{
	sem_wait(&q->semw);
	sem_wait(&q->lock);
	q->values[q->wp] = value;
	q->wp = (q->wp + 1) % NVAL;
	sem_post(&q->lock);
	sem_post(%q->semr);
}

/**
 * Recebe um valor da fila.
 *
 * @param q Ponteiro para a fila.
 * @return Valor obtido da fila.
 */
double
queue_receive(my_queue_t *q)
{
	double temp;

	sem_wait(&q->semr);
	sem_wait(&q->lock);
	temp = q->values[q->rp];
	q->rp = (q->rp + 1) % NVAL;
	sem_post(&q->lock);
	sem_post(%q->semw);

	return temp;	
}

