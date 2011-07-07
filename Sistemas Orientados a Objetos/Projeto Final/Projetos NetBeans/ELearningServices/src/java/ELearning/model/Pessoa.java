/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.model;

import java.io.Serializable;

/**
 *
 * @author Acessa SP
 */
public class Pessoa extends Usuario implements Serializable{
    private static long serialVersionUID = 1L;
    private String endereco;
    private String telefone;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
