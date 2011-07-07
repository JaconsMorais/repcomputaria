#include "C:\RE_Micro\slave_1.h"

int16 x = 0;
int1 alt = 0;

void config_slave_1()
{
   setup_adc_ports(RA0_ANALOG);
   setup_adc(ADC_CLOCK_DIV_2 | ADC_CLOCK_INTERNAL);
   setup_spi(SPI_SLAVE|SPI_L_TO_H|SPI_CLK_DIV_4);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_1);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,1);
   setup_ccp1(CCP_OFF);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);
}

void rotina_conversor_ad()
{
   set_adc_channel(0);
   x = read_adc();
   
  
   printf("Valor do potenciometro: %Lu",x);
   puts("\n");
}

void rotina_slave_1()
{
    if (spi_data_is_in()){
      alt = spi_read();
      
      if (!alt){
         spi_write(make8(x,0));
         printf ("Valor %u para o Master", make8(x,0));
         puts ("\n");
      }else if(alt && !spi_data_is_in()){
         spi_write(make8(x,1));
         printf ("Valor %u para o Master", make8(x,1));
         puts ("\n");
      }
      
      if(alt) printf ("Recebi 1 -  Valor alto do Master");
      else printf ("Recebi 0 - Valor baixo do Master");
      puts ("\n");
    }
}

void main()
{
   config_slave_1();
   
   while (true)
   {
      rotina_conversor_ad();
    
      rotina_slave_1();
    
      delay_ms(150);
   }
}
