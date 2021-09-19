package view;


public class Funcionarios {
	private String cpf;
	private String nome;
	private String cargo;
	private String email;
	
	public Funcionarios(String cpf, String nome, String cargo, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.cargo = cargo;
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Método para tratar o conteúdo mostrado na ComboBox
	@Override
	public String toString() {
		return getNome();
	}
}
