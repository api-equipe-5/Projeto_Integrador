/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

/**
 *
 * @author info-aux01
 */
public class Instalacao {
    
    private int instalacao_id;
    private String instalacao_numero;
    private String instalacao_apelido;
    private String instalacao_tipo;
    private String concessionaria_id;
    private String cliente_id;

    public int getInstalacao_id() {
        return instalacao_id;
    }

    public void setInstalacao_id(int instalacao_id) {
        this.instalacao_id = instalacao_id;
    }

    public String getInstalacao_numero() {
        return instalacao_numero;
    }

    public void setInstalacao_numero(String instalacao_numero) {
        this.instalacao_numero = instalacao_numero;
    }

    public String getInstalacao_apelido() {
        return instalacao_apelido;
    }

    public void setInstalacao_apelido(String instalacao_apelido) {
        this.instalacao_apelido = instalacao_apelido;
    }

    public String getInstalacao_tipo() {
        return instalacao_tipo;
    }

    public void setInstalacao_tipo(String instalacao_tipo) {
        this.instalacao_tipo = instalacao_tipo;
    }

    public String getConcessionaria_id() {
        return concessionaria_id;
    }

    public void setConcessionaria_id(String concessionaria_id) {
        this.concessionaria_id = concessionaria_id;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Instalacao(int instalacao_id, String instalacao_numero, String instalacao_apelido, String instalacao_tipo, String concessionaria_id, String cliente_id) {
        this.instalacao_id = instalacao_id;
        this.instalacao_numero = instalacao_numero;
        this.instalacao_apelido = instalacao_apelido;
        this.instalacao_tipo = instalacao_tipo;
        this.concessionaria_id = concessionaria_id;
        this.cliente_id = cliente_id;
    }
    
    
    
}
