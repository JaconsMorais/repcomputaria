#include "C:\Users\cn208000729\Desktop\AnalogDigital.h"

void inicia_ad (void){

/*Configure the A/D module:
• Configure analog pins/voltage reference and
digital I/O (ADCON1)
• Select A/D input channel (ADCON0)
• Select A/D conversion clock (ADCON0)
• Turn on A/D module (ADCON0)*/

adcon1 = 0b10000000;
adcon0 = 0b00000000;
adon = 1;

/*3. Wait the required acquisition time.*/

delay_ms(1);

}

int16 le_ad (void){

int16 a = 0;

/*4. Start conversion:
• Set GO/DONE bit (ADCON0)*/

godone = 1;

/*5. Wait for A/D conversion to complete, by either:
• Polling for the GO/DONE bit to be cleared
(with interrupts enabled); OR
• Waiting for the A/D interrupt*/

while(godone);

/*6. Read A/D result register pair
(ADRESH:ADRESL), clear bit ADIF if required.*/

a = adresh;
a = a << 8;
a = a|adresl;

/*7. For the next conversion, go to step 1 or step 2,
as required. The A/D conversion time per bit is
defined as TAD. A minimum wait of 2TAD is
required before the next acquisition starts.*/

return a;

}

void verifica_tecla(void){
int b,c;

for(b=1;b<=4;b++){
for(c=1;c<=3;c++){

}
}
}

void main()
{

   float volt;

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
   TRIS_B = 0xFF;
   TRIS_C = 0b10111111;
   
   inicia_ad();

   

   while(true){
   volt = 5*(float)le_ad()/1023;
   printf("\r\n%.3f",volt);
   delay_ms(100);
   }

}
