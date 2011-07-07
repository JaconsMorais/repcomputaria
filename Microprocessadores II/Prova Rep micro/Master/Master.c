#include "C:\Prova Rep micro\Master\Master.h"

void inicia_ad (void){

adcon1 = 0b10000000;
adcon0 = 0b00000000;
adon = 1;

delay_ms(1);

}

int16 le_ad (void){

int16 a = 0;

godone = 1;

while(godone);

a = adresh;
a = a << 8;
a = a|adresl;

return a;

}

void main()
{

   float i = 0,iant = 0, pot, duty;
 
   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_OFF);
   setup_spi(spi_slave | spi_h_to_l | spi_ss_disabled);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_4);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,0);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);



   // TODO: USER CODE!!
   
   TRIS_A = 0xFF;
   TRIS_B = 0xFF;
   TRIS_C = 0b10111111;
   
   inicia_ad();

   while(true){
    iant = i;
    i = (float)le_ad()/1023;
    
    if(PIN_A5){
    if(i != iant){
     pot = i*100/5;
     printf("\r\nPot%cncia do motor: %.3f%%",136,pot);
    }
    }
    
   }
