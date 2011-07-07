#include "D:\Micro II\Projeto1\main.h"

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
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_1);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,1);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);

   // TODO: USER CODE!!
   tris_a = 0xff;
   tris_b = 0x00;
   tris_c = 0xff;
   
   while(TRUE){
            if (porta_c == 0x00) esquerda();
            else direita();
   }
}

/*#include "D:\Micro II\Projeto1\main.h"

int troca = 0;

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

void shift(){
   if (troca == 0){
      troca = 1;
      esquerda();
   }else{
      troca = 0;
      direita();
   }
}

void main()
{
   
   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_OFF);
   setup_spi(SPI_SS_DISABLED);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_1);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,1);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);

   // TODO: USER CODE!!
   tris_a = 0xff;
   tris_b = 0x00;
   tris_c = 0xff;
   
   while(TRUE){
            if (porta_c == 0x00) shift();
   }
}
}
}*/
