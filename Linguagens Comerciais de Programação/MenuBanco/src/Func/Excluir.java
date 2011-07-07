/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Func;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thales
 */
public class Excluir extends JFrame{
    public Excluir(/*OpFuncDAO DAO*/){
         super("Excluir");
         Box b = Box.createHorizontalBox();
         setSize(700, 285);
         getContentPane().setLayout(new BorderLayout());

         String[] colunas = new String []{"Conta","Nome","CPF","Endereço","Saldo"};
         String[][] dados = new String [][] {
                {"1","Zé da Silva","123.456.789-01","Rua Falsa, 123","R$ 100,00"},
                {"2","João de Souza","987.654.321-01","Rua Falsa, 456","R$ 125,57"}
         };
         JTable tabela = new JTable(dados,colunas);

         add(new JScrollPane(tabela),BorderLayout.CENTER);
         getContentPane().add(new JScrollPane(tabela));
         botaoVoltar(b);
         botaoExcluir(b);
         add(b,BorderLayout.SOUTH);
         setVisible(true);
    }

    private void botaoExcluir(Box b){
        JButton ex = new JButton("Excluir");
        ex.setBounds(30, 170, 75, 50);
        b.add(ex);
		ex.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
    }

    private void botaoVoltar(Box b){
        JButton sair = new JButton("Voltar");
        sair.setBounds(30, 170, 75, 50);
        b.add(sair);
		sair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
    }
}