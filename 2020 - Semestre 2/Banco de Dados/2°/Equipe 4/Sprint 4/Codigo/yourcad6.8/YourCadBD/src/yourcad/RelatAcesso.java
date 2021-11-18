/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

/**
 *
 * @author MaXx
 */
public class RelatAcesso {
    
    private int acesso_id;
    private String usuario_nome;
    private String usuario_funcao;
    private String acesso_data;
    private String acesso_hora;
    private String usuario_status;

    public int getAcesso_id() {
        return acesso_id;
    }

    public void setAcesso_id(int acesso_id) {
        this.acesso_id = acesso_id;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    public String getUsuario_funcao() {
        return usuario_funcao;
    }

    public void setUsuario_funcao(String usuario_funcao) {
        this.usuario_funcao = usuario_funcao;
    }

    public String getAcesso_data() {
        return acesso_data;
    }

    public void setAcesso_data(String acesso_data) {
        this.acesso_data = acesso_data;
    }

    public String getAcesso_hora() {
        return acesso_hora;
    }

    public void setAcesso_hora(String acesso_hora) {
        this.acesso_hora = acesso_hora;
    }

    public String getUsuario_status() {
        return usuario_status;
    }

    public void setUsuario_status(String usuario_status) {
        this.usuario_status = usuario_status;
    }

    public RelatAcesso(int acesso_id, String usuario_nome, String usuario_funcao, String acesso_data, String acesso_hora, String usuario_status) {
        this.acesso_id = acesso_id;
        this.usuario_nome = usuario_nome;
        this.usuario_funcao = usuario_funcao;
        this.acesso_data = acesso_data;
        this.acesso_hora = acesso_hora;
        this.usuario_status = usuario_status;
    }

 

    
    
    
    
}
