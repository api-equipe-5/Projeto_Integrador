package fatec.pi.controllers;

import static javax.swing.JOptionPane.showMessageDialog;

import java.math.BigDecimal;

import java.util.List;

import fatec.pi.daos.SupplierDao;
import fatec.pi.daos.WaterAccountDao;
import fatec.pi.entities.Supplier;
import fatec.pi.entities.WaterAccount;
import fatec.pi.views.ViewAccountType;

public class WaterAccountController {
	public static void saveValues(Integer number, String dueDate, BigDecimal penalty, BigDecimal consumptionValue,
			BigDecimal pollutionValue, BigDecimal sewerValue, BigDecimal waterValue, Integer pisPercentage,
			BigDecimal otherValues, Long supplierCnpj, Integer createdBy, Integer alterBy) {
		
		WaterAccount water = new WaterAccount(number, dueDate, penalty, consumptionValue, pollutionValue, sewerValue,
				waterValue, pisPercentage, otherValues, supplierCnpj, createdBy, alterBy);
		
		if(WaterAccountDao.save(water) == 1) {
			showMessageDialog(null, "Dados cadastrados com Sucesso!");
		}
		
	}
	public static List<WaterAccount> getValues(String installation){
		List<WaterAccount> waterAccount = WaterAccountDao.listWaterAccounts(installation);
		return waterAccount;
	}
	
	
	public static void updateValues(WaterAccount wateraccount) {
		if(WaterAccountDao.update(wateraccount) == 1) {
			showMessageDialog(null, "Dados alterados com sucesso!");
		}
		else {
			showMessageDialog(null, "Dados do tipo incorreto, verifique e tente novamente");
		}	
	}
}
