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
public class Cliente {

    private int cliente_id;
    private String cliente_nome;
    private String cliente_documento;
    private String cliente_apelido;
    private String cliente_endereco;
    private String cliente_complementoEndereco;
    private String cliente_numeroEndereco;
    private String cliente_cep;
    private String cliente_cidade;
    private String cliente_uf;
    private String cliente_bairro;

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCliente_documento() {
        return cliente_documento;
    }

    public void setCliente_documento(String cliente_documento) {
        this.cliente_documento = cliente_documento;
    }

    public String getCliente_apelido() {
        return cliente_apelido;
    }

    public void setCliente_apelido(String cliente_apelido) {
        this.cliente_apelido = cliente_apelido;
    }

    public String getCliente_endereco() {
        return cliente_endereco;
    }

    public void setCliente_endereco(String cliente_endereco) {
        this.cliente_endereco = cliente_endereco;
    }

    public String getCliente_complementoEndereco() {
        return cliente_complementoEndereco;
    }

    public void setCliente_complementoEndereco(String cliente_complementoEndereco) {
        this.cliente_complementoEndereco = cliente_complementoEndereco;
    }

    public String getCliente_numeroEndereco() {
        return cliente_numeroEndereco;
    }

    public void setCliente_numeroEndereco(String cliente_numeroEndereco) {
        this.cliente_numeroEndereco = cliente_numeroEndereco;
    }

    public String getCliente_cep() {
        return cliente_cep;
    }

    public void setCliente_cep(String cliente_cep) {
        this.cliente_cep = cliente_cep;
    }

    public String getCliente_cidade() {
        return cliente_cidade;
    }

    public void setCliente_cidade(String cliente_cidade) {
        this.cliente_cidade = cliente_cidade;
    }

    public String getCliente_uf() {
        return cliente_uf;
    }

    public void setCliente_uf(String cliente_uf) {
        this.cliente_uf = cliente_uf;
    }

    public String getCliente_bairro() {
        return cliente_bairro;
    }

    public void setCliente_bairro(String cliente_bairro) {
        this.cliente_bairro = cliente_bairro;
    }

    public Cliente(int cliente_id, String cliente_nome, String cliente_documento, String cliente_apelido, String cliente_endereco, String cliente_complementoEndereco, String cliente_numeroEndereco, String cliente_cep, String cliente_cidade, String cliente_uf, String cliente_bairro) {
        this.cliente_id = cliente_id;
        this.cliente_nome = cliente_nome;
        this.cliente_documento = cliente_documento;
        this.cliente_apelido = cliente_apelido;
        this.cliente_endereco = cliente_endereco;
        this.cliente_complementoEndereco = cliente_complementoEndereco;
        this.cliente_numeroEndereco = cliente_numeroEndereco;
        this.cliente_cep = cliente_cep;
        this.cliente_cidade = cliente_cidade;
        this.cliente_uf = cliente_uf;
        this.cliente_bairro = cliente_bairro;
    }
                                                                               

    
    
    
}
