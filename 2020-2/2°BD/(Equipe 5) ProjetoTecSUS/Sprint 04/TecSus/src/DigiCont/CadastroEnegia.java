package DigiCont;

import java.sql.Date;
import java.util.*;

public class CadastroEnegia {
	
	
	public String ContaLuzID;
	public String ContaLuzValorTotal;
	public String ContaLuzDataVencimento; 
	public String ContaLuzMes;
	public String ContaLuzEmissao;
	public String ContaLuzAnterior; 
	public String ContaLuzAtual;
	public String ContaLuzDiasFaturamento;
	public String ContaLuzStatus;
	public String ContaLuzPrevisaoProximaLuz;
	public String ContaLuzValorFornecedor;
	public String ContaLuzDataFaturamento;
	public String ContaLuzQtdkWh;
	public String ContaLuzAviso;
	public String ContaLuzFiscalCFOP;
	public String ContaLuzFiscalGrupo;
	public String ContaLuzFiscalSubGrupo;
	public String ContaLuzFiscalClasse;
	public String ContaLuzFiscalSubClasse;
	public String ContaLuzFiscalMulta;
	public String ContaLuzFiscalJurosMulta;
	public String ContaLuzFiscalTipoFornecimento;
	public String ContaLuzFiscalModalidadeTarifaria;
	
	//GETTER AND SETTERS

	public String getContaLuzID() {
		return ContaLuzID;
	}
	public void setContaLuzID(String contaLuzID) {
		ContaLuzID = contaLuzID;
	}
	public String getContaLuzValorTotal() {
		return ContaLuzValorTotal;
	}
	public void setContaLuzValorTotal(String contaLuzValorTotal) {
		ContaLuzValorTotal = contaLuzValorTotal;
	}
	public String getContaLuzDataVencimento() {
		return ContaLuzDataVencimento;
	}
	public void setContaLuzDataVencimento(String contaLuzDataVencimento) {
		ContaLuzDataVencimento = contaLuzDataVencimento;
	}
	public String getContaLuzMes() {
		return ContaLuzMes;
	}
	public void setContaLuzMes(String contaLuzMes) {
		ContaLuzMes = contaLuzMes;
	}
	public String getContaLuzEmissao() {
		return ContaLuzEmissao;
	}
	public void setContaLuzEmissao(String contaLuzEmissao) {
		ContaLuzEmissao = contaLuzEmissao;
	}
	public String getContaLuzAnterior() {
		return ContaLuzAnterior;
	}
	public void setContaLuzAnterior(String contaLuzAnterior) {
		ContaLuzAnterior = contaLuzAnterior;
	}
	public String getContaLuzAtual() {
		return ContaLuzAtual;
	}
	public void setContaLuzAtual(String contaLuzAtual) {
		ContaLuzAtual = contaLuzAtual;
	}
	public String getContaLuzDiasFaturamento() {
		return ContaLuzDiasFaturamento;
	}
	public void setContaLuzDiasFaturamento(String contaLuzDiasFaturamento) {
		ContaLuzDiasFaturamento = contaLuzDiasFaturamento;
	}
	public String getContaLuzStatus() {
		return ContaLuzStatus;
	}
	public void setContaLuzStatus(String contaLuzStatus) {
		ContaLuzStatus = contaLuzStatus;
	}
	public String getContaLuzPrevisaoProximaLuz() {
		return ContaLuzPrevisaoProximaLuz;
	}
	public void setContaLuzPrevisaoProximaLuz(String contaLuzPrevisaoProximaLuz) {
		ContaLuzPrevisaoProximaLuz = contaLuzPrevisaoProximaLuz;
	}
	public String getContaLuzValorFornecedor() {
		return ContaLuzValorFornecedor;
	}
	public void setContaLuzValorFornecedor(String contaLuzValorFornecedor) {
		ContaLuzValorFornecedor = contaLuzValorFornecedor;
	}
	public String getContaLuzDataFaturamento() {
		return ContaLuzDataFaturamento;
	}
	public void setContaLuzDataFaturamento(String contaLuzDataFaturamento) {
		ContaLuzDataFaturamento = contaLuzDataFaturamento;
	}
	public String getContaLuzQtdkWh() {
		return ContaLuzQtdkWh;
	}
	public void setContaLuzQtdkWh(String contaLuzQtdkWh) {
		ContaLuzQtdkWh = contaLuzQtdkWh;
	}
	public String getContaLuzAviso() {
		return ContaLuzAviso;
	}
	public void setContaLuzAviso(String contaLuzAviso) {
		ContaLuzAviso = contaLuzAviso;
	}
	public String getContaLuzFiscalCFOP() {
		return ContaLuzFiscalCFOP;
	}
	public void setContaLuzFiscalCFOP(String contaLuzFiscalCFOP) {
		ContaLuzFiscalCFOP = contaLuzFiscalCFOP;
	}
	public String getContaLuzFiscalGrupo() {
		return ContaLuzFiscalGrupo;
	}
	public void setContaLuzFiscalGrupo(String contaLuzFiscalGrupo) {
		ContaLuzFiscalGrupo = contaLuzFiscalGrupo;
	}
	public String getContaLuzFiscalSubGrupo() {
		return ContaLuzFiscalSubGrupo;
	}
	public void setContaLuzFiscalSubGrupo(String contaLuzFiscalSubGrupo) {
		ContaLuzFiscalSubGrupo = contaLuzFiscalSubGrupo;
	}
	public String getContaLuzFiscalClasse() {
		return ContaLuzFiscalClasse;
	}
	public void setContaLuzFiscalClasse(String contaLuzFiscalClasse) {
		ContaLuzFiscalClasse = contaLuzFiscalClasse;
	}
	public String getContaLuzFiscalSubClasse() {
		return ContaLuzFiscalSubClasse;
	}
	public void setContaLuzFiscalSubClasse(String contaLuzFiscalSubClasse) {
		ContaLuzFiscalSubClasse = contaLuzFiscalSubClasse;
	}
	public String getContaLuzFiscalMulta() {
		return ContaLuzFiscalMulta;
	}
	public void setContaLuzFiscalMulta(String contaLuzFiscalMulta) {
		ContaLuzFiscalMulta = contaLuzFiscalMulta;
	}
	public String getContaLuzFiscalJurosMulta() {
		return ContaLuzFiscalJurosMulta;
	}
	public void setContaLuzFiscalJurosMulta(String contaLuzFiscalJurosMulta) {
		ContaLuzFiscalJurosMulta = contaLuzFiscalJurosMulta;
	}
	public String getContaLuzFiscalTipoFornecimento() {
		return ContaLuzFiscalTipoFornecimento;
	}
	public void setContaLuzFiscalTipoFornecimento(String contaLuzFiscalTipoFornecimento) {
		ContaLuzFiscalTipoFornecimento = contaLuzFiscalTipoFornecimento;
	}
	public String getContaLuzFiscalModalidadeTarifaria() {
		return ContaLuzFiscalModalidadeTarifaria;
	}
	public void setContaLuzFiscalModalidadeTarifaria(String contaLuzFiscalModalidadeTarifaria) {
		ContaLuzFiscalModalidadeTarifaria = contaLuzFiscalModalidadeTarifaria;
	}
	
}
	
	
	

