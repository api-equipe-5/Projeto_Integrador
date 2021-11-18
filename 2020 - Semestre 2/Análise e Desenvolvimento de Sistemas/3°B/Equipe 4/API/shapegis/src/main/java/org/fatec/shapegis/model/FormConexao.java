package org.fatec.shapegis.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FormConexao {
@Id
	public String host;
	public String porta;
	public String bd;
	public String usuario;
	public String senha;
}
