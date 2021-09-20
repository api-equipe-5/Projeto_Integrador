package professor.hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;

import antena.utils.*;
import spark.Request;
import spark.Response;
import spark.Route;

public class ControllerProfessor {

	private ModelProfessor model;
	private String WhoIsauth;

	public ControllerProfessor(ModelProfessor model) {
		super();
		this.model = model;
	}
	
	public String getWhoIsauth() {
		return WhoIsauth;
	}

	public void setWhoIsauth(String whoIsauth) {
		WhoIsauth = whoIsauth;
	}
	
	public void Auth() { // Gera um token de autentica��o para o usu�rio
		post("/Auth", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {

				try {
					response.header("Access-Control-Allow-Origin", "*");

					// set
					JSONObject myjson = new JSONObject(request.body());
					Jwt AuthEngine = new Jwt();
					
					// try to find user
					Document user = model.searchByEmail(myjson.getString("email"));

					String email = user.getString("email");
					String senhaDigitada = myjson.getString("senha");
					String senhaArmazenada = user.getString("senha");
					boolean usuarioAtivo = user.getBoolean("ativo");

					if (email.length() > 0 && senhaDigitada.equals(senhaArmazenada) && usuarioAtivo) {
						response.status(200);
						return AuthEngine.GenerateJwt(email);
					}
					response.status(403);
					return "Usu�rio inexistente ou inativo";

				} catch (JSONException ex) {
					return "erro 500 " + ex;
				}
			}
		});
	}
	
	public boolean IsAuth(String body) { // Verifica se o usu�rio est� autenticado
		try {
			// setting
			JSONObject myjson = new JSONObject(body);
			Jwt AuthEngine = new Jwt();

			// try to find user
			String emailOrNull = AuthEngine.verifyJwt((myjson.getString("token")));

			if(emailOrNull == null) {
				return false;
			}else {
				setWhoIsauth(emailOrNull);
				return true;
			}

		} catch (JSONException ex) {
			return false;
		}
	}
	
	
	public void ativarUsuario() { // � chamado quando o usuario recebe o link de ativa��o no email
		get("/active/professor/:email", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				String email = new String(Base64.getDecoder().decode ( request.params("email")  )) ;
				Document found = model.ativarProfessor(email);
				if (!found.isEmpty()) {
					response.redirect("http://localhost:8081/professor/index.html");
				}
				return null;
			}
		});
	}

	public void loginProfessor() {
		post("/professor", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				response.header("Access-Control_Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());
				String email = json.getString("email");
				String senha = json.getString("senha");
				try {
					Document professor = model.login(email, senha);
					
					if ((Boolean)professor.get("ativo")==true){
						return professor.toJson();
					}
					return null;
				} catch (NullPointerException e) {
					return null;
				}

			}
		});
	}
	public void updateProjetoProfessor() {
		post("/updateProjetoProfessor", (Request request, Response response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			model.updateProjeto(Document.parse(request.body()));
			
			return request.body();
		});
	}
	public void inserirProfessor() {

		post("/professorcadastro", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				try {
					response.header("Access-Control-Allow-Origin", "*");
					String jsonString = request.body();
					Document userData = Document.parse(jsonString);

					userData.append("ativo", false);

					Document found = model.searchByEmail(userData.getString("email"));

					if (found == null || found.isEmpty()) {
						model.addProfessor(userData);
						new emailService(userData).sendSimpleEmail("Antenas - Sua confirmação de conta", "Por favor, para confirmar sua conta, clique no link: ", "professor");
						return userData.toJson();
					} else {
						return "Email j� cadastrado";
					}
				} catch (Exception ex) {
					return "erro 500 " + ex;
				}
			}
		});
		
	}

	public void atualizaProfessor() {
		post("/updateProfessor", (Request request, Response response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			JSONObject json = new JSONObject(request.body());
			model.updateProfessor(Document.parse(request.body()));
			return json;
		});
	}
	public void searchprofessor() {
		post("/professorLogado", (request, response) -> {
			JSONObject json = new JSONObject(request.body());
			String email = json.getString("email");
			return model.searchByEmail(email).toJson();
		});
		
		/*restornar meus projetos que fa�o parte*/
		get("/myprojects", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				String email = request.queryString();
				ArrayList<Document> projectFound = model.myProjects(new Document("email", email));
				return StreamSupport.stream(projectFound.spliterator(), false)
						.map(Document::toJson)
						.collect(Collectors.joining(", ", "[", "]"));
			}
		});
		
	}
	
}
