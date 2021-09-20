package br.com.fatec.model.service;

import java.util.List;

import br.com.fatec.model.Municipio;

public interface MunicipioDao {
	
public Boolean save(Municipio municipio);
	
	public Boolean update(Municipio municipio);
	
	public Boolean delete(Municipio municipio);
	
	public List<Municipio> listAll();
	
	public Municipio findByCodigoMunicipio(String codigoMunicipio);

}
