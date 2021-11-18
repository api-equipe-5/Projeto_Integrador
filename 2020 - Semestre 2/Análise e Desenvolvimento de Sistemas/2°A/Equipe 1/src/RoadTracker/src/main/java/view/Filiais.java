package view;

public class Filiais {
	private int id;
	private String nome;
	private String estado;
	private String cidade;
	
	public Filiais(int id, String nome, String estado) {
		this.nome = nome;	
		this.estado = estado;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	//Método para tratar o conteúdo mostrado na ComboBox
	@Override
	public String toString() {
		return getNome();
	}

}
