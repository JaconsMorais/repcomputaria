package Menu;

import Func.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Func extends JFrame{
    public Func() {
        setTitle("Opera��es de funcion�rio");
        setSize(300, 425);
        getContentPane().setLayout(null);
        
        botaoCadastrar();
        botaoEditar();
        botaoRemover();
        botaoLocalizar();
        botaoVoltar();
        		
		setVisible(true);	
        
    }
    
    private void botaoCadastrar(){
        JButton cad = new JButton("Cadastrar");
        cad.setBounds(30, 30, 235, 50);
        getContentPane().add(cad);
		cad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}			
		});
    }
    
    private void botaoEditar(){
        JButton edit = new JButton("Editar");
        edit.setBounds(30, 100, 235, 50);
        getContentPane().add(edit);
		edit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Editar ed = new Editar(/*new ClienteDAO(),cli*/);
			}			
		});
    }
    
    private void botaoRemover(){
        JButton rem = new JButton("Remover");
        rem.setBounds(30, 170, 235, 50);
        getContentPane().add(rem);
		rem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Excluir ex = new Excluir(/*new ClienteDAO(),cli*/);
			}			
		});
    }
    
    private void botaoLocalizar(){
        JButton locus = new JButton("Localizar");
        locus.setBounds(30, 240, 235, 50);
        getContentPane().add(locus);
		locus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Localizar local = new Localizar(/*new ClienteDAO(),cli*/);
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
