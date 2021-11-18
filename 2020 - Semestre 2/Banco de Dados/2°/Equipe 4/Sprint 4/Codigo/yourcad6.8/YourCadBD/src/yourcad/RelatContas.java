/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

import javafx.fxml.FXML;

/**
 *
 * @author info-chefe
 */
public class RelatContas 
{
    private int Relat_Id;
    private String Relat_clienteNome;
    private String Relat_instalacao;
    private String Relat_apelido;
    private String Relat_nConta;
    private String Relat_competencia;
    private String Relat_Valor;

    public int getRelat_Id() {
        return Relat_Id;
    }

    public void setRelat_Id(int Relat_Id) {
        this.Relat_Id = Relat_Id;
    }

    public String getRelat_clienteNome() {
        return Relat_clienteNome;
    }

    public void setRelat_clienteNome(String Relat_clienteNome) {
        this.Relat_clienteNome = Relat_clienteNome;
    }

    public String getRelat_instalacao() {
        return Relat_instalacao;
    }

    public void setRelat_instalacao(String Relat_instalacao) {
        this.Relat_instalacao = Relat_instalacao;
    }

    public String getRelat_apelido() {
        return Relat_apelido;
    }

    public void setRelat_apelido(String Relat_apelido) {
        this.Relat_apelido = Relat_apelido;
    }

    public String getRelat_nConta() {
        return Relat_nConta;
    }

    public void setRelat_nConta(String Relat_nConta) {
        this.Relat_nConta = Relat_nConta;
    }

    public String getRelat_competencia() {
        return Relat_competencia;
    }

    public void setRelat_competencia(String Relat_competencia) {
        this.Relat_competencia = Relat_competencia;
    }

    public String getRelat_Valor() {
        return Relat_Valor;
    }

    public void setRelat_Valor(String Relat_Valor) {
        this.Relat_Valor = Relat_Valor;
    }

    public RelatContas(int Relat_Id, String Relat_clienteNome, String Relat_instalacao, String Relat_apelido, String Relat_nConta, String Relat_competencia, String Relat_Valor) {
        this.Relat_Id = Relat_Id;
        this.Relat_clienteNome = Relat_clienteNome;
        this.Relat_instalacao = Relat_instalacao;
        this.Relat_apelido = Relat_apelido;
        this.Relat_nConta = Relat_nConta;
        this.Relat_competencia = Relat_competencia;
        this.Relat_Valor = Relat_Valor;
    }
   
    
    
}
