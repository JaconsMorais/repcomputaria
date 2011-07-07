/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import simplex.core.Simplex;
import simplex.core.SimplexMatrix;

/**
 *
 * @author aluno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            // TODO code application logic here
            int rstrs = -1;
            int coefs = -1;
            int i,j;

            double matriz[][],funcObj[],results[],Z[],coef;

            BufferedReader tecl = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Digite o numero de coeficientes: ");
            
            while(coefs < 1){
                try {
                    coefs = Integer.parseInt(tecl.readLine());
                    if(coefs < 1) System.out.print("ERRO! Digite o numero de coeficientes: ");
                } catch (IOException ex) {
                    System.out.print("ERRO! Digite um numero positivo não-nulo: ");
                }
            }

            System.out.print("Digite o numero de restrições: ");

            while(rstrs < 1){
                try {
                    rstrs = Integer.parseInt(tecl.readLine());
                    if(rstrs < 1) System.out.print("ERRO! Digite o numero de restrições: ");
                } catch (IOException ex) {
                    System.out.print("ERRO! Digite um numero inteiro positivo não-nulo: ");
                }
            }

            funcObj = new double[coefs+rstrs];
            Z = new double[rstrs+1];
            results = new double[rstrs+1];
            matriz = new double[rstrs][coefs+rstrs];

            Z[0] = 1;

            for(i = 0;i < coefs; i++){
                try {
                    System.out.print("Digite o valor de X" + (i + 1) + " da funcao objetiva: ");
                    coef = Double.parseDouble(tecl.readLine());
                    funcObj[i] = -coef;
                } catch (IOException ex) {
                    System.out.print("ERRO! Digite um numero: ");
                }
            }

            for(j = 0; j < rstrs;j++){
                for(i = 0;i < coefs; i++){
                    try {
                        System.out.print("Digite o valor de X" + (i + 1) + " da restrição "+ (j + 1) +": ");
                        coef = Double.parseDouble(tecl.readLine());
                        matriz[j][i] = coef;
                        matriz[j][coefs+j] = 1;
                    } catch (IOException ex) {
                        System.out.print("ERRO! Digite um numero: ");
                    }
                }
                
                try {
                    System.out.print("Digite o valor do resultado da restrição "+ (j + 1) +": ");
                    coef = Double.parseDouble(tecl.readLine());
                    results[j+1] = coef;
                } catch (IOException ex) {
                    System.out.print("ERRO! Digite um numero: ");
                }
            }

            new Simplex(new SimplexMatrix(Z,funcObj,matriz,results));
    }

}
