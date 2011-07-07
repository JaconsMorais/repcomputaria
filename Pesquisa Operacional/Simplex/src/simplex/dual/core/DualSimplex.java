/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.dual.core;

import simplex.core.SimplexMatrix;

/**
 *
 * @author Thales
 */
public class DualSimplex {

    SimplexMatrix mObj;
    DualSimplexMatrix mobj;
    String flag;

    public DualSimplex(DualSimplexMatrix m){
        flag = "D"; //Forma Dual
        initMatrix(m);
        DualSimplexMethod(flag);
    }

    public DualSimplex(SimplexMatrix m){
        flag = "P"; //Forma Primal
        initMatrix(m);
        DualSimplexMethod(flag);
    }

    private void initMatrix(DualSimplexMatrix m) {
        mobj = m;
    }

    private void initMatrix(SimplexMatrix m) {
        mObj = m;
    }

    private void DualSimplexMethod(String flag) {
        if(flag.equals("P")){
            while(!OptimalSolution(flag)){
                DualSimplexIteration(flag);
                mObj.printSimplexMatrix();
            }
        }
        if(flag.equals("D")){
            while(!OptimalSolution(flag)){
                DualSimplexIteration(flag);
                mobj.printSimplexMatrix();
            }
        }
    }

    private boolean OptimalSolution(String flag) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void DualSimplexIteration(String flag) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}