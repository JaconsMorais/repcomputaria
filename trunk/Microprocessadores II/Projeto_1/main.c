#include "D:\Micro II\Projeto_1\pinos.h"


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
   
         tris_a = 255;
         tris_b = 0;
         tris_c = 255;
           
            while (true){
           
           
            delay_ms(100);//delay de 100 ms
            tris_b = tris_b >> 1

            }
}
