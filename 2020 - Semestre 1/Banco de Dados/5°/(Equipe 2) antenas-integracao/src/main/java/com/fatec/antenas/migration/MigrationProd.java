package com.fatec.antenas.migration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;



@ChangeLog
@Configuration
public class MigrationProd {
	
	
	@Bean 
	@Autowired
	public Mongock mongock(Environment environment) {

		MongoClientURI uri = new MongoClientURI(environment.getProperty("spring.data.mongodb.uri"));
		MongoClient mongoClient = new MongoClient(uri);
		String database = environment.getProperty("spring.data.mongodb.database");
		
		MongoTemplate mongoTemplete = new MongoTemplate(mongoClient, database);
		
		 return new SpringMongockBuilder(mongoTemplete, "com.fatec.antenas.migration.changeLog")
			        .setSpringEnvironment(environment)
			      .setLockQuickConfig() 
			      .setStartSystemVersion("prod:0.0.1")
			      .setEndSystemVersion("test:0.0.1")
			      .build();

	}
	
}		
