package application.models;

import java.util.Date;

public class ContaGas {
	
	public int idContaGas;
	public int idClienteConta;
	public int codUsuario;
	public String segmento;
	public String diasConsumo;
	public String tipoMedidor;
	public String numeroMedidor;
	public String consumoCorrigido;
	public String consumo;
	public float valorLeituraAtual;
	public float valorLeituraAnterior;
	public Date dataLeituraAtual;
	public Date dataLeituraAnterior;
	public Date dataVencimento;
	public float totalPagar;
	
	public ContaGas(int idContaGas, int idClienteConta, int codUsuario, String segmento, String diasConsumo, String tipoMedidor,
			String numeroMedidor, String consumoCorrigido, String consumo, float valorLeituraAtual, float valorLeituraAnterior,
			Date dataLeituraAtual, Date dataLeituraAnterior,
			Date dataVencimento, float totalPagar) {
		this.idContaGas = idContaGas;	
		this.idClienteConta = idClienteConta;
		this.codUsuario = codUsuario;
		this.segmento = segmento;
		this.diasConsumo = diasConsumo;
		this.tipoMedidor = tipoMedidor;
		this.numeroMedidor = numeroMedidor;
		this.consumoCorrigido = consumoCorrigido;
		this.consumo = consumo;
		this.valorLeituraAtual = valorLeituraAtual;
		this.valorLeituraAnterior = valorLeituraAnterior;
		this.dataLeituraAtual = dataLeituraAtual;
		this.dataLeituraAnterior = dataLeituraAnterior;
		this.dataVencimento = dataVencimento;
		this.totalPagar = totalPagar;
				
			}

	public int getIdContaGas() {
		return idContaGas;
	}

	public void setIdContaGas(int idContaGas) {
		this.idContaGas = idContaGas;
	}

	public int getIdClienteConta() {
		return idClienteConta;
	}

	public void setIdClienteConta(int idClienteConta) {
		this.idClienteConta = idClienteConta;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getDiasConsumo() {
		return diasConsumo;
	}

	public void setDiasConsumo(String diasConsumo) {
		this.diasConsumo = diasConsumo;
	}

	public String getTipoMedidor() {
		return tipoMedidor;
	}

	public void setTipoMedidor(String tipoMedidor) {
		this.tipoMedidor = tipoMedidor;
	}

	public String getNumeroMedidor() {
		return numeroMedidor;
	}

	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}

	public String getConsumoCorrigido() {
		return consumoCorrigido;
	}

	public void setConsumoCorrigido(String consumoCorrigido) {
		this.consumoCorrigido = consumoCorrigido;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}

	public float getValorLeituraAtual() {
		return valorLeituraAtual;
	}

	public void setValorLeituraAtual(float valorLeituraAtual) {
		this.valorLeituraAtual = valorLeituraAtual;
	}

	public float getValorLeituraAnterior() {
		return valorLeituraAnterior;
	}

	public void setValorLeituraAnterior(float valorLeituraAnterior) {
		this.valorLeituraAnterior = valorLeituraAnterior;
	}

	public Date getDataLeituraAtual() {
		return dataLeituraAtual;
	}

	public void setDataLeituraAtual(Date dataLeituraAtual) {
		this.dataLeituraAtual = dataLeituraAtual;
	}

	public Date getDataLeituraAnterior() {
		return dataLeituraAnterior;
	}

	public void setDataLeituraAnterior(Date dataLeituraAnterior) {
		this.dataLeituraAnterior = dataLeituraAnterior;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public float getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(int totalPagar) {
		this.totalPagar = totalPagar;
	}
	

}
