public class Empresa {
    public static void main(String[] args){
        Gerente ger1;
        Gerente ger2;

        ger1 = new Gerente(123,"Pedro",1122334455,3600);
        ger2 = new Gerente(123,"Joao",214435655,4300);

        System.out.println("Nome: "+ger1.nome + " " +"CPF: "+ ger1.cpf + " "+ "Senha: " +ger1.getSenha() + " " + "Salario: " +ger1.getSalario());
        System.out.println("Nome: "+ger2.nome + " " +"CPF: "+ ger2.cpf + " "+ "Senha: " +ger2.getSenha() + " " + "Salario: " +ger2.getSalario());

        System.out.println(ger1.autentica(123));
    }
}
