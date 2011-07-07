#include "C:\Users\Thales\Desktop\Prova Micro\Prova.h"

int cheio,prov;

#INT_TIMER0
void tempo ()
{
   int16 conta;
   set_timer0 (131 - get_timer0 ());
   conta++;
   if (conta == 625)
   {
      conta = 0;
      prov++;
   }
}

void emergencia(){

txreg = printf("EMERGÊNCIA\n");

while(botaoem != 0){
sirene = 1;
motor = 0;
valvula = 0;
ledfim = 0;
}

sirene = 0;

}

void delay ()
{
int temp;
   set_timer0 (131);  
   enable_interrupts (global | int_timer0);
   while (prov < 15)
   {
         if (botaoem == 1)
         {
            disable_interrupts(GLOBAL);
            temp = get_timer0 ();
            emergencia();
            set_timer0 (temp); 
            enable_interrupts (global | int_timer0);

         }
   }
   prov = 0;
   disable_interrupts(GLOBAL);
}

void ve_galao(){
if (sensorp1 == 0){

if (sensora == 0) printf("20 litros\n");
else printf("10 litros\n");

motor = 0;
}
}

void encher_galao(){
cheio = 0;



txreg = printf("enchendo galão\n");
valvula = 1;

if (sensora == 0){ 
delay();
delay();
}
else delay();

valvula = 0;
txreg = printf("galão cheio\n");

cheio = 1;

}

void retoma_esteira(){


if(botaoem == 1) emergencia();
else if(cheio){
while(sensorp2 == 0){ 
 ledfim = 1;
 motor = 0;
}
txreg = printf("fim! recomeçando\n");
motor = 1;
ledfim = 0;

}

cheio = 0;

}

void main()
{

   setup_adc_ports(NO_ANALOGS);
   setup_adc(ADC_OFF);
   setup_spi(SPI_SS_DISABLED);
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_32);
   setup_timer_1(T1_DISABLED);
   setup_timer_2(T2_DISABLED,0,1);
   setup_comparator(NC_NC_NC_NC);
   setup_vref(FALSE);
   enable_interrupts(GLOBAL);
   enable_interrupts(INT_TIMER0);
   
   TRIS_A = 0xff; //porta a - entrada de dados
   TRIS_B = 0xff; //porta b - entrada de dados
   TRIS_C = 0xf0; //porta c - saída de dados(exceto RX)

   while(TRUE){
      
      if(botaoem == 1) emergencia();
      else{
      txreg = printf("Aguardando galão...\n");
            
      while (sensorp1 != 0) motor = 1;
      ve_galao();
      encher_galao();
      retoma_esteira();
      
      }
   }

}
