#include <16F876A.h>

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

#BYTE TRIS_A = 0x85
#BYTE TRIS_B = 0x86
#BYTE TRIS_C = 0x87

#BYTE ADCON0 = 0x1F
#BYTE ADCON1 = 0x9F
#BYTE ADRESH = 0x1E
#BYTE ADRESL = 0x9E

#BIT PIN_0 = ADCON1.0
#BIT PIN_1 = ADCON1.1
#BIT PIN_2 = ADCON1.2
#BIT PIN_3 = ADCON1.3

#BIT CH_3 = ADCON1.3
#BIT CH_4 = ADCON1.4
#BIT CH_5 = ADCON1.5

#BIT CLK_AD1_6 = ADCON1.6
#BIT CLK_AD0_7 = ADCON0.7
#BIT CLK_AD0_6 = ADCON0.6

#BIT TURNON = ADCON0.0
#BIT CONVERSION = ADCON0.2

#BIT ADFM = ADCON1.7

void inicia_ad(void);
int16 le_ad(void);
