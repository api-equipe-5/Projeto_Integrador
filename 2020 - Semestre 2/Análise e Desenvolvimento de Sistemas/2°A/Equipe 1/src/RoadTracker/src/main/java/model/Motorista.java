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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import view.Funcionarios;

@Entity
@Table(name = "motoristas")
public class Motorista {
	@Id
	@Column(length=14, nullable=false)
	private String cpf;
	@Column(length=50, nullable=false)
	private String nome;
	@Column(length=50, nullable=false)
	private String email;
	@Column(length=32, nullable=false)
	private String senha;
	@Column(length=10, nullable=false)
	private String salario;
	@Column(length=4, nullable=false)
	private String cargaHoraria;
	@Column(length=11, nullable=false)
	private String turno;
	private boolean seg;
	private boolean ter;
	private boolean qua;
	private boolean qui;
	private boolean sex;
	private boolean sab;
	private boolean dom;
	@Column(length=13)
	private String cargo;
	@Column(length=3)
	private String dia_atual;
	@Column(length=10)
	private String trabalhado_hoje;
	@Column(length=10)
	private String descansado_hoje;
	@Column(length=10)
	private String alimentacao_hoje;
	@Column(columnDefinition="TEXT")
	private String metadados = "VgmAtt:0 VgmFin:0 VgmAtr:0";
	
	// Mapeamento
	@ManyToOne
	@JoinColumn(name = "filial", nullable = false, foreignKey = @ForeignKey(name = "fk_filiais_id"))
	private Filial filial = new Filial();
	@OneToMany(mappedBy = "motorista")
	private List<Aviso> avisos = new ArrayList<Aviso>();
	@OneToMany(mappedBy = "motorista")
	private List<Status> status = new ArrayList<Status>();
	//@OneToMany(mappedBy = "funcionario")
	//private List<Viagem> viagens = new ArrayList<Viagem>();
	
