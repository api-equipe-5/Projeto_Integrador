package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootapp.controller.View;

@Entity
@Table(name = "mensagens")
@SecondaryTable(name = "usr_usuario", pkJoinColumns = @PrimaryKeyJoinColumn(name = "usr_id"))
public class Mensagem {

    @JsonView({View.MensagemResumo.class,View.ConversaResumo.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensagem_id")
    private Long id;

    @JsonView({View.ConversaResumo.class, View.MensagemResumo.class})
    @Column(name = "data_hora")
    private String dataHora;

    @JsonView({View.ConversaResumo.class, View.MensagemResumo.class})
    @Column(name = "conteudo")
    private String conteudo;

    @JsonView({View.MensagemResumo.class})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    private Conversa conversa;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "mensagens")
    private Set<Usuario> usuarios;

    @JsonView(View.MensagemResumo.class)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destinatario")
    private Usuario destinatario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Conversa getConversa() {
        return conversa;
    }

    public void setConversa(Conversa conversa) {
        this.conversa = conversa;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }
    


}
