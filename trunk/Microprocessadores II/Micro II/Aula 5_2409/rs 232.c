#include ".\rs 232.h"


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
   
   PORT_C.6 = 0;
   PORT_C.7 = 1;
   
   set_tris_c(X);
   
   while(1)
   {
      printf("RS 232");
      getc();
      putc(getc());
   }
}
