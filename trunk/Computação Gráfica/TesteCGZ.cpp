#include <gl/glut.h>
#include <stdio.h>
#include <stdlib.h>

void Inicializa (void)
{       
    glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    
    glMatrixMode(GL_MODELVIEW);
    
    glLoadIdentity();
    
    glClear(GL_COLOR_BUFFER_BIT);
    
    glMatrixMode(GL_PROJECTION);
    
    glLoadIdentity();
    
    gluOrtho2D( 0, 600, 0, 400);
    
    glColor3f(0.0,0.0,0.0);
}

int main(void)
{
     glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);     
     glutInitWindowSize(600,400);
     glutInitWindowPosition(50,50);
     glutCreateWindow("Paint!!!!! Por Thiago (RA 208000701) e Thales (RA 208000729)");   
     Inicializa();
     glutPostRedisplay();
     glutMainLoop();
}
