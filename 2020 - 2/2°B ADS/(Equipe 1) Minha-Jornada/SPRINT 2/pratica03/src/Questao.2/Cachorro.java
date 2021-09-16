public class Cachorro extends Animal{
    private String raca;

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Cachorro(String raca,String nome,double peso) {
        super(nome,peso);
        this.raca = raca;
    }
}
