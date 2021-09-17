public class Peixe extends Animal{
    private String tipoHabitat;

    public String getTipoHabitat() {
        return tipoHabitat;
    }

    public void setTipoHabitat(String tipoHabitat) {
        this.tipoHabitat = tipoHabitat;
    }

    public Peixe(String tipoHabitat,String nome,double peso) {
        super(nome,peso);
        this.tipoHabitat = tipoHabitat;
    }
}
