package view;

public class Estados {
	private String estado;
	
	public Estados(String estado) {
		this.estado = estado;
	}

	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return getEstado();
	}
}
