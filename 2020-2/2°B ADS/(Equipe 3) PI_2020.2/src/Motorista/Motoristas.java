package br.com.cliente.bean;

public class Motoristas {
    private Integer id;
    private String nome;
    private String endereco;
    private String municipio;
    private String estado;
    private String cep;
    private String tel;
    private String cpf;
    private String email;
    private String genero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {

        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {

        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {

        this.cep = cep;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {

        this.tel = tel;
    }

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {

        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Motoristas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", municipio='" + municipio + '\'' +
                ", cep='" + cep + '\'' +
                ", tel='" + tel + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
