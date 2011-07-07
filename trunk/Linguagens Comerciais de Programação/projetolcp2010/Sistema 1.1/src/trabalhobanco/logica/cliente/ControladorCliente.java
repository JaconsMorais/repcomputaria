/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhobanco.logica.cliente;

import trabalhobanco.logica.exceptions.TratarExceptions;

/**
 *Classe para controlar os dados do cliente
 * @author Administrador
 */
public class ControladorCliente {
   ConsultaClienteLogica consultaClienteLogica;

   /**
    *
    * @param CPF
    * @param Nome
    * @param Telefone
    * @param Rua
    * @param Bairro
    * @param Cidade
    * @param Estado
    * @param CEP
    * @param CPF_c
    * @param Nome_c
    * @param EstCivil
    * @param Filhos
    * @param Empresa
    * @param Rua_f
    * @param Bairro_f
    * @param CEP_f
    * @param Telefone_f
    * @param Cargo
    * @param Tempo
    * @param casa
    * @param carro
    * @param Banco
    * @param clienteDesde
    * @return
    */
   public boolean cadastroClientes(String CPF, String Nome, String Telefone, String Rua, String Bairro,
            String Cidade, String Estado, String CEP, String CPF_c, String Nome_c,
            String EstCivil, String Filhos, String Empresa, String Rua_f, String Bairro_f,
            String CEP_f, String Telefone_f, String Cargo, String Tempo,
            String casa, String carro, String Banco, String clienteDesde){

    CadastroCliente cadastroCliente = new CadastroCliente();
     try{  boolean registrado = cadastroCliente.cadastroCliente(CPF, Nome, Telefone, Rua, Bairro, Cidade,
        Estado, CEP, CPF_c, Nome_c, EstCivil, Filhos, Empresa, Rua_f, Bairro_f,
        CEP_f, Telefone_f, Cargo, Tempo, casa, carro, Banco, clienteDesde);
     return registrado; }
     catch(Exception e){
            try {new TratarExceptions(e);
                cadastroCliente.statement.close();
            } catch (Exception ex) {
            }
         return false;
        }
    }
   /**
    * faz a consulta de clientes por CPF
    * @param cpf
    * @return
    */
   public boolean consultaClienteCPFs(String cpf){
    consultaClienteLogica = new ConsultaClienteLogica();
    try{
   boolean consulta = consultaClienteLogica.consultaClienteCPF(cpf);
    return consulta;
    }catch(Exception e){
            try {new TratarExceptions(e);
                consultaClienteLogica.statement.close();
            } catch (Exception ex) {

            }
         return false;
        }
}

/**
 * faz a consulta de clientes por nome
 * @param nome
 * @return
 */
public boolean consultaClienteNomes(String nome){
    consultaClienteLogica = new ConsultaClienteLogica();
    try{
   boolean consulta = consultaClienteLogica.consultaClienteNome(nome);
    return consulta;
    }catch(Exception e){
            try {new TratarExceptions(e);
                consultaClienteLogica.statement.close();
            } catch (Exception ex) {

            }
         return false;
        }
}

/**
 * exclui clientes
 * @param cpf
 * @return
 */
public boolean ExcluirClientes(String cpf){
        consultaClienteLogica = new ConsultaClienteLogica();
    try{
   boolean consulta = consultaClienteLogica.ExcluirCliente(cpf);
    return consulta;
    }catch(Exception e){
            try {new TratarExceptions(e);
                consultaClienteLogica.statement.close();
            } catch (Exception ex) {

            }
         return false;
        }
}
}
