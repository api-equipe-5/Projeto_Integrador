package com.iacit.iacit.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="usuarios")
public class Users {
    
    @Id
    private String matricula;

    private String nome;
    
    private String login;
    
    private String senha;
    
    private String telefone;

    private String email;

    private String endereco;

    private String cpf;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "usuario", referencedColumnName = "matricula",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "role", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Roles> roles = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "motorista")
    private Set<Jornadas> jornadas;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Escalas escala;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private Set<Pagamentos> pagamentos;

    

    //gets and sets
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Escalas getEscala() {
        return escala;
    }

    public void setEscala(Escalas escala) {
        this.escala = escala;
    }

    public Set<Jornadas> getJornadas() {
        return jornadas;
    }

    public Set<Pagamentos> getPagamentos() {
        return pagamentos;
    }

    public void setJornadas(Set<Jornadas> jornadas) {
        this.jornadas = jornadas;
    }

    public void setPagamentos(Set<Pagamentos> pagamentos) {
        this.pagamentos = pagamentos;
    }

}
