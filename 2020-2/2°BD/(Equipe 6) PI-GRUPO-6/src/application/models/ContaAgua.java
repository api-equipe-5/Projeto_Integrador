package application.models;

import java.util.Date;

public class ContaAgua {
	
	public int idContaAgua;
	public int idClienteConta;
	public int rgi;
	public int codigoCliente;
	public String tipoLigacao;
	public String hidrometro;
	public String tipoFaturamento;
	public String periodoConsumo;
	public String agua;
	public String esgoto;
	public String consumo;
	public float valorLeituraAtual;
	public float valorLeituraAnterior;
	public Date dataLeituraAtual;
	public Date dataLeituraAnterior;
	public Date dataVencimento;
	public float totalPagar;
	
	public ContaAgua(int idContaAgua, int idClienteConta, int rgi, int codigoCliente, String tipoLigacao, String hidrometro, String tipoFaturamento, String periodoConsumo,
			String agua, String esgoto, String consumo, float valorLeituraAtual, float valorLeituraAnterior, Date dataLeituraAtual, Date dataLeituraAnterior,
			Date dataVencimento, float totalPagar) {
		this.idContaAgua = idContaAgua;
		this.idClienteConta = idClienteConta;
		this.rgi = rgi;
		this.codigoCliente = codigoCliente;
		this.tipoLigacao = tipoLigacao;
		this.hidrometro = hidrometro;
		this.tipoFaturamento = tipoFaturamento;
		this.periodoConsumo = periodoConsumo;
		this.agua = agua;
		this.esgoto = esgoto;
		this.consumo = consumo;
		this.valorLeituraAtual = valorLeituraAtual;
		this.valorLeituraAnterior = valorLeituraAnterior;
		this.dataLeituraAtual = dataLeituraAtual;
		this.dataLeituraAnterior = dataLeituraAnterior;
		this.dataVencimento = dataVencimento;
		this.totalPagar = totalPagar;
		
	}

	public int getIdContaAgua() {
		return idContaAgua;
	}

	public void setIdContaAgua(int idContaAgua) {
		this.idContaAgua = idContaAgua;
	}

	public int getIdClienteConta() {
		return idClienteConta;
	}

	public void setIdClienteConta(int idClienteConta) {
		this.idClienteConta = idClienteConta;
	}

	public int getRgi() {
		return rgi;
	}

	public void setRgi(int rgi) {
		this.rgi = rgi;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getTipoLigacao() {
		return tipoLigacao;
	}

	public void setTipoLigacao(String tipoLigacao) {
		this.tipoLigacao = tipoLigacao;
	}

	public String getHidrometro() {
		return hidrometro;
	}

	public void setHidrometro(String hidrometro) {
		this.hidrometro = hidrometro;
	}

	public String getTipoFaturamento() {
		return tipoFaturamento;
	}

	public void setTipoFaturamento(String tipoFaturamento) {
		this.tipoFaturamento = tipoFaturamento;
	}

	public String getPeriodoConsumo() {
		return periodoConsumo;
	}

	public void setPeriodoConsumo(String periodoConsumo) {
		this.periodoConsumo = periodoConsumo;
	}

	public String getAgua() {
		return agua;
	}

	public void setAgua(String agua) {
		this.agua = agua;
	}

	public String getEsgoto() {
		return esgoto;
	}

	public void setEsgoto(String esgoto) {
		this.esgoto = esgoto;
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

	public void setTotalPagar(float totalPagar) {
		this.totalPagar = totalPagar;
	}
	

}
