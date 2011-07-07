#include "C:\RE_Micro\slave_2.h"

int8 hg = 0, lw = 0;
int16 out = 0;
int1 y = 1, alt = 0;

void config_slave_2()
{
   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_CLOCK_DIV_2);
   setup_spi(SPI_SLAVE|SPI_L_TO_H|SPI_CLK_DIV_4);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_1);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,1);
   setup_ccp1(CCP_OFF);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);
}
 
void refresh_leds()
{
      output_bit(LED_1,bit_test(out,0));
      output_bit(LED_2,bit_test(out,1));
      output_bit(LED_3,bit_test(out,2));
      output_bit(LED_4,bit_test(out,3));
      output_bit(LED_5,bit_test(out,4));
      output_bit(LED_6,bit_test(out,5));
      output_bit(LED_7,bit_test(out,6));
      output_bit(LED_8,bit_test(out,7));
      output_bit(LED_9,bit_test(out,8));
      output_bit(LED_10,bit_test(out,9));
}

void rotina_slave_2()
{
    if (spi_data_is_in()){
      if(y){
         lw = spi_read();
         printf ("Recebi %u do Master",lw);
         puts ("\n");
         alt = 0;
         y = 0;
      }else{
         hg = spi_read();
         out = make16(lw,hg);
         printf ("Recebi %u do Master", hg);
         puts ("\n");
         refresh_leds();
         printf (" Leds Atualizados");
         puts ("\n");
         alt = 1;
         y = 1;
      }
      
      spi_write(alt);
       
      
      if(alt) printf (" 1 -  Master com o valor mais significativo");
      else printf (" 0 -  Master com o valor menos significativo");
      puts ("\n");
    }
}

void main()
{ 
   config_slave_2();
   
   while (true)
   {
      rotina_slave_2();
   }
}
