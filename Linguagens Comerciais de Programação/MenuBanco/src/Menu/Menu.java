package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Banco");
        setSize(300, 285);
        getContentPane().setLayout(null);
        
        botaoFunc();
        botaoCaixa();
        botaoSair();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		setVisible(true);	
        
    }

    private void botaoFunc(){
        JButton func = new JButton("Opera��es de funcion�rio");
        func.setBounds(30, 30, 235, 50);
        getContentPane().add(func);
		func.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Func func = new Func();
			}			
		});
    }
    
    private void botaoCaixa(){
        JButton caixa = new JButton("Caixa eletr�nico");
        caixa.setBounds(30, 100, 235, 50); 
        getContentPane().add(caixa);
		caixa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Caixa cx = new Caixa();
			}			
		});
    }
    
    private void botaoSair(){
        JButton sair = new JButton("Sair");
        sair.setBounds(30, 170, 235, 50); 
        getContentPane().add(sair);
		sair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}			
		});    	
    }
}