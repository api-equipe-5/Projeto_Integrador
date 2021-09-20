package application.models;

public class Cliente {

	public int id_cli;
	public String nome_cli;
	public String cpf_cnpj_cli;
	public String rua_cli;
	public int numero_cli;
	public String complemento_cli;
	public String bairro_cli;
	public String cidade_cli;
	public String estado_cli;
	public String cep_cli;
	public String telefone_cli;
	
	public Cliente() {}
	
	public Cliente(int id_cli, String nome_cli, String cpf_cnpj_cli, String rua_cli, int numero_cli,
			String complemento_cli, String bairro_cli, String cidade_cli, String estado_cli, String cep_cli,
			String telefone_cli) {
		this.id_cli = id_cli;
		this.nome_cli = nome_cli;
		this.cpf_cnpj_cli = cpf_cnpj_cli;
		this.rua_cli = rua_cli;
		this.numero_cli = numero_cli;
		this.complemento_cli = complemento_cli;
		this.bairro_cli = bairro_cli;
		this.cidade_cli = cidade_cli;
		this.estado_cli = estado_cli;
		this.cep_cli = cep_cli;
		this.telefone_cli = telefone_cli;
	}

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public String getNome_cli() {
		return nome_cli;
	}

	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
	}

	public String getCpf_cnpj_cli() {
		return cpf_cnpj_cli;
	}

	public void setCpf_cnpj_cli(String cpf_cnpj_cli) {
		this.cpf_cnpj_cli = cpf_cnpj_cli;
	}

	public String getRua_cli() {
		return rua_cli;
	}

	public void setRua_cli(String rua_cli) {
		this.rua_cli = rua_cli;
	}

	public int getNumero_cli() {
		return numero_cli;
	}

	public void setNumero_cli(int numero_cli) {
		this.numero_cli = numero_cli;
	}

	public String getComplemento_cli() {
		return complemento_cli;
	}

	public void setComplemento_cli(String complemento_cli) {
		this.complemento_cli = complemento_cli;
	}

	public String getBairro_cli() {
		return bairro_cli;
	}

	public void setBairro_cli(String bairro_cli) {
		this.bairro_cli = bairro_cli;
	}

	public String getCidade_cli() {
		return cidade_cli;
	}

	public void setCidade_cli(String cidade_cli) {
		this.cidade_cli = cidade_cli;
	}

	public String getEstado_cli() {
		return estado_cli;
	}

	public void setEstado_cli(String estado_cli) {
		this.estado_cli = estado_cli;
	}

	public String getCep_cli() {
		return cep_cli;
	}

	public void setCep_cli(String cep_cli) {
		this.cep_cli = cep_cli;
	}

	public String getTelefone_cli() {
		return telefone_cli;
	}

	public void setTelefone_cli(String telefone_cli) {
		this.telefone_cli = telefone_cli;
	}
	
	
	
}
