package br.gov.sp.fatec.springbootprodutora.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/*import com.fasterxml.jackson.annotation.JsonIgnore;*/
import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootprodutora.controller.View;

@Entity
@DiscriminatorValue(value = "T")
public class Diretor extends Pessoa{
    /*@JsonIgnore*/
    @JsonView(View.Diretor.class)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "diretor", cascade = CascadeType.REMOVE)
	private Set<Filmagem> filmagensDirigidas;

	public Set<Filmagem> getFilmagensDirigidas() {
		return filmagensDirigidas;
	}

	public void setFilmagensDirigidas(Set<Filmagem> filmagensDirigidas) {
		this.filmagensDirigidas = filmagensDirigidas;
	}
}