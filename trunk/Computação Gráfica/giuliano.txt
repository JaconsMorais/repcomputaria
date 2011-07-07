#include <gl/glut.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#define WIDTH 800
#define HEIGHT 600

#define PINCEL    0
#define RETA      1
#define CIRCULO   2

float VERMELHO, VERDE, AZUL;

// Variavel para saber qual desenho sera feito
int tipodesenho = 0;

// Raio e grossura do ponto
int ponto = 2;
int raio = 20;

// Salver posição do click do mouse
int ClickX = 0;
int ClickY = 0;
int ClickX2 = 0;
int ClickY2 = 0;

// Função que desenha uma reta
void DesenhaReta(int x1, int y1, int x2, int y2 )
{
        glBegin(GL_LINES);
         glVertex2i(x1,y1);
         glVertex2i(x2,y2);
        glEnd();
}

// Função que desenha um ponto
void DesenhaPonto(int x, int y)
{
     glBegin(GL_POINTS);
        glVertex2i(x,y);
     glEnd();
}

// Função que desenha um Circulo
void DesenhaCirculo(int xCen, int yCen, int radius)
{
    int i = 0;
    int i2 = 0;
    int f = 1 - radius; 
    int ddF_x = 1; 
    int ddF_y = -2 * radius; 
    int x = 0; 
    int y = radius; 
  
    DesenhaPonto(ClickX, ClickY + radius); 
    DesenhaPonto(ClickX, ClickY - radius); 
    DesenhaPonto(ClickX + radius, ClickY); 
    DesenhaPonto(ClickX - radius, ClickY); 
    
    while(x < y) 
    { 
      
      if(f >= 0) 
      { 
        y--; 
        ddF_y += 2; 
        f += ddF_y; 
      } 
      x++; 
      ddF_x += 2; 
      f += ddF_x;    
      DesenhaPonto(ClickX + x, ClickY + y); 
      DesenhaPonto(ClickX - x, ClickY + y); 
      DesenhaPonto(ClickX + x, ClickY - y); 
      DesenhaPonto(ClickX - x, ClickY - y); 
      DesenhaPonto(ClickX + y, ClickY + x); 
      DesenhaPonto(ClickX - y, ClickY + x); 
      DesenhaPonto(ClickX + y, ClickY - x); 
      DesenhaPonto(ClickX - y, ClickY - x); 

     }
}

// Função Principal de Desenho
void display(void)
{
     
     switch (tipodesenho) {
       case RETA:      DesenhaReta(ClickX,ClickY,ClickX2,ClickY2);
                       break;
       case CIRCULO:   DesenhaCirculo(ClickX,ClickY,raio);
                       break;
       case PINCEL:    DesenhaPonto(ClickX,ClickY);
                       break;
     }                 
     
     glutSwapBuffers();
     
}

void LimparDesenho(){
   glClear(GL_COLOR_BUFFER_BIT);
   glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
   glutSwapBuffers();
}

// Gerenciamento do menu com as opções de cores           
void MenuCor(int op)
{
   switch(op) {
            case 0:
                     VERMELHO = 1.0f;
                     VERDE = 0.0f;
                     AZUL = 0.0f;
                     break;
            case 1:
                     VERMELHO = 0.0f;
                     VERDE = 1.0f;
                     AZUL = 0.0f;
                     break;
            case 2:
                     VERMELHO = 0.0f;
                     VERDE = 0.0f;
                     AZUL = 1.0f;
                     break;
            case 3:
                     VERMELHO = 0.0f;
                     VERDE = 0.0f;
                     AZUL = 0.0f;
                     break;
            case 4:
                     VERMELHO = 1.0f;
                     VERDE = 1.0f;
                     AZUL = 0.0f;
                     break;
            case 5:
                     VERMELHO = 0.0f;
                     VERDE = 1.0f;
                     AZUL = 1.0f;
                     break;
            case 6:
                     VERMELHO = 1.0f;
                     VERDE = 0.0f;
                     AZUL = 1.0f;
                     break;
            case 7:
                     VERMELHO = 1.0f;
                     VERDE = 1.0f;
                     AZUL = 1.0f;
                     break;
    }
    
    glColor3f(VERMELHO,VERDE,AZUL);
    
}           

