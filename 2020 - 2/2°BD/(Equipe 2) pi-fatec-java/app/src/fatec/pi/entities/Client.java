package fatec.pi.entities;

import java.math.BigDecimal;

public class Client {
	
	private Integer id;
	private Long supplierCnpj;
	private Long clientCpf;
	private String clientName;
	private String zipCode;
	private String streetName;
	private Integer streetNumber;
	private String streetComplement;
	private String city;
	private String state;
	private Integer meterNumber;
	private String measurementOrder; //Roteiro de Leitura
	private String lightClass;
	private String lightSubclass;
	private BigDecimal normalTax; //Tarifa sem imposto
	private BigDecimal tributeTax; //Tarifa com imposto
	private Integer createdBy;
	private Integer alterBy;
	
	public Client(Long supplierCnpj, Long clientCpf, String clientName, String zipCode, String streetName, Integer streetNumber,
			String streetComplement, String city, String state, Integer meterNumber, String measurementOrder, String lightClass, String lightSubclass,
			BigDecimal normalTax, BigDecimal tributeTax, Integer createdBy, Integer alterBy) {
		this.setSupplierCnpj(supplierCnpj);
		this.setClientCpf(clientCpf);
		this.setClientName(clientName);
		this.setZipCode(zipCode);
		this.setStreetName(streetName);
		this.setStreetNumber(streetNumber);
		this.setStreetComplement(streetComplement);
		this.setCity(city);
		this.setState(state);
		this.setMeterNumber(meterNumber);
		this.setMeasurementOrder(measurementOrder);
		this.setLightClass(lightClass);
		this.setLightSubclass(lightSubclass);
		this.setNormalTax(normalTax);
		this.setTributeTax(tributeTax);
		this.setCreatedBy(createdBy);
		this.setAlterBy(alterBy);
	}
	
	
	
	public Client(Integer id, Long supplierCnpj, Long clientCpf, String clientName, String zipCode,
			String streetName, Integer streetNumber, String streetComplement, String city, String state,
			Integer meterNumber, String measurementOrder, String lightClass, String lightSubclass, BigDecimal normalTax,
			BigDecimal tributeTax, Integer alterBy) {
		this.setId(id);
		this.setSupplierCnpj(supplierCnpj);
		this.setClientCpf(clientCpf);
		this.setClientName(clientName);
		this.setZipCode(zipCode);
		this.setStreetName(streetName);
		this.setStreetNumber(streetNumber);
		this.setStreetComplement(streetComplement);
		this.setCity(city);
		this.setState(state);
		this.setMeterNumber(meterNumber);
		this.setMeasurementOrder(measurementOrder);
		this.setLightClass(lightClass);
		this.setLightSubclass(lightSubclass);
		this.setNormalTax(normalTax);
		this.setTributeTax(tributeTax);
		this.setAlterBy(alterBy);
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public Long getSupplierCnpj() {
		return supplierCnpj;
	}
	public void setSupplierCnpj(Long supplierCnpj) {
		this.supplierCnpj = supplierCnpj;
	}
	public Long getClientCpf() {
		return clientCpf;
	}
	public void setClientCpf(Long clientCpf) {
		this.clientCpf = clientCpf;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode=zipCode;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName=streetName;
	}
	public Integer getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetComplement() {
		return streetComplement;
	}
	public void setStreetComplement(String streetComplement) {
		this.streetComplement=streetComplement;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state=state;
	}
	public Integer getMeterNumber() {
		return meterNumber;
	}
	public void setMeterNumber(Integer meterNumber) {
		this.meterNumber=meterNumber;
	}
	public String getMeasurementOrder() {
		return measurementOrder;
	}
	public void setMeasurementOrder(String measurementOrder) {
		this.measurementOrder=measurementOrder;
	}
	public String getLightClass() {
		return lightClass;
	}
	public void setLightClass(String lightClass) {
		this.lightClass=lightClass;
	}
	public String getLightSubclass() {
		return lightSubclass;
	}
	public void setLightSubclass(String lightSubclass) {
		this.lightSubclass=lightSubclass;
	}
	public BigDecimal getNormalTax() {
		return normalTax;
	}
	public void setNormalTax( BigDecimal normalTax) {
		this.normalTax=normalTax;
	}
	public BigDecimal getTributeTax() {
		return tributeTax;
	}
	public void setTributeTax(BigDecimal tributeTax) {
		this.tributeTax=tributeTax;
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
		return "Client [id=" + id + ", supplierCnpj=" + supplierCnpj + ", clientCpf=" + clientCpf + ", clientName="
				+ clientName + ", zipCode=" + zipCode + ", streetName=" + streetName + ", streetNumber=" + streetNumber
				+ ", streetComplement=" + streetComplement + ", city=" + city + ", state=" + state + ", meterNumber="
				+ meterNumber + ", measurementOrder=" + measurementOrder + ", lightClass=" + lightClass
				+ ", lightSubclass=" + lightSubclass + ", normalTax=" + normalTax + ", tributeTax=" + tributeTax
				+ ", createdBy=" + createdBy + ", alterBy=" + alterBy + "]";
	}

	

}
