#include ".\conversor AD.h"


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
   
   TRIS_A = 0xFF;
   set_tris_b(0xFF);
   set_tris_c(0b10111111);
   
   inicia_ad();
   
   while(1)
   {
      delay_ms(100);
      printf("\r\n%ld", le_ad());

   }
}

void inicia_ad(void)
{
   //Configure analog pins/voltage
   PIN_0 = 0;
   PIN_1 = 0;
   PIN_2 = 1;
   PIN_3 = 0;
   
   //Channel
   CH_3 = 0;
   CH_4 = 0;
   CH_5 = 0;
   
   //Clock
   CLK_AD1_6 = 0;
   CLK_AD0_7 = 0;
   CLK_AD0_6 = 0;
   
   //Right justified
   ADFM = 1;   
   
   //Turn on module A/D
   TURNON = 1;
   
   delay_ms(15);
   
}

int16 le_ad(void)
{
   int16 content;
   
   //Start conversion
   CONVERSION = 1;   
   
   while(CONVERSION == 1);
   //Lê do registrador ADRESH
   content = ADRESH;
   //Desloca 8 bits do conteúdo
   content = (content <<8) | ADRESL;
   //concatena com ADRESL
   //content = content + ADRESL;
   
   return content;
}
