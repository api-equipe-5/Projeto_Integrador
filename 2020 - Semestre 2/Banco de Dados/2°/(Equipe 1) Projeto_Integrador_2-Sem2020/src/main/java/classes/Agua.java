package classes;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Agua {
	
	private BigInteger int_numero_instalacao;
	private String cta_mes_referencia;
	private BigInteger agu_gr;
	private BigInteger agu_codigo_cliente;
	private BigInteger agu_numero_conta;
	private String agu_tipo_ligacao;
	private String agu_hidrometro;
	private String agu_data_leitura_anterior;
	private String agu_data_leitura_atual;
	private BigInteger agu_leitura_anterior;
	private BigInteger agu_leitura_atual;
	private BigInteger agu_consumo;
	private BigDecimal agu_valor_agua;
	private BigDecimal agu_valor_esgoto;
	private BigDecimal agu_taxa_regulamentacao;
	private BigDecimal agu_multa;
	private BigDecimal agu_tarifa_ate10_agua;
	private BigDecimal agu_tarifa_ate20_agua;
	private BigDecimal agu_tarifa_ate30_agua;
	private BigDecimal agu_tarifa_ate50_agua;
	private BigDecimal agu_tarifa_acima50_agua;
	private BigDecimal agu_tarifa_ate10_esgoto;
	private BigDecimal agu_tarifa_ate20_esgoto;
	private BigDecimal agu_tarifa_ate30_esgoto;
	private BigDecimal agu_tarifa_ate50_esgoto;
	private BigDecimal agu_tarifa_acima50_esgoto;
	private BigDecimal agu_valor_agua1;
	private BigDecimal agu_valor_agua2;
	private BigDecimal agu_valor_esgoto1;
	private BigDecimal agu_valor_esgoto2;
	
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
	public BigInteger getAgu_gr() {
		return agu_gr;
	}
	public void setAgu_gr(BigInteger agu_gr) {
		this.agu_gr = agu_gr;
	}
	public BigInteger getAgu_codigo_cliente() {
		return agu_codigo_cliente;
	}
	public void setAgu_codigo_cliente(BigInteger agu_codigo_cliente) {
		this.agu_codigo_cliente = agu_codigo_cliente;
	}
	public BigInteger getAgu_numero_conta() {
		return agu_numero_conta;
	}
	public void setAgu_numero_conta(BigInteger agu_numero_conta) {
		this.agu_numero_conta = agu_numero_conta;
	}
	public String getAgu_tipo_ligacao() {
		return agu_tipo_ligacao;
	}
	public void setAgu_tipo_ligacao(String agu_tipo_ligacao) {
		this.agu_tipo_ligacao = agu_tipo_ligacao;
	}
	public String getAgu_hidrometro() {
		return agu_hidrometro;
	}
	public void setAgu_hidrometro(String agu_hidrometro) {
		this.agu_hidrometro = agu_hidrometro;
	}
	public String getAgu_data_leitura_anterior() {
		return agu_data_leitura_anterior;
	}
	public void setAgu_data_leitura_anterior(String agu_data_leitura_anterior) {
		this.agu_data_leitura_anterior = agu_data_leitura_anterior;
	}
	public String getAgu_data_leitura_atual() {
		return agu_data_leitura_atual;
	}
	public void setAgu_data_leitura_atual(String agu_data_leitura_atual) {
		this.agu_data_leitura_atual = agu_data_leitura_atual;
	}
	public BigInteger getAgu_leitura_anterior() {
		return agu_leitura_anterior;
	}
	public void setAgu_leitura_anterior(BigInteger agu_leitura_anterior) {
		this.agu_leitura_anterior = agu_leitura_anterior;
	}
	public BigInteger getAgu_leitura_atual() {
		return agu_leitura_atual;
	}
	public void setAgu_leitura_atual(BigInteger agu_leitura_atual) {
		this.agu_leitura_atual = agu_leitura_atual;
	}
	public BigInteger getAgu_consumo() {
		return agu_consumo;
	}
	public void setAgu_consumo(BigInteger agu_consumo) {
		this.agu_consumo = agu_consumo;
	}
	public BigDecimal getAgu_valor_agua() {
		return agu_valor_agua;
	}
	public void setAgu_valor_agua(BigDecimal agu_valor_agua) {
		this.agu_valor_agua = agu_valor_agua;
	}
	public BigDecimal getAgu_valor_esgoto() {
		return agu_valor_esgoto;
	}
	public void setAgu_valor_esgoto(BigDecimal agu_valor_esgoto) {
		this.agu_valor_esgoto = agu_valor_esgoto;
	}
	public BigDecimal getAgu_taxa_regulamentacao() {
		return agu_taxa_regulamentacao;
	}
	public void setAgu_taxa_regulamentacao(BigDecimal agu_taxa_regulamentacao) {
		this.agu_taxa_regulamentacao = agu_taxa_regulamentacao;
	}
	public BigDecimal getAgu_multa() {
		return agu_multa;
	}
	public void setAgu_multa(BigDecimal agu_multa) {
		this.agu_multa = agu_multa;
	}
	public BigDecimal getAgu_tarifa_ate10_agua() {
		return agu_tarifa_ate10_agua;
	}
	public void setAgu_tarifa_ate10_agua(BigDecimal agu_tarifa_ate10_agua) {
		this.agu_tarifa_ate10_agua = agu_tarifa_ate10_agua;
	}
	public BigDecimal getAgu_tarifa_ate20_agua() {
		return agu_tarifa_ate20_agua;
	}
	public void setAgu_tarifa_ate20_agua(BigDecimal agu_tarifa_ate20_agua) {
		this.agu_tarifa_ate20_agua = agu_tarifa_ate20_agua;
	}
	public BigDecimal getAgu_tarifa_ate30_agua() {
		return agu_tarifa_ate30_agua;
	}
	public void setAgu_tarifa_ate30_agua(BigDecimal agu_tarifa_ate30_agua) {
		this.agu_tarifa_ate30_agua = agu_tarifa_ate30_agua;
	}
	public BigDecimal getAgu_tarifa_ate50_agua() {
		return agu_tarifa_ate50_agua;
	}
	public void setAgu_tarifa_ate50_agua(BigDecimal agu_tarifa_ate50_agua) {
		this.agu_tarifa_ate50_agua = agu_tarifa_ate50_agua;
	}
	public BigDecimal getAgu_tarifa_acima50_agua() {
		return agu_tarifa_acima50_agua;
	}
	public void setAgu_tarifa_acima50_agua(BigDecimal agu_tarifa_acima50_agua) {
		this.agu_tarifa_acima50_agua = agu_tarifa_acima50_agua;
	}
	public BigDecimal getAgu_tarifa_ate10_esgoto() {
		return agu_tarifa_ate10_esgoto;
	}
	public void setAgu_tarifa_ate10_esgoto(BigDecimal agu_tarifa_ate10_esgoto) {
		this.agu_tarifa_ate10_esgoto = agu_tarifa_ate10_esgoto;
	}
	public BigDecimal getAgu_tarifa_ate20_esgoto() {
		return agu_tarifa_ate20_esgoto;
	}
	public void setAgu_tarifa_ate20_esgoto(BigDecimal agu_tarifa_ate20_esgoto) {
		this.agu_tarifa_ate20_esgoto = agu_tarifa_ate20_esgoto;
	}
	public BigDecimal getAgu_tarifa_ate30_esgoto() {
		return agu_tarifa_ate30_esgoto;
	}
	public void setAgu_tarifa_ate30_esgoto(BigDecimal agu_tarifa_ate30_esgoto) {
		this.agu_tarifa_ate30_esgoto = agu_tarifa_ate30_esgoto;
	}
	public BigDecimal getAgu_tarifa_ate50_esgoto() {
		return agu_tarifa_ate50_esgoto;
	}
	public void setAgu_tarifa_ate50_esgoto(BigDecimal agu_tarifa_ate50_esgoto) {
		this.agu_tarifa_ate50_esgoto = agu_tarifa_ate50_esgoto;
	}
	public BigDecimal getAgu_tarifa_acima50_esgoto() {
		return agu_tarifa_acima50_esgoto;
	}
	public void setAgu_tarifa_acima50_esgoto(BigDecimal agu_tarifa_acima50_esgoto) {
		this.agu_tarifa_acima50_esgoto = agu_tarifa_acima50_esgoto;
	}
	public BigDecimal getAgu_valor_agua1() {
		return agu_valor_agua1;
	}
	public void setAgu_valor_agua1(BigDecimal agu_valor_agua1) {
		this.agu_valor_agua1 = agu_valor_agua1;
	}
	public BigDecimal getAgu_valor_agua2() {
		return agu_valor_agua2;
	}
	public void setAgu_valor_agua2(BigDecimal agu_valor_agua2) {
		this.agu_valor_agua2 = agu_valor_agua2;
	}
	public BigDecimal getAgu_valor_esgoto1() {
		return agu_valor_esgoto1;
	}
	public void setAgu_valor_esgoto1(BigDecimal agu_valor_esgoto1) {
		this.agu_valor_esgoto1 = agu_valor_esgoto1;
	}
	public BigDecimal getAgu_valor_esgoto2() {
		return agu_valor_esgoto2;
	}
	public void setAgu_valor_esgoto2(BigDecimal agu_valor_esgoto2) {
		this.agu_valor_esgoto2 = agu_valor_esgoto2;
	}

}
