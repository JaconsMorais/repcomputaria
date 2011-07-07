#include <16F876A.h>
#device adc=8

#FUSES NOWDT                    //No Watch Dog Timer
#FUSES HS                       //High speed Osc (> 4mhz for PCM/PCH) (>10mhz for PCD)
#FUSES NOPUT                    //No Power Up Timer
#FUSES PROTECT                  //Code protected from reads
#FUSES NODEBUG                  //No Debug mode for ICD
#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O
#FUSES CPD                      //Data EEPROM Code Protected
#FUSES NOWRT                    //Program memory not write protected

#use delay(clock=20000000)
#use rs232(UART1)
 
#define LED_1 PIN_B0
#define LED_2 PIN_B1
#define LED_3 PIN_B2
#define LED_4 PIN_B3
#define LED_5 PIN_B4
#define LED_6 PIN_B5
#define LED_7 PIN_B6
#define LED_8 PIN_B7
#define LED_9 PIN_C0
#define LED_10 PIN_C1
