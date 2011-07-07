package Menu;

import Conta.Cliente;
import Usuario.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Caixa extends JFrame{
    public Caixa(/*Cliente c*/) {
        setTitle("Caixa eletr�nico");
        setSize(300, 425);
        getContentPane().setLayout(null);
        
        botaoSaque(/*c*/);
        botaoDeposito(/*c*/);
        botaoSaldos(/*c*/);
        botaoExtratos();
        botaoVoltar();
        		
	setVisible(true);	
        
    }

	private void botaoSaque(/*final Cliente cli*/) {
        JButton voltar = new JButton("Saque");
        voltar.setBounds(30, 30, 235, 50);
        getContentPane().add(voltar);
		voltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                            try {
                                Saque s = new Saque(/*new ClienteDAO(),cli*/);
                            } catch (SQLException ex) {
                                Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}			
		});
	}

	private void botaoSaldos(/*final Cliente cli*/) {
        JButton voltar = new JButton("Saldos");
        voltar.setBounds(30, 100, 235, 50);
        getContentPane().add(voltar);
		voltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Saldos s = new Saldos(/*cli*/);
			}			
		});
	}

	private void botaoDeposito(/*final Cliente cli*/) {
        JButton voltar = new JButton("Dep�sitos");
        voltar.setBounds(30, 170, 235, 50);
        getContentPane().add(voltar);
		voltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                            try {
                                Deposito d = new Deposito(/*new ClienteDAO(),cli*/);
                            } catch (SQLException ex) {
                                Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}			
		});
	}

	private void botaoExtratos(/*final Cliente cli*/) {
        JButton voltar = new JButton("Extratos");
        voltar.setBounds(30, 240, 235, 50);
        getContentPane().add(voltar);
		voltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                            try {
                                Extratos ex = new Extratos(/*new ClienteDAO(),cli*/);
                            } catch (SQLException ex1) {
                                Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex1);
                            }
			}			
		});
	}
	
    private void botaoVoltar(){
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(30, 310, 235, 50);
        getContentPane().add(voltar);
		voltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}			
		});
    }
}
