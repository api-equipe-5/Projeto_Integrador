package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import control.ComparadorDeId;
import view.Registros;

@Entity
@Table(name="logs")
public class Logs {
	
	// Declarando as váriaveis
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(length=15)
	private String data;
	
	@Column(columnDefinition="TEXT")
	private String registro;
	
	@Column(length=10)
	private String horario;
	
	@Column(length=20)
	private String cpfEmissor;
	
	@Column(length=50)
	private String nomeEmissor;

	
	
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCpfEmissor() {
		return cpfEmissor;
	}

	public void setCpfEmissor(String cpfEmissor) {
		this.cpfEmissor = cpfEmissor;
	}

	public String getNomeEmissor() {
		return nomeEmissor;
	}

	public void setNomeEmissor(String nomeEmissor) {
		this.nomeEmissor = nomeEmissor;
	}

	
	
	
	public void registrarLog(String nome, String cpf, String registro) {
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
    	
    	String horario = String.valueOf(Calendar.HOUR_OF_DAY) + ":" + String.valueOf(Calendar.MINUTE) + ":" + String.valueOf(Calendar.SECOND);
    	
    	this.setHorario(horario);
    	
		this.setCpfEmissor(cpf);
		this.setNomeEmissor(nome);
		
		
		this.setData(data);
		this.setRegistro(registro);
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao registrar o log. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
	}
	
	public Logs encontrarLog(int id) {
		EntityManager con = new ConnectionFactory().getConnection();

		Logs log  = null;

		try {
			log = con.find(model.Logs.class, id);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return log;
	}
	
	public List<Logs> consultarLogs(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Logs> filiais = null;
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
	
	public List<Logs> consultarTodosLogs(){
		EntityManager con = new ConnectionFactory().getConnection();
		List<Logs> logs = null;
		try {
			logs = con.createQuery("from Logs l").getResultList();
			logs.sort(new ComparadorDeId());
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return logs;
	}
	
	public List<Registros> listarLogs(){	
		List<Registros> logsArmazenados = new ArrayList<>();
		for (Logs l: this.consultarTodosLogs()) {
			Registros registro = new Registros(l.getNomeEmissor(), l.getCpfEmissor(), l.getData(), l.getRegistro(), l.getId());
			logsArmazenados.add(registro);
		}
		
		return logsArmazenados;
		
	}
	
}
