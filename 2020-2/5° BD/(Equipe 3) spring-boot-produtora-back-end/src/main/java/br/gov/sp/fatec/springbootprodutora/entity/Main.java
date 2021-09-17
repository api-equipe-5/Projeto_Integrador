package br.gov.sp.fatec.springbootprodutora.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootprodutora.controller.View;

/*(import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

@MappedSuperclass
public class Main {
        //private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    
    @JsonView({View.Filme.class, View.Novela.class,View.PessoaCompleta.class})
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}