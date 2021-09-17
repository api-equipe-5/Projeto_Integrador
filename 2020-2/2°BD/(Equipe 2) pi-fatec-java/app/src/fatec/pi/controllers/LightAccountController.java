package fatec.pi.controllers;

import static javax.swing.JOptionPane.showMessageDialog;

import java.math.BigDecimal;
import java.util.List;

import fatec.pi.daos.LightAccountDao;
import fatec.pi.entities.LightAccount;

public class LightAccountController {
	
	public static void saveValues(Integer identCod, Integer meterNumber, String invoice, String currentDate,
			String dueDate, Integer consumptionDays, String flagType, BigDecimal consumptionValue, BigDecimal pisPercentage,
			BigDecimal cofinsPercentage, BigDecimal icmsBasis, BigDecimal icmsPercentage, BigDecimal icmsValue,
			BigDecimal pisCofinsBasis, BigDecimal pisValue, BigDecimal cofinsValue, BigDecimal forfeitValue,
			BigDecimal interestValue, BigDecimal otherValues, BigDecimal supplyValue, BigDecimal financialItems,
			BigDecimal amount, Long supplierCnpj, Integer createdBy, Integer alterBy) {
		
		LightAccount light = new LightAccount(identCod, meterNumber, invoice, currentDate, dueDate, consumptionDays,
				flagType, consumptionValue, pisPercentage, cofinsPercentage, icmsBasis, icmsPercentage, icmsValue,
				pisCofinsBasis, pisValue, cofinsValue, forfeitValue, interestValue, otherValues, supplyValue,
				financialItems, amount, supplierCnpj, createdBy, alterBy);
		
		
		if(LightAccountDao.save(light) == 1) {
			
			showMessageDialog(null, "Dados cadastrados com Sucesso!");
		}
	}
			public static List <LightAccount> getValues (String identCod){
				List <LightAccount> lightAccounts = LightAccountDao.listLightAccounts(identCod);
				return lightAccounts;
			}
		
			public static void updateValues (LightAccount lightaccount) {
				if (LightAccountDao.update(lightaccount) == 1) {
					showMessageDialog(null, "Dados alterados com sucesso!");
				}
				else {
					showMessageDialog(null,"Dados do tipo incorreto, verifique e tente novamente");
				}
			}
			
 		}