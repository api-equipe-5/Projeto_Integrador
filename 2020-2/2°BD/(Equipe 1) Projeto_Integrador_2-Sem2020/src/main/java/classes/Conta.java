package classes;

import java.math.BigInteger;

public class Conta {

	private BigInteger int_numero_instalacao;
	private String cta_mes_referencia;
    private String cta_vencimento;
    private String cta_usuario;
	
	public BigInteger getInt_numero_instalacao() {
		return int_numero_instalacao;
	}
	public void setInt_numero_instalacao(BigInteger int_numero_instalacao) {
		this.int_numero_instalacao = int_numero_instalacao;
	}
	public String getCta_mes_referencia() {
		return cta_mes_referencia;
	}
	public void setCta_mes_referencia(String cta_mes_referencia) {
		this.cta_mes_referencia = cta_mes_referencia;
	}
	public String getCta_vencimento() {
		return cta_vencimento;
	}
	public void setCta_vencimento(String cta_vencimento) {
		this.cta_vencimento = cta_vencimento;
	}
	public String getCta_usuario() {
		return cta_usuario;
	}
	public void setCta_usuario(String cta_usuario) {
		this.cta_usuario = cta_usuario;
	}
}