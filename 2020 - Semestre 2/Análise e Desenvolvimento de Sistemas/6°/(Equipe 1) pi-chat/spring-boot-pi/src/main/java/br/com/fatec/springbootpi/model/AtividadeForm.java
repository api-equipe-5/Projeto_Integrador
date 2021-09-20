package br.com.fatec.springbootpi.model;

import java.util.Date;
import java.util.List;

public class AtividadeForm {
    private String descricaoAtividade, tituloAtividade, corAtividade;
    private Date dataPrevista, dataFechamento;
    private Boolean atividadeAberta;
    private List<Long> idUsuarios;

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public String getTituloAtividade() {
        return tituloAtividade;
    }

    public String getCorAtividade(){
        return corAtividade;
    }

    public List<Long> getIdUsuarios() {
        return idUsuarios;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public void setTituloAtividade(String tituloAtividade) {
        this.tituloAtividade = tituloAtividade;
    }

    public void setCorAtividade(String corAtividade){
        this.corAtividade = corAtividade;
    }

    public void setIdUsuarios(List<Long> idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Boolean getAtividadeAberta() {
        return atividadeAberta;
    }

    public void setAtividadeAberta(Boolean atividadeAberta) {
        this.atividadeAberta = atividadeAberta;
    }

}