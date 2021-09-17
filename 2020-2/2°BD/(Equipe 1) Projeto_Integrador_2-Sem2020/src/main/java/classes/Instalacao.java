package classes;

import java.math.BigInteger;

public class Instalacao {

	private BigInteger int_numero_instalacao;
	private String cli_nome;
	private BigInteger cli_documento;
	private String for_nome;
	private BigInteger for_cnpj;
	private BigInteger cep_cep;
	private String cep_rua;
    private BigInteger end_numero;
    
	public BigInteger getInt_numero_instalacao() {
		return int_numero_instalacao;
	}
	public void setInt_numero_instalacao(BigInteger int_numero_instalacao) {
		this.int_numero_instalacao = int_numero_instalacao;
	}
	public String getCli_nome() {
		return cli_nome;
	}
	public void setCli_nome(String cli_nome) {
		this.cli_nome = cli_nome;
	}
	public BigInteger getCli_documento() {
		return cli_documento;
	}
	public void setCli_documento(BigInteger cli_documento) {
		this.cli_documento = cli_documento;
	}
	public String getFor_nome() {
		return for_nome;
	}
	public void setFor_nome(String for_nome) {
		this.for_nome = for_nome;
	}
	public BigInteger getFor_cnpj() {
		return for_cnpj;
	}
	public void setFor_cnpj(BigInteger for_cnpj) {
		this.for_cnpj = for_cnpj;
	}
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
	public BigInteger getEnd_numero() {
		return end_numero;
	}
	public void setEnd_numero(BigInteger end_numero) {
		this.end_numero = end_numero;
	}	
	
}