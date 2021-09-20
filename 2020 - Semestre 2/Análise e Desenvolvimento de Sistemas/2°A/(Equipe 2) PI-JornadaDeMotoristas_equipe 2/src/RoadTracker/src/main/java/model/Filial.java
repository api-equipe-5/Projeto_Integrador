package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import view.Filiais;

@Entity
@Table(name="filiais")
public class Filial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	/* @Column(name="id_filial") */
	private Integer id;
	@Column(length=50)
	private String nome;
	@Column(length=50)
	private String cidade;
	@Column(length=2)
	private String estado;
	@Column(length=19)
	private String cnpj;
	@Column(length=14)
	private String rntrc;
	@Column(columnDefinition="TEXT")
	private String metadados = "FncAss:0 "
			+ "VeiAss:0 ";
	
	//uma filial possui um ou mais funcionarios
	@OneToMany(mappedBy = "filial") //nome do campo na tabela filha
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRntrc() {
		return rntrc;
	}
	public void setRntrc(String rntrc) {
		this.rntrc = rntrc;
	}
	
	public String getMetadados() {
		return metadados;
	}
	public void setMetadados(String metadados) {
		this.metadados = metadados;
	}
	public void cadastrarFilial(String nome, String cidade, String estado, String cnpj, String rntrc) {

		EntityManager con = new ConnectionFactory().getConnection();
		
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.setRntrc(rntrc);
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao cadastrar a filial. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	public void alterarDadosFilial(String novoNome, String novaCidade, String novoEstado, String novoCnpj, String novoRntrc, int id) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.id = id;
		this.cidade = novaCidade;
		this.estado = novoEstado;
		this.nome = novoNome;
		this.cnpj = novoCnpj;
		this.rntrc = novoRntrc;
				
		
		try {
			con.getTransaction().begin();
			con.merge(this);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	
	public boolean excluirFilial(Integer id) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		Filial filial = null;
		
		try {
			filial = con.find(model.Filial.class, id);		
			
			con.getTransaction().begin();
			con.remove(filial);
			con.getTransaction().commit();
			return true;
		}
		catch (Exception e) {
			con.getTransaction().rollback();
			return false;
		}
		finally {
			con.close();
		}
		
	}
	
	public List<Filial> consultarTodasFiliais(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Filial> filiais = null;
		try {
			filiais = con.createQuery("from Filial f").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return filiais;
	}
	
	public List<Filiais> listarFiliais(){	
		List<Filiais> lista = new ArrayList<>();
		for (Filial f: this.consultarTodasFiliais()) {
			Filiais filiais = new Filiais(f.getId(), f.getNome(), f.getEstado());
			lista.add(filiais);
		}
		
		return lista;
		
	}
	
	public Filial encontrarFilial(int id){
		
		EntityManager con = new ConnectionFactory().getConnection();

		Filial filial = null;

		try {
			filial = con.find(model.Filial.class, id);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return filial;
	}
	
	public Map<String, String> dadosFilial(){
		Map<String, String> dicionarioDeDados = new HashMap<String, String>();
		
		dicionarioDeDados.put("CNPJ", this.getCnpj());
		dicionarioDeDados.put("Nome", this.getNome());
		dicionarioDeDados.put("RNTRC", this.getRntrc());
		dicionarioDeDados.put("Estado", this.getEstado());
		dicionarioDeDados.put("Cidade", this.getCidade());
		
		return dicionarioDeDados;
	}
	
	public String[][] obterDicionarioMetadados() {
		String[][] dic = {{"FncAss", "Funcionários associados"},
				          {"VeiAss", "Veículos associados"}};

		return dic;
	}
	
	
	/**FncAss, VeiAss
	 * 
	 * @param metadado
	 */
	public void incrementarMetadados(String metadado) {
		String[] metadados = this.metadados.split(" ");
		
		for(int i = 0; i < metadados.length; i++) {
			if(metadados[i].contains(metadado)) {
				metadados[i] = metadados[i].substring(0, 6) + ":" + String.valueOf(Integer.parseInt(metadados[i].substring(7)) + 1);
			}
		}
		
		
		String reconstruir = "";
		for(int i = 0; i < metadados.length; i++) {
			reconstruir += metadados[i] + " ";
		}
		
		this.metadados = reconstruir;
		
		EntityManager con = new ConnectionFactory().getConnection();
		
		try {
			con.getTransaction().begin();
			con.merge(this);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
}
