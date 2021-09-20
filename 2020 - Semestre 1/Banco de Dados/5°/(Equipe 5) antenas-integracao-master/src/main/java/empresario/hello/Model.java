package empresario.hello;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.result.DeleteResult;


public class Model{


	MongoClient mongoClient = new MongoClient( "165.227.80.192" );
	MongoDatabase db = mongoClient.getDatabase("app");

	public void addProjeto(Document projeto) {
		MongoCollection<Document> projetos = db.getCollection("projeto");
    	projetos.insertOne(projeto);
	}
	
	public DeleteResult deleteProject(Document project) {
		MongoCollection<Document> projectsFound = db.getCollection("projeto");
		return projectsFound.deleteOne(project);
	}
	
	public void addEmpresario(Document empresario) {
		MongoCollection<Document> empresarios = db.getCollection("empresario");
		empresarios.insertOne(empresario);
	}
	
	public Document updateProjeto(Document projeto) {
		MongoCollection<Document> projetos = db.getCollection("projeto");
    	BasicDBObject query = new BasicDBObject();
    	query.append("_id", projeto.get("_id"));
    	Bson newDocument = new Document("$set", projeto);
    	return projetos.findOneAndUpdate(query, newDocument, (new FindOneAndUpdateOptions()).upsert(true));
	}

	public Document updateEmpresario(Document empresario) {
		MongoCollection<Document> projetos = db.getCollection("empresario");
		BasicDBObject query = new BasicDBObject();
		query.append("_id", empresario.get("_id"));
		Bson newDocument = new Document("$set", empresario);
		return projetos.findOneAndUpdate(query, newDocument, (new FindOneAndUpdateOptions()).upsert(true));
	}

	public FindIterable<Document> getAllProjetos() {
		MongoCollection<Document> projetos = db.getCollection("projeto");
		FindIterable<Document> todos = projetos.find();

		for(Document projeto: todos) {
			System.out.println(projeto);
		}
		return todos;
	}

	public FindIterable<Document> getAllEmpresarios() {
		MongoCollection<Document> empresarios = db.getCollection("empresario");
		FindIterable<Document> todos = empresarios.find();

		for(Document empresario: todos) {
			System.out.println(empresario);
		}
		return todos;
	}

	public Document searchByEmail(String email) {
		MongoCollection<Document> users = db.getCollection("empresario");
    	Document found = users.find(new Document("email", email)).first();
    	return found;
    }

    public FindIterable<Document> getProjectByEmpresario(String email) {
		MongoCollection<Document> projetos = db.getCollection("projeto");
		FindIterable<Document> found = projetos.find(new Document("responsavel-empresario", email));

		return found;
	}
}
