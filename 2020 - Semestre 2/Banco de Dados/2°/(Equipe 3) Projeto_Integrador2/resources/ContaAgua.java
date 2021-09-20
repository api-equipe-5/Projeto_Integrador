/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;

public class ContaAgua {
    
    private String rgi;
    private String nome;
    private String conta;
    private String mes;
    private String consumo;
    private String total;
    private String vencimento;
    
    public ContaAgua(String rgi, String nome, String conta, String mes, String consumo, String total, String vencimento) {
        
        this.rgi = rgi;
        this.nome = nome;
        this.conta = conta;
        this.mes = mes;
        this.consumo = consumo;
        this.total = total;
        this.vencimento = vencimento;
        
    }

    public String getRgi() {
        return rgi;
    }

    public String getNome() {
        return nome;
    }

    public String getConta() {
        return conta;
    }

    public String getMes() {
        return mes;
    }

    public String getConsumo() {
        return consumo;
    }

    public String getTotal() {
        return total;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setRgi(String rgi) {
        this.rgi = rgi;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public String toString() {
        return "RGI=" + rgi + ",NOME=" + nome + ",NUMERO DA CONTA=" + conta + ",MES DE REFERENCIA=" + mes + ",CONSUMO=" + consumo + ",TOTAL=" + total + ",VENCIMENTO=" + vencimento + '\n';
    }
    
    
    
    
}
