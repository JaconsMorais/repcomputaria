#include <gl/glut.h>
#include <stdio.h>
#include <stdlib.h>

#define RETA    0
#define CIRCULO 1
#define PINCEL  2
#define LIMPAR  3
#define raio  100

int Modo = 0;
int ClickX = 0;
int ClickY = 0;
int retaX0 = 0;
int retaY0 = 0;
int trans = 0;
int esc = 1;
GLfloat r = 0.0f,g = 0.0f,b = 0.0f, rf, gf, bf;

void Reta(int x, int y)
{
     glBegin(GL_LINES);
     glVertex2i(retaX0,retaY0);
     glVertex2i(x,y);
     glEnd();
}


void Ponto(int x, int y)
{
     glBegin(GL_POINTS);
        glVertex2i(x,y);
     glEnd();
     
}

void DesenhaCirculo(int xCen, int yCen, int radius)
{
    int i = 0;
    int i2 = 0;
    int f = 1 - radius; 
    int ddF_x = 1; 
    int ddF_y = -2 * radius; 
    int x = 0; 
    int y = radius; 
  
    Ponto(xCen, yCen + radius); 
    Ponto(xCen, yCen - radius); 
    Ponto(xCen + radius, yCen); 
    Ponto(xCen - radius, yCen); 
    
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
      Ponto(xCen + x, yCen + y); 
      Ponto(xCen - x, yCen + y); 
      Ponto(xCen + x, yCen - y); 
      Ponto(xCen - x, yCen - y); 
      Ponto(xCen + y, yCen + x); 
      Ponto(xCen - y, yCen + x); 
      Ponto(xCen + y, yCen - x); 
      Ponto(xCen - y, yCen - x); 

     }
}

void ArrastaMouse(int x, int y)
{
     if(Modo == PINCEL){
        glPointSize(esc);
        Ponto(x,400-y);
        glutSwapBuffers();
     }
}

void LimpaTela(){
   glClear(GL_COLOR_BUFFER_BIT);
   glClearColor(rf, gf, bf, 1.0f);
   glutSwapBuffers();
}

void FuncDesenho(void)
{
          
     glColor3f(r,g,b);
     
     if (Modo == RETA)
     {
        if( retaX0 == 0 && retaY0 == 0)
        {
        retaX0 = esc*ClickX+trans;
        retaY0 = esc*ClickY+trans;
        }
        else
        {
        Reta(esc*ClickX+trans,esc*ClickY+trans);
        retaX0 = 0;
        retaY0 = 0;
        }
     }
     else if (Modo == CIRCULO)
        DesenhaCirculo(ClickX+trans,ClickY+trans,esc*raio);
     else if (Modo == PINCEL)
        ArrastaMouse(ClickX,ClickY);
     else if (Modo == LIMPAR)
        LimpaTela();
     
     glutSwapBuffers();
     
}

void Inicializa (void)
{   
    Modo = 0;
    
    glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    
    glMatrixMode(GL_MODELVIEW);
    
    glLoadIdentity();
    
    glClear(GL_COLOR_BUFFER_BIT);
    
    glMatrixMode(GL_PROJECTION);
    
    glLoadIdentity();
    
    gluOrtho2D( 0, 600, 0, 400);
    
    glColor3f(r ,g ,b);
}
           
void MenuDesenho(int op)
{
   if (op == 0)
      Modo = RETA;
   else if (op == 1)
      Modo = CIRCULO;
   else if (op == 2)
      Modo = PINCEL;
   else
      Modo = LIMPAR;
      
}

void MenuCor(int op){
   switch(op) {
            case 0:
                     r = 1.0f;
                     g = 0.0f;
                     b = 0.0f;
                     break;
            case 1:
                     r = 0.0f;
                     g = 1.0f;
                     b = 0.0f;
                     break;
            case 2:
                     r = 0.0f;
                     g = 0.0f;
                     b = 1.0f;
                     break;
            case 3:
                     r = 0.0f;
                     g = 0.0f;
                     b = 0.0f;
                     break;
            case 4:
                     r = 1.0f;
                     g = 1.0f;
                     b = 1.0f;
                     break;
    }
    glutPostRedisplay( );
}

