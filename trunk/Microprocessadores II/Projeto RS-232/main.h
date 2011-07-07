#include <16F876A.h>
#device adc=8

#FUSES NOWDT                    //No Watch Dog Timer
#FUSES LP                       //Low power osc < 200 khz
#FUSES NOPUT                    //No Power Up Timer
#FUSES NOPROTECT                //Code not protected from reading
#FUSES NODEBUG                  //No Debug mode for ICD
#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O
#FUSES NOCPD                    //No EE protection
#FUSES WRT_50%                  //Lower half of Program Memory is Write Protected

#use delay(clock=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8)

#byte TXREG = 0x19
#byte RCREG = 0x1A

#byte = PIR1 = 0x0C
#byte = TXSTA = 0x98

#bit TXIF = PIR1.4
#bit TRMT = TXSTA.1



#byte PORT_C = 0x07


#bit C7 = PORT_C.7
#bit C6 = PORT_C.6
