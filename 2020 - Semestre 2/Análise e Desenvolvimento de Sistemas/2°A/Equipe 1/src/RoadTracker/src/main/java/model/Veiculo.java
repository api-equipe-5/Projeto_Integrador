package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import view.Veiculos;

@Entity
@Table(name="veiculos")
public class Veiculo {
	
	@Id
	@Column(length=8)
	private String placa;
	@Column(length=20)
	private String modelo_veiculo;
	@Column(length=20)
	private int id_rastreador;
	@Column(length=20)
	private String marca_rastreador;
	@Column(length=20)
	private String modelo_rastreador;

	@ManyToOne
	@JoinColumn(name = "filiais", nullable = false, foreignKey = @ForeignKey(name = "fk_filiais_id"))
	private Filial filial = new Filial();
	@OneToMany(mappedBy = "veiculo")
	private List<Viagem> viagens = new ArrayList<Viagem>();
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo_veiculo() {
		return modelo_veiculo;
	}

	public void setModelo_veiculo(String modelo_veiculo) {
		this.modelo_veiculo = modelo_veiculo;
	}

	public int getId_rastreador() {
		return id_rastreador;
	}

	public void setId_rastreador(int id_rastreador) {
		this.id_rastreador = id_rastreador;
	}

	public String getMarca_rastreador() {
		return marca_rastreador;
	}

	public void setMarca_rastreador(String marca_rastreador) {
		this.marca_rastreador = marca_rastreador;
	}

	public String getModelo_rastreador() {
		return modelo_rastreador;
	}

	public void setModelo_rastreador(String modelo_rastreador) {
		this.modelo_rastreador = modelo_rastreador;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}

	
	
	
	public void cadastrarVeiculo(String placa, String modelo_veiculo, String id_rastreador, String marca_rastreador, String modelo_rastreador, int idFilial){
		int idRastreador;
		idRastreador = Integer.parseInt(id_rastreador);
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.setPlaca(placa);
		this.setModelo_veiculo(modelo_veiculo);
		this.setId_rastreador(idRastreador);
		this.setMarca_rastreador(marca_rastreador);
		this.setModelo_rastreador(modelo_rastreador);
		
		filial.setId(idFilial);
		this.setFilial(filial);

		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
	}
	
	public void alterarDadosVeiculo(String placa, String modelo_veiculo, String id_rastreador, String marca_rastreador, String modelo_rastreador, int idFilial) {
		int idRastreador;
		idRastreador = Integer.parseInt(id_rastreador);
		
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.placa = placa;
		this.modelo_veiculo = modelo_veiculo;
		this.id_rastreador = idRastreador;
		this.marca_rastreador = marca_rastreador;
		this.modelo_rastreador = modelo_rastreador;
		filial.setId(idFilial);
		this.setFilial(filial);
		
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
	
	public boolean excluirVeiculo(String placa) {
		EntityManager con = new ConnectionFactory().getConnection();
		Veiculo veiculo = null;
		
		try {
			veiculo = con.find(model.Veiculo.class, placa);		
			
			con.getTransaction().begin();
			con.remove(veiculo);
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
	
	public List<Veiculo> consultarTodosVeiculos(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Veiculo> veiculos = null;
		try {
			veiculos = con.createQuery("from Veiculo v").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return veiculos;
	}
	
	public List<Veiculos> listarVeiculos(){	
		List<Veiculos> lista = new ArrayList<>();
		for (Veiculo vei: this.consultarTodosVeiculos()) {
			Veiculos veiculos = new Veiculos(vei.getId_rastreador(), vei.getPlaca());
			lista.add(veiculos);
		}
		
		return lista;
		
	}
	
	public Veiculo encontrarVeiculo(String placa){
		
		EntityManager con = new ConnectionFactory().getConnection();

		Veiculo veiculo = null;

		try {
			veiculo = con.find(model.Veiculo.class, placa);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return veiculo;
	}
	
	public Map<String, String> dadosVeiculo(){
		Map<String, String> dicionarioDeDados = new HashMap<String, String>();
		
		dicionarioDeDados.put("Placa", this.getPlaca());
		dicionarioDeDados.put("Filial", this.getFilial().getNome());
		dicionarioDeDados.put("Modelo do veículo", this.getModelo_veiculo());
		dicionarioDeDados.put("Marca do rastreador", this.getMarca_rastreador());
		dicionarioDeDados.put("Modelo do rastreador", this.getModelo_rastreador());
		dicionarioDeDados.put("ID do rastreador", String.valueOf(this.getId_rastreador()));
		
		return dicionarioDeDados;
	}
	
	
}