#include "C:\Users\Thales\Desktop\Micro\Micro II\Prova Rep micro\Teste 2\main.h"

int1 i = 1;

#int_timer1
void us(){

set_timer1(25000);
output_bit(PIN_C2,i);

i = !i;

}

void main()
{

   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_OFF);
   setup_spi(SPI_SS_DISABLED);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_4);
   setup_timer_1(T1_INTERNAL|T1_DIV_BY_2);
   setup_timer_2(T2_DIV_BY_16,93,1);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);
   // TODO: USER CODE!!




while(true){
/*output_bit(PIN_C2,1);
delay_us(10);
output_bit(PIN_C2,0);
delay_us(90);*/
}

}
