package com.ExampleValcode.valcode;

import com.ExampleValcode.valcode.model.entity.PessoaFisica;
import com.ExampleValcode.valcode.model.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigInteger;
import java.util.Arrays;

@SpringBootApplication
public class ValcodeApplication {
	@Autowired
	private static PessoaFisicaRepository pessoaFisicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ValcodeApplication.class, args);
	}



}
