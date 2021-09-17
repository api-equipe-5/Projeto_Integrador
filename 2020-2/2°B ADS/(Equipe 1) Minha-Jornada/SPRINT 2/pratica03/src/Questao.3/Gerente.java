public class Gerente extends Funcionario{
    private int senha;

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public Gerente(int senha,String nome,int cpf, double salario) {
        super(nome,cpf,salario);
        this.senha = senha;
    }

    public boolean autentica(int s){
        return getSenha() == s;
    }
}
