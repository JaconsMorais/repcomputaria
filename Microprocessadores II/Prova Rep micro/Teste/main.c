#include "C:\Users\Thales\Desktop\Micro\Micro II\Prova Rep micro\Teste\main.h"

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

   float volt = 0,voltant = 0, pot, duty;
 
   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_OFF);
   setup_spi(SPI_SS_DISABLED);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_4);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DIV_BY_16,93,1);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);
   setup_ccp1(CCP_PWM);


   // TODO: USER CODE!!
   
   TRIS_A = 0xFF;
   TRIS_B = 0xFF;
   TRIS_C = 0b10111011;
   
   inicia_ad();

   

   while(true){
    voltant = volt;
    volt = 5*(float)le_ad()/1023;
    if(volt != voltant){
     pot = volt*100/5;
     printf("\r\nPot%cncia do motor: %.3f%%",136,pot);
    }
    
    delay_ms(100);
    //duty = (int)pot*1023/100;    
    duty = 100;
    if(pot != 0){
     output_bit(PIN_C2,1);
     set_pwm1_duty(duty);
    }else output_bit(PIN_C2,0);
   }

}
