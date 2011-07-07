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
public class Usuario implements Serializable{
    private static long serialVersionUID = 1L;
    private Long idUsuario;
    private String login;
    private String senha;
    private Integer tipoUsuario;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}
