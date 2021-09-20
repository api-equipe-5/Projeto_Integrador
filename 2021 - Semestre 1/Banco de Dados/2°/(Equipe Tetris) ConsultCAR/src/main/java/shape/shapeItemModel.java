package shape;

public class shapeItemModel {
	
	private Double num_area;
	private String cod_estado;
	private String nome_municipio;
	private Double num_modulo;
	private String tipo_imovel;
	private String situacao;
	private String condicao_imovel;
	private Double cod_imovel;

	private Long gid;
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public Double getNum_area() {
		return num_area;
	}
	public void setNum_area(Double num_area) {
		this.num_area = num_area;
	}
	public String getCod_estado() {
		return cod_estado;
	}
	public void setCod_estado(String cod_estado) {
		this.cod_estado = cod_estado;
	}
	public String getNome_municipio() {
		return nome_municipio;
	}
	public void setNome_municipio(String nome_municipio) {
		this.nome_municipio = nome_municipio;
	}
	public Double getNum_modulo() {
		return num_modulo;
	}
	public void setNum_modulo(Double num_modulo) {
		this.num_modulo = num_modulo;
	}
	public String getTipo_imovel() {
		return tipo_imovel;
	}
	public void setTipo_imovel(String tipo_imovel) {
		this.tipo_imovel = tipo_imovel;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getCondicao_imovel() {
		return condicao_imovel;
	}
	public void setCondicao_imovel(String condicao_imovel) {
		this.condicao_imovel = condicao_imovel;
	}
	public Double getCod_imovel() {
		return cod_imovel;
	}
	public void setCod_imovel(Double cod_imovel) {
		this.cod_imovel = cod_imovel;
	}
	
	public shapeItemModel(Double num_area, String cod_estado, String nome_municipio, Double num_modulo,
			String tipo_imovel, String situacao, String condicao_imovel, Double cod_imovel, Long gid) {
		
		this.num_area = num_area;
		this.cod_estado = cod_estado;
		this.nome_municipio = nome_municipio;
		this.num_modulo = num_modulo;
		this.tipo_imovel = tipo_imovel;
		this.situacao = situacao;
		this.condicao_imovel = condicao_imovel;
		this.cod_imovel = cod_imovel;
		this.gid = gid;
	}
	
	
}
