package br.com.fatec.model.service;

import java.util.List;

import br.com.fatec.model.Integracao;

public interface IntegracaoDao {
	
	public Boolean save(Integracao integracao);
	
	public Boolean update(Integracao integracao);
	
	public Boolean delete(Integracao integracao);
	
	public List<Integracao> listAll();
	
	public Integracao findById(Long id);

}
