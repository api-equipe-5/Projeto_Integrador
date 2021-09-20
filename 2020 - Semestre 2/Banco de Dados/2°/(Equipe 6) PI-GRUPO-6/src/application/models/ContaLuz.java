package application.models;

import java.util.Date;

public class ContaLuz {

	public int id_contaluz;
	public int id_cliente_contaluz;
	public int cod_identif_contaluz;
	public String grupo_subgrupo_contaluz;
	public String tpfornecimento_contaluz;
	public String modtarifaria_contluz;
	public String rotleitura_contluz;
	public String codfiscal_contaluz;
	public String classe_subclasse_contaluz;
	public String tensaonominal_contaluz;
	public int medidor_contaluz;
	public int id_clienteconsumo_contaluz;
	public float valortotal_contaluz;
	public int numeroinstalacao_contaluz;
	public int consumo_contluz;
	public Date datavenc_contaluz;
	public String contames_contaluz;
	public String bandtarifarias;
	public Date emissao_contaluz;
	public Date leituraanterior_contaluz;
	public Date leituraatual_contaluz;
	public Date prevproxleit_contaluz;
	public int diasfatura_contaluz;
	public String avisos_contaluz;
	public float leit_ant_contaluz;
	public float leit_atual_contaluz;
	public float const_mult_contaluz;
	
	public ContaLuz(int id_contaluz, int id_cliente_contaluz, int cod_identif_contaluz, String grupo_subgrupo_contaluz,
			String tpfornecimento_contaluz, String modtarifaria_contluz, String rotleitura_contluz,
			String codfiscal_contaluz, String classe_subclasse_contaluz, String tensaonominal_contaluz,
			int medidor_contaluz, int id_clienteconsumo_contaluz, float valortotal_contaluz,
			int numeroinstalacao_contaluz, int consumo_contluz, Date datavenc_contaluz, String contames_contaluz,
			String bandtarifarias, Date emissao_contaluz, Date leituraanterior_contaluz, Date leituraatual_contaluz,
			Date prevproxleit_contaluz, int diasfatura_contaluz, String avisos_contaluz, float leit_ant_contaluz,
			float leit_atual_contaluz, float const_mult_contaluz) {
		super();
		this.id_contaluz = id_contaluz;
		this.id_cliente_contaluz = id_cliente_contaluz;
		this.cod_identif_contaluz = cod_identif_contaluz;
		this.grupo_subgrupo_contaluz = grupo_subgrupo_contaluz;
		this.tpfornecimento_contaluz = tpfornecimento_contaluz;
		this.modtarifaria_contluz = modtarifaria_contluz;
		this.rotleitura_contluz = rotleitura_contluz;
		this.codfiscal_contaluz = codfiscal_contaluz;
		this.classe_subclasse_contaluz = classe_subclasse_contaluz;
		this.tensaonominal_contaluz = tensaonominal_contaluz;
		this.medidor_contaluz = medidor_contaluz;
		this.id_clienteconsumo_contaluz = id_clienteconsumo_contaluz;
		this.valortotal_contaluz = valortotal_contaluz;
		this.numeroinstalacao_contaluz = numeroinstalacao_contaluz;
		this.consumo_contluz = consumo_contluz;
		this.datavenc_contaluz = datavenc_contaluz;
		this.contames_contaluz = contames_contaluz;
		this.bandtarifarias = bandtarifarias;
		this.emissao_contaluz = emissao_contaluz;
		this.leituraanterior_contaluz = leituraanterior_contaluz;
		this.leituraatual_contaluz = leituraatual_contaluz;
		this.prevproxleit_contaluz = prevproxleit_contaluz;
		this.diasfatura_contaluz = diasfatura_contaluz;
		this.avisos_contaluz = avisos_contaluz;
		this.leit_ant_contaluz = leit_ant_contaluz;
		this.leit_atual_contaluz = leit_atual_contaluz;
		this.const_mult_contaluz = const_mult_contaluz;
	}

	public int getId_contaluz() {
		return id_contaluz;
	}

	public void setId_contaluz(int id_contaluz) {
		this.id_contaluz = id_contaluz;
	}

	public int getId_cliente_contaluz() {
		return id_cliente_contaluz;
	}

	public void setId_cliente_contaluz(int id_cliente_contaluz) {
		this.id_cliente_contaluz = id_cliente_contaluz;
	}

	public int getCod_identif_contaluz() {
		return cod_identif_contaluz;
	}

	public void setCod_identif_contaluz(int cod_identif_contaluz) {
		this.cod_identif_contaluz = cod_identif_contaluz;
	}

	public String getGrupo_subgrupo_contaluz() {
		return grupo_subgrupo_contaluz;
	}

	public void setGrupo_subgrupo_contaluz(String grupo_subgrupo_contaluz) {
		this.grupo_subgrupo_contaluz = grupo_subgrupo_contaluz;
	}

	public String getTpfornecimento_contaluz() {
		return tpfornecimento_contaluz;
	}

	public void setTpfornecimento_contaluz(String tpfornecimento_contaluz) {
		this.tpfornecimento_contaluz = tpfornecimento_contaluz;
	}

