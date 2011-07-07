#include "D:\Micro II\Projeto2\main.h"
#define TMP1 300

char FLAGTEMP01;
char TEMP01;
long CONTADORTMP01;

#INT_TIMER0
void TIMER0_ISR(){
   if (TEMP01){
   
      if (CONTADORTMP01 <= 0){
         CONTADORTMP01 = TMP1;
         FLAGTEMP01 = TRUE;
         
      }else{
         FLAGTEMP01 = FALSE;
         CONTADORTMP01 --;
      }
   }else{
   
   FLAGTEMP01 = FALSE;
   CONTADORTMP01 = TMP1;
   
  }
  
}
  
void direita(){

   porta_b = 0b10000000;
   delay_ms (100);
   while (porta_b != 0b0){
      porta_b >>= 1;
      delay_ms (100);
   }
   
}

void esquerda(){

   porta_b = 0b00000001;
   delay_ms (100);
   while (porta_b != 0b0){
      porta_b <<= 1;
      delay_ms (100);
   }

}

void main()
{

   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_OFF);
   setup_spi(SPI_SS_DISABLED);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_4);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,1);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);
   enable_interrupts(GLOBAL);
   enable_interrupts(INT_TIMER0);
   
   // TODO: USER CODE!!
   tris_a = 0xff;
   tris_b = 0x00;
   tris_c = 0xff;
   
   FLAGTEMP01 = FALSE;
   CONTADORTMP01 = TMP1;
   TEMP01 = TRUE;
   
   while(TRUE){
         if (FLAGTEMP01){
            if (porta_c == 0x00) esquerda();
            else direita();
        //    led = !led;
         }
   }
}
