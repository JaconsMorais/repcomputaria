#include "F:\Estudos\Micro II\Projeto elevador\elevador.h"

int16 TMP1 = 0;
int16 TMP2;
int16 conta;
int andares[4],botao;
int i = 0;
int parou = 0;

#INT_TIMER0
void tempo()
{
   set_timer0 (131 - get_timer0 ());
   conta++; //contagem das interrupções
   //printf("%d\n",conta);
}

void insere_andar(int andar[],int i){//guarda na memória o andar pressionado
int teste=0,j;

if(i<4){


 for(j = 0; j<i;j++){
  if(botao == andar[j]){
   teste = 1; //repetição de andares
   break;
  }
 }
 
 if(teste == 0) andar[i] = botao;
 i++;
}

}

void tira_andar(int andar[]){ //tira da memória o andar que já foi
   int i;
   andar[0] = 0;
   for (i = 1;i<4;i++){
    andar[i-1] = andar[i];
    andar[i] = 0;
   }
}

void ordena(int andar[]){ //ordena os andares para irem na ordem
     int i,j,aux;
     
     for(i=1;i<4;i++){
       aux=andar[i];
       for(j=i-1;j>=0 && andar[j] > aux;j--) andar[j+1]=andar[j];
       andar[j+1]=aux;
     } 
}

void motor_passo_frente(int16 timer){

conta = 0;

while(conta != timer){ //passos para frente
 motor1 = 1;
 delay_ms(50);
 motor2 = 1;
 delay_ms(50);
 motor1 = 0;
 delay_ms(50);
 motor3 = 1;
 delay_ms(50);
 motor2 = 0;
 delay_ms(50);
 motor4 = 1;
 delay_ms(50);
 motor3 = 0;
 delay_ms(50);
 motor4 = 0;
 delay_ms(50);
}

}

void motor_passo_tras(int16 timer){

conta = 0;

while(conta != timer){
 motor4 = 1;
 delay_ms(50);
 motor3 = 1;
 delay_ms(50);
 motor4 = 0;
 delay_ms(50);
 motor2 = 1;
 delay_ms(50);
 motor3 = 0;
 delay_ms(50);
 motor1 = 1;
 delay_ms(50);
 motor2 = 0;
 delay_ms(50);
 motor1 = 0;
 delay_ms(50);
}
 
}

void parar_motor_passo(){
motor1 = 0;
motor2 = 0;
motor3 = 0;
motor4 = 0;
}

void debug();

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
   enable_interrupts(INT_RDA);
   enable_interrupts(INT_TIMER0);
   enable_interrupts(GLOBAL);
   //port_b_pullups(TRUE);
   set_timer0(131);
   // TODO: USER CODE!!

andares[0] = 0;
andares[1] = 0;
andares[2] = 0;
andares[3] = 0;
sinal = 0;

   set_tris_a(0x00); //saída de dados
   set_tris_b(0xfe); //entrada de dados,menos bit 0
   set_tris_c(0xbf); //saída de dados, menos bit 6
   
   while(TRUE){
    conta = 0;
    
         if(andares[0] != 0){
            if(andares[0] == 1) TMP1 = 0; 
            if(andares[0] == 2) TMP1 = 100;
            if(andares[0] == 3) TMP1 = 200;
            if(andares[0] == 4) TMP1 = 300;
            
          if(TMP2 < TMP1) motor_passo_frente(TMP1-TMP2);
          else motor_passo_tras(TMP2-TMP1);
     
          conta = 0;
          sinal = 1;
          parar_motor_passo();
          printf("Você está no andar %d",andares[0]);
          tira_andar(andares);
          while(conta != 125);
          sinal = 0;

         }else{
          parar_motor_passo();
          sinal = 1;
        }

    TMP2 = TMP1;
     
    if(!parada){
    while(!parada){
    delay_ms(30);
    parou = 1;
    }
    }

       if(parou){
           printf("Opa!parada de emergência");
           sinal = 0; 
           
       TMP2 = TMP1;
   
            do{
            parar_motor_passo();
            
            if(!parada){
            while(!parada){
            delay_ms(30);
            parou = 0;
            }
            }while(!parou);
            printf("Prosseguindo...");
            sinal = 1;
        }    

        if(!andar1 || !andar2 || !andar3 || !andar4){
          while(!andar1 || !andar2 || !andar3 || !andar4){
            delay_ms(30);
            if(!andar1) botao = 1; 
            if(!andar2) botao = 2;
            if(!andar3) botao = 3;
            if(!andar4) botao = 4;
            insere_andar(andares,i);
            ordena(andares);
          }
        }

debug();
         
               
   }

}

}
