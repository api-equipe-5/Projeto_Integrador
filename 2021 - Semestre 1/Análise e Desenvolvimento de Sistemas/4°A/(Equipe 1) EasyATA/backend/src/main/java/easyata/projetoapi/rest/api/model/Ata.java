package easyata.projetoapi.rest.api.model;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "dados_ata")
@Entity
public class Ata implements Serializable {
    //Cabeçalho
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, length = 50)
    public String data_inicio;

    @Column(nullable = false, length = 50)
    public String data_fim;

    @Column(nullable = false, length = 50)
    public String hora_inicio;

    @Column(nullable = false, length = 50)
    public String hora_fim;

    @Column(nullable = false, length = 200)
    public String local;

    //Corpo

    @Column(nullable = false, length = 1000)
    public String tema;

    @Column(nullable = false, length = 100)
    public String pauta;

    //corpo2
    @Column(nullable = false, length = 1000)
    public String participante;

    @Column(nullable = false, length = 1000)
    public String area;

    @Column(nullable = false, length = 1000)
    public String email;

    @Column(nullable = false, length = 1000)
    public String telefone;

    @Column(nullable = false, length = 1000)
    public String assunto;

    @Column(nullable = false, length = 1000)
    public String responsavel;

    @Column(nullable = false, length = 500)
    public String prazo;

    @Column(nullable = false, length = 500)
    public String distribuicao;

    @Column(nullable = false, length = 1000)
    public String assinatura;

    @Column(nullable = false, length = 1000)
    public String nome;

    @Column(nullable = false, length = 1000)
    public String representante;

    @Column(nullable = false, length = 60)
    @Check(constraints = "CHECK (estado IN ('Pendente','Aprovado','Reprovado'))")
    public String estado = "Pendente";

    //get & set

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getData_inicio() { return data_inicio; }

    public void setData_inicio(String data_inicio) { this.data_inicio = data_inicio; }

    public String getData_fim() { return data_fim; }

    public void setData_fim(String data_fim) { this.data_fim = data_fim; }

    public String getHora_inicio() { return hora_inicio;}

    public void setHora_inicio(String hora_inicio) { this.hora_inicio = hora_inicio; }

    public String getHora_fim() { return hora_fim; }

    public void setHora_fim(String hora_fim) { this.hora_fim = hora_fim; }

    public String getLocal() { return local; }

    public void setLocal(String local) { this.local = local; }

    public String getTema() { return tema; }

    public void setTema(String tema) { this.tema = tema; }

    public String getParticipante() { return participante; }

    public void setParticipante(String participante) { this.participante = participante; }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPauta() { return pauta; }

    public void setPauta(String pauta) { this.pauta = pauta; }

    public String getAssunto() { return assunto; }

    public void setAssunto(String assunto) { this.assunto = assunto; }

    public String getResponsavel() { return responsavel; }

    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    public String getPrazo() { return prazo; }

    public void setPrazo(String prazo) { this.prazo = prazo; }

    public String getDistribuicao() { return distribuicao; }

    public void setDistribuicao(String distribuicao) { this.distribuicao = distribuicao; }

    public String getAssinatura() { return assinatura; }

    public void setAssinatura(String assinatura) { this.assinatura = assinatura; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getRepresentante() { return representante; }

    public void setRepresentante(String representante) { this.representante = representante; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }


}