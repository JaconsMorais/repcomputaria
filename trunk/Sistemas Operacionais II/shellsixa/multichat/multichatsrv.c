/******************************************************************************
	Programa Servidor
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


// soquete do servidor
static int serversock = -1;

// porta do servidor
int port;

// definicao de usuarios/senhas
char *users[3][2] = { {"usuario1", "senha1"}, 
					  {"usuario2", "senha2"},
					  {"usuario3", "senha3"} };

// lista de usuarios conectados
char conusers[MAXCONCLIENTS][MAXUSERNAMEL];

// sockets dos clientes conectados
struct pollfd sockets[MAXCONCLIENTS];

// contador de clientes conectados
int conclients;

// thread para receber conexoes
pthread_t thread;


//funcoes do programa
void setup_server(void);
void login(int clientsocket);
void *acceptconnections(void *arg);
void sendtoall(msg_t *msg);
void removeclientat(int index);


//---------------------- configura a conexão do servidor ----------------------
void setup_server()
{

	struct sockaddr_in local;

	// cria o socket do servidor
	if ((serversock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
		fatal("socket: %s.", strerror(errno));

	// estrutura para a conexao
	local.sin_family = AF_INET;
	local.sin_addr.s_addr = htonl(INADDR_ANY);
	local.sin_port = htons(port);

	// associa o endereco ao socket
	if (bind(serversock, (struct sockaddr*) &local, sizeof(local)) < 0)
		fatal("bind: %s.", strerror(errno));

	// aguarda por uma conexao remota
	if (listen(serversock, MAXCONCLIENTS) < 0)
		fatal("listen: %s.", strerror(errno));

	printf("\nServidor configurado.\n");
}


//------------------------- verica informacoes de login -----------------------
void login(int clientsocket)
{
	msg_t *msg;
	msg = (msg_t *) malloc (sizeof (msg_t));
	recv(clientsocket, msg, sizeof(msg_t), 0);
	int count;
	
	// compara informacoes de login com a lista de usuarios (users)
	for (count = 0; count < 3; count++)
	{
		if (!strcmp(msg->user, users[count][0]) &&
		    !strcmp(msg->msgbuff, users[count][1]))
		{
			// login aceito, informa o cliente
			printf("Usuario '%s' conectou-se.\n", msg->user);
			strcpy(conusers[conclients], msg->user);
			strcpy(msg->user, "SERVER");
			strcpy(msg->msgbuff, "Login aceito, conexao estabelecida.");
			msg->msgtype = Login; 	
			send(clientsocket, msg, sizeof(msg_t), 0);

			//informa os demais clientes conectados sobre o novo usuario
			msg->msgtype = Message;
			strcpy(msg->msgbuff, "Usuario '");
			strcat(msg->msgbuff, conusers[conclients]);
			strcat(msg->msgbuff, "' conectou-se.");
			sendtoall(msg);

			// adiciona o o novo cliente a lista de sockets
			sockets[conclients].fd = clientsocket;
			conclients++;	
			return;
		}
	}

	// login recusado, informa o cliente
	strcpy(msg->user, "SERVER");
	strcpy(msg->msgbuff, "Nome de usuario ou senha invalido, conexao rejeitada.");
	msg->msgtype = Logout;
	send(clientsocket, msg, sizeof(msg_t), 0);
	return;
}

//------------------- thread, aguarda por novas conexoes ----------------------
void *acceptconnections(void *arg)
{
	printf("Aguardando por conexoes...\n\n");
	// conexao com clientes
	struct sockaddr_in peer;
	size_t peerlen = sizeof(peer);

	// socket do cliente em processo de login
	int clientsocket;
	
	// aguarda por novas conexoes
	do {
		while (conclients == MAXCONCLIENTS)
			// maximo de clientes conectados, aguarda 
			system("sleep 30");

		// aceita uma conexao
		if ((clientsocket = accept(serversock, (struct sockaddr*) &peer, &peerlen)) < 0)
			error("accept: %s.", strerror(errno));
		else
			// verifica o login do novo usuario
			login(clientsocket);
	} while (clientsocket != -1);

	return NULL;
}

//------------- envia mensagem para todos os clientes conectados --------------
void sendtoall(msg_t *msg)
{
	int count;
	for (count = 0; count < conclients; count++)
		send(sockets[count].fd, msg, sizeof(msg_t), 0);
}

//------------------ remove cliente na posicao espeficicada -------------------
void removeclientat(int index)
{
	// fecha a conexao com o socket do cliente a ser removido
	close(sockets[index].fd);

	// decrementa o contador de usuarios conectados
	conclients--;
	
	// desloca o descritor dos sockets e usuarios conectados apos index
	int count;
	for (count = index; count < conclients; count++)
	{
		sockets[count].fd = sockets[count+1].fd;
		strcpy(conusers[count], conusers[count+1]);
	}
	sockets[conclients].fd = -1;
}

//----------------------- funcao principal do programa ------------------------
int main(int argc, char *argv[])
{
	// usa porta predefinida
	port = SERVERPORT;

	// configura socket do servidor
	setup_server();
	
	// inicializa estrutura para verificacao de eventos de leitura no socket
	int pollret;	
	for (pollret = 0; pollret < MAXCONCLIENTS; pollret++)
	{
		sockets[pollret].fd = -1;
		sockets[pollret].events = POLLIN | POLLPRI;
	}
	
	conclients = 0;
	// thread p aguardar e estabelecer novas conexoes...
	if (pthread_create(&thread, NULL, acceptconnections, 0))
		fatal("thread_creation: %s.", strerror(errno));	
	
	// recebe mensagens dos clientes e as reenvia para todos os clientes 
	// conectados, enquanto houver clientes conectados 
	msg_t *msg;
	msg = (msg_t *) malloc (sizeof (msg_t));
	int count;
	do {
		// aguarda por evento nos sockets
		while (!conclients || !(pollret = poll(sockets, conclients, 1000)));
		
		// verifica os eventos ocorridos nos sockets dos clientes
		for (count = 0; count < conclients; count++)
		{
			msg->msgtype = Message;

			// se ha conteudo a ser lido no socket
			if ( (sockets[count].revents & POLLIN) ||
			     (sockets[count].revents & POLLPRI))
			{
				// recebe msg do cliente e reenvia a todos
				recv(sockets[count].fd, msg, sizeof(msg_t), 0);
				if (msg->msgtype != Logout)
				{
					printf("%s envia: %s\n", msg->user, msg->msgbuff);
					sendtoall(msg);
				}
			}

			// se cliente solicitou logout ou ocorreu erro com seu socket
			if ( (sockets[count].revents & POLLHUP) ||
			     (sockets[count].revents & POLLNVAL) || 
			     msg->msgtype == Logout )
			{
				// gera msg para avisar sobre a saida do usuario
				printf("Usuario '%s' desconectou-se.\n", conusers[count]);
				strcpy(msg->user, "SERVER");
				strcpy(msg->msgbuff, "Usuario '");
				strcat(msg->msgbuff, conusers[count]);
				strcat(msg->msgbuff, "' desconectou-se.");
				msg->msgtype = Message;
				// remove usuario
				removeclientat(count);
				// informa os demais da saida do usuario
				sendtoall(msg);
				// cliente desconectado, retorna o contador
				count--;
				// se nao ha clientes conectados, finaliza o servidor
				if (!conclients)
					conclients = -1;
			}
		}
	} while (conclients != -1);

	// encerra o socket do servidor
	close(serversock);

	return 0;
}
