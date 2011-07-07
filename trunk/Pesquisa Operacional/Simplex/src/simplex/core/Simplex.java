/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.core;

/**
 *
 * @author aluno
 */
public class Simplex {
    SimplexMatrix mObj;

    public Simplex(){
        
    }

    public Simplex(SimplexMatrix m){
        initMatrix(m);
        SimplexMethod();
    }

    protected void SimplexMethod(){
        while(!OptimalSolution(mObj)){
            SimplexIteration();
            mObj.printSimplexMatrix();
        }
    }

    private void SimplexIteration() {
        int indexPivot[] = new int[2];
        indexPivot = findPivot();
        pivotRowDivision(indexPivot);
        otherRowsManipulation(indexPivot);
    }

    protected void initMatrix(SimplexMatrix m) {
        mObj = m;
    }

    private int[] findPivot() {
        int indexPivot[] = new int[2];
        double min = 0;
        boolean first = true;

        for(int j = 1;j < mObj.funcObjLength+1;j++){
            if(mObj.simplexMatrix[0][j] < 0){
                if(first){
                    min = mObj.simplexMatrix[0][j];
                    indexPivot[1] = j;
                    first = false;
                }else if(min > Math.min(min,mObj.simplexMatrix[0][j])){
                    min = mObj.simplexMatrix[0][j];
                    indexPivot[1] = j;
                }
            }
        }

        first = true;

        for(int i = 1;i < mObj.resultsFuncsLength;i++){
            if(mObj.simplexMatrix[i][indexPivot[1]] > 0){
                if(first){
                    min = mObj.simplexMatrix[i][mObj.funcObjLength+1] / mObj.simplexMatrix[i][indexPivot[1]];
                    indexPivot[0] = i;
                    first = false;
                }else if(min > 0 && min > Math.min(min,mObj.simplexMatrix[i][mObj.funcObjLength+1] / mObj.simplexMatrix[i][indexPivot[1]])){
                    min = mObj.simplexMatrix[i][mObj.funcObjLength+1] / mObj.simplexMatrix[i][indexPivot[1]];
                    indexPivot[0] = i;
                }
            }
        }
        return indexPivot;
    }

    private void pivotRowDivision(int[] indexPivot) {
        double pivot = mObj.simplexMatrix[indexPivot[0]][indexPivot[1]];
        for(int i = 1 ; i < mObj.funcObjLength+2 ; i++)
            mObj.simplexMatrix[indexPivot[0]][i] /= pivot;
    }

    private void otherRowsManipulation(int[] indexPivot) {
        double mul;
        for(int i = 0 ; i < mObj.resultsFuncsLength ; i++){
            mul = -1 * mObj.simplexMatrix[i][indexPivot[1]];
            for(int j = 1 ; j < mObj.funcObjLength+2 ; j++){
                if(i != indexPivot[0]) mObj.simplexMatrix[i][j] += mul*mObj.simplexMatrix[indexPivot[0]][j];
            }
        }
    }

    protected boolean OptimalSolution(SimplexMatrix mObj) {
        boolean b = true;
        for(int i = 1 ; i < mObj.funcObjLength+1 ; i++){
            if(mObj.simplexMatrix[0][i] < 0){
                b = false;
                break;
            }
        }
        return b;
    }
}