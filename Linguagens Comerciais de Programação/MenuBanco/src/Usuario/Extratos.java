package Usuario;

import Conta.Cliente;
import DAO.ClienteDAO;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Extratos extends JFrame{
    public Extratos(/*ClienteDAO c,Cliente cli*/) throws SQLException{
         super("Extratos");
         //ResultSet rs = c.selectTransacao( cli.getId());
         Box b = Box.createHorizontalBox();
         setSize(300, 285);
         getContentPane().setLayout(new BorderLayout());
         
         String[] colunas = new String []{"Transação","Valor"};
         String[][] dados = new String [][] {
                {"Saque","R$ 20,00"},
                {"Depósito","R$ 50,00"}
         };
         JTable tabela = new JTable(dados,colunas);
         
         add(new JScrollPane(tabela),BorderLayout.CENTER);
         getContentPane().add(new JScrollPane(tabela));
         botaoVoltar(b);
         add(b,BorderLayout.SOUTH);
         setVisible(true);
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
