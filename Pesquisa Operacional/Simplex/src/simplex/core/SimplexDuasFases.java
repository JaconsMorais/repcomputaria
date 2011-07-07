/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.core;

/**
 *
 * @author aluno
 */
public class SimplexDuasFases extends Simplex{
    
    public SimplexDuasFases(SimplexMatrix m){
        super();
        super.initMatrix(m);
        ManipulateArtificialFunction(mObj);
        super.SimplexMethod();
        EliminateArtificials(mObj);
        super.SimplexMethod();
    }

    private void ManipulateArtificialFunction(SimplexMatrix mObj) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    private void EliminateArtificials(SimplexMatrix m) {
        mObj.removeLine(0);
         for(int i = mObj.ArtificialInitIndex; i < mObj.funcObjLength;i++)
            mObj.removeColumn(i);
    }

}
