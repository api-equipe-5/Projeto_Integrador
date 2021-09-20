package easyata.projetoapi.rest.api.controller.dto;

public class TokenDto {

    private String token;
    private String tipo;
    private Long id;
    private String nome;
    private String perfil;

    public TokenDto(String token, String tipo, Long id, String nome, String perfil){
        this.token = token;
        this.tipo = tipo;
        this.id = id;
        this.nome = nome;
        this.perfil = perfil;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}