void MenuBack(int op){
   switch(op) {
            case 0:
                     rf = 1.0f;
                     gf = 0.0f;
                     bf = 0.0f;
                     break;
            case 1:
                     rf = 0.0f;
                     gf = 1.0f;
                     bf = 0.0f;
                     break;
            case 2:
                     rf = 0.0f;
                     gf = 0.0f;
                     bf = 1.0f;
                     break;
            case 3:
                     rf = 0.0f;
                     gf = 0.0f;
                     bf = 0.0f;
                     break;
            case 4:
                     rf = 1.0f;
                     gf = 1.0f;
                     bf = 1.0f;
                     break;
    }
    glutPostRedisplay( );
}

void MenuTrans(int op)
{
     switch(op) {
            case 0:  trans = -200;
                     break;
            case 1:  trans = -100;
                     break;
            case 2:  trans = 0;
                     break;
            case 3:  trans = 100;
                     break;
            case 4:  trans = 200;
                     break;
    }
    glutPostRedisplay( );
}

void MenuEscala(int op)
{
     switch(op) {
            case 0:  esc = 1;
                     break;
            case 1:  esc = 2;
                     break;
            case 2:  esc = 4;
                     break;
            case 3:  esc = 8;
                     break;
    }
    glutPostRedisplay( );
}

void MenuTransf(int op)
{
}   

void MenuPrincipal(int op)
{
}
              
void CriaMenu() 
{
    int menu,menu2,menu3,menu4,menu5,menu6,p;
    
    menu = glutCreateMenu(MenuDesenho);
    glutAddMenuEntry("Reta",0);
    glutAddMenuEntry("Circulo",1);
    glutAddMenuEntry("Pincel",2);
    glutAddMenuEntry("Aplica Background(Limpa tela)",3);
    menu2 = glutCreateMenu(MenuCor);
    glutAddMenuEntry("Vermelho",0);
    glutAddMenuEntry("Verde",1);
    glutAddMenuEntry("Azul",2);
    glutAddMenuEntry("Preto",3);
    glutAddMenuEntry("Branco",4);
    menu6 = glutCreateMenu(MenuBack);
    glutAddMenuEntry("Vermelho",0);
    glutAddMenuEntry("Verde",1);
    glutAddMenuEntry("Azul",2);
    glutAddMenuEntry("Preto",3);
    glutAddMenuEntry("Branco",4);
    menu3 = glutCreateMenu(MenuTrans);
    glutAddMenuEntry("-200",0);
    glutAddMenuEntry("-100",1);
    glutAddMenuEntry("0",2);
    glutAddMenuEntry("+100",3);
    glutAddMenuEntry("+200",4);   
    menu4 = glutCreateMenu(MenuEscala);
    glutAddMenuEntry("x1",0);
    glutAddMenuEntry("x2",1);
    glutAddMenuEntry("x4",2);
    glutAddMenuEntry("x8",3);  
    menu5 = glutCreateMenu(MenuTransf);
    glutAddSubMenu("Translação",menu3);
    glutAddSubMenu("Escala",menu4);
    
    
    p = glutCreateMenu(MenuPrincipal);
    glutAddSubMenu("Funções de desenho",menu);
    glutAddSubMenu("Cores",menu2);
    glutAddSubMenu("Cores de fundo",menu6);
    glutAddSubMenu("Transformações",menu5);
    glutAttachMenu(GLUT_RIGHT_BUTTON);
}

void Mouse(int button, int state, int x, int y)
{        
    if (button == GLUT_RIGHT_BUTTON)
         if (state == GLUT_DOWN) 
            CriaMenu();
    
    if (button == GLUT_LEFT_BUTTON)
         if (state == GLUT_DOWN){
            ClickX = x;
            ClickY = 400 - y;
            FuncDesenho();
         }
         
    glutPostRedisplay();
}

int main(void)
{
     glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);     
     glutInitWindowSize(600,400);
     glutInitWindowPosition(50,50);
     glutCreateWindow("Pincel  ---  Por Thiago e Thales");
     glutDisplayFunc(FuncDesenho);
     glutMotionFunc(ArrastaMouse); 
     glutMouseFunc(Mouse);    
     Inicializa();
     
     glutMainLoop();
}
