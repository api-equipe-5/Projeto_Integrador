package view;

public class Veiculos {
	private int id_rastreador;
	private String placa;
	

		
	public Veiculos(int id_rastreador, String placa) {
		this.id_rastreador = id_rastreador;
		this.placa = placa;
	}




	public int getId_rastreador() {
		return id_rastreador;
	}
	public void setId_rastreador(int id_rastreador) {
		this.id_rastreador = id_rastreador;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}




	//Método para tratar o conteúdo mostrado na ComboBox
	@Override
	public String toString() {
		return getPlaca();
	}
}
