#ifndef UTIL_H
#define UTIL_H

#include <stdarg.h>

void verror(const char *msg, va_list args);
void error(const char *msg, ...);
void fatal(const char *msg, ...);

char * chop(char *str);

#define SERVERPORT	7000
#define SERVERADDR	"127.0.0.1"
#define MAXCONCLIENTS  	20
#define MAXUSERNAMEL	100
#define MAXPASSWDL		100
#define MAXMSGL			200

enum msgType {Login, Logout, Message};

typedef struct {
	char user[MAXUSERNAMEL];
	enum msgType msgtype;
	char msgbuff[MAXMSGL];
} msg_t;



#endif
