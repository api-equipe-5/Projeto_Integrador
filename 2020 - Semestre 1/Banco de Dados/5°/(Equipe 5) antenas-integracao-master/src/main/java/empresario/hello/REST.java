package empresario.hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.*;
import com.mongodb.client.FindIterable;

import antena.utils.Jwt;
import antena.utils.emailService;

import org.bson.Document;
import spark.Request;
import spark.Response;
import spark.Route;

public class REST {

	private Model model;
	private String WhoIsauth;

	public REST(Model store) {
		model = store;
	}

	public String getWhoIsauth() {
		return WhoIsauth;
	}

	public void setWhoIsauth(String whoIsauth) {
		WhoIsauth = whoIsauth;
	}
	
	public void Auth() { // Gera um token de autenticação para o usuário
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
					return "Usuário inexistente ou inativo";

				} catch (JSONException ex) {
					return "erro 500 " + ex;
				}
			}
		});
	}
	
	public void IsAuth() { // Verifica se o usuário está autenticado
		post("/is-auth", new Route() {
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

						Document empresario = model.searchByEmail(emailOrNull);

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

	public void cadastroEmpresario() { // Cadastra um novo usuario
		post("/cadastroempresario", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				try {
					response.header("Access-Control-Allow-Origin", "*");
					String jsonString = request.body();
					Document userData = Document.parse(jsonString);

					userData.append("ativo", false);

					Document found = model.searchByEmail(userData.getString("email"));

					if (found == null || found.isEmpty()) {
						model.addEmpresario(userData);
						new emailService(userData).sendSimpleEmail("Antenas - Sua confirmação de conta", "Por favor, para confirmar sua conta, clique no link: ", "empresario");
						return userData.toJson();
					} else {
						return "Email já cadastrado";
					}
				} catch (JSONException ex) {
					return "erro 500 " + ex;
				}
			}
		});
	}

	public void cadastroProjeto() { // Cadastra um novo projeto
		post("/cadastroprojeto", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				try {
					response.header("Access-Control-Allow-Origin", "*");
					String jsonString = request.body();

					Document project = Document.parse(jsonString);
					model.addProjeto(project);
					
					return project.toJson();
				} catch (JSONException ex) {
					return "erro 500 " + ex;
				}
			}
		});
	}
	
	public void deletaProjeto() { // Apaga um projeto
		post("/deletaProjeto", new Route() {
			@Override
			public Boolean handle(final Request request, final Response response) {
				try {
					response.header("Access-Control-Allow-Origin", "*");
					return model.deleteProject( Document.parse( request.body() ) ).getDeletedCount() > 0;

				}catch(Exception ex){ throw ex; }
			}
		});
	}

	public void atualizaProjeto() { // Atualiza um projeto
		post("/atualizaProjeto", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				try {
					response.header("Access-Control-Allow-Origin", "*");
					return model.updateProjeto(Document.parse( request.body() )) == null? "projeto n�o encontrado": "projeto deletado";
				}catch(Exception ex) { throw ex; }
			}
		});
	}

	public void getProjetos() { // Lista os projetos
		get("/projetos", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				 FindIterable<Document> projectsFound = model.getAllProjetos();

				 return StreamSupport.stream(projectsFound.spliterator(), false)
			        .map(Document::toJson)
			        .collect(Collectors.joining(", ", "[", "]"));
			}
		});
	}

	public void getEmpresarios() { // Lista os empresarios
		get("/empresarios", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				 FindIterable<Document> empresariosFound = model.getAllEmpresarios();

				 return StreamSupport.stream(empresariosFound.spliterator(), false)
			        .map(Document::toJson)
			        .collect(Collectors.joining(", ", "[", "]"));
			}
		});
	}

    public void loginEmpresario() { // Faz requisição de login
        post("/loginempresario", new Route() {
            @Override
            public Object handle(final Request request, final Response response) {
				String jsonString = request.body();
				JSONObject jsonobj =  new JSONObject(jsonString);
				Document found = model.searchByEmail(jsonobj.getString("email"));

				if (found == null) {
					response.status(404);
					return null;
				}
				else {
					response.status(200);
					return found.toJson();
				}
            }
        });
    }

    public void ativarUsuario() { // é chamado quando o usuario recebe o link de ativação no email
		get("/active/empresario/:email", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				String email = new String(Base64.getDecoder().decode ( request.params("email")  )) ;
				Document found = model.searchByEmail(email);
				found.replace("ativo", true);
				model.updateEmpresario(found);
				if (!found.isEmpty()) {
					response.redirect("http://localhost:8081/");
				}

				return null;
			}
		});
	}

    public void getProjectByEmpresario() { // Lista os projetos do empresario
		get("/buscaprojetoporempresario", new Route() {
			@Override
			public Object handle(final Request request, final Response response) {
				String email = request.queryString();
				FindIterable<Document> projectFound = model.getProjectByEmpresario(email);
				return StreamSupport.stream(projectFound.spliterator(), false)
						.map(Document::toJson)
						.collect(Collectors.joining(", ", "[", "]"));
			}
		});
	}
}
