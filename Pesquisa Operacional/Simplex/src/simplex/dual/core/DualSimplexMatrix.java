/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.dual.core;

import simplex.core.SimplexMatrix;

/**
 *
 * @author aluno
 */
public class DualSimplexMatrix extends SimplexMatrix{
    public double dualSimplexMatrix[][];
    public int dualResultsFuncsLength, dualFuncObjLength;

    public DualSimplexMatrix(double z[],double fObj[],double Matrix[][],double Results[]){
        super(z,fObj,Matrix,Results);
        initMatrix();
    }

    private void initMatrix() {
        dualSimplexMatrix = new double[funcObjLength+2][resultsFuncsLength];
        for(int i = 0; i < resultsFuncsLength; i++)
            for(int j = 0; j < funcObjLength+2; j++)
                dualSimplexMatrix[i][j] = simplexMatrix[j][i];
        dualResultsFuncsLength = funcObjLength;
        dualFuncObjLength = resultsFuncsLength;
    }
}
