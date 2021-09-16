package classes;

import java.math.BigInteger;

public class Cep {
    private BigInteger cep_cep;
	private String cep_rua;
	private String cep_estado;
	private String cep_cidade;
	
	public BigInteger getCep_cep() {
		return cep_cep;
	}
	public void setCep_cep(BigInteger cep_cep) {
		this.cep_cep = cep_cep;
	}
	public String getCep_rua() {
		return cep_rua;
	}
	public void setCep_rua(String cep_rua) {
		this.cep_rua = cep_rua;
	}
	public String getCep_estado() {
		return cep_estado;
	}
	public void setCep_estado(String cep_estado) {
		this.cep_estado = cep_estado;
	}
	public String getCep_cidade() {
		return cep_cidade;
	}
	public void setCep_cidade(String cep_cidade) {
		this.cep_cidade = cep_cidade;
	}
    
}