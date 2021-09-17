package fatec.pi.entities;

public class Supplier {
	private Integer id;

	private Long cnpj;
	private String name;
	private String site;
	private Integer type;
	private Integer createdBy;
	private Integer alterBy;
	

	public Supplier(Long cnpj, String name, String site, Integer type, Integer createdBy, Integer alterBy) {
		
		this.setCnpj(cnpj);
		this.setName(name);
		this.setSite(site);
		this.setType(type);
		this.setCreatedBy(createdBy);
		this.setAlterBy(alterBy);
	}
	

	public Supplier( Integer id, Long cnpj, String name, String site, Integer type, Integer alterBy) {
		this.setId(id);
		this.setCnpj(cnpj);
		this.setName(name);
		this.setSite(site);
		this.setType(type);
		this.setAlterBy(alterBy);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	

	public Integer getAlterBy() {
		return alterBy;
	}


	public void setAlterBy(Integer alterBy) {
		this.alterBy = alterBy;
	}
	
	
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", cnpj=" + cnpj + ", name=" + name + ", site=" + site + ", type=" + type
				+ ", createdBy=" + createdBy + ", alterBy=" + alterBy + "]";
	}

	public String toType() {
		String result = "";
		if(this.getType().equals(0)) {
			result = "Energia";
		}
		else {
			result = "Água";
		}
		return result;
	}
}