// Gerenciamento do menu com as op‡äes de cores           
void MenuOpcao(int op)
{
   
   glColor3f( VERMELHO , VERDE , AZUL );
   
   switch(op) {
            case 0: tipodesenho = RETA;
                     break;
            case 1: tipodesenho = CIRCULO;
                     break;
            case 2: tipodesenho = PINCEL;
                     break;
    }
    glutSwapBuffers();
    
}   

void MENU2(int op)
{
   switch(op) {
    case 0: raio++;
            break;
    case 1: raio--;
            break;
    case 2: ponto++;
            break;
    case 3: ponto--;
            break;
    case 4: LimparDesenho();
            break;
    }
    glPointSize(ponto);
} 


// Gerenciamento do menu principal           
void MenuPrincipal(int op)
{
}
              
// Criacao do Menu
void CriaMenu() 
{
    int menu,menucor,menuponto,menu2,menudesenho;

    menucor = glutCreateMenu(MenuCor);
    glutAddMenuEntry("Vermelho",0);
    glutAddMenuEntry("Verde",1);
    glutAddMenuEntry("Azul",2);
    glutAddMenuEntry("Preto",3);
    glutAddMenuEntry("Amarelo",4);
    glutAddMenuEntry("Cyan",5);
    glutAddMenuEntry("Rosa",6);
    glutAddMenuEntry("Branco",7);
    
    menudesenho = glutCreateMenu(MenuOpcao);
    glutAddMenuEntry("Reta",0);
    glutAddMenuEntry("Circulo",1);
    glutAddMenuEntry("Ponto",2);
    
    menu2= glutCreateMenu(MENU2);
    glutAddMenuEntry("Raio + 1",0);
    glutAddMenuEntry("Raio - 1",1);
    glutAddMenuEntry("Pincel + 1",2);
    glutAddMenuEntry("Pincel + 1",3);
    glutAddMenuEntry("Limpar Desenho",4);
    
    menu = glutCreateMenu(MenuPrincipal);
    glutAddSubMenu("Tipos de Desenho",menudesenho);
    glutAddSubMenu("Cores",menucor);
    glutAddSubMenu("Opcoes",menu2);
    
    glutAttachMenu(GLUT_RIGHT_BUTTON);
}

void keyboard(unsigned char key, int x, int y)
{
    if (key == 27) exit(0);
}

void BotaoPressionadoMouse(int x, int y)
{
     if(tipodesenho==PINCEL)
     {
        DesenhaPonto(x,HEIGHT-y);
        glutSwapBuffers();
     }
}

void BotoesMouse(int button, int state, int x, int y)
{        
    if (button == GLUT_RIGHT_BUTTON)
         if (state == GLUT_DOWN) 
            CriaMenu();
    
    if (button == GLUT_LEFT_BUTTON)
         if (state == GLUT_DOWN)
          {
            ClickX = x;
            ClickY = HEIGHT - y;
            display();
            ClickX2 = 0;
            ClickY2 = 0;
          }
          if (state == GLUT_UP)
          {
            ClickX2 = x;
            ClickY2 = HEIGHT - y;
            display();
            ClickX = 0;
            ClickY = 0;
          }
}

// Programa Principal 
int main(void)
{
     glutInitDisplayMode(GLUT_DOUBLE|GLUT_RGB);     
     glutInitWindowSize(WIDTH,HEIGHT);
     glutInitWindowPosition(50,50);
     glutCreateWindow("PROJETO FINAL");
     glutDisplayFunc(display);
     glutKeyboardFunc(keyboard);
     glutMotionFunc(BotaoPressionadoMouse); 
     glutMouseFunc(BotoesMouse);    
     
          glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
     			tipodesenho = RETA;
     			glPointSize(ponto);
     			VERMELHO = 0.0f;
     			VERDE = 0.0f;
     			AZUL = 0.0f;
     			glMatrixMode(GL_MODELVIEW);
     			glLoadIdentity();
     			glClear(GL_COLOR_BUFFER_BIT);
     			glMatrixMode(GL_PROJECTION);
     			glLoadIdentity();
     			gluOrtho2D( 0, WIDTH, 0, HEIGHT);
     			glColor3f(VERMELHO,VERDE,AZUL);
     
     glutMainLoop();
}
