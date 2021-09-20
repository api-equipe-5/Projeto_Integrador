package view;

public class Listas {
	
	private String id;
	private String valor;
	
	public Listas(String id, String valor) {
		this.id = id;
		this.valor = valor;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}


	//Método para tratar o conteúdo mostrado na ComboBox
	@Override
	public String toString() {
		return getValor();
	}
	
	
}