	@Column(length=14)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public boolean getSeg() {
		return seg;
	}
	public void setSeg(boolean seg) {
		this.seg = seg;
	}
	public boolean getTer() {
		return ter;
	}
	public void setTer(boolean ter) {
		this.ter = ter;
	}
	public boolean getQua() {
		return qua;
	}
	public void setQua(boolean qua) {
		this.qua = qua;
	}
	public boolean getQui() {
		return qui;
	}
	public void setQui(boolean qui) {
		this.qui = qui;
	}
	public boolean getSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public boolean getSab() {
		return sab;
	}
	public void setSab(boolean sab) {
		this.sab = sab;
	}
	public boolean getDom() {
		return dom;
	}
	public void setDom(boolean dom) {
		this.dom = dom;
	}
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	public List<Aviso> getAvisos() {
		return avisos;
	}
	public void setAvisos(List<Aviso> avisos) {
		this.avisos = avisos;
	}
	public List<Status> getStatus() {
		return status;
	}
	public void setStatus(List<Status> status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getDia_atual() {
		return dia_atual;
	}
	public void setDia_atual(String dia_atual) {
		this.dia_atual = dia_atual;
	}
	public String getTrabalhado_hoje() {
		return trabalhado_hoje;
	}
	public void setTrabalhado_hoje(String trabalhado_hoje) {
		this.trabalhado_hoje = trabalhado_hoje;
	}
	public String getDescansado_hoje() {
		return descansado_hoje;
	}
	public void setDescansado_hoje(String descansado_hoje) {
		this.descansado_hoje = descansado_hoje;
	}
	public String getAlimentacao_hoje() {
		return alimentacao_hoje;
	}
	public void setAlimentacao_hoje(String alimentacao_hoje) {
		this.alimentacao_hoje = alimentacao_hoje;
	}
	public String getMetadados() {
		return metadados;
	}
	public void setMetadados(String metadados) {
		this.metadados = metadados;
	}
	// Métodos
	public boolean cadastrarMotorista(String cpf, String nome, String email, String senha, String salario, String cargaHoraria, int idFilial,
			String turno, boolean seg, boolean ter, boolean qua, boolean qui, boolean sex, boolean sab, boolean dom, String cargo) {

		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setSalario(salario);
		this.setCargaHoraria(cargaHoraria);
		this.setTurno(turno);
		this.setSeg(seg);
		this.setTer(ter);
		this.setQua(qua);
		this.setQui(qui);
		this.setSex(sex);
		this.setSab(sab);
		this.setDom(dom);
		this.setCargo(cargo);
		
		filial.setId(idFilial);
		this.setFilial(filial);
		
		this.setDia_atual("00");
		this.setAlimentacao_hoje("0");
		this.setDescansado_hoje("0");
		this.setTrabalhado_hoje("0");
		
		EntityManager con = new ConnectionFactory().getConnection();
		
		try {
			con.getTransaction().begin();
			con.persist(this);
			con.getTransaction().commit();
		}
		catch(Exception e) {
			con.getTransaction().rollback();
			con.close();
			return false;
		}
		finally {
			con.close();
		}
		
		return true;
	}
	
	public void alterarSenhaMot(String senha){
		this.setSenha(senha);
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

	public void alterarDadosMotorista(String cpf, String nome, String email, String senha, String salario, String cargaHoraria, int idFilial,
			String turno, boolean seg, boolean ter, boolean qua, boolean qui, boolean sex, boolean sab, boolean dom) {
		
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setSalario(salario);
		this.setCargaHoraria(cargaHoraria);

		filial.setId(idFilial);
		this.setFilial(filial);
		
		this.setTurno(turno);
		this.setSeg(seg);
		this.setTer(ter);
		this.setQua(qua);
		this.setQui(qui);
		this.setSex(sex);
		this.setSab(sab);
		this.setDom(dom);
		
		
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
	public Motorista excluirMotorista(String cpf) {
		EntityManager con = new ConnectionFactory().getConnection();

		Motorista motorista = null;

		try {
			motorista = con.find(model.Motorista.class, cpf);		

			con.getTransaction().begin();
			con.remove(motorista);
			con.getTransaction().commit();
		}
		catch (Exception e) {
			con.getTransaction().rollback();
			return null;
		}
		finally {
			con.close();
		}

		return motorista;
	}
	
	public List<Funcionarios> listarMotoristas() {
		List<Funcionarios> lista = new ArrayList<>();
		for (Motorista m: this.consultarTodosMotoristas()) {
			Funcionarios nome = new Funcionarios(m.cpf, m.nome, m.cargo, m.email);
			lista.add(nome);
		}
		return lista;
	}
	public List<Motorista> consultarTodosMotoristas() {
		EntityManager con = new ConnectionFactory().getConnection();
		List<Motorista> motorista = null;

		try {
			motorista = con.createQuery("from Motorista m").getResultList();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			con.close();
		}

		return motorista;
	}
	
	public Motorista encontrarMotorista(String cpf) {
		EntityManager con = new ConnectionFactory().getConnection();

		Motorista motorista  = null;

		try {
			motorista = con.find(model.Motorista.class, cpf);
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return motorista;
	}
	
	public String verificarLogin(String email){
		
		EntityManager con = new ConnectionFactory().getConnection();
		
		List<Funcionarios> list = new ArrayList<>();
		
		String cpf = "";
		
		try {
			// Precisa da query personalizada aqui para retornar o cpf correspondente ao email e depois chamar a função de encontrar funcionário
			Query query = con.createNativeQuery("select cpf from motoristas where email = :email");
			query.setParameter("email", email);

			list = query.getResultList();

			cpf = list.toString();
			
			if(cpf.length() > 3) {
				cpf = cpf.substring(1, 15);
			}else {
				cpf = "Não encontrado";
			}
		}
		catch (Exception e) {
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}

		return cpf;
	}
	
	public void atualizarTempos(String expHoje, String alimHoje, String descHoje) {
		EntityManager con = new ConnectionFactory().getConnection();
		
		this.trabalhado_hoje = expHoje;
		this.alimentacao_hoje = alimHoje;
		this.descansado_hoje = descHoje;
		
		try {
			con.getTransaction().begin();
			
			
			Query query = con.createQuery("update Motorista set trabalhado_hoje = :expHoje, alimentacao_hoje = :alimHoje, descansado_hoje = :descHoje where cpf = :cpf");
			query.setParameter("expHoje", expHoje);
			query.setParameter("alimHoje", alimHoje);
			query.setParameter("descHoje", descHoje);
			query.setParameter("cpf", this.cpf);
			query.executeUpdate();
			
			con.getTransaction().commit();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados do motorista: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
			System.err.println(e);
			con.getTransaction().rollback();
		}
		finally {
			con.close();
		}
	}
	
	public void resetarDiaDeTrabalho() {
		String diaDeHoje = String.valueOf(LocalDate.now().getDayOfMonth());
		
		if(!this.getDia_atual().equals(diaDeHoje)) {
			EntityManager con = new ConnectionFactory().getConnection();
			
			this.trabalhado_hoje = "0";
			this.alimentacao_hoje = "0";
			this.descansado_hoje = "0";
			this.dia_atual = diaDeHoje;

			try {
				con.getTransaction().begin();


				Query query = con.createQuery("update Motorista set trabalhado_hoje = :expHoje, alimentacao_hoje = :alimHoje, descansado_hoje = :descHoje, dia_atual = :diaHoje where cpf = :cpf");
				query.setParameter("expHoje", "0");
				query.setParameter("alimHoje", "0");
				query.setParameter("descHoje", "0");
				query.setParameter("diaHoje", diaDeHoje);
				query.setParameter("cpf", this.cpf);
				query.executeUpdate();

				con.getTransaction().commit();
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados do motorista: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);
				System.err.println(e);
				con.getTransaction().rollback();
			}
			finally {
				con.close();
			}
		}
		

	}
	
	public Map<String, String> dadosMotorista(){
		Map<String, String> dicionarioDeDados = new HashMap<String, String>();
		
		
		String diasDeTrabalho = "";

		if(this.getDom()) {
			diasDeTrabalho += "Domingo";
		}
		if(this.getSeg()) {
			diasDeTrabalho += ", Segunda-Feira";
		}
		if(this.getTer()) {
			diasDeTrabalho += ", Terça-Feira";
		}
		if(this.getQua()) {
			diasDeTrabalho += ", Quarta-Feira";
		}
		if(this.getQui()) {
			diasDeTrabalho += ", Quinta-Feira";
		}
		if(this.getSex()) {
			diasDeTrabalho += ", Sexta-Feira";
		}
		if(getSab()) {
			diasDeTrabalho += " e Sábado";
		}
		if(!this.getDom()) {
			diasDeTrabalho = diasDeTrabalho.substring(2); // Tira ", " caso não trabalhe domingo
		}
		
		
		dicionarioDeDados.put("Nome", this.getNome());
		dicionarioDeDados.put("E-mail", this.getEmail());
		dicionarioDeDados.put("CPF", this.getCpf());
		dicionarioDeDados.put("Filial", this.getFilial().getNome());
		dicionarioDeDados.put("Salario", this.getSalario());
		dicionarioDeDados.put("Carga Horaria", this.getCargaHoraria());
		dicionarioDeDados.put("Dias de trabalho", diasDeTrabalho);

		
		return dicionarioDeDados;
	}
	
	
	
	/**
	 * Os metadados que devem ser passados como parâmetro são (em string)
	 * VgmAtt
	 * VgmFin
	 * VgmAtr
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
			reconstruir = reconstruir + metadados[i] + " ";
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
	
	public String[][] obterDicionarioMetadados() {
		String[][] dic = {{"VgmAtt", "Viagens atribuídas"},
				          {"VgmFin", "Viagens finalizadas"},
				          {"VgmAtr", "Viagens atrasadas"}};

		return dic;
	}

	
}
