public class Pessoa {
    protected String RG;
    protected String nome;

    public Pessoa(String RG, String nome) {
        this.RG = RG;
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
