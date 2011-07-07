/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.core;

/**
 *
 * @author aluno
 */
public class SimplexMatrix {
    private double funcMatrix[][], Z[], funcObj[], resultsFuncs[]; //matrizes
    public double simplexMatrix[][]; //matriz final
    public String vars[],basicas[]; //matrizes com os nomes das variáveis
    public int funcObjLength,resultsFuncsLength; //número de variáveis básicas e não-básicas presentes e número de resultados das funções("b")
    public int DiffInitIndex,ArtificialInitIndex;

    public SimplexMatrix(double z[],double fObj[],double Matrix[][],double Results[]){ //deixa tudo pronto para a manipulação do Simplex
        initZ(z);
        initObj(fObj);
        initMatrix(Matrix);
        initResults(Results);

        initSimplexMatrix();
        printSimplexMatrix();

    }

    private void initZ(double[] z) { //inicializa a matriz Z que está dentro dessa classe
        Z = z;
    }

    private void initObj(double fObj[]){ //inicializa a matriz da função objetiva que está dentro dessa classe
        funcObj = fObj;
        funcObjLength = fObj.length;
    }

    private void initMatrix(double Matrix[][]){ //inicializa a matriz de restrições que está dentro dessa classe
        funcMatrix = Matrix;
    }

    private void initResults(double Results[]){ //inicializa a matriz de resultados que está dentro dessa classe
        resultsFuncs = Results;
        resultsFuncsLength = Results.length;
    }

    private void initSimplexMatrix() { //inicializa a matriz que está dentro dessa classe juntando todas as outras
        int i,j;
        simplexMatrix = new double[resultsFuncs.length][funcObj.length+2];

        for(i = 0; i < resultsFuncs.length; i++){
            simplexMatrix[i][0] = Z[i];
            simplexMatrix[i][funcObj.length+1] = resultsFuncs[i];
        }
        for(j = 0; j < funcObj.length; j++)simplexMatrix[0][j+1] = funcObj[j];
        
        for(i = 1; i < resultsFuncs.length; i++)
            for(j = 1; j < funcObj.length+1; j++)
                simplexMatrix[i][j] = funcMatrix[i-1][j-1];
    }

    public void printSimplexMatrix() { //imprime a matriz na tela
        int i,j;
        for(i = 0; i < resultsFuncs.length; i++){
            for(j = 0; j < funcObj.length+2; j++){
                if(simplexMatrix[0][j] < 0 && i != 0)
                    System.out.print("  "+simplexMatrix[i][j]);
                else
                    System.out.print(" "+simplexMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    protected void removeColumn(int i) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    protected void removeLine(int i) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
