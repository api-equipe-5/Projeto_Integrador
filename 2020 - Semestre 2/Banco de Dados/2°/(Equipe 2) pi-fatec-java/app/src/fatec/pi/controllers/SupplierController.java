package fatec.pi.controllers;

import static javax.swing.JOptionPane.showMessageDialog;

import java.util.List;

import fatec.pi.daos.SupplierDao;
import fatec.pi.entities.Supplier;
import fatec.pi.views.ViewAccountType;

public class SupplierController {

	public static void saveValues(Long cnpj, String name, String site, Integer type, Integer createdBy, Integer alterBy) {
		Supplier sup = new Supplier(cnpj, name, site, type, createdBy, alterBy);
  
		if(SupplierDao.save(sup) == 1) {
			showMessageDialog(null, "Dados cadastrados com Sucesso!");
		}
	}
	
	public static List<Supplier> getValues(String cnpj) {
			List<Supplier> suppliers = SupplierDao.listSuppliers(cnpj);
			return suppliers;
	}
	
	public static void updateValues(Supplier supplier) {
		
		if(supplier.getType() > 2) {
			showMessageDialog(null, "Dados do tipo incorreto, verifique e tente novamente");
		}
		else {
			if(SupplierDao.update(supplier) == 1) {
				showMessageDialog(null, "Dados alterados com sucesso!");
			}
			else {
				showMessageDialog(null, "Dados do tipo incorreto, verifique e tente novamente");
			}
		}
		
	}
}
