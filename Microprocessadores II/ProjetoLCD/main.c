#include "D:\Micro II\ProjetoLCD\main.h"

void clock(){
   E = 1;
   delay_cycles(1);
   E = 0;
   delay_cycles(1);

}

void verificaBF(void)
{
   TRIS_C = 0xff;
   RW = 1;
   delay_ms (1);

   while(BF);
   
   TRIS_C = 0x00;
   RW = 0;
   delay_ms (1);
}


void EscreveInstr (char Instr)
{
   RS = 0;
   
   PORTA_C = instr;
   clock ();
   verificaBF ();
}


void EscreveDado (char dado)
{
   RS = 1;
   
   PORTA_C = dado;
   clock ();
   verificaBF ();
}

void initLCD(){
   
   TRIS_C = 0x00;
   RW = 0;
   RS = 0;
   
   PORTA_C = 0x38; //inicializa
   clock();
   delay_ms (15);

   clock();
   delay_ms (15);

   EscreveInstr (0x06);
   EscreveInstr (0x0e);
   EscreveInstr (0x01);
   
   
}

   
 
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
   
   TRIS_A = 0xFF;
   TRIS_B = 0x00;
   TRIS_C = 0xFF;
   
   initLCD();
   
   EscreveDado ('S');
   delay_ms (1000);
   EscreveInstr (0x01);
   
   while (TRUE)
   {

   }

   

}
