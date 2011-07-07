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
public class Localizar extends JFrame{
    public Localizar(){
         super("Localizar");
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
         botaoLocalizar(b);
         add(b,BorderLayout.SOUTH);
         setVisible(true);
    }

    private void botaoLocalizar(Box b){
        JButton loc = new JButton("Localizar");
        loc.setBounds(30, 170, 75, 50);
        b.add(loc);
		loc.addActionListener(new ActionListener(){
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