	public String getModtarifaria_contluz() {
		return modtarifaria_contluz;
	}

	public void setModtarifaria_contluz(String modtarifaria_contluz) {
		this.modtarifaria_contluz = modtarifaria_contluz;
	}

	public String getRotleitura_contluz() {
		return rotleitura_contluz;
	}

	public void setRotleitura_contluz(String rotleitura_contluz) {
		this.rotleitura_contluz = rotleitura_contluz;
	}

	public String getCodfiscal_contaluz() {
		return codfiscal_contaluz;
	}

	public void setCodfiscal_contaluz(String codfiscal_contaluz) {
		this.codfiscal_contaluz = codfiscal_contaluz;
	}

	public String getClasse_subclasse_contaluz() {
		return classe_subclasse_contaluz;
	}

	public void setClasse_subclasse_contaluz(String classe_subclasse_contaluz) {
		this.classe_subclasse_contaluz = classe_subclasse_contaluz;
	}

	public String getTensaonominal_contaluz() {
		return tensaonominal_contaluz;
	}

	public void setTensaonominal_contaluz(String tensaonominal_contaluz) {
		this.tensaonominal_contaluz = tensaonominal_contaluz;
	}

	public int getMedidor_contaluz() {
		return medidor_contaluz;
	}

	public void setMedidor_contaluz(int medidor_contaluz) {
		this.medidor_contaluz = medidor_contaluz;
	}

	public int getId_clienteconsumo_contaluz() {
		return id_clienteconsumo_contaluz;
	}

	public void setId_clienteconsumo_contaluz(int id_clienteconsumo_contaluz) {
		this.id_clienteconsumo_contaluz = id_clienteconsumo_contaluz;
	}

	public float getValortotal_contaluz() {
		return valortotal_contaluz;
	}

	public void setValortotal_contaluz(float valortotal_contaluz) {
		this.valortotal_contaluz = valortotal_contaluz;
	}

	public int getNumeroinstalacao_contaluz() {
		return numeroinstalacao_contaluz;
	}

	public void setNumeroinstalacao_contaluz(int numeroinstalacao_contaluz) {
		this.numeroinstalacao_contaluz = numeroinstalacao_contaluz;
	}

	public int getConsumo_contluz() {
		return consumo_contluz;
	}

	public void setConsumo_contluz(int consumo_contluz) {
		this.consumo_contluz = consumo_contluz;
	}

	public Date getDatavenc_contaluz() {
		return datavenc_contaluz;
	}

	public void setDatavenc_contaluz(Date datavenc_contaluz) {
		this.datavenc_contaluz = datavenc_contaluz;
	}

	public String getContames_contaluz() {
		return contames_contaluz;
	}

	public void setContames_contaluz(String contames_contaluz) {
		this.contames_contaluz = contames_contaluz;
	}

	public String getBandtarifarias() {
		return bandtarifarias;
	}

	public void setBandtarifarias(String bandtarifarias) {
		this.bandtarifarias = bandtarifarias;
	}

	public Date getEmissao_contaluz() {
		return emissao_contaluz;
	}

	public void setEmissao_contaluz(Date emissao_contaluz) {
		this.emissao_contaluz = emissao_contaluz;
	}

	public Date getLeituraanterior_contaluz() {
		return leituraanterior_contaluz;
	}

	public void setLeituraanterior_contaluz(Date leituraanterior_contaluz) {
		this.leituraanterior_contaluz = leituraanterior_contaluz;
	}

	public Date getLeituraatual_contaluz() {
		return leituraatual_contaluz;
	}

	public void setLeituraatual_contaluz(Date leituraatual_contaluz) {
		this.leituraatual_contaluz = leituraatual_contaluz;
	}

	public Date getPrevproxleit_contaluz() {
		return prevproxleit_contaluz;
	}

	public void setPrevproxleit_contaluz(Date prevproxleit_contaluz) {
		this.prevproxleit_contaluz = prevproxleit_contaluz;
	}

	public int getDiasfatura_contaluz() {
		return diasfatura_contaluz;
	}

	public void setDiasfatura_contaluz(int diasfatura_contaluz) {
		this.diasfatura_contaluz = diasfatura_contaluz;
	}

	public String getAvisos_contaluz() {
		return avisos_contaluz;
	}

	public void setAvisos_contaluz(String avisos_contaluz) {
		this.avisos_contaluz = avisos_contaluz;
	}

	public float getLeit_ant_contaluz() {
		return leit_ant_contaluz;
	}

	public void setLeit_ant_contaluz(float leit_ant_contaluz) {
		this.leit_ant_contaluz = leit_ant_contaluz;
	}

	public float getLeit_atual_contaluz() {
		return leit_atual_contaluz;
	}

	public void setLeit_atual_contaluz(float leit_atual_contaluz) {
		this.leit_atual_contaluz = leit_atual_contaluz;
	}

	public float getConst_mult_contaluz() {
		return const_mult_contaluz;
	}

	public void setConst_mult_contaluz(float const_mult_contaluz) {
		this.const_mult_contaluz = const_mult_contaluz;
	}
	
	
	
	
}
