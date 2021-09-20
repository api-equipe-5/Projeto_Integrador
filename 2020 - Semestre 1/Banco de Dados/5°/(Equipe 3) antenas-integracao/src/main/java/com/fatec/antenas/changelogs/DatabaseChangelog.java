package com.fatec.antenas.changelogs;

import org.omg.CORBA.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.SpringMongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.DB;

@ChangeLog(order = "001")
public class DatabaseChangelog {
	@ChangeSet(order = "001", id = "someChangeId", author = "testAuthor")
	  public void importantWorkToDo(DB db){
	     // task implementation
	  }
	
}
