public class Animal {
    protected String nome;
    protected double peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Animal(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }
}
