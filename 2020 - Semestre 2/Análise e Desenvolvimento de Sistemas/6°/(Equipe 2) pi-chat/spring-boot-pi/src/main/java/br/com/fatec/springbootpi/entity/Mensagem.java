package br.com.fatec.springbootpi.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.fatec.springbootpi.controller.View;

@Entity
@Table(name = "mensagem")
public class Mensagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensagem")
    @JsonView(View.MensagemResumo.class)
    private Long idMensagem;

    @JsonView(View.MensagemResumo.class)
    @Column(name = "conteudo_mensagem")
    private String conteudoMsg;
    
    @JsonView(View.MensagemResumo.class)
    @Column(name = "data_criado")
    private Date dataCriado;

    @JsonView(View.MensagemResumo.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuarios;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_conversa")
    private Conversa conversas;

    public Mensagem () {
        this.dataCriado = new Date();
    }

    public String getConteudoMsg() {
        return conteudoMsg;
    }

    public Conversa getConversas() {
        return conversas;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public Long getIdMensagem() {
        return idMensagem;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setConteudoMsg(String conteudoMsg) {
        this.conteudoMsg = conteudoMsg;
    }

    public void setConversas(Conversa conversas) {
        this.conversas = conversas;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }

    public void setIdMensagem(Long idMensagem) {
        this.idMensagem = idMensagem;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }
}