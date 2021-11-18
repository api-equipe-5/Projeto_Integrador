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
public class Concessionaria {

    Concessionaria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getConcessionaria_id() {
        return concessionaria_id;
    }

    public void setConcessionaria_id(int concessionaria_id) {
        this.concessionaria_id = concessionaria_id;
    }

    public String getConcessionaria_cnpj() {
        return concessionaria_cnpj;
    }

    public void setConcessionaria_cnpj(String concessionaria_cnpj) {
        this.concessionaria_cnpj = concessionaria_cnpj;
    }

    public String getConcessionaria_nome() {
        return concessionaria_nome;
    }

    public void setConcessionaria_nome(String concessionaria_nome) {
        this.concessionaria_nome = concessionaria_nome;
    }

    public String getConcessionaria_inscricao_estadual() {
        return concessionaria_inscricao_estadual;
    }

    public void setConcessionaria_inscricao_estadual(String concessionaria_inscricao_estadual) {
        this.concessionaria_inscricao_estadual = concessionaria_inscricao_estadual;
    }

    public String getConcessionaria_endereco() {
        return concessionaria_endereco;
    }

    public void setConcessionaria_endereco(String concessionaria_endereco) {
        this.concessionaria_endereco = concessionaria_endereco;
    }

    public String getConcessionaria_endereco_num() {
        return concessionaria_endereco_num;
    }

    public void setConcessionaria_endereco_num(String concessionaria_endereco_num) {
        this.concessionaria_endereco_num = concessionaria_endereco_num;
    }

    public String getConcessionaria_endereco_complemento() {
        return concessionaria_endereco_complemento;
    }

    public void setConcessionaria_endereco_complemento(String concessionaria_endereco_complemento) {
        this.concessionaria_endereco_complemento = concessionaria_endereco_complemento;
    }

    public String getConcessionaria_cep() {
        return concessionaria_cep;
    }

    public void setConcessionaria_cep(String concessionaria_cep) {
        this.concessionaria_cep = concessionaria_cep;
    }

    public String getConcessionaria_cidade() {
        return concessionaria_cidade;
    }

    public void setConcessionaria_cidade(String concessionaria_cidade) {
        this.concessionaria_cidade = concessionaria_cidade;
    }

    public String getConcessionaria_estado() {
        return concessionaria_estado;
    }

    public void setConcessionaria_estado(String concessionaria_estado) {
        this.concessionaria_estado = concessionaria_estado;
    }

    public String getConcessionaria_email() {
        return concessionaria_email;
    }

    public void setConcessionaria_email(String concessionaria_email) {
        this.concessionaria_email = concessionaria_email;
    }

    public String getConcessionaria_site() {
        return concessionaria_site;
    }

    public void setConcessionaria_site(String concessionaria_site) {
        this.concessionaria_site = concessionaria_site;
    }
        public String getConcessionaria_bairro() {
        return concessionaria_bairro;
    }

    public void setConcessionaria_bairro(String concessionaria_bairro) {
        this.concessionaria_bairro = concessionaria_bairro;
    }

    public Concessionaria(int concessionaria_id, String concessionaria_cnpj, String concessionaria_nome, String concessionaria_inscricao_estadual, String concessionaria_endereco, String concessionaria_bairro, String concessionaria_endereco_num, String concessionaria_endereco_complemento, String concessionaria_cep, String concessionaria_cidade, String concessionaria_estado, String concessionaria_email, String concessionaria_site) {
        this.concessionaria_id = concessionaria_id;
        this.concessionaria_cnpj = concessionaria_cnpj;
        this.concessionaria_nome = concessionaria_nome;
        this.concessionaria_inscricao_estadual = concessionaria_inscricao_estadual;
        this.concessionaria_endereco = concessionaria_endereco;
        this.concessionaria_bairro = concessionaria_bairro;
        this.concessionaria_endereco_num = concessionaria_endereco_num;
        this.concessionaria_endereco_complemento = concessionaria_endereco_complemento;
        this.concessionaria_cep = concessionaria_cep;
        this.concessionaria_cidade = concessionaria_cidade;
        this.concessionaria_estado = concessionaria_estado;
        this.concessionaria_email = concessionaria_email;
        this.concessionaria_site = concessionaria_site;
    }
    
    int concessionaria_id;
    String concessionaria_cnpj;
    String concessionaria_nome;
    String concessionaria_inscricao_estadual;
    String concessionaria_endereco;
    String concessionaria_bairro;
    String concessionaria_endereco_num;
    String concessionaria_endereco_complemento;
    String concessionaria_cep;
    String concessionaria_cidade;
    String concessionaria_estado;
    String concessionaria_email;
    String concessionaria_site;

    @Override
    public String toString() {
        return getConcessionaria_nome(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
