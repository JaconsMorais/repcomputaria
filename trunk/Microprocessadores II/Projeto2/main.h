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

#use delay(clock=4000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8)

#byte porta_a = 0x05 //registrador de leitura e escrita
#byte porta_b = 0x06 //registrador de leitura e escrita
#byte porta_c = 0x07 //registrador de leitura e escrita

#byte tris_a = 0x85
#byte tris_b = 0x86
#byte tris_c = 0x87

#byte port_c = 0x07

