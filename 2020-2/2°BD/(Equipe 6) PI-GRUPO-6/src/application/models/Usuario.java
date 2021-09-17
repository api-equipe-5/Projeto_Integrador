package application.models;

public class Usuario {

	public int id_user;
	public String nome_user;
	public String cpf_user;
	public String login_user;
	public String senha_user;
	public String tipo_user;
	public String telefone_user;
	
	public Usuario(int id_user, String nome_user, String cpf_user, String login_user, String senha_user,
			String tipo_user, String telefone_user) {
		this.id_user = id_user;
		this.nome_user = nome_user;
		this.cpf_user = cpf_user;
		this.login_user = login_user;
		this.senha_user = senha_user;
		this.tipo_user = tipo_user;
		this.telefone_user = telefone_user;
	}
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNome_user() {
		return nome_user;
	}

	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}

	public String getCpf_user() {
		return cpf_user;
	}

	public void setCpf_user(String cpf_user) {
		this.cpf_user = cpf_user;
	}

	public String getLogin_user() {
		return login_user;
	}

	public void setLogin_user(String login_user) {
		this.login_user = login_user;
	}

	public String getSenha_user() {
		return senha_user;
	}

	public void setSenha_user(String senha_user) {
		this.senha_user = senha_user;
	}

	public String getTipo_user() {
		return tipo_user;
	}

	public void setTipo_user(String tipo_user) {
		this.tipo_user = tipo_user;
	}
	
	public String getTelefone_user() {
		return telefone_user;
	}

	public void setTelefone_user(String telefone_user) {
		this.telefone_user = telefone_user;
	}
}