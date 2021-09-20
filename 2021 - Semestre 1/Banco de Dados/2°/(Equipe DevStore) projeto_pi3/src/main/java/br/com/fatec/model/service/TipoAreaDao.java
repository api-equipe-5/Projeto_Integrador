package br.com.fatec.model.service;

import java.util.List;

import br.com.fatec.model.Estado;
import br.com.fatec.model.TipoArea;

public interface TipoAreaDao {
	
	public Boolean save(TipoArea tipoArea);
	
	public Boolean update(TipoArea tipoArea);
	
	public Boolean delete(TipoArea tipoArea);
	
	public List<TipoArea> listAll();
	
	public TipoArea findByTipoDescricao(String tipoDescricao);

}
