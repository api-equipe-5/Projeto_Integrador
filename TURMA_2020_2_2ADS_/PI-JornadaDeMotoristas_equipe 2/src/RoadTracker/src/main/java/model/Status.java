package model;

import java.util.Date;

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

@Entity
@Table(name="status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(length=20)
	private String tipo;
	@Column(length=10)
	private String inicio;
	@Column(length=10)
	private String fim;
	@Column(length=8)
	private String total;

	
	//um ou mais status pertence a um funcionário
	@ManyToOne
	@JoinColumn(name = "motorista", nullable = false, foreignKey = @ForeignKey(name = "fk_motoristas_cpf")) //coluna da tabela pai
	private Motorista motorista = new Motorista();
	
	//um ou mais status pertence a uma viagem
	@ManyToOne
	@JoinColumn(name = "viagem", nullable = false, foreignKey = @ForeignKey(name = "fk_viagens_id")) //coluna da tabela pai
	private Viagem viagem = new Viagem();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Viagem getViagem() {
		return viagem;
	}
	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}
	
	// aqui o parâmetro tipo deve depender do botão acionado
	public void enviarStatus(String inicio, String fim, String tipo, String total, String cpfMotorista, String idViagem) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		Date dia = new Date();
		int hora = dia.getHours();
		int minutos = dia.getMinutes();
		int segundos = dia.getSeconds();
		String data = Integer.toString(hora) + ":" + Integer.toString(minutos) + ":" + Integer.toString(segundos);
		this.setInicio(data);
		
		this.setTipo(tipo); // isso é setado de acordo com o botão
		this.setFim("A declarar"); //acho que isso é setado só depois né
		this.setTotal("A declarar"); //acho que isso é setado só depois né
		
		motorista.setCpf(cpfMotorista);
		this.setMotorista(motorista);
		
		viagem.setId(Integer.parseInt(idViagem));
		this.setViagem(viagem);
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema ao enviar o status. Tente novamente.\nErro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
		
	}
	
}
