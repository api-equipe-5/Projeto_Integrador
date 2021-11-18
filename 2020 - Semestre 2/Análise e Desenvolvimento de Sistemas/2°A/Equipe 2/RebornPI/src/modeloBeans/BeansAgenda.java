/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

import java.util.Date;




public class BeansAgenda {

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the agendaCod
     */
    public int getAgendaCod() {
        return agendaCod;
    }

    /**
     * @param agendaCod the agendaCod to set
     */
    public void setAgendaCod(int agendaCod) {
        this.agendaCod = agendaCod;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the nomeVeiculo
     */
    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    /**
     * @param nomeVeiculo the nomeVeiculo to set
     */
    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the endereço
     */
    public String getEndereço() {
        return endereço;
    }

    /**
     * @param endereço the endereço to set
     */
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the carga
     */
    public String getCarga() {
        return carga;
    }

    /**
     * @param carga the carga to set
     */
    public void setCarga(String carga) {
        this.carga = carga;
    }
  
    private int agendaCod;
    private String nomeFuncionario;
    private String nomeVeiculo;
    private String estado;
    private String endereço;
    private Date data;
    private String carga;
    private String obs;
    
    
}


