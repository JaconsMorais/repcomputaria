#include "C:\RE_Micro\master.h"
#define slave_1 PIN_B0
#define slave_2 PIN_B1

int8 cond = 1, alto_slave_1 = 0, baixo_slave_1 = 0;
int1 h = 1, w = 1, offset_slave_2 = 0;
 
void config_master(){
   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_CLOCK_DIV_2);
   setup_spi(SPI_MASTER|SPI_L_TO_H|SPI_CLK_DIV_4|SPI_SS_DISABLED);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_1);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,1);
   setup_ccp1(CCP_OFF);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);
}

void turnon_slave_1 ()
{
   output_bit (slave_1, 0);
}

void turnoff_slave_1 ()
{
   output_bit (slave_1, 1);
}
 
void rotina_slave_1()
{
   if(h){
      spi_write (0);
      printf(" Slave 1 pede o valor menos significativo!");
      puts("\n");
      h = 0;
      
      while (!spi_data_is_in()) {}
   
      if (spi_data_is_in()) baixo_slave_1 = spi_read();
      
      printf("Recebi %u do Slave 1",baixo_slave_1);
      puts("\n");
      
     }else{ 
      spi_write (1);
      printf(" Slave 1 pede o valor mais significativo");
      puts("\n");
      h = 1;
      
      while (!spi_data_is_in()) {}
   
      if (spi_data_is_in()) alto_slave_1 = spi_read();
      
      printf("Recebi %u do Slave 1",alto_slave_1);
      puts("\n");
     }
}

void turnon_slave_2 ()
{
   output_bit (slave_2, 0);
}

void turnoff_slave_2 ()
{
   output_bit (slave_2, 1);
}
 
void rotina_slave_2()
{
     if(w){
      spi_write (baixo_slave_1);
      printf("Mandei para o Slave 2 o valor baixo");
      puts("\n");
      w = 0;
      
      while (!spi_data_is_in()) {}
   
      if (spi_data_is_in()) offset_slave_2 = spi_read();

     }else{ 
      spi_write (alto_slave_1);
      printf("Mandei para o Slave 2 o valor alto");
      puts("\n");
      w = 1;
      
      while (!spi_data_is_in()) {}
   
      if (spi_data_is_in()) offset_slave_2 = spi_read();
     }
     
     if(offset_slave_2) printf("Recebi 1 - Requisicao do Slave 2 pelo valor alto");
     else printf("Recebi 0 - Requisicao do Slave 2 pelo valor baixo");
     puts("\n");
}

void main()
{
   config_master(); 
   
   while (true)
   {  
      
      turnon_slave_1();
     
      rotina_slave_1();
   
      turnoff_slave_1();
   
      delay_ms(300); 
   
      turnon_slave_2();

      rotina_slave_2();
      
      turnoff_slave_2();
   
      delay_ms(200);
   }
}
