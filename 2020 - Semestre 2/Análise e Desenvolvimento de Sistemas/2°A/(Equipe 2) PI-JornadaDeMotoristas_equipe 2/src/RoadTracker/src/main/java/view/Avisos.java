package view;


public class Avisos {
	
	private String tituloAviso;
	private String motorista;
	private String dataAviso;
	private int id;
	
	public String getTituloAviso() {
		return tituloAviso;
	}

	public void setTituloAviso(String tituloAviso) {
		this.tituloAviso = tituloAviso;
	}
	
	public String getDataAviso() {
		return dataAviso;
	}

	public void setDataAviso(String dataAviso) {
		this.dataAviso = dataAviso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String string) {
		this.motorista = string;
	}
}
