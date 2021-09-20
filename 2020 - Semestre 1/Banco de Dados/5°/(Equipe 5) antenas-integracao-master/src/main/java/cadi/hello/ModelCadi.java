package cadi.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.mongodb.MongoClient;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;

public class ModelCadi {

//	mongoClient mongoClient = new mongoClient("app");
	MongoClient mongoClient = new MongoClient( "165.227.80.192" );
	MongoDatabase db = mongoClient.getDatabase("app");

	public String search(String chave, String valor) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> projects = db.getCollection("projeto");
		FindIterable<Document> found = projects.find(new Document(chave, valor));
		String foundJson = StreamSupport.stream(found.spliterator(), false).map(Document::toJson)
				.collect(Collectors.joining(", ", "[", "]"));
		return foundJson;
	}
	public String searchUsuario(String chave, String valor) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> projects = db.getCollection("cadi");
		FindIterable<Document> found = projects.find(new Document(chave, valor));
		String foundJson = StreamSupport.stream(found.spliterator(), false).map(Document::toJson)
				.collect(Collectors.joining(", ", "[", "]"));
		return foundJson;
	}
	
	public Document searchEmpresario(String email) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> empresarios = db.getCollection("empresario");
		Document found = empresarios.find(new Document("email", email)).first();
		return found;
	}
	
	public String buscaPorDono(String email) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> projetos = db.getCollection("projeto");
		FindIterable<Document> found = projetos.find(new Document("responsavel-cadi", email));
		String foundJson = StreamSupport.stream(found.spliterator(), false).map(Document::toJson)
				.collect(Collectors.joining(", ", "[", "]"));
		return foundJson;
	}
	
	public String buscaSemDono() {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> projects = db.getCollection("projeto");
		FindIterable<Document> found = projects.find(new Document("responsavel-cadi", ""));
		String foundJson = StreamSupport.stream(found.spliterator(), false).map(Document::toJson)
				.collect(Collectors.joining(", ", "[", "]"));
		return foundJson;
	}

	public void addCADI(Document doc) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> researches = db.getCollection("cadi");
		researches.insertOne(doc);
	}

	public void addProjeto(Document doc) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> projeto = db.getCollection("projeto");
		projeto.insertOne(doc);
	}

	public void addProfessores(Document doc) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> professor = db.getCollection("professor");
		professor.insertOne(doc);
	}

	public Document login(String email, String senha) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> cadi = db.getCollection("cadi");
		Document found = cadi.find(new Document("email", email).append("senha", senha)).first();
		return found;
	}
	
	public Document ativarCadi(String email) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> cadis = db.getCollection("cadi");
		Document cadi = searchByEmail(email);
		cadi.replace("ativo", true);
		return updateCadi(cadi);
	}

	
	public Document searchByEmail(String email) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> cadi = db.getCollection("cadi");
		Document found = cadi.find(new Document("email", email)).first();
		return found;
	}

	public String listaProjetos() {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> projetos = db.getCollection("projeto");
		FindIterable<Document> found = projetos.find();
		String foundJson = StreamSupport.stream(found.spliterator(), false).map(Document::toJson)
				.collect(Collectors.joining(", ", "[", "]"));
		return foundJson;
	}

	
	public List<String> listCadi() {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> cadiF = db.getCollection("cadi");
		FindIterable<Document> cadi= cadiF.find();
		List<String> listCadi = new ArrayList<String>();
		for(Document proj:cadi) {
			listCadi.add(proj.toJson());
		}
		return listCadi;
	}
	
	//test profs
	public String listProf() {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> prof = db.getCollection("professor");
		FindIterable<Document> found = prof.find();
		String foundJson = StreamSupport.stream(found.spliterator(), false).map(Document::toJson)
				.collect(Collectors.joining(", ", "[", "]"));
		return foundJson;
	}

	public void alterarId (String id, Document alteracao){
		Document filter = new Document("id", id);
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> cadiF = db.getCollection("cadi");
		cadiF.updateOne(filter, alteracao);
	}
	
	public void addReuniao(Document doc) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> reuniao = db.getCollection("reuniao");
		reuniao.insertOne(doc);
	}
	
	/*Update*/
	public Document updateProjeto(Document projeto) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> projetos = db.getCollection("projeto");
		BasicDBObject query = new BasicDBObject();
		query.append("_id", projeto.get("_id"));
		Bson newDocument = new Document("$set", projeto);
		return projetos.findOneAndUpdate(query, newDocument, (new FindOneAndUpdateOptions()).upsert(true));
	}
	
	public Document updateCadi(Document projeto) {
		MongoDatabase db = mongoClient.getDatabase("app");
		MongoCollection<Document> projetos = db.getCollection("cadi");
		BasicDBObject query = new BasicDBObject();
		query.append("_id", projeto.get("_id"));
		Bson newDocument = new Document("$set", projeto);
		return projetos.findOneAndUpdate(query, newDocument, (new FindOneAndUpdateOptions()).upsert(true));
	}

}
