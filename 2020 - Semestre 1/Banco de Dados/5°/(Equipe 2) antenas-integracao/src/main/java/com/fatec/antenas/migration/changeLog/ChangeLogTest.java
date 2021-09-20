package com.fatec.antenas.migration.changeLog;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.fatec.antenas.model.DocumentEmpresario;
import com.fatec.antenas.util.PasswordEncrypt;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;


@ChangeLog
public class ChangeLogTest {

	
	  @Profile("test")
	  @ChangeSet(order = "001", id = "migration_prod_to_test", author = "test", systemVersion = "test:0.0.1")
	  public void updateTestProd(MongoTemplate mongoTemplate){
		  
		  DocumentEmpresario empresarioAdmin = new DocumentEmpresario(null, "test",
					 "test.empresario@fatec.sp.gov.br", new PasswordEncrypt("test").getPasswordEncoder(), "FATEC", "008.678.770-57", "");
			 empresarioAdmin.setAdmin(true);
			 empresarioAdmin.setAtivo(true);
			 mongoTemplate.save(empresarioAdmin);
	  }

}
