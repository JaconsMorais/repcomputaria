package banco;

import javax.swing.JOptionPane;

/*Classe que trata algumas operaÃ§Ãµes basicas da conta do cliente*/
public class Conta {

	private double saldo = 0;
        private Cliente dono;



    public boolean ValidaConta(int id, int pass){


    if ((dono.getId() == id) && (dono.getPassword() == pass)){
        return true;
    } else return false;

    }


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double valor){
		saldo = saldo + valor;
		JOptionPane.showMessageDialog(null,
				"Deposito Realizado Com Sucesso!");

	}

	public Conta(Cliente cliente,double saldo) {
		super();
		this.saldo = saldo;
                this.dono = cliente;

	}



	public void sacar(double valor){

		saldo = saldo - valor;
		JOptionPane.showMessageDialog(null,
				"Saque Realizado Com Sucesso!");

	}

}

