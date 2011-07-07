/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import javax.swing.*;
/**
 *
 * @author ZÃ©
 */
public class Menu extends inicializar{

    int op = 0;
    double a;
    int pass,contnumber;
    private Conta c;
    private Cliente cli;

    @Override
    public void inicializa() {

          MenuCliente();
          MenuValidacao();

    }

    public void MenuCliente(){
        cli = new Cliente();
        while(op != 4){

            op = Integer
                        .parseInt(JOptionPane
                                        .showInputDialog("1 - CPF \n2 - Conta\n 3 - Senha \n 4 - Finalizar "));
            switch(op){


                case 1 :
                        a = Double.parseDouble(JOptionPane
                                                    .showInputDialog("Digite o cpf " ));
				cli.setCpf(a);

                break;
                case 2 :
                      contnumber = Integer.parseInt(JOptionPane
                                                .showInputDialog("Digite a conta " ));
				cli.setPassword(contnumber);

                break;
                case 3 :
                       pass = Integer.parseInt(JOptionPane
                                                .showInputDialog("Digite a senha " ));
				cli.setId(pass);

                break;

                case 4:

				break;
                default:
				JOptionPane.showMessageDialog(null,
						"Opcao Invalida");
                break;

            }

        }

      c = new Conta(cli, 100);

    }

    public void MenuCaixa(){

        while (op != 4) {
			op = Integer
					.parseInt(JOptionPane
							.showInputDialog("1 - Sacar\n2 - Depositar\n3 - Saldo\n4 - Sair"));
			switch (op) {

			case 1:
				a = Double.parseDouble(JOptionPane
						.showInputDialog("Digite o valor " + "a ser Sacado:"));
				c.sacar(a);
				break;
			case 2:

				a = Double.parseDouble(JOptionPane
						.showInputDialog("Digite o Valor a Ser "
								+ "Depositado: "));
				c.depositar(a);
				break;
			case 3:

				JOptionPane.showMessageDialog(null, "Seu Saldo Ã©: "
						+ c.getSaldo());
				break;
			case 4:
				break;

			default:
				JOptionPane.showMessageDialog(null,
						"Opcao Invalida");
			break;

			}



    }


 }

    public void MenuValidacao(){


        while (op != 3) {
        op = Integer
                        .parseInt(JOptionPane
                                        .showInputDialog("1 - Entre com Nro da conta \n2 - Insira a Senha\n 3 - Logar "));
            switch(op){

             case 1 :
                      contnumber = Integer.parseInt(JOptionPane
                                                .showInputDialog("Digite a conta " ));


                break;
                case 2 :
                       pass = Integer.parseInt(JOptionPane
                                                .showInputDialog("Digite a senha " ));
                break;

                case 3:
				break;

             default:
				JOptionPane.showMessageDialog(null,
						"Opcao Invalida");
                break;
            }
        }

       if (c.ValidaConta(contnumber, pass)) {

                MenuCaixa();
       }else {
              JOptionPane.showMessageDialog(null,
						"Conta ou senha inexistente");


              }

    }

}
