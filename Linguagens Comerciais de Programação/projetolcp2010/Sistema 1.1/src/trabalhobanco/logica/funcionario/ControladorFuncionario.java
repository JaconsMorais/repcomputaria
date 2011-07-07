/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhobanco.logica.funcionario;

import trabalhobanco.logica.exceptions.TratarExceptions;

/**
 * classe para controlar os dados do fucnionario
 * @author Administrador
 */
public class ControladorFuncionario {
   ConsultaFuncionarioLogica consultaFuncionarioLogica;

   /**
    * cadastro do funcionario
    * @param CPF
    * @param Nome
    * @param Telefone
    * @param Rua
    * @param Bairro
    * @param Cidade
    * @param Estado
    * @param CEP
    * @param DataAdmissao
    * @param cargo
    * @param salario
    * @return
    */
   public boolean cadastroFuncionario(String CPF, String Nome, String Telefone, String Rua, String Bairro, String Cidade,
            String Estado, String CEP, String DataAdmissao, String cargo, String salario) {

    CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
     try{  boolean registrado = cadastroFuncionario.cadastroFuncionario(CPF, Nome, Telefone, Rua, Bairro, Cidade, Estado, CEP,
             DataAdmissao, cargo, salario);
     return registrado; }
     catch(Exception e){
            try {new TratarExceptions(e);
                cadastroFuncionario.statement.close();
            } catch (Exception ex) {new TratarExceptions(ex);
            }
         return false;
        }
    }
   /**
    * faz a consulta de fucionario por CPF
    * @param cpf
    * @return
    */
   public boolean consultaFuncionarioCPFs(String cpf){
    consultaFuncionarioLogica = new ConsultaFuncionarioLogica();
    try{
   boolean consulta = consultaFuncionarioLogica.consultaFuncionarioCPF(cpf);
    return consulta;
    }catch(Exception e){
            try {new TratarExceptions(e);
                consultaFuncionarioLogica.statement.close();
            } catch (Exception ex) {new TratarExceptions(ex);

            }
         return false;
        }
}

   /**
    *  faz a consulta de fucionario por nome
    * @param nome
    * @return
    */
   public boolean consultaFuncionarioNomes(String nome){
    consultaFuncionarioLogica = new ConsultaFuncionarioLogica();
    try{
   boolean consulta = consultaFuncionarioLogica.consultaFuncionarioNome(nome);
    return consulta;
    }catch(Exception e){
            try {new TratarExceptions(e);
                consultaFuncionarioLogica.statement.close();
            } catch (Exception ex) {new TratarExceptions(ex);

            }
         return false;
        }
}
/**
 *  exclui funcionario
 * @param cpf
 * @return
 */
public boolean ExcluirFuncionarios(String cpf){
        consultaFuncionarioLogica = new ConsultaFuncionarioLogica();
    try{
   boolean consulta = consultaFuncionarioLogica.ExcluirFuncionario(cpf);
    return consulta;
    }catch(Exception e){
            try {new TratarExceptions(e);
                consultaFuncionarioLogica.statement.close();
            } catch (Exception ex) {new TratarExceptions(ex);

            }
         return false;
        }
}
}
