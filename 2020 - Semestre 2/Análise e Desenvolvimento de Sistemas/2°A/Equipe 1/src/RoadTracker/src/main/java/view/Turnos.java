package view;

import java.util.ArrayList;
import java.util.List;

public class Turnos {
	
	private int id;
	private String turno;
	public Turnos(int id, String turno) {
		this.id = id;
		this.turno = turno;	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	//Método para tratar o conteúdo mostrado na ComboBox
	@Override
	public String toString() {
		return getTurno();
	}

	public List<Turnos> listarTurnos(){
		
		List<Turnos> turnos = new ArrayList<>();
		
		Turnos turno1 = new Turnos(1, "Matutino");
		turnos.add(turno1);
		Turnos turno2 = new Turnos(2, "Vespertino");
		turnos.add(turno2);
		Turnos turno3 = new Turnos(3, "Noturno");
		turnos.add(turno3);
		
		return turnos;
	}
	
}
