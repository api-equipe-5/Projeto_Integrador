package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import view.Avisos;

@Entity
@Table(name="avisos")
public class Aviso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(columnDefinition="TEXT")
	private String mensagem;
	private boolean resolvido;
	@Column(length=15)
	private String data;
	@Column(length=40)
	private String nomenclatura;
	@Column(length=14)
	private String emissor;
	
	//um ou mais avisos correspondem a um funcionario
//	@ManyToOne
//	@JoinColumn(name = "funcionario", nullable = false, foreignKey = @ForeignKey(name = "fk_funcionarios_cpf")) //coluna da tabela pai
//	private Funcionario funcionario = new Funcionario();
	
	//um ou mais avisos correspondem a um funcionario
	@ManyToOne
	@JoinColumn(name = "motorista", nullable = true, foreignKey = @ForeignKey(name = "fk_motoristas_cpf")) //coluna da tabela pai
	private Motorista motorista = new Motorista();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public String getEmissor() {
		return emissor;
	}
	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}
	public boolean isResolvido() {
		return resolvido;
	}
	public String getNomenclatura() {
		return nomenclatura;
	}
	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}
	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
	
	public boolean cadastrarAviso(String funcionario_destino, String cpfMotorista, String mensagem, String nomenclatura, boolean resolvido) {
			EntityManager con = new ConnectionFactory().getConnection();
			
			Motorista motorista = new Motorista();
				
			LocalDate hoje = LocalDate.now();
	    	int ano = hoje.getYear();
	    	int dia = hoje.getDayOfMonth();
	    	int mes = hoje.getMonthValue();
	    	
	    	String diaCerto = "";
	    	if (dia >= 1 && dia < 10) {
	    		diaCerto = '0' + String.valueOf(dia);
	    	}
	    	else {
	    		diaCerto = String.valueOf(dia);
	    	}
	    	
	    	String data = (diaCerto + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
			this.setData(data);
			
			this.setMensagem(mensagem);
			this.setResolvido(resolvido); // não vou mandar uma coisa já resolvida (foi dada a opção, então é melhor mandar).
			
			this.setNomenclatura(nomenclatura + cpfMotorista);
			
			motorista.setCpf(cpfMotorista);
			this.setMotorista(motorista);
			this.setEmissor(cpfMotorista);
			
			try {
				con.getTransaction().begin();
				con.persist(this);
				con.getTransaction().commit();
				return true;
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um problema ao enviar o aviso. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
				con.getTransaction().rollback();
			}
			finally {
				con.close();
			}
			return false;
		}
	
	
	public Aviso excluirAviso(int id) {
		EntityManager con = new ConnectionFactory().getConnection();

		Aviso aviso = null;

		try {
			aviso = con.find(model.Aviso.class, id);		

			con.getTransaction().begin();
			con.remove(aviso);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return aviso;
	}
	
	public List<Aviso> consultarTodosAvisos(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Aviso> avisos = null;
		try {
			avisos = con.createQuery("from Aviso a").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return avisos;
	}
	
	public List<Avisos> listarAvisos(){	
		List<Avisos> lista = new ArrayList<>();
		for (Aviso a: this.consultarTodosAvisos()) {
			Avisos aviso = new Avisos();
			aviso.setTituloAviso(a.getMensagem());
			aviso.setDataAviso(a.getData());
			aviso.setId(a.getId());
			
			try {
				aviso.setMotorista(a.getMotorista().getCpf());
			}catch (Exception erro){
				aviso.setMotorista(a.getEmissor());
			}

			
			lista.add(aviso);
		}
		
		return lista;
		
	}
	
	public Aviso encontrarAviso(int id){
		
		EntityManager con = new ConnectionFactory().getConnection();

		Aviso aviso = null;

		try {
			aviso = con.find(model.Aviso.class, id);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return aviso;
	}
	
	
	public boolean solicitarCadastro(String cpfEmissor, String mensagem) {
		EntityManager con = new ConnectionFactory().getConnection();
			
		LocalDate hoje = LocalDate.now();
    	int ano = hoje.getYear();
    	int dia = hoje.getDayOfMonth();
    	int mes = hoje.getMonthValue();
    	
    	String diaCerto = "";
    	if (dia >= 1 && dia < 10) {
    		diaCerto = '0' + String.valueOf(dia);
    	}
    	else {
    		diaCerto = String.valueOf(dia);
    	}
    	
    	String data = (diaCerto + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
    	
		this.setData(data);
		
		this.setMensagem(mensagem);
		this.setResolvido(false); // não vou mandar uma coisa já resolvida
		
		this.setNomenclatura("Registro");
		this.setMotorista(null);
		this.setEmissor(cpfEmissor);
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao enviar o aviso. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		return false;
	}
	
	public Map<String, String> dadosAviso(){
		Map<String, String> dicionarioDeDados = new HashMap<String, String>();
		
		dicionarioDeDados.put("Mensagem", this.getMensagem());
		dicionarioDeDados.put("Data", this.getData());
		dicionarioDeDados.put("ID", String.valueOf(this.getId()));
		dicionarioDeDados.put("Emissor", this.getEmissor());
		dicionarioDeDados.put("Código", this.getNomenclatura());
		
		return dicionarioDeDados;
	}
	
}
