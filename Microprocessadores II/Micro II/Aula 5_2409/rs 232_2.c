#include ".\rs 232_2.h"


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
   
   TX = 0;
   RX = 1;
   
   TRIS_B = 0x00;
   
   while(1)
   {
      //putc(getc());
      LED = 1;
      delay_ms(300);
      
      LED = 0;
      delay_ms(300);
      
      if(verificaFlag())
      {
         if(recebeByte())
            enviaByte('T');
      }      
   }
}

int verificaFlag(void)
{
   if(TXIF && TRMT)
   {
      return 1; 
   }
   return 0;
}

int recebeByte(void)
{
   CREN = 1;
   RCIF = 1;
   
   if(FLAG)
   {
      return 1;
   }
   CREN = 0;
   return 0;
   
}

void enviaByte(char palavra)
{
   TXREG = palavra;
}

/*
void enviaByte(char palavra)
{
   while(! TRMT);
   while(! TXIF);
   TXREG = palavra;
}

int recebeByte(char *a)
{
   if(RCIF)
   {
      *a = RCREG;
      return 1;
   }
   return 0;

}

main()
{
   if(recebeByte(&a))
   {
      enviaByte('A');
   }
}

*/
