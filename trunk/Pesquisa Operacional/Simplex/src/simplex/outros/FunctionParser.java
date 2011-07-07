/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.outros;

import java.util.regex.Pattern;

/**
 *
 * @author Thales
 */
public class FunctionParser {
    public FunctionParser(){
        if(verifyFunction()){

        }
    }

    private boolean verifyFunction() {
        if(verifyFuncObj() || verifyRstr()) return true;
        else return false;
    }
     
    private boolean verifyFuncObj() {
        Pattern pattern = Pattern.compile("Z=[+-]?\\d*[*][a-zA-Z].*([+-]\\d*[*][a-zA-Z].*)*");
        return false;
    }

    private boolean verifyRstr() {
        Pattern pattern = Pattern.compile("[+-]?\\d*[*][a-zA-Z].*([+-]\\d*[*][a-zA-Z].*)*(<=|>=)\\d+");
        return false;
    }

}
