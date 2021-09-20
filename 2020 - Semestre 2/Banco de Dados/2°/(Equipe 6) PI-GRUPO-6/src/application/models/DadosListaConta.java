package application.models;

import java.util.Date;

public class DadosListaConta {
	public String nome_cli;
	public Date dataVencimento;
	public float totalPagar;
	public int cod_identif_conta;

	public String getNome_cli() {
		return nome_cli;
	}

	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
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

	public int getCod_identif_conta() {
		return cod_identif_conta;
	}

	public void setCod_identif_conta(int cod_identif_conta) {
		this.cod_identif_conta = cod_identif_conta;
	}

	public DadosListaConta(String nome_cli, Date dataVencimento, float totalPagar, int cod_identif_conta) {
		super();
		this.nome_cli = nome_cli;
		this.dataVencimento = dataVencimento;
		this.totalPagar = totalPagar;
		this.cod_identif_conta = cod_identif_conta;
	}

	@Override
	public String toString() {
		return "DadosListaConta [nome_cli=" + nome_cli + ", dataVencimento=" + dataVencimento + ", totalPagar="
				+ totalPagar + ", cod_identif_conta=" + cod_identif_conta + "]";
	}
}
