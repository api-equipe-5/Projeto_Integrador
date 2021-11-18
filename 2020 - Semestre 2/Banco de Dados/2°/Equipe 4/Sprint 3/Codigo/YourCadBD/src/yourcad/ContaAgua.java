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
public class ContaAgua {
    
        private int conta_aguaId;
        private String instalacaoApelido;
        private String cliente_id;
        private String instalacao_numero;
        private String conta_competencia;
        private String conta_vencimento;
        private String conta_dataProximaLeitura;
        private String conta_dataLeituraAtual;
        private String conta_valorAtual;
        private String conta_valorAgua;
        private String conta_valorEsgoto;
        private String conta_trcf;
        private String conta_multa;
        private String conta_basePis;
        private String conta_aliquota;

    public int getConta_aguaId() {
        return conta_aguaId;
    }

    public void setConta_aguaId(int conta_aguaId) {
        this.conta_aguaId = conta_aguaId;
    }

    public String getInstalacaoApelido() {
        return instalacaoApelido;
    }

    public void setInstalacaoApelido(String instalacao_id) {
        this.instalacaoApelido = instalacaoApelido;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getInstalacao_numero() {
        return instalacao_numero;
    }

    public void setInstalacao_numero(String instalacao_numero) {
        this.instalacao_numero = instalacao_numero;
    }

    public String getConta_competencia() {
        return conta_competencia;
    }

    public void setConta_competencia(String conta_competencia) {
        this.conta_competencia = conta_competencia;
    }

    public String getConta_vencimento() {
        return conta_vencimento;
    }

    public void setConta_vencimento(String conta_vencimento) {
        this.conta_vencimento = conta_vencimento;
    }

    public String getConta_dataProximaLeitura() {
        return conta_dataProximaLeitura;
    }

    public void setConta_dataProximaLeitura(String conta_dataProximaLeitura) {
        this.conta_dataProximaLeitura = conta_dataProximaLeitura;
    }

    public String getConta_dataLeituraAtual() {
        return conta_dataLeituraAtual;
    }

    public void setConta_dataLeituraAtual(String conta_dataLeituraAtual) {
        this.conta_dataLeituraAtual = conta_dataLeituraAtual;
    }

    public String getConta_valorAtual() {
        return conta_valorAtual;
    }

    public void setConta_valorAtual(String conta_valorAtual) {
        this.conta_valorAtual = conta_valorAtual;
    }

    public String getConta_valorAgua() {
        return conta_valorAgua;
    }

    public void setConta_valorAgua(String conta_valorAgua) {
        this.conta_valorAgua = conta_valorAgua;
    }

    public String getConta_valorEsgoto() {
        return conta_valorEsgoto;
    }

    public void setConta_valorEsgoto(String conta_valorEsgoto) {
        this.conta_valorEsgoto = conta_valorEsgoto;
    }

    public String getConta_trcf() {
        return conta_trcf;
    }

    public void setConta_trcf(String conta_trcf) {
        this.conta_trcf = conta_trcf;
    }

    public String getConta_multa() {
        return conta_multa;
    }

    public void setConta_multa(String conta_multa) {
        this.conta_multa = conta_multa;
    }

    public String getConta_basePis() {
        return conta_basePis;
    }

    public void setConta_basePis(String conta_basePis) {
        this.conta_basePis = conta_basePis;
    }

    public String getConta_aliquota() {
        return conta_aliquota;
    }

    public void setConta_aliquota(String conta_aliquota) {
        this.conta_aliquota = conta_aliquota;
    }

    public ContaAgua(int conta_aguaId, String instalacao_numero, String instalacaoApelido,  String cliente_id,  String conta_valorAtual, String conta_competencia) {
        this.conta_aguaId = conta_aguaId;
        this.instalacaoApelido = instalacaoApelido;
        this.cliente_id = cliente_id;
        this.instalacao_numero = instalacao_numero;
        this.conta_competencia = conta_competencia;
        this.conta_valorAtual = conta_valorAtual;
    }
    

    
}
