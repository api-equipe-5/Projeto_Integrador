package classes;

import java.math.BigInteger;

public class Endereco {
	
	private BigInteger cep_cep;
	private BigInteger end_numero;
	private String end_complemento;
	
	public BigInteger getCep_cep() {
		return cep_cep;
	}
	public void setCep_cep(BigInteger cep_cep) {
		this.cep_cep = cep_cep;
	}
	public BigInteger getEnd_numero() {
		return end_numero;
	}
	public void setEnd_numero(BigInteger end_numero) {
		this.end_numero = end_numero;
	}
	public String getEnd_complemento() {
		return end_complemento;
	}
	public void setEnd_complemento(String end_complemento) {
		this.end_complemento = end_complemento;
	}
}