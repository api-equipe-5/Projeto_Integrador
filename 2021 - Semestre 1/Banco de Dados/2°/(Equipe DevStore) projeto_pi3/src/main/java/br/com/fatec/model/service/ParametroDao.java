package br.com.fatec.model.service;

import java.util.List;

import br.com.fatec.model.Parametro;


public interface ParametroDao {
	
	public Boolean save(Parametro parametro);
	
	public Boolean update(Parametro parametro);
	
	public Boolean delete(Parametro parametro);
	
	public List<Parametro> listAll();
	
	public Parametro findByExtesao(String extensao);

}
