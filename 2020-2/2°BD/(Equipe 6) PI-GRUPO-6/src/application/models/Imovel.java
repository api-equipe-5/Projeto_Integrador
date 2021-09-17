package application.models;

public class Imovel {
	
	public int idImovel;
	public int idCliente;
	public String tipoImovel;
	public int identificacaoImovel;
	public String ufImovel;
	public String cidadeImovel;
	public String bairroImovel;
	public String ruaImovel;
	public String numImovel;
	public String complementoImovel;
	public String cepImovel;
	
	public Imovel() {}
	
	public Imovel(int idImovel, int idCliente, String tipoImovel, int identificacaoImovel, 
			String ufImovel, String cidadeImovel, String bairroImovel,
			String ruaImovel, String numImovel, String complementoImovel, String cepImovel) {
		this.idImovel = idImovel;
		this.idCliente = idCliente;
		this.tipoImovel = tipoImovel;
		this.identificacaoImovel = identificacaoImovel;
		this.ufImovel = ufImovel;
		this.cidadeImovel = cidadeImovel;
		this.bairroImovel = bairroImovel;
		this.ruaImovel = ruaImovel;
		this.numImovel = numImovel;
		this.complementoImovel = complementoImovel;
		this.cepImovel = cepImovel;
		
	}

	public int getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(int idImovel) {
		this.idImovel = idImovel;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}
	
	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public String getUfImovel() {
		return ufImovel;
	}

	public void setUfImovel(String ufImovel) {
		this.ufImovel = ufImovel;
	}

	public String getCidadeImovel() {
		return cidadeImovel;
	}

	public void setCidadeImovel(String cidadeImovel) {
		this.cidadeImovel = cidadeImovel;
	}

	public String getBairroImovel() {
		return bairroImovel;
	}

	public void setBairroImovel(String bairroImovel) {
		this.bairroImovel = bairroImovel;
	}

	public String getRuaImovel() {
		return ruaImovel;
	}

	public void setRuaImovel(String ruaImovel) {
		this.ruaImovel = ruaImovel;
	}

	public String getNumImovel() {
		return numImovel;
	}

	public void setNumImovel(String numImovel) {
		this.numImovel = numImovel;
	}

	public String getComplementoImovel() {
		return complementoImovel;
	}

	public void setComplementoImovel(String complementoImovel) {
		this.complementoImovel = complementoImovel;
	}

	public String getCepImovel() {
		return cepImovel;
	}

	public void setCepImovel(String cepImovel) {
		this.cepImovel = cepImovel;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdentificacaoImovel() {
		return identificacaoImovel;
	}

	public void setIdentificacaoImovel(int identificacaoImovel) {
		this.identificacaoImovel = identificacaoImovel;
	}
	

}
