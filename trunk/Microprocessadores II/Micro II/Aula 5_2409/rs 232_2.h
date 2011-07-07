#include <16F876A.h>
#device adc=8

#FUSES NOWDT                    //No Watch Dog Timer
#FUSES XT                       //Crystal osc <= 4mhz
#FUSES NOPUT                    //No Power Up Timer
#FUSES NOPROTECT                //Code not protected from reading
#FUSES NODEBUG                  //No Debug mode for ICD
#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O
#FUSES NOCPD                    //No EE protection
#FUSES WRT_50%                  //Lower half of Program Memory is Write Protected

#use delay(clock=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8)

#BYTE PORT_A = 0x05
#BYTE PORT_B = 0x06
#BYTE PORT_C = 0x07

#BYTE TRIS_B = 0x86

#BIT LED = PORT_B.0

#BIT TX = PORT_C.6
#BIT RX = PORT_C.7

#BYTE TXIF = 0x0C
#BYTE TRMT = 0x98
#BYTE TXREG = 0x19

#BYTE RCIF = 0x0C
#BYTE RCIE = 0x8C
#BYTE RCSTA = 0x18
#BYTE CREN = 0x18

#BIT FLAG = RCSTA.9

int verificaFlag(void);
void enviaByte(char palavra);
int recebeByte(void);

/*
////////////TX
#BYTE PIR1 = 0x0C
#BYTE TXSTA = 0x98
#BIT TXIF = PIR1.4
#BIT TRMT = TXSTA.1

////////////RX
#BYTE RCREG = 0x1A
#BYTE RCSTA = 0x18
#BIT RCIF = PIR1.5
#BIT CREN = RCSTA.4
*/
