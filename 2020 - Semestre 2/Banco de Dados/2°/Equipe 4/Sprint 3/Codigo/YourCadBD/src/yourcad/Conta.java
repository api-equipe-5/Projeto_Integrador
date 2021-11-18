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
public class Conta {

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }

    public String getInstalacaoId() {
        return instalacaoId;
    }

    public void setInstalacaoId(String instalacaoId) {
        this.instalacaoId = instalacaoId;
    }

    public String getContaNumeroInstalacao() {
        return contaNumeroInstalacao;
    }

    public void setContaNumeroInstalacao(String contaNumeroInstalacao) {
        this.contaNumeroInstalacao = contaNumeroInstalacao;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Conta(int contaId, String instalacaoId, String contaNumeroInstalacao, String tipoConta) {
        this.contaId = contaId;
        this.instalacaoId = instalacaoId;
        this.contaNumeroInstalacao = contaNumeroInstalacao;
        this.tipoConta = tipoConta;
    }
    int contaId;
    String instalacaoId;
    String contaNumeroInstalacao;
    String tipoConta;
}
