#include "D:\Micro II\Projeto RS-232\main.h"

 void envia_byte(char a){
 
 while(!TRMT);
 while(!TXIF);
 TXREG = a;  
   
 }
 
 char recebe (char *a)
 

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
 set_tris_c(0xBF);
 

 
 while(true){
   //printf("Micro2\R\N");
   //putc(getc());
   envia_byte();
   
 
 }

}
