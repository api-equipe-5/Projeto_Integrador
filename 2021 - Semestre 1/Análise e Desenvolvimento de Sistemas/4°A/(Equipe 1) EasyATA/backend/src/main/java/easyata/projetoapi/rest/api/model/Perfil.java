package easyata.projetoapi.rest.api.model;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="perfil")
public class Perfil implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String perfil = "Usuario";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return perfil;
    }

    public void setNome(String nome) {
        this.perfil = nome;
    }

    @Override
    public String getAuthority() {
        return perfil;
    }

}
