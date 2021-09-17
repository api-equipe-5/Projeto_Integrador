package fatec.pi.entities;

import java.math.BigDecimal;

public class LightAccount {
	
	private Integer id;
	private Integer identCod;
	private Integer meterNumber;
	private String invoice;
	private String currentDate;
	private String dueDate;
	private Integer consumptionDays;
	private String flagType;
	private BigDecimal consumptionValue;
	private BigDecimal pisPercentage;
	private BigDecimal cofinsPercentage;
	private BigDecimal icmsBasis;
	private BigDecimal icmsPercentage;
	private BigDecimal icmsValue;
	private BigDecimal pisCofinsBasis;
	private BigDecimal pisValue;
	private BigDecimal cofinsValue;
	private BigDecimal forfeitValue;
	private BigDecimal interestValue;
	private BigDecimal otherValues;
	private BigDecimal supplyValue;
	private BigDecimal financialItems;
	private BigDecimal amount;
	private Long supplierCnpj;
	private Integer createdBy;
	private Integer alterBy;
	
	public LightAccount(Integer identCod, Integer meterNumber, String invoice, String currentDate, String dueDate,
			Integer consumptionDays, String flagType, BigDecimal consumptionValue, BigDecimal pisPercentage,
			BigDecimal cofinsPercentage, BigDecimal icmsBasis, BigDecimal icmsPercentage, BigDecimal icmsValue,
			BigDecimal pisCofinsBasis, BigDecimal pisValue, BigDecimal cofinsValue, BigDecimal forfeitValue,
			BigDecimal interestValue, BigDecimal otherValues, BigDecimal supplyValue, BigDecimal financialItems,
			BigDecimal amount, Long supplierCnpj, Integer createdBy, Integer alterBy) {
		
		this.setIdentCod(identCod);
		this.setMeterNumber(meterNumber);
		this.setInvoice(invoice);
		this.setCurrentDate(currentDate);
		this.setDueDate(dueDate);
		this.setConsumptionDays(consumptionDays);
		this.setFlagType(flagType);
		this.setConsumptionValue(consumptionValue);
		this.setPisPercentage(pisPercentage);
		this.setCofinsPercentage(cofinsPercentage);
		this.setIcmsBasis(icmsBasis);
		this.setIcmsPercentage(icmsPercentage);
		this.setIcmsValue(icmsValue);
		this.setPisCofinsBasis(pisCofinsBasis);
		this.setPisValue(pisValue);
		this.setCofinsValue(cofinsValue);
		this.setForfeitValue(forfeitValue);
		this.setInterestValue(interestValue);
		this.setOtherValues(otherValues);
		this.setSupplyValue(supplyValue);
		this.setFinancialItems(financialItems);
		this.setAmount(amount);
		this.setSupplierCnpj(supplierCnpj);
		this.setCreatedBy(createdBy);
		this.setAlterBy(alterBy);
	}
	
	
	
	
	public LightAccount(Integer id, Integer identCod, Integer meterNumber, String invoice, String currentDate,
			String dueDate, Integer consumptionDays, String flagType, BigDecimal consumptionValue,
			BigDecimal pisPercentage, BigDecimal cofinsPercentage, BigDecimal icmsBasis, BigDecimal icmsPercentage,
			BigDecimal icmsValue, BigDecimal pisCofinsBasis, BigDecimal pisValue, BigDecimal cofinsValue,
			BigDecimal forfeitValue, BigDecimal interestValue, BigDecimal otherValues, BigDecimal supplyValue,
			BigDecimal financialItems, BigDecimal amount, Long supplierCnpj, Integer alterBy) {
		this.setId(id);
		this.setIdentCod(identCod);
		this.setMeterNumber(meterNumber);
		this.setInvoice(invoice);
		this.setCurrentDate(currentDate);
		this.setDueDate(dueDate);
		this.setConsumptionDays(consumptionDays);
		this.setFlagType(flagType);
		this.setConsumptionValue(consumptionValue);
		this.setPisPercentage(pisPercentage);
		this.setCofinsPercentage(cofinsPercentage);
		this.setIcmsBasis(icmsBasis);
		this.setIcmsPercentage(icmsPercentage);
		this.setIcmsValue(icmsValue);
		this.setPisCofinsBasis(pisCofinsBasis);
		this.setPisValue(pisValue);
		this.setCofinsValue(cofinsValue);
		this.setForfeitValue(forfeitValue);
		this.setInterestValue(interestValue);
		this.setOtherValues(otherValues);
		this.setSupplyValue(supplyValue);
		this.setFinancialItems(financialItems);
		this.setAmount(amount);
		this.setSupplierCnpj(supplierCnpj);
		this.setAlterBy(alterBy);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getIdentCod() {
		return identCod;
	}
	public void setIdentCod(Integer identCod) {
		this.identCod = identCod;
	}

	public Integer getMeterNumber() {
		return meterNumber;
	}
	public void setMeterNumber(Integer meterNumber) {
		this.meterNumber = meterNumber;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public Integer getConsumptionDays() {
		return consumptionDays;
	}
	public void setConsumptionDays(Integer consumptionDays) {
		this.consumptionDays = consumptionDays;
	}
	public String getFlagType() {
		return flagType;
	}
	public void setFlagType(String flagType) {
		this.flagType = flagType;
	}
	public BigDecimal getConsumptionValue() {
		return consumptionValue;
	}
	public void setConsumptionValue (BigDecimal consumptionValue) {
		this.consumptionValue = consumptionValue;
	}
	public BigDecimal getPisPercentage() {
		return pisPercentage;
	}
	public void setPisPercentage(BigDecimal pisPercentage) {
		this.pisPercentage = pisPercentage;
	}
	public BigDecimal getCofinsPercentage() {
		return cofinsPercentage;
	}
	public void setCofinsPercentage(BigDecimal cofinsPercentage) {
		this.cofinsPercentage = cofinsPercentage;
	}
	public BigDecimal getIcmsBasis() {
		return icmsBasis;
	}
	public void setIcmsBasis(BigDecimal icmsBasis) {
		this.icmsBasis = icmsBasis;
	}
	public BigDecimal getIcmsPercentage() {
		return icmsPercentage;
	}
	public void setIcmsPercentage(BigDecimal icmsPercentage) {
		this.icmsPercentage = icmsPercentage;
	}
	public BigDecimal getIcmsValue() {
		return icmsValue;
	}
	public void setIcmsValue(BigDecimal icmsValue) {
		this.icmsValue = icmsValue;
	}
	public BigDecimal getPisCofinsBasis() {
		return pisCofinsBasis;
	}
	public void setPisCofinsBasis(BigDecimal pisCofinsBasis) {
		this.pisCofinsBasis = pisCofinsBasis;
	}
	public BigDecimal getPisValue() {
		return pisValue;
	}
	public void setPisValue(BigDecimal pisValue) {
		this.pisValue = pisValue;
	}
	public BigDecimal getCofinsValue() {
		return cofinsValue;
	}
	public void setCofinsValue(BigDecimal cofinsValue) {
		this.cofinsValue = cofinsValue;
	}
	public BigDecimal getForfeitValue() {
		return forfeitValue;
	}
	public void setForfeitValue(BigDecimal forfeitValue) {
		this.forfeitValue = forfeitValue;
	}
	public BigDecimal getInterestValue() {
		return interestValue;
	}
	public void setInterestValue(BigDecimal interestValue) {
		this.interestValue = interestValue;
	}
	public BigDecimal getOtherValues() {
		return otherValues;
	}
	public void setOtherValues(BigDecimal otherValues) {
		this.otherValues = otherValues;
	}
	public BigDecimal getSupplyValue() {
		return supplyValue;
	}
	public void setSupplyValue(BigDecimal supplyValue) {
		this.supplyValue = supplyValue;
	}
	public BigDecimal getFinancialItems() {
		return financialItems;
	}
	public void setFinancialItems(BigDecimal financialItems) {
		this.financialItems = financialItems;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getSupplierCnpj() {
		return supplierCnpj;
	}
	public void setSupplierCnpj(Long supplierCnpj) {
		this.supplierCnpj = supplierCnpj;
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
		return "LightAccount [id=" + id + ", identCod=" + identCod + ", meterNumber=" + meterNumber + ", invoice="
				+ invoice + ", currentDate=" + currentDate + ", dueDate=" + dueDate + ", consumptionDays="
				+ consumptionDays + ", flagType=" + flagType + ", consumptionValue=" + consumptionValue
				+ ", pisPercentage=" + pisPercentage + ", cofinsPercentage=" + cofinsPercentage + ", icmsBasis="
				+ icmsBasis + ", icmsPercentage=" + icmsPercentage + ", icmsValue=" + icmsValue + ", pisCofinsBasis="
				+ pisCofinsBasis + ", pisValue=" + pisValue + ", cofinsValue=" + cofinsValue + ", forfeitValue="
				+ forfeitValue + ", interestValue=" + interestValue + ", otherValues=" + otherValues + ", supplyValue="
				+ supplyValue + ", financialItems=" + financialItems + ", amount=" + amount + ", supplierCnpj="
				+ supplierCnpj + ",createdBy=" + createdBy +", alterBy=" + alterBy + "]";
	}


	
	
}
