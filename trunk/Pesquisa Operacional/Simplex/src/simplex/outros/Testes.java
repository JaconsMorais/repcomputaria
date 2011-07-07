/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.outros;

/**
 *
 * @author aluno
 */
public class Testes {
    public static void escreveMatrizes(double z[],double fObj[],double rstrs[][], double results[]){
            System.out.print(z[0]);
            for(int i = 0;i < fObj.length; i++) System.out.print(" " + fObj[i]);
            System.out.println(" " + results[0]);

            for(int i = 0;i < results.length; i++){
                System.out.print(z[i+1]);
                for(int j = 0; j < fObj.length+results.length;j++) System.out.print(" " + rstrs[i][j]);
                System.out.println(" " + results[i+1]);
            }
    }
}
