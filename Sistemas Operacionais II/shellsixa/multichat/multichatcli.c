/******************************************************************************
		Programa Cliente
 ******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <errno.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <poll.h>
#include <pthread.h>
#include "util.h"

// socket do client
int clientsocket = -1;

// parametros do servidor
int port;
char addres[16];

// buffer de entrada de dados 
char buffer[MAXMSGL];

// dados do cliente
char username[MAXUSERNAMEL];

// thread para recebimento de mensagens
pthread_t thread;


// funcoes do programa
void setup_client(void);
void *receivemsgs(void *arg);


//------------------- configura a conexão do cliente --------------------------
void setup_client()
{	
	// cria o socket do cliente
	if ((clientsocket = socket(AF_INET, SOCK_STREAM, 0)) < 0)
		fatal("socket: %s.", strerror(errno));

	// estrutura para a conexao 
	struct sockaddr_in server;
	server.sin_family = AF_INET;
	server.sin_port = htons (port);
	if (inet_pton(AF_INET, addres, &server.sin_addr) <= 0)
		fatal("Falhou ao interpretar o endereço IP.");
	
	// conecta com o servidor
	if (connect(clientsocket, (struct sockaddr*) &server, sizeof(server)) < 0)
		fatal("connect: %s.", strerror(errno));
}

//------------ funcao para a thread de recebimento de mensagens ---------------
void *receivemsgs(void *arg)
{
	msg_t *rvmsg;
	rvmsg = (msg_t *) malloc (sizeof (msg_t));

	// estrutura para verificacao de eventos de leitura no socket
	struct pollfd fds[1];
	fds[0].fd = clientsocket;
	fds[0].events = POLLIN | POLLPRI;
	int pollret;	

	// loop para leitura no socket	
	while (1)
	{
		// aguarda por conteudo a ser lido ou erro no socket
		while ( !(pollret = poll(fds, 1, 1000)) );
		
		// verifica o evento ocorrido no socket 
		if ( (fds[0].revents & POLLIN) ||
		     (fds[0].revents & POLLPRI) )
		{
			// conteudo a ser lido, le e exibe na tela
			recv(clientsocket, rvmsg, sizeof(msg_t), 0);
			printf("%s: %s\n", rvmsg->user, rvmsg->msgbuff);
			// se o usuario esta digitando uma msg, a reescreve na tela
			printf("%s", buffer);
		}
			else if (fds[0].revents & (POLLHUP | POLLNVAL))
			// ocorreu erro com o socket, termina o programa
			fatal("socket error: %s.", strerror(errno));
	}
	
	return NULL;
}

//---------------------- funcao principal do programa -------------------------
int main(int argc, char *argv[])
{
	port = SERVERPORT;
	strcpy(addres, SERVERADDR);

	// configura socket do cliente
	setup_client();
	printf("\nConectado ao Servidor em: %s:%d\n", addres, port);

	// login com servidor
	// username
	int count = 0;
	printf("\n<<< LOGIN >>>\nUsername:");
	while ((username[count] = getchar()) != '\n')
		count++;
	username[count] = 0;
	//password
	char passwd[MAXPASSWDL];
	count = 0;
	printf("Password:");
	while ((passwd[count] = getchar()) != '\n')
		count++;
	passwd[count] = 0;
	// mensagem de conexao	
	msg_t *msg;
	msg = (msg_t *) malloc (sizeof (msg_t));
	strcpy(msg->user, username);
	strcpy(msg->msgbuff, passwd);
	msg->msgtype = Login;
	// envia mensagem para conexao
	send(clientsocket, msg, sizeof(msg_t), 0);
	// recebe resposta do pedido de conexao do servidor
	recv(clientsocket, msg, sizeof(msg_t), 0);
	printf("Resposta do servidor: %s\n\n", msg->msgbuff);

	// verifica se os dados de login foram aceitos e inicia a troca de msgs
	if (msg->msgtype != Logout)
	{
		printf("Voce esta conectado. Digite 'exit' para sair.\n\n");

		// username em maiuscula
		int i = 0;
		while ((username[i] = toupper(username[i])))
			i++;
		strcpy(msg->user, username);
		
		// inicia thread para recebimento de mensagens
		if (pthread_create(&thread, NULL, receivemsgs, 0))
			fatal("thread_creation: %s.", strerror(errno));

		// estrutura para controle de uso do socket para envio
		struct pollfd fds[1];
		fds[0].fd = clientsocket;
		fds[0].events = POLLOUT;
		int pollret;
	
		char ch = 0;
		int buffpos=0;
		buffer[0] = 0;
		// envia mensagens do usuario para o servidor
		do {
			// le entrada do teclado
			do {
				// aguarda por uma tecla
				while (read(0, &ch, 1) <= 0 ); 
				// se '\n', termina leitura do teclado
				if (ch == '\n') break;
				// adiciona tecla para o buffer 
				buffer[buffpos] = ch;
				buffpos++;
				buffer[buffpos] = 0;	
			} while (1);
			// mensagem do usuario
			strcpy(msg->msgbuff, buffer);
			// limpa o buffer de entrada
			buffpos = 0;
			buffer[buffpos] = 0;
			// define tipo da mensagem
			if (strcmp(msg->msgbuff, "exit"))
				msg->msgtype = Message;
			else
				msg->msgtype = Logout;

			// aguarda por possibilidade de envio ou erro no socket
			while ( !(pollret = poll(fds, 1, 1000)) );

			// verifica o evento ocorrido no socket 
			if (fds[0].revents & POLLOUT)
			{
				// pode enviar, envia mensagem ao servidor
				send(fds[0].fd, msg, sizeof(msg_t), 0);
			}
			else if ( (fds[0].revents & POLLHUP) ||
				  (fds[0].revents & POLLNVAL) )
				// ocorreu erro com o socket, termina o programa
				fatal("socket error: %s.", strerror(errno));

		} while (msg->msgtype != Logout);
	}

	// encerra a conexão com o servidor
	close(clientsocket);

	return 0;
}
