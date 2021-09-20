package cadi.hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.Base64;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;


import spark.Request;
import spark.Response;
import spark.Route;

import antena.utils.Jwt;
import antena.utils.emailService;
public class ControllerCadi {

	private ModelCadi model;
	private String WhoIsauth;

	public ControllerCadi(ModelCadi model) {
		super();
		this.model = model;
	}
	
	public String getWhoIsauth() {
		return WhoIsauth;
	}

	public void setWhoIsauth(String whoIsauth) {
		WhoIsauth = whoIsauth;
	}
	
	public void Auth() { // Gera um token de autenticacaoo para o usuario
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
					return "Usuario inexistente ou inativo";

				} catch (JSONException ex) {
					return "erro 500 " + ex;
				}
			}
		});
	}
	
	public boolean IsAuth(String body) { // Verifica se o usuario esta autenticado
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
	
	public void ativarUsuario() { // chamado quando o usuario recebe o link de ativacao no email
		get("/active/cadi/:email", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				String email = new String(Base64.getDecoder().decode ( request.params("email")  )) ;
				Document found = model.ativarCadi(email);
				if (!found.isEmpty()) {
					response.redirect("http://localhost:8081/cadi/index.html");
				}
				return null;
			}
		});
	}
	
	public void loginCadi() {
		post("/cadi", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				response.header("Access-Control_Allow-Origin", "*");
				JSONObject json = new JSONObject(request.body());
				String email = json.getString("email");
				String senha = json.getString("senha");
				try {
					Document cadi = model.login(email, senha);

					if ((Boolean)cadi.get("ativo")==true){
						return cadi.toJson();
					}
					return null;
				} catch (NullPointerException e) {
					return null;
				}

			}
		});
	}
	
	public void atribuirProjeto() {
		post("/semdono", (Request request, Response response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			JSONObject json = new JSONObject(request.body());
			model.updateProjeto(Document.parse(request.body() ));
			return model.buscaSemDono();
		});
	}

	public void inserirCADI() {

		post("/cadicadastro", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				try {
					response.header("Access-Control-Allow-Origin", "*");
					String jsonString = request.body();
					Document userData = Document.parse(jsonString);
					userData.append("ativo", false);
					Document found = model.searchByEmail(userData.getString("email"));
					if (found == null || found.isEmpty()) {
						model.addCADI(userData);
						new emailService(userData).sendSimpleEmail(
								"Antenas - Sua confirmacao de conta",
								"Por favor, para confirmar sua conta, clique no link: ",
								"cadi"
								);
						return userData.toJson();
					} else {
						return "Email ja cadastrado";
					}
				} catch (Exception ex) {
					return "erro 500 " + ex;
				}
			}
		});
	}
	
	public void atualizaCadi() {
		post("/updateCadi", (Request request, Response response) -> {

			response.header("Access-Control-Allow-Origin", "*");
			JSONObject json = new JSONObject(request.body());

			model.updateCadi(Document.parse(request.body()));
			return model.buscaSemDono();
		});
	}

	public void projetos() {
		get("/projetos", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				return model.listaProjetos();
			}
		});
	}

	public void search() {
		get("/search", (request, response) -> {
			return model.search(request.queryParams("chave"), request.queryParams("valor"));
		});
		
		get("/searchEmpresario/:email", (request, response) -> {
			return model.searchEmpresario(request.params("email")).toJson();
		});
		
		post("/usuarioLogado", (request, response) -> {
			JSONObject json = new JSONObject(request.body());
			String email = json.getString("email");
			return model.searchByEmail(email).toJson();
		});

		get("/dono", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				String email = request.queryString();
				return model.buscaPorDono(email);
			}
		});
		get("/semdono", (request, response) -> {
			return model.buscaSemDono();
		});
		
		post("/putProf", (request, response) -> {
			Document projetoComProfessor = Document.parse(request.body());
			model.updateProjeto(projetoComProfessor);
			return projetoComProfessor.toJson();
		});
		
		post("/putCadi", (request, response) -> {
			Document projetoComCadi = Document.parse(request.body());
			model.updateProjeto(projetoComCadi);
			return projetoComCadi.toJson();
		});
		
		post("/pulafase", (request, response) -> {
			Document projeto = Document.parse(request.body());
			model.updateProjeto(projeto);
			return projeto.toJson();
		});

	}
	
	public void inserirReuniao() {
		get("/reuniao", (Request request, Response response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			Document reuniao = Document.parse(request.body());
			model.addReuniao(reuniao);
			return reuniao.toJson();
		});
	}
	
	public void listCadi() {
		post("/listarCadi", (req, res) -> {
			return model.listCadi();
		});
	}
	
	public void listProf() {
		get("/listarProf", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				return model.listProf();
			}
		});
	}
}
