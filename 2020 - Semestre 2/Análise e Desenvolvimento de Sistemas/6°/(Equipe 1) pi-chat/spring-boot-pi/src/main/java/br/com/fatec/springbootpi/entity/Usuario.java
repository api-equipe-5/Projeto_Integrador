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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.fatec.springbootpi.controller.View;

@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @JsonView(View.UsuarioResumo.class)
    private Long idUsuario;

    @JsonView({View.UsuarioResumo.class, 
               View.MensagemResumo.class, 
               View.AtividadeResumo.class, 
               View.ArquivoResumo.class,
               View.ConversaResumo.class})
    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @JsonView(View.UsuarioResumo.class)
    @Column(name = "cpf_usuario")
    private String cpfUsuario;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
    private Set<Conversa> conversas;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
    private Set<Arquivo> arquivos;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
    private Set<Atividade> atividades;

    @JsonView(View.UsuarioResumo.class)
    @ManyToOne
    @JoinColumn(name="id_tipo_usuario")
    private TipoUsuario tiposUsuarios;

    @Column(name = "data_criado")
    private Date dataCriado;

    @Column(name = "senha")
    private String senha;

    public Long getIdUsuario() {
        return idUsuario;
    }
    
    public String getCpfUsuario() {
         return cpfUsuario;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public TipoUsuario getTiposUsuarios() {
        return tiposUsuarios;
    }

    public Set<Conversa> getConversas() {
        return conversas;
    }

    public Set<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setTiposUsuarios(TipoUsuario tiposUsuarios) {
        this.tiposUsuarios = tiposUsuarios;
    }

    public void setConversas(Set<Conversa> conversas) {
        this.conversas = conversas;
    }

    public void setArquivos(Set<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }


}