package br.com.fatec.springbootpi.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.fatec.springbootpi.controller.View;

@Entity
@Table(name = "conversa")
public class Conversa {

    public Conversa() {
        super();
        Date x = new Date();
        this.setDataInicial(x);
        this.setDataUltimaConversa(x);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conversa")
    @JsonView(View.ConversaResumo.class)
    private Long idConversa;

    @JsonView(View.ConversaResumo.class)
    @Column(name = "data_inicio")
    private Date dataInicial;

    @Column(name = "data_ultima_conversa")
    private Date dataUltimaConversa;

    @JsonView(View.ConversaResumo.class)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_conversa",
    joinColumns = { @JoinColumn(name = "id_conversa") },
    inverseJoinColumns = { @JoinColumn(name = "id_usuario") })
    private Set<Usuario> usuarios;

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataUltimaConversa(Date dataUltimaConversa) {
        this.dataUltimaConversa = dataUltimaConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Date getDataInicial() {
        return dataInicial;
    }
    
    public Date getDataUltimaConversa() {
        return dataUltimaConversa;
    }
    
    public Long getIdConversa() {
        return idConversa;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
}