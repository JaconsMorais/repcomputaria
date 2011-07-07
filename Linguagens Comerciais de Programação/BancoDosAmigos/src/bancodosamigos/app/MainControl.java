/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodosamigos.app;

import bancodosamigos.classes.*;
import bancodosamigos.util.BancoLMFAO;
import bancodosamigos.view.Mensagens;
import bancodosamigos.view.Menus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */

/*
 * Enviar para frank@rc.unesp.br
 * SOO-01/04/2011
 * Ate 06/04
 */
public class MainControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        try {
            BancoLMFAO.criaArquivo();
        } catch (IOException ex) {
        }

        int opcao = 0;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        while(opcao != 3){

            try {
                Menus.mainMenu();
                opcao = Integer.parseInt(buffer.readLine().trim());
                MenuControl.controlMainMenu(opcao);
            } catch (IOException ex) {
            	System.out.println(Mensagens.opcaoInvalidaMenu);
            }
        }
    }

}
