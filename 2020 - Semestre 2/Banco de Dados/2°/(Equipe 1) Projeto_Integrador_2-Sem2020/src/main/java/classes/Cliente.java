package classes;

import java.math.BigInteger;

public class Cliente {
	
	private BigInteger cli_documento;
	private String cli_nome;
	private String cli_email;
	
	public BigInteger getCli_documento() {
		return cli_documento;
	}
	public void setCli_documento(BigInteger cli_documento) {
		this.cli_documento = cli_documento;
	}
	public String getCli_nome() {
		return cli_nome;
	}
	public void setCli_nome(String cli_nome) {
		this.cli_nome = cli_nome;
	}
	public String getCli_email() {
		return cli_email;
	}
	public void setEmail(String cli_email) {
		this.cli_email = cli_email;
	}
}