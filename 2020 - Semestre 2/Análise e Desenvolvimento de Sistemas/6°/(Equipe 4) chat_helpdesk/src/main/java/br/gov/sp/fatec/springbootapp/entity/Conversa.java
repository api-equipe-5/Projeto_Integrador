package br.gov.sp.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootapp.controller.View;

@Entity
@Table(name = "conversas")
public class Conversa {

    @JsonView({View.ConversaResumo.class,View.MensagemResumo.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @JsonView(View.ConversaResumo.class)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "conversas")
    private Set<Usuario> usuarios;

    @JsonView(View.ConversaResumo.class)
    @OneToMany(mappedBy="conversa", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Mensagem> mensagens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Set<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    
}