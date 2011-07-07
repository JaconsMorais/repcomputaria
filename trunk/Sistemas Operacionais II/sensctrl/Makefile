CC = gcc
CFLAGS = -g -Wall -std=gnu99
LDFLAGS = -lrt -lm

PROGRAMS = controller sensor

default: $(PROGRAMS)

controller: controller.o queue.o util.o
sensor: sensor.o queue.o util.o

clean:
	rm -rf $(PROGRAMS) *.o

Makefile: Makefile.dep
Makefile.dep: *.c *.h
	$(CC) -MM *.c > $@

-include Makefile.dep

