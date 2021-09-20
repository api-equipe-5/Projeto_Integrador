public class Funcionário extends Pessoa{
    private double salario;

    public Funcionário(String RG, String nome) {
        super(RG, nome);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double aumentar_salario(double d){
        return this.salario + (d * this.salario);
    }
}
