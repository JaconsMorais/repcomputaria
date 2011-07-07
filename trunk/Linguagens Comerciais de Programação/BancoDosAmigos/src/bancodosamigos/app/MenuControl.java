/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodosamigos.app;

import bancodosamigos.classes.Banco;
import bancodosamigos.classes.Cliente;
import bancodosamigos.classes.Conta;
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
public class MenuControl {
	private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
    public static void controlMainMenu(int opcao) throws IOException{
        switch(opcao){
            case 1:
            	boolean voltar = false;
            	boolean criou = false;
            	
            	Conta c = new Conta();
            	Banco b = new Banco();
            	Cliente cli = new Cliente();
            	
            	while(!voltar){
	                ArrayList<String> al = Menus.menuNovoCliente(buffer);
	                if((al.get(0) != null && !al.get(0).equals("")) || (al.get(1) != null && !al.get(1).equals(""))){
		                try{
		                	c = Conta.criaConta();
		                	
			                b.setNome("B.O.A.A");
			                b.setnAgencia(c.getnAgencia());
			                
			                cli.setNome(al.get(0));
			                long l = Long.parseLong(al.get(1));
			                cli.setCPF(l);
			                cli.setnConta(c.getnConta());
			                criou = true;
		                }catch(Exception ex){
		                	System.out.println(Mensagens.erroCriarCampoInvalido);
		                }finally{
		                	if(criou){
		    	                BancoLMFAO.insereAgencia(b);
		    	                BancoLMFAO.insereConta(c, cli);
		    	                System.out.println(Mensagens.sucessoCriarConta);
		                	}
		                	voltar = MenuControl.controlMenuVoltar();
		                }
	                }else{
	                	System.out.println(Mensagens.erroCriarConta);
	                	voltar = MenuControl.controlMenuVoltar();
	                }
            	}
                break;
            case 2:
                int s[] = Menus.menuClienteJaExistente(buffer);
                MenuControl.controlMenuClienteJaExistente(s[0], s[1]);
                break;
            case 3:
                System.out.println(Mensagens.fim);
                break;
            default:
                System.out.println(Mensagens.opcaoInvalidaMenu);
                break;
        }
    }

    public static void controlMenuClienteJaExistente(int nAgencia, int nConta){
    	ArrayList al = BancoLMFAO.getBancoContaCliente(nAgencia, nConta);
    	int opcao = 0;
    	
    	if(!al.isEmpty()){
    		Banco banco = (Banco)al.get(0);
    		Conta conta = (Conta)al.get(1);
    		Cliente cliente = (Cliente)al.get(2);
    		while(opcao != 4){
	    		try{
		    		Menus.menuOperacoes(cliente.getNome());
		    		opcao = Integer.parseInt(buffer.readLine().trim());
		    		MenuControl.controlMenuOperacoes(opcao, banco, conta, cliente);
	    		}catch(Exception ex){
	    			System.out.println(Mensagens.opcaoInvalidaMenu);
	    		}
    		}
    	}else{
    		System.out.println(Mensagens.erroLoginConta);
    	}
    }

    public static void controlMenuOperacoes(int opcao, Banco banco, Conta conta, Cliente cliente){
        switch(opcao){
            case 1:
            	try{
	            	Menus.menuDeposito();
	            	double dep = Double.parseDouble(buffer.readLine());
	            	conta.depositar(dep);
	            	BancoLMFAO.updateXML(banco, conta, cliente);
	            	System.out.println(Mensagens.sucessoDeposito);
            	}catch(Exception ex){
            		System.out.println(Mensagens.erroDeposito);
            	}
                break;
            case 2:
            	try{
	            	Menus.menuSaque();
	            	double sac = Double.parseDouble(buffer.readLine());
	            	if(conta.getSaldo() >= sac){
		            	conta.sacar(sac);
		            	BancoLMFAO.updateXML(banco, conta, cliente);
		            	System.out.println(Mensagens.sucessoSaque);
	            	}else{
	            		System.out.println(Mensagens.erroSaqueSemSaldo);
	            	}
            	}catch(Exception ex){
            		System.out.println(Mensagens.erroSaque);
            	}
                break;
            case 3:
            	conta.exibeSaldo();
                break;
            case 4:
            	System.out.println(Mensagens.voltaFinal);
                break;
            default:
            	System.out.println(Mensagens.opcaoInvalidaMenu);
                break;
        }
    }
    
    public static boolean controlMenuVoltar() throws IOException{
    	System.out.print(Mensagens.volta);
    	String volta = buffer.readLine();
    	do{
    		if(volta.equals("s") || volta.equals("S")){
    			return true;
    		}else if(!(volta.equals("n") || volta.equals("N"))){
    			System.out.print(Mensagens.erroVolta);
    			volta = buffer.readLine();
    		}else{
    			return false;
    		}
    	}while(!(volta.equals("s") || volta.equals("S") || volta.equals("n") || volta.equals("N")));
    	
    	return false;
    }
}
