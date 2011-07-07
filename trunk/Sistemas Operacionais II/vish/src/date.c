#include <time.h> 
#include <stdio.h> 
           
void date()
{
    int size= 256;
    char buffer[size]; 
    time_t curtime; 
    struct tm *loctime; 
      
    /* obtem o tempo atual. */ 
    curtime = time (NULL); 
      
    /* Converte para representação de tempo local. */ 
    loctime = localtime (&curtime); 
      
    /* formata a data e hora para um padrão */ 
    //fputs (asctime (loctime), stdout); 
      
    // formata saida  
    strftime (buffer, size, "Data: %A, %B %d.\n", loctime); 
    fputs (buffer, stdout); 
    strftime (buffer, size, "Hora: %I:%M %p.\n", loctime); 
    fputs (buffer, stdout); 
    
}          
      
int main (void) 
{ 
    date();
    return 0; 
} 

