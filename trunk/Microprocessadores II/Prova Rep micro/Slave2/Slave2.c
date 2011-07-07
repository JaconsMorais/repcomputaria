#include "C:\Users\Thales\Desktop\Micro\Micro II\Prova Rep micro\Slave2.h"

int8 mem[80], dado, instr, end;

void escreve()
{
   while(!spi_data_is_in());
   
   dado = spi_read();
   
   if(address >= 0 || address <= 80)
   {
      mem[end] = dado;
   }
}

BYTE le()
{
    return (mem[end]);
}


void inicia_spi()
{
      while(!spi_data_is_in());
      instr = spi_read();
      
      while(!spi_data_is_in());
      end = spi_read();

      if (instr == 0x18)
      {
         instr = spi_read(mem[end]);
      }
      else if(instr == 0xa)
      {
         escreve();
      } 
}

void main()
{

   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_OFF);
   setup_spi(spi_slave | spi_h_to_l | spi_ss_disabled);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_1);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,1);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);

   // TODO: USER CODE!!
   while(true){
      int pot;
      
      inicia_spi();
   }

}
