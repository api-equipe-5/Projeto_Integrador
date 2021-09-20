package com.fatec.antenas.migration.changeLog;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.fatec.antenas.model.DocumentAluno;
import com.fatec.antenas.model.DocumentCadi;
import com.fatec.antenas.model.DocumentEmpresario;
import com.fatec.antenas.model.DocumentProfessor;
import com.fatec.antenas.util.PasswordEncrypt;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

@ChangeLog
public class ChangeLogProd {
	
	  @Profile("prod")
	  @ChangeSet(order = "001", id = "emp_default_admin", author = "prod", systemVersion = "prod:0.0.1")
	  public void cadInitEmpresarioAdminProd(MongoTemplate mongoTemplate){
		  DocumentEmpresario empresarioAdmin = new DocumentEmpresario(null, "admin",
					 "admin.empresario@fatec.sp.gov.br", new PasswordEncrypt("admin").getPasswordEncoder(), "FATEC", "008.678.770-57", "");
			 empresarioAdmin.setAdmin(true);
			 empresarioAdmin.setAtivo(true);
			 mongoTemplate.save(empresarioAdmin);
	  }
	  
	  @Profile("prod")
	  @ChangeSet(order = "001", id = "alu_default_admin", author = "prod", systemVersion = "prod:0.0.1")
	  public void cadInitAlunoAdminProd(MongoTemplate mongoTemplate){
		  DocumentAluno alunoAdmin = new DocumentAluno(null, "admin", "admin.aluno@fatec.sp.gov.br", new PasswordEncrypt("admin").getPasswordEncoder());
		  	alunoAdmin.setAdmin(true);
		  	alunoAdmin.setAtivo(true);
			mongoTemplate.save(alunoAdmin);
	  }

	  
	  @Profile("prod")
	  @ChangeSet(order = "001", id = "cadi_default_admin", author = "prod", systemVersion = "prod:0.0.1")
	  public void cadInitCadiAdminProd(MongoTemplate mongoTemplate){
		  DocumentCadi cadiAdmin = new DocumentCadi(null, "admin", "admin.cadi@fatec.sp.gov.br", new PasswordEncrypt("admin").getPasswordEncoder());
		  	cadiAdmin.setAdmin(true);
		  	cadiAdmin.setAtivo(true);
			mongoTemplate.save(cadiAdmin);
	  }

	  
	  @Profile("prod")
	  @ChangeSet(order = "001", id = "prof_default_admin", author = "prod", systemVersion = "prod:0.0.1")
	  public void cadInitProfessorAdminProd(MongoTemplate mongoTemplate){
		  DocumentProfessor professorAdmin = new DocumentProfessor(null, "admin", "admin.professor@fatec.sp.gov.br", new PasswordEncrypt("admin").getPasswordEncoder());
		  professorAdmin.setAdmin(true);
		  professorAdmin.setAtivo(true);
		  mongoTemplate.save(professorAdmin);
	  }



}
