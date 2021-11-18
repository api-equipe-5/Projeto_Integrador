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
public class RelatDigitador 
{
    private String relat_id;
    private String relat_usuarioId;
    private String relat_contaId;
    private String relat_data;
    private String relat_hora;
    private String relat_funcao;
    private String relat_digitador;
    private String relat_instalacao;
    private String relat_cliente;
    private String relat_tipoConta;
    private String relat_competencia;

    public String getRelat_id() {
        return relat_id;
    }

    public void setRelat_id(String relat_id) {
        this.relat_id = relat_id;
    }

    public String getRelat_usuarioId() {
        return relat_usuarioId;
    }

    public void setRelat_usuarioId(String relat_usuarioId) {
        this.relat_usuarioId = relat_usuarioId;
    }

    public String getRelat_contaId() {
        return relat_contaId;
    }

    public void setRelat_contaId(String relat_contaId) {
        this.relat_contaId = relat_contaId;
    }

    public String getRelat_data() {
        return relat_data;
    }

    public void setRelat_data(String relat_data) {
        this.relat_data = relat_data;
    }

    public String getRelat_hora() {
        return relat_hora;
    }

    public void setRelat_hora(String relat_hora) {
        this.relat_hora = relat_hora;
    }

    public String getRelat_funcao() {
        return relat_funcao;
    }

    public void setRelat_funcao(String relat_funcao) {
        this.relat_funcao = relat_funcao;
    }

    public String getRelat_digitador() {
        return relat_digitador;
    }

    public void setRelat_digitador(String relat_digitador) {
        this.relat_digitador = relat_digitador;
    }

    public String getRelat_instalacao() {
        return relat_instalacao;
    }

    public void setRelat_instalacao(String relat_instalacao) {
        this.relat_instalacao = relat_instalacao;
    }

    public String getRelat_cliente() {
        return relat_cliente;
    }

    public void setRelat_cliente(String relat_cliente) {
        this.relat_cliente = relat_cliente;
    }

    public String getRelat_tipoConta() {
        return relat_tipoConta;
    }

    public void setRelat_tipoConta(String relat_tipoConta) {
        this.relat_tipoConta = relat_tipoConta;
    }

    public String getRelat_competencia() {
        return relat_competencia;
    }

    public void setRelat_competencia(String relat_competencia) {
        this.relat_competencia = relat_competencia;
    }

    public RelatDigitador(String relat_id, String relat_usuarioId, String relat_cliente, String relat_instalacao,  String relat_tipoConta, String relat_data, String relat_hora, String relat_contaId, String relat_funcao, String relat_digitador,  String relat_competencia) 
    {
        this.relat_id = relat_id;
        this.relat_usuarioId = relat_usuarioId;
        this.relat_contaId = relat_contaId;
        this.relat_data = relat_data;
        this.relat_hora = relat_hora;
        this.relat_funcao = relat_funcao;
        this.relat_digitador = relat_digitador;
        this.relat_instalacao = relat_instalacao;
        this.relat_cliente = relat_cliente;
        this.relat_tipoConta = relat_tipoConta;
        this.relat_competencia = relat_competencia;
    }

    
}
