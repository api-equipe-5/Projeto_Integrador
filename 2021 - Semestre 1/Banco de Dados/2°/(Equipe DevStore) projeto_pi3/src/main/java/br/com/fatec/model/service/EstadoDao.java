package br.com.fatec.model.service;

import java.util.List;

import br.com.fatec.model.Estado;

public interface EstadoDao {
	
	public Boolean save(Estado estado);
	
	public Boolean update(Estado estado);
	
	public Boolean delete(Estado estado);
	
	public List<Estado> listAll();
	
	public Estado findByCodigoEstado(String codigoEstado);

}
