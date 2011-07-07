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

//registrador de leitura e escrita
#BYTE PORTA_A = 0x05
#BYTE PORTA_B = 0x06
#BYTE PORTA_C = 0x07

#BYTE TRIS_A = 0x85
#BYTE TRIS_B = 0x86 // saida de dados
#BYTE TRIS_C = 0x87 // entrada de dados

#byte adresh = 0x1E
#byte adresl = 0x9E
#byte adcon0 = 0x1F
#byte adcon1 = 0x9F
#byte pir1 = 0x0C
#byte pie1 = 0x8C
#byte intcon = 0x8B

#bit adon = adcon0.0
#bit godone = adcon0.2
#bit adfm = adcon1.7


