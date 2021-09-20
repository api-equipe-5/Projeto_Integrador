package aluno.hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;

import spark.Request;
import spark.Response;
import spark.Route;

import antena.utils.*;;

public class ControllerAluno {

	private ModelAluno model;

	public ControllerAluno(ModelAluno model) {
		super();
		this.model = model;
	}


	//Login com token de autenticacao
	public void loginAluno() { 
		post("/aluno", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				try {
					response.header("Access-Control-Allow-Origin", "*");
					// set
		
					JSONObject jsonLogin = new JSONObject(request.body());
					//Nao colocar Jwt no projeto que ser� integrado
					Jwt autorProjeto = new Jwt();

					// try to find user
					Document aluno = model.procurarEmail(jsonLogin.getString("email")); 
					String email = aluno.getString("email");
					String senhaDigitada = jsonLogin.getString("senha");
					String senhaArmazenada = aluno.getString("senha");
					boolean usuarioAtivo = aluno.getBoolean("ativo"); //So implementar apos inserir o email service. E Inserir condicao de usuario ativo no if abaixo

					if (email.length() > 0 && senhaDigitada.equals(senhaArmazenada) && usuarioAtivo) {
						response.status(200);
						return autorProjeto.GenerateJwt(email);
					}
					response.status(403);
					return "Usu�rio inexistente ou inativo";

				}catch (JSONException ex) {
					return "erro 500 " + ex;
				}
			}
		});
	}
	
	public void validaAluno() { // Verifica se o usuário está autenticado
		post("/valida-aluno", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {

				try {
					// setting
					JSONObject myjson = new JSONObject(request.body());
					Jwt AuthEngine = new Jwt();

					// try to find user
					String emailOrNull = AuthEngine.verifyJwt((myjson.getString("token")));
					if(emailOrNull == null) {
						response.status(404);
						return false;
					}
					else {

						Document empresario = model.procurarEmail(emailOrNull);

						if (empresario == null) {
							response.status(404);
							return false;
						}

						response.status(200);
						return empresario.toJson();
					}

				} catch (JSONException ex) {
					return false;
				}
			}
		});
	}
	
	
	public void ativarUsuario() { //Link de ativacao do cadastro por email
		get("/active/aluno/:email", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				String email = new String(Base64.getDecoder().decode ( request.params("email")  )) ;
				Document found = model.procurarEmail(email);
				found.replace("ativo", true);
				model.updateAluno(found);
				if (!found.isEmpty()) {
					response.redirect("/aluno"); //8081
				}

				return null;
			}
		});
	}
	
	public void atribuirProjeto() {
		post("/add-projeto", (Request request, Response response) -> {
			
			response.header("Access-Control-Allow-Origin", "*");
			Document json = Document.parse(request.body());
			//System.out.println("test-4");
			
			try {
				Document retorno = model.updateProjeto(json);
				if(retorno!=null) return retorno;
				else return false;

			} catch (NullPointerException e) {
				return null;
			}
		});
	}
	public void cadastroAluno() {

		post("/aluno-cadastro", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				try {
						response.header("Access-Control-Allow-Origin", "*");
						String jsonString = request.body();
						Document dadosAluno = Document.parse(jsonString);

						dadosAluno.append("ativo", false);

						Document encontrado = model.procurarEmail(dadosAluno.getString("email"));
						
						if (encontrado == null || encontrado.isEmpty()) {
							model.addAluno(dadosAluno);
							new emailService(dadosAluno).sendSimpleEmail("Antenas - Sua confirma��o de conta", "Por favor, para confirmar sua conta, clique no link:", "aluno");
							return dadosAluno.toJson();
						}else {
							return "Email ja cadastrado!";
						}
				}catch (JSONException ex) {
					return "erro 500 " + ex;
				}
			}
		});
	}
	public void projetos() {
		get("/projetos", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {

				FindIterable<Document> projectsFound = model.listaProjetos();

				return StreamSupport.stream(projectsFound.spliterator(), false).map(Document::toJson)
						.collect(Collectors.joining(", ", "[", "]"));
			}
		});
	}

	public void search() {
		get("/searchaluno/:id", (request, response) -> {
			return model.search(request.params(":id"));
		});

		get("/dono/:email", (request, response) -> {
			String ret = model.buscaPorDono(request.params(":email"));
			return ret;
		});

		get("/semdono", (request, response) -> {
			return model.buscaSemDono();
		});
		
		get("/putAluno", (request, response) -> {
			return model.atribuirAluno(request.queryParams("emailProf"), request.queryParams("_id"));
		});
		
		get("/put", (request, response) -> {
			return model.atribuir(request.queryParams("emailAluno"), request.queryParams("_id"));
		});

	}

	public void alterarId() {
		post("/alterarId", (req, res) -> {
			model.alterarId(req.queryParams("id"), new Document("$set", Document.parse(req.body())));
			return model.listAlunos();
		});
	}

	public void listAlunos() {
		get("/listarAlunos", (req, res) -> {
			return model.listAlunos();
		});
	}
	
	public void entregaProjeto() {
		post("/entregar", (req, res) -> {
			System.out.println("test");
			Document project = Document.parse(req.body());
			System.out.println(project);
			String id = project.getString("id");
			String alunos = project.getString("autores");
			String descricao = project.getString("descricao");
			String linkGitHub = project.getString("link");
			Document now = model.getProject(id);
			return model.submitProject(id, now, alunos, descricao, linkGitHub);
		});
	}	
	
}
