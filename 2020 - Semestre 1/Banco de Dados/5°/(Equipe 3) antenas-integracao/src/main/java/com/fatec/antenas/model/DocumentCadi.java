package com.fatec.antenas.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cadi")
public class DocumentCadi extends Usuario{

	public DocumentCadi(String _id, String nome, String email, String senha) {
		super(_id, nome, email, senha, false, true);
		// TODO Auto-generated constructor stub
	}

